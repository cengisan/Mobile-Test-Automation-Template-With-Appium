@trendyolFaultyLoginError
Feature: Faulty login error message control

  Scenario Outline: Login attempt with invalid email and password
    When Click to Men select box
    When Click to My Account icon
    When Click to input boxes and write email and password
    When Click to login button
    Then Check "<Login Error>" message on the screen
    Examples:
      | Login Error                                |
      | E-posta adresiniz ve/veya şifreniz hatalı. |