package com.chalmersmegagame.game.game_resources;

import java.util.ArrayList;
import java.util.Map;

public interface IHasResources {
    public ArrayList<String> getResources();

    public Map<String, Integer> getResourceQuantities();

    public void addResource(String resourceName, int quantity);

    public void removeResource(String resourceName, int quantity);
}
