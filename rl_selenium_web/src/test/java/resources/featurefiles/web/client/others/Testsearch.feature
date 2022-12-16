@TestSearch @Regression @Web  @Traffic
Feature: Client Others TestSearch

  Background: Test search form validation, registration
   Given I navigate to page "Hiring Resume Search"
    When I click on "Try for Yourself"
    Then I should be able to see in browser URL "Hiring Resume Search Test Search"

  @newTestSearch @ReleaseRegression2
  Scenario: New test search user journey
    Then I should see text "Millions of candidates."
    And  I should see text "Hundreds of sources."
    And  I should see text "One Resume Search."
    And  I should see text "Resume Search Tips"
    And  I should see text free instant search "FREE INSTANT SEARCH"
    And  I should see text "Millions of U.S. candidates on demand"
    When I enter email address with random client email
    And  I enter basic search keywords with "sales"
   # And  I enter location with "10001"
    And  I enter name field with "automation Testsearch"
    And  I enter client company name "resume-library"
    And  I enter phone number "123456789"
    Then I click on Search Resumes button
    Then I should see text on test search page "You have 10 resume views remaining | To view an unlimited number of resumes for free, call us on 1-800-672-6706 Start hiring"
    And  I should see text "Search Millions of Resumes"
    And   I select "Ever" from active within dropdown
    And   I click on Search Resumes
    And  I should see text "Preview Resume"
    And  I should see text "Create Alert"
    And  I should see text "Create Resume Alert"
    And  I should see text "Get candidates matching this search sent straight to your inbox"
    Then I scroll up 0,500
    And  I click on "Search Builder"
    Then I enter search builder keywords text area with "Tester"
    And  I enter location with "10011"
    And  I click on More Search Options
    And  I select option "10000" from Salary Min
    And  I select option "90000" from Salary Max
    And  I select "Ever" from active within dropdown
    When I click on Search Resumes
    Then I should see text "Sales"
    And  I should see text "Displaying 1 to "

  @newTestSearchRegistration
 Scenario: New test search user registration
    When I enter email address with random client email
    And  I enter basic search keywords with "sales"
    And  I enter name field with "automation Testsearch"
    And  I enter client company name "resume-library"
    And  I enter phone number "123456789"
    Then I click on Search Resumes button
    And  I should be on page "Client Resume Search Results"
    And  I select "Ever" from active within dropdown
    And  I click on Search Resumes
    And  I find a locked candidate and verify text "Unlock Resume"
    Then I should be able to see in browser URL "Client Resume View Candidate Profile Search"
    And  I click on "Unlock Resume"
    And  I should see text "Unlock this Resume"
    And  I should see "Single Unlock"
    And  I should see text "View the full resume"
    And  I should see text "Access the candidates' full contact details"
    And  I should see text p tag "Only" and verify message "Only $9.99"
    And  I should see "30 Day Access"
    And  I should see text "Unlimited resume searches and views"
    And  I should see text "Unlimited user licenses for your whole team"
    And  I should see text p tag "Only" and verify message "Only $279.00"
    And  I should see "We're here to help"
    And  I should see text p tag "Contact our team" and verify message "Contact our team on 1-800-672-6706 or sales@resume-library.com"
    And  I click on "Buy Now"
    Then I should be able to see in browser URL "Client Registration"
    And  I should see "To unlock a resume you need to register with Resume-Library."
    When I fill in Email address with random client email
    And  I enter first name "automation"
    And  I enter last name "client"
    And  I enter password "123456"
    And  I enter client company name "resume-library"
    And  I enter phone number "123456789"
    And  I click on "Enter address manually"
    And  I enter address "1st street"
    And  I enter city "Boston"
    And  I enter state "Massachusetts"
    And  I enter zip code "02108"
    And  I select option "Staffing Agency" from company type and size
    And  I click on "Register"
    Then I should be able to see in browser URL "Client Account"
    And  I should see text "Welcome to Resume-Library!"
    And  I should see "Before you can make any purchases we need to validate your account. Please call our team on 1-857-239-0143 to validate your account instantly."

  @testSearchValidation
  Scenario: Test search validation
    When I click on Search Resumes button
    Then I should see "Please enter some search criteria"
    And  I should see "Enter a location or select Nationwide"
    And  I should see "Name is required"
    And  I should see "Company name is required"
    And  I should see "Email is required"
    And  I should see "Phone number is required"
    When I fill in the field where id is "email_address" with: "test@"
    Then I should see "Please enter a valid email address"
    When I enter phone number "aaaaa"
    Then I should see "Phone number is not valid"