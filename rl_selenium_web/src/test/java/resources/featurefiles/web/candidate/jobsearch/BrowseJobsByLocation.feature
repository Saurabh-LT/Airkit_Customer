@BrowseJobsByLocation @Regression @Web  @ReleaseRegression1 @Traffic
Feature: Candidate JobSearch BrowseJobsByLocation

  @browseJobs
  Scenario: Verify browse jobs on home page
    Given I navigate to page "Search Jobs Locations"
    Then I should see text "Browse Jobs By Location"
    And I should see text "Search & Apply for 1000s of jobs from top employers/recruiters."
    And I should see "Search Jobs" link
    And I should see text "States"
    Then I click on "Alabama"
    And I should be able to see in browser URL "Jobs In Alabama Al State"
    And I should see text "Jobs in Alabama"
    When I navigate to page "Search Jobs Locations"
    Then I click on "View Cities"
    And I should be able to see in browser URL "Search Jobs Locations Alabama"
    And I should see "Cities in Alabama"
    Then I click on "Locations"
    And I should be able to see in browser URL "Search Jobs Locations"
    When I navigate to page "Search Jobs Locations In Alabama"
    Then I click on "Huntsville"
    And I should be able to see in browser URL "Jobs In Huntsville Al"
    And I should see text "Jobs in Huntsville, AL"