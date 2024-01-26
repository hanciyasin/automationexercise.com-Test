Feature: Remove Products From Cart

  Scenario: TC17 Remove Products From Cart
    Given Navigate to website
    Then Add products to cart
    And Click 'Cart' button
    And Verify that cart page is displayed
    And Click 'X' button corresponding to particular product
    And Verify that product is removed from the cart