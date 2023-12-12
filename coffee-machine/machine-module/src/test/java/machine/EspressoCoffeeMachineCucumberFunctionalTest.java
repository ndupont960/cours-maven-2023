package machine;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:functional/features/make_an_espresso.features"},
        glue = "machine.cucumber.steps"
)
//@Ignore
public class EspressoCoffeeMachineCucumberFunctionalTest {

}
