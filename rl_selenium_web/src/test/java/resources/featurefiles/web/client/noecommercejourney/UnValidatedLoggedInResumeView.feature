@NoEcommerceUnvalidatedLoggedInClient @Regression @Web  @ReleaseRegression2 @Recruiters
Feature: Client NoEcommerceJourney UnValidatedLoggedInResumeView

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

  @NoEcommerceUnvalidatedLoggedInClientResumeView
  Scenario: As an unvalidated logged in client with E-commerce disabled I do not want to see products on resume view page
    When  I navigate to page "Client Resume Search With Keywords"
    And   I should be able to see in browser URL "Client Resume Search Results"
    And   I should see element with id "save_this_search" to be "visible"
    And   I find a locked candidate and click on unlock resume
    Then  I should see text "To purchase this product, contact your account manager on:"
    Then  I should see text "1-800-672-6706"
    And   I should see text "sales@resume-library.com"
    Then  I close purchase product popup for unlock resume
    And   I should see element "Download Resume" is disabled

    When  I click on main number view contact details
    Then  I should see text "To purchase this product, contact your account manager on:"
    Then  I should see text "1-800-672-6706"
    And   I should see text "sales@resume-library.com"
    Then  I close purchase product popup for unlock resume

    When  I click on main email address view contact details
    Then  I should see text "To purchase this product, contact your account manager on:"
    Then  I should see text "1-800-672-6706"
    And   I should see text "sales@resume-library.com"
    Then  I close purchase product popup for unlock resume

    When  I click on "Download Resume" on view resume page
    Then  I should see text "To purchase this product, contact your account manager on:"
    Then  I should see text "1-800-672-6706"
    And   I should see text "sales@resume-library.com"
    Then  I close purchase product popup for unlock resume

    When  I click on "Video Interview" on view resume page
    Then  I should see text "To purchase this product, contact your account manager on:"
    Then  I should see text "1-800-672-6706"
    And   I should see text "sales@resume-library.com"
    Then  I close purchase product popup for unlock resume

    When  I click on "Email Resume" on view resume page
    Then  I should see text "To purchase this product, contact your account manager on:"
    Then  I should see text "1-800-672-6706"
    And   I should see text "sales@resume-library.com"
    Then  I close purchase product popup for unlock resume