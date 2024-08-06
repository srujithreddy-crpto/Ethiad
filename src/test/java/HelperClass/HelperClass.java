package HelperClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperClass {
	public static HelperClass helperClass;
    public static WebDriver driver;
    public final static int TIMEOUT = 5;
     
               
    public static void openPage(String url) {
        driver.get(url);
    }
           
    public static WebDriver getDriver() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        return driver;              
    }
       
    public static void setUpDriver() {
        if (helperClass==null) {
            helperClass = new HelperClass();
        }
    }
       
    public static void tearDown() {
            
        if(driver!=null) {
             driver.close();
             driver.quit();
        }
            
       helperClass = null;
   } 
	
}
