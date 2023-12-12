package fr.imt.cours.machine.component;

import fr.imt.cours.machine.exception.MaximumVolumeExceededException;
import fr.imt.cours.machine.exception.WrongCoffeeTypeInBeanTankException;
import fr.imt.cours.storage.cupboard.coffee.type.CoffeeType;

public class BeanTank extends Tank{

    private CoffeeType beanCoffeeType;
    /**
     * Réservoir de graines de café de la cafetière
     *
     * @param initialVolume Volume de graines à mettre dans le réservoir à sa création
     * @param minVolume     Volume de graines minimal du réservoir
     * @param maxVolume     Volume de graines maximal du réservoir
     * @param beanCoffeeType Type de café dans le réservoir
     */
    public BeanTank(double initialVolume, double minVolume, double maxVolume, CoffeeType beanCoffeeType) {
        super(initialVolume, minVolume, maxVolume);
        this.beanCoffeeType = beanCoffeeType;
    }

    public void increaseCoffeeVolumeInTank(double coffeeVolume, CoffeeType coffeeType) throws WrongCoffeeTypeInBeanTankException, MaximumVolumeExceededException {
        if(coffeeType != beanCoffeeType){
            if (getActualVolume() == 0){
                this.increaseVolumeInTank(coffeeVolume);
                this.beanCoffeeType = coffeeType;
            } else if (getActualVolume() > 0) {
                throw new WrongCoffeeTypeInBeanTankException("The bean tank is getting filled with the incorrect coffee type");

            }
        } else {
            this.increaseVolumeInTank(coffeeVolume);
        }
    }
    public CoffeeType getBeanCoffeeType() {
        return beanCoffeeType;
    }

    public void setBeanCoffeeType(CoffeeType beanCoffeeType) {
        this.beanCoffeeType = beanCoffeeType;
    }
}
