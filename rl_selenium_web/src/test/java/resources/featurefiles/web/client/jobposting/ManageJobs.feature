@ManageJobs @Regression @Web  @Recruiters
Feature: Client JobPosting ManageJobs

  @jobListings @ReleaseRegression2
  Scenario: Verify jobs on Manage Jobs page
    Given I login as a client
    When  I navigate to page "Client Jobs"
    Then  I should see text H two tag "Manage Jobs"
    And   I should see text "Active Jobs"
    And   I should see text "Job ID"
    And   I should see text "Posted by"
    And   I should see text "Job title"
    And   I should see text "Location"
    And   I should see text "Posted"
    And   I should see text "Expires"
    And   I should see text "Apps"
    And   I should see text "Views"
    And   I should see text "Apply type"
    And   I should see text "Actions"

  @assertLinks
  Scenario: Verify links on Manage Jobs page
    Given I login as a client
    When  I navigate to page "Client Jobs"
    When  I click on post job
    Then  I should be on page "Job Post"
    Then  I should see text "Post a Job"
    And   I should see text "Job Details"
    When  I navigate to page "Client Jobs"
    And   I click on manage job template
    Then  I should be on page "Client Jobs Templates"
    Then  I should see text "Manage Job Templates"
    #And   I should see text p tag "Displaying" and verify message "Displaying 1 to 20 of"
    When  I navigate to page "Client Jobs"
    And   I click on view job applications
    Then  I should be on page "Client Job Applications"
    Then  I should see text "Job Applications"
    And   I should see text p tag "Displaying" and verify message "Displaying 1 to 20 of"
    When  I navigate to page "Client Jobs"
    And   I click on inactive jobs
    Then  I should be on page "Client Jobs Inactive"
    Then  I should see text "Inactive Jobs"
    And   I should see text p tag "Displaying" and verify message "Displaying 1 to 20 of"
    When  I navigate to page "Client Jobs"
    And   I click on "View Profile"
    Then  I should be on page "Company 1478 Acme Company No 1728 Jobs"
    Then  I should see text "Acme Company No 1728 jobs"
    And   I should see text p tag "Showing" and verify message "Showing 1 - "
    When  I navigate to page "Client Jobs"
    And   I click on "Edit Profile"
    Then  I should be on page "Client Company Profile"
    Then  I should see text "Update Company Profile"
    And   I should see text "Contact Details"

  @reActivateJob @ReleaseRegression2
  Scenario: Verify Reactivate job
    Given I login as a client
    When  I navigate to page "client Jobs Inactive"
    Then  I click on jobs action btn one
    And   I click on "Reactivate"
    And   I click on id "refresh_this_job"
    Then  I should see element with text "The following job(s) have been successfully reactivated:" to be "visible"

  @editJob @ReleaseRegression2
  Scenario Outline: Verify Edit job
    Given I login as a client
    When  I navigate to page "Job Post"
    And   I enter job title "<Title>"
    And   I select "<State>" from state dropdown
    And   I enter city "<City>"
    And   I enter salary min "<SalMin>"
    And   I enter salary max "<SalMax>"
    And   I enter job description "<Description>"
    And   I click on preview button
    And   I click on post job button
    And   I click on post job submit button
    Then  I should be able to see in browser URL "Client Jobs New Job Posted"
    And   I navigate to page "Client Jobs"
    When  I click on jobs action btn one
    Then  I click on action edit btn
    And   I should be able to see in browser URL "Job Edit"
    When  I enter job title "<TitleUpdated>"
    And   I click on preview button
    And   I click on post job button
    Then  I should be on page "Client Jobs"
    And   I should see text "has been successfully updated"
    Examples:
      | Title    | State      | City  | SalMin | SalMax | Description                                                                                                                                                                                                                                                                                                                                                                             | TitleUpdated    |
      | test job | California | 90001 | 10000  | 30000  | Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job | test job update |

  @viewMatchingCandidates @ReleaseRegression2
  Scenario: Verify View matching candidates
    Given I login as a client
    When  I navigate to page "Client Jobs"
    And   I click on jobs action btn one
    And   I click on action matching btn
    Then  I should be able to see in browser URL "Client Resume Search Results"

  @deactivateJob @ReleaseRegression2
  Scenario: Verify Deactivate job
    Given I login as a client
    When  I navigate to page "Client Jobs"
    When  I click on jobs action btn one
    And   I click on action deactivate btn
    And   I click on deactivate this job
    Then  I should see text "Job Successfully Deactivated"

  @activeJobsPagination @ReleaseRegression2
  Scenario: Active Jobs Pagination
    Given I login as testers client
    And   I navigate to page "Client Jobs"
    And   I should see text p tag "Displaying" and verify message "Displaying 1 to 20 of"
    And   I scroll down 0,2000
    And   I click on "2"
    Then  I should be on page "Client Jobs 2"
    And   I should see text p tag "Displaying" and verify message "Displaying 21 to 40 of"
    And   I should see "Prev" link
    And   I scroll down 0,2000
    When  I click on link text "Prev"
    Then  I should be on page "Client Jobs 1"
    And   I should not see "Prev" link

  @inactiveJobsPagination
  Scenario: Inactive Jobs Pagination
    Given I login as testers client
    And   I navigate to page "Client Jobs Inactive"
    And   I should see text p tag "Displaying" and verify message "Displaying 1 to 20 of"
    And   I scroll down 0,2000
    And   I click on "2"
    Then  I should be on page "Client Jobs Inactive 2"
    And   I should see text p tag "Displaying" and verify message "Displaying 21 to 40 of"
    And   I should see "Prev" link
    And   I scroll down 0,2000
    When  I click on link text "Prev"
    Then  I should be on page "Client Jobs Inactive 1"
    And   I should not see "Prev" link

  @manageJobsSortingByPosted @ReleaseRegression2
  Scenario: Sorting Active jobs by Posted dates
    Given I login as testers client
    And   I navigate to page "Client Jobs"
    When  I click on posted dates descending arrow
    Then  I should see posted dates in desc order
    When  I click on posted dates ascending arrow
    Then  I should see posted dates in asc order

  @manageJobsSortingByExpires
  Scenario: Sorting Active jobs by Expires dates
    Given I login as testers client
    When  I navigate to page "Client Jobs"
    When  I click on expires dates descending arrow
    Then  I should see expires dates in desc order
    When  I click on expires dates ascending arrow
    Then  I should see expires dates in asc order

  @manageInActiveJobsSortingByPosted
  Scenario: Sorting Inactive jobs by Posted dates
    Given I login as testers client
    And   I navigate to page "Client Jobs Inactive"
    When  I click on posted dates descending arrow
    Then  I should see posted dates in desc order
    When  I click on posted dates ascending arrow
    Then  I should see posted dates in asc order

  @manageInActiveJobsSortingByExpires
  Scenario: Sorting Inactive jobs by Expires dates
    Given I login as testers client
    When  I navigate to page "Client Jobs Inactive"
    When  I click on expires dates descending arrow
    Then  I should see expires dates in desc order
    When  I click on expires dates ascending arrow
    Then  I should see expires dates in asc order