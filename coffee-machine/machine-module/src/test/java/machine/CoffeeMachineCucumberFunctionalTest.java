package machine;

import fr.imt.cours.machine.CoffeeMachine;
import fr.imt.cours.machine.exception.*;
import fr.imt.cours.storage.cupboard.coffee.type.CoffeeType;
import fr.imt.cours.storage.cupboard.container.*;
import fr.imt.cours.storage.cupboard.exception.CupNotEmptyException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.runner.RunWith;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Classe qui permet de faire le lien entre le fichier "make_a_coffee.feature" et la classe implémentant les étapes
 * de test CoffeeMachineTestFunctionalTest.java
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:functional/features/"},
        glue = "machine.cucumber.steps"
)
//Permet d'ignorer les tests fonctionnels de Cucumber
//Ne lance pas la class CoffeeMachineFunctionalTest

//@Ignore
public class CoffeeMachineCucumberFunctionalTest {

}
