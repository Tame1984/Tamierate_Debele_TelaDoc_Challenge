package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports.html" },
        features = "src/test/java/features/users.feature"
        ,glue= {"stepsDefinition"}
)
public class UserRunner {

}