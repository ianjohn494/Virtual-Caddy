package com.project.virtualcaddymaven.controller.wedge;

import com.project.virtualcaddymaven.model.Wedge;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wedges")
public class WedgeController {

    @Autowired
    private final WedgeService wedgeService;


    @Autowired
    public WedgeController(WedgeService wedgeService) {
        this.wedgeService = wedgeService;
    }

    @GetMapping("/closest")
    public ResponseEntity<Wedge> getClosestWedge(@RequestParam int distance) {
        Wedge closestWedge = wedgeService.findClosestWedge(distance);
        return ResponseEntity.ok(closestWedge);
    }

    @PostMapping
    public Wedge addWedge(@RequestBody Wedge wedge) {
        Wedge savedWedge = wedgeService.saveWedge(wedge);
        return wedgeService.saveWedge(wedge);
    }

    @GetMapping
    public List<Wedge> getAllWedges() {
        return wedgeService.getAllWedges();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWedge(@PathVariable String id) {
        ObjectId objectId = new ObjectId(id);
        boolean isRemoved = wedgeService.deleteWedgeById(objectId);
        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
