package machine.component;

import fr.imt.cours.machine.component.BeanTank;
import fr.imt.cours.machine.exception.MaximumVolumeExceededException;
import fr.imt.cours.machine.exception.WrongCoffeeTypeInBeanTankException;
import fr.imt.cours.storage.cupboard.coffee.type.CoffeeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BeanTankTest {

    /**
     * Test permettant de vérifier que le type de café du réservoir de grain change lorsqu'on le reremplit.
     */
    @Test
    void testCoffeeTypeChangesWhenFillingEmptyBeanTank() throws WrongCoffeeTypeInBeanTankException, MaximumVolumeExceededException {
        double initialVolume = 0;
        double minVolume = 0;
        double maxVolume = 2;
        CoffeeType beanCoffeeType = CoffeeType.ARABICA;

        // generate empty bean tank :
        BeanTank beanTank = new BeanTank(initialVolume,minVolume,maxVolume,beanCoffeeType);

        double coffeeVolume = 0.2;
        CoffeeType coffeeType = CoffeeType.MOKA;

        beanTank.increaseCoffeeVolumeInTank(coffeeVolume,coffeeType);

        CoffeeType coffeeTypeExpected = CoffeeType.MOKA;
        CoffeeType coffeeTypeActual = beanTank.getBeanCoffeeType();

        Assertions.assertEquals(coffeeTypeExpected,coffeeTypeActual);
    }


    /**
     * Test permettant de vérifier si une erreur se produit lorsqu'on remplit le réservoir avec le mauvais type de grain,
     * et que l'erreur ne se produit pas avec le bon type de grain
     */
    @Test
    void testWrongCoffeeTypeException() {
        double initialVolume = 0.5;
        double minVolume = 0;
        double maxVolume = 2;
        CoffeeType beanCoffeeType = CoffeeType.ARABICA;

        // generate bean tank :
        BeanTank beanTank = new BeanTank(initialVolume,minVolume,maxVolume,beanCoffeeType);

        Assertions.assertThrows(WrongCoffeeTypeInBeanTankException.class, () -> {
            beanTank.increaseCoffeeVolumeInTank(1, CoffeeType.ROBUSTA);
        });

        Assertions.assertDoesNotThrow(() -> {
            beanTank.increaseCoffeeVolumeInTank(1, CoffeeType.ARABICA);
        });
    }
}
