# Test Coverage
# 1. Verify empty field validation messages seen on the job posting page
# 2. Verify input validation messages seen on the job posting page

@JobPostingValidation @Regression @Web  @ReleaseRegression2 @Recruiters
Feature: Client JobPosting JobPostingValidation

  Background: Client Login
    Given I login as a client
    When  I navigate to page "Job Post"

  @clientJobPostingValidation
  Scenario: Job Posting Validation Messages
    And   I click on preview button
    And   I click on post job button
    Then  I should see text "Please add a job title"
    And   I should see text "Please add a minimum salary"
    And   I should see text "Please add a maximum salary"
    And   I should see text "Please make sure your vacancy description is at least 200 characters in length"
    And   I should see text "Please add a town/city/zip"
    And   I should see text "Please select a State"

  @clientJobPostingInputValidation
  Scenario Outline: Job Posting Input Validation Messages
    And   I enter job title "<Title>"
    And   I enter salary min "<SalMin>"
    And   I enter salary max "<SalMax>"
    And   I click on preview button
    And   I click on post job button
    Then  I should see text "Please add a valid job title"
    Then  I should see text "Maximum salary must be more than minimum salary"
    Then  I should see text "Minimum salary must be less than maximum salary"
    Examples:
      | Title | SalMin | SalMax |
      | -     | 20000  | 10000  |

  @screeningQuestionsValidation
  Scenario: Validate screening questions section
    Then  I click on add screening questions btn
    And   I click on save screening questions btn one
    Then  I should see text p tag "Question text required - Do you want to" and verify message "Question text required - Do you want to remove this question?"
    And   I should see "Please provide at least one desirable answer"
    And   I should see "You must provide at least two answers"
    When  I click on "remove"
    Then  I should not see "Question text required - Do you want to remove this question?"