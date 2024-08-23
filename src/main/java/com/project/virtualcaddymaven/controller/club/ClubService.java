package com.project.virtualcaddymaven.controller.club;

import com.project.virtualcaddymaven.controller.iron.IronService;
import com.project.virtualcaddymaven.controller.wedge.WedgeService;
import com.project.virtualcaddymaven.controller.wood.WoodService;
import com.project.virtualcaddymaven.model.Club;
import com.project.virtualcaddymaven.model.Iron;
import com.project.virtualcaddymaven.model.Wedge;


import com.project.virtualcaddymaven.model.Wood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubService {

    @Autowired
    private IronService ironService;

    @Autowired
    private WedgeService wedgeService;

    @Autowired
    private WoodService woodService;


    // Gets the closest iron, wedge, and wood from the services and decides which of them is closest
    public Club findClosestClub(int distance) {
        Iron closestIron = ironService.findClosestIron(distance);
        Wedge closestWedge = wedgeService.findClosestWedge(distance);
        Wood closestWood = woodService.findClosestWood(distance);

        Club closestClub = null;
        
        int closestDifference = Integer.MAX_VALUE;

        if (closestIron != null) {
            int ironDifference = Math.abs(closestIron.getFullDistance() - distance);
            if (ironDifference < closestDifference) {
                closestDifference = ironDifference;
                closestClub = closestIron;
            }
        }

        if (closestWedge != null) {
            int wedgeDifference = Math.abs(closestWedge.getFullDistance() - distance);
            if (wedgeDifference < closestDifference) {
                closestDifference = wedgeDifference;
                closestClub = closestWedge;
            }
        }

        if (closestWood != null) {
            int woodDifference = Math.abs(closestWood.getFullDistance() - distance);
            if (woodDifference < closestDifference) {
                closestDifference = woodDifference;
                closestClub = closestWood;
            }
        }

        return closestClub;

    }
}
