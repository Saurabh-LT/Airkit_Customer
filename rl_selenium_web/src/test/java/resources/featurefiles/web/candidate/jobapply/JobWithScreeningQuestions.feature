@ScreeningQuestions  @Regression @Web  @ReleaseRegression1 @Candidate
Feature: Candidate JobApply JobWithScreeningQuestions

  Background: Post a job with additional questions
    Given  I login as a client
    When   I navigate to page "Job Post"
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

  @registerApplyScreeningQuestions
  Scenario: Register apply for a job with Screening Questions
    When   I navigate to page "Jobs Screening Questions"
    Then   I click on apply now
    And    I click Register & apply button
    And    I should be able to see in browser URL "Register Apply"
    And    I fill in "email" with random candidate email
    And    I fill in the first name with "automation"
    And    I fill the  last name with "candidate"
    And    I fill in password with "123456"
    And    I upload resume "Test Cv"
    And    I uncheck the label Claim my free professional Resume Review
    And    I click Login & apply button
    Then   I should be able to see in browser URL "Register Apply"
    And    I fill in the field where id is "latest_job_title" with: "sales"
    And    I fill in the field where id is "zip_code_ux" with: "10001"
    And    I fill in the field where id is "phone" with: "123456789"
    Then   I click on registration confirm button
    And    I click on apply send application link
    And    I should see text "Vacancy Specific Questions"
    Then   I should see "Please answer all vacancy specific questions to apply for this job"
    And    I select the option "Yes" from vacancy specific questions
    And    I click on apply send application link
    Then   I navigate to page "Candidate Myapplications"
    And    I should see text "Screening Questions"