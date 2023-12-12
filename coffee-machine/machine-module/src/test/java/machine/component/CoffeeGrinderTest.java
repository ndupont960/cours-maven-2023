package machine.component;

import fr.imt.cours.machine.component.BeanTank;
import fr.imt.cours.machine.component.CoffeeGrinder;
import fr.imt.cours.machine.exception.LackOfBeansInTankException;
import fr.imt.cours.machine.exception.NegativeTankVolumeException;
import fr.imt.cours.storage.cupboard.coffee.type.CoffeeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoffeeGrinderTest {


    /**
     * Test vérifiant la diminution du volume du réservoir de grains lors de l'action grindCoffee
     * @throws InterruptedException
     *
     */
    @Test
    void testGrindCoffee() throws InterruptedException, NegativeTankVolumeException {

        int grindingTime = 2000;

        double initialVolume = 1.5;
        double maxVolume = 2;
        double minVolume = 0.2;
        CoffeeType beanCoffeeType = CoffeeType.ROBUSTA;

        CoffeeGrinder coffeeGrinder = new CoffeeGrinder(grindingTime);
        BeanTank beanTank = new BeanTank(initialVolume,minVolume,maxVolume,beanCoffeeType);

        double volumeBeforeGrind = beanTank.getActualVolume();
        coffeeGrinder.grindCoffee(beanTank);

        double volumeAfterGrind = beanTank.getActualVolume();

        Assertions.assertTrue(volumeAfterGrind < volumeBeforeGrind);

    }
}
