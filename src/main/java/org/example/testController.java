package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;
import reactor.core.publisher.Sinks;

/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 26/12/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/
@RestController
public class testController {
    @Autowired
    private Sinks.Many<String> sink;

    @RequestMapping(method= RequestMethod.POST,value="/panic/id")
    public ResponseEntity<Boolean> mapp(@RequestBody Event event) throws Exception {
        System.out.println("received panic event.........."+event.altitude+"  "+event.latitude+"  "+event.originId);
            try {
                //LocationObject lo = new LocationObject(event.latitude, event.longitude);
                //ObjectMapper mapper = new ObjectMapper();
                //String json = mapper.writeValueAsString(lo);
                String json="{ \"title\":\""+ event.originId+"\" , \"position\":{ \"lat\": "+Double.parseDouble(event.latitude)+", \"lng\": "+Double.parseDouble(event.longitude)+" }}";
               // json="\"{ lat: -25.363, lng: 131.044 }\"";
                sink.emitNext(json, Sinks.EmitFailureHandler.FAIL_FAST);
            }catch (Exception e){
                e.printStackTrace();
            }
        return ResponseEntity.ok(true);
    }

    @RequestMapping(method= RequestMethod.GET,value="/track")
    public ResponseEntity<String> track() throws Exception {

        return ResponseEntity.ok(Consts.HTML_CLIENT);
    }

}