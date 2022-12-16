@CompaniesPage @Regression @Web  @ReleaseRegression1 @Recruiters
Feature: Candidate Companies CompaniesPage

  @companySearch @CandidateE2E
  Scenario Outline: Do a search on companies page
    Given  I navigate to page "Companies"
    When   I enter company name "<CompanyName>"
    And    I click on search companies button
    Then   I should be on page "<URL>"
    Examples:
      | CompanyName          | URL                          |
      | acme company 1728    | /companies/acme-company-1728 |

  @companySearchResult
  Scenario: Verify the search result on companies page
    Given  I navigate to page "Companies Acme Company 1728"
    Then   I should see text "Companies matching acme"
    And    I should see text "Company Type"
    And    I should see text "All"
    And    I should see text "Staffing Agency"
    And    I should see text "Direct Employer"
    And    I should see text "Companies by State"
    And    I should see text "Popular Companies"

    #TODO Nirupan has to confirm on the data
#  @companiesPageAlsoInOtherLocations
#  Scenario: Verify ‘Also in other locations’ link on /company page
#    Given  I am on page "/company/11626/acme-company-no-11093-jobs"
#    When  I click on "Also in other locations" and see link "View all locations"
#    And   I switch tab
#    Then  I should be able to see in browser URL "/job/view/"
#    And   I should see text "Apply now"
#    And   I should see Save button

  @companiesPageAssertElements
  Scenario Outline: Assert elements on companies page
    Given  I navigate to page "Companies"
    And    I should see text "Search Companies"
    When   I click on companies page title "<CompanyTitle>"
    Then   I should be on page "<TitleURL>"
    And    I should see text H one tag "<Message>"
    When   I navigate to page "Companies"
    And    I should see text "Popular Companies"
    And    I click on companies "<Company>"
    Then   I should be on page "<URL>"
    And    I should see text H one tag "<Msg>"

    #@TODO https://cv-library.atlassian.net/browse/RL-2749
    When   I navigate to page "Companies"
    And   I click on View All
    Then  I should be on page "Companies Browse"
    And   I should see text "Browse Companies"

    When  I navigate to page "Companies"
    And   I should see text "Companies by State"
    And   I click on companies "<CompanyState>"
    Then  I should be on page "<CompanyURL>"
    And   I should see text "<Text>"

    When  I navigate to page "Companies"
    And   I should see text "Companies by City"
    And   I click on companies "<ByCity>"
    Then  I should be on page "<URL1>"
    And   I should see text "<Text1>"

    When  I navigate to page "Companies"
    And   I should see text "Popular job titles"
    Then  I click on popular job title "<JobTitle>"
    Then  I should be on page "<URL2>"
    And   I should see text H one tag "<Text2>"

    Examples:
      | CompanyTitle             | TitleURL                                   | Message                | Company                | URL                                        | Msg                    | CompanyState | CompanyURL            | Text                 | ByCity        | URL1                       | Text1                      | JobTitle        | URL2             | Text2           |
      | Browse jobs from Twitter | /company/18670/acme-company-no-642447-jobs | Acme Company No 642447 | Acme Company No 576874 | /company/14732/acme-company-no-576874-jobs | Acme Company No 576874 | Alabama      | /companies/in-alabama | Companies in Alabama | Arlington, TX | /companies/in-arlington-tx | Companies in Arlington, TX | Accountant Jobs | /jobs/accounting | Accounting jobs |