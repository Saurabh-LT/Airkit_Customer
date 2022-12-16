@CareerAdviceHeaderFooterLoggedOut @Regression @Web  @ReleaseRegression1 @Candidate
Feature: Candidate CareerAdvice CareerAdviceHeadersFooters

  @CareerAdviceNavigateHeader
  Scenario: Navigation header for logged out user
    Given  I navigate to page "Career Advice"
    Then   I should see resume Library footer logo
    When   I click on the logged out RL header logo
    Then   I should be on page "/"
    Then   I should see text "Search Jobs"
    When   I navigate to page "Career Advice"
    Then   I scroll down 0,5000
    And    I click on link text "Search Jobs"
    Then   I should be able to see in browser URL "Search Jobs"
    When   I navigate to page "Career Advice"
    Then   I scroll down 0,5000
    Then   I click on link text "Job Alerts"
    Then   I should be able to see in browser URL "Job Alerts"
    When   I navigate to page "Career Advice"
    Then   I scroll down 0,5000
    Then   I should be able to see in browser URL "Career Advice"
    When   I navigate to page "Career Advice"
    Then   I scroll down 0,5000
    And    I click on link text "Saved Jobs"
    Then   I should be able to see in browser URL "Saved Jobs"
    When   I navigate to page "Career Advice"
    Then   I scroll down 0,5000
    And    I click on link text "Login"
    Then   I should be able to see in browser URL "Login"
    When   I navigate to page "Career Advice"
    Then   I scroll down 0,5000
    And    I click on link text "Hiring?"
    Then   I should be able to see in browser URL "Hiring"

  @CareerAdviceNavigateFooterJobSeekers
  Scenario: Navigation Footer JobSeekers Menu for logged out user
    Given  I navigate to page "Career Advice"
    Then   I should see resume Library footer logo
    When   I click on resume Library footer logo
    Then   I should see text H four tag "Jobseekers"
    And    I should see hyperlink "Search Jobs"
    And    I should see hyperlink "Career Advice"
    And    I should see hyperlink "Free Resume Review"
    And    I should see hyperlink "Search Companies"
    And    I should see hyperlink "Login"
    When   I navigate to page "Career Advice"
    Then   I click on "Register" in footer menu job seekers and verify url "Candidate Registration Page"
    When   I navigate to page "Career Advice"
    And    I click on "Search Jobs" in footer menu job seekers and verify url "Search Jobs"
    When   I am on page "Career Advice"
    And    I click on "Free Resume Review" in footer menu job seekers and verify url "Resume Review"
    When   I am on page "Career Advice"
    And    I click on "Search Companies" in footer menu job seekers and verify url "Companies"
    When   I am on page "Career Advice"
    And    I click on "Login" in footer menu job seekers and verify url "Login"

  @CareerAdviceNavigateFooterHiring
  Scenario: Navigation Footer Hiring Menu for logged out user
    When   I am on page "/"
    Then   I click on "Career Advice"
    Then   I should see text H four tag "Hiring?"
    Then   I should see hyperlink "Employers"
    And    I should see hyperlink "Post Jobs"
    And    I should see hyperlink "Search Resumes"
    And    I should see hyperlink "Partner Network"
    And    I should see hyperlink "Employer Login"
    When   I navigate to page "Career Advice"
    Then   I click on "Employers" in footer menu hiring and verify url "Hiring"
    When   I navigate to page "Career Advice"
    Then   I click on "Post Jobs" in footer menu hiring and verify url "Hiring Post Jobs"
    When   I navigate to page "Career Advice"
    Then   I click on "Search Resumes" in footer menu hiring and verify url "Hiring Resume Search"
    When   I navigate to page "Career Advice"
    Then   I click on "Partner Network" in footer menu hiring and verify url "/hiring/partner-network"
    When   I navigate to page "Career Advice"
    Then   I click on "Employer Login" in footer menu hiring and verify url "Hiring Login"

  @CareerAdviceNavigateFooterRL @CandidateE2E
  Scenario: Navigation Footer Resume-Library Menu for logged out user
    When   I navigate to page "Career Advice"
    Then   I should see text H four tag "Resume-Library"
    Then   I should see hyperlink "About Us"
    And    I should see hyperlink "Contact Us"
    And    I should see hyperlink "FAQs"
    And    I should see hyperlink "Meet the Team"
    And    I should see hyperlink "Work For Us"
    When   I navigate to page "Career Advice"
    Then   I scroll down 0,5000
    And    I click on "About Us" in footer menu Resume-Library and verify url "About"
    When   I navigate to page "Career Advice"
    And    I click on "Contact Us" in footer menu Resume-Library and verify url "Contact"
    When   I navigate to page "Career Advice"
    And    I click on "Meet the Team" in footer menu Resume-Library and verify url "Meet The Team"
    When   I navigate to page "Career Advice"
    And    I click on "Work For Us" in footer menu Resume-Library and verify url "/company/4394/resume-library-jobs"

  @CareerAdviceLoggedOutScrollUpDown
  Scenario: As a logged out user on the Career Advice page I should be able to use scroll up button
    Given  I navigate to page "Career Advice"
    Then   I scroll down 0,5000
    Then   I scroll up 0,2000
    Then   I scroll up 0,1000
    Then   I should see element with id "back-to-top" on the page
    When   I click on back to top button
    Then   I scroll to an element "Search Jobs"
    Then   I should see resume Library header logo
    And    I should see text "Career Advice"
    And    I should see hyperlink "Login"
    And    I should see hyperlink "Register"
    And    I should see hyperlink "Hiring?"