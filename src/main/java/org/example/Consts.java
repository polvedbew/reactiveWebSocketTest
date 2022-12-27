package org.example;

/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 26/12/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/
public class Consts {

    public static final  String HTML_CLIENT= " <!DOCTYPE html>\n" +
            "<html>\n" +
            "\t<body>\n" +
            "\n" +
            "\t\t<h1>SecTrack</h1>\n" +
            "\n" +
            "\t\t<div id=\"googleMap\" style=\"width:100%;height:400px;\"></div>\n" +
            "\n" +
            "\t\t<script>\n" +
            "\n" +
            "\t\t\tvar map;\n" +
            "\t\t\tfunction myMap() {\n" +
            "\t\t\t\tvar mapProp= {\n" +
            "\t\t\t\t  center:new google.maps.LatLng(51.508742,-0.120850),\n" +
            "\t\t\t\t  zoom:2,\n" +
            "\t\t\t\t};\n" +
            "\t\t\t\tmap = new google.maps.Map(document.getElementById(\"googleMap\"),mapProp);\n" +
            "\t\t\t}\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t\t   var markerMapData= new Map();\n" +
            "\t\t   \n" +
            "\n" +
            "\t\t   function addMarker(lat,lng,title) {\n" +
            "\t\t\tevents(\"add marker data:\"+lat+\"  ---  \"+lng+\"    \"+title);\n" +
            "\t\t\tvar idSpec=\"lt\"+lat+\"ln\"+lng+\"tt\"+title\n" +
            "\n" +
            "\t\t\tif(markerMapData.has(idSpec)){\n" +
            "\t\t\t\tmarkerMapData.get(idSpec).setPosition(new google.maps.LatLng(lat,lng));\n" +
            "\t\t\t\t\n" +
            "\t\t\t}else{\n" +
            "\t\t\t\tmarkerMapData.set(idSpec,new google.maps.Marker({\n" +
            "\t\t\t\t\t    position: new google.maps.LatLng(lat,lng),\n" +
            "\t\t\t\t\t    map: map,\n" +
            "\t\t\t\t\t    title: title,\n" +
            "\t\t\t\t\t    label: {\n" +
            "\t\t\t\t\t\t\t    text: title,\n" +
            "\t\t\t\t\t\t\t    color: \"#1010ff\",\n" +
            "\t\t\t\t\t\t\t    fontWeight: \"bold\",\n" +
            "\t\t\t\t\t\t\t    fontSize: \"16px\",\n" +
            "\t\t\t\t\t\t\t    className: \"map-label\"\n" +
            "\t\t\t\t\t\t      }\n" +
            "\t\t\t\t\t}));\n" +
            "\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\n" +
            "\n" +
            "\t\t    }\n" +
            "\n" +
            "\t\t\t\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t\t    var clientWebSocket = new WebSocket(\"ws://103.214.234.248:54321/event-emitter\");\n" +
            "\n" +
            "\t\t    clientWebSocket.onopen = function() {\n" +
            "\t\t\tconsole.log(\"clientWebSocket.onopen\", clientWebSocket);\n" +
            "\t\t\tconsole.log(\"clientWebSocket.readyState\", \"websocketstatus\");\n" +
            "\t\t\tclientWebSocket.send(\"event-me-from-browser\");\n" +
            "\t\t    }\n" +
            "\n" +
            "\t\t    clientWebSocket.onclose = function(error) {\n" +
            "\t\t\tconsole.log(\"clientWebSocket.onclose\", clientWebSocket, error);\n" +
            "\t\t\tevents(\"Closing connection\");\n" +
            "\t\t    }\n" +
            "\n" +
            "\t\t    clientWebSocket.onerror = function(error) {\n" +
            "\t\t\tconsole.log(\"clientWebSocket.onerror\", clientWebSocket, error);\n" +
            "\t\t\tevents(\"An error occured\");\n" +
            "\t\t    }\n" +
            "\n" +
            "\t\t    clientWebSocket.onmessage = function(loc) {\n" +
            "\t\t\t\tvar obj=JSON.parse(loc.data);\n" +
            "\t\t\t\t//const myLatLng = loc.data;// { lat: parseFloat( loc.data.lat ), lng: parseFloat( loc.data.lng ) };\n" +
            "\t\t\t\t//var position = new google.maps.LatLng(loc.data.lat,loc.data.lng); \n" +
            "\t\t\t\t//var myLatLng = new google.maps.LatLng(parseFloat(loc.data.substring(1,6)),131.044922);\n" +
            "\n" +
            "\t\t\t\taddMarker(obj.position.lat,obj.position.lng,obj.title);\n" +
            "\n" +
            "\t\t\tconsole.log(\"clientWebSocket.onmessage\", clientWebSocket, loc);\n" +
            "\t\t\tevents(loc.data +\"  ------  \" +loc.data.position);\n" +
            "\t\t    }\n" +
            "\n" +
            "\n" +
            "\t\t    function events(responseEvent) {\n" +
            "\t\t\tdocument.querySelector(\".events\").innerHTML += responseEvent + \"<br>\";\n" +
            "\t\t    }\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t\t</script>\n" +
            "\n" +
            "\t\t<script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyBRmeUDbac2Kj0l5dTE3UCV4KjWibdD7CI&callback=myMap\"></script>\n" +
            "\n" +
            "\t</body>\n" +
            "\n" +
            "<div class=\"events\"></div>\n" +
            "\n" +
            "\n" +
            "</html>";


}
