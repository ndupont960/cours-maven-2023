package machine.cucumber.steps;

import fr.imt.cours.machine.EspressoCoffeeMachine;
import fr.imt.cours.machine.exception.*;
import fr.imt.cours.storage.cupboard.coffee.type.CoffeeType;
import fr.imt.cours.storage.cupboard.container.*;
import fr.imt.cours.storage.cupboard.exception.CupNotEmptyException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class CucumberStepsEspressoCoffeeMachineTest {

    public EspressoCoffeeMachine espressoCoffeeMachine;

    public Mug mug;

    public CoffeeContainer containerWithCoffee;


    @Given("an espresso coffee machine with {double} l of min capacity, {double} l of max capacity, {double} l per h of water flow for the pump")
    public void givenAnEspressoCoffeeMachine(double minCapacity, double maxCapacity, double pumpCapacity) {
        espressoCoffeeMachine = new EspressoCoffeeMachine(minCapacity,maxCapacity,minCapacity,maxCapacity,pumpCapacity);
    }

    @And("a {string} with {double} l of capacity")
    public void aWithLOfCapacity(String containerType, double containerCapacity) {
        if ("mug".equals(containerType))
            mug = new Mug(containerCapacity);
    }

    @When("I plug the espresso machine to electricity")
    public void iPlugTheEspressoMachineToElectricity() {
        espressoCoffeeMachine.plugToElectricalPlug();
    }

    @And("I add {int} l of water in the water tank")
    public void iAddLOfWaterInTheWaterTank(double waterVolume) throws MaximumVolumeExceededException {
        espressoCoffeeMachine.addWaterInTank(waterVolume);
    }

    @And("I add {double} l of {string} in the bean tank")
    public void iAddLOfInTheBeanTank(double beanVolume, String coffeeType) throws WrongCoffeeTypeInBeanTankException, MaximumVolumeExceededException {
        espressoCoffeeMachine.addCoffeeInBeanTank(beanVolume, CoffeeType.valueOf(coffeeType));
    }


    @And("I made an espresso coffee {string}")
    public void iMadeAnEspressoCoffee(String coffeeType) throws InterruptedException, CupNotEmptyException, LackOfWaterInTankException, MachineNotPluggedException, CoffeeTypeCupDifferentOfCoffeeTypeTankException, LackOfBeansInTankException, NegativeTankVolumeException{
        //On créé un mock de l'objet random
        Random randomMock = Mockito.mock(Random.class, Mockito.withSettings().withoutAnnotations());
        //On vient ensuite stubber la méthode nextGaussian pour pouvoir controler la valeur retournée
        //ici on veut qu'elle retourne 0.6
        Mockito.when(randomMock.nextGaussian()).thenReturn(0.6);
        //On injecte ensuite le mock créé dans la machine à café
        espressoCoffeeMachine.setRandomGenerator(randomMock);

        if (mug != null)
            containerWithCoffee = espressoCoffeeMachine.makeACoffee(mug, CoffeeType.valueOf(coffeeType));
    }

    @Then("the espresso coffee machine return a coffee mug not empty")
    public void theEspressoCoffeeMachineReturnACoffeeMugNotEmpty() {
        Assertions.assertFalse(containerWithCoffee.isEmpty());
    }

    @And("the coffee volume equals to {double}")
    public void theCoffeeVolumeEqualsTo(double coffeeVolume) {
        assertThat(coffeeVolume, is(containerWithCoffee.getCapacity()));
    }

    @And("the coffee {string} containing a coffee type {string}")
    public void theCoffeeContainingACoffeeType(String containerType, String coffeeType) {
        if ("mug".equals(containerType))
            assertThat(containerWithCoffee, instanceOf(CoffeeMug.class));
        assertThat(containerWithCoffee.getCoffeeType(), is(CoffeeType.valueOf(coffeeType)));
    }

}
