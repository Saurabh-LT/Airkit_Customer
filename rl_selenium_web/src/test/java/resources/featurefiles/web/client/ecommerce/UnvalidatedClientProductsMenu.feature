@EcommerceUnvalidatedClientProductsJourney @Regression @Web  @Recruiters
Feature: Client Ecommerce UnvalidatedClientProductsMenu

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

  @EcommerceProductsContactCredits
  Scenario: as an unvalidated logged in client I expect to see Contact credit products that I can purchase
    Given I navigate to page "Client Account"
    And   I should see text "Products"
    When  I mouse hover "Products"
    Then  I should see text "Contact Credits"
    When  I click on "Contact Credits"
    Then  I should be able to see in browser URL "Client Products Contact Credits"
    And   I should see text H two tag "30-day Resume Search"
    And   I should see text H two tag "Starter Package"
    And   I should see text H two tag "Multiple User Packages"
   #And   I add checks for text and prices of above modules

    When  I click 30-day Resume Search Buy Online
    Then  I should see text "Account Authentication Required"
    And   I should see text "Before you can make any purchases, we need to validate your account."
    And   I should see text p tag "Please call our team on " and verify message "Please call our team on 1-857-239-0143 and this will be validated instantly."
    Then  I close account authentication for client products

    When  I click starter package Buy Online
    Then  I should see text "Account Authentication Required"
    And   I should see text "Before you can make any purchases, we need to validate your account."
    And   I should see text p tag "Please call our team on " and verify message "Please call our team on 1-857-239-0143 and this will be validated instantly."
    Then  I close account authentication for client products

    When  I click on Request pricing
    Then  I should see text "Thanks for your request"
    And   I should see text "Please expect a call from us shortly"
    And   I should see text "Go to dashboard"
    When  I click on "Go to dashboard"
    Then  I should be able to see in browser URL "Client Account"

  @EcommerceProductsJobPostings
  Scenario: as an unvalidated logged in client I expect to see job posting products that I can purchase
    Given I navigate to page "Client Account"
    And   I should see text "Products"
    When  I mouse hover "Products"
    Then  I should see text "Job Postings"
    When  I click on "Job Postings"
    Then  I should be able to see in browser URL "Client Products Jobs"

    And   I should see text H two tag "Featured Job Posting"
    And   I should see text "Special offer - Save $70"
    And   I should see text "Jobs shared across hundreds of sites"
    And   I should see text "Top matched resumes sent to your inbox"
    And   I should see text "Fully branded job postings"
    And   I should see text "Dedicated customer support"
    And   I should see text H two tag "Greater Hiring Needs?"
    And   I should see text "Contact us to discuss our hiring packages"
    And   I should see text "sales@resume-library.com"
    And   I should see text "Request pricing"

    When  I click on "Buy online"
    Then  I should see text "Account Authentication Required"
    And   I should see text "Before you can make any purchases, we need to validate your account."
    And   I should see text p tag "Please call our team on " and verify message "Please call our team on 1-857-239-0143 and this will be validated instantly."
    Then  I close account authentication for client products

    When  I click on Request pricing
    Then  I should see text "Thanks for your request"
    And   I should see text "Please expect a call from us shortly"
    And   I should see text "Go to dashboard"
    When  I click on "Go to dashboard"
    Then  I should be able to see in browser URL "Client Account"

  @EcomUnValidatedClientPurchaseHistory
  Scenario: verify as an unvalidated logged in client with ecommerce enabled purchase history
    Given I navigate to page "Client Account"
    When  I mouse hover "Hi Stephanie"
    Then  I should see text "Purchase History"
    When  I click on "Purchase History"
    Then  I should see text "Account Authentication Required"
    And   I should see text "Before you can make any purchases, we need to validate your account."
    And   I should see text p tag "Please call our team on " and verify message "Please call our team on 1-857-239-0143 and this will be validated instantly."

  @EcommUnvalidatedClientPostJobsNow
  Scenario: as an unvalidated logged in client with E-commerce enabled verify post jobs now
    Given I navigate to page "Client Account"
    Then I navigate to page "Client Resume Search With Keywords"
    And   I should be able to see in browser URL "Client Resume Search Results"
    And   I wait for "2" seconds
    And   I should see text "Post Jobs Now"
    When  I click on "Post Jobs Now"
    Then  I should see text "Account Authentication Required"
    And   I should see text "Before you can make any purchases, we need to validate your account."
    And   I should see text p tag "Please call our team on " and verify message "Please call our team on 1-857-239-0143 and this will be validated instantly."

  @EcommUnvalidatedLoggedInClientPosJobResumeSearch
  Scenario: as an unvalidated logged in client with E-commerce enabled verify gif that alternately displays 30-Day resume search and Post Your Job
    Given I navigate to page "Resources"
    And   I scroll down 0,600
    And   I should see resources-switch-banner "Resume Search"
    Then  I should be able to see in browser http URL "Hiring Resume Search"
    When  I navigate to page "Resources"
    Then  I scroll down 0,600
    And   I should see resources-switch-banner "Post A Job"
    Then  I should be able to see in browser http URL "Hiring Post Jobs"


  @EcommUnvalidatedLoggedInClientLimit10ResumeView
  Scenario: as an unvalidated client I should be limited to 10 resume views from  /client/resume-search
    Given I navigate to page "Client Resume Search"
    Then  I should see text on test search page "You have 10 resume views remaining | To view more resumes, we need to validate your account first. Please call us on 1-857-239-0143 and a member of our team can arrange this for you."
    And   I navigate to page "Client Resume Search With Keywords"
    And   I should be able to see in browser URL "Client Resume Search Results"
    And   I should see text on test search page "You have 10 resume views remaining | To view more resumes, we need to validate your account first. Please call us on 1-857-239-0143 and a member of our team can arrange this for you."
    When  I click on preview resume "1"
    Then  I should see text on test search page "You have 9 resume views remaining | To view more resumes, we need to validate your account first. Please call us on 1-857-239-0143 and a member of our team can arrange this for you."
    When  I click on preview resume "2"
    Then  I should see text on test search page "You have 8 resume views remaining | To view more resumes, we need to validate your account first. Please call us on 1-857-239-0143 and a member of our team can arrange this for you."
    When  I click on preview resume "3"
    Then  I should see text on test search page "You have 7 resume views remaining | To view more resumes, we need to validate your account first. Please call us on 1-857-239-0143 and a member of our team can arrange this for you."
    When  I click on preview resume "4"
    Then  I should see text on test search page "You have 6 resume views remaining | To view more resumes, we need to validate your account first. Please call us on 1-857-239-0143 and a member of our team can arrange this for you."
    When  I click on preview resume "5"
    Then  I should see text on test search page "You have 5 resume views remaining | To view more resumes, we need to validate your account first. Please call us on 1-857-239-0143 and a member of our team can arrange this for you."
    When  I click on preview resume "6"
    Then  I should see text on test search page "You have 4 resume views remaining | To view more resumes, we need to validate your account first. Please call us on 1-857-239-0143 and a member of our team can arrange this for you."
    When  I click on preview resume "7"
    Then  I should see text on test search page "You have 3 resume views remaining | To view more resumes, we need to validate your account first. Please call us on 1-857-239-0143 and a member of our team can arrange this for you."
    When  I click on preview resume "8"
    Then  I should see text on test search page "You have 2 resume views remaining | To view more resumes, we need to validate your account first. Please call us on 1-857-239-0143 and a member of our team can arrange this for you."
    When  I click on preview resume "9"
    Then  I should see text on test search page "You have 1 resume views remaining | To view more resumes, we need to validate your account first. Please call us on 1-857-239-0143 and a member of our team can arrange this for you."
    When  I click on preview resume "10"
    Then  I should see text on test search page "You have used all your resume views | To view more resumes, we need to validate your account first. Please call us on 1-857-239-0143 and a member of our team can arrange this for you."