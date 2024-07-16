package Annotation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features =  "src/test/resources/features",
        glue = {"classpath:src/test/java/Step_Definitions"},
        plugin = {"pretty", "html:target/cucumber1.html", "json:target/cucumber1.json"}
)
public class runtest {
}
