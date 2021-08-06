package project;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/project/features",
        plugin = {"pretty", "html:target/cucumber-html-report:"},
        strict = true)
public class RunTest {

}