Feature: Flight Search
  This feature deals with the one way, round trip and multi city flight search features

    @Regression
  Scenario: Round Trip Flight Search
    Given User is landed on Search Flights home page
    And User selects round trip option for flight search
    And User enters the source and destination airports
    And User selects the travel date as 7 December and return date as 10 January
    And User selects the no of passengers that are travelling
    And User clicks on search flights
    Then all the flights should be displayed to the user




