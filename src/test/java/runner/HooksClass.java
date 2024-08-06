package runner;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

import HelperClass.HelperClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;

public class HooksClass {
	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] takeScreenShot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(takeScreenShot, "img/png", scenario.getName());
			Allure.addByteAttachmentAsync(null, null, null, null);
		}
		HelperClass.tearDown();
	}
}
