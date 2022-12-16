@FastTrackRegistration  @Regression @Web  @Traffic
Feature: Candidate Registration FastTrackRegister

  Background: Register as a candidate using fast track form
    Given  I navigate to page "Jobs Non External Test Jobs"
    Then   I set cookie with "ibpid" and "56079"
    And    I reload the page
    #we need the below wait, it was failing so do not remove

  @fastTrackFromSearchResults @ReleaseRegression1 @CandidateE2EExcluded
  Scenario: Register as a new candidate from search results
    When I click on Apply now Link
    And  I fill candidate email field with random EmailId
    And  I Enters Firstname as "Mike"
    And  I Enters Lastname as "Bob"
    And  I Enters Password "Passw0rd"
    And  I Click on Link Register & Apply
    Then I should be able to see in browser URL "Job Apply"

  @fastTrackFromJobView @ReleaseRegression1
  Scenario: Register as a new candidate from job view page
    And  I Click on Job Title
    And  I switch tab
    And  I click on Button Apply now
    And  I fill candidate email field with random EmailId
    And  I Enters Firstname as "Automation"
    And  I Enters Lastname as "Tester"
    And  I Enters Password "rltest01"
    And  I Click on Link Register & Apply
    Then I should be able to see in browser URL "Job Apply"

  @fastTrackFormValidation
  Scenario: Validate fast track registration form
    Then I follow link containing text "More"
    And  I switch tab
    Then I click on Apply now Link
    And  I should see text "Apply for"
    And  I should see text "Already have an account?"
    When I follow link Login
    And  I Click on Link Register & Apply
    Then I should see text "Email is required"
    Then I should see text "Password is required"
    And  I Click on Create a jobseeker account link
    When I Click on Link Register & Apply
    Then I should see text "Email is required"
    Then I should see text "First name is required"
    Then I should see text "Last name is required"
    Then I should see text "Password is required"
    And  I should not see "Resume is required" text

  @fastTrackFromCompanyProfile @ReleaseRegression1
  Scenario: Register as a new candidate from company profile
    When I am on page "Company 1478 Acme Company No 1728 Jobs"
    And  I click on Apply now Link
    And  I fill candidate email field with random EmailId
    And  I Enters Firstname as "Automation"
    And  I Enters Lastname as "Tester"
    And  I Enters Password "rltest01"
    And  I upload resume "Test Cv"
    And  I uncheck the label Claim my free professional Resume Review one
    And  I Click on Link Register & Quick Apply
    Then I should be able to see in browser URL "Job Apply"
    And  I should not see element with id "apply_view_more" on the page

  @fastTrackRegistrationResumeMandatory
  Scenario: Fast track register - Resume mandatory when 'Resume required on registration' partner setting is turned on
    Given  I set cookie with "ibpid" and "975438"
    And    I reload the page
    And    I click on Apply now Link
    And    I click Register & apply button
    Then   I should see text "Upload Resume & Apply"