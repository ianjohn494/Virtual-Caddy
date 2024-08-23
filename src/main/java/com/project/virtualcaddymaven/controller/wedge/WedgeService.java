package com.project.virtualcaddymaven.controller.wedge;


import com.project.virtualcaddymaven.model.Iron;
import com.project.virtualcaddymaven.model.Wedge;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WedgeService {
    @Autowired
    private WedgeRepository wedgeRepository;

    // Finds the closest wedge to the distance
    public Wedge findClosestWedge(int distance) {
        List<Wedge> wedgesLessThanOrEqual = wedgeRepository.findByFullDistanceLessThanEqualOrderByFullDistanceDesc(distance);
        List<Wedge> wedgesGreaterThanOrEqual = wedgeRepository.findByFullDistanceGreaterThanEqualOrderByFullDistanceAsc(distance);

        Wedge closestWedge = null;

        if (!wedgesLessThanOrEqual.isEmpty()) {
            closestWedge = wedgesLessThanOrEqual.get(0);
        }

        if (!wedgesGreaterThanOrEqual.isEmpty()) {
            Wedge closestGreaterWedge = wedgesGreaterThanOrEqual.get(0);
            if (closestWedge == null ||
                    Math.abs(closestGreaterWedge.getFullDistance() - distance) < Math.abs(closestWedge.getFullDistance() - distance)) {
                closestWedge = closestGreaterWedge;
            }
        }

        return closestWedge;
    }

    public Wedge saveWedge(Wedge wedge) {
        return wedgeRepository.save(wedge);
    }

    public List<Wedge> getAllWedges() {
        return wedgeRepository.findAll();
    }

    public boolean deleteWedgeById(ObjectId id) {
        if (wedgeRepository.existsById(id.toString())) {
            wedgeRepository.deleteById(id.toString());
            return true;
        }
        return false;
    }
}

