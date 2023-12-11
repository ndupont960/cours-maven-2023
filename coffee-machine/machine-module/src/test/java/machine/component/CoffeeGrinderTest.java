package machine.component;

import fr.imt.cours.machine.component.CoffeeGrinder;
import org.junit.jupiter.api.Test;

public class CoffeeGrinderTest {


    @Test
    void testGrindCoffee() throws InterruptedException {

        int grindingTime = 10000;

        CoffeeGrinder coffeeGrinder = new CoffeeGrinder(grindingTime);
    }
}
