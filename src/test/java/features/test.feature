@AppiumTemplate
  Feature:N11 Mobile Application Test
    Scenario: Buying a phone with N11 mobile application
      When Click to ads close button
      When Click to category button
      When Click to electronic category icon
      When Click to telephone and accessory category icon
      When Click to cellphone category icon
      When Click to filter and select iphone15 pro max
      When Click to show result
      When Click first product
      When Click add to cart
      Then Assert to product is in the cart
