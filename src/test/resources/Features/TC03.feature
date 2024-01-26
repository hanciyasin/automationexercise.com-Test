Feature: Login User with incorrect email and password

  Scenario: TC03 Login User with incorrect email and password
    Given Navigate to website
    Then Click on Signup-Login button
    And Verify Login to your account is visible
    And Enter incorrect email address and password
    And Click login button
    And Verify error Your email or password is incorrect! is visible