# Test Coverage:
#1. Search and view a candidate
#2. Other options (Download, Interview, Email, Update, Print, Report)
# More Info: search and view candidate then unlock the candidate. Once unlocked, add tests for above mentioned 4 options by clicking those options and complete each journey

@ResumeViewOptions @Regression @Web  @ReleaseRegression @Search
Feature: Client ResumeView ResumeViewOptions

  Background: Resume Search
    Given I login as a client
    #TODO removed the parameter updated_on=14+days from the below url search string
    And   I navigate to page "Client Account Unlocked Resumes"
    Then  I should see text "Account Unlocked Resumes"

  @unlockedResumeViewOptions
  Scenario: View a candidate resume and interact with options on a unlocked candidate
    And   I click on saved action one
    And   I click on "View"
    Then  I switch tab
    Then  I should be able to see in browser URL "Client Resume View Candidate Profile"
    And   I go to page "/client/resume/view_candidate_profile/11018283/1/0335c0ef22e5"
    And   I click on "Video Interview"
    Then  I should see text H three tag "Set Up Video Interview"
    And   I click on id "close-video-interview-btn"
    And   I click on "Email Resume"
    Then  I should see text "Would you like to email"
    And   I should see "You will receive an email containing the candidate's information with their resume attached."
    And   I click on "Email Resume"
    Then  I should see text "Resume has been emailed to testers+client@resume-library.com"
#   @TODO once reported we cannot report again, so we need to think and update this scenario
#    And   I click on "Report Resume"
#    Then  I should see text "Report this resume to Resume-Library"
#    And   I click on id "report.4"
#    And   I click on "Report Resume"
#    Then  I should see text "Resume has been successfully reported."
#    And   I click on "Request Resume to be Updated" and verify below steps
    And   I click on "Request Resume to be Updated"
    Then  I should see text "Request Candidate Action"
    And   I select "Request updated Resume" from requested action
    And   I enter email "testers@resume-library.com" to your email field
    And   I click on "Send Request"
