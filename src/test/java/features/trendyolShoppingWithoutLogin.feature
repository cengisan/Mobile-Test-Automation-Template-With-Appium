@trendyolShoppingWithoutLogin
Feature: Trendyol Shopping without login Test Case

  Scenario Outline: Add a phone in the cart and check the cart notification
    When Click to Men select box
    When Click to electronic category icon from menu
    When Click to cellphone category icon
    When Click to IOS Phones category icon
    When Scroll down and click to second product
    When Add product to cart
    Then Check "<Notification>" in the cart
    Examples:
      | Notification             |
      | Sepetim, 1 yeni bildirim |