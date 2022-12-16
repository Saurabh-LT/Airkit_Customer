@NoEcomValidatedClientPurchase @Regression @Web  @Recruiters
Feature: Client NoEcommerceJourney ValidatedProductsJourney

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
    And   I should see element with text "Product Details" to be "visible"
    And   I click on product details Edit button
    And   I should see element with id "disable_ecomm" to be "visible"
    And   I scroll down 0,700
    And   I select Disable Ecomm "Yes"
    And   I click on update account
    Then  I click on actions btn
    And   I click on "Validate account"
    And   I confirm browser popup

  @NoEcomValidatedClientPurchaseProducts @ReleaseRegression2
  Scenario: as an validated logged in client with E-commerce disabled I do not want to see products that I can purchase
    Given I navigate to page "Client Account"
    And   I should see text "Products"
    When  I mouse hover "Products"
    Then  I should not see text "Contact Credits"
    And   I should not see text "Job postings"
    When  I click on "Products"
    Then  I should be able to see in browser URL "Hiring Products"
    And   I should see text H one tag "Our Hiring Products"

  @NoEcommerceValidatedProductsPurchaseHistory
  Scenario: verify as an validated logged in client purchase history
    Given I navigate to page "Client Account"
    When  I mouse hover "Hi Automation"
    Then  I should see text "Purchase History"
    When  I click on "Purchase History"
    Then  I should see text "To purchase this product, contact your account manager on:"
    Then  I should see text "1-800-672-6706"
    And   I should see text "sales@resume-library.com"

  @NoEcommValidatedClientVerifyEmployersLogo
  Scenario: as an validated logged in client with E-commerce disabled verify employers logo
    Given I navigate to page "Client Account"
    When  I click on the RL Employers header logo
    Then  I am on page "Hiring"

  @NoEcommValidatedClientInviteToApply1
  Scenario: as an validated logged in client with E-commerce disabled verify resume search invite to apply
    Given I navigate to page "Client Resume Search With Keywords"
    Then  I should see text "Invite Candidates"
    Then  I select email candidate amount from list
    And   I click on "Invite Candidates"
    Then  I should see text "To purchase this product, contact your account manager on:"
    Then  I should see text "1-800-672-6706"
    And   I should see text "sales@resume-library.com"

  @NoEcommValidatedClientInviteToApply2
  Scenario: as an validated logged in client with E-commerce disabled verify resume search select all checkbox invite to apply
    Then  I navigate to page "Client Resume Search With Keywords"
    And   I should be able to see in browser URL "Client Resume Search Results"
    Then  I should see text "Invite Candidates"
    And   I should see text "Select all " on the page source
    When  I tick Select all checkbox
    Then  I should see all Resume(s) selected
    And   I should see element with text "Choose action" to be "visible"
    And   I select option "Invite to Apply" from resumes selected
    Then  I should see text "To purchase this product, contact your account manager on:"
    Then  I should see text "1-800-672-6706"
    And   I should see text "sales@resume-library.com"

  @NoEcommValidatedClientBanner
  Scenario: As a logged in validated user not on the ecommerce journey,  I should not any banners advertising products i.e. 3-month Resume Search banners nor 30-Day resume search and Post Your Job gif
    And   I navigate to page "Resources"
    Then  I scroll down 0,600
    And   I should not see resources-3-month-banner "3-month Resume Search"
    And   I should not see resources-switch-banner "Resume Search"
    And   I should not see resources-switch-banner "Post A Job"