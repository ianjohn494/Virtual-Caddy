package com.project.virtualcaddymaven.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Wedges")
public class Wedge extends Club{

    private int bounce;
    private int loft;
    private String grind;
    private int knockDownDistance;

    public Wedge(int bounce, int loft, String grind, String brand, String model, int fullDistance, int knockDownDistance, String id, String type) {
        super(fullDistance, brand, model, id, type);
        this.bounce = bounce;
        this.loft = loft;
        this.grind = grind;
        this.knockDownDistance = knockDownDistance;
    }

    public Wedge() {
        super();
    }

    // Setters
    public void setBounce(int bounce) {
        this.bounce = bounce;
    }

    public void setLoft(int loft) {
        this.loft = loft;
    }

    public void setGrind(String grind) {
        this.grind = grind;
    }

    public void setknockDownDistance(int knockDownDistance) {
        this.knockDownDistance = knockDownDistance;
    }

    // Getters
    public int getBounce() {
        return bounce;
    }

    public int getLoft() {
        return loft;
    }

    public String getGrind() {
        return grind;
    }

    public int getKnockDownDistance() {
        return knockDownDistance;
    }

}
