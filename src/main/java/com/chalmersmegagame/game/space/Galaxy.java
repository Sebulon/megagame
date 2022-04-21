package com.chalmersmegagame.game.space;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Galaxy {
    @Id
    private String name;
    @OneToMany
    private Set<SolarSystem> solarSystems;

    public Galaxy(Set<SolarSystem> solarSystems){
        this.solarSystems = solarSystems;
    }

    public Galaxy() {

    }

    public void pairSolarSystems(SolarSystem solarSystem1, SolarSystem solarSystem2){
        solarSystem1.addConnection(solarSystem2);
    }
}
