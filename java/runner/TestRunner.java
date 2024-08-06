package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FeatureFiles", glue= {"StepDefinitions"}, tags = "@Booking and @BookingFlight", 
monochrome = true, dryRun = true, plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","json:target/cucumber-reports/cucumber.json"})
public class TestRunner {
}