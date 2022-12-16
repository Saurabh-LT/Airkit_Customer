# Test scenarios
  #1. Resume search with returned resumes shows expected buttons (basic tab)
  #2. Resume search with Zero resumes shows expected buttons (basic tab)

@ResumeSearchResults @Regression @Web  @Search
Feature: Client ResumeSearch SearchResults

Background: On resume search page
    Given I login as a client

    @resumeSearchResultsButtons
    Scenario: Resume search results expected buttons
    When I am on page "/client/resume-search/results?search_builder=1&keywords=sales+&updated_on=2+years&submt_btn=1"
    Then I should see text "Preview Resume"
    And I should see text "Invite Candidates"
    And I should see text "Post Jobs Now"
    And I should see text "Instantly contact top candidates"
    And I should see text "Client Help Center"
    And I should not see "Resume search tips" text

  @resumeSearchZeroResultsButtons
  Scenario: Resume search zero results expected buttons
    When  I am on page "/client/resume-search/results?search_builder=1&keywords=qqqq+&updated_on=3+months&submt_btn=1"
     And  I should not see "Preview Resume"
     And  I should see text "Invite Candidates"
     And  I should see text "Post Jobs Now"
     And  I should see text "Resume search tips"
     And  I should see text "Sorry, no Resumes found for that criteria."

  @resumeSearchIncompleteZipCode @ReleaseRegression2
  Scenario: Resume search with incomplete zip code
    When  I am on page "/client/resume-search/results?search_builder=1&keywords=&location=100&distance=35&updated_on=3+months&submt_btn=1"
    Then  I should see text p tag "We searched " and verify message "We searched 10001, did you mean:"
     And  I should see text "10002"
     And  I should see text "10003"
     And  I should see text "View more locations"
     And  I click on "View more locations"
     And  I should see text "10006"
     And  I should see text "10007"
     And  I should see text "View fewer locations"
     When I click on "View fewer locations"
     And  I should not see "View fewer locations" text
     And  I should see text "10002"
     And  I should see text "10002"

  @resumeSearchIncompleteLocation @ReleaseRegression2
  Scenario: Resume search with incomplete location
    When  I am on page "/client/resume-search/results?search_builder=1&keywords=&location=bos&distance=35&updated_on=3+months&submt_btn=1"
    Then  I should see text p tag "We searched " and verify message "We searched Boston, MA, did you mean:"
    And   I should see text "Bossier Parish, LA"
    And   I click on "View more locations"
    Then  I should see text "New Boston, NH"
    And   I should see text "South Boston, VA"
    When  I click on "View fewer locations"
    Then  I should not see "New Boston, NH" text
    And   I should not see "South Boston, VA" text
    And   I click on "Bossier Parish, LA"
    And   I should see text in location field "Bossier Parish, LA"