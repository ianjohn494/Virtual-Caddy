package com.project.virtualcaddymaven.controller.iron;


import com.project.virtualcaddymaven.model.Iron;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IronService {
    @Autowired
    private IronRepository ironRepository;

    public Iron findClosestIron(int distance) {
        List<Iron> ironsLessThanOrEqual = ironRepository.findByFullDistanceLessThanEqualOrderByFullDistanceDesc(distance);
        List<Iron> ironsGreaterThanOrEqual = ironRepository.findByFullDistanceGreaterThanEqualOrderByFullDistanceAsc(distance);

        Iron closestIron = null;

        if (!ironsLessThanOrEqual.isEmpty()) {
            closestIron = ironsLessThanOrEqual.get(0);
        }

        // Finds the closest iron to the distance
        if (!ironsGreaterThanOrEqual.isEmpty()) {
            Iron closestGreaterIron = ironsGreaterThanOrEqual.get(0);
            if (closestIron == null ||
                    Math.abs(closestGreaterIron.getFullDistance() - distance) < Math.abs(closestIron.getFullDistance() - distance)) {
                closestIron = closestGreaterIron;
            }
        }

        return closestIron;
    }

    public Iron saveIron(Iron iron) {
        return ironRepository.save(iron);
    }

    public List<Iron> getAllIrons() {
        return ironRepository.findAll();
    }

    public boolean deleteIronById(ObjectId id) {
        if (ironRepository.existsById(id.toString())) {
            ironRepository.deleteById(id.toString());
            return true;
        }
        return false;
    }
}
