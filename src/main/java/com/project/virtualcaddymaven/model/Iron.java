package com.project.virtualcaddymaven.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Irons")
public class Iron extends Club{
    
    private int clubNum;
    private int knockDownDistance;

    public Iron(int clubNum, String brand, String model, int fullDistance, int knockDownDistance, String id, String type) {
        super(fullDistance, brand, model, id, type);
        this.clubNum = clubNum;
        this.knockDownDistance = knockDownDistance;
    }

    public Iron() {
        super();
    }

    // Setters
    public void setClubNum(int clubNum) {
        this.clubNum = clubNum;
    }

    public void setKnockDownDistance(int knockDownDistance) {
        this.knockDownDistance = knockDownDistance;
    }

    // Getters
    public int getClubNum() {
        return clubNum;
    }

    public int getKnockDownDistance() {
        return knockDownDistance;
    }

}