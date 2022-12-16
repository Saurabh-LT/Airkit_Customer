#test coverage
  # 1. Existing user run search
  # 2. Existing user Edit alert
  # 3. Existing user delete alert

@ModifyJobAlert @Regression @Web  @Traffic
Feature: Candidate JobAlert ModifyJobAlert

  @existingUserRunSearch @ReleaseRegression1
  Scenario: Existing user run search
    Given I navigate to page "Candidate Registration"
    And   I register as a new candidate
    And   I navigate to page "Candidate Job Alerts"
    And   I fill in Keywords text with "Sales Manager" and location with "Texas City, TX"
    And   I click on Create Job Alert button
    And   I reload the page
    And   I click on Run Search
    And   I should be able to see in browser URL "Jobs"
    Then  I should see text p tag "Displaying " and verify message "Displaying 1 to "
    And   I navigate to page "Candidate Job Alerts"
    And   I click on Delete Alert link
    Then  I should see text "Are you sure you want to delete this Job Alert?" on alert popup
    And   I click on Yes, delete this alert

  @existingUserEditAlert @ReleaseRegression1
  Scenario: Existing user Edit alert
    Given I navigate to page "Candidate Registration"
    And   I register as a new candidate
    And   I navigate to page "Candidate Job Alerts"
    And   I fill in Keywords text with "Test Manager" and location with "Texas City, TX"
    And   I click on Create Job Alert button
    And   I reload the page
    And   I click on Edit Job Alert
    Then  I should see label tag "Keywords" and verify "Keywords/ job title"
    When  I fill in edit alert text with random keyword
    And   I click Save Changes button on edit alert page
    Then  I should see text "Job Alert Modified Successfully!"
    And   I click on Delete Alert link
    Then  I should see text "Are you sure you want to delete this Job Alert?" on alert popup
    And   I click on Yes, delete this alert

  @existingUserSnoozeAlert @ReleaseRegression1
  Scenario: Existing user snooze alert
    Given I navigate to page "Candidate Registration"
    And   I register as a new candidate
    And   I navigate to page "Candidate Job Alerts"
    And   I fill in Keywords text with "Test Manager" and location with "Texas City, TX"
    And   I click on Create Job Alert button
    And   I reload the page
    And   I click on "active" toggle job alert status
    Then  I click on snooze button
    Then  I should see text "Job Alert Modified Successfully!"
    Then  I should see text "Snoozed until" on the page source
    And   I click on snoozed toggle job alert status
    Then  I click on turn off snooze job alert status
    And   I reload the page
    And   I click on Delete Alert link
    And   I click on Yes, delete this alert
    And   I should see text "My Alerts"

  @JobAlertsMatchingJobs @ReleaseRegression1
  Scenario: Edit Job Alert and Check for Matching Jobs
    Given I navigate to page "Candidate Registration"
    And   I register as a new candidate
    And   I navigate to page "Candidate Job Alerts"
    Then  I should see text "Job Alerts"
    And   I fill in Keywords text with "Nonexternaltestjob" and location with "Texas City, TX"
    And   I click on Create Job Alert button
    And   I reload the page
    When  I click on Edit Job Alert
    Then  I Click on "Example Job Matches"
    Then  I should see Example Job Matches the Keyword or Job Title Field otherwise it should display "Sorry, no jobs match your search criteria"
    And   I reload the page
    And   I click on Delete Alert link
    And   I click on Yes, delete this alert