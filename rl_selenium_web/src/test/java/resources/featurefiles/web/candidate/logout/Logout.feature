@CandidateLogout @Regression @Web  @ReleaseRegression1 @Candidate
Feature: Candidate Logout Logout

  Scenario: Logout and verify elements
    Given  I login as a candidate
    Then   I should be on "My Dashboard" page
    When   I mouse hover "Hi Resume-Library"
    And    I click Logout
    Then   I should be on "Logged out" page
    And    I should see text "You have been logged out successfully."
    And    I should see text "Recommended jobs for you"
    And    I should see text "View"
    And    I should see text "Apply"
    And    I should see text "View all job matches"
    And    I should see text "Login"
    And    I should see text "Register"
    And    I should see text "Hiring"
    And    I should see text "Saved Jobs"
    When   I click on link text "View all job matches"
    Then   I should be able to see in browser URL "Jobs"