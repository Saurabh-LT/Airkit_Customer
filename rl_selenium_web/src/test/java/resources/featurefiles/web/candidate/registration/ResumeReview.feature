@ResumeReview @Regression @Web  @Candidate
Feature: Candidate Registration ResumeReview

  @resumeReviewValidation
  Scenario Outline: Validation on resume review page
    Given I navigate to page "Resume Review"
    When  I press login and review my resume button
    Then  I should see text "Email is required"
    And   I should see text "First name is required"
    And   I should see text "Last name is required"
    And   I should see text "Resume is required"
    When  I reload the page
    And   I enter email address "<Email>"
    And   I press login and review my resume button
    Then  I should see text "Please enter a valid email address"
    When  I enter first name "<FirstName>"
    And   I press login and review my resume button
    Then  I should see text "Please enter a valid first name that does not contain numbers"
    When  I enter last name "<LastName>"
    And   I press login and review my resume button
    Then  I should see text "Please enter a valid last name that does not contain numbers"
    Examples:
      | Email | FirstName | LastName |
      | test@ | first1    | last1    |

  @resumeReviewRegistration @ReleaseRegression1
  Scenario Outline: Registration through resume review page
    Given I navigate to page "Resume Review"
    When  I enter email address "<Email>"
    And   I enter first name "<FirstName>"
    And   I enter last name "<LastName>"
    And   I upload resume "<Resume>"
    Then  I press login and review my resume button
    Then  I should be on page "Candidate Resume Review Success"
    Examples:
      | Email          | FirstName | LastName | Resume  |
      | test@yahoo.com | Bob       | Russel   | Test Cv |

  @resumeReviewLoggedIn
  Scenario: Verify resume review banner for a logged in/newly registered candidate
    Given I navigate to page "Candidate Registration"
    When  I register as a new candidate
    And   I click on complete button
    And   I reload the page
    And   I click on FREE Resume Review
    Then  I should see text H three tag "Your resume has been sent for review"
    And   I should see "You will receive an email from our partner within a few days with a link to your personalized review"
    And   I click on "OK, Thanks"

  @resumeReviewJobApply
  Scenario: Verify Resume Review from Job Apply
    Given I navigate to page "Candidate Registration"
    When  I register as a new candidate
    And   I navigate to page "Jobs Non External Test Jobs"
    And   I click on non external job to apply
    And   I switch tab
    And   I should be able to see in browser URL "Job Apply"
    Then  I should see "Selenium Candidate, you're applying for:"
    When  I enter phone number "012345678912"
    And   I click on apply send application link
    And   I should be able to see in browser URL "Job Apply"
    And   I reload the page
    And   I should see text "Application sent - the employer will be in touch if you are successful"
    And   I click on FREE Resume Review
    Then  I should see text H three tag "Your resume has been sent for review"
    And   I should see "You will receive an email from our partner within a few days with a link to your personalized review"
    And   I click on "OK, Thanks"

  @resumeReviewJobAlerts
  Scenario: Verify resume review banner on Job Alerts page
    Given I navigate to page "Candidate Registration"
    When  I register as a new candidate
    And   I click on complete button
    And   I reload the page
    And    I navigate to page "Candidate Job Alerts"
    And   I click on FREE Resume Review
    Then  I should see text H three tag "Your resume has been sent for review"
    And   I should see "You will receive an email from our partner within a few days with a link to your personalized review"
    And   I click on "OK, Thanks"

  @resumeReviewSavedJobs
  Scenario: Verify resume review banner on Saved Jobs page
    Given I navigate to page "Candidate Registration"
    When  I register as a new candidate
    And   I click on complete button
    And   I reload the page
    And   I navigate to page "Candidate Saved Jobs"
    And   I click on FREE Resume Review
    Then  I should see text H three tag "Your resume has been sent for review"
    And   I should see "You will receive an email from our partner within a few days with a link to your personalized review"
    And   I click on "OK, Thanks"

  @resumeReviewMySettings
  Scenario: Verify resume review banner on My Settings page
    Given I navigate to page "Candidate Registration"
    When  I register as a new candidate
    And   I click on complete button
    And   I reload the page
    And   I navigate to page "Candidate Settings"
    And   I click on FREE Resume Review
    Then  I should see text H three tag "Your resume has been sent for review"
    And   I should see "You will receive an email from our partner within a few days with a link to your personalized review"
    And   I click on "OK, Thanks"

  @resumeReviewCoverLetter
  Scenario: Verify resume review banner on Modify Cover Letter page
    Given I navigate to page "Candidate Registration"
    When  I register as a new candidate
    And   I click on complete button
    And   I reload the page
    And   I navigate to page "Candidate Cover Letter"
    And   I click on FREE Resume Review
    And   I should see text H three tag "Your resume has been sent for review"
    And   I should see "You will receive an email from our partner within a few days with a link to your personalized review"
    And   I click on "OK, Thanks"

  @resumeReviewEmailPreferences
  Scenario: Verify resume review banner on My Email Preferences page
    Given I navigate to page "Candidate Registration"
    When  I register as a new candidate
    And   I click on complete button
    And   I reload the page
    And   I navigate to page "Candidate Email Preferences"
    And   I click on FREE Resume Review
    Then  I should see text H three tag "Your resume has been sent for review"
    And   I should see "You will receive an email from our partner within a few days with a link to your personalized review"
    And   I click on "OK, Thanks"

  @resumeReviewJobSearchLoggedOut
  Scenario: Verify resume review from a logged out user job search
    Given I navigate to page "Jobs Sales In 10010"
    And   I click on search results resume review banner
    Then  I should be able to see in browser URL "Resume Review"
    And   I enter email address "test@gmail.com"
    And   I enter first name "automation "
    And   I enter last name "candidate"
    And   I upload resume "Test Cv"
    Then  I press login and review my resume button
    And   I should be on page "Candidate Resume Review Success"

  @resumeReviewJobSearchLoggedIn @ReleaseRegression1
  Scenario: Verify resume review from a logged in user job search
    Given I navigate to page "Candidate Registration"
    When  I register as a new candidate
    And   I click on complete button
    And   I reload the page
    And   I navigate to page "Jobs Sales In 10010"
    And   I click on search results resume review banner
    Then  I should see text H three tag "Your resume has been sent for review"
    And   I should see "You will receive an email from our partner within a few days with a link to your personalized review"
    And   I click on "OK, Thanks"

  @resumeReviewJobView
  Scenario: Verify resume review from a Job View page
    Given I navigate to page "Candidate Registration"
    When  I register as a new candidate
    And   I click on complete button
    And   I reload the page
    And   I navigate to page "Jobs Sales"
    When  I click on title of the job
    And   I switch tab
    Then  I should be able to see in browser URL "Job View"
    When  I click on "Review My Resume"
    Then  I should see text H three tag "Your resume has been sent for review"
    And   I should see "You will receive an email from our partner within a few days with a link to your personalized review"
    And   I click on "OK, Thanks"

  @resumeReviewCompanyProfilePage
  Scenario: Verify resume review from a company profile page
    Given I navigate to page "Candidate Registration"
    When  I register as a new candidate
    And   I click on complete button
    And   I reload the page
    And   I am on page "Company 1478 Acme Company No 1728 Jobs"
    And   I click on FREE Resume Review
    Then  I should see text H three tag "Your resume has been sent for review"
    And   I should see "You will receive an email from our partner within a few days with a link to your personalized review"
    And   I click on "OK, Thanks"