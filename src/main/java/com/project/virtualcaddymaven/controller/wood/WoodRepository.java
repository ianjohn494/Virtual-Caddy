package com.project.virtualcaddymaven.controller.wood;

import com.project.virtualcaddymaven.model.Wood;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WoodRepository extends MongoRepository<Wood, String> {
    //Finds the closest Wood less than the distance
    List<Wood> findByFullDistanceLessThanEqualOrderByFullDistanceDesc(int distance);

    //Finds the closest Wood greater than the distance
    List<Wood> findByFullDistanceGreaterThanEqualOrderByFullDistanceAsc(int distance);
}
