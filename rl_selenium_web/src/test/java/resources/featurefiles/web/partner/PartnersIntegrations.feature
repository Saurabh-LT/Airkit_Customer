@PartnersIntegrations @Regression @Web @Partner @ReleaseRegression2 @Partnerships
Feature: Partner PartnersIntegrations

  Scenario: Partner Integrations - Validate the page links
    Given  I navigate to page "Partner Integrations"
    Then   I should see text "Marketplace"
    And    I should see text p tag "Seamlessly integrate your ATS with " and verify message "Seamlessly integrate your ATS with Resume-Library to make better hires and faster"
    When   I click on video play button in the "integration-page"
    Then   I should see text "Our Current Integrations"
    And    I should see text "Filter by integration type"
    And    I should see text "Apploi"
    Then   I should see all integrations checkbox is checked
    When   I scroll down 0,1000
    Then   I should see text "Our integration types"
    And    I click on "Broadbean"
    And    I should be on page "Partner Integrations Broadbean"
    And    I should see text "Broadbean Integration"
    When   I navigate to page "Partner Integrations"
    And    I click on ATS Import checkbox
    Then   I should see all integrations checkbox is unchecked
    And    I should see text "Bullhorn"
    And    I should not see "Apploi" link
    And    I scroll down 0,2000
    And    I should see text "Is your ATS or multi-poster missing?"
    And    I should see text "If your ATS or multi-poster is missing from our marketplace, please"
    And    I should see text "Looking for recruitment software?"
    And    I should see text "Resume-Library are proud to partner with Rectec, matching recruiters to the most appropriate ATS or CRM."
    Then   I click on "Get started"
    And    I switch to window 1
    And    I should see text "Register for Rectec Compare"
    Then   I should see the external url "https://rectec.io/register-cv-library/"
    Then   I go to page "/partner/integrations"
    And    I scroll down 0,3000
    And    I should see text "Become a partner"
    And    I should see text "We work with leading Applicant Tracking Systems and multi-posters to improve the hiring process for recruiters and job seekers."