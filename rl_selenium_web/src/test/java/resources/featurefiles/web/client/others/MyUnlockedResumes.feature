@MyUnlockedResumes @Regression @Web  @Recruiters
Feature: Client Others MyUnlockedResumes

  @myUnlockResumesAssertAndActions
  Scenario: Verify elements in unlocked resume and check 'Actions'
    Given I login as a client
    When  I navigate to page "Client My Unlocked Resumes"
    Then  I should see text "My Unlocked Resumes"
    And   I should see text "Date unlocked"
    And   I should see text "Candidate name / Job title"
    And   I should see text "Expected salary"
    And   I should see text "Actions"
    When  I click on saved action one
    And   I click on "View"
    And   I switch tab
    Then  I should be able to see in browser URL "Client Resume View Candidate Profile"
    And   I should see text "Candidate ID:"
    And   I should see text "Profile/Resume Last Updated:"
    And   I should see text "Resume Unlocked"