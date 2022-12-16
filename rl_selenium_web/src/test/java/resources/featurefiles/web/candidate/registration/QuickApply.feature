@QuickApply @Regression @Web  @Traffic
Feature: Candidate Registration QuickApply

  Background: Posting a quick apply job and then apply for that job as a candidate
    Given I login as a client
    When  I navigate to page "Job Post"
    And   I enter job title "quick apply candidate job"
    And   I select "California" from state dropdown
    And   I enter city "90001"
    And   I enter salary min "10000"
    And   I enter salary max "30000"
    Then  I enter job description "Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job"
    And   I click on quick apply toggle
    Then  I click on preview button
    And   I click on post job button
    And   I click on post job submit button
    And   I logout the client
    Then  I navigate to page "Jobs One Click Apply Candidate Job"

  @quickApplyFromSearchResults @ReleaseRegression1
  Scenario Outline: Validate and quick apply from search results
    And   I click on apply now
    Then  I should see "Register & Quick Apply"
    When  I Click on Link Register & Apply
    Then  I should see "Email is required"
    And   I should see "First name is required"
    And   I should see "Last name is required"
    And   I should see "Password is required"
    And   I should not see "Resume is required" text
    When  I fill candidate email with random EmailId
    And   I Enters Firstname as "<FirstName>"
    And   I Enters Lastname as "<LastName>"
    And   I Enters Password "<Password>"
    And   I upload resume "Test Cv"
    And   I uncheck the label Claim my free professional Resume Review one
    When  I Click on Link Register & Apply
    Then  I should be able to see in browser URL "Job Apply"
    And   I should see text "Additional Details"
    Examples:
      | FirstName  | LastName | Password |
      | Automation | Tester   | rltest01 |

  @quickApplyFromJobView
  Scenario Outline: Quick apply registration from job view
    And   I click on title of the job
    And   I switch tab
   # And   I click on apply now job view page
    When  I fill candidate email with random EmailId
    And   I Enters Firstname as "<FirstName>"
    And   I Enters Lastname as "<LastName>"
    And   I Enters Password "<Password>"
    And   I upload resume "Test Cv"
    #And   I uncheck the label Claim my free professional Resume Review one
    When  I Click on Link Register & Apply
    Then  I should be able to see in browser URL "Job Apply"
    And   I should see text "Additional Details"
    Examples:
      | FirstName  | LastName | Password |
      | Automation | Tester   | rltest01 |

  @quickApplyResumeMandatory
  Scenario: Quick apply registration - Resume mandatory when 'Resume required on registration' partner setting is turned on
    Given  I set cookie with "ibpid" and "975438"
    Then   I reload the page
    And    I click on apply now
    And    I should see "Register & Quick Apply"
    When   I Click on Link Register & Apply
    And    I should see "Resume is required"

  @quickApplyResumeNotMandatory
  Scenario: Register and Apply - Resume NOT mandatory when 'Resume required on registration' partner setting is turned off
    Given  I set cookie with "ibpid" and "975155"
    And    I reload the page
    Then   I click on apply now
    And    I should see "Register & Quick Apply"
    When   I Click on Link Register & Apply
    And    I should not see "Resume is required" text