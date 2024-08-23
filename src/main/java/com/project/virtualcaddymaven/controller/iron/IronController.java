package com.project.virtualcaddymaven.controller.iron;

import com.project.virtualcaddymaven.model.Iron;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/irons")
public class IronController {

    @Autowired
    private final IronService ironService;

    @Autowired
    public IronController(IronService ironService) {
        this.ironService = ironService;
    }

    @GetMapping("/closest")
    public ResponseEntity<Iron> getClosestIron(@RequestParam int distance) {
        Iron closestIron = ironService.findClosestIron(distance);
        return ResponseEntity.ok(closestIron);
    }

    @PostMapping
    public ResponseEntity<Iron> addIron(@RequestBody Iron iron) {
        Iron savedIron = ironService.saveIron(iron);
        return ResponseEntity.ok(savedIron);
    }

    @GetMapping
    public List<Iron> getAllIrons() {
        return ironService.getAllIrons();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIron(@PathVariable String id) {
        ObjectId objectId = new ObjectId(id);
        boolean isRemoved = ironService.deleteIronById(objectId);
        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
