@ClientRegistration @Regression @Web  @ReleaseRegression2 @Recruiters
Feature: Client Registration Registration

  @clientValidRegistration @ClientE2E
  Scenario Outline: Register a new client with all details
    Given I navigate to page "Client Registration"
    When  I enter email address "<Email>"
    And   I enter first name "<FirstName>"
    And   I enter last name "<LastName>"
    And   I enter password "<Password>"
    And   I enter client company name "<CompanyName>"
    And   I enter phone number "<Phone>"
    And   I click on enter address manually link
    And   I enter address one "<Address>"
    And   I enter city "<City>"
    And   I enter state "<State>"
    And   I enter zip code "<Zipcode>"
    And   I select "<Type>" from recruiter type
    And   I click on Submit inquiry
    Then  I should be on page "Client Account"
    And   I should see text "Welcome to Resume-Library!"
    And  I should see text "Before you can make any purchases we need to validate your account. Please call our team on 1-857-239-0143 to validate your account instantly."

    Examples:
      | Email                           | FirstName  | LastName | Password | Address    | CompanyName    | City   | Phone        | State         | Zipcode | Type            |
      | registration@resume-library.com | automation | client   | 123456   | 1st street | resume-library | Boston | 012345678912 | Massachusetts | 02108   | Staffing Agency |