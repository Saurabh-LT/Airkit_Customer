@1ClickApply @Regression @Web  @Candidate
Feature: Candidate JobApply 1ClickApply

  @jobView1ClickApply
  Scenario: 1-click apply on job view page
    Given I navigate to page "Candidate Registration"
    Then  I register as a new candidate resume check
    When  I navigate to page "Jobs One Click Apply"
    Then  I click on More Link
    And   I switch tab
    And   I should see one click apply text "1-Click Apply"
    And   I click on id "1-click-apply-btn"
    And   I should see text "Applied"
    And   I should see text "View application"
    When  I navigate to page "Candidate Myapplications"
    And   I should see text "1-Click Apply"

  @jobSearch1ClickApply @ReleaseRegression1
  Scenario: 1-click apply on job search page
    Given I navigate to page "Candidate Registration"
    Then  I register as a new candidate resume check
    When  I navigate to page "Jobs One Click Apply"
    And   I should see text "1-Click apply"
    And   I click on "1-Click apply"
    And   I should see text "Applied"
    And   I should see text "View Application"
    When  I navigate to page "Candidate Myapplications"
    And   I should see text "Click Apply"