@CandidateApplications @Regression @Web  @Candidate
Feature: Candidate Application Applications

  @candidateWithNoApplication
  Scenario: Candidate with no application
    Given  I navigate to page "Candidate Registration"
    And    I register as a new candidate resume check
    When   I navigate to page "Candidate Myapplications"
    And    I should see text H one tag "My Applications"
    And    I should see text "It can take a few moments for your job applications to appear – please check back shortly"

  @candidateWithApplicationViewApplication @ReleaseRegression1
  Scenario: Candidate with application view application
    Given  I navigate to page "Candidate Registration"
    And    I register as a new candidate resume check
    Then   I navigate to page "Jobs Non External Test Jobs"
    And    I click on non external job to apply
    And    I switch tab
    Then   I should be able to see in browser URL "Job Apply"
    When   I enter phone number "01234567891"
    And    I click on apply send application link
    When   I navigate to page "Candidate Myapplications"
    Then   I should see text p tag "Displaying" and verify message "Displaying 1 to 1 of 1"
    And    I should see text "Date Applied"
    And    I should see text with id hide expired application "Hide Expired Applications"
    And    I click on View button
    Then   I should see text "The Vacancy you Applied for"

  @candidateWithOneApplicationViewJob
  Scenario: Candidate with one application view job
    Given  I navigate to page "Candidate Registration"
    And    I register as a new candidate resume check
    When   I navigate to page "Jobs Non External Test Jobs"
    And    I click on non external job to apply
    And    I switch tab
    Then   I should be able to see in browser URL "Job Apply"
    When   I enter phone number "01234567891"
    And    I click on apply send application link
    Then   I navigate to page "Candidate Myapplications"
    When   I click on job title applied link
    And    I switch to window 2
    Then   I should be able to see in browser URL "Job View"
    And    I should see text "Applied"
    And    I should see text "View application"