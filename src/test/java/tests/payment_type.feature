# filename: tests/payment_type.feature

Feature: Anonymous PayPal Purchase
  Scenario: Customer without an existing account checks out via PayPal
    Given Customer does not have an account wants to pay with PayPal
    When Customer enters required info and clicks PayPal button
    Then Customer is redirected to PayPal site to complete purchase

