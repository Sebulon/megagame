package technology;

import java.util.ArrayList;

public class TechTree {
    private ArrayList<Technology> technologies;
    private ArrayList<Technology> researched;
    private ArrayList<Technology> available;

    public TechTree(){
        technologies = new ArrayList<>();
        researched = new ArrayList<>();
        available = new ArrayList<>();
    }

    public TechTree(ArrayList<Technology> technologies){
        this.technologies = technologies;
        researched = new ArrayList<>();
        available = new ArrayList<>();
    }

    public void update (){
        for (Technology technology : technologies){
            if (technology.isResearchable()){
                if (!available.contains(technology)) {
                    available.add(technology);
                }
            }

            if (technology.isResearched()){
                if (!researched.contains(technology)){
                    researched.add(technology);
                }
            }

            if (available.contains(technology)){
                if (technology.isResearched()){
                    available.remove(technology);
                }
            }

            if (researched.contains(technology)){
                if(technology.isResearchable()){
                    researched.remove(technology);
                }
            }

        }
    }
}
