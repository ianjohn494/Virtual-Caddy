package com.project.virtualcaddymaven.controller.iron;

import com.project.virtualcaddymaven.model.Iron;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IronRepository extends MongoRepository<Iron, String> {
    //Finds the closest Iron less than the distance
    List<Iron> findByFullDistanceLessThanEqualOrderByFullDistanceDesc(int distance);

    //Finds the closest Iron greater than the distance
    List<Iron> findByFullDistanceGreaterThanEqualOrderByFullDistanceAsc(int distance);
}
