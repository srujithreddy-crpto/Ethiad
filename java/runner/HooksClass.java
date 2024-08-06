package runner;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;

public class HooksClass {

	public static WebDriver driver;
	public static ChromeOptions chromeOptions;
	
	@Before
	public void chromeDriver() {
		WebDriverManager.chromedriver().setup();
		chromeOptions.addArguments("--incognito");
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--headless=false");
		driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.etihad.com/en-in/");
	}
	
	@AfterStep
	public void failedScenarios(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] takeScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(takeScreenShot, "img/png", scenario.getName());
			Allure.addByteAttachmentAsync(null, null, null, null);
		}
	}
	
	@After
	public void tearDown() {
		
		driver.quit();
	}
}
