@JobView  @Regression @Web  @Traffic
Feature: Candidate JobView JobView

  @jobViewSuccess @ReleaseRegression1 @CandidateE2EExcluded
  Scenario: Job view as a candidate
    Given I navigate to page "Jobs Sales"
    When  I Click on Job Title
    And   I switch tab
    Then  I should be able to see in browser URL "Job View"
    And   I should see text "Keywords" label tag
    And   I should see text "Location"
    And   I should see text "Create a new Job Alert to make sure you see the best new jobs first!"
    And   I should see Save button

  @expiredJobView @ReleaseRegression1
  Scenario: Expired job view as a candidate
    Given I navigate to page "Jobs View For 3509582"
    Then  the response code should be 410
    And   I should see text div tags "The position" and verify "The position Experienced Class A CDL Drivers - Flatbed in Chattanooga, Tennessee is no longer available."
    And   I should see link "Posted by" with id "job-details-posted"

  @jobViewRecentlyViewedJobs
  Scenario: Job view as a candidate recently viewed jobs
    Given I navigate to page "Jobs Non External Test Jobs"
    When  I Click on Job Title
    And   I switch to window 1
    Then  I should not see "Recently viewed jobs" text
    When  I navigate to page "Jobs QA"
    And   I Click on Job Title
    And   I switch to window 2
    Then  I should see text "Recently viewed jobs"
    And   I click on recent job title
    Then  I should be able to see in browser URL "Job View"
    And   I should see Save button
    When  I navigate to page "Job Automation"
    When  I Click on Job Title
    And   I switch to window 3
    When  I navigate to page "Jobs Tester"
    And   I click on "Automation jobs"
    Then  I should be able to see in browser URL "Jobs Automation"

  @nationalJobsBannerOnJobView
  Scenario: Verify National jobs banner on job view
    When  I navigate to page "Jobs"
    And   I Click on Job Title
    And   I switch tab
    Then  I should be able to see in browser URL "Job View"
    And   I should see text "National Job"

  @featuredJobsBannerOnJobView
  Scenario: Verify Featured jobs banner on job view
    Given I login as a client
    When  I navigate to page "Job Post"
    And   I enter job title "Drummer"
    And   I select "California" from state dropdown
    And   I enter city "90001"
    And   I enter salary min "10000"
    And   I enter salary max "30000"
    And   I enter job description "Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job"
    And   I click on preview button
    And   I click on post job button
    And   I click on post job submit button
    Then  I should be able to see in browser URL "Client Jobs New Job Posted"
    And   I should see text "Job Posted Successfully!"
    And   I mouse hover to users profile
    And   I click "Logout" button
    When  I navigate to page "Jobs Drummer"
    And   I Click on Job Title
    And   I switch tab
    Then  I should be able to see in browser URL "Job View"
   #And   I should see text span tags "Featured"

  @premiumJobsHasNoBannerOnJobView
  Scenario: Verify Premium jobs has no banner on job view
    When I navigate to page "Job View For 25759485"
    Then I should see text H one tag "Partner Account Manager"
    And  I should see "Remote, US based"
    And  I should not see "Featured" text

  @JobIdContainsStringOnJobView404Redirect
  Scenario: Verify job id containing a string job view redirects to 404 page
    When I navigate to page "Job View ABC"
    Then  I should see text H one tag "Page not found"
    And  I should see "/job/view/abc"
    And  I should be able to see in browser URL "Job View Abc"

  @JobIdNotInDatabaseOnJobView404Redirect
  Scenario: Verify job id not in database on job view redirects to 404 page
    When I navigate to page "Job View For 11740"
    Then  I should see text H one tag "Page not found"
    And  I should see "/job/view/11740"
    And  I should be able to see in browser URL "/job/view/11740"

  @JobIdIsTemplateOnJobView404Redirect
  Scenario: Verify job id is template on job view redirects to 404 page
    When I navigate to page "Job View 12572172"
    Then  I should see text H one tag "Page not found"
    And  I should see "/job/view/12572172"
    And  I should be able to see in browser URL "/job/view/12572172"