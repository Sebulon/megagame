package space;

import java.util.ArrayList;
import java.util.Set;

public class Galaxy {
    private Set<SolarSystem> solarSystems;

    public Galaxy(Set<SolarSystem> solarSystems){
        this.solarSystems = solarSystems;
    }

    public void pairSolarSystems(SolarSystem solarSystem1, SolarSystem solarSystem2){
        solarSystem1.addConnection(solarSystem2);
    }
}
