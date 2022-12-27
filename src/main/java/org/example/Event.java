package org.example;

/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 25/12/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/
public class Event {

    public String by_name;
    public String latitude;
    public String longitude;
    public String altitude;
    public String originId;
    public String gpsTime;
    public String speed;
    public String locationAccuracy;
    public String bearing;
    public boolean isLocationFine;

    public  int at_seconds_utc = 0;
    public  int at_minutes_utc = 0;
    public  int at_hours_utc = 0;
    public  int at_day_utc = 0;
    public  int at_month_utc = 0;
    public  int at_year_utc = 0;

}
