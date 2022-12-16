# Test Coverage
# 1. Save a search from resume search
# 2. Assert on saved search page
# 3. Confirm saved search actions Run, Modify, Delete
@savedResumeSearches @Regression @Web  @Search
Feature: Client ResumeSearch SavedSearches

  Background: Client Login
    Given I login as a client

  @resumeSearchSavedSuccess @ReleaseRegression2
  Scenario: Searching for resume on basic tab saved success
    Given I navigate to page "Client Saved Search"
    Then  I delete saved search
    When  I navigate to page "Client Resume Search"
    And   I fill in basic search keywords with "test analyst"
    And   I enter location with "10010"
    And   I click on Search Resumes
    Then  I should be able to see in browser URL "Client Resume Search Results"
    And   I click on "Save this Search"
    And   I should see element with text "Search name" to be "visible"
    Then  I enter saved search name with "Test Search"
    And   I click on Save search submit button
    Then  I should see text "Search saved successfully!"
    And   I navigate to page "Client Saved Search"
    And   I click on saved search actions one
    And   I click on link text "Delete"
    Then  I click on save search delete btn
    And   I should see text "Search removed successfully"

  @clientSavedSearches
  Scenario: Saved Resume Searches
    Given I navigate to page "Client Saved Search"
    Then  I delete saved search
    When  I navigate to page "Client Resume Search"
    And   I fill in basic search keywords with "test analyst"
    And   I enter location with "10010"
    And   I select "Ever" from active within dropdown
    And   I click on Search Resumes
    Then  I should be able to see in browser URL "Client Resume Search Results"
    And   I click on "Save this Search"
    Then  I enter saved search name with "Test Search"
    And   I click on Save search submit button
    Then  I should see text "Search saved successfully!"
    And   I navigate to page "Client Saved Search"
    Then  I should see text "Personal Saved Searches"
    Then  I should see text "Account Saved Searches"
    And   I click on saved search actions one
    And   I click on run saved search one
    Then  I should be able to see in browser URL "Client Resume Search Results"
    And   I move backward one page
    And   I click on saved search actions one
    And   I click on "Modify"
    Then  I should be able to see in browser URL "Client Resume Search Update"
    And   I move backward one page
    And   I click on saved search actions one
    And   I click on link text "Delete"
    Then  I click on save search delete btn
    And   I should see text "Search removed successfully"

  @accountSavedSearches
  Scenario: Account Saved Resume Searches
    Given I navigate to page "Client Saved Search Account"
    And   I click on saved search actions one
    And   I click on run saved search one
    Then  I should be able to see in browser URL "Client Resume Search Results"
    And   I should see text "Search Millions of Resumes"

  @sortAccountSavedSearches
  Scenario: Sort Saved Resume Searches
    Given I navigate to page "Client Saved Search Account"
    And   I sort the saved searches names in ascending order
    Then  I should see text ""
    And   I sort the saved searches names in descending order
    Then  I should see text "Wordpress"
    And   I sort the saved searches keywords in descending order
    Then  I should see text "wordpress"
    And   I sort the saved searches keywords in ascending order
    Then  I should see text "accounts"