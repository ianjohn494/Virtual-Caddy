package com.project.virtualcaddymaven.controller.wedge;

import com.project.virtualcaddymaven.model.Wedge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WedgeRepository extends MongoRepository<Wedge, String> {
    //Finds the closest Wedge less than the distance
    List<Wedge> findByFullDistanceLessThanEqualOrderByFullDistanceDesc(int distance);

    //Finds the closest Wedge greater than the distance
    List<Wedge> findByFullDistanceGreaterThanEqualOrderByFullDistanceAsc(int distance);
}

