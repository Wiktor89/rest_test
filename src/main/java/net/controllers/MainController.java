package net.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.models.Query;
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

import java.io.IOException;

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
        jsonNode = restTemplate.getForObject(url, JsonNode.class).get("query");
        Query query = null;
        try {
            query = mapper.readValue(jsonNode.traverse(), Query.class);
            System.out.println(query.getCount());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}