Feature: Search Product

  Scenario: TC09 Search Product
    Given Navigate to website
    Then Click on Products button
    And Verify user is navigated to ALL PRODUCTS page successfully
    And Enter product name in search input and click search button
    And Verify SEARCHED PRODUCTS is visible
    And Verify all the products related to search are visible