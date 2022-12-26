package org.example;

/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 26/12/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/
public class LocationObject {
        double lat;
        double lon;

        public LocationObject(String lat,String lon) throws Exception{

            this.lat=Double.parseDouble(lat);
            this.lon=Double.parseDouble(lon);
        }

}
