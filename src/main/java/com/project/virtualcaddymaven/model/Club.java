package com.project.virtualcaddymaven.model;

import org.springframework.data.annotation.Id;

public abstract class Club {

    @Id
    private String id;
    private int fullDistance;
    private String brand;
    private String model;
    private String type;

    public Club() {}

    public Club(int fullDistance, String brand, String model, String id, String type) {
        this.fullDistance = fullDistance;
        this.brand = brand;
        this.model = model;
        this.id = id;
        this.type = type;
    }

    // Setters
    public void setFullDistance(int fullDistance) {
        this.fullDistance = fullDistance;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public int getFullDistance() {
        return fullDistance;
    }

}
