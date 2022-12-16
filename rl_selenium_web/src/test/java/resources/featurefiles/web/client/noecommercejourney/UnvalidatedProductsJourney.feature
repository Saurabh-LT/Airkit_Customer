@NoEcomUnvalidatedClientPurchase @Regression @Web  @Recruiters
Feature: Client NoEcommerceJourney UnValidatedProductsJourney

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
    And   I should see element with id "disable_ecomm" to be "visible"
    And   I scroll down 0,700
    And   I select Disable Ecomm "Yes"
    And   I click on update account

  @NoEcomUnvalidatedClientPurchaseProducts
  Scenario: As an unvalidated logged in client with E-commerce disabled I do not want to see products option
    When  I navigate to page "Client Account"
    And   I should see text "Products"
    When  I mouse hover "Products"
    Then  I should not see text "Contact Credits"
    And   I should not see text "Job postings"
    When  I click on "Products"
    Then  I should be able to see in browser URL "Hiring Products"
    And   I should see text H one tag "Our Hiring Products"

    #XT-1487  logged In Headers -Unvalidated ecomm disabled
    When  I navigate to page "Resources"
    And   I should see text "Products"
    When  I mouse hover "Products"
    Then  I should not see text "Contact Credits"
    And   I should not see text "Job postings"
    When  I click on "Products"
    #Then  I should be able to see in browser URL "Hiring Products"

  @NoEcommerceUnvalidatedProductsPurchaseHistory
  Scenario: verify as an unvalidated logged in client purchase history
    When  I navigate to page "Client Account"
    When  I mouse hover "Hi Automation"
    Then  I should see text "Purchase History"
    When  I click on "Purchase History"
    Then  I should see text "To purchase this product, contact your account manager on:"
    Then  I should see text "1-800-672-6706"
    And   I should see text "sales@resume-library.com"
    Then  I close account authentication required popup

  @NoEcommUnvalidatedClientVerifyEmployersLogo
  Scenario: as an unvalidated logged in client with E-commerce disabled verify employers logo
    When  I navigate to page "Client Account"
    When  I click on the RL Employers header logo
    Then  I should be on page "Hiring"

  @NoEcommUnvalidatedClientInviteToApply1
  Scenario: as an unvalidated logged in client with E-commerce disabled verify resume search invite to apply
    When  I navigate to page "Client Resume Search With Keywords"
    Then  I should see text "Invite Candidates"
    Then  I select email candidate amount from list
    And   I click on "Invite Candidates"
    Then  I should see text "To purchase this product, contact your account manager on:"
    Then  I should see text "1-800-672-6706"
    And   I should see text "sales@resume-library.com"

  @NoEcommUnvalidatedClientInviteToApply2
  Scenario: as an unvalidated logged in client with E-commerce disabled verify resume search select all checkbox invite to apply
    When  I navigate to page "Client Account"
    Then  I navigate to page "Client Resume Search With Keywords"
    And   I should be able to see in browser URL "Client Resume Search Results"
    Then  I should see text "Invite Candidates"
    And   I should see text "Select all " on the page source
    When  I tick Select all checkbox
    Then  I should see all Resume(s) selected
    And   I select option "Invite to Apply" from resumes selected
    Then  I should see text "To purchase this product, contact your account manager on:"
    Then  I should see text "1-800-672-6706"
    And   I should see text "sales@resume-library.com"