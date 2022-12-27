package org.example;

import reactor.core.publisher.Sinks;

/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 27/12/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/
public class MapEvent {

    public Position position;
    public String info;
    public String title;

    public MapEvent(String info,String title,double lat,double lng){
        this.position=new Position(lat,lng);
        this.info=info;
        this.title=title;
    }

}

class Position{
    double lat;
    double lng;
    public Position(double lat,double lng){
        this.lat=lat;
        this.lng=lng;
    }

}