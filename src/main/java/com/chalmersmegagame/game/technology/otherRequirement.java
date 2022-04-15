package com.chalmersmegagame.game.technology;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class otherRequirement {
    @Id
    private String name;
    private String description;
    private boolean achieved;

    public otherRequirement (String description, String name){
        this.description = description;
        this.name = name;
    }

    public otherRequirement() {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAchieved() {
        return achieved;
    }

    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }
}
