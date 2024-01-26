Feature: Logout User

  Scenario: TC04 Logout User
    Given Navigate to website
    Then Click on Signup-Login button
    And Verify Login to your account is visible
    And Enter correct email address and password
    And Click login button
    And Verify error Your email or password is incorrect! is visible
    And Click Logout button
    And Verify that user is navigated to login page