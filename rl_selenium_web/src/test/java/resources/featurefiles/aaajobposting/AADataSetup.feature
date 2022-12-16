@DataSetupForAllTests @Regression @Web  @ReleaseRegression1 @Recruiters
Feature: Data setup for candidate tests

  @jobPosingSpendTypeAccount
  Scenario: Verifying job posting spend type is ACCOUNT not CLIENT
    Given I login as an admin user
    When  I navigate to page on admin "Account 1478"
    And   I click on product details Edit button
    Then  the job posting spend type is "ACCOUNT" not "CLIENT"

  @quickApplyJobPosting
  Scenario:  Posting a quick apply job
    Given I login as a client
    When I navigate to page "Job Post"
    And  I fill in title with "quick apply candidate job"
    And  I select "California" from state dropdown
    And  I enter city "90001"
    And  I enter salary min "10000"
    And  I enter salary max "30000"
    Then I enter job description "Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job"
    And  I click on quick apply toggle
    Then I click on preview button
    And  I click on post job button
    And  I click on post job submit button
    And  I am on page "Logout" and I should see browser URL "Hiring"

  @screeningQuestionJobPosting
  Scenario:  Posting a screening question job
    Given  I login as a client
    When I navigate to page "Job Post"
    And    I fill in title with "Screening Questions"
    And    I select "California" from state dropdown
    And    I enter city "90001"
    And    I enter salary min "10000"
    And    I enter salary max "30000"
    Then   I enter job description "Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job"
    And    I click on "Add Question"
    And    I fill in Question 1  with "Behat test"
    And    I fill in Answer 1 with "Yes"
    And    I fill in Answer 2 with "No"
    And    I click on Desirable Answer 1
    And    I click on "Save Question"
    And    I click on preview button
    And    I click on post job button
    And    I click on post job submit button
    Then   I should be able to see in browser URL "Client Jobs New Job Posted"
    And    I should see text p tag "Your job can now be seen in matching search results." and verify message "Job Posted Successfully! Your job can now be seen in matching search results."
    And    I should see text "Job Posted Successfully!"
    And    I am on page "Logout" and I should see browser URL "Hiring"

  @featuredJobPosting
  Scenario: Posting a drummer job for featured banner
    Given I login as a client
    When I navigate to page "Job Post"
    And   I enter job title "Drummer"
    And   I select "California" from state dropdown
    And   I enter city "90001"
    And   I enter salary min "10000"
    And   I enter salary max "30000"
    And   I enter job description "Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job"
    And   I click on preview button
    And   I click on post job button
    And   I click on post job submit button
    Then  I should be able to see in browser URL "Client Jobs New Job Posted"
    And   I should see text "Job Posted Successfully!"
    And   I logout the client

  @nonExternalJobPosting
  Scenario: Posting a non external job
    Given I login as a client and post a non external job

  @1ClickApplyJobPosting
  Scenario: Posting a 1-click apply job
    Given I login as a client
    When I navigate to page "Job Post"
    And I fill in title with "1-Click Apply"
    And I select "California" from state dropdown
    And I enter city "90001"
    And I enter salary min "10000"
    And I enter salary max "30000"
    Then I enter job description "Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job"
    And I click on preview button
    And I click on post job button
    And I click on post job submit button
    Then I should be able to see in browser URL "Client Jobs New Job Posted"
    And I should see text "Job Posted Successfully!"
    And I should see text p tag "Your job can now be seen in matching search results." and verify message "Job Posted Successfully! Your job can now be seen in matching search results."
    And I am on page "Logout" and I should see browser URL "Hiring"

  @deleteSavedSearch
  Scenario: Delete saved search
    Given I login as a client
    When  I navigate to page "Client Saved Search"
    Then  I delete saved search

  @deleteSavedCard
  Scenario: Delete saved card
    Given I login as a client
    When  I navigate to page "Client Purchase Pay Now"
    And   I see if a card is saved then delete it