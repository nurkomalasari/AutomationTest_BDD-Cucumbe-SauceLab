Feature: Add to Cart Sauce Demo Website

  Scenario: Add Product to Cart
    Given Sauce demo login page
    When Input Username
    And Input Password
    And Click login button
    Then User in products page
    And Click one product
    Then User in product page
    And Click add to cart
    And Click cart icon
    Then The product is in cart page
    And Close the page


  Scenario: Remove Product from Cart
    Given Sauce demo login page
    When Input Username
    And Input Password
    And Click login button
    Then User in products page
    And Click one product
    Then User in product page
    And Click add to cart
    And Click cart icon
    Then The product is in cart page
    And Click button remove
#    Then The product is removed from cart page
    And Close the page