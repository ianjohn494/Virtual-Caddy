package com.project.virtualcaddymaven.controller.wood;


import com.project.virtualcaddymaven.model.Wedge;
import com.project.virtualcaddymaven.model.Wood;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/woods")
public class WoodController {

    @Autowired
    private final WoodService woodService;

    @Autowired
    public WoodController(WoodService woodService) {
        this.woodService = woodService;
    }

    @GetMapping("/closest")
    public ResponseEntity<Wood> getClosestWood(@RequestParam int distance) {
        Wood closestWood = woodService.findClosestWood(distance);
        return ResponseEntity.ok(closestWood);
    }

    @PostMapping
    public ResponseEntity<Wood> addWood(@RequestBody Wood wood) {
        Wood savedWood = woodService.saveWood(wood);
        return ResponseEntity.ok(savedWood);
    }

    @GetMapping
    public List<Wood> getAllWoods() {
        return woodService.getAllWoods();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWood(@PathVariable String id) {
        ObjectId objectId = new ObjectId(id);
        boolean isRemoved = woodService.deleteWoodById(objectId);
        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

