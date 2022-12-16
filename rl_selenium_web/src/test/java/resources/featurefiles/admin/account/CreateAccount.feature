@CreateAccount @Regression @Admin @ReleaseRegression1 @Recruiters
Feature: Admin Account CreateAccount

  Background: Navigating to Create Account page
    Given I login as an admin user
    When  I navigate to page on admin "Account Add"

  @createAccountValidation
  Scenario: Validations on create account page
    Then  I should see text "Create Account"
    And   I should see text "Company Details"
    And   I should see text "Primary Contact Details"
    When  I click Create Account button
    Then  I should see text "Company Name is required"
    And   I should see text "This field is required."
    And   I should see text "First Name is required"
    And   I should see text "Last Name is required"
    And   I should see text "Email is required"
    And   I should see text "At least 1 contact number is required"
    And   I should see text "Please, select one ATS at least"

  @createAccountSuccess @AdminE2E
  Scenario: Create an account successfully
    When  I fill in "Company Name"
    And   I select the option "Active" from "Account Type" field
    And   I enter "Bullhorn" to ATS field
    And   I fill in the field "Email"
    And   I fill in the field "First Name"
    And   I fill in the field "Last Name"
    And   I fill in the field "Main Telephone"
    And   I click Create Account button
    Then  I should be on Account View page
    And   I should see text "successfully created"
    And   I click View more button
    And   the ATS Apply field should contain "None"
    Then  I click Edit button
    And   I select the option "BigBiller" from "ATS Apply" field
    When  I click Save Changes button
    And   I click View more button
    And   the ATS Apply field should contain "BigBiller"