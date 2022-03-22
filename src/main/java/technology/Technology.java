package technology;

import java.util.ArrayList;

public abstract class Technology {
    private boolean researched;
    private ArrayList <Technology> required, requiredFor;
    private String description;

    public boolean isResearched() {
        return researched;
    }

    public void setResearched(boolean researched) {
        this.researched = researched;
    }

    public ArrayList<Technology> getRequired() {
        return required;
    }

    public ArrayList<Technology> getRequiredFor() {
        return requiredFor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
