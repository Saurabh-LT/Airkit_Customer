@AccountSavedResumes @Regression @Web  @Search
Feature: Client SavedResumes AccountSavedResumes

  Background: on Account Saved Resumes page
    Given I login as a client

  @accountSavedResumesAssertAndActions
  Scenario: Verify elements in account saved resumes and check 'Actions'
    When  I navigate to page "Client Account Saved Resumes"
    Then  I should see text "Date saved"
    And   I should see text "Candidate name / Job title"
    And   I should see text "Expected salary"
    And   I should see text "Saved by"
    When  I click on saved action one
    And   I click on "View"
    And   I switch tab
    Then  I should be able to see in browser URL "Client Resume View Candidate Profile"
    And   I should see text "Candidate ID:"
    And   I should see text "Email address"

  @accountSavedResumesSorting @ReleaseRegression2
  Scenario: Verify sorting based on 'Candidate name/Job title' and 'Saved by'
    When  I navigate to page "Client Account Saved Resumes"
    When  I press candidate name by asc order
    Then  I should see in Candidate name in asc order
    When  I press candidate name by desc order
    Then  I should see in Candidate name in desc order
    When  I press saved by asc order
    Then  I should see saved by in asc order on account saved resume page
    When  I press saved by desc order
    Then  I should see saved by in desc order on account saved resume page

  @emailDisabledForLockedResume1
  Scenario: Verify if 'Email' option is disabled for locked resumes on Account Saved resumes
    Then  I am on page "Client Resume Search With Keywords"
    And   I should see element with id "save_this_search" to be "visible"
    And   I find a locked candidate and verify text "Unlock Resume"
    Then  I should be able to see in browser URL "Client Resume View Candidate Profile"
    And   I click on id "save-resume"
    When  I go to page "Client Account Saved Resumes"
    And   I click on saved action one
    And   I should see element "Email" is disabled
    And   I click on "Email"
    Then  I should see text "Resume is locked"
    And   I should see text "You may only contact a candidate once they have been unlocked. Please unlock this candidate to continue."
    And   I should see element with text "OK" to be "visible"
    And   I click on "OK"
    And   I should see text H one tag "Account Saved Resumes"

  @deleteDisabledWhenSavedByAnotherUser
  Scenario: Verify if 'Delete' option is disabled if the resume is saved by another user
    When  I navigate to page "Client Account Saved Resumes"
    Then  I am on page "Logout" and I should see browser URL "Hiring"
    When  I login as testers client
    And   I go to page "Client Account Saved Resumes"
    And   I click on id "saved_action_2"
    And   I should see element "Delete" is disabled
    And   I click on "Delete"
    Then  I should see text "Candidate saved by another user"
    And   I should see text "You can not delete a resume saved by another user"
    And   I should see element with text "OK" to be "visible"
    And   I click on "OK"
    Then  I should see text H one tag "Account Saved Resumes"