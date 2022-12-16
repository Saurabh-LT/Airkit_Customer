@RegisterAndApply  @Regression @Web  @Traffic
Feature: Candidate Registration RegisterApply

  @candidateRegisterApply @ReleaseRegression1
  Scenario Outline: Register and Apply - Successful registration
    Given I navigate to page "Jobs Non External Test Jobs"
    When  I click on non external job to apply
    And   I click Register & apply button
    Then  I should be able to see in browser URL "Register Apply"
    And   I enter first name "<FirstName>"
    And   I enter last name "<LastName>"
    And   I enter email address "<Email>"
    And   I enter password "<Password>"
    And   I upload resume "<Resume>"
    And   I uncheck the label Claim my free professional Resume Review
    And   I click on register button
    Then  I should be able to see in browser URL "Register Apply"
    When  I enter latest job title "<JobTitle>"
    And   I enter zip code "<ZipCode>"
    And   I enter phone number "<Phone>"
    Then  I click on register confirm button
    And   I should be able to see in browser URL "Job Apply"
    And   I click on apply send application link
    And   I should see text "Application sent - the employer will be in touch if you are successful" or "Increase your chances of getting hired"

    Examples:
      | Email                                        | FirstName | LastName | Password | Resume  | JobTitle     | ZipCode | Phone        |
      | automation-register-apply@resume-library.com | Bob       | Russel   | 123456   | Test Cv | Test Analyst | 50001   | 012345678912 |

  @registerApplyResumeMandatory
  Scenario: Register and Apply - Resume mandatory when 'Resume required on registration' partner setting is turned on
    Given  I navigate to page "Jobs Non External Test Jobs"
    Then   I set cookie with "ibpid" and "975438"
    And    I reload the page
    When   I click on non external job to apply
    And    I click Register & apply button
    And    I click on register button
    Then   I should see text "Resume is required"

  @registerApplyResumeNotMandatory
  Scenario: Register and Apply - Resume NOT mandatory when 'Resume required on registration' partner setting is turned off
    Given  I navigate to page "Jobs Non External Test Jobs"
    Then   I set cookie with "ibpid" and "975155"
    And    I reload the page
    When   I click on non external job to apply
    And    I click Register & apply button
    And    I click on register button
    And    I should not see "Resume is required" text

  @registerApplyNoIbpidSet
  Scenario: Register and Apply where IBPID cookie is not set
    Given  I navigate to page "Jobs Non External Test Jobs"
    And    I reload the page
    When   I click on non external job to apply
    And    I click Register & apply button
    And    I click on register button
    And    I should not see "Resume is required" text