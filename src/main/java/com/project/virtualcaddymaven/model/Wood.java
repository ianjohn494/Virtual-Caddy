package com.project.virtualcaddymaven.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Woods")
public class Wood extends Club{

    private int clubNum;

    public Wood(int clubNum, String brand, String model, int fullDistance, String id, String type) {
        super(fullDistance, brand, model, id, type);
        this.clubNum = clubNum;
    }

    public Wood() {
        super();
    }

    // Setters
    public void setClubNum(int clubNum) {
        this.clubNum = clubNum;
    }

    // Getters
    public int getClubNum() {
        return clubNum;
    }
}
