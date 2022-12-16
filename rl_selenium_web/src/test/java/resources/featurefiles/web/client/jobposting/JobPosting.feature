@JobPosting @Regression @Web  @Recruiters
Feature: Client JobPosting JobPosting

  @jobPostingSuccessful @ReleaseRegression2 @ClientE2E
  Scenario Outline: Successfully post a job as an existing client
    Given I login as a client
    When  I navigate to page "Job Post"
    And   I enter job title "<Title>"
    And   I select "<State>" from state dropdown
    And   I enter city "<City>"
    And   I enter salary min "<SalMin>"
    And   I enter salary max "<SalMax>"
    And   I enter job description "<Description>"
    And   I click on preview button
    And   I click on post job button
    And   I click on post job submit button
    Then  I should be able to see in browser URL "Client Jobs New Job Posted"
    And   I should see text p tag " Your job can now be seen in matching search results." and verify message "Job Posted Successfully! Your job can now be seen in matching search results. Go to Job Dashboard"
    Examples:
      | Title    | State      | City  | SalMin | SalMax | Description        |
      | nonexternaltestjob | California | 90001 | 10000  | 30000  | Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job |