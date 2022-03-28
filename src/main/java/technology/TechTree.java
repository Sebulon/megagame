package technology;

import java.util.Set;

public class TechTree {
    private Set<Technology> technologies;
    private Set<Technology> researched;
    private Set<Technology> available;

    public TechTree(){

    }

    public TechTree(Set<Technology> technologies){
        this.technologies = technologies;
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
