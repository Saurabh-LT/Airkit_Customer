@SearchJobNavigationBar @Regression @Web  @Search
Feature: Candidate JobSearch SearchJobsNavigationBar

  @SearchJobNavigationBarJobAlerts
  Scenario: Search for a job from Navigation bar job alerts
    Given I navigate to page "Job Alerts"
    And The search jobs navigation bar button has text "Find jobs"
    And I fill in search jobs nav bar keywords search with "Sales"
    And I fill in search jobs nav bar location search with "10001"
    And I select "60 Miles" from search distance
    And I click on search jobs
    Then I should be able to see in browser URL "/jobs/sales-in-10001?r=60"
    And I should see text H one tag "Sales jobs"
    And I should see text "Keywords/job title"
    And I should see text "Nearby Towns"

  @SearchJobNavigationBarJobAlertsAllJobs
  Scenario: Search for a job from Navigation bar job alerts all jobs
    Given I navigate to page "Job Alerts"
    And I click on search jobs
    Then I should be able to see in browser URL "Jobs"
    And I should see text H one tag "All jobs"
    And I should see text "Keywords/job title"
    And I should see text "Jobs By Location"