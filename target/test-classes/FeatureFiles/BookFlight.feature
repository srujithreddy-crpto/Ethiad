@Smoke @Booking @Sanity 
Feature: Book a Flight  
  
  
  @BookingFlight
  Scenario: Passenger travelling from One city to another city
  	Given User opens the browser
    Given User clicks on the "Book" tab for booking a flight
    	|tripType |One way |
    	|cabinType|Business|
    Then User travels from "Hyderabad" to "Singapore" in flight