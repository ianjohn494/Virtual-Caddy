package com.project.virtualcaddymaven.controller.wood;

import com.project.virtualcaddymaven.model.Wood;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WoodService {
    @Autowired
    private WoodRepository woodRepository;

    // Finds the closest wood to the distance
    public Wood findClosestWood(int distance) {
        List<Wood> woodsLessThanOrEqual = woodRepository.findByFullDistanceLessThanEqualOrderByFullDistanceDesc(distance);
        List<Wood> woodsGreaterThanOrEqual = woodRepository.findByFullDistanceGreaterThanEqualOrderByFullDistanceAsc(distance);

        Wood closestWood = null;

        if (!woodsLessThanOrEqual.isEmpty()) {
            closestWood = woodsLessThanOrEqual.getFirst();
        }

        if (!woodsGreaterThanOrEqual.isEmpty()) {
            Wood closestGreaterWood = woodsGreaterThanOrEqual.getFirst();
            if (closestWood == null ||
                    Math.abs(closestGreaterWood.getFullDistance() - distance) < Math.abs(closestWood.getFullDistance() - distance)) {
                closestWood = closestGreaterWood;
            }
        }

        return closestWood;
    }

    public Wood saveWood(Wood wood) {
        return woodRepository.save(wood);
    }

    public List<Wood> getAllWoods() {
        return woodRepository.findAll();
    }

    public boolean deleteWoodById(ObjectId id) {
        if (woodRepository.existsById(id.toString())) {
            woodRepository.deleteById(id.toString());
            return true;
        }
        return false;
    }
}
