package machine.component;

import fr.imt.cours.machine.component.WaterPump;
import fr.imt.cours.machine.component.WaterTank;
import fr.imt.cours.machine.exception.NegativeTankVolumeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WaterPumpTest {


    /**
     * Test pour vérifier si le volume après le pompage de l'eau diminue correctement, et si le pumpingTime est le bon
     * @throws InterruptedException
     */
    @Test
    void testPumpWater() throws InterruptedException, NegativeTankVolumeException {

        double initialVolume = 1.5;
        double minVolume = 0.2;
        double maxVolume = 2;

        double waterVolume = 0.5;

        WaterPump waterPump = new WaterPump(700);
        WaterTank waterTank = new WaterTank(initialVolume,minVolume,maxVolume);

        double waterVolumeBeforePump = waterTank.getActualVolume();
        waterPump.pumpWater(waterVolume, waterTank);
        double waterVolumeAfterPump = waterTank.getActualVolume();


        Assertions.assertEquals(waterVolumeAfterPump, waterVolumeBeforePump - waterVolume);
        double pumpingTimeExpected = (waterVolume / 700) * 1000 * 2;
        double pumpingTimeActual = waterPump.pumpWater(waterVolume,waterTank);

        Assertions.assertEquals(pumpingTimeExpected,pumpingTimeActual);
    }
}
