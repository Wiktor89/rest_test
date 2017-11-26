package net.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.models.Channel;
import net.service.ServiceCity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Properties;

@RequestMapping("/main")
@RestController
public class MainController {

    private RestTemplate restTemplate;

    private static final Logger LOGGER = Logger.getLogger(MainController.class);

    private ServiceCity serviceCity;

    @Autowired
    @Qualifier(value = "serviceCity")
    public void setServiceCity(ServiceCity serviceCity) {
        this.serviceCity = serviceCity;
    }

    @RequestMapping(value = "/nameCity", method = RequestMethod.GET)
    public void getMovie(@RequestParam String name, ModelMap modelMap) {
        restTemplate = new RestTemplate();
        String url = "https://query.yahooapis.com/v1/public/yql?q=select * from weather.forecast where " +
                "woeid in (select woeid from geo.places(1) where text=\"" + name + "\")&format=json";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = null;
        RestTemplate restTemplate = new RestTemplate();
        jsonNode = restTemplate.getForObject(url, JsonNode.class).get("query").get("results").get("channel");
        Channel channel = null;
        try {
            channel = mapper.readValue(jsonNode.traverse(), Channel.class);
            go(channel);
            LOGGER.info("Channel " + channel);
            LOGGER.debug("Channel " + channel);
//            serviceCity.addCity(channel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    private static void sendMessage(ConnectionFactory connectionFactory, Destination destination) {
        Connection connection = null;
        Session session = null;
        MessageConsumer messageConsumer = null;

        try {
            connection = connectionFactory.createConnection("admin", "admin");
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            messageConsumer = session.createConsumer(destination);

            TextMessage text = session.createTextMessage();
            text.setText("Send some useful message");
            Message message = messageConsumer.receiveNoWait();
            String body = message.getBody(String.class);
            LOGGER.info("Body {} " + body);

        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException f) {
                    f.printStackTrace();
                }
            }
        }
    }

    public void go(Channel channel) {
        final Properties p = new Properties();
        p.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        p.put(Context.PROVIDER_URL, "//localhost:8080");
        p.put(Context.SECURITY_PRINCIPAL, "admin");
        p.put(Context.SECURITY_CREDENTIALS, "admin");
        Context namingContext = null;
        JMSContext context = null;
        JMSConsumer consumer = null;
        try {
            namingContext = new InitialContext(p);
            ConnectionFactory factory = (ConnectionFactory) namingContext.lookup
                    ("java:jboss/exported/jms/RemoteConnectionFactory");
            Destination destination = (Destination) namingContext.lookup(
                    "java:/testBroker");
            context = factory.createContext("admin", "admin");
            for (int i = 0; i < 2; i++) {
                context.createProducer().send(destination, channel);
                System.out.println("Сообщение отправленно " + i);
            }
            for (int i = 0; i < 1; i++) {
                consumer = context.createConsumer(destination);
//                Channel s = consumer.receiveBody(Channel.class);
                Channel channel1 = consumer.receiveBody(Channel.class);
                System.out.println("Сообщение из очереди " + channel1.getTitle());

            }

        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

}