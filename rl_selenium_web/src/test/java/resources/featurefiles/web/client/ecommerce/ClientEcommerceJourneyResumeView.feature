@ClientEcommerceResumeView @Regression @Web  @Recruiters
Feature: Client Ecommerce ClientEcommerceJourneyResumeView

  Background: Register a new client with all details
    Given I navigate to page "Client Registration"
    And   I enter first name "Stephanie"
    And   I enter last name "client"
    And   I enter password "123456"
    And   I enter client company name "resume-library"
    And   I enter phone number "012345678912"
    And   I click on enter address manually link
    And   I enter address one "1st street"
    And   I enter city "Boston"
    And   I enter state "Massachusetts"
    And   I enter zip code "02108"
    And   I select "Staffing Agency" from recruiter type
    When  I enter client email address "registration@resume-library.com"
    And   I click on Submit inquiry
    Then  I should be on page "Client Account"
    And   I should see text "Welcome to Resume-Library!"
    And   I should see text "Before you can make any purchases we need to validate your account. Please call our team on 1-857-239-0143 to validate your account instantly."

  @ClientEcomResumeViewAccountAuthentication @ReleaseRegression2
  Scenario: as an unvalidated logged in client I expect to see resume view options
    Given I navigate to page "Client Account"
    Then  I am on page "Client Resume Search With Keywords"
    And   I should be able to see in browser URL "Client Resume Search Results"
    And   I find a locked candidate and click on unlock resume
    Then  I should see text "Account Authentication Required"
    And   I should see text "Before you can make any purchases, we need to validate your account."
    And   I should see text p tag "Please call our team on " and verify message "Please call our team on 1-857-239-0143 and this will be validated instantly."
    Then  I close account authentication for unlock resume
    And   I should see element "Download Resume" is disabled

    When  I click on main number view contact details
    And   I wait for account authentication popup
    Then  I should see text "Account Authentication Required"
    And   I should see text "Before you can make any purchases, we need to validate your account."
    And   I should see text p tag "Please call our team on " and verify message "Please call our team on 1-857-239-0143 and this will be validated instantly."
    Then  I close account authentication for unlock resume

    When  I click on main email address view contact details
    And   I wait for account authentication popup
    Then  I should see text "Account Authentication Required"
    And   I should see text "Before you can make any purchases, we need to validate your account."
    And   I should see text p tag "Please call our team on " and verify message "Please call our team on 1-857-239-0143 and this will be validated instantly."
    Then  I close account authentication for unlock resume

    When  I click on "Download Resume"
    And   I wait for account authentication popup
    Then  I should see text "Account Authentication Required"
    And   I should see text "Before you can make any purchases, we need to validate your account."
    And   I should see text p tag "Please call our team on " and verify message "Please call our team on 1-857-239-0143 and this will be validated instantly."
    Then  I close account authentication for unlock resume

    When  I click on "Video Interview"
    And   I wait for account authentication popup
    Then  I should see text "Account Authentication Required"
    And   I should see text "Before you can make any purchases, we need to validate your account."
    And   I should see text p tag "Please call our team on " and verify message "Please call our team on 1-857-239-0143 and this will be validated instantly."
    Then  I close account authentication for unlock resume

    When  I click on "Email Resume"
    And   I wait for account authentication popup
    Then  I should see text "Account Authentication Required"
    And   I should see text "Before you can make any purchases, we need to validate your account."
    And   I should see text p tag "Please call our team on " and verify message "Please call our team on 1-857-239-0143 and this will be validated instantly."
    Then  I close account authentication for unlock resume

    Given I navigate to page "Client Jobs"
    Then  I click on "Post a Job"
    Then  I should see text "Account Authentication Required"
    And   I should see text "Before you can make any purchases, we need to validate your account."
    And   I should see text p tag "Please call our team on " and verify message "Please call our team on 1-857-239-0143 and this will be validated instantly."
    Then  I close account authentication for job dashboard

  @EcommUnvalidatedClientInviteToApply1
  Scenario: as an unvalidated logged in client with E-commerce enabled verify resume search invite to apply
    Given I navigate to page "Client Account"
    Then  I am on page "/client/resume-search/results?keywords=sales+OR+php+OR+test&submt_btn=1"
    And   I should be able to see in browser URL "Client Resume Search Results"
    And   I wait for "2" seconds
    Then  I should see text "Invite Candidates"
    When  I select all (20) from email candidates amount dropdown
    And   I click on "Invite Candidates"
    And   I wait for "1" seconds
    Then  I should see text "Account Authentication Required"
    And   I should see text "Before you can make any purchases, we need to validate your account."
    And   I should see text p tag "Please call our team on " and verify message "Please call our team on 1-857-239-0143 and this will be validated instantly."

  @EcommUnvalidatedClientInviteToApply2
  Scenario: as an unvalidated logged in client with E-commerce enabled verify resume search select all checkbox invite to apply
    Given I navigate to page "Client Account"
    Given I navigate to page "Client Resume Search With Keywords"
    And   I should be able to see in browser URL "Client Resume Search Results"
    And   I wait for "2" seconds
    Then  I should see text "Invite Candidates"
    And   I should see text "Select all" on the page source
    When  I tick Select all checkbox
    Then  I should see all Resume(s) selected
    And   I select option "Invite to Apply" from resumes selected
    And   I wait for "2" seconds
    Then  I should see text "Account Authentication Required"
    And   I should see text "Before you can make any purchases, we need to validate your account."
    And   I should see text p tag "Please call our team on " and verify message "Please call our team on 1-857-239-0143 and this will be validated instantly."