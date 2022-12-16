@ResourcesPageDropToolNavigation  @Regression @Web  @Traffic
Feature: Client Resources ResourcesDropToolBarLoggedIn

  Background: Navigating to Resources page
    Given I login as a client

  @ResourcesDropToolNavigation
  Scenario: As a logged in user I see the resources page drop navigation has links
    Given  I navigate to page "Resources"
    Then   I should see text "Home"
    Then   I should see text "Attracting Candidates"
    Then   I should see text "Interviewing Tips"
    Then   I should see text "Job Market Insights"
    Then   I should see text "Making The Hire"
    Then   I should see text "Workplace"
    Then   I should see text "News"
    Then   I should see text "Events"
    Then   I should see text "COVID-19 Advice"
    When   I click on "Attracting Candidates"
    Then   I should be on page "Resources Attracting Candidates"
    Then   I should see text H one tag "Attracting Candidates"
    When   I move backward one page
    And    I click on "Interviewing Tips"
    Then   I should be on page "Resources Interviewing Tips"
    Then   I should see text H one tag "Interviewing Tips"
    When   I move backward one page
    And    I click on "Job Market Insights"
    Then   I should be on page "Resources Job Market Insights"
    Then   I should see text H one tag "Job Market Insights"
    When   I move backward one page
    And    I click on "Making The Hire"
    Then   I should be on page "Resources Making The Hire"
    Then   I should see text H one tag "Making The Hire"
    When   I move backward one page
    And    I click on link text "Workplace"
    Then   I should be on page "Resources Workplace"
    Then   I should see text H one tag "Workplace"
    When   I move backward one page
    And    I click on "News"
    Then   I should be on page "Resources News"
    Then   I should see text H one tag "News"
    When   I move backward one page
    And    I click on "Events"
    Then   I should be on page "Resources Events"
    Then   I should see text H one tag "Resume-Library Events"
    When   I move backward one page
    And    I click on "COVID-19 Advice"
    Then   I should be on page "Resources Covid 19 Advice"
    Then   I should see text H one tag "COVID-19 Advice"