Feature: Add to Cart Button Test in Products Page

  Scenario: Add to Cart Button
    Given Sauce demo login page
    When Input Username
    And Input Password
    And Click login button
    Then User in products page
    And Click add to cart
    Then Button change to remove
    And Close the page


  Scenario: Remove Product Button
    Given Sauce demo login page
    When Input Username
    And Input Password
    And Click login button
    Then User in products page
    And Click add to cart
    Then Button change to remove
    And Click button remove
    Then Button change to add to cart
    And Close the page