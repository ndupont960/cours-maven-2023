package machine.component;

import fr.imt.cours.machine.component.Tank;
import fr.imt.cours.machine.exception.MaximumVolumeExceededException;
import fr.imt.cours.machine.exception.NegativeTankVolumeException;
import io.cucumber.java.sl.In;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TankTest {

    public Tank tankUnderTest;

    @BeforeEach
    public void beforeTest() {
        double initialVolume = 1.5;
        double minVolume = 0.2;
        double maxVolume = 2;

        tankUnderTest = new Tank(initialVolume,minVolume,maxVolume);
    }

    /**
     * Test permettant de vérifier la fonction d'augmentation du volume dans le réservoir d'eau
     *
     */
    @Test
    public void testVolumeIncreaseWithJUnit() throws MaximumVolumeExceededException {
        double volumeToIncrease = 0.2;

        double volumeBeforeIncrease = tankUnderTest.getActualVolume();
        tankUnderTest.increaseVolumeInTank(volumeToIncrease);
        double volumeExpectedAfterIncrease = volumeBeforeIncrease + volumeToIncrease;

        double volumeActualAfterIncrease = tankUnderTest.getActualVolume();

        // Assertion effectuée avec JUnit5 permettant de tester si la valeur de volume est bien celle attendue
        Assertions.assertEquals(volumeExpectedAfterIncrease,volumeActualAfterIncrease);
    }

    /**
     * Test permettant de vérifier la fonction de diminution du volume dans le réservoir d'eau
     */
    @Test
    public void testVolumeDecreaseWithJUnit() throws NegativeTankVolumeException {
        double volumeToDecrease = 0.2;

        double volumeBeforeDecrease = tankUnderTest.getActualVolume();
        tankUnderTest.decreaseVolumeInTank(volumeToDecrease);
        double volumeExpectedAfterDecrease = volumeBeforeDecrease - volumeToDecrease;

        double volumeActualAfterDecrease = tankUnderTest.getActualVolume();

        // Assertion effectuée avec JUnit5 permettant de tester si la valeur de volume est bien celle attendue
        Assertions.assertEquals(volumeExpectedAfterDecrease,volumeActualAfterDecrease);

    }

    /**
     * Permet de vérifier si une erreur est renvoyée en cas de valeur négative de volume de réservoir
     */
    @Test
    void testNegativeVolumeException() {
        Assertions.assertThrows(NegativeTankVolumeException.class, () -> {
            tankUnderTest.decreaseVolumeInTank(3000);
        });
    }

    /**
     * Permet de vérifier si une erreur est renvoyée en cas de dépassement du volume max du réservoir
     */
    @Test
    void testMaximumVolumeExceededException() {
        Assertions.assertThrows(MaximumVolumeExceededException.class, () -> {
            tankUnderTest.increaseVolumeInTank(3000);
        });
    }
}
