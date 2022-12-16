@ResourcesPageFooterLinks  @Regression @Web  @ReleaseRegression2 @Traffic
Feature: Client Resources ResourcesLoggedInFooterLinks

  Background: Navigating to Resources page
    Given I login as a client

  @ResourcesPageFooterLinks
  Scenario: Navigation Footer for logged In user on resources blog page
    When   I navigate to page "Resources"
    And    I should see text H four tag "Resume Search"
    And    I should see text H four tag "Manage Jobs"
    And    I should see text H four tag "Resume Alerts"
    And    I should see text H four tag "Account Options"
    And    I scroll down to element "Search Resumes Now"
    When   I click on link "Search Resumes Now" in "Resume Search" footer
    Then   I wait for "2" seconds
    And    I should see text H two tag "Search Millions of Resumes"
    And    I reload the page
    Then   I should be able to see in browser URL "Client Resume Search"

    When   I move backward one page
    Then   I click on link "Saved Resumes" in "Resume Search" footer
    Then   I should be able to see in browser URL "Client My Saved Resumes"
    Then   I should see text H one tag "My Saved Resumes"

    When   I move backward one page
    Then   I click on link "Unlocked Resumes" in "Resume Search" footer
    Then   I should be able to see in browser URL "Client My Unlocked Resumes"
    Then   I should see text H one tag "My Unlocked Resumes"

    When   I move backward one page
    When   I click on link "Manage Jobs" in "Manage Jobs" footer
    Then   I should be able to see in browser URL "Client Jobs"

    When   I move backward one page
    When   I click on link "Post Jobs" in "Manage Jobs" footer
    Then   I should be able to see in browser URL "Job Post"

    When   I move backward one page
    When   I click on link "Job Applications" in "Manage Jobs" footer
    Then   I should be able to see in browser URL "Client Job Applications"

    When   I move backward one page
    When   I click on link "Manage Alerts" in "Resume Alerts" footer
    Then   I should be able to see in browser URL "Client Resume Alerts"

    When   I move backward one page
    When   I click on link "Create New Alert" in "Resume Alerts" footer
    Then   I should be able to see in browser URL "Client Resume Alert Create"

    When   I move backward one page
    When   I click on link "View Sent Alerts" in "Resume Alerts" footer
    Then   I should be able to see in browser URL "Client Resume Alerts Log"

    When   I move backward one page
    When   I click on link "Change Password" in "Account Options" footer
    Then   I should be able to see in browser URL "User Change Password"

    When   I move backward one page
    When   I click on link "FAQs" in "Account Options" footer
    Then   I should be able to see in browser URL "/faq?type=recruiter"

    When   I move backward one page
    When   I click on link "Contact Us" in "Account Options" footer
    Then   I should be able to see in browser URL "Client Contact"

    And   I should see resume Library Employers header logo