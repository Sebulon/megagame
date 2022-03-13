package space;

import static org.junit.jupiter.api.Assertions.*;

class PlanetoidTest {

    public Planetoid planetoid1 = new Planetoid(10, "Gas Giant");

    public Planetoid testSatellite1 = new Planetoid(5, "Moon");

    public Planetoid planetoid2 = new Planetoid(15, "Ice Giant", testSatellite1);

    public void constructorTest(){
        assert planetoid1.getSize() == 0 && planetoid1.getSize() == 10 && planetoid1.getType().equals("Gas Giant");

    }

}