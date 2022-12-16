@ResumeUnlock @Regression @Web  @Search
Feature: Client ResumeUnlock ResumeUnlock

  @unlockWithCredits @ReleaseRegression2
  Scenario: Unlock with contact credits
    Given I login as a client
    And   I navigate to page "Client Resume Search With Keywords"
    Then  I should be able to see in browser URL "Client Resume Search Results"
    And   I find a locked candidate and verify text "Unlock Resume"
    Then  I should be able to see in browser URL "Client Resume View Candidate Profile"
    #And   I should see text "Resume has been successfully unlocked."

  @unlockWithoutCredits @ReleaseRegression2
  Scenario: Unlock without contact credits
    Given I login as a client with no credits
    And   I navigate to page "Client Resume Search With Keywords"
    Then  I should be able to see in browser URL "Client Resume Search Results"
    And   I find a locked candidate and click on unlock resume
    And   I wait for "1" seconds
    And   I click on "Buy Now"
    Then  I should be able to see in browser URL "Client Purchase"
    And   I click on "Checkout"
    Then  I should be able to see in browser URL "Client Purchase Pay Now"

  @unlockResumePagination
  Scenario: Pagination on My Unlocked Resume Page
    Given I login as testers client
    When  I navigate to page "Client My Unlocked Resumes"
    And   I should see text p tag "Displaying" and verify message "Displaying 1 to 20 of"
    And   I scroll down 0,2000
    And   I click on "2"
    Then  I should be on page "Client My Unlocked Resumes 20"
    And   I should see text p tag "Displaying" and verify message "Displaying 21 to 40 of"
    And   I should see "Prev" link
    And   I scroll down 0,2000
    When  I click on "Prev"
    Then  I should be able to see in browser URL "Client My Unlocked Resumes 0"
    And   I should not see "Prev" link

  @accountUnlockResumePagination
  Scenario: Pagination on Account Unlocked Resume Page
    Given I login as testers client
    And   I navigate to page "Client Account Unlocked Resumes"
    And   I should see text p tag "Displaying" and verify message "Displaying 1 to 20 of"
    And   I scroll down 0,2000
    And   I click on "2"
    Then  I should be on page "Client Account Unlocked Resumes 20"
    And   I should see text p tag "Displaying" and verify message "Displaying 21 to 40 of"
    And   I should see "Prev" link
    And   I scroll down 0,2000
    When  I click on "Prev"
    Then  I should be able to see in browser URL "Client Account Unlocked Resumes 0"
    And   I should not see "Prev" link

  @unlockResumeSortingByDate @ReleaseRegression2
  Scenario:Sorting By Date Unlocked on My Unlock Resume page
    Given I login as testers client
    When   I navigate to page "Client My Unlocked Resumes"
    When  I click on dates saved descending order
    Then  I should see saved dates in desc order
    When  I click on dates saved ascending order
    Then  I should see in saved dates in asc order

  @unlockResumeSortingByCandidateName
  Scenario: Sorting By Candidate Name on My Unlock Resume page
    Given I login as testers client
    When   I navigate to page "Client My Unlocked Resumes"
    And   I click on id "saved-unlocked-resume-name-asc"
    Then  I should see in Candidate name in asc order
    When  I click on id "saved-unlocked-resume-name-desc"
    Then  I should see in Candidate name in desc order

  @accountUnlockResumeSortingByDate
  Scenario:Sorting By Date Unlocked on Account Unlock Resume page
    Given I login as testers client
    When  I navigate to page "Client Account Unlocked Resumes"
    When  I click on dates saved descending order
    Then  I should see saved dates in desc order
    When  I click on dates saved ascending order
    Then  I should see in saved dates in asc order

  @accountUnlockResumeSortingByCandidateName
  Scenario: Sorting By Candidate Name on Account Unlock Resume page
    Given I login as testers client
    When  I navigate to page "Client Account Unlocked Resumes"
    And   I click on id "saved-unlocked-resume-name-asc"
    Then  I should see in Candidate name in asc order
    When  I click on id "saved-unlocked-resume-name-desc"
    Then  I should see in Candidate name in desc order

  @unlockATSImport
  Scenario: Unlock using ATS Import
    Given I login as a client
    And   I navigate to page "Client Resume Search With Keywords"
    Then  I should be able to see in browser URL "Client Resume Search Results"
    And   I find a locked candidate and verify text "Unlock Resume"
    Then  I should be able to see in browser URL "Client Resume View Candidate Profile"
    And   I click on "ATS Import"
    When  I click on Greenhouse checkbox
    And   I click on Import button
    Then  I should see text "Candidate imported successfully!" on ats import popup
    And   I should see text "Resume has been successfully unlocked"
    And   I click on "ATS Import"
    And   I should see Greenhouse checkbox is selected