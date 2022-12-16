@DemographicsPage @Regression @Web  @Traffic
Feature: Client Others DemographicsPage

  Background: on Demographics page
    Given  I login as a client
    Then   I navigate to page "Hiring Demographics"

  @pageVerify
  Scenario: Verify text and elements on Demographics Page
    Then  I should see text "Demographics"
    Then  I should see text "Our Resume Database"
    Then  I should see text "Access millions of candidates in the U.S."
    Then  I should see text "State Breakdown"
    Then  I should see text "Sector Breakdown"
    And   I should see text "Explore candidates from every sector across the U.S."

  @verifySector @ReleaseRegression2
  Scenario: Verify results by changing sector and location
    And   I should see element with text "Explore candidates from every sector across the U.S." to be "visible"
    And   I scroll down to element "Choose sector"
    When  I select the option "Accounting" from "Sector" field
    And   I scroll to an element "Choose location"
    Then  I select the option "California" from "Status" field
    And   I confirm browser popup
    Then  I should see "Resume Matches"
    When  I click on "Preview Resume"
    And   I switch tab
    Then  I should be able to see in browser URL "Client Resume View Candidate Profile" or I should see "Client Resume Search"

  @verifyViewAllMatches
  Scenario: Verify View All Matches
    When  I select the option "Sales" from "Sector" field
    And   I select the option "Massachusetts" from "Status" field
    And   I confirm browser popup
    And   I scroll down 0,1500
    And   I should see element with text "View All Matches" to be "visible"
    And   I click on "View All Matches"
    Then  I should be able to see in browser URL "Client Resume Search Results"
    And   I should see "Sales" in search builder keywords text area
    And   I find value "State of Massachusetts" and store as a variable