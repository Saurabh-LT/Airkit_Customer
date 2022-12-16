@ClientHelpJobPosting @Regression @Web  @Recruiters
Feature: Client JobPosting ClientHelp

    @ClientHelpJobPosting
  Scenario: Verify client help links and texts for job posting
    Given I login as a client
    When  I navigate to page "Client Help Job Posting"
    Then  I should see text H one tag "Job Posting Tips"
    And   I should see text H two tag "How to Post a Job"
    And   I should see text "You can access the Post a Job page in multiple ways:"
    When  I click on "https://www.resume-library.com/job/post"
    Then  I should be able to see in browser URL "Job Post"
    And   I should see text H one tag "Post a Job"
    When  I navigate to page "Client Help Job Posting"
    Then  I click on "here"
    And   I should be able to see in browser URL "Client Products Jobs"
    And   I should see text H two tag "Featured Job Posting"

    When  I navigate to page "Client Help Job Posting"
    Then  I should see bread crumbs "Client Help Center > Job Posting Tips" with class name: "breadcrumbs"

    When  I navigate to page "Client Help Job Posting"
    Then  I click on "Client Help Center Home"
    And   I should be able to see in browser URL "Client Help"
    And   I should see text H one tag "Client Help Center"

    When  I navigate to page "Client Help Job Posting"
    Then  I click on "Client FAQs"
    And   I should be able to see in browser URL "Faq"
    And   I should see text H one tag "How Can We Help You?"

    When  I navigate to page "Client Help Job Posting"
    Then  I click on "Job Posting Tips"
    And   I should be able to see in browser URL "Client Help Job Posting"

    When  I navigate to page "Client Help Job Posting"
    Then  I click on "Job Enhancement Tips"
    And   I should be able to see in browser URL "Client Help Vacancy Enhancements"
    And   I should see text H one tag "Job Enhancement Tips"

    When  I navigate to page "Client Help Job Posting"
    Then  I click on "Resume Search Tips"
    And   I should be able to see in browser URL "Client Help Search Tips"
    And   I should see text H one tag "Resume Search Tips"

    When  I navigate to page "Client Help Job Posting"
    Then  I click on "Resume Alert Tips"
    And   I should be able to see in browser URL "Client Help Alert Tips"
    And   I should see text H one tag "Resume Alert Tips"

    When  I navigate to page "Client Help Job Posting"
    Then  I click on "Video Guides"
    And   I should be able to see in browser URL "Client Help Videos"
    And   I should see text H one tag "Video Guides"

    When  I navigate to page "Client Help Job Posting"
    Then  I click on "Download User Manual"
    And   I should be able to see in browser obfuscated URL "Downloads Rl User Manual"

    When  I navigate to page "Client Help Job Posting"
    Then  I click on "Contact Us"
    And   I should be able to see in browser URL "Client Contact"
    And   I should see text H one tag "Contact us"