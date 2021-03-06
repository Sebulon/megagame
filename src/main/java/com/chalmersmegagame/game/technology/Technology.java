package com.chalmersmegagame.game.technology;

import java.util.ArrayList;

public abstract class Technology {
    private boolean researched, researchable;
    private ArrayList <Technology> requirements = new ArrayList<>();
    private ArrayList <otherRequirement> otherRequirements = new ArrayList<>();
    private String description;

    public void update (){
        if (researched == true){
            researchable = false;
        }

        if ((requirements.isEmpty() && otherRequirements.isEmpty()) && researched == false){
            researchable = true;
        }

        for (Technology tech: requirements){
            tech.update();

            if (tech.isResearched() == true){
                requirements.remove(tech);
            }
        }
        for (otherRequirement req : otherRequirements){
            if (req.isAchieved() == true){
                otherRequirements.remove(req);
            }
        }
    }

    public boolean isResearched() {
        return researched;
    }

    public void setResearched(boolean researched) {
        this.researched = researched;
    }

    public boolean isResearchable() {
        return researchable;
    }

    public void setResearchable(boolean researchable) {
        this.researchable = researchable;
    }

    public ArrayList<Technology> getRequirements() {
        return requirements;
    }

    public void addRequirement(Technology requirement) {
        this.requirements.add(requirement);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void activate(){

    }
}
