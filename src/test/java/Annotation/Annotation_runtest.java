package Annotation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features =  "src/test/resources/features/annotation.feature",
        glue = {"classpath:Step_Definitions"},
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}
)
public class Annotation_runtest {
}
