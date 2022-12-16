@ResumeAlertSent @Regression @Web  @Recruiters
Feature: Client ResumeAlert ResumeAlertsSent

  @resumeAlertsSent @ReleaseRegression2
  Scenario: Verify Resume Alerts sent page
    Given I login as a client
    When  I navigate to page "Client Resume Alert"
    And   I click on link text "583"
    And   I should see element with text "Resume Alerts Sent (Ref: IWTest)" to be "visible"
    Then  I should be on page "Client Resume Alert Log 5202"
    And   I should see text p tag "Displaying" and verify message "Displaying 1 to 50 of 582"
    And   I should see text "Date sent"
    And   I should see text "Candidate ID"
    And   I should see text "Candidate name"
    And   I should see text "Alert name"
    And   I should see text "Unlocked by"
    And   I should see text "Actions"
    And   I fill in the field where id is "candidate-name-candidate-id-search" with: "9221829"
    And   I click on id "resume-alert-sent-search-btn"
    Then  I should see text p tag "Displaying" and verify message "Displaying 1 to 1 of 1"
    And   I should see text "9221829"
    And   I click on link text "View"
    Then  I switch tab
    #And   I should be able to see in browser URL "Client Resume Alert 5202"
    And   I should see text "Candidate ID:"
    And   I should see text "Resume-library, is this resume a good match to your alert?"
    And   I click on "Yes"
    And   I should see text "Resume Alert rating received - Thank you!"
    When  I am on page "Client Resume Alert Log 5202"
    And   I check show me unlocked candidates only
    #And   I should see text "You haven't unlocked any resumes yet."
    #And   I should see text p tag "View your" and verify message "View your matches for potential candidates."
    #And   I click on "matches"
    Then  I should be on page "Client Resume Alert Log 5202"

  @resumeAlertSentPagination
  Scenario:Create Alert Sent Page Pagination
    Given I login as testers client
    And   I navigate to page "Client Resume Alert"
    And   I click on "583"
    Then  I should be able to see in browser URL "Client Resume Alert Log"
    And   I should see text p tag "Displaying" and verify message "Displaying 1 to 50 of"
    And   I scroll down 0,3000
    And   I click on "2"
    Then  I should be on page "Client Resume Alert Log 5202 2"
    And   I should see text p tag "Displaying" and verify message "Displaying 51 to 100 of"
    And   I should see "Prev" link
    And   I scroll down 0,3000
    When  I click on "Prev"
    Then  I should be on page "Client Resume Alert Log 5202 1"
    And   I should not see "Prev" link
    And   I should see text p tag "Displaying" and verify message "Displaying 1 to 50 of"