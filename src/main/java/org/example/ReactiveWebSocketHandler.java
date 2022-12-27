package org.example;


import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.WebSocketMessage;
import reactor.core.publisher.*;


/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 25/12/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/
@Component
public class ReactiveWebSocketHandler implements WebSocketHandler {

    SinkService sinkService;
    public ReactiveWebSocketHandler(SinkService sinkService){
        this.sinkService=sinkService;
    }
    @Override
    public Mono<Void> handle(WebSocketSession webSocketSession) {
       // sink.next("test 2");
        return webSocketSession.send(sinkService.getSink().asFlux()
                        .map(webSocketSession::textMessage))
                .and(webSocketSession.receive()
                        .map(WebSocketMessage::getPayloadAsText)
                        .log());
    }
}