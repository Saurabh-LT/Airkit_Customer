@ResultsPerPage @Regression @Web  @Search
Feature: Candidate JobSearch ResultsPerPage

  @verifyResultsPerPage @ReleaseRegression1
  Scenario: Verify job search by changing 'Results per page' dropdown
    Given I navigate to page "Jobs"
    Then  I should see search results displaying text "Displaying 1 to 20 of 40,000+ jobs"
    And   I click on "Next"
    Then  I should see search results displaying text "Displaying 21 to 40 of 40,000+ jobs"
    When  I select option "50" from results per page
    Then  I should see option "50" selected
    Then  I should see search results displaying text "Displaying 1 to 50 of 40,000+ jobs"
    And   I select option "75" from results per page
    Then  I should see option "75" selected
    And   I should see search results displaying text "Displaying 1 to 75 of 40,000+ jobs"
    And   I select option "100" from results per page
    Then  I should see option "100" selected
    And   I should see search results displaying text "Displaying 1 to 100 of 40,000+ jobs"
    And   I select option "250" from results per page
    Then  I should see option "250" selected
    And   I should see search results displaying text "Displaying 1 to 250 of 40,000+ jobs"

  @searchResultsPageNavigationButtonsPerPageParam @ReleaseRegression1 @CandidateE2E
  Scenario: Search results page modules
    Given I navigate to page "Jobs Sales"
    And   I click on "2" pagination
    Then  I should see text p tag "Displaying " and verify message "Displaying 21 to 40 of "
    And   I should be able to see in browser URL "Jobs Sales Page 2"
    And   I click on "Prev" pagination
    Then  I should see text p tag "Displaying " and verify message "Displaying 1 to 20 of "
    And   I should be able to see in browser URL "Jobs Sales"
    And   I click on "Next" pagination
    Then  I should see text p tag "Displaying " and verify message "Displaying 21 to 40 of "
    And   I should be able to see in browser URL "Jobs Sales Page 2"

  @searchResultsPageNavigationButtonsPPParam
  Scenario: Search results page modules
    Given I navigate to page "Jobs Sales"
    And   I select option "75" from results per page
    And   I click on "2" pagination
    Then  I should see text p tag "Displaying " and verify message "Displaying 76 to 150 of "
    And   I should be able to see in browser URL "Jobs Sales PP75 Page 2"
    And   I click on "Prev" pagination
    Then  I should see text p tag "Displaying " and verify message "Displaying 1 to 75 of "
    And   I should be able to see in browser URL "Jobs Sales PP75"
    And   I click on "Next" pagination
    Then  I should see text p tag "Displaying " and verify message "Displaying 76 to 150 of "
    And   I should be able to see in browser URL "Jobs Sales PP75 Page 2"

  @searchResultsPageNavigationMaxPageNumberNextLink @ReleaseRegression1
  Scenario: Search results page max pagination
    Given I navigate to page "Search Jobs Per Page 20 Max Page 50"
    And   I should see text p tag "Displaying " and verify message "Displaying 981 to 1,000 of "
    And   I should not see "Next" link
    And   I should not see "51" link

    Given I navigate to page "Search Jobs Per Page 75 Max Page 14"
    And   I should see text p tag "Displaying " and verify message "Displaying 976 to 1,050 of "
    And   I should not see "Next" link
    And   I should not see "15" link

  @jobSearchPaginationMaxViewableIs1000 @ReleaseRegression1
  Scenario: Job Search pagination max viewable is 1000
    Given I browse the url "Search Jobs Per Page 250 Page Number 5"
    Then  I should be able to see in browser as URL "Search Jobs Per Page 250 Page Number 4"
    When  I browse the url "Search Jobs Per Page 100 Page Number 11"
    Then  I should be able to see in browser as URL "Search Jobs Per Page 100 Page Number 10"
    When  I browse the url "Search Jobs Per Page 75 Page Number 15"
    Then  I should be able to see in browser as URL "Search Jobs Per Page 75 Page Number 14"
    When  I browse the url "Search Jobs In Texas Tx State Page Number 51"
    Then  I should be able to see in browser as URL "Search Jobs In Texas Tx State Page Number 50"
    When  I browse the url "Search Jobs Drummer In Houston Tx Per Page 75 Page Number 15 PN 1113"
    Then  I should be able to see in browser as URL "Search Jobs Drummer In Houston Tx Per Page 75 Page Number 14 PN 1113"
    When  I browse the url "Search Jobs Drummer In Houston Tx Per Page 100 Page Number 11 PN 1050"
    Then  I should be able to see in browser as URL "Search Jobs Drummer In Houston Tx Per Page 100 Page Number 10 PN 1050"
    When  I browse the url "Search Jobs Drummer In Houston Tx Per Page 250 Page Number 5 PN 1118"
    Then  I should be able to see in browser as URL "Search Jobs Drummer In Houston Tx Per Page 250 Page Number 4 PN 1118"
    And   I should see text p tag "Displaying" and verify message "Displaying 751 to 1,000 of"

    When  I navigate to page "Search Jobs Drummer In Houston Tx"
    And   I should see text p tag "Displaying " and verify message "Displaying 1 to 20 of "
    And   I should see "Next" link
    When  I navigate to page "Search Jobs Drummer In Houston Tx Per Page 50"
    And   I should see text p tag "Displaying " and verify message "Displaying 1 to 50 of "
    And   I should see "Next" link
    When  I navigate to page "Search Jobs Drummer In Houston Tx Per Page 100"
    And   I should see text p tag "Displaying " and verify message "Displaying 1 to 100 of "
    And   I should see "Next" link
    When  I navigate to page "Search Jobs Drummer In Houston Tx Per Page 250"
    And   I should see text p tag "Displaying " and verify message "Displaying 1 to 250 of "
    And   I should see "Next" link
