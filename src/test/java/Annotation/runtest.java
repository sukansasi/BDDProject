package Annotation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "Registration",
        features =  "src/test/resources/features/Registration.feature",
        glue = {"classpath:src/test/java/Step_Definitions"},
        plugin = {"pretty", "html:target/cucumber1.html", "json:target/cucumber1.json"}
)
public class runtest {
}
