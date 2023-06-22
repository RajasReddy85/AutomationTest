@test
Feature: Automation Test for Mercator

  Scenario: Add costly dress to cart
    Given I open the sauce demo site
    And I login to sauce demo site
    Then I assert the page title to be "Products"
    When I add costly dress to cart
    And I click on cart icon on the products page
    Then I assert the page title to be "Your Cart"
    And I validate the price in the cart page
