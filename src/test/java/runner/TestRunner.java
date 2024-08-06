package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FeatureFiles", glue= {"StepDefinitions"}, tags = "@Booking", 
monochrome = true, plugin = {"pretty","html:target/cucumber.html","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class TestRunner{
}