package StepDefinitions;

import java.util.Map;

import com.web.pom.BookingFlightPO;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import runner.HooksClass;

public class BookingFlight extends HooksClass {

	BookingFlightPO bookingFlightPO;

	@Given("User clicks on the {string} tab for booking a flight")
	public void clickTab(String tab, DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		bookingFlightPO = new BookingFlightPO(HooksClass.driver);
		bookingFlightPO.selectTabList(tab, data.get("tripType"), data.get("cabinType"));
	}

	@Then("User travels from {string} to {string} in flight")
	public void selectCity(String source, String destination) {
		bookingFlightPO = new BookingFlightPO(HooksClass.driver);
		bookingFlightPO.selectFlyingFrom(source, destination);
	}
}
