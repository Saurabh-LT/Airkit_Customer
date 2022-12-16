@ClientLogin @Regression @Web  @Recruiters
Feature: Client Login Login

  @clientSuccessfulLogin @ReleaseRegression2 @ClientE2E
  Scenario: Successfully Login as an existing Client
    Given I login as a client
    Then  I should be able to see in browser URL "Client Account"
    And   I should see text "Resume library"
    And   I should see text "Job Postings"

  @rejectClientLoginInvalid
  Scenario: Reject Client Login with invalid credentials
    Given I navigate to page "Hiring Login"
    And   I click on "Login as Employer"
    Then  I should see text "Email is required"
    And   I should see text "Password is required"

  @resetClientPasswordLink @ReleaseRegression2
  Scenario: Reset Client Password link
    Given I navigate to page "Hiring Login"
    And   I click on "Forgot password?"
    Then  I should see "Enter your email address below and we will send you an email to reset your password."
    When  I enter client email address to reset password
    And   I click on "Reset Password"
    Then  I should be able to see in browser URL "User Reset Password"
    And   I should see text p tag "We've sent your password reset link to" and verify message "We've sent your password reset link to testers+client@resume-library.com."

  @toggleCandidateLoginIcon
  Scenario: toggle the candidate login icon
    Given I navigate to page "Hiring Login"
    And   I click on "Jobseeker login"
    Then  I should be able to see in browser URL "Login"
    And   I should see button "Login as Jobseeker"
    And   I should see text "Create a jobseeker account"