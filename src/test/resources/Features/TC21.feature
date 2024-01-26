Feature: Add review on product

  Scenario: TC21 Add review on product
    Given Navigate to website
    Then Click on 'Products' button
    And Verify user is navigated to ALL PRODUCTS page successfully
    And Click on 'View Product' button
    And Verify 'Write Your Review' is visible
    And Enter name, email and review
    And Click 'Submit' button
    And Verify success message 'Thank you for your review.'