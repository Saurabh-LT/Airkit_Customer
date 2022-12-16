@JobApplySearchResults @Regression @Web  @Candidate
Feature: Candidate JobApply FromSearchResults

  @jobApplySearchResultsLoggedOut
  Scenario: Job apply popup as logged out
    Given   I navigate to page "Jobs Non External Test Jobs"
    When    I click on apply now
    Then    I should see "Not registered"

  #Scenario: Apply for job after registering a new candidate profile
  @jobApplySearchResultsRegister @ReleaseRegression1
  Scenario: Job apply after registering a new candidate
    Given   I navigate to page "Candidate Registration"
    When    I register as a new candidate resume check
    When    I navigate to page "Jobs Non External Test Jobs"
    When    I click on non external job to apply
    And     I switch tab
    And     I should be able to see in browser URL "Job Apply"
    Then    I should see text "you're applying for:"
    When    I enter phone number "012345678912"
    And     I click on send application button
    And     I should be able to see in browser URL "Job Apply Confirm"
    And     I reload the page
    And     I should see text "Application sent - the employer will be in touch if you are successful"

  @jobApplySearchResultsLoggedIn
  Scenario: Job apply from search results page after logging into an account
    Given   I login as a candidate
    And     I navigate to page "Jobs Non External Test Jobs"
    When    I click on non external job to apply
    And     I switch tab
    Then    I should be able to see in browser URL "Job Apply"
    And     I should see text "you're applying for"