@CareerAdviceLoggedIn @Regression @Web  @ReleaseRegression1 @Candidate
Feature: Candidate CareerAdvice CareerAdviceLoggedIn

  Background: CareerAdvice login page
    Given   I login as a candidate

  @loadCareerAdvice
  Scenario: Load Career Advice
    Given  I navigate to page "Career Advice"
    Then   I should see "Career Advice" on the page
    And    I should see text "View all"
    And    I should see H two tag "The latest jobs on " and verify message "The latest jobs on Resume-Library"
    And    I should see text H three tag "Jobs By Industry"
    And    I should see text H three tag "Jobs By Location"
    And    I should see text H three tag "Popular jobs"

  @careerAdviceCategories
  Scenario: Career advice categories are shown
    Given  I navigate to page "Career Advice Getting Started"
    And    I should see text "At Work"
    And    I should see text "Career Development"
    And    I should see text "Cover Letters"
    And    I should see text "Getting Started"
    And    I should see text "Grads"
    And    I should see text "Interviews"
    And    I should see text "Latest"
    And    I should see text "Location Guides"
    And    I should see text "Resume Tips"

#  @CareerAdviceCompaniesCount
#  Scenario: Career Advice Companies Count is not zero in sub nav bar
#    Given  I navigate to page "Career Advice"
#    Then   I should not see the companies count is zero
#    When   I click on Companies link
#    Then   I should be on page "/companies"
#    And    I should see text "Search Companies"

#  @CareerAdviceFreeResumeReview
#  Scenario: Verify resume review banner on career Advice page
#    Given  I navigate to page "Career Advice"
#    And    I click on FREE Resume Review
#    Then   I should see text "Your resume has been sent for review"
#    When   I click on id "ok_thanks_btn"
#    And    I navigate to page "Candidate Modify"
#    Then   I click on Upload Resume button
#    And    I uncheck the label Claim my free professional Resume Review
#    And    I upload resume "Test Cv"
#    And    I click on update resume submit button

#  @CareerAdviceSavedJobs
#  Scenario: Career Advice Saved Jobs
#    Given  I navigate to page "Career Advice"
#    When   I click on saved job button
#    Then   I should be on page "/saved-jobs"
#    And    I should see text H one tag "My Saved Jobs"
#
#  @CareerAdviceSavedJobsView
#  Scenario: As a logged in user save a job and view it on career advice page
#    Given I navigate to page "Jobs Non External Test Jobs"
#    And   I delete all saved jobs
#    And   I navigate to page "Jobs Non External Test Jobs"
#    When  I click on save toggle one
#    And   I click on "Career Advice"
#    And   I should be able to see in browser URL "/career-advice/"
#    Then  I should see text a tags "Saved Jobs (" and verify "Saved Jobs (1)"

#  @CareerAdviceSearchJobsLink
#  Scenario: As a logged in user I see the career-advice navigation bar has  search jobs link
#    Given  I navigate to page "Career Advice"
#    Then   I should see Search Jobs link
#    When   I click on Search Jobs link
#    Then   I should be on page "/search-jobs"

  @CareerAdviceNavigationLinks
  Scenario:As a logged in user I see the career-advice drop navigation has links
    Given I navigate to page "Career Advice"
    Then  I should see text "Home"
    When  I click on "Getting Started" career advice links
    Then  I should be on page "Career Advice Getting Started"

    When I navigate to page "Career Advice"
    And   I click on "Resume Tips" career advice links
    Then  I should be on page "Career Advice Resume Tips"

    When  I navigate to page "Career Advice"
    And   I click on "Cover Letters" career advice links
    Then  I should be on page "Career Advice Cover Letters"

    When  I navigate to page "Career Advice"
    And   I click on "Interviews" career advice links
    Then  I should be on page "Career Advice Interviews"

    When  I navigate to page "Career Advice"
    And   I click on "At Work" career advice links
    Then  I should be on page "Career Advice At Work"

    When  I navigate to page "Career Advice"
    And   I click on "Career Development" career advice links
    Then  I should be on page "Career Advice Career Development"

    When  I navigate to page "Career Advice"
    And   I click on "Location Guides" career advice links
    Then  I should be on page "Career Advice Location Guides"

    When  I navigate to page "Career Advice"
    And   I click on "Grads" career advice links
    Then  I should be on page "Career Advice Grads"

    When  I navigate to page "Career Advice"
    And   I click on "Gig Jobs" career advice links
    Then  I should be on page "Career Advice Gig Jobs"

    When  I navigate to page "Career Advice"
    And   I click on "COVID-19 Advice" career advice links
    Then  I should be on page "Career Advice Covid 19 Advice"

  @CareerAdviceLoggedInScrollUpDown
  Scenario: As a logged in user on the Career Advice page I should be able to use scroll up button
    Given  I navigate to page "Career Advice"
    Then   I scroll down 0,5000
    Then   I scroll up 0,2000
    Then   I scroll up 0,1000
    Then   I should see element with id "back-to-top" on the page
    When   I click on back to top button
    Then   I scroll to an element "Search Jobs"
    Then   I should see resume Library header logo
    Then   I should see text "My Dashboard"
    Then   I should see text "Search Jobs"
    And    I should see text "My Profile"
    And    I should see text "Job Alerts"
    And    I should see text "Saved Jobs"

  @CareerAdvice3AdvertsLoggedIn
  Scenario: As a logged in user I see the career-advice page has 3 adverts
    Given I navigate to page "Career Advice"
    Then  I should see RL Career Advice Dyn Banner
    And   I should see RL Career Advice 160x600
    And   I should see blog-fb-banner

  @CareerAdviceResumeReviewLoggedIn
  Scenario:As a logged in user who has uploaded a resume but not had it reviewed
    When  I navigate to page "Candidate My Profile"
    And   I upload resume "Test Cv"
    Then  I should be able to see in browser URL "Candidate My Profile"
    Then  I should see text "Your resume is currently processing, you will be able to apply for jobs in just a few moments."
    When  I click on link "Career Advice" jobseeker tools menu
    And   I click on FREE Resume Review
    Then  I should see text H three tag "Your resume has been sent for review"
    And   I should see "You will receive an email from our partner within a few days with a link to your personalized review"
    And   I click on "OK, Thanks"

  @CareerAdviceSearchJobsNavigationBarLoggedIn
  Scenario: As a logged in user I see the career-advice page has search jobs navigation bar
    Given I navigate to page "Career Advice"
    And   The search jobs navigation bar button has text "Find jobs"
    And   I fill in search jobs nav bar keywords search with "Sales"
    And   I fill in search jobs nav bar location search with "10001"
    And   I select "60 Miles" from search distance
    And   I click on search jobs
    Then  I should be able to see in browser URL "/jobs/sales-in-10001?r=60"
    And   I should see text H one tag "Sales jobs in 10001"