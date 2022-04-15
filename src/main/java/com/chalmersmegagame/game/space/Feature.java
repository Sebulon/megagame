package com.chalmersmegagame.game.space;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Feature {
    @Id
    private String name;
    private String description;

    public Feature (String description, String name){
        this.description = description;
        this.name = name;
    }

    public Feature() {}

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
}
