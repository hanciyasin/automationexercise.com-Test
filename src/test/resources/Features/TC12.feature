Feature: Add Products in Cart

  Scenario: TC12 Add Products in Cart
    Given Navigate to website
    Then Click 'Products' button
    And Hover over first product and click 'Add to cart'
    And Click 'Continue Shopping' button
    And Hover over second product and click 'Add to cart'
    And Click 'View Cart' button
    And Verify both products are added to Cart
    And Verify their prices, quantity and total price