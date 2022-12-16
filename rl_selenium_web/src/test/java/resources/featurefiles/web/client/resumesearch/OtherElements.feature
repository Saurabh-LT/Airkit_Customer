@ResumeSearchOtherElements @Regression @Web  @Search
Feature: Client ResumeSearch OtherElements

  Background: On resume search page
    Given I login as a client
    Then  I navigate to page "Client Saved Search"
    Then  I delete saved search
    When  I navigate to page "Client Resume Search"

  @mySearchesSavedSearchesTab @ReleaseRegression2
  Scenario: Verify searches in My Searches
    When  I click on my searches link
    Then  I should see text H three tag "My searches"
    And   I should see text "Recent searches"
    And   I should see text "Saved searches"
    And   I click on "Saved searches"
    Then  I should see text "You haven't saved any searches yet" or delete the search
    When  I click on "Start searching"
    Then  I should be able to see in browser URL "Client Resume Search"
    And   I fill in basic search keywords with "test analyst"
    And   I enter location with "10010"
    And   I click on Search Resumes
    And   I wait for "2" seconds
    When  I click on id "save_this_search"
    Then  I should see text H three tag "Save this Search"
    When  I click on Save search submit button
    Then  I should see "Please enter a search name"
    When  I enter saved search name with "test analyst"
    And   I click on Save search submit button
    Then  I should see text "Search saved successfully!"
    And   I should see text "Search Saved"
    When  I click on my searches link
    Then  I click on tab Saved searches
    And   I should see text p tag "Displaying " and verify message "Displaying 1 to 1 of 1"
    When  I navigate to page "Client Saved Search"
    And   I click on saved search actions one
    And   I click on link text "Delete"
    Then  I click on save search delete btn
    And   I should see text "Search removed successfully"

  @mySearchesRecentSearchesTab
  Scenario: Verify searches in my recent searches
    When  I click on My searches and verify below steps
    #Then  I should see text "Job type"
    #And   I should see text "Actions"
    #And   I should see text p tag "Displaying" and verify message "Displaying 1 to "
    #And   I should see link "Run Search" with id "my-searches-run-btn"
    #When  I click on Run Search button
    #Then  I should see text "Instantly contact top candidates"

  @popularSearches
  Scenario: Verify Popular Searches
    When  I click on Popular searches link
    Then  I click on "Agriculture"
    When  I click on "Farm Worker"
    Then  I click on "Add to search"
    And   I should be able to see in browser URL "Client Resume Search"
    Then  I should see text "farm worker"
    Then  I should see text "farm assistant"

  @resetForm
  Scenario: Verify Reset form
    When  I fill in basic search keywords with "Sales"
    And   I enter location with "10010"
    Then  I click on Reset form
    And   I click on Search Resumes
    Then  I should see "No Search Criteria"

  @ResumeSearchInviteToApply @ReleaseRegression2
  Scenario: Resume Search Invite to Apply
    When  I fill in basic search keywords with "Sales"
    And   I enter location with "10010"
    And   I select "Ever" from active within dropdown
    And   I wait for "2" seconds
    And   I click on Search Resumes
    Then  I should see text "Instantly contact top candidates"
    When  I select email candidate amount from list
    And   I click on "Invite Candidates"
    Then  I should see text H three tag "Unlock Resumes"
    And   I should see "Unlock & Invite" link
    When  I click on "Unlock & Invite"
    Then  I should see text H three tag "Invite Candidates"
    When  I click on "Send Invites"
    Then  I should see text "Please enter a subject line"
    And   I should see text "Please enter a message"
    When  I enter subject as "SubjectTest"
    And   I enter message in TextArea with 100 characters
    When  I click on Preview
    Then  I should see text H three tag "Preview Your Invites"
    And   I click on "Close Preview"
    When  I select related job "NonExternalTestJob90001, CA"
    Then  I should see message text "Hi,  I came across your resume and thought you would be a great fit for our role. I've included some details about the job below for you.  Hopefully this role is of interest to you.  Thanks {Client name}"
    When  I click on Preview
    Then  I should see text H three tag "Preview Your Invites"
    When  I click on "Close Preview"
    And   I should see element with text "Send Invites" to be "visible"
    And   I click on "Send Invites"
    Then  I should see text H three tag "Invite Sent"
    And   I click on "OK"

  @ResumeSearchInviteToApplyDice
  Scenario: Resume Search Invite to Apply for Dice candidates
    When  I fill in basic search keywords with "13935566"
    And   I click on More Search Options
    And   I select "Ever" from active within dropdown
    And   I wait for "2" seconds
    And   I click on Search Resumes
    When  I select email candidate amount from list
    And   I click on "Invite Candidates"
    Then  I should see text H three tag "Unlock Resumes"
    And   I should see "Unlock & Invite" link
    When  I click on "Unlock & Invite"
    Then  I should see text H three tag "Invite Candidates"
    When  I click on "Send Invites"
    Then  I should see text "Please enter a subject line"
    And   I should see text "Please enter a message"
    When  I enter subject as "SubjectTest"
    And   I enter message in TextArea with 100 characters
    When  I click on Preview
    Then  I should see text H three tag "Preview Your Invites"
    And   I click on "Close Preview"
    When  I select related job "NonExternalTestJob90001, CA"
    Then  I should see message text "Hi,  I came across your resume and thought you would be a great fit for our role. I've included some details about the job below for you.  Hopefully this role is of interest to you.  Thanks {Client name}"
    When  I click on Preview
    Then  I should see text H three tag "Preview Your Invites"
    When  I click on "Close Preview"
    And   I should see element with text "Send Invites" to be "visible"
    And   I click on "Send Invites"
    Then  I should see text H three tag "Invite Sent"
    And   I click on "OK"