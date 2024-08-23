package com.project.virtualcaddymaven.controller.club;

import com.project.virtualcaddymaven.model.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clubs")
public class ClubController {
    @Autowired
    private ClubService golfClubService;

    @GetMapping("/closest")
    public ResponseEntity<Club> getClosestClub(@RequestParam int distance) {
        Club closestClub = golfClubService.findClosestClub(distance);
        return ResponseEntity.ok(closestClub);
    }

}
