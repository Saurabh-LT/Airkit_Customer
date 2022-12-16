@AccountSearch @Regression @Admin @ReleaseRegression1 @Recruiters @AdminE2E
Feature: Admin Account AccountSearch

  Scenario: Search for an account using account number
    Given   I login as an admin user
    When    I search for "1478" in the navigation bar
    Then    I should be on account search results page
    Then    I should see text "Search Results"
    Then    I should see text "You searched for"
    And     I should see text "Account Results"
    When    I click on "Acme Company No 813181"
    #When    I click View account details from the first results
    Then    I should be on Account View page
    Then    I should see text "Acme Company No 813181 (23300) - NOT VALIDATED"
    And     I should see text "Account Overview"