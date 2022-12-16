@adminPurchaseProduct @Regression @Admin @ReleaseRegression1 @Recruiters
Feature: Admin Misc PurchaseProducts

  Background: Login to admin
    Given I login as an admin user

  @purchaseProductsForAccount
  Scenario: Purchasing products for an account
    When   I navigate to page on admin "Account Purchase Products 1478"
    And   I select option "Test Client Behat ( #11609560 )" from contact
    And   I select option "Cameron Briggs" from sales person
    And   I click on "Add a product"
    And   I select option "Job Posting" from product
    And   I select option "Resume-Library Testing ( #1360713 )" apply to
    And   I select option "Credit Card" from payment type
    And   I click on Mark as Paid
    Then  I click on "Pay Now"
    Then  I enter city "New York"
    And   I fill in "valid" card number
    And   I fill in "valid" cvc
    And   I fill in expiry date
    When  I click Save this card
    Then  I click Pay Now button
    Then  I should see text H three tag "Confirm payment"
    And   I click on Confirm payment
    Then  I should see text "Order Confirmation"
    And   I should see text "The client's purchase has been successful."

  @purchaseCustomProductsForAccount
  Scenario: Purchasing custom products for an account
    When  I navigate to page on admin "Account Purchase Products 1478"
    And   I select option "Test Client Behat ( #11609560 )" from contact
    And   I select option "Cameron Briggs" from sales person
    Then  I click on "Add a custom product"
    And   I enter custom product description "Behat Testing"
    And   I enter custom product unit cost "10"
    And   I select option "Credit Card" from payment type
    And   I click on Mark as Paid
    Then  I click on "Pay Now"
    Then  I enter city "New York"
    And   I fill in "valid" card number
    And   I fill in "valid" cvc
    And   I fill in expiry date
    When  I click Save this card
    Then  I click Pay Now button
    Then  I should see text H three tag "Confirm payment"
    And   I click on Confirm payment
    Then  I should see text "Order Confirmation"
    And   I should see text "The client's purchase has been successful."