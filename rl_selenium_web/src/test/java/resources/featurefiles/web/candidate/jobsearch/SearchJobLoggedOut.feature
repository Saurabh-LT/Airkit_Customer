# Tests coverage
    # 1. Advanced Search job page with keyword and location, then asserting URL
    # 2. Advanced Search job page with all filters, then asserting URL

@SearchJobLoggedOut @Regression @Web  @Search
Feature: Candidate JobSearch SearchJobsLoggedOut

  Background: On search page with keyword sales
    Given I navigate to page "Search Jobs"

  @searchJobLoggedOutWithKeywordLocation
  Scenario: Search job page logged out test with keyword and location
    And   I fill in search title field with "sales"
    And   I fill in search location with "Brooklyn, NY"
    And   I click on Find Jobs search button
    Then  I should be able to see in browser URL "Jobs Sales In Brooklyn Ny"

  @searchJobLoggedOutWithAllParameters
  Scenario: Search job page logged out test with all values
    And   I select the option "50000" from Salary Min
    And   I select the option "70000" from Salary Max
    And   I select the option "Permanent" from Job Type
    And   I select the option "15" from Posted Since
    And   I fill in search title field with "sales"
    And   I fill in search location with "New York City, NY"
    When  I click on Find Jobs search button
    Then  I should be able to see in browser URL "Jobs Sales In New York City Ny Pd 15 Annual Salary From 50000 Annual Salary To 70000 Job Type Permanent"
    And   I should see text H one tag "Sales jobs"
   # And   I should see text "Nearby Towns"

  @searchPartnerJobLoggedOutWhenLessRLJobs
  Scenario: Search job page logged out, displaying partner jobs when < 20 RL jobs
    When  I navigate to page "Jobs Web Job"
    And   I should not see link "Save" with id "save_toggle_20"
    And   I should not see link "More" with id "more_20"
    And   I should not see link "Apply now" with id "apply_now_20"
    And   I should not see "»"
    And   I scroll down to element "Next"
    Then  I click on "Next"
    And   I should not see link "Save" with id "save_toggle_1"
    And   I should not see link "More" with id "more_1"
    And   I should see link "Apply now" with id "apply-now-partner-jobs-1"

  @searchPartnerJobLoggedOutWhenMoreRLJobs20
  Scenario: Search job page logged out, displaying partner jobs when > 19 RL jobs
    When  I navigate to page "Jobs Sales In New York"
    And   I should not see link "Save" with id "save_toggle_20"
    And   I should see link "Save" with id "save_toggle_15"
    And   I should see link "More" with id "more_15"
    And   I should see link "Apply Now" with id "apply_now_15"
    And   I should see link "Apply Now" with id "apply-now-partner-jobs-5"
    And   I scroll down to element "2"
    Then  I click on link "2"
    And   I should not see link "Save" with id "save_toggle_20"
    And   I should see link "Save" with id "save_toggle_15"
    And   I should see link "More" with id "more_15"
    And   I should see link "Apply now" with id "apply_now_15"
    And   I should see link "Apply now" with id "apply-now-partner-jobs-5"
    Then  I should be able to see in browser URL "/jobs/sales-in-new-york-city-ny?page_number=2"

  @searchPartnerJobLoggedOutWhenMoreRLJobs50PerPage
  Scenario: Search job page logged in, displaying partner jobs when > 44 RL jobs and 50 per page
    When  I browse the url "Search Jobs Sales In New York City Ny Per Page 50"
    And   I should see link using id "save_toggle_45"
    And   I should see link using id "more_45"
    And   I should see link using id "apply_now_45"
    And   I should not see link "Save" with id "save_toggle_50"
    And   I should see link "Apply now" with id "apply-now-partner-jobs-5"

  @searchPartnerJobLoggedOutWhenMoreRLJobs75PerPage
  Scenario: Search job page logged in, displaying partner jobs when > 69 RL jobs and 75 per page
    When  I browse the url "Search Jobs Sales In New York City Ny Per Page 75"
    And   I should see link using id "save_toggle_70"
    And   I should see link using id "more_70"
    And   I should see link using id "apply_now_70"
    And   I should not see link "Save" with id "save_toggle_71"
    And   I should see link "Apply now" with id "apply-now-partner-jobs-5"

  @searchPartnerJobLoggedOutWhenMoreRLJobs100PerPage
  Scenario: Search job page logged in, displaying partner jobs when > 94 RL jobs and 100 per page
    When  I browse the url "Search Jobs Sales In New York City Ny Per Page 100"
    And   I should see link using id "save_toggle_95"
    And   I should see link using id "more_95"
    And   I should see link using id "apply_now_95"
    And   I should not see link "Save" with id "save_toggle_96"
    And   I should see link "Apply now" with id "apply-now-partner-jobs-5"

  @featuredJobsLoggedOut
  Scenario: As a logged out user, verify 'Featured Jobs' section
    When  I navigate to page "Jobs"
    And   I should see text "Featured Jobs"
    Then  I click on Featured jobs one
    And   I switch tab
    Then  I should be able to see in browser URL "Job View"
    And   I should see text "Create a new Job Alert to make sure you see the best new jobs first!"

  @hideJobsLoggedOutReasonOne
  Scenario: As a logged out user, verify 'Hide Jobs' functionality reason one
    And   I fill in search title field with "sales"
    And   I fill in search location with "Brooklyn, NY"
    When  I click on Find Jobs search button
    And   I should be on page "Jobs"
    And   I click on id starts with "search_hide_result"
    Then  I should see text "This job will be hidden from all searches"
    When  I click on id starts with "search_hide_tell_us"
    Then  I should see text "I've already applied or viewed this job"
    And   I should see text "It's irrelevant"
    And   I should see text "Other"
    When  I click on id ends with "_0_0"
    Then  I should see "Thank you for your feedback"

  @hideJobsLoggedOutReasonTwo
  Scenario: As a logged out user, verify 'Hide Jobs' functionality reason two
    And   I fill in search title field with "sales"
    And   I fill in search location with "Brooklyn, NY"
    When  I click on Find Jobs search button
    And   I should be on page "Jobs"
    And   I click on id starts with "search_hide_result"
    Then  I should see text "This job will be hidden from all searches"
    When  I click on id starts with "search_hide_tell_us"
    Then  I should see text "I've already applied or viewed this job"
    And   I should see text "It's irrelevant"
    And   I should see text "Other"
    When  I click on id ends with "_0_1"
    Then  I should see "Thank you for your feedback"

  @hideJobsLoggedOutReasonOther
  Scenario: As a logged out user, verify 'Hide Jobs' functionality reason other
    And   I fill in search title field with "sales"
    And   I fill in search location with "Brooklyn, NY"
    When  I click on Find Jobs search button
    And   I should be on page "Jobs"
    And   I click on id starts with "search_hide_result"
    Then  I should see text "This job will be hidden from all searches"
    When  I click on id starts with "search_hide_tell_us"
    Then  I should see text "I've already applied or viewed this job"
    And   I should see text "It's irrelevant"
    And   I should see text "Other"
    When  I click on id ends with "_2"
    Then  I should see text "Tell us more about why you don't want to see this job" on the page
    When  I enter reasons other input "Regression testing"
    And   I click on "Submit"
    Then  I should see "Thank you for your feedback"

  @hideJobsLoggedOutUndo
  Scenario: As a logged out user, verify 'Hide Jobs' functionality undo
    And   I fill in search title field with "sales"
    And   I fill in search location with "Brooklyn, NY"
    When  I click on Find Jobs search button
    And   I should be on page "Jobs"
    And   I click on id starts with "search_hide_result"
    Then  I should see text "This job will be hidden from all searches"
    When  I click on id starts with "search_hide_tell_us"
    Then  I should see text "I've already applied or viewed this job"
    And   I should see text "It's irrelevant"
    And   I should see text "Other"
   Then   I click on id starts with "search_hide_undo"