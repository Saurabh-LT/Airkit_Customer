@MyDashboard @Regression @Web  @Candidate
Feature: Candidate MyDashboard MyDashboard

  Background: Login and my dashboard page
    Given  I login as a candidate

  @jobMatches @ReleaseRegression1 @safari
  Scenario: Verify Job matches tab
    Then  I should see text H one tag "My Dashboard"
    And   I should see text "Job Matches"
    And   I navigate to page "Candidate My Profile"
    And   I click on "Job Requirements" edit button
    When  I fill in the field where id is "latest_job_title" with: "NonExternalTestJob"
    And   I fill in the field where id is "desired_job_title" with: "NonExternalTestJob"
    And   I click on Save Changes Button on Modify Profile Page
    And   I navigate to page "Candidate My Dashboard"
    When  I click on view link
    Then  I should be able to see in browser URL "/job/view/"
    And   I navigate to page "Candidate My Dashboard"
    And   I reload the page
    Then  I click on apply now link
    And   I should be able to see in browser URL "/job/apply"
    And   I navigate to page "Candidate My Dashboard"
    Then  I click "View all job matches" button
    And   I should be able to see in browser URL "/jobs/nonexternaltestjob-in-90189?r=51"
    And   I should see text H one tag "Nonexternaltestjob jobs in 90189"

  @verifyBannersAndLinks @Safari
  Scenario: Verify Job matches, Recently applied & Banner
    When  I navigate to page "Candidate My Profile"
    And   I upload resume "Test CV"
    Then  I navigate to page "Candidate My Dashboard"
    When  I click on resume review side banner
    Then  I should see text H three tag "Your resume has been sent for review"
    When  I click "OK, Thanks" button
    Then  I should see text H one tag "My Dashboard"
    When  I click on search on go banner
    Then  I should be on page "/search-jobs-on-the-go"
    Then  I click on modify profile link
    And   I upload resume "Test CV"
    Then  I should be on page "Candidate My Profile"
    And   I should see text p tag replace all "Your resume is currently processing, you will be able to apply for jobs in just a few moments."

  @VerifyLinksUnderMyAccountSection @Safari
  Scenario: Verify the Link Navigation's under my Dashboard page
    When I click on job alert link
    Then I should be on page "Candidate Job Alerts"
    And  I should see text H one tag "Job Alerts"
    And  I should see bread crumbs "My Dashboard > Job Alerts" with class name: "breadcrumbs"
    Then I navigate to page "Candidate My Dashboard"
    When I click on application link
    Then I should be on page "Candidate Myapplications"
    And  I should see text H one tag "My Applications"
    And  I should see bread crumbs "My Dashboard > My Applications" with class name: "breadcrumbs"
    Then I navigate to page "Candidate My Dashboard"
    When I click on saved job link
    Then I should be on page "/candidate/saved-jobs"
    And  I should see text H one tag "My Saved Jobs"
    And  I should see bread crumbs "My Dashboard > My Saved Jobs" with class name: "breadcrumbs"
    Then I navigate to page "Candidate My Dashboard"
    When I click on my cover letters link
    Then I should be on page "/candidate/cover-letter"
    And  I should see text H one tag "Modify Cover Letter"
    And  I should see bread crumbs "My Dashboard > Modify Cover Letter" with class name: "breadcrumbs"
    Then I navigate to page "Candidate My Dashboard"
    When I click on edit profile link
    Then I should be on page "Candidate My Profile"
    And  I should see text H one tag "My Profile"
    And  I should see bread crumbs "My Dashboard > My Profile" with class name: "breadcrumbs"
    Then I navigate to page "Candidate My Dashboard"

  @VerifyEditProfileLink @Safari
  Scenario: Verify the Edit Profile Link Navigation on Dashboard page
    When I click on "Edit Profile"
    Then I should be on page "Candidate My Profile"
    And  I should see text H one tag "My Profile"
    And  I should see bread crumbs "My Dashboard > My Profile" with class name: "breadcrumbs"

  @VerifyHeaderBannerLinks @Safari
  Scenario: Verify the Site Navigation links on Header Banner on Dashboard page
    When I click "My Dashboard" link on Header Banner
    Then I should be on page "/candidate/my-dashboard"
    And  I should see text H one tag "My Dashboard"
    When I click "My Profile" link on Header Banner
    Then I should be on page "Candidate My Profile"
    And  I should see text H one tag "My Profile"
    And  I should see bread crumbs "My Dashboard > My Profile" with class name: "breadcrumbs"
    When I click "Job Alerts" link on Header Banner
    Then I should be on page "Candidate Job Alerts"
    And  I should see text H one tag "Job Alerts"
    And  I should see bread crumbs "My Dashboard > Job Alerts" with class name: "breadcrumbs"
    When I click "Saved Jobs" link on Header Banner
    Then I should be on page "/candidate/saved-jobs"
    And  I should see text H one tag "My Saved Jobs"
    And  I should see bread crumbs "My Dashboard > My Saved Jobs" with class name: "breadcrumbs"
    When I click "My Applications" link on Header Banner
    Then I should be on page "Candidate Myapplications"
    And  I should see text H one tag "My Applications"
    And  I should see bread crumbs "My Dashboard > My Applications" with class name: "breadcrumbs"
    When I click "My Settings" link on Header Banner
    Then I should be on page "Candidate Settings"
    And  I should see text H one tag "My Settings"
    And  I should see bread crumbs "My Dashboard > My Settings" with class name: "breadcrumbs"
    When I click "My Email Preferences" link on Header Banner
    Then I should be on page "Candidate Email Preferences"
    And  I should see text H one tag "My Email Preferences"
    And  I should see bread crumbs "My Dashboard > My Email Preferences" with class name: "breadcrumbs"
    When I click "Logout" link on Header Banner
    Then I should be on page "Logout"