package machine.component;

import fr.imt.cours.machine.component.BeanTank;
import fr.imt.cours.storage.cupboard.coffee.type.CoffeeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BeanTankTest {

    /**
     * Test permettant de vérifier le comportement du réservoir de grains lors du remplissage.
     */
    @Test
    void testIncreaseCoffeeVolumeWithJUnit() {
        double initialVolume = 1500;
        double minVolume = 200;
        double maxVolume = 2000;
        CoffeeType beanCoffeeType = CoffeeType.ARABICA;

        BeanTank beanTank = new BeanTank(initialVolume,minVolume,maxVolume,beanCoffeeType);

        double coffeeVolume = 200;
        CoffeeType coffeeType = CoffeeType.MOKA;

        beanTank.increaseCoffeeVolumeInTank(coffeeVolume,coffeeType);

        CoffeeType coffeeTypeExpected = CoffeeType.MOKA;
        CoffeeType coffeeTypeActual = beanTank.getBeanCoffeeType();

        Assertions.assertEquals(coffeeTypeExpected,coffeeTypeActual);


    }
}
