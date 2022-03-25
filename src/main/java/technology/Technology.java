package technology;

import java.util.ArrayList;

public abstract class Technology {
    private boolean researched;
    private ArrayList <Technology> requirements;
    private String description;

    public boolean isResearched() {
        return researched;
    }

    public void setResearched(boolean researched) {
        this.researched = researched;
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
}
