@NoEcomValidatedClientProducts @Regression @Web  @Recruiters
Feature: Client Ecommerce ValidatedEmailUnverifiedClientProducts

  Background:
    Given I navigate to page "Client Registration"
    And   I enter first name "automation"
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
    And   I should see text "Popular Products"
    And   I login as an admin user
    When  I search for "registration@resume-library.com" in the navigation bar on admin
    And   I click on product details Edit button
    Then  I click on actions btn
    And   I click on "Validate account"
    And   I confirm browser popup

  @NoEcommValidatedEmailVerification @ReleaseRegression2
  Scenario: as an validated unverified email account with ecommerce enabled client email account email verification
    Given I navigate to page "Client Account"
    Then  I should see text H two tag "Popular Products"
    Then  I should see text "Featured Job Posting"
    When  I click on Feature Job Posting Buy Online Now
    Then  I should see text "Email Verification Required"
    And   I should see text "An email has been sent to you to complete this. Please be sure to check your junk mail in case it has landed there!"
    And   I should see text p tag "If you need assistance, please call us on " and verify message "If you need assistance, please call us on 1-857-239-0143"
    Then  I close email verification required popup

    And   I should see text p tag "3 Months" and verify message "3 MONTHS"
    When  I click on three months Resume Search Buy Online Now
    Then  I should see text "Email Verification Required"
    And   I should see text "An email has been sent to you to complete this. Please be sure to check your junk mail in case it has landed there!"
    And   I should see text p tag "If you need assistance, please call us on " and verify message "If you need assistance, please call us on 1-857-239-0143"
    Then  I close email verification required popup

    And   I should see text "Post a Job"
    When  I click on "Post a Job"
    Then  I should see text "Email Verification Required"
    And   I should see text "An email has been sent to you to complete this. Please be sure to check your junk mail in case it has landed there!"
    And   I should see text p tag "If you need assistance, please call us on " and verify message "If you need assistance, please call us on 1-857-239-0143"
    Then  I close email verification required popup

  @NoEcommValidatedEmailVerificationForProductsJourney
  Scenario: as an validated unverified email account with ecommerce enabled verify products journey
  #  Given I navigate to page "Client Account"
    And   I navigate to page "Client Resume Search With Sales Keywords"
    And   I should be able to see in browser URL "Client Resume Search Results"
    Then  I should see text "Invite Candidates"
    Then  I select email candidate amount from list
    And   I click on "Invite Candidates"
    Then  I should see text "Email Verification Required"
    And   I should see text "An email has been sent to you to complete this. Please be sure to check your junk mail in case it has landed there!"
    And   I should see text p tag "If you need assistance, please call us on " and verify message "If you need assistance, please call us on 1-857-239-0143"
    Then  I close email verification required popup for resume search

    When  I find a locked candidate and click on unlock resume
    Then  I should see text "Email Verification Required"
    And   I should see text "An email has been sent to you to complete this. Please be sure to check your junk mail in case it has landed there!"
    And   I should see text p tag "If you need assistance, please call us on " and verify message "If you need assistance, please call us on 1-857-239-0143"
    Then  I close email verification required unlock popup
    And   I should see element "Download Resume" is disabled

    When  I click on main number view contact details
    Then  I should see text "Email Verification Required"
    And   I should see text "An email has been sent to you to complete this. Please be sure to check your junk mail in case it has landed there!"
    And   I should see text p tag "If you need assistance, please call us on " and verify message "If you need assistance, please call us on 1-857-239-0143"
    Then  I close email verification required unlock popup

    When  I click on main email address view contact details
    Then  I should see text "Email Verification Required"
    And   I should see text "An email has been sent to you to complete this. Please be sure to check your junk mail in case it has landed there!"
    And   I should see text p tag "If you need assistance, please call us on " and verify message "If you need assistance, please call us on 1-857-239-0143"
    Then  I close email verification required unlock popup

    When  I click on "Download Resume" on view resume page
    Then  I should see text "Email Verification Required"
    And   I should see text "An email has been sent to you to complete this. Please be sure to check your junk mail in case it has landed there!"
    And   I should see text p tag "If you need assistance, please call us on " and verify message "If you need assistance, please call us on 1-857-239-0143"
    Then  I close email verification required unlock popup

    When  I click on "Video Interview" on view resume page
    Then  I should see text "Email Verification Required"
    And   I should see text "An email has been sent to you to complete this. Please be sure to check your junk mail in case it has landed there!"
    And   I should see text p tag "If you need assistance, please call us on " and verify message "If you need assistance, please call us on 1-857-239-0143"
    Then  I close email verification required unlock popup

    When  I click on "Email Resume" on view resume page
    Then  I should see text "Email Verification Required"
    And   I should see text "An email has been sent to you to complete this. Please be sure to check your junk mail in case it has landed there!"
    And   I should see text p tag "If you need assistance, please call us on " and verify message "If you need assistance, please call us on 1-857-239-0143"
    Then  I close email verification required unlock popup