@CandidateApplyLogin @Regression @Web  @Candidate
Feature: Candidate JobApply JobApplyFromLogin

  @quickApplyLogin @ReleaseRegression1
  Scenario:  Search for quick apply job and login
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
    Then I am on page "/jobs/quick-apply-candidate-job-in-90001?pd=1&annual_salary_from=10000&annual_salary_to=30000"
    Then I click on apply now
    Then I should see "Register & Quick Apply"
    When I fill job apply email with "testers+candidate@resume-library.com" on job apply
    Then I should see text "This email already exists, please login"
    When I fill job apply password with "rltest01" on job apply
    And  I Click on Link Register & Quick Apply
    Then I should be able to see in browser URL "Job Apply"

  @jobApplyLogin
  Scenario:  Search for job and verify login apply
    Given I navigate to page "Jobs Non External Test Jobs"
    When I click on non external job to apply
    And  I should see "Already have an account?"
    And  I should see "Login to your Resume-Library account to apply."
    And  I click on "Login & apply"
    Then I should be able to see in browser URL "Login Apply"
    And  I should see text "You're applying for" on the page
    And  I fill in email address with "testers+candidate@resume-library.com"
    And  I fill in password with "rltest01"
    And  I press and wait "login_now"
    Then I should be able to see in browser URL "Job Apply"
    And  I should see text "Your resume"
    And  I should see text p tag "attached, you're ready to apply!" and verify message "test-cv.pdf "
    And  I should see text "Your cover letter"