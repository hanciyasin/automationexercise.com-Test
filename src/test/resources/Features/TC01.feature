Feature: Register User Test
@01
  Scenario: TC01 Resgister User
    Given Navigate to website
    Then Click on Signup-Login button
    And Verify New User Signup! is visible
    And Enter name and email address
    And Click Signup button
    And Verify that ENTER ACCOUNT INFORMATION is visible
    And Fill details: Title, Name, Email, Password, Date of birth
    And Select checkbox Sign up for our newsletter!
    And Select checkbox Receive special offers from our partners!
    And Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    And Click Create Account button
