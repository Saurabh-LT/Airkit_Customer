@RequestATrial @Regression @Web  @Traffic
Feature: Client TrailDemo RequestATrial

Background: Navigating to Request a Trial page
    Given  I navigate to page "Hiring Resume Search"
    When   I click on "Request Free Trial"

  @requestATrialValidation
  Scenario: Validation of trial page
    Then  I should see text "Activate Your Free Trial Today"
    When  I click on Submit inquiry
    Then  I should see text "Email is required"
    Then  I should see text "Full name is required"
    Then  I should see text "Phone number is required"
    Then  I should see text "Company name is required"
    Then  I should see text "Zip code is required"
    Then  I should see text "Company type and size is required"
    Then  I should see text "Approximate hires per year is required"
    When  I enter email address "testers@"
    Then  I should see text "Please enter a valid email address"
    When  I enter phone number "aaaaa"
    Then  I should see text "Please enter a valid contact number"
    Then  I enter zip code "00000"
    Then  I click on Submit inquiry
    Then  I should see text "Please enter a valid US zip code"

  @requestATrialSubmit @ReleaseRegression2
  Scenario: Submit the trial form
    When  I enter email address "testers+client@resume-library.com"
    And   I enter name "automation demo"
    And   I enter phone number "123456789"
    And   I enter client company name "resume-library"
    And   I enter zip code "10001"
    And   I select "Staffing Agency (1-5 employees)" from recruiter type
    And   I select "1-10" from approx hires
    Then  I click on Submit inquiry
    Then  I should see text "Thanks for requesting a trial."