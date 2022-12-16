@AdminAccountValidation @Regression @Admin @ReleaseRegression1 @Recruiters
Feature: Admin Account AccountValidation

  Background: Navigating to Account list page
    Given  I navigate to page "Client Registration"
    And    I enter client email address "registration@resume-library.com"
    And    I enter first name "Client"
    And    I enter last name "Client"
    And    I enter password "123456"
    And    I enter client company name "resume-library.com"
    When   I click on enter address manually link
    Then   I enter address "1st street"
    And    I enter city "Los Angeles"
    And    I enter state "California"
    And    I enter zip code "10001, NY"
    And    I enter phone number "012345678945"
    And    I select "Staffing Agency" from recruiter type
    Then   I click on Submit inquiry
    And    I should be on page "Client Account"
    And    I login as an admin user
    When   I search for "registration@resume-library.com" in the navigation bar on admin
    And    I click Account Users
    Then   I click on "Edit" button to activate user in admin page
    Then   I select the option "yes" from dropdown with id "email_confirmed"
    Then   I click on button "Update User" in admin page
    And    I navigate to page on admin "Account Accountlist"

  @accountModify
  Scenario: Modify an account
    Then   I click on modify account btn one
    And    I should see text "Update Account"
    And    I Select Account Type Radio button as "Active"
    And    I click on update account
    Then   I should see text "was successfully updated."

  @accountValidation
  Scenario: Validate a newly created account
    Then   I click on validate account btn one
    And    I confirm browser popup
    Then   I should see text "was validated"

  @accountRejection
  Scenario: Reject an account
    Then   I click on reject account btn one
    And    I should see text "Reject Account"
    And    I select deactivate reason from dropdown "No Budget"
    And    I fill in the comments "Automation Test"
    And    I click on deactivate client
    Then   I should see text "has been rejected"