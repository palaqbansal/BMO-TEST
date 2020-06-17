@FindRestaurant
Feature: Find a Restaurant

Scenario: Search for restaurants in my area

Given the user is logged on to "justeat"
When the user enters the Postal code as AR51 1AA
When the user clicks on Search
Then the should see some restaurants in AR51 1AA
