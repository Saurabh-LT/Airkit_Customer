@ClientHelpResumeSearch @Regression @Web  @Recruiters
Feature: Client JobPosting ClientHelpResumeSearch

  @ClientHelpResumeSearchTips @ReleaseRegression2
  Scenario: Verify resume search tips page for a client
    Given I login as a client
    When  I navigate to page "Client Help Search Tips"
    Then  I should see text "Improve Your Search Results"
    And   I should see text "Advanced Search Techniques"
    And   I should see bread crumbs "Client Help Center > Resume Search Tips" with class name: "breadcrumbs"
    And   I should see image is displayed
    When  I switch to frame and play the video
    #We need this wait because, we are playing video for 4 seconds and pausing
    Then  I wait for "4" seconds
    And   I click on video pause button
    Then  I should see the video played up to "00:03" seconds
    And   I switch to window 0
    And   I scroll down to element "Search Resume Database"
    When  I click on "Search Resume Database"
    Then  I should be on page "Client Resume Search"