@ClientHelpResumeAlert @Regression @Web  @Recruiters
Feature: Client JobPosting ClientHelpResumeAlert

  @ClientHelpResumeAlertTips
  Scenario: Verify client Navigation links and Text
    Given I login as a client
    When  I navigate to page "Client Help Alert Tips"
    Then  I should see text "Modify, Delete or Reactivate a Resume Alert"
    And   I should see text "Top Tips for using Resume Alerts"
    When  I click on "here"
    Then  I navigate to page "Hiring Resume Search"
    When  I move backward one page
    Then  I should see bread crumbs "Client Help Center > Resume Alert Tips" with class name: "breadcrumbs"
    When  I click on "Set up a Resume Alert"
    Then  I navigate to page "Client Help Alert Tips"