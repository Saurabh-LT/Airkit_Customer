# Tests coverage
    # 1. Confirm breadcrumb format for job search results
@SearchJobBreadcrumbFormat @Regression @Web  @ReleaseRegression1 @Traffic
Feature: Candidate JobSearch SearchBreadcrumbFormat

  @SearchJobBreadcrumbFormatKeywordLocation
  Scenario: Breadcrumb format on job search with keyword and location
    Given I navigate to page "Jobs Sales In New York"
    Then I should see bread crumbs "Search Jobs > Sales > New York > New York City" with class name: "breadcrumbs"

  @SearchJobBreadcrumbFormatNoKeywordLocation
  Scenario: Breadcrumb format on job search with keyword and location
    Given I navigate to page "Jobs"
    Then I should see text "Search Jobs"

  @SearchJobBreadcrumbFormatKeywordNoLocation
  Scenario: Breadcrumb format on job search with keyword and no location
    Given I navigate to page "Jobs Sales"
    Then I should see bread crumbs "Search Jobs > Sales" with class name: "breadcrumbs"

  @SearchJobBreadcrumbFormatLocationNoKeyword
  Scenario: Breadcrumb format on job search with location and no keyword
    Given I navigate to page "Jobs Sales In New York"
    Then I should see bread crumbs "Search Jobs > New York > New York City" with class name: "breadcrumbs"