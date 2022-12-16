@ModifyResumeUpdate @Regression @Web  @ReleaseRegression1 @Candidate
Feature: Candidate ModifyProfile UpdateResume

  Background: On modify profile page
    Given  I navigate to page "Candidate Registration"
    And   I register as a new candidate
    When I navigate to page "Candidate My Profile"

  @modifyProfileChangeResume
  Scenario: Modify profile change resume
    And I upload resume "Test Cv"
    Then I should be able to see in browser URL "Candidate My Profile"
    Then I should see text "Your resume is currently processing, you will be able to apply for jobs in just a few moments."