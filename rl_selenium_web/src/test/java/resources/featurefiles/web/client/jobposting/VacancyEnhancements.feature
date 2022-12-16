@ClientHelpVacancyEnhancement @Regression @Web  @Recruiters
Feature: Client JobPosting VacancyEnhancements

  Background: Client Help Vacancy Enhancement
    Given I login as a client
    When  I navigate to page "Client Help Vacancy Enhancements"

  @ClientHelpJobPostingVacancyEnhancement
  Scenario: Verify client help links and texts for job posting Vacancy Enhancements
    Then  I should see text H one tag "Job Enhancement Tips"
    And   I should see text H three tag "Other Help Topics"
    And   I should see text H two tag "Top Tips to Attract Candidates"
    And   I should see text H three tag "Job Title"
    And   I should see text H three tag "Job Details"
    And   I should see text H three tag "Spelling and Layout"
    And   I should see text H three tag "Location"
    And   I should see text H three tag "Refreshing Jobs"
    When  I click on "Post a Job"
    Then  I should be able to see in browser URL "Job Post"
    When  I am on page "Client Help Vacancy Enhancements"
    And   I click on "Modify Jobs"
    Then  I should be able to see in browser URL "Client Jobs"
    And   I should see text H one tag "Manage Jobs"

  @ClientHelpHelpCenterVacancyEnhancement
  Scenario: Verify client help  center links  for job posting Vacancy Enhancements
    Then  I should see bread crumbs "Client Help Center > Job Enhancement Tips" with class name: "breadcrumbs"

  @ClientHelpCenterJobPostingVacancyEnhancement
  Scenario: Verify client help center text for job posting Vacancy Enhancements
    Then  I click on "Client Help Center Home"
    And   I should be able to see in browser URL "Client Help"
    And   I should see text H one tag "Client Help Center"

  @ClientHelpFAQVacancyEnhancement
  Scenario: Verify client help center faqs links  for job posting Vacancy Enhancements
    Then  I click on "Client FAQs"
    And   I should be able to see in browser URL "Faq"
    And   I should see text H one tag "How Can We Help You?"

  @ClientHelpJobPostingTipsVacancyEnhancement
  Scenario: Verify client job posting tips links for job posting Vacancy Enhancements
    Then  I click on "Job Posting Tips"
    And   I should be able to see in browser URL "Client Help Job Posting"

  @ClientHelpJobTipsVacancyEnhancement
  Scenario: Verify client Job Enhancement Tips for job posting Vacancy Enhancements
    Then  I click on "Job Enhancement Tips"
    And   I should be able to see in browser URL "Client Help Vacancy Enhancements"
    And   I should see text H one tag "Job Enhancement Tips"

  @ClientHelpResumeSearchVacancyEnhancement
  Scenario: Verify client Resume Search Tips for job posting Vacancy Enhancements
    Then  I click on "Resume Search Tips"
    And   I should be able to see in browser URL "Client Help Search Tips"
    And   I should see text H one tag "Resume Search Tips"

  @ClientHelpResumeAlertVacancyEnhancement
  Scenario: Verify client Resume Alert Tips for job posting Vacancy Enhancements
    Then  I click on "Resume Alert Tips"
    And   I should be able to see in browser URL "Client Help Alert Tips"
    And   I should see text H one tag "Resume Alert Tips"

  @ClientHelpVideoGuideVacancyEnhancement
  Scenario: Verify client Video Guides for job posting Vacancy Enhancements
    Then  I click on "Video Guides"
    And   I should be able to see in browser URL "Client Help Videos"
    And   I should see text H one tag "Video Guides"

  @ClientHelpClientDownloadVacancyEnhancement
  Scenario: Verify client Download User Manual for job posting Vacancy Enhancements
    Then  I click on "Download User Manual"
    And   I should be able to see in browser obfuscated URL "Downloads Rl User Manual Pdf"

  @ClientHelpContactUsVacancyEnhancement
  Scenario: Verify client Contact Us help links job posting Vacancy Enhancements
    Then  I click on "Contact Us"
    And   I should be able to see in browser URL "Client Contact"
    And   I should see text H one tag "Contact us"