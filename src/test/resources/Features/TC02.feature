Feature: Login User with correct email and password

  Scenario: TC02 Login User with correct email and password
    Given Navigate to website
    Then Click on Signup-Login button
    And Verify Login to your account is visible
    And Enter correct email address and password
    And Click login button
    And Verify that Logged in as username is visible
