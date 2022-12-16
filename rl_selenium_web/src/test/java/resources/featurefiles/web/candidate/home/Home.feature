@HomePage @Regression @Web  @ReleaseRegression1 @Candidate
Feature: Candidate Home Home

  Background: Navigate to  page
    Given  I am on page "/"

  @jobSearchFromHomePage @Safari
  Scenario Outline: Verify Home Page
    Then  I should not see search jobs navigation bar button
    And   I should see text H one tag "Find a job"
    And   I fill in search title field with "<Title>"
    And   I fill in search location with "<Location>"
    And   I select "<Distance>" from search distance
    And   I click on find jobs button
    Then  I should be able to see in browser URL "Jobs Sales In 10001"
    And   I should see text H one tag "Sales jobs in 10001"
    And   the title field should contain "<Title1>"
    And   the location field should contain "<Location>"
    And   the distance field should contain "<Distance1>"

    Examples:
      | Title | Location | Distance | Distance1 |   Title1 |
      | Sales | 10001    | 20 Miles |   20      |   sales  |

  @homePageRecentSearches @Safari
  Scenario: Search for a job and verify that recent searches are displayed on home page
    When  I navigate to page "Jobs Sales"
    Then  I am on page "/"
    And   I should see text "Recent Searches"
    And   I click on recent searches link
    And   I should see text "Sales jobs"
    And   I click on "Sales jobs"
    And   I should be able to see in browser URL "Jobs Sales"
    Then  I am on page "/"
    And   I should see text "Here are some job matches you might like. We've based them on your previous search." on the page
    And   I should see text "See more job matches"
    Then  I click on "See more job matches"
    And   I should be able to see in browser URL "Jobs Sales"

  @homeClearRecentSearches @Safari
  Scenario: Search for a job and verify clear recent searches
    When  I navigate to page "Jobs Sales"
    Then  I am on page "/"
    And   I should see text "Recent Searches"
    And   I click on recent searches link
    And   I should see text "Sales jobs"
    And   I click on clear recent searches link
    And   I confirm browser popup
    Then  I should not see "Recent Searches"

  @homePageOtherLinksPart1 @Safari
  Scenario: Validate other links on home page part1
    And   I should see text "Upload your Resume"
    And   I should see text "Employers"
    When  I click on "Upload your Resume"
    Then  I should be able to see in browser URL "/candidate/registration"
    Then  I move backward one page
    When  I click on "Employers"
    Then  I should be able to see in browser URL "/hiring"
    Then  I move backward one page
    And   I should see text "Jobs by Industry"
    And   I click on "Accounting"
    Then  I should be on page "Jobs Accounting"
    And   I should see text H one tag "Accounting jobs"
    Then  I move backward one page
    And   I click on "Jobs by State"
    And   I click on "Alabama"
    Then  I should be on page "Jobs In Alabama Al State"
    And   I should see text H one tag "Jobs in Alabama"
    Then  I move backward one page
    And   I click on "Jobs by City"
    And   I click on "Arlington, TX"
    Then  I should be on page "Jobs In Arlington Tx"
    And   I should see text H one tag "Jobs in Arlington, TX"
    Then  I move backward one page
    And   I click on "Popular Jobs"
    And   I click on "Administrative Assistant"
    Then  I should be on page "Jobs Administrative Assistant"
    And   I should see text H one tag "Administrative Assistant jobs"
    Then  I move backward one page
    Then  I should see text "Upload your Resume"
    And   I should see text "Employers"
    When  I click on "Upload your Resume"
    Then  I should be able to see in browser URL "/candidate/registration"
    Then  I move backward one page
    When  I click on "Employers"
    Then  I should be able to see in browser URL "/hiring"

  @homePageOtherLinksPart2 @safari
  Scenario: Validate other links and buttons on home page part2
    And   I should see text H two tag "Featured Companies"
    And   I click on "View all companies"
    Then  I should be on page "Companies"
    And   I should see text H one tag "Search Companies"
    Then  I move backward one page
   And   I should see text "America's Fastest-Growing Job Board" on the page source
    And   I should see "Resume-Library is one of the leading U.S. job boards, ready to assist with every aspect of your job hunt."
    And   I should see text p tag "Upload your resume and use our " and verify message "Upload your resume and use our advanced searching tool to browse jobs, from over 50 different industries. Our Career Advice, written by industry experts, will support you from job search, to interview, and beyond."
    And   I click on "advanced searching tool"
    Then  I should be on page "Search Jobs"
    And   I should see text H one tag "Advanced Job Search"
    Then  I move backward one page
    And   I click on "browse jobs"
    Then  I should be on page "Search Jobs Locations"
    And   I should see text H one tag "Browse Jobs By Location"
    Then  I move backward one page
    And   I click on "50 different industries"
    Then  I should be on page "Search Jobs"
    And   I should see text H one tag "Advanced Job Search"
    Then  I move backward one page
    And   I click on "Career Advice"
    Then  I should be on page "Career Advice"
    And   I should see text H one tag "Career Advice"

  @homePageOtherLinksPart3 @Safari
  Scenario: Validate other links and buttons on home page part3
    And   I should see text H two tag "Register your Resume"
    And   I should see text H two tag "Job Alerts"
    And   I should see text p tag "in minutes and let the jobs find you. With companies headhunting talent across 50 different industries, get noticed and get hired, fast!" and verify message "Upload your resume in minutes and let the jobs find you. With companies headhunting talent across 50 different industries, get noticed and get hired, fast!"
    And   I click on link text "Register Now"
    Then  I should be on page "Candidate Registration Page"
    And   I should see text h one tags "Upload Resume & " and verify message "Upload Resume & Register Today"
    Then  I move backward one page
    And   I should see text p tag "Receive the latest" and verify message "Receive the latest jobs straight to your inbox with Job Alerts. They take seconds to set up and you can apply instantly to the best job matches!"

    And   I click on "Get Job Alerts"
    Then  I should be on page "Job Alerts"
    And   I should see text H three tag "Create a Job Alert"

    Then  I move backward one page
    And   I should see text "Make your resume stand out with a free Resume Review! You'll receive useful advice from an expert."
    And   I click on "Free Resume Review"

    Then  I should be on page "Resume Review"
    And   I should see text H three tag "FREE Resume Review"
    Then  I move backward one page
    And   I should see "Find career tips, salary guides, interview advice and cover letter templates to help you reach your career goals."
    And   I click on "Career Advice"
    Then  I should be able to see in browser http URL "Career Advice"
    And   I should see text H one tag "Career Advice"

    Then  I move backward one page
    And   I should see "Download the Resume-Library app and search jobs on the go. Available on Apple App Store and Google Play."
    And   I click on "Job Search App"
    Then  I should be on page "/search-jobs-on-the-go"
    And   I should see text H one tag "Search and Apply to Jobs On-the-Go!"
    And   I should see text p tag "Stay on top of the freshest job opportunities in your industry with " and verify message "Stay on top of the freshest job opportunities in your industry with Resume-Library's Job Search App - available free on mobile and tablet devices."

  @homePageResumeLibraryLogo @homePage @CandidateE2E @Safari
  Scenario: Validate resume library logo on home page
    Then  I should see resume library logo

  @homePageDropdowns @Safari
  Scenario Outline: Validate the link Text under Jobs by Industry, Jobs by State, Jobs by City and Popular Jobs tabs on HomePage
    And   I should see text "Jobs by Industry"
    Then  I should see linkText "<JobsByIndustry>" under Jobs by Industry tab
    And   I click on "Jobs by State"
    Then  I should see linkText "<JobsByState>" under Jobs by State tab
    And   I click on "Jobs by City"
    Then  I should see linkText "<JobsByCity>" under Jobs by City tab
    And   I click on "Popular Jobs"
    Then  I should see linkText "<PopularJobs>" under Popular Jobs tab
    Examples:
      |   JobsByIndustry     | JobsByState  | JobsByCity | PopularJobs              |
      |   Manufacturing      | South Dakota | Denver, CO | Administrative Assistant |

  @homePageHeaderAndDropdownLinksAndProfileIcon
  Scenario: Home Page Header Links and Candidate Dropdown links and also Profile Icon navigations
    Given I login as a candidate
    When  I click on "My Dashboard" Header Link
    Then  I should be on page "Candidate My Dashboard"
    And   I should see text H one tag "My Dashboard"
    When  I click on "My Profile" Header Link
    Then  I should be on page "Candidate My Profile"
    And   I should see text H one tag "My Profile"
    When  I click on "Job Alerts" Header Link
    Then  I should be on page "Candidate Job Alerts"
    And   I should see text H one tag "Job Alerts"
    And   I click on "Saved Jobs" Header Link
    Then  I should be on page "/candidate/saved-jobs"
    And   I should see text H one tag "My Saved Jobs"
    When  I click on "My Applications" Header Link
    Then  I should be on page "Candidate Myapplications"
    And   I should see text H one tag "My Applications"
    When  I click on "My Settings" Header Link
    Then  I should be on page "Candidate Settings"
    And   I should see text H one tag "My Settings"
    When  I click on "My Email Preferences" Header Link
    Then  I should be on page "Candidate Email Preferences"
    And   I should see text H one tag "My Email Preferences"
    When  I click on "Logout" Header Link
    Then  I should be on page "Logout"
    And  I should see text p tag " Thanks for using Resume-Library!" and verify message "You have been logged out successfully. Thanks for using Resume-Library!"