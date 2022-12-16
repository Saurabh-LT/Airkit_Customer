@ResumeSearchBasic @Regression @Web  @Search
Feature: Client ResumeSearch Basic

  Background: On basic resume search page
    Given I login as a client
    When  I navigate to page "Client Resume Search"

  @resumeSearchBasicSuccess @ReleaseRegression2 @ClientE2E
  Scenario: Searching for resume on basic tab
    And   I fill in basic search keywords with "sales"
    And   I select "Ever" from active within dropdown
    And   I click on Search Resumes
    Then  I should be able to see in browser URL "Client Resume Search Results"
    And   I should see text "Preview Resume"

  @resumeSearchBasicSuccessByCandidateId @ReleaseRegression2
  Scenario: Searching for resume on basic tab by candidate id
    And   I enter basic search keywords with candidate id
    And   I select "Ever" from active within dropdown
    And   I click on Search Resumes
    And   I should see resume search results displaying text "Displaying 1 to 1 of 1 Resumes matched"

  @resumeSearchBasicNoneFoundByCandidateId
  Scenario: Searching for resume on basic tab none found by candidate id
    And   I enter basic search keywords with invalid candidate id
    And   I click on Search Resumes
    And   I should see resume search results displaying text "Displaying 0 Resumes matched"