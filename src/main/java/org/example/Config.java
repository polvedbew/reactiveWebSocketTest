package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import reactor.core.publisher.Sinks;

import java.util.HashMap;
import java.util.Map;

/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 26/12/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/
@Configuration
public class Config {



    @Bean
    public Sinks.Many<String> sink(){
        return Sinks.many().multicast().directBestEffort();
    }



}
