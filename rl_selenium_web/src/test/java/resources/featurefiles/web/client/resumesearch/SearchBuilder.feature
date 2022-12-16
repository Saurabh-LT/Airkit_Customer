@ResumeSearchBuilder @Regression @Web  @Search
Feature: Client ResumeSearch SearchBuilder

  Background: On Search builder resume search page
    Given I login as a client
    And   I navigate to page "Client Resume Search"
    And   I click on "Search Builder"

  #Scenario: Log in as a client and perform a resume search using the search builder
  @resumeSearchBuilderSuccess @ReleaseRegression2
  Scenario: Searching for resume on the search builder tab
    When  I enter search builder keywords text area with "sales"
    And   I click on More Search Options
    And   I select "Ever" from active within dropdown
    And   I click on Search Resumes
    Then  I should be able to see in browser URL "Client Resume Search Results"
    And   I should see text "Preview Resume"
    And   I should see text "Invite Candidates"
    And   I should see text "Post Jobs Now"

  @resumeSearchBuilderSuccessByCandidateId
  Scenario: Searching for resume on builder tab by candidate id
    And   I enter search builder keywords text area with candidate id
    And   I click on More Search Options
    And   I select "Ever" from active within dropdown
    And   I click on Search Resumes
    And   I should see resume search results displaying text "Displaying 1 to 1 of 1 Resumes matched"

  @resumeSearchBuilderNoneFoundByCandidateId
  Scenario: Searching for resume on builder tab none found by candidate id
    And   I enter search builder keywords text area with invalid candidate id
    And   I click on Search Resumes
    And   I should see resume search results displaying text "Displaying 0 Resumes matched"
