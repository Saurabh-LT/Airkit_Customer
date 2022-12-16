@CandidateLogin @Regression @Web  @Candidate
Feature: Candidate Login Login

  @loginAsExistingCandidate @login @ReleaseRegression1 @CandidateE2E
  Scenario: Login in as an existing Candidate
    Given  I am on home page
    When   I click Login button
    And    I fill in Email address
    And    I fill in Password
    And    I click Login as Jobseeker button
    Then   I should be on "My Dashboard" page
    And    I should see text "Hi Resume-Library"
    And    I should see text "Recently Applied"

  @loginPageErrorMessage
  Scenario: Verify error message on login page
    Given  I am on home page
    When   I click Login button
    And    I click Login as Jobseeker button
    Then   I should see text "Email is required"
    And    I should see text "Password is required"

  @loginPageResetPassword @ReleaseRegression1
  Scenario: Reset candidate password
    Given  I am on home page
    When   I click Login button
    And    I click Forgot password?
    Then   I should see text "Enter your email address below and we will send you an email to reset your password."
    When   I fill in Email address to reset password
    And    I click Reset Password button
    And    I should see a text message "We've sent your password reset link to testers+candidate@resume-library.com."

  @toggleEmployerLoginIcon
  Scenario: toggle the employer login icon
    Given  I navigate to page "Login"
    And    I click on recruiter login icon
    Then   I should be able to see in browser URL "Hiring Login"
    And    I should see login as employer button
    And    I should see text "Create an employer account"

  @resumeReviewLogin
  Scenario: Login as existing candidate on free resume review page
    Given  I navigate to page "Resume Review"
    Then   I fill in Email address
    And    I click on first name field
    And    I should see "There is already an account associated with this email. Login to claim your review."
    And    I enter password "rltest01"
    And    I press login and review my resume button
    Then   I should be on page "Candidate Resume Review Success"
    And    I should see text H one tag "Thanks for requesting a free resume review!"
    When   I navigate to page "Candidate My Profile"
    And    I upload resume "Test Cv"
    Then   I should be on page "Candidate My Profile"
    And    I should see "Your resume is currently processing, you will be able to apply for jobs in just a few moments."
    And    I should see "FREE Resume Review" link