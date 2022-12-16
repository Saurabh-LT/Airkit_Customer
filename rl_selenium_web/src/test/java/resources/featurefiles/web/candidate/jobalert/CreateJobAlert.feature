#test coverage
  # 1. New user create alert
  # 2. New user create alert banner 1
  # 3. New user create alert on /job-alerts page and update cover letter
  # 4. Existing user create alert
  # 5. New User form Validation
  # 6. Add a job alert from job view
  # 7. Add a job alert from application success page
  # 8. Login as existing user on /job-alerts page and create alert
  # 9. Job search (keyword+loc) and login as existing user via 'Get the latest Jobs with Job Alerts' icon (delete alert after creation)
  # 10. Job search (keyword+loc) and login as existing user via 'Create Job Alert' banner (delete alert after creation)
  # 11. Job view and login as existing user on job-alerts banner (delete alert after creation)

@CreateJobAlert @Regression @Web  @Traffic
Feature: Candidate JobAlert CreateJobAlert

  @newUserCreateAlert @ReleaseRegression1 @CandidateE2E
  Scenario: New user create alert
    Given I navigate to page "Jobs Sales In Houston"
    When  I click on link Get the latest Jobs with Job Alert
    And   I fill search results job alerts email with random email id
    And   I click on Create Job Alert
    And   I should see text p tag "To make your job search a little easier we've set up a Job Alert for you. We've also created a Resume-Library profile for you - " and verify message "To make your job search a little easier we've set up a Job Alert for you. We've also created a Resume-Library profile for you - complete your profile and be seen by top recruiters today!"
    When  I navigate to page "Candidate Job Alerts"
    Then  I should see text "We've created a job alert based on your profile so you receive the latest matching jobs direct to your inbox." on the page

  @newUserCreateAlertOne @ReleaseRegression1
  Scenario: New user create alert banner 1
    Given I navigate to page "Jobs Sales In Houston"
    And   I fill in new user email field with random email id
    When  I click button email me jobs like these
    And   I should see element with id "resume-upload-btn" to be "visible"
    Then  I navigate to page "Candidate Job Alerts"
    Then  I should see text "Create New Job Alert"
    And   I should see text "We've created a job alert based on your profile so you receive the latest matching jobs direct to your inbox." on the page

  @newUserCreateAlertTwo
  Scenario: New user create alert on /job-alerts page and update cover letter
    Given I navigate to page "Job Alerts"
    And   I fill the fields keywords with "Test Analyst" and location with "Texas City, TX"
    And   I fill in "email" with random candidate email
    When  I click on Create Job Alerts button
    And   I should be able to see in browser URL "Candidate Job Alerts"
    #Then  I should see text "We've created a job alert based on your profile so you receive the latest matching jobs direct to your inbox." on the page
    Then  I should see text H one tag "Job Alerts"
    Then  I should see text H two tag "My Alerts"
    Then  I should see text "Create New Job Alert" on the page
    Then  I click on my cover letters link
    And   I should see text "Dear Sir/Madam,"
    And   I should see text "I have just viewed your job vacancy on Resume-Library and would like to be considered for this position."
    And   I should see text "Please find a copy of my resume attached."
    And   I enter "Dear Sir/Madam, I have just viewed your job vacancy on Resume-Library and would like to be considered for this position. Please find a copy of my resume attached. This is updated cover letter" to edit your cover letter
    And   I click on save changes button
    And   I should see text "Cover letter saved successfully" on the page

  @existingUserCreateAlert @ReleaseRegression1
  Scenario: Existing user create alert
    Given I navigate to page "Candidate Registration"
    And   I register as a new candidate
    When  I navigate to page "Candidate Job Alerts"
    And   I fill in Keywords text with "Test Manager" and location with "Texas City, TX"
    And   I select the option "50 Miles" from distance
    And   I click on Create Job Alert button
    Then  I should see text "Job Alert created successfully!"
    And   I reload the page
    And   I click on Delete Alert link
    Then  I should see text "Are you sure you want to delete this Job Alert?" on alert popup
    And   I click on Yes, delete this alert on alert popup

  @newUserFormValidation
  Scenario: New User form Validation
    Given I navigate to page "Job Alerts"
    And   I click on Create Job Alerts button
    Then  I should see "Please enter keywords"
    And   I should see "Please enter a location"
    And   I should see "Email is required"
    When  I click on "Privacy Policy"
    Then  I should be able to see in browser URL "Privacy"
    And   I should see text H one tag "Resume-Library Privacy Policy"
    Then  I navigate to page "Job Alerts"
    And   I click on "Terms & Conditions"
    And   I should be able to see in browser URL "Terms"
    And   I should see text H one tag "Resume-Library Terms & Conditions"
    Then  I navigate to page "Job Alerts"
    And   I click on "Register now"
    Then  I should be able to see in browser URL "Candidate Registration Page"
    And   I should see text H one tag "Upload Resume &"
    Then  I navigate to page "Job Alerts"
    And   I click on "Learn more"
    Then  I should be able to see in browser URL "Search Jobs On The Go"
    And   I should see text H one tag "Search and Apply to Jobs On-the-Go!"

  @jobAlertJobView @ReleaseRegression1
  Scenario: Add a job alert from job view
    Given I navigate to page "Jobs Sales"
    Then  I click on id "more_2"
    And   I switch tab
    Then  I should be able to see in browser URL "Job View"
    And   I should see text p tag replace all "Create a new Job Alert to make sure you see the best new jobs first!"
    And   I should see label tag "Keywords" and verify "Keywords / job title"
    And   I should see text "Location" on the page source
    And   I should see text "Distance" on the page source
    When  I click on id "jbe-create-btn"
    And   I click on id "jbe-create-btn"
    And   I should see text "Email address is required"
    When  I fill in "ja-email" with random candidate email
    And   I click on id "jbe-create-btn"
    Then  I should be able to see in browser as URL "Jobs"
    And   I should see text p tag "To make your job search a little easier we've set up a Job Alert for you. We've also created a Resume-Library profile for you - " and verify message "To make your job search a little easier we've set up a Job Alert for you. We've also created a Resume-Library profile for you - complete your profile and be seen by top recruiters today!"
    And   I should see text "My Dashboard"

  @jobAlertApplicationSuccess @ReleaseRegression1
  Scenario: Add a job alert from application success page
    Given I navigate to page "Candidate Registration"
    And   I register as a new candidate
    And   I navigate to page "Jobs Apply Confirm"
    And   I should see text "Be alerted when jobs like these are posted!"
    And   I reload the page
    And   I fill the fields keywords with "Test Analyst" and location with "Texas City, TX"
    And   I click on "Create Alert"
    And   I should see "Job Alert Saved! You will receive job matches"
    And   I navigate to page "Candidate Job Alerts"
    And   I click on Delete Alert link
    Then  I should see text "Are you sure you want to delete this Job Alert?" on alert popup
    And   I click on Yes, delete this alert

  @jobAlertLoginOne
  Scenario: Login as existing user on /job-alerts page, create alert, delete alert
    Given I navigate to page "Job Alerts"
    And   I fill the fields keywords with "Test Analyst" and location with "Texas City, TX"
    And   I fill in email address with "testers+candidate@resume-library.com"
    And   I click on id "jbe-form"
    Then  I should see text "There is already an account associated with this email. Login to create your Job Alert." on the page
    And   I fill in password with "rltes"
    And   I click on id "jbe-form"
    Then  I should see "Your password must be at least 6 characters long"
    And   I fill in password with "rltes02"
    And   I click on "Login & Create Job Alert"
    Then  I should see "invalid password"
    And   I fill in password with "rltest01"
    And   I click on "Login & Create Job Alert"
    And   I should see message "Job Alert Created Successfully."
    And   I click on Delete Alert link
    Then  I should see text "Are you sure you want to delete this Job Alert?" on alert popup
    And   I click on Yes, delete this alert

  @jobAlertLoginTwo
  Scenario: Job search (keyword+loc) and login as existing user via 'Get the latest Jobs with Job Alerts' icon (delete alert after creation)
    Given I navigate to page "Jobs Sales In Houston"
    And   I click on link Get the latest Jobs with Job Alert
    And   I fill in jbe email address with "testers+candidate@resume-library.com"
    And   I click on Create Job Alert
    Then  I should see text "It looks like you are already signed up. Enter your password to login and save this Job Alert:"
    And   I fill in jbe password with "rltest01"
    And   I press and wait "search-results-jbe-submit"
    Then  I should be able to see in browser URL "Candidate Job Alerts"
    And   I should see message "Job Alert has been created" in the jbe xpath
    And   I click on Delete Alert link
    Then  I should see text "Are you sure you want to delete this Job Alert?" on alert popup
    And   I click on Yes, delete this alert on alert popup

  @jobAlertLoginThree
  Scenario: Job search (keyword+loc) and login as existing user via 'Create Job Alert' banner (delete alert after creation)
    Given I navigate to page "Jobs Sales In Houston"
    When  I fill in jbe email one with "testers+candidate@resume-library.com"
    And   I click button email me jobs like these
    And   I should see text "It looks like you are already registered. Enter your password to login and save this Job Alert:"
    And   I fill in password one with "rltest01"
    And   I press and wait "create_alert_1"
    And   I should be able to see in browser URL "Candidate Job Alerts"
    And   I should see message "Job Alert has been created" in the jbe xpath
    And   I click on Delete Alert link
    Then  I should see text "Are you sure you want to delete this Job Alert?" on alert popup
    And   I click on Yes, delete this alert on alert popup

  @jobAlertLoginFour
  Scenario: Job view and login as existing user on job-alerts banner (delete alert after creation)
    Given I navigate to page "Jobs Sales"
    Then  I click on More Link
    And   I switch tab
    And   I fill in the field where id is "ja-keywords" with random keyword
    And   I click on "Create Alert"
    When  I fill in ja email with "testers+candidate@resume-library.com"
    And   I should see text "This email already exists. Enter your password to login and save this Job Alert"
    And   I fill in ja password with "rltest01"
    And   I click on "Create Alert"
    And   I should be able to see in browser URL "Candidate Job Alerts"
    And   I should see message "Job Alert Created Successfully"
    And   I click on Delete Alert link
    Then  I should see text "Are you sure you want to delete this Job Alert?" on alert popup
    And   I click on Yes, delete this alert on alert popup