@JobSearchViewOptions @Regression @Web  @Search
Feature: Candidate JobView JobViewSearch

  @candidateJobViewOptions @ReleaseRegression1
  Scenario: Verify the more, save, print, email and share buttons on job view
    Given I am on page "/"
    When  I fill in search title field with "Nonexternaltestjobs"
    And   I click on Find Jobs search button
    Then  I should be on page "Jobs Nonexternaltestjobs"
    And   I Click on Job Title
    And   I switch tab
    Then  I should be able to see in browser URL "Job View"
    And   I should see Save button
    And   I should see link "Print" with id "print-job"
    And   I should see link "Share" with id "share-job"

  @candidateJobViewPagURL
  Scenario: Verify the job title is displayed in the job view page URL
    Given I am on page "/"
    When  I fill in search title field with "Sales"
    And   I click on Find Jobs search button
    Then  I should be able to see in browser URL "Jobs Sales"
    And   I Click on Job Title
    And   I switch tab
    Then  I should be able to see "sales" in browser url

  @candidateJobViewPagURLSimilarJobs @Nirupan
  Scenario: Verify the job title is displayed in the job view page URL for similar jobs
    Given I am on page "/"
    When  I fill in search title field with "Sales"
    And   I click on Find Jobs search button
    Then  I should be on page "Jobs Sales"
    And   I Click on Job Title
    And   I switch to window 1
    Then  I should be able to see "sales" in browser url
    And   I wait for similar jobs to load
    And   I Click on job from Similar Jobs
    And   I switch tab2
    Then  I should be able to see "sales" in browser url

  @JobViewSimilarJobsModule
  Scenario: Similar jobs module for external jobs should not cause a 404
    And    I am on page "Job View Sales Lead For 37890455"
    Then   I should see text "Similar Jobs"
    And    I wait for similar jobs to load
    When   I click on title of the job on similar jobs module and verify url

  @candidateJobViewSimilarJobsToggle
  Scenario: Verify the similar jobs section is a toggle
    Given I navigate to page "Jobs Sales"
    And   I Click on Job Title
    And   I switch to window 1
    # need to wait for jobs from partners to load
    And I wait for similar jobs to load
    And I collapse similar jobs section
    And I expand similar jobs section