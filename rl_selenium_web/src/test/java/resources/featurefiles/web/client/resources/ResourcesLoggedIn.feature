@ResourcesPageLoggedInClient @Regression @Web  @Traffic
Feature: Client Resources ResourcesLoggedIn

  Background: Login as a client to verify resources page
    Given I login as a client

  @ResourcesPageLoggedInHeaders1
  Scenario: As a registered user logged in and verify the navigation menu
    When  I navigate to page "Resources"
    Then  I should see resume Library Employers header logo
    Then  I should see text "Dashboard"
    And   I should see text "Resume Search"
    And   I should see text "Manage Jobs"
    And   I should see text "Resume Alerts"
    And   I should see text "Products"
    And   I should see text "Hi Resume library"
    When  I mouse hover "Resume Search"
    Then  I should see text "Search Resumes"
    When  I click on link text "Search Resumes"
    Then  I reload the page
    Then  I should see element with text "Resume Search" to be "visible"
    Then  I should be able to see in browser URL "Client Resume Search"

    When  I mouse hover to link "Resume Search"
    Then  I should see text "Saved Searches"
    When  I click on link text "Saved Searches"
    And   I should see element with text "Saved Resume Searches" to be "visible"
    Then  I should be able to see in browser URL "Client Saved Search"

    When  I mouse hover to link "Resume Search"
    Then  I should see text "Saved Resumes"
    When  I click on link text "Saved Resumes"
    And   I should see element with text "My Saved Resumes" to be "visible"
    Then  I should be able to see in browser URL "Client My Saved Resumes"

    When  I mouse hover to link "Resume Search"
    And   I should see text "Unlocked Resumes"
    When  I click on link text "Unlocked Resumes"
    And   I should see element with text "My Unlocked Resumes" to be "visible"
    Then  I should be able to see in browser URL "Client My Unlocked Resumes"

    When  I mouse hover to link "Resume Search"
    And   I should see text "Popular Searches"
    When  I click on link text "Popular Searches"
    And   I should see element with text "Select your industry" to be "visible"
    Then  I should be able to see in browser URL "Client Resume Search"

  @ResourcesPageLoggedInHeaders2
  Scenario: As a registered user logged in and verify resume search menu
    When  I navigate to page "Resources"

    When  I mouse hover to link "Manage Jobs"
    Then  I should see text "Manage Jobs"
    When  I click on link text "Manage Jobs"
    Then  I should be able to see in browser URL "Client Jobs"

    When  I mouse hover to link "Manage Jobs"
    And   I should see text "Post a Job Now"
    When  I click on link text "Post a Job Now"
    Then  I should be on page "Job Post"

    When  I mouse hover to link "Manage Jobs"
    And   I should see text "Job Applications"
    When  I click on link text "Job Applications"
    Then  I should be able to see in browser URL "Client Job Applications"

    When  I mouse hover to link "Manage Jobs"
    And   I should see text "Manage Job Templates"
    When  I click on link text "Manage Job Templates"
    Then  I should be able to see in browser URL "Client Jobs Templates"

  @ResourcesPageLoggedInHeaders3
  Scenario: As a registered user logged in and verify manage jobs menu
    When  I navigate to page "Resources"

    When  I mouse hover to link "Resume Alerts"
    Then  I should see text "Resume Alerts"
    When  I click on "Resume Alerts"
    Then  I should be able to see in browser URL "Client Resume Alerts"

    When  I mouse hover to link "Resume Alerts"
    And   I should see text "Create New Alert"
    When  I click on "Create New Alert"
    Then  I should be able to see in browser URL "Client Resume Alert Create"

    When  I mouse hover to link "Resume Alerts"
    And   I should see text "View Sent Alerts"
    When  I click on "View Sent Alerts"
    Then  I should be able to see in browser URL "Client Resume Alerts Log"

  @ResourcesPageLoggedInHeaders4
  Scenario: As a registered user logged in and verify products menu
    When  I navigate to page "Resources"

    When  I mouse hover Products Navigation menu
    Then  I should see text "Contact Credits"
    When  I click on "Contact Credits"
    Then  I should be able to see in browser URL "Client Products Contact Credits"

    When  I mouse hover Products Navigation menu
    And   I should see text "Job Postings"
    When  I click on "Job Postings"
    Then  I should be able to see in browser URL "Client Products Jobs"

  @ResourcesPageLoggedInHeaders5
  Scenario: As a registered user logged in and verify profile menu
    When  I navigate to page "Resources"

    When  I click on "Hi Resume library"
    Then  I should see text "Edit Company Profile"
    When  I click on "Edit Company Profile"
    Then  I should be able to see in browser URL "Client Company Profile"

    When  I mouse hover "Hi Resume library"
    And   I should see text "Integrated Services"
    When  I click on "Integrated Services"
    Then  I should be able to see in browser URL "Client Account Integrated Services"

    When  I mouse hover "Hi Resume library"
    Then  I should see text "Client Help Center"
    When  I click on "Client Help Center"
    Then  I should be able to see in browser URL "Client Help"

    When  I mouse hover "Hi Resume library"
    And   I should see text "Logout"

  @ResourcesDropNavigationLoggedIn @ReleaseRegression2
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
    When   I click on link text "Attracting Candidates"
    Then   I should be on page "Resources Attracting Candidates"
    Then   I should see text H one tag "Attracting Candidates"
    When   I move backward one page
    And    I click on link text "Interviewing Tips"
    Then   I should be on page "Resources Interviewing Tips"
    Then   I should see text H one tag "Interviewing Tips"
    When   I move backward one page
    And    I click on link text "Job Market Insights"
    Then   I should be on page "Resources Job Market Insights"
    Then   I should see text H one tag "Job Market Insights"
    When   I move backward one page
    And    I click on link text "Making The Hire"
    Then   I should be on page "Resources Making The Hire"
    Then   I should see text H one tag "Making The Hire"
    When   I move backward one page
    And    I click on link text "Workplace"
    Then   I should be on page "Resources Workplace"
    Then   I should see text H one tag "Workplace"
    When   I move backward one page
    And    I click on link text "News"
    Then   I should be on page "Resources News"
    Then   I should see text H one tag "News"
    When   I move backward one page
    And    I click on link text "Events"
    Then   I should be on page "Resources Events"
    Then   I should see text H one tag "Events"
    When   I move backward one page
    And    I click on link text "COVID-19 Advice"
    Then   I should be on page "Resources Covid 19 Advice"
    Then   I should see text H one tag "COVID-19 Advice"

  @ResourcesPageSubNavBarLoggedIn
  Scenario: As a logged in user I see the resources navigation bar has search jobs link
    Given  I navigate to page "Resources"
    Then   I should see text a tags "Search our" and verify "Search our candidate database today"
    And    I should see text "1-800-672-6706"