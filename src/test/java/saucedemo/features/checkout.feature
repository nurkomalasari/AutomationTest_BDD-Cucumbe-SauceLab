Feature: Checkout Product from Cart Sauce Demo Website

  Scenario: Checkout Product with Complete User Information
    Given Sauce demo login page
    When Input Username
    And Input Password
    And Click login button
    Then User in products page
    And Click one product
    And Click add to cart
    And Click cart icon
    Then The product is in cart page
    And Click checkout button
    Then User in information page
    And Input first name
    And Input last name
    And Input postal code
    And Click continue
    Then User in checkout overview page
    And Click Finish
    Then User in checkout complete page
    And Close the page

  Scenario: Checkout Product with Missing Postal Code
    Given Sauce demo login page
    When Input Username
    And Input Password
    And Click login button
    Then User in products page
    And Click one product
    And Click add to cart
    And Click cart icon
    Then The product is in cart page
    And Click checkout button
    Then User in information page
    And Input first name
    And Input last name
    And Click continue
    Then User get postal error message
    And Close the page
