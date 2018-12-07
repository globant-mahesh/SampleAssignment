Feature: Flight Search
  This feature deals with the one way, round trip and multi city flight search features

  @Sanity
  Scenario: One way flight search
  #When Open app URL
    Given User is landed on Search Flights home page
    And User selects one way option for flight search
    And User enters the source and destination airports
    And User selects the travel date as 7 December
    And User selects the no of passengers that are travelling
    And User clicks on search flights
    Then all the flights should be displayed to the user
    And Top five flights to be exported to excel spreadsheet as output data



