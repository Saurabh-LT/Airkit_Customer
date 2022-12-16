@CandidateSettings @Regression @Web  @ReleaseRegression1 @Traffic
Feature: Candidate Settings Settings

  Background: Register a new candidate with all details
    Given I navigate to page "Candidate Registration"
    When  I register as a new candidate resume check
    Then  I navigate to page "Candidate Settings"

  @candidatePasswordChange
  Scenario: Changing candidate password
    And   I should see text H two tag "Profile & Resume Visibility"
    And   I should see text H two tag "Download My information"
    And   I should see text H two tag "Delete Account"
    And   I fill in old password "123456"
    And   I fill in new password "rltest01"
    And   I fill in confirm new password "rltest01"
    And   I click on save new password button
    Then  I should see "Your password has been successfully updated."
    When  I click on "Logout" Header Link
    Then  I should be on page "Logout"
    And   I should see text p tag "Thanks for using Resume-Library!" and verify message "You have been logged out successfully. Thanks for using Resume-Library!"
    When  I click on "Login" Header Link
    Then  I enter registered email address
    And   I enters Changed password as "rltest01"
    When  I click Login as Jobseeker button
    Then  I should be able to see in browser URL "Candidate My Dashboard"

  @candidateEmailChange
  Scenario: Changing candidate email
    And   I click on change email button
    And   I fill in email and confirm email "settings@gmail.com"
    And   I click on save new email
    Then  I should see "Your email address has been changed successfully to"
    And   I click on "Delete my Account"
    Then  I should be on page "Candidate Delete"
    And   I click on delete my account button
    Then  I should be on page "Candidate Delete Confirm"
    And   I should see text p tag " Your Resume-Library Account has been deleted" and verify message "Account Deletion Successful Your Resume-Library Account has been deleted"

  @candidateHideProfile
  Scenario: Hiding a candidate profile
    Then  I should see text "Hide my Profile"
    And   I click on "Hide my Profile"
    Then  I should be on page "Candidate Hide"
    And   I click on Hide My Profile
    Then  I should see "Your profile is hidden from employers."
    And   I click on "Unhide my Profile"
    Then  I should see "Your profile has been unhidden."

  @candidateDeleteProfile
  Scenario: Deleting a candidate profile
    Then  I should see text "Delete my Account"
    And   I click on "Delete my Account"
    Then  I should be on page "Candidate Delete"
    And   I fill in the comments "Automated testing"
    And   I click on delete my account button
    Then  I should be on page "Candidate Delete Confirm"
    And   I should see text p tag " Your Resume-Library Account has been deleted" and verify message "Account Deletion Successful Your Resume-Library Account has been deleted"

  @CandidateDownloadPersonalInformation
  Scenario: Candidate settings Download Personal information
    And   I click on "Download Personal Information"
    And   I should see download file "personal_data" in folder