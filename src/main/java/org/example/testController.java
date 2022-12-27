package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 26/12/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/
@RestController
public class testController {
    private SinkService sinkService;

    @Autowired
    public ObjectMapper objectMapper;
    public testController(SinkService sinkService){
        this.sinkService=sinkService;
    }

    @RequestMapping(method= RequestMethod.POST,value="/panic/id")
    public ResponseEntity<Boolean> mapp(@RequestBody Event event) throws Exception {
        System.out.println("received panic event.........."+event.altitude+"  "+event.latitude+"  "+event.originId);
        try {
            String name="";
            if("BC:57:29:00:BA:A6".equals(event.originId)){
                name="Mani E R";
            }else if("BC:57:29:00:B8:F6".equals(event.originId)){
                name="Arun";
            }else if("BC:57:29:00:B8:D1".equals(event.originId)){
                name="Amol K R";
            }else if("BC:57:29:00:B8:C3".equals(event.originId)){
                name="Sarath Prem";
            }else{
                name=event.originId;
            }
            //LocationObject lo = new LocationObject(event.latitude, event.longitude);
            //ObjectMapper mapper = new ObjectMapper();
            //String json = mapper.writeValueAsString(lo);
            try {
                MapEvent me=new MapEvent("Received time: "//+event.at_year_utc+"/"+event.at_month_utc+"/"+event.at_day_utc+"-"+event.at_hours_utc+":"+event.at_minutes_utc+":"+event.at_seconds_utc
                      //  +"\nReceived from: "+event.by_name
                      //  +"\nSpeed: "+event.speed
                     //   +"\nDirection: "+event.bearing
                     //   +"\nGps time: "+event.gpsTime
                        , name
                        , Double.parseDouble(event.latitude)
                        ,Double.parseDouble(event.longitude));
                String json= objectMapper.writeValueAsString(me);

                try{
                    sinkService.emitToSink(json);
                }catch (Exception ee){
                    ee.printStackTrace();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
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
