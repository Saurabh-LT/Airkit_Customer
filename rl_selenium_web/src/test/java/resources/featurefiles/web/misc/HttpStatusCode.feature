@HttpStatusCode @Regression @Web @Misc @Traffic
Feature: Misc HttpStatusCode

  Scenario: Verify 500 status code page
    Given  I navigate to page "Page 500 Error"
    Then    the response code should be 200
    And     I should see "ERROR 500 - Internal Server Error" on the page
    And     I should see text "The request was not completed. The server met an unexpected condition."
    And     I should see text p tag "We may be down for maintenance, however if the problem persists please contact " and verify message "We may be down for maintenance, however if the problem persists please contact support@resume-library.com to report the problem."

  Scenario: Verify 403 status code page
    Given  I navigate to page "Page 403 Error"
    Then    the response code should be 200
    And     I should see "ERROR 403 - Forbidden" on the page
    And     I should see text "Access is forbidden to the requested page."
    And     I should see text p tag "We may be down for maintenance, however if the problem persists please contact " and verify message "We may be down for maintenance, however if the problem persists please contact support@resume-library.com to report the problem."

  @SearchJobsNavigationBar403Page
  Scenario: Search for a job from search jobs navigation bar 403 page
    Given I navigate to page "Page 403 Error"
    And The search jobs navigation bar button has text "Find jobs"
    And I fill in search jobs nav bar keywords search with "Sales"
    And I fill in search jobs nav bar location search with "10001"
    And I select "60 Miles" from search distance
    And I click on search jobs
    Then I should be able to see in browser URL "/jobs/sales-in-10001?r=60"
    And I should see text H one tag "Sales jobs"

  @SearchJobsNavigationBarMaintenancePage
  Scenario: Search for a job from search jobs navigation bar maintenance page
    Given I navigate to page "Page Maintenance"
    And The search jobs navigation bar button has text "Find jobs"
    And I fill in search jobs nav bar keywords search with "Sales"
    And I fill in search jobs nav bar location search with "10001"
    And I select "60 Miles" from search distance
    And I click on search jobs
    Then I should be able to see in browser URL "/jobs/sales-in-10001?r=60"
    And I should see text H one tag "Sales jobs"