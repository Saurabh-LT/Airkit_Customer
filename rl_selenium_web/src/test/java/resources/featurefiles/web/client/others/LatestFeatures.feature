@LatestFeatures @Regression @Web  @Traffic
Feature: Client Others LatestFeatures

  Background: Verify page elements in Latest Features page
    Given  I login as a client
    When   I navigate to page "Client Latest Features"

  @verifyLatestFeaturesPage1 @ReleaseRegression2
  Scenario: Verify post job in Latest Features page
    Then   I should be on page "Client Latest Features"
    And    I should see text "Latest Features"
    And    I should see text "Stand Out with Premium Featured Jobs"
    And    I should see text "Format Your Jobs and Attract More Interest"
    And    I click on post a job button
    Then   I should be on page "Job Post"
    And    I scroll into view header
    And    I should see text "Post a Job"
    When   I navigate to page "Client Latest Features"
    And    I click on "View Products"
    Then   I should be on page "Hiring Products"
    And    I should see text "Our Hiring Products"

  @verifyLatestFeaturesPage2
  Scenario: Verify CCPA and ITA in Latest Features page
    Then   I should be on page "Client Latest Features"
    And    I click on id "search-builder-search-btn"
    Then   I should be on page "Client Resume Search"
    And    I should see text "Resume Search"
    When   I navigate to page "Client Latest Features"
    And    I scroll down to element "California Consumer Privacy Act of 2018 (CCPA)"
    And    I click on "California Consumer Privacy Act of 2018 (CCPA)"
    Then   I should be able to see in browser URL "/privacy#californian_residents"
    And    I should see text "Privacy Notice for Californian Residents"
    When   I navigate to page "Client Latest Features"
    And    I click on "Quick Apply"
    And    I should see "You can now accept applications from candidates that do not hold an up to date resume. This will improve your application rate and ensure you don't miss a great candidate match."
    And    I click on "Invite to Apply"
    And    I should see "Invite to Apply has been updated so you can multi-select candidates from search results to choose which ones you want to email inviting them to apply to your jobs."
    And    I click on "Import to ATS: Greenhouse"
    And    I should see text "Users of Greenhouse ATS can now import candidates directly from Resume-Library into their ATS talent pool."