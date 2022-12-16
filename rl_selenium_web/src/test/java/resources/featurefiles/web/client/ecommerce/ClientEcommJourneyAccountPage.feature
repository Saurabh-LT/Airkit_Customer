@ClientEcommerceJourneyAccountPage @Regression @Web  @Recruiters
Feature: Client Ecommerce ClientEcommJourneyAccountPage

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

  @EcomClientVerifyProductsPurchase @ReleaseRegression2
  Scenario: as an unvalidated logged in client I expect to see products that I can purchase
    Given I navigate to page "Client Account"
    Then  I should see text H two tag "Popular Products"
    Then  I should see text "Featured Job Posting"
    When  I click on Feature Job Posting Buy Online Now
    Then  I should see text "Account Authentication Required"
    Then  I should see text "Before you can make any purchases, we need to validate your account."
    Then  I should see text p tag "Please call our team on " and verify message "Please call our team on 1-857-239-0143 and this will be validated instantly."
    When  I close account authentication required popup
    Then  I should see text p tag "3 Months" and verify message "3 MONTHS"
    Then  I should see text H three tag "Resume Search"
    When  I click on three months Resume Search Buy Online Now
    And   I should see text "Account Authentication Required"
    And   I should see text "Before you can make any purchases, we need to validate your account."
    And   I should see text p tag "Please call our team on " and verify message "Please call our team on 1-857-239-0143 and this will be validated instantly."
    And   I close account authentication required popup
    Then  I should see text "Post a Job"
    When  I click on Post a Job
    Then  I should see text "Account Authentication Required"
    And   I should see text "Before you can make any purchases, we need to validate your account."
    And   I should see text p tag "Please call our team on" and verify message "Please call our team on 1-857-239-0143 and this will be validated instantly."
    And   I close account authentication required popup

  @EcommUnvalidatedClientVerifyEmployersLogo
  Scenario: as an unvalidated logged in client with E-commerce enabled verify employers logo
    Given I navigate to page "Client Account"
    When  I click on the RL Employers header logo
    And   I navigate to page "Hiring"
    And   I should see text "Search Resumes"
    And   I should see text "Search millions of resumes"
    And   I should see text "Unlimited views and searches"
    And   I should see text "Up to 10k registrations daily"
    And   I should see text p tag "Only" and verify message "Only $279"

    And   I should see text "Post Jobs"
    And   I should see text "Post jobs for just $79"
    And   I should see text "Pay per application from just $3"
    And   I should see text "Jobs shared across 100+ sites"

    When  I click on learn more for search resumes
    Then  I should be able to see in browser as URL "Hiring Resume Search"
    When  I click on "Buy Now"
    Then  I should see text "Account Authentication Required"
    And   I should see text "Before you can make any purchases, we need to validate your account."
    And   I should see text p tag "Please call our team on " and verify message "Please call our team on 1-857-239-0143 and this will be validated instantly."
    Then  I close account authentication for recruiters

    Then  I navigate to page "Hiring"
    When  I click on learn more for post jobs
    Then  I should be able to see in browser as URL "Hiring Post Jobs"
    When  I click on "Buy Online"
    Then  I should see text "Account Authentication Required"
    And   I should see text "Before you can make any purchases, we need to validate your account."
    And   I should see text p tag "Please call our team on " and verify message "Please call our team on 1-857-239-0143 and this will be validated instantly."
    Then  I close account authentication for recruiters
    When  I click on "Learn More"
    Then  I should be able to see in browser URL "Hiring Pay For Performance Job Advertising"