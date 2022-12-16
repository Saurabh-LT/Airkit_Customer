# Test Coverage
# 1. Verify that create, view, edit, Post job and delete job template https://cv-library.atlassian.net/browse/XT-1379

@ManageJobTemplate @Regression @Web  @ReleaseRegression2 @Recruiters
Feature: Client JobPosting ManageJobTemplate

  @EditJobTemplate
  Scenario: Edit Job Template
    Given I login as a client
    When  I navigate to page "Client Jobs Templates"
    When  I click on "Create New Template"
    Then  I enter job title "Client Job Template"
    And   I select "California" from state dropdown
    And   I enter city "California Pines, CA"
    And   I enter salary min "2000"
    And   I enter salary max "5000"
    Then  I enter salary benefits details "Testing benefits"
    And   I enter job description "Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job"
    Then  I click on preview button
    Then  I click on save template btn
    And   I enter job template name "Test Template 100"
    Then  I click on "Save Template"
    Then  I should see text "has been created successfully"
    When  I click on Actions
    And   I click on "View / Edit"
    Then  I enter job title "Client Job Template11"
    And   I select "California" from state dropdown
    And   I enter city "California Pines, CA"
    And   I enter salary min "3000"
    And   I enter salary max "6000"
    Then  I enter salary benefits details "Testing benefits"
    And   I enter job description "Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job"
    Then  I click on preview button
    Then  I click on save template btn
    Then  I click on update template btn
    Then  I should see text "has been updated successfully"

  @PostJobFromTemplate
  Scenario: Post a Job from Job Template
    Given I login as a client
    When  I navigate to page "Client Jobs Templates"
    When  I click on Actions
    And   I click on "Post Job"
    And   I should see element with text "Save as Template" to be "visible"
    Then  I click on preview button
    And   I should see element with text "Close Preview" to be "visible"
    Then  I click on post job button
    And   I should see text H three tag "Posting this job will cost 1 job credit"
    And   I click on post job submit button
    Then  I should see text "Job Posted Successfully!"

  @PostJobFromTemplateList
  Scenario: Post a Job from Job Template List from Left side
    Given I login as a client
    And   I am on page "Client Jobs Templates Create"
    When  I enter job title "Client Job Template"
    And   I select "California" from state dropdown
    And   I enter city "California Pines, CA"
    And   I enter salary min "2000"
    And   I enter salary max "5000"
    Then  I enter salary benefits details "Testing benefits"
    And   I enter job description "Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job"
    Then  I click on preview button
    Then  I click on save template btn
    And   I enter job template name "Test Template 100"
    Then  I click on "Save Template"
    Then  I should see text "has been created successfully"
    When  I navigate to page "Client Jobs Templates"
    When  I click on Actions
    And   I click on "Post Job"
    Then  I select the option "Test Template 100" from Job template
    And   I click on "Load Job Template"
    And   I should see element with text "Save as Template" to be "visible"
    Then  I click on preview button
    And   I should see element with text "Close Preview" to be "visible"
    Then  I click on post job button
    And   I should see text H three tag "Posting this job will cost 1 job credit"
    And   I click on post job submit button
    Then  I should see text "Job Posted Successfully!"

  @DeleteJobTemplate
  Scenario: Delete Job Template
    Given I login as a client
    When  I navigate to page "Client Jobs Templates"
    When  I click on Actions
    And   I click on Delete button
    And   I click on Delete confirm button
    Then  I should see text "has been deleted"