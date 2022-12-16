@CareerAdvice @Regression @Web  @Candidate
Feature: Candidate CareerAdvice CareerAdvice

  @loadCareerAdvice @ReleaseRegression1 @CandidateE2E @Safari
  Scenario: Load Career Advice
    Given  I am on page "/career-advice"
    Then   I should see "Career Advice" on the page
    And    I should see text "View all"
    And    I should see H two tag "The latest jobs on " and verify message "The latest jobs on Resume-Library"
    And    I should see text H three tag "Jobs By Industry"
    And    I should see text H three tag "Jobs By Location"
    And    I should see text H three tag "Popular jobs"

  @careerAdviceCategories @ReleaseRegression1 @Safari
  Scenario: Career advice categories are shown
    Given  I am on page "/career-advice/getting-started/"
    And    I should see text "At Work"
    And    I should see text "Career Development"
    And    I should see text "Cover Letters"
    And    I should see text "Getting Started"
    And    I should see text "Grads"
    And    I should see text "Interviews"
    And    I should see text "Latest"
    And    I should see text "Location Guides"
    And    I should see text "Resume Tips"

  @CareerAdviceCompaniesCount @ReleaseRegression1 @Safari
  Scenario: Career Advice Companies Count is not zero in sub nav bar
    Given  I am on page "/career-advice"
    Then   I should not see the companies count is zero
    When   I click on "Companies"
    Then   I should be on page "/companies"
    And    I should see text "Search Companies"

  @CareerAdviceFreeResumeReview @ReleaseRegression1 @Safari
  Scenario: Verify resume review banner on career Advice page
    Given  I am on page "/career-advice"
    And    I click on FREE Resume Review
    Then   I should be on page "/resume-review"
    And    I should see text "FREE Resume Review"

  @CareerAdviceSavedJobs @Safari
  Scenario: Career Advice Saved Jobs
    Given  I am on page "/career-advice"
    When   I click on saved job button
    Then   I should be on page "/saved-jobs"
    And    I should see text H one tag "My Saved Jobs"

  @CareerAdviceHiddenProfile @Safari
  Scenario: As a logged in user who has hidden their profile
    Given  I navigate to page "Candidate Registration"
    When   I register as a new candidate resume check
    Then   I navigate to page "Candidate Settings"
    Then   I should see text "Hide my Profile"
    And    I click on link text "Hide my Profile"
    Then   I should be on page "Candidate Hide"
    And    I click on Hide My Profile
    Then   I should see "Your profile is hidden from employers."
    When   I click on link "Career Advice" jobseeker tools menu
    And    I click on "Unhide Profile"
    Then   I should see "Your profile has been unhidden."