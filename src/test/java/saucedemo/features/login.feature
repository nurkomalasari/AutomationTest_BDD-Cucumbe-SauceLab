Feature: Login Page Sauce Demo Website

  Scenario: Success Login
    Given Sauce demo login page
    When Input Username
    And Input Password
    And Click login button
    Then User in products page
    And Close the page

  Scenario: Failed Login
    Given Sauce demo login page
    When Input Username
    And Input Invalid Password
    And Click login button
    Then User get error message
    And Close the page