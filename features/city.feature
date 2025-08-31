Feature: City Search Module

  Background:
    Given User is on the city selection page

  @ValidCitySearch
  Scenario Outline: Search for a valid city name
    When I search for city "<city>"
    Then I should see "<city>" in the search results
    And verify dropdown text should be "<city>"
    
    Examples:
    |city  |
    |Lucknow|

  @InvalidCitySearch
  Scenario Outline: Search for an invalid city name
    When I search for city "<city>"
    Then I should see an error message "<message>"
    
    Examples:
    |city  		 |message          |
    |FakeCity|No results found.|

  @CityIcons
  Scenario Outline: Select city by choosing a city icon
    When I select the city icon "<city>"
    Then verify dropdown text should be "<city>"
    
    Examples:
    |city |
    |Pune |

  @ViewAllCities
  Scenario Outline: View all cities and validate additional city names
    When I click on "<textlink>"
    Then I should see city names like "<city1>" and "<city2>" 
    And verify "<city1>" and "<city2>" should not be in popular cities
    
   Examples:
    |city1  |city2      |textlink              |
    |Nagpur |Bhubaneswar|View All Cities|
