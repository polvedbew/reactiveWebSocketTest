package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.springframework.web.reactive.socket.WebSocketHandler;


/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on ${DAY}/${MONTH}/${YEAR}
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/

@SpringBootApplication
public class Main {
    private static SpringApplication app;
    @Autowired
    private WebSocketHandler webSocketHandler;
    public static void main(String[] args) throws InterruptedException {

        app= new SpringApplication(Main.class);
        Properties properties = new Properties();
        properties.put("server.port",54321);
        properties.put("spring.main.web-application-type","reactive");
        app.setDefaultProperties(properties);
        app.run(args);
    }



    @Bean
    public HandlerMapping webSocketHandlerMapping() {
        Map<String, WebSocketHandler> map = new HashMap<>();
        map.put("/event-emitter", webSocketHandler);

        SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
        handlerMapping.setOrder(1);
        handlerMapping.setUrlMap(map);
        return handlerMapping;
    }
}