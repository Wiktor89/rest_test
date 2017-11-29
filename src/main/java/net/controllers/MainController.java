package net.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.jms.JMSReceiver;
import net.jms.JMSSender;
import net.models.Channel;
import net.service.ServiceCity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RequestMapping("/main")
@RestController
public class MainController {

    private static final Logger LOGGER = Logger.getLogger(MainController.class);

    private RestTemplate restTemplate;

    @Autowired
    @Qualifier(value = "serviceCity")
    private ServiceCity serviceCity;

    @Autowired
    @Qualifier(value = "sender")
    private JMSSender sender;

    @Autowired
    @Qualifier(value = "receiver")
    private JMSReceiver receiver;

    public void setReceiver(JMSReceiver receiver) {
        this.receiver = receiver;
    }

    public void setSender(JMSSender sender) {
        this.sender = sender;
    }

    @RequestMapping(value = "/nameCity", method = RequestMethod.POST)
    public void getMovie(@RequestParam String name) throws IOException {
        restTemplate = new RestTemplate();
        String url = "https://query.yahooapis.com/v1/public/yql?q=select * from weather.forecast where " +
                "woeid in (select woeid from geo.places(1) where text=\"" + name + "\")&format=json";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = restTemplate.getForObject(url, JsonNode.class).get("query").get("results").get("channel");
        Channel channel = mapper.readValue(jsonNode.traverse(), Channel.class);
        LOGGER.info("Channel {}" + channel);
        LOGGER.debug("Channel {}" + channel);
        sender.sendMessage(channel);
    }

    @RequestMapping(value = "/getQueue", method = RequestMethod.GET)
    private Channel sendMessage() {
        LOGGER.info("Start sendMessage ");
        Channel channelQueue = receiver.getChannel();
        LOGGER.debug("From the queue " + channelQueue);
        serviceCity.addCity(channelQueue);
        Channel channelBase = serviceCity.getCity();
        LOGGER.debug("From the base " + channelBase);
        return channelBase;
    }
}