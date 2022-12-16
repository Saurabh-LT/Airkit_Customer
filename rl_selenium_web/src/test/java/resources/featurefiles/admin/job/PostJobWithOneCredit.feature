@AdminJobPostingCredit @Regression @Admin @ReleaseRegression1 @Recruiters
Feature: Admin Job PostJobWithOneCredit

  Background:
    Given I navigate to page "Client Registration"
    When  I enter first name "automation"
    And   I enter last name "client"
    And   I enter password "123456"
    And   I enter client company name "resume-library"
    And   I enter phone number "012345678912"
    And   I click on enter address manually link
    And   I enter address one "1st street"
    And   I enter city "Boston"
    And   I enter state "Massachusetts"
    And   I enter zip code "02108"
    And   I select "Staffing Agency" from recruiter type
    And   I enter client email address "registration@resume-library.com"
    And   I click on Submit inquiry
    And   I should be on page "Client Account"
    And   I should see text "Popular Products"
    And   I login as an admin user
    And   I search for "registration@resume-library.com" in the navigation bar on admin
    And   I get account name and number
    And   I click on actions btn
    And   I click on link text "Validate account"
    And   I confirm browser popup
    And   I click on product details Edit button
    And   I select "CLIENT" job posting spend type
    And   I click on update account
    Then  I should see text "was successfully updated."
    When  I click on actions btn
    And   I click on link text "Update product balances"
    And   I click on link text "Job Postings"
    And   I enters job credit "1"
    And   I click on "Update Balance"
    And   I should see element with text "Account Overview" to be "visible"

  @JobPostWithOneCredit1
  Scenario: Job get posted successfully from admin and credit is used
    And   I click on Active Jobs
    And   I click on add jobs link
    And   I fill in "Job Title"
    And   I fill in "Minimum Salary"
    And   I fill in "Maximum Salary"
    And   I select the option "California" from "State" field
    And   I fill in "Town/City/Zip"
    And   I select the option "Permanent" from "Job Type" field
    And   I select the option "Month" from "Salary Time Period" field
    And   I select the option "Active" from "Status" field
    And   I fill in Description in the text area
    And   I enter account number "Account"
    And   I fill in "Company Name"
    And   I select the option "api" from "Apply Type" field
    And   I select "automation client (1 credits)" users from list
    And   I click Add Job button
    Then  I should see text "Job successfully added"
    When  I click on link text "View Account"
    Then  I should see job credits deducted to "0"

  @JobPostWithOneCredit2
  Scenario:  Job get posted successfully from jobs add page and credit is used
    And   I am on admin page "Jobs Add"
    And   I fill in "Job Title"
    And   I fill in "Minimum Salary"
    And   I fill in "Maximum Salary"
    And   I select the option "California" from "State" field
    And   I fill in "Town/City/Zip"
    And   I select the option "Permanent" from "Job Type" field
    And   I select the option "Month" from "Salary Time Period" field
    And   I select the option "Active" from "Status" field
    And   I fill in Description in the text area
    And   I enter account number "resume-library - "
    And   I fill in "Company Name"
    And   I select the option "api" from "Apply Type" field
    And   I click Add Job button
    And   I select "automation client (1 credits)" users from list
    And   I click Add Job button
    Then  I should see text "Job successfully added"
    When  I search for "registration@resume-library.com" in the navigation bar on admin
    Then  I should see job credits deducted to "0"