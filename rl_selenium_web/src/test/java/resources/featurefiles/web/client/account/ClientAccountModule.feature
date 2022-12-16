@ClientAccountPage  @Regression @Web  @Recruiters
Feature: Client Account ClientAccountModule

  Background: Client Account page Login
    Given  I login as a client

  @clientAccountVerificationResumeSearch @ReleaseRegression2
  Scenario: Verify the resume search module content on account page
    When   I navigate to page "Client Account"
    Then   I should see text "Unlocks Remaining" in "Resume Search" module
    And    I should see text "Search Resumes" in "Resume Search" module
    And    I should see text "Recent Searches" in "Resume Search" module
    And    I should see text "Saved Resumes" in "Resume Search" module
    When   I click on "Search Resumes"
    Then   I should be able to see in browser URL "Client Resume Search"
    When   I navigate to page "Client Account"
    And    I click on "Recent Searches"
    Then   I should be able to see in browser URL "/client/resume-search#"
    And    I should see text "My searches"
    When   I navigate to page "Client Account"
    And    I click on "Saved Resumes"
    Then   I should be able to see in browser URL "Client My Saved Resumes"
    And    I should see text "My Saved Resumes"

  @clientAccountVerificationResumeAlerts @ReleaseRegression2
  Scenario: Verify the resume alerts module content on account page
    When  I navigate to page "Client Resume Alert Create"
    And    I enter name field with "test alert"
    And    I enter basic search keywords with "\"sales manager\""
    And    I enter location with "10001"
    And    I click on "Create Resume Alert"
    Then   I should be able to see in browser as URL "Client Resume Alerts Msg Created"
    And    I navigate to page "Client Resume Alert Create"
    And    I enter name field with "test alert"
    And    I enter basic search keywords with "\"sales manager\""
    And    I enter location with "10001"
    And    I click on "Create Resume Alert"
    Then   I should be able to see in browser as URL "Client Resume Alerts Msg Created"
    When   I navigate to page "Client Account"
    And    I should see text "Live Alerts" in "Resume Alerts" module
    And    I should see text "Create an Alert" in "Resume Alerts" module
    And    I navigate to page "Client Account"
    And    I should see text "View Resume Alerts" in "Resume Alerts" module
    And    I click on "View Resume Alerts"
    Then   I should be able to see in browser URL "Client Resume Alerts"
    And    I should see text H one tag "Resume Alerts"
    When   I navigate to page "Client Account"
    And    I should see text "Edit Resume Alerts" in "Resume Alerts" module
    And    I click on "Edit Resume Alerts"
    Then   I should be able to see in browser URL "Client Resume Alerts"
    And    I should see text H one tag "Resume Alerts"

  @clientAccountVerificationJobPostings @ReleaseRegression2
  Scenario: Verify the job Postings module content on account page
    When    I navigate to page "Client Account"
    Then   I should see text H two tag "Job Postings"
    And    I should see text "Remaining" in "Job Postings" module
    And    I should see text "Post a Job" in "Job Postings" module
    When   I click on "Post a Job"
    Then   I should be able to see in browser URL "Job Post"
    And    I should see text H one tag "Post a Job"
    When   I navigate to page "Client Account"
    And    I should see text "Manage my Jobs" in "Job Postings" module
    And    I click on "Manage my Jobs"
    Then   I should be able to see in browser URL "Client Jobs"
    And    I should see text H one tag "Manage Jobs"
    When   I navigate to page "Client Account"
    And    I should see text "View Applications" in "Job Postings" module
    And    I click on "View Applications"
    Then   I should be able to see in browser URL "Client Job Applications"
    And    I should see text H one tag "Job Applications"

  @clientAccountVerificationCompanyProfile
  Scenario: Verify the company profile module content on account page
    Given  I navigate to page "Client Account"
    Then   I should see text H two tag "Company Profile"
    And    I should see text "View Company Profile" in "Company Profile" module
    And    I should see text p tag "Complete" and verify message "% Complete"
    When   I click on "View Company Profile" in "Company Profile" module
    Then   I should be able to see in browser URL "Company"
    And    I should see text "Search Companies"
    Given  I navigate to page "Client Account"
    And    I should see text "Edit Company Profile" in "Company Profile" module
    When   I click on "Edit Company Profile" in "Company Profile" module
    Then   I should be able to see in browser URL "Client Company Profile"
    And    I should see text H one tag "Update Company Profile"

  @clientAccountVerificationPopularProducts1
  Scenario: Verify the 'Featured Job Posting' in popular products module content on account page part 1
    Given  I navigate to page "Client Account"
    Then   I should see text p tag "Live for 30 Days" and verify message "LIVE FOR 30 DAYS"
    And    I should see text "1-10 Jobs" on the page source
    And    I should see text "3 Months" on the page source
    And    I should see text "Featured Job Posting" for plan "1-10 Jobs" in "Popular Products" module
    And    I should see text "Jobs shared across hundreds of sites" for plan "1-10 Jobs" in "Popular Products" module
    And    I should see text "Featured Job Posting" for plan "1-10 Jobs" in "Popular Products" module
    And    I should see text "Top matched resumes sent to your inbox" for plan "1-10 Jobs" in "Popular Products" module
    And    I should see text "Fully branded job postings" for plan "1-10 Jobs" in "Popular Products" module
    And    I should see text "Per Job" on the page source
    And    I should see text "Buy Online Now" for plan "1-10 Jobs" in "Popular Products" module
    When   I click on "Buy Online Now" for plan "1-10 Jobs" in "Popular Products" module
    Then   I should be able to see in browser URL "Client Purchase"
    And    I should see text H one tag "Your Cart"

  @clientAccountVerificationPopularProducts2
  Scenario: Verify the 'Featured Job Posting' in popular products module content on account page part 2
    Given  I navigate to page "Client Account"
    Then   I should see text p tag "Choose the Duration" and verify message "CHOOSE THE DURATION"
    And    I should see text "Featured Job Posting" for plan "10+ Jobs" in "Popular Products" module
    And    I should see text "Complete control of your budgets" for plan "10+ Jobs" in "Popular Products" module
    And    I should see text "Pay for views, clicks, applications to your jobs" for plan "10+ Jobs" in "Popular Products" module
    And    I should see text "Fully branded job postings" for plan "10+ Jobs" in "Popular Products" module
    And    I should see text "Per Application" on the page source
    And    I should see text "Learn More" for plan "10+ Jobs" in "Popular Products" module
    When   I click on "Learn More" for plan "10+ Jobs" in "Popular Products" module
    Then   I should be able to see in browser URL "Hiring Pay For Performance Job Advertising"
    And    I should see text H two tag "Tailored Hiring Solutions For your Team"

  @clientAccountVerificationPopularProducts3
  Scenario: Verify the 'Featured Job Posting' in popular products module content on account page part 3
    Given  I navigate to page "Client Account"
    And    I should see text "Resume Search" for plan "3 Months" in "Popular Products" module
    And    I should see text "Unlimited Resume Search and Views" for plan "3 Months" in "Popular Products" module
    And    I should see text "Access for your entire team" for plan "3 Months" in "Popular Products" module
    And    I should see text "Dedicated customer support" for plan "3 Months" in "Popular Products" module
    And    I should see text "Per Month" on the page source
    And    I should see text "Buy Online Now" for plan "3 Months" in "Popular Products" module
    When   I click on "Buy Online Now" for plan "3 Months" in "Popular Products" module
    Then   I should be able to see in browser URL "Client Purchase"
    And    I should see text H one tag "Your Cart"

  @clientAccountVerificationFaq1
  Scenario: Verify the faq module content on account page part 1
    Given  I navigate to page "Client Account"
    Then   I scroll down 1000,1000
    Then   I should see text "How can I edit my account details?"
    And    I should see text "How long will it take to validate my account?"
    And    I should see text "Can I extend my job posting?"
    And    I should see text "How do I create a Resume Alert?"
    And    I should see text "How can I post a job without a salary?"
    And    I should see text "Additional FAQs"

    Given  I navigate to page "Client Account"
    When   I click on "How can I edit my account details?"
    Then   I should be able to see in browser URL "Faq Recruiter Edit Account"
    And    I should see text "Log in to your account on Resume-Library to update your password and Company Profile."

    Given  I navigate to page "Client Account"
    When   I click on "How long will it take to validate my account?"
    Then   I should be able to see in browser URL "Faq Recruiter Validate Account"
    And    I should see text "Our Support team will answer your request by the end of the next business day. Friday, Saturday & Sunday registrations will be actioned on the following Monday. If your request is urgent, call our team on 1-800-672-6706."

    Given  I navigate to page "Client Account"
    When   I click on "Can I extend my job posting?"
    Then   I should be able to see in browser URL "Faq Recruiter Extend Posting"
    And    I should see text "We will notify you when your job is about to expire. If required, you can choose to renew your job."

  @clientAccountVerificationFaq2
  Scenario: Verify the faq module content on account page part 2
    Given  I navigate to page "Client Account"
    When   I click on "How do I create a Resume Alert?"
    Then   I should be able to see in browser URL "Faq Recruiter Resume Search"
    And    I should see text "Log in to Resume-Library to view the 'Resume Alerts' menu. Click this, enter your criteria to the form and save your alert."

    Given  I navigate to page "Client Account"
    When   I click on "How can I post a job without a salary?"
    Then   I should be able to see in browser URL "Faq Recruiter Job Length"
    And    I should see text "In the 'Salary' fields, enter '0' and then select 'No' on the 'Display Salary' dropdown option."

    Given  I navigate to page "Client Account"
    When   I click on "Additional FAQs"
    Then   I should be able to see in browser URL "Faq Recruiter"
    And    I should see text H one tag "How Can We Help You?"

    Given  I navigate to page "Client Account"
    When   I click on "Client Help Center"
    Then   I should be able to see in browser URL "Client Help"
    And    I should see text H one tag "Client Help Center"

    Given  I navigate to page "Client Account"
    And    I click on "Download our user manual"
    Then   I switch to window 1
    Then   I should be able to see in browser obfuscated URL "Downloads Rl User Manual Pdf"
    Then   I switch to window 0

  @clientAccountVerificationFaq3
  Scenario: Verify the faq module content on account page part 3
    Given  I navigate to page "Client Account"
    And    I click on "Resume Alert Tips"
    Then   I should be able to see in browser URL "Client Help Alert Tips"
    And    I should see text H one tag "Resume Alert Tips"

    Given  I navigate to page "Client Account"
    And    I click on "Resume Search Tips"
    Then   I should be able to see in browser URL "Client Help Search Tips"
    And    I should see text H one tag "Resume Search Tips"

    Given  I navigate to page "Client Account"
    And    I click on "Resume Search Tips"
    Then   I should be able to see in browser URL "Client Help Search Tips"
    And    I should see text H one tag "Resume Search Tips"

    Given  I navigate to page "Client Account"
    And    I click on "Job Posting Tips"
    Then   I should be able to see in browser URL "Client Help Job Posting"
    And    I should see text H one tag "Job Posting Tips"

    Given  I navigate to page "Client Account"
    And    I click on "Job Enhancement Tips"
    Then   I should be able to see in browser URL "Client Help Vacancy Enhancements"
    And    I should see text H one tag "Job Enhancement Tips"

  @clientAccountVerificationHiringInsights
  Scenario: Verify the hiring insights module content on account page
    Given  I navigate to page "Client Account"
    Then   I should see text "Hiring Insights" in "Hiring Insights" module
    And    I should see text "Our employer blog, packed with useful articles on hiring advice, workplace insights, and job market reports." in "Hiring Insights" module
    And    I should see text "Go to Hiring Insights" in "Hiring Insights" module
    When   I click on "Go to Hiring Insights"
    Then   I should be able to see in browser URL "Resources"
    And    I should see text H one tag "Hiring Insights"