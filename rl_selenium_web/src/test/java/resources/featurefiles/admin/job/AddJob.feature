@AdminAddJob @Regression @Admin @ReleaseRegression1 @Recruiters
Feature: Admin Job AddJob

Background: Navigating to Add A Job page
    Given   I login as an admin user
    When    I go to add jobs page
 
  Scenario: Validations on add job page
    Then    I should see text "Add A Job"
    When    I click Add Job button
    Then    I should see text "Please add a town/city/zip"
    And     I should see text "Please add your vacancy description"
    When    I select the option "California" from "State" field
    Then    I fill in "Town/City/Zip"
    Then    I fill in Description in the text area
    And     I click Add Job button
    Then    I should see text "The Title field is required."
    Then    I should see text "The Job Type field is required."
    Then    I should see text "The Status field is required."
    Then    I should see text "The Posted By field is required."
    Then    I should see text "The Apply Type field is required."
    And     I should see text "An Account Is required."

  @AdminE2E
  Scenario: Create a job successfully
    Then    I fill in "Job Title"
    And     I fill in "Minimum Salary"
    And     I fill in "Maximum Salary"
    When    I select the option "California" from "State" field
    Then    I fill in "Town/City/Zip"
    Then    I select the option "Permanent" from "Job Type" field
    Then    I select the option "Month" from "Salary Time Period" field
    Then    I select the option "Active" from "Status" field
    And     I fill in Description in the text area
    When    I fill in "Account"
    Then    I fill in "Company Name"
    Then    I select the option "api" from "Apply Type" field
    When    I click Add Job button
    Then    I should see text "Job successfully added"