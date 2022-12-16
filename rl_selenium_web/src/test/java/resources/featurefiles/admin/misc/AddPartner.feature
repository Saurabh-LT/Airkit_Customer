@AddPartner @Regression @Admin @ReleaseRegression1 @Partnerships
Feature: Admin Misc AddPartner

Background: Login to Admin
    Given   I login as an admin user
    When    I go to add partner page

Scenario: Confirming the validation messages when adding a partner
    Then    I should see text "Add Partner/Alliance"
    And     I click Add PartnerAlliance button
    Then    I should see text "The Company name field is required."
    And     I should see text "The First Name field is required."
    And     I should see text "The Last Name field is required."
    And     I should see text "The Email field is required."
    And     I should see text "The Partner Type field is required."

    @AdminE2E
Scenario: Adding a new partner to admin
    When    I fill in "Partner Company Name"
    And     I fill in "Contact First Name"
    And     I fill in "Contact Last Name"
    And     I fill in "Contact Email"
    And     I select the option "backfill_partner" from "Partner Type" field
    Then    I click Add PartnerAlliance button
    Then    I should see text "has been successfully created"
    And     I should see text "View Partner"