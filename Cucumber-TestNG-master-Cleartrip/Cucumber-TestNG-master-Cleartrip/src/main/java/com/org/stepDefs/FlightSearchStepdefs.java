package com.org.stepDefs;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


import java.io.IOException;

import com.org.pages.DisplayFlightOptions;
import com.org.pages.SearchFlight;




public class FlightSearchStepdefs{
    
    
    public SearchFlight searchFlightPg;
    public DisplayFlightOptions displayFlightPg;

    
    private void CreatePageObjects() {
    	
   
   	 	
        searchFlightPg = new SearchFlight(Hooks.driver);
        displayFlightPg = new DisplayFlightOptions(Hooks.driver);

    }
    
    

    @Given("^User is landed on Search Flights home page$")
    public void userIsLandedOnSearchFlightsHomePage() {
      CreatePageObjects();
    	//searchFlightPg = new SearchFlight(Hooks.driver);
       searchFlightPg.navigateToSearchPage();
    }

    @And("^User selects one way option for flight search$")
    public void userSelectsOneWayOptionForFlightSearch() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
       CreatePageObjects();
        //Thread.sleep(2000);
        //driver.findElement(By.id("RoundTrip")).click();
    	//searchFlightPg = new SearchFlight(Hooks.driver);
        searchFlightPg.oneWaySelect();
    }

    @And("^User enters the source and destination airports$")
    public void userEntersTheSourceAndDestinationAirports() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        CreatePageObjects();
        searchFlightPg.enterLocations();
    }


    @And("^User selects the travel date as (\\d+) December$")
    public void userSelectsTheTravelDateAsDecember(int Date) {
        // Write code here that turns the phrase above into concrete actions
        CreatePageObjects();
        searchFlightPg.selectDepartDate(Integer.toString(Date));
    }

    @And("^User selects the travel date as (\\d+) December and return date as (\\d+) January")
    public void userSelectsTheTravelDateAsDecemberAndReturnDateAsDecember(String departDate, String returnDate) {
        // Write code here that turns the phrase above into concrete actions
        CreatePageObjects();
        searchFlightPg.selectDepartDate(departDate);
        searchFlightPg.selectReturnDate(returnDate);
    }

    @And("^User selects the no of passengers that are travelling$")
    public void userSelectsTheNoOfPassengersThatAreTravelling() {
        // Write code here that turns the phrase above into concrete actions
        CreatePageObjects();
        searchFlightPg.passengerDetails();
    }

    @And("^User clicks on search flights$")
    public void userClicksOnSearchFlights() {
        // Write code here that turns the phrase above into concrete actions
        CreatePageObjects();
        DisplayFlightOptions objDisplayFlight =searchFlightPg.searchFlight();
    }

    @Then("^all the flights should be displayed to the user$")
    public void allTheFlightsShouldBeDisplayedToTheUser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        CreatePageObjects();
        displayFlightPg.getFlightDetails();
    }


    @And("^User selects round trip option for flight search$")
    public void userSelectsRoundTripOptionForFlightSearch() {
        // Write code here that turns the phrase above into concrete actions
        CreatePageObjects();
        searchFlightPg.returnSelect();
    }


    @And("^Top five flights to be exported to excel spreadsheet as output data$")
    public void topFiveFlightsToBeExportedToExcelSpreadsheetAsOutputData() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        CreatePageObjects();
        displayFlightPg.writeFlightDetails();
    }
}
