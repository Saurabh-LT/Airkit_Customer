@SavedJobs @Regression @Web  @Candidate
Feature: Candidate SavedJobs SavedJobs

  @loggedOutUserSaveJobAndView
  Scenario: As a logged out user save a job and view it
    Given I navigate to page "Jobs Sales"
    When  I click on save toggle one
    Then  I should see text a tags "Saved Jobs (" and verify "Saved Jobs (1)"
    When  I click on saved job button
    And   I should see text p tag "Displaying" and verify message "Displaying 1 to 1 of 1"
    And   I should see text "Job ID"
    And   I should see text "Job title / Location"
    And   I should see text "Date saved"
    And   I should see text "Actions"
    Then  I click on saved job link on saved jobs page
    And   I switch tab
    And   I should be able to see in browser URL "Job View"

  @loggedOutUserSaveJobAndDelete @ReleaseRegression1
  Scenario: As a logged out user save a job and delete it
    Given I navigate to page "Jobs Sales"
    And   I click on save toggle one
    And   I click on saved job button
    And   I click on Actions
    And   I click on "Delete"
    And   I should see text H one tag "My Saved Jobs"

  @loggedOutUserSaveJobsTestHoverViewAllShowJobAndDelete
  Scenario: As a logged out user save a job hover basket test show, view all and delete job
    Given  I navigate to page "Jobs Nonexternaltestjobs"
    When   I click on save toggle one
    And    I click on save toggle two
    And    I click on save toggle three
    Then   I mouse hover Saved Jobs
    And    I should see text "View all"
    And    I should see text a tags "Saved Jobs (" and verify "Saved Jobs (3)"
    When   I click delete button on saved jobs
    Then   I should see text a tags "Saved Jobs (" and verify "Saved Jobs (2)"

  @loggedOutUserSaveJobAndRegister1 @ReleaseRegression1
  Scenario: As a logged out user save a job and register (via /candidate/registration page)
    Given  I navigate to page "Jobs Sales"
    When   I click on save toggle one
    And    I click on Register button
    And    I should be on page "Candidate Registration Page"
    Then   I should see text "You have saved jobs during your searches"
    And    I should see "Register below and these jobs will be saved into your account."
    Then   I register as a new candidate resume check
    And    I navigate to page "Candidate Saved Jobs"
    Then   I should see text "My Saved Jobs"
    And    I should see text p tag "Displaying" and verify message "Displaying 1 to 1 of 1"

  @loggedOutUserSaveJobAndLogin1 @ReleaseRegression1
  Scenario: As a logged out user save a job and login (via /login page)
    Given  I navigate to page "Jobs Sales"
    When   I click on save toggle one
    And    I click Login button
    Then   I should see text "You have saved jobs during your searches"
    And    I should see "To save these jobs to your account login below. Not registered?"
    Then   I login as a candidate
    And    I navigate to page "Candidate Saved Jobs"
    Then   I should see text "My Saved Jobs"
    And    I should see text p tag "Displaying" and verify message "Displaying 1 to "
    And    I click on Actions
    And    I click on "Delete"

  @loggedOutUserNoSavedJobsAndRegister
  Scenario: As a logged out user verify no saved jobs, register and verify no saved jobs message
    Given  I navigate to page "Saved Jobs"
    Then   I should see text H one tag "My Saved Jobs"
    And    I should see text "You have no saved jobs."
    When   I click on "Search jobs now"
    Then   I should be on page "Search Jobs"
    And    I should see text "Advanced Job Search"
    And    I click on Register button
    When   I register as a new candidate resume check
    And    I navigate to page "Candidate Saved Jobs"
    Then   I should see text "My Saved Jobs"
    And    I should see "It can take a few moments for your saved jobs to appear – please check back shortly"

  @loggedOutUserSaveJobAndRegister2
  Scenario: As a logged out user save a job and register (via Register & apply pop-up)
    Given  I navigate to page "Jobs Nonexternaltestjobs"
    When   I click on save toggle one
    And    I click on saved job button
    And    I click on Actions
    Then   I click apply now job click event
    And    I click on "Register & apply"
    And    I should be able to see in browser URL "Register Apply"
    And    I fill in "email" with random candidate email
    And    I enter first name "automation"
    And    I enter last name "candidate"
    And    I enter password "123456"
    And    I click on register button
    Then   I should be able to see in browser URL "Register Apply"
    And    I should see text a tags "Saved Jobs (" and verify "Saved Jobs (1)"
    When   I click on saved job button
    Then   I should be able to see in browser URL "Candidate Saved Jobs"
    And    I should see text p tag "Displaying" and verify message "Displaying 1 to 1 of 1"

  @loggedOutUserSaveJobAndLogin2
  Scenario: As a logged out user save a job and login (via Login & Apply pop-up)
    Given  I navigate to page "Jobs Nonexternaltestjobs"
    When   I click on save toggle one
    And    I click on saved job button
    And    I click on Actions
    And    I click apply now job click event
    And    I click on "Login & apply"
    Then   I should be able to see in browser URL "Login Apply"
    And    I fill in Email address
    And    I fill in password with "rltest01"
    And    I click on Login now button
    And    I navigate to page "Candidate Saved Jobs"
    Then   I should see text "My Saved Jobs"
    And    I should see text p tag "Displaying" and verify message "Displaying 1 to"
    And    I click on Actions
    And    I click on "Delete"