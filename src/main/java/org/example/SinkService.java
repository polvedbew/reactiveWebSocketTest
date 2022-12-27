package org.example;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 27/12/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/
@Service
public class SinkService {
    Sinks.Many<String> sink;

    public SinkService( Sinks.Many<String> sink){
        this.sink=sink;
    }

    public synchronized void emitToSink(String str){
        sink.emitNext(str, Sinks.EmitFailureHandler.FAIL_FAST);
    }

    public Sinks.Many<String> getSink(){
        return sink;
    }


}
