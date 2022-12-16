@RecentlyAppliedTab @Regression @Web  @Candidate
Feature: Candidate MyDashboard RecentlyApplied

  Background: Login as a new candidate
    Given I login as a candidate

  @recentlyApplied
  Scenario: Verify Recently applied tab
    And   I click on recently applied link
    And   I should see text p tag "Some jobs listed above require you to complete your application directly on a " and verify message "Some jobs listed above require you to complete your application directly on a third party website. Please note: this list may include jobs that you have viewed but have NOT applied for. External applications are not tracked by Resume-Library, therefore we are unable to track whether you have made an application after you have left Resume-Library.com."
    And   I click on "View all applications ("
    Then  I should be on page "Candidate Myapplications"
    #And   I should see text "Stand out from the crowd with the perfect Resume"
    And   I should see text p tag "Displaying" and verify message "Displaying 1 to"
    And   I should see text "Job ID"
    And   I should see text "Date Applied"
    Then  I should see text Hide Expired Applications label "Hide Expired Applications"