#test coverage 
 #1. View an unlocked resume 
 #2. View a locked resume
 #3. Save a viewed locked resume
 #4. View a saved resume by name link
 #5. View a saved resume by Action link
 #6. Delete a saved resume by Action link

@ResumeView @Regression @Web  @Search
Feature: Client ResumeView ResumeView

  Background: Login as client
    Given I login as a client

  @resumeViewUnlocked @ReleaseRegression2
  Scenario: View an unlocked resume
    When I am on page "Client Resume View Candidate Profile1"
    Then I should see text "Resume Unlocked"
    And  I should see text "Similar resumes"
    And  I should see text "Candidate ID:"
    And  I should see text "Date Registered:"
    And  I should see text "Main number"
    And  I should see text "Email address"
    And  I should see text "Location"
    And  I should see text "Willing to travel"
    And  I should see text "Latest job title"
    And  I should see text "Desired job title"
    And  I should see text "Expected salary"
    And  I should see text "Work experience"
    And  I should see text "Job type"
    And  I should see text "Key skills"
    Then I should see text "Terri Reese"
    Then I should see text "Head of Sales & Growth"
    When I mouse hover Resume Unlocked
    Then I should see text "Unlocked by Resume-Library Client user on 01/13/2021 12:12:07"
    And  I should see text "Download Resume"
    And  I should see text "Video Interview"
    And  I should see text "Email Resume"
    And  I should see text "Request Resume to be Updated"
    And  I should see text "Print Resume"

  @resumeViewLocked @ReleaseRegression2 @ClientE2E
  Scenario: View a locked resume
    When  I navigate to page "Client Resume Search With Keywords"
    Then  I should be able to see in browser URL "Client Resume Search Results"
    And   I find a locked candidate
    Then  I should see text "Unlock Resume"
    And   I should see text "View contact details"
    And   I should see text "Email address"
    And   I should see text "View contact details"
    And   I should see text "Download Resume"
    Then  I should see element "Download Resume" is disabled
    And   I should see element "Video Interview" is disabled
    And   I should see element "Email Resume" is disabled
    And   I should see element "update-resume" is disabled
    And   I should see element "Print Resume" is not disabled
    And   I should see element "Report Resume" is not disabled

  @resumeSaveViewedLockedResume
  Scenario: Save a viewed locked resume
    When I am on page "Client Resume View Candidate Profile2"
    And  I click on save resume
    And  I am on page "Client My Saved Resumes"
    Then I should see text "Brianna"
    When I click on saved action one
    And  I click on "Delete"
    And  I wait for "1" seconds
    And  I click on "Delete"
    Then I should be able to see in browser URL "Client My Saved Resumes"
    And  I should see text "Candidate has been successfully deleted"

  @resumeViewSavedResumeByNameLink
  Scenario: View a saved resume by name link
    When I am on page "Client Resume View Candidate Profile2"
    And  I click on save resume
    And  I am on page "Client My Saved Resumes"
    Then I should see text "Brianna"
    When I click on saved resume one
    And  I switch to window 1
    Then I should be able to see in browser URL "Client Resume View Candidate Profile2a"
    And  I should see text "Location"
    And  I should see text "Email address"
    And  I should see text "Similar resumes"
    When I am on page "Client My Saved Resumes"
    And  I click on saved action one
    And  I click on "Delete"
    And  I wait for "1" seconds
    And  I click on "Delete"
    Then I should be able to see in browser URL "Client My Saved Resumes"
    And  I should see text "Candidate has been successfully deleted"

  @resumeViewSavedResumeByActionLink
  Scenario: View a saved resume by Action link
    When I am on page "Client Resume View Candidate Profile2"
    And  I click on save resume
    And  I am on page "Client My Saved Resumes"
    Then I should see text "Brianna"
    When I click on saved action one
    And  I click on saved action view one
    And  I switch tab
    Then I should be able to see in browser URL "Client Resume View Candidate Profile2a"
    And  I should see text "Location"
    And  I should see text "Email address"
    And  I should see text "Similar resumes"
    When I am on page "Client My Saved Resumes"
    Then I should see text "Brianna"
    When I click on saved action one
    And  I click on saved action delete one
    And  I click on saved delete
    Then I should be able to see in browser URL "Client My Saved Resumes"
    And  I should see text "Candidate has been successfully deleted"

  @resumeDeleteSavedResumeByActionLink
  Scenario: Delete a saved resume by Action link
    When I am on page "Client Resume View Candidate Profile2"
    And  I click on save resume
    And  I go to page "Client My Saved Resumes"
    Then I should see text "Brianna"
    When I click on saved action one
    And  I click on saved action delete one
    Then I should see text "Are you sure you want to delete this saved Resume?"
    When I click on saved delete cancel
    Then I should be able to see in browser URL "Client My Saved Resumes"
    When I click on saved action one
    And  I click on saved action delete one
    And  I click on saved delete
    Then I should be able to see in browser URL "Client My Saved Resumes"
    And  I should see text "Candidate has been successfully deleted"

  @resumePaginateAccountSaved
  Scenario: Click on paginated account saved resumes
    When I navigate to page "Client Account Saved Resumes"
    And  I should see link "2"
    And  I should see link "Next"
    Then I click on "Next"
    Then I should be able to see in browser URL "Client Account Saved Resumes 20"
    And  I should see link "Prev"
    Then I click on "Prev"
    Then I should be able to see in browser URL "Client Account Saved Resumes 0"

  @viewCandidateApplication @ReleaseRegression2
  Scenario: View a resume through Job Applications page
    When I go to page "Client Resume View Candidate Profile3"
    Then I should see text "Application for"
    Then I should see text "Contact applicant"
    Then I should see text "Location"
    And  I should see text "Willing to travel"
    And  I should see text "Latest job title"
    #And  I should see text "Desired job title"
    And  I should see text "Work experience"
    And  I should see text "Key skills"
    And  I should see text "Education level"
    And  I should see text "Willing to relocate"
    And  I should see text "Drivers license"
    And  I should see text "Expected salary"
    And  I should see text "Job type"
    And  I click on contact applicant btn
    And  I should see text "Main Number"
    And  I should see text "Email address"

  @resumeViewInviteToApplyDice
  Scenario: View a DICE candidate and click Invite to Apply link
    When I am on page "/client/resume/view_candidate_profile/13935566/1/1ddb9b974463"
   # Then I should see text "This Resume has been sourced from Dice"
    And  I click on "Invite to Apply"
    Then  I should see text H three tag "Invite to Apply"
    When  I click on "Send Invite"
    Then  I should see text "Please enter a subject line"
    And   I should see text "Please enter a message"
    When  I enter subject as "SubjectTest"
    And   I enter message in TextArea with 100 characters
    When  I click on Preview
    Then  I should see text H three tag "Preview Your Invite"
    And   I click on "Close Preview"
    When  I select related job "NonExternalTestJob90001, CA"
    Then  I should see message text "Hi,  I came across your resume and thought you would be a great fit for our role. I've included some details about the job below for you.  Hopefully this role is of interest to you.  Thanks {Client name}"
    When  I click on Preview
    Then  I should see text H three tag "Preview Your Invite"
    When  I click on "Close Preview"
    And   I click on "Send Invite"
    Then  I should see text H three tag "Invite Sent"
    And   I click on "OK"