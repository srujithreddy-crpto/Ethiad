package StepDefinitions;

import java.util.Map;

import com.web.pom.BookingFlightPO;

import HelperClass.HelperClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingFlight{

	BookingFlightPO bookingFlightPO;
	
	public BookingFlight() {
		bookingFlightPO = new BookingFlightPO(HelperClass.getDriver());
	}
	
	@Given("User opens the browser")
	public void openBrowser() {
		HelperClass.getDriver().get("https://www.etihad.com/en-in/");
		HelperClass.getDriver().manage().window().maximize();
	}

	@Given("User clicks on the {string} tab for booking a flight")
	public void clickTab(String tab, DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		bookingFlightPO.selectTabList(tab, data.get("tripType"), data.get("cabinType"));
	}

	@Then("User travels from {string} to {string} in flight")
	public void selectCity(String source, String destination) {
		bookingFlightPO.selectFlyingFrom(source, destination);
	}
}
