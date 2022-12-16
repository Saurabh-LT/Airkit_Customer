@ClientUnsuccessfulRegistration @Regression @Web  @Recruiters
Feature: Client Registration UnsuccessfulRegistration

  @clientRegistrationValidation
  Scenario: Unsuccessful registration and field validation
    Given I navigate to page "Client Registration"
    And   I click on Submit inquiry
    Then  I should see text "Email is required"
    And   I should see text "First name is required"
    Then  I should see text "Last name is required"
    And   I should see text "Password is required"
    Then  I should see text "Company name is required"
    And   I should see text "Address is required"
    Then  I should see text "Phone number is required"
    And   I should see text "Company type and size is required"
    Then  I click on enter address manually link
    Then  I should see text "Address 1 is required"
    And   I should see text "City is required"
    Then  I should see text "State/Province is required"
    And   I should see text "Zip code is required"
    And   I enter email address "testers@"
    Then  I should see text "Please enter a valid email address"
    And   I enter password "1234"
    Then  I should see text "Your password must be at least 6 characters long"
    And   I enter phone number "aaaaa"
    Then  I should see text "Please enter a valid contact number"