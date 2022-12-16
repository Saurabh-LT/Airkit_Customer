@JobApplyCompanyProfile @Regression @Web  @Candidate
Feature: Candidate JobApply FromCompanyProfile

  #Scenario: A user navigates to a company profile while not logged into an account. The user clicks to apply for the
  #job and is asked to log-in or register
  @jobApplyCompanyProfileLoggedOut
  Scenario: Job apply popup from company profile page
    Given I am on page "Company 28692 Acme Company No 818952 Jobs"
    When I click on apply now
    Then I should see text "Already have an account?"
    Then I should see text "Not registered?"

  #Scenario: Registers a new candidate to the site, navigates to a company profile and applies for the first job
  @jobApplyCompanyProfileNewCandidate
  Scenario: Job apply from company profile page after registering
    Given I navigate to page "Candidate Registration"
    Then I register as a new candidate resume check
    When I go to page "Company 1478 Acme Company No 1728 Jobs"
    When I find a non external job to apply for
    And I switch tab
    Then I should be able to see in browser URL "Job Apply"
    And I should see text "you're applying for"

  #Scenario: Logs a candidate into their account, navigates to a company profile and applies for a job they have not
  #already applied for
  @jobApplyCompanyProfileLoggedIn @ReleaseRegression1
  Scenario: Job apply from company profile page after logging into an account
    Given I login as a candidate
    And I am on page "Company 1478 Acme Company No 1728 Jobs"
    When I find a non external job to apply for
    And I switch tab
    Then I should be able to see in browser URL "Job Apply"
    And I should see text "you're applying for"