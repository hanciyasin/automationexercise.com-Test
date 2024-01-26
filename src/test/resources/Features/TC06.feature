Feature: Contact Us Form

  Scenario:   TC06 Contact Us Form
    Given Navigate to website
    Then Click on 'Contact Us' button
    And Verify 'GET IN TOUCH' is visible
    And Enter name, email, subject and message
    And Upload file
    And Click 'Submit' button
    And Click OK button
    And  Verify success message 'Success! Your details have been submitted successfully.' is visible
    And  Click 'Home' button and verify that landed to home page successfully