package com.project.virtualcaddymaven.controller.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/location")
    public ResponseEntity<Double> getYards(@RequestParam double lat,
                                               @RequestParam double lon) {
        double midLat = 39.85798;
        double midLon = 83.04226;

        return ResponseEntity.ok(locationService.getYards(midLat, lat, midLon, Math.abs(lon)));
    }

}
