package org.example;


/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 27/12/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/
public class MapEvent {

    public String info;
    public String title;
    public double lat;
    public double lng;

    public MapEvent(String info,String title,double lat,double lng){
        this.info=info;
        this.title=title;
        this.lat=lat;
        this.lng=lng;
    }

}


