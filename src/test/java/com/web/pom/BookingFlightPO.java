package com.web.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BookingFlightPO {

	public static WebDriver driver;
	Actions actions;

	public BookingFlightPO(WebDriver driver) {
		this.driver = driver; 
		actions = new Actions(driver);
	}

	By trip = By.xpath("//*[contains(@id,'guest')][contains(@aria-label,'undefined')]");
	By cabin = By.xpath("//*[contains(@aria-label,'Cabin')]");

	public void selectTabList(String tabName, String tripType, String cabinType) {
		driver.findElement(By.xpath("//*[contains(@data-analytics-key," + tabName + ")]")).click();
		switch (tabName) {
		case "Book":
			driver.findElement(trip).click();
			driver.findElement(By.xpath("//div[contains(text(),'" + tripType + "')]")).click();
			driver.findElement(cabin).click();
			driver.findElement(By.xpath("//div[contains(text(),'" + cabinType + "')])")).click();
			break;
		case "Manage":
			// Need to add logic for Manage Tab
			break;
		case "Check in":
			// Need to add logic for Checkin Tab
			break;
		case "Flight Status":
			// Need to add logic for Flight Status Tab
			break;
		}
	}

	public void selectFlyingFrom(String flyingFrom, String flyingTo) {
		driver.findElement(By.id("oneWayOrigin")).sendKeys(flyingFrom);
		actions.sendKeys(Keys.TAB).build().perform();
		driver.findElement(By.id("oneWayDestination")).sendKeys(flyingTo);
		actions.sendKeys(Keys.TAB).build().perform();
	}
}
