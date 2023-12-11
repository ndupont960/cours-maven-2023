package machine.component;

import fr.imt.cours.machine.component.Tank;
import io.cucumber.java.sl.In;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TankTest {

    /**
     * Test permettant de vérifier la fonction d'augmentation du volume dans le réservoir d'eau
     *
     */
    @Test
    public void testVolumeIncreaseWithJUnit() {
        double initialVolume = 1500;
        double minVolume = 200;
        double maxVolume = 2000;


        Tank tank = new Tank(initialVolume,minVolume,maxVolume);

        double volumeToIncrease = 200;
        tank.increaseVolumeInTank(volumeToIncrease);
        double volumeExpected = initialVolume + volumeToIncrease;

        double volumeActual = tank.getActualVolume();

        // Assertion effectuée avec JUnit5 permettant de tester si la valeur de volume est bien celle attendue
        Assertions.assertEquals(volumeExpected,volumeActual);

    }

    /**
     * Test permettant de vérifier la fonction de diminution du volume dans le réservoir d'eau
     */
    @Test
    public void testVolumeDecreaseWithJUnit() {
        double initialVolume = 1500;
        double minVolume = 200;
        double maxVolume = 2000;


        Tank tank = new Tank(initialVolume,minVolume,maxVolume);

        double volumeToDecrease = 200;
        tank.decreaseVolumeInTank(volumeToDecrease);
        double volumeExpected = initialVolume - volumeToDecrease;

        double volumeActual = tank.getActualVolume();


        // Assertion effectuée avec JUnit5 permettant de tester si la valeur de volume est bien celle attendue
        Assertions.assertEquals(volumeExpected,volumeActual);

    }
}
