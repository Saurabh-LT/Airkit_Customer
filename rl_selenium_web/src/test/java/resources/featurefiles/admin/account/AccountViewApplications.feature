@AccountViewApplications @Regression @Admin @Recruiters
Feature: Admin Account AccountViewApplications

  @accountViewApplicationsOne
  Scenario: Search for an account using account number and verify Applications page load case 1
    Given   I login as an admin user
    When    I navigate to page on admin "Account 1478"
    Then    I should see text "Acme Company No 1728 (1478)"
    Then    I click on Applications
    Then    I should see text "Applications for Acme Company No 1728 - Account ID: #1478"
    Then    I should see text "Job ID"
    Then    I should see text "Job Title"
    Then    I should see text "Candidate ID"
    Then    I should see text "Candidate Name"
    Then    I should see header text "Email"
    Then    I should see text "Application Time"
    Then    I should see header text with BR "Apply Type"
    Then    I should see header text with BR "User Deleted"

  @accountViewApplicationsTwo
  Scenario: Search for an account using account number and verify Applications page load2
    Given   I login as an admin user
    When    I navigate to page on admin "Account 19088"
    Then    I should see text "Acme Company No 787777 (19088)"
    Then    I click on Applications
    Then    I should see text "Applications for Acme Company No 787777 - Account ID: #19088"
    Then    I should see text "Job ID"
    Then    I should see text "Job Title"
    Then    I should see text "Candidate ID"
    Then    I should see text "Candidate Name"
    Then    I should see header text "Email"
    Then    I should see text "Application Time"
    Then    I should see header text with BR "Apply Type"
    Then    I should see header text with BR "User Deleted"