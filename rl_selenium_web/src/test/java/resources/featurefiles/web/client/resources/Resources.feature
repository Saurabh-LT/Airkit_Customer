@Resources @Regression @Web  @Traffic
Feature: Client Resources Resources

  @loadResources @ReleaseRegression2
  Scenario: Load the resources page
    Given  I navigate to page "Resources"
    Then   I should see resume Library Employers header logo
    When   I click on the RL Employers header logo
    Then   I should be on page "Hiring"
    When   I navigate to page "Resources"
    Then   I should see "Resume Search" link
    Then   I should see "Post Jobs" link
    Then   I should see "Products" link
    And    I should see "Login" link
    And    I should see "Hire Now" link
    And    I should see "Find Jobs" link
    Then   I should see "Resources" link
    When   I mouse hover Resources Navigation menu
    Then   I should see "Demographics" link
    Then   I should see "Integrations" link
    Then   I should see "Hiring Insights" link
    Then   I should see "Events" link
    Then   I should see "Video Guides" link
    When   I mouse hover Resources Navigation menu
    Then   I click on link text "Demographics"
    Then   I should be able to see in browser URL "Hiring Demographics"
    When   I mouse hover Resources Navigation menu
    Then   I click on link text "Integrations"
    Then   I should be able to see in browser URL "Partner Integrations"
    When   I mouse hover Resources Navigation menu
    Then   I click on link text "Hiring Insights"
    Then   I should be able to see in browser URL "Resources"
    When   I mouse hover Resources Navigation menu
    Then   I click on link text "Events"
    Then   I should be able to see in browser http URL "Resources Events"
    When   I mouse hover Resources Navigation menu
    Then   I click on link text "Video Guides"
    Then   I should be able to see in browser URL "Hiring Video Guides"

  @verifyCategories @ClientE2E
  Scenario: Verify the elements
    Given I navigate to page "Resources"
    And   I should see resume Library header logo
    Then  I should see text "Latest Articles"
    And   I should see text "Attracting Candidates"
    And   I should see text "Interviewing Tips"
    And   I should see text "Job Market Insights"
    And   I should see text "Making The Hire"
    And   I should see text "Workplace"
    When  I am on page "Resources Latest"
    And   I click on "2"
    Then  I should see text H one tag "Latest"
    Then  I should see text "Categories"
    Then  I should see text "Latest Articles"

  @resourcesNavigationBar
  Scenario: As a logged in user I see the resources navigation bar has search candidates link, a telephone number and a contact us button
    Given  I login as a client
    And    I navigate to page "Resources"
    Then   I should see text a tags "Search our" and verify "Search our candidate database today"
    When   I click on search our candidate database link
    Then   I should be on page "Client Resume Search"
    When   I navigate to page "Resources"
    And    I should see text p tag "Call our Client Help Center on " and verify message "Call our Client Help Center on 1-857-239-0143"
    And    I should see text "Contact Us"
    When   I click on client contact us btn
    Then   I should see text "Your Customer Success Executive"
    And    I should see text "Client Help Center"
    And    I should see text "General Enquiries"
    And    I should contact us email link
    When   I click on help center btn
    Then   I should be on page "Client Help"
    When   I navigate to page "Resources"
    When   I click on client contact us btn
    Then   I should see "Contact form" link
    When   I click on contact form btn
    Then   I should be on page "/client/contact?show_form=1#contact-us-row"

  @ResourcesPageLoggedOutClientBanner
  Scenario: As a logged out client user I see the resources banner for resume search and for jobs.
    Given  I navigate to page "Resources"
    Then   I scroll down 0,600
    And    I should see resources-switch-banner "Resume Search"
    Then   I should be able to see in browser http URL "Hiring Resume Search"
    When   I navigate to page "Resources"
    Then   I scroll down 0,600
    And    I should see resources-switch-banner "Post A Job"
    Then   I should be able to see in browser http URL "Hiring Post Jobs"

  @ResourcesDropNavigation @ReleaseRegression2
  Scenario: As a logged out user I see the resources page drop navigation has links
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
    When   I navigate to page "Resources"
    And    I click on "Interviewing Tips"
    Then   I should be on page "Resources Interviewing Tips"
    Then   I should see text H one tag "Interviewing Tips"
    When   I navigate to page "Resources"
    And    I click on "Job Market Insights"
    Then   I should be on page "Resources Job Market Insights"
    Then   I should see text H one tag "Job Market Insights"
    When   I navigate to page "Resources"
    And    I click on "Making The Hire"
    Then   I should be on page "Resources Making The Hire"
    Then   I should see text H one tag "Making The Hire"
    When   I navigate to page "Resources"
    And    I click on "Workplace"
    Then   I should be on page "Resources Workplace"
    Then   I should see text H one tag "Workplace"
    When   I navigate to page "Resources"
    And    I click on "News"
    Then   I should be on page "Resources News"
    Then   I should see text H one tag "News"
    When   I navigate to page "Resources"
    And    I click on "Events"
    Then   I should be on page "Resources Events"
    Then   I should see text H one tag "Events"
    When   I navigate to page "Resources"
    And    I click on "COVID-19 Advice"
    Then   I should be on page "Resources Covid 19 Advice"
    Then   I should see text H one tag "COVID-19 Advice"

  @ResourcesPageSubNavBar
  Scenario: As a logged out user I see the resources navigation bar has  search jobs link
    Given  I navigate to page "Resources"
    Then   I should see text on resources page "Email us: sales@resume-library.com"
    And    I should see text "1-800-672-6706"

  @ResourcesPageLoggedOutBanner
  Scenario: As a logged out user I see the resources banner for resume search and for jobs.
    Given  I navigate to page "Resources"
    Then   I scroll down 0,600
    And    I should see resources-switch-banner "Resume Search"
    Then   I should be able to see in browser http URL "Hiring Resume Search"
    When   I navigate to page "Resources"
    Then   I scroll down 0,600
    And    I should see resources-switch-banner "Post A Job"
    Then   I should be able to see in browser http URL "Hiring Post Jobs"

  @ResourcesPageLoggedInChatWindow
  Scenario: As a logged out user I see the resources navigation bar has  Live chat button
    Given  I login as a client
    Then   I navigate to page "Resources"
    Then   I should see transparent-button envelope is displayed
    When   I click on the envelope
    Then   I should see "Contact Us" popup displayed