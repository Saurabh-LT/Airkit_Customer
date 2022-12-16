@HideExpiredApplications @Regression @Web  @Candidate
Feature: Candidate Application HideExpiredApplications

  @hideExpiredApplication @ReleaseRegression1
  Scenario: Test 'Hide Expired Applications' checkbox
    Given  I login as a candidate
    When  I navigate to page "Candidate Myapplications"
    Then   I should see hide expired checkbox is unchecked
    When   I click on Hide expired checkbox
    # check some element to make sure checkbox is working?
    Then   I should see hide expired checkbox is checked
    # uncheck the box otherwise test will fail next time