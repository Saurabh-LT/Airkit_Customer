@SearchJobsPage @Regression @Web  @Search
Feature: Candidate JobSearch SearchJobsPage

  Background: On Search Jobs page
    Given I navigate to page "Search Jobs"

  @searchJobs @ReleaseRegression1
  Scenario: Verify Search Jobs Page
    Then I should see text H one tag "Advanced Job Search"
    And I should see text "Job Searching Tips"
    And I should see text H two tag "Browse jobs by location and category"
    And I should see text H three tag "Popular jobs"
    And I should see text H three tag "Jobs by industry"
    And I should see text H three tag "Jobs by State"
    And I should see text H three tag "Jobs by City"
    When I click on "Administrative Assistant"
    Then I should be able to see in browser URL "Jobs Administrative Assistance"
    When I navigate to page "Search Jobs"
    Then I click on "Accounting"
    And I should be able to see in browser URL "Jobs Accounting"
    When I navigate to page "Search Jobs"
    Then I click on "Alabama"
    And I should be able to see in browser URL "Jobs In Alabama Al State"
    When I navigate to page "Search Jobs"
    Then I click on "Arlington, TX"
    And I should be able to see in browser URL "Jobs In Arlington Tx"

  @incompleteZipCode @ReleaseRegression1
  Scenario: Search jobs with incomplete zip code
    When I fill in search location with "100"
    Then I click on Find Jobs search button
    And I should be able to see in browser URL "Jobs In 10001"
    And I should see text "Jobs in 10001"
    Then I should see text p tag "We searched" and verify message "We searched 10001, did you mean:"
    And I should see text "10002"
    And I click on "View more locations"
    And I should see text "View fewer locations"
    Then I should see text "10009"
    And I should see text "10010"
    And I click on "View fewer locations"
    And I should not see "View fewer locations"
    And I click on suggested locations one
    And I should be able to see in browser URL "Jobs In 10002"
    And I should see text "Jobs in 10002"
   # And I should see text Location: "10002"

  @incompleteLocation @ReleaseRegression1
  Scenario: Search jobs with incomplete zip location
    When I fill in search location with "bos"
    Then I click on Find Jobs search button
    And I should be able to see in browser URL "Jobs In Boston Ma"
    And I should see text "Jobs in Boston, MA"
    Then I should see text p tag "We searched " and verify message "We searched Boston, MA, did you mean:"
    And I should see text "Bossier Parish, LA"
    When I click on "View more locations"
    And I should see text "View fewer locations"
    And I should see text "New Boston, TX"
    When I click on "View fewer locations"
    And I should not see "View fewer locations"
    And I click on suggested locations two
    And I should be able to see in browser URL "Jobs In Bossier City La"
    And I should see text "Jobs in Bossier City, LA"

  @redirectURLHomepage
  Scenario: Search jobs on home page and verify redirect
    Given I am on page "/"
    When I fill in search location with "New York City, NY"
    Then I click on Find Jobs search button
    And I verify that http code is 200 and not 301
    And I should be able to see in browser URL "Jobs In New York City NY"
    And I should see text "Jobs in New York City, NY"


