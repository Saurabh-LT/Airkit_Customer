@JobViewSchemaValidation @Regression @Web  @Traffic
Feature: Candidate JobView JobViewSchemaValidation
# dev team code refactoring done , here the validation is to check the jobPostingSchema https://cv-library.atlassian.net/browse/XT-1263

  Scenario: Job view schema element validation for active job
    Given I navigate to page "Jobs NonexternaltestjobS"
    When  I Click on Job Title
    And   I switch tab
    Then  I should be able to see in browser URL "Job View"
    Then  I should see element with id "jobPostingSchema" on the page

  Scenario: Job view schema element validation for expired job
    When  I navigate to page "Job View For 24146400"
    Then  I should not see element with id "jobPostingSchema" on the page