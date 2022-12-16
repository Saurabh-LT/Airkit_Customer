@FastTrackUpdateProfile @Regression @Web  @Candidate
Feature: Candidate Registration FastTrackUpdateProfile

  Background: Register as a candidate using fast track form
    Given I navigate to page "Jobs Sales In Houston"
    When  I click on link Get the latest Jobs with Job Alert
    And   I fill search results job alerts email with random email id
    And   I click on Create Job Alert move to page "Candidate My Dashboard"

  @fastTrackUpdateProfileToResumeUpload
  Scenario: Fast track update profile to Resume Upload
    And   I should see text "What is your most recent job title?"
    And   I should see text "You have no job matches"
    And   I should see text "Modify Profile Now"

    When  I fill in latest job title with "sales"
    And   I click on Save to profile button
    And   I should see text p tag "Your profile is still only 25% complete." and verify message "Your profile is still only 25% complete. Complete your profile to attract top recruiters."
    And   I should see text "View all job matches"
    And   I should see text "What is your phone number?"

    When  I fill in the field phone with "123456789"
    And   I click on Save to profile button
    And   I should see text p tag "Your profile is still only 35% complete." and verify message "Your profile is still only 35% complete. Complete your profile to attract top recruiters."
    And   I should see text "Upload your resume"

    When  I click on upload resume toggle
    Then  I upload resume "Test Cv"
    And   I click on Upload resume button
    And   I reload the page
    Then  I should see text Profile "45%" complete

  @fastTrackUpdateProfileSkipResumeUpload
  Scenario: Fast track update profile skipping Resume Upload
    When  I fill in latest job title with "sales"
    And   I click on Save to profile button
    And   I fill in the field phone with "123456789"
    And   I click on Save to profile button
    And   I click on the link Skip >
    Then  I should see text "What is your zip/postal code?"

    When  I fill in the zip code with "10001"
    And   I click on Save to profile button
    And   I click on the link Skip >
    Then  I should see text "What is your desired job title?" on the page source

    When  I enter desired job title "sales" on modify profile page
    And   I click on Save to profile button skip
    And   I click on the link Skip >
    Then  I should see text "What is your desired salary?"

    When  I fill in salary expectation from with "10000"
    When  I fill in salary expectation to with "20000"
    And   I click on Save to profile button
    And   I click on the link Skip >
    Then  I should see text "What is your education level?"

    When  I fill in the education level with "Vocational"
    And   I click on Save to profile button
    And   I click on the link Skip >
    Then  I should see text "Authorization to work in the U.S."

    When  I select the option "I am authorized to work in this country for any employer" from eligibility status
    And   I click on Save to profile button
    And   I click on the link Skip >
    Then  I should see text "What is your first name?"

    When  I fill in the first name with "Automation"
    And   I click on Save to profile button
    And   I should see text "Automation"
    And   I click on the link Skip >
    Then  I should see text "Enter up to 14 key skills " on the page source

    When  I fill in skills input with "Sales Manager, PHP"
    And   I click on Save to profile button
    And   I click on the link Skip >

    Then  I should see text "What is your last name?"
    When  I fill the  last name with "Candidate"
    And   I click on Save to profile button
    And   I should see text "Automation Candidate" on the page source
    And   I click on the link Skip >

    Then  I should see text "Are you willing to relocate?" on the page source

    When  I select the option "Yes" from relocate
    And   I click on Save to profile button
    And   I click on the link Skip >
    Then  I should see text "How many years of experience do you have?" on the page source

    When  I select the option "More than 10 years" from work experience
    And   I click on Save to profile button
    And   I click on the link Skip >
    Then  I should see text "Do you have a valid drivers license?" on the page source

    When  I select the option "Yes" from driving licence
    And   I click on Save to profile button
    And   I should see text "Upload your resume"
    When  I click on upload resume toggle
    And   I upload resume "Test Cv"
    And   I click on Upload resume button
    And   I reload the page
    Then  I should see text Profile "100%" complete