@CandidateEmailPreferences @Regression @Web  @Traffic
Feature: Candidate Settings EmailPreferences

  @emailPreferences @ReleaseRegression1
  Scenario: Login as an existing candidate and check email preferences
    Given I login as a candidate
    When  I navigate to page "Candidate Email Preferences"
    Then  I should see job alerts is ticked
    And   I should see updates is ticked

  @emailPreferencesUnsubscribeJobAlerts
  Scenario: Candidate unsubscribes from Job Alert emails
    Given I login as a candidate
    And   I navigate to page "Candidate Email Preferences"
    When  I untick Job alerts
    And   I Click on Save changes
    And   I should see text "Your preferences have been saved."
    And   I tick Job alerts
    And   I Click on Save changes

  @emailPreferencesUnsubscribeUpdates @ReleaseRegression1
  Scenario: Candidate unsubscribes from Job Alert emails
    Given I login as a candidate
    And   I navigate to page "Candidate Email Preferences"
    When  I untick Updates
    And   I Click on Save changes
    And   I should see text "Your preferences have been saved."
    And   I tick updates
    And   I Click on Save changes

  @emailPreferencesUnsubscribeAllEmails
  Scenario: Candidate unsubscribes from all emails
    Given I login as a candidate
    And   I navigate to page "Candidate Email Preferences"
    When  I untick unsubscribes from all emails
    And   I should see job alerts is ticked
    And   I should see updates is ticked
    And   I Click on Save changes
    And   I should see text "Your preferences have been saved."
    And   I tick updates
    And   I tick Job alerts
    And   I Click on Save changes

  @emailPreferencesCombineEmails
  Scenario: Candidate Email Preferences Combine emails
    Given I login as a candidate
    And   I navigate to page "Candidate Email Preferences"
    Then  I click on job application confirmation individual
    And   I should see text "Your job application confirmation preferences have now been updated."
    Then  I click on job application confirmation combined
    And   I should see text "Your job application confirmation preferences have now been updated."
    Then  I click on job alerts confirmation individual
    And   I should see text "Your Job Alert preferences have now been updated."
    Then  I click on job alerts confirmation combined
    And   I should see text "Your Job Alert preferences have now been updated."