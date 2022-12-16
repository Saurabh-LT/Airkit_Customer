# Test Coverage:
# 1. Checking field validation for email, first name, last name, password, job title, zip code and resume upload
# 2. Checking field validation messages when the field conditions are not met or invalid information is entered
@CandidateRegistrationValidation @Regression @Web  @Candidate
Feature: Candidate Registration UnsuccessfulRegistration

  @candidateInvalidRegistrationValidationMessage
  Scenario: Unsuccessful candidate registration field validation
    Given I navigate to page "Candidate Registration"
    When  I click on register button
    And   I click on register button
    Then  I should see text "Email is required"
    And   I should see text "First name is required"
    And   I should see text "Last name is required"
    And   I should see text "Password is required"
    And   I should see text "Latest job title is required"
    And   I should see text "Zip code is required"
    And   I should see text "Resume is required"

  @candidateInvalidRegistration @ReleaseRegression1
  Scenario Outline: Unsuccessful candidate registration
    Given I navigate to page "Candidate Registration"
    When  I enter email address "<Email>"
    And   I enter first name "<FirstName>"
    And   I enter last name "<LastName>"
    And   I enter password "<Password>"
    And   I enter latest job title "<JobTitle>"
    And   I enter zip code "<ZipCode>"
    And   I upload resume "<Resume>"
    And   I click on register button
    Then  I should see text "Please enter a valid email address"
    And   I should see text "Please enter a valid first name that does not contain numbers"
    And   I should see text "Please enter a valid last name that does not contain numbers"
    And   I should see text "Your password must be at least 6 characters long"
    And   I should see text "Please enter a valid US zip code"
    And   I should see text "We can only accept .doc .docx .pdf .txt .odt .wps .html .htm files"
    Examples:
      | Email | FirstName | LastName | Password | JobTitle     | ZipCode   | Resume            |
      | test  | Test123   | Test123  | test     | Test Analyst | 123456789 | Project Structure Image|

  @resumeReviewValidationOnRegistration
  Scenario: Verify resume review is displayed on registration after a upload
    Given I navigate to page "Candidate Registration"
    When  I should not see "Send me my free professional resume review" text
    And   I upload resume "Test Cv"
    Then  I should see text "Send me my free professional resume review"

  @verifyRegistrationTerms
  Scenario: Verify that the privacy policy and terms and conditions links are displayed on registration
    Given I navigate to page "Candidate Registration"
    And   I click on privacy policy link
    Then  I should be able to see in browser URL "Privacy"
    And   I should see text "Resume-Library Privacy Policy"
    And   I move backward one page
    Then  I click on terms conditions link
    Then  I should be able to see in browser URL "Terms"
    And   I should see text "Resume-Library Terms & Conditions"

  @registrationValidationResumeUndersize
  Scenario: Verify resume is large enough on resume upload
    Given I navigate to page "Candidate Registration"
    And   I upload resume "Resume Undersized Text File"
    Then  I should see text "This file is less than 1kb or bigger than 2mb"

  @registrationValidationResumeOversize
  Scenario: Verify resume is small enough on resume upload
    Given I navigate to page "Candidate Registration"
    And   I upload resume "Resume Oversized"
    Then  I should see text "This file is less than 1kb or bigger than 2mb"

  @registrationValidationOfInvalidEmailAddressAndPassWord
  Scenario Outline: Validation of Email Address
    Given I navigate to page "Candidate Registration"
    When  I enter email address only "<Email>"
    And   I enter password "<Password>"
    And   I enter latest job title "<JobTitle>"
    And   I click on register button
    Then  I should see text "Please enter a valid email address"
    Then  I should see text "Your password can not contain spaces"
    Examples:
      | Email       | Password   | JobTitle     |
      | test@gmail. | 12345  678 | Test Analyst |