package com.project.virtualcaddymaven.controller.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {


    private LocationService locationService = new LocationService();


    @PostMapping("/location")
    public String updateLocation(@RequestBody Coordinate coordinates) {
        //double latitude = coordinates.getLatitude();
        //double longitude = Math.abs(coordinates.getLongitude());

        double midLat = 39.85798;
        double midLon = 83.04226;

        double yardsToPin = locationService.getYards(midLat, coordinates.getLatitude(), midLon, Math.abs(coordinates.getLongitude()));


        System.out.println("yards: " + yardsToPin);


        return "coordinate success";
    }

}
