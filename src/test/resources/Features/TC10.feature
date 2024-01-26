Feature: Verify Subscription in home page

  Scenario: TC10 Verify Subscription in home page
    Given Navigate to website
    Then Scroll down to footer
    And Verify text 'SUBSCRIPTION'
    And Enter email address in input and click arrow button
    And Verify success message 'You have been successfully subscribed!' is visible