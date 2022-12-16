@NoEcomUnvalidatedLoggedInManageJobsJourney @Regression @Web  @Recruiters
Feature: Client NoEcommerceJourney UnValidatedLoggedInManageJobs

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
    And   I select Disable Ecomm "Yes"
    And   I click on update account
    Then  I should see text "was successfully updated."

  @NoEcomUnvalidatedLoggedInManageJobs
  Scenario: As an unvalidated logged in client with E-commerce disabled Post A Job
    Given I navigate to page "Client Account"
    Then  I click on "Post a Job"
    Then  I should see text "To purchase this product, contact your account manager on:"
    Then  I should see text "1-800-672-6706"
    And   I should see text "sales@resume-library.com"
    Then  I close post a job popup

  @NoEcommUnvalidatedClientPostJobsNow @ReleaseRegression2
  Scenario: as an unvalidated logged in client with E-commerce disabled verify post jobs now
    Given I navigate to page "Client Account"
    Then  I navigate to page "Client Resume Search With Keywords"
    And   I should be able to see in browser URL "Client Resume Search Results"
    And   I should see text "Post Jobs Now"
    When  I click on "Post Jobs Now"
    Then  I should see text "To purchase this product, contact your account manager on:"
    Then  I should see text "1-800-672-6706"
    And   I should see text "sales@resume-library.com"