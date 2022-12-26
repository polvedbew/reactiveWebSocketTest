package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.WebSocketMessage;
import reactor.core.publisher.*;

import java.util.List;

/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 25/12/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/
@Component
public class ReactiveWebSocketHandler implements WebSocketHandler {

    @Autowired
    private Sinks.Many<String> sink;

    @Override
    public Mono<Void> handle(WebSocketSession webSocketSession) {
       // sink.next("test 2");
        return webSocketSession.send(sink.asFlux()
                        .map(webSocketSession::textMessage))
                .and(webSocketSession.receive()
                        .map(WebSocketMessage::getPayloadAsText)
                        .log());
    }
}