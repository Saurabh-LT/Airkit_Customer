@ModifyProfileUpdate @Regression @Web  @Candidate
Feature: Candidate ModifyProfile UpdateProfileDetails

  @modifyProfileDetailsUpdate @ReleaseRegression1
  Scenario Outline: Modify profile validation error
    Given I navigate to page "Candidate Registration"
    And   I register as a new candidate
    When  I navigate to page "Candidate My Profile"
    And   I click on "Job Requirements" edit button
    When  I select the option "I am authorized to work in this country for any employer" from eligibility status
    And   I click on "Personal Information" edit button
    And   I fill in the first name with "Resume-Library123" on modify profile page
    And   I should see text "Please enter a valid first name that does not contain numbers"
    And   I enter the zip code with "" on modify profile page
    And   I should see text "Zip code is required"
    When  I fill in the field phone with "1234-1234" on modify profile page
    And   I should see text "Please enter a valid number"
    When  I fill in latest job title with "" on modify profile page
    And   I should see text "Latest job title is required"
    When  I fill in the first name with "<First Name>" on modify profile page
    And   I enter the zip code with "<Zip Code>" on modify profile page
    And   I fill in the last name with "<Last Name>" on modify profile page
    And   I fill in the field phone with "<Phone Number>" on modify profile page
    And   I select the field education level with "<Education Level>" on modify profile page
    And   I select the field years of experience with "<Years of experience>" on modify profile page
    And   I enter desired job title "<Desired Job Title>" on modify profile page
    And   I select the field prepared to travel with "<Prepared to travel>" on modify profile page
    And   I scroll down 0,1700
    And   I select the field desired salary from with "<Desired salary From>" on modify profile page
    And   I select the field desired salary to with "<Desired salary To>" on modify profile page
    And   I select the field authorization to work in the U.S with "<Authorization to work in the U.S.>" on modify profile page
    And   I select the field willing to relocate with "<Willing to relocate>" on modify profile page
    And   I select the field drivers license with "<Drivers license>" on modify profile page
    And   I fill in latest job title with "<Latest Job Title>" on modify profile page
    And   I scroll down 0,1700
    And   I click on "Main Skills and Languages" edit button
    When  I fill in skills input with "first" on modify profile page
    And   I click on Save Changes Button on Update Profile Page
    Then  I should be able to see in browser URL "Candidate My Profile"
    And   I should see text "Your details have been successfully updated"
    Then  Compare the "First name:" label Text With "<First Name>"
    And   Compare the "Zip code:" label Text With "<Zip Code>"
    And   Compare the "Last name:" label Text With "<Last Name>"
    And   Compare the "Phone number:" label Text With "<Phone Number>"
    And   Compare the "Education level:" label Text With "<Education Level>"
    And   Compare the "Years of experience:" label Text With "<Years of experience>"
    And   Compare the "Prepared to travel:" label Text With "<Prepared to travel>"
    And   Compare the "Latest job title:" label Text With "<Latest Job Title>"
    And   Compare the "Willing to relocate:" label Text With "<Willing to relocate>"
    And   Compare the "Desired job title:" label Text With "<Desired Job Title>"
    And   Compare the "Drivers license:" label Text With "<Drivers license>"
    And   Compare the "Desired salary:" label Text With "<Desired salary From> - <Desired salary To>"
    And   Compare the "Authorization to work in the U.S.:" label Text With "<Authorization to work in the U.S.>"
    Examples:
      | First Name      | Zip Code | Last Name | Phone Number | Education Level | Years of experience | Prepared to travel | Latest Job Title    | Willing to relocate | Desired Job Title  | Drivers license | Desired salary From | Desired salary To | Authorization to work in the U.S. |
      |Resume-Library   | 90189    | Selenium  | 123456789    | Certification   | 3-5 years           | Up to 50 Miles     | NonExternalTestJob  | Yes                 | NonExternalTestJob | No              | $60,000             | $90,000           | I require sponsorship to work in this country |

  @modifyKeySkillsValidation
  Scenario: Modify key skills validation
    Given I navigate to page "Candidate Registration"
    Then  I register as a new candidate resume check
    And   I navigate to page "Candidate My Profile"
    And   I click on "Job Requirements" edit button
    And   I select the option "I am authorized to work in this country for any employer" from eligibility status
    And   I click on Save Changes Button on Update Profile Page
    When  I navigate to page "Candidate My Profile"
    And   I click on "Main Skills and Languages" edit button
    When  I fill in skills input with "-" on modify profile page
    Then  I should see text "A skill must contain at least 1 letter"
    When  I reload the page
    And   I click on "Main Skills and Languages" edit button
    When  I fill in skills input with "test" on modify profile page
    When  I fill in skills input with "test" on modify profile page
    Then  I should see text "You have entered the same skill more than once"
    When  I fill in skills input with "first" on modify profile page
    When  I fill in skills input with "second" on modify profile page
    When  I fill in skills input with "third" on modify profile page
    When  I fill in skills input with "forth" on modify profile page
    When  I fill in skills input with "fifth" on modify profile page
    When  I fill in skills input with "sixth" on modify profile page
    When  I fill in skills input with "seventh" on modify profile page
    When  I fill in skills input with "eighth" on modify profile page
    When  I fill in skills input with "ninth" on modify profile page
    When  I fill in skills input with "tenth" on modify profile page
    When  I fill in skills input with "eleventh" on modify profile page
    When  I fill in skills input with "twelth" on modify profile page
    When  I fill in skills input with "thirteenth" on modify profile page
    When  I fill in skills input with "fourteenth" on modify profile page
    When  I fill in skills input with "fifteenth" on modify profile page
    Then  I should see text "You may only have a maximum of 14 key skills"
    When  I reload the page
    And   I click on "Job Requirements" edit button
    And   I select the option "I am authorized to work in this country for any employer" from eligibility status
    And   I click on "Main Skills and Languages" edit button
    When  I fill in skills input with "Sales" on modify profile page
    When  I fill in skills input with "Manager" on modify profile page
    And   I click on Save Changes Button on Modify Profile Page
    Then  I should see text "Your details have been successfully updated"

  @modifyProfileSetPassword @Safari
  Scenario: Modify profile set password
    Given I navigate to page "Jobs Sales In Houston"
    When  I click on link Get the latest Jobs with Job Alert
    And   I fill search results job alerts email with random email id
    And   I click on Create Job Alert move to page "Candidate My Profile"
    Then  I should see text "Create a Password"
    And   I should see text "Ready to create your password?"
    And   I should see text "My account password"
    And   I click on Set Password button
    Then  I should see text "New password is required"
    When  I fill in password with "test"
    Then  I should see text "Your password must be at least 6 characters long"
    When  I fill in password with "maxlenth32maxlenth32maxlenth32-33"
    Then  I should see text "Your password can be a maximum of 32 characters long"
    When  I fill in password with "      "
    Then  I should see text "Your password can not contain spaces"
    When  I fill in password with "test01"
    And   I click on Set Password button
    #Then  I should see text p tag "The password for" and verify message "The password for has been successfully created!"

  @modifyProfileUploadResume @CandidateE2E @Safari
  Scenario: Modify profile upload resume
    Given I navigate to page "Jobs Sales In Houston"
    When  I click on link Get the latest Jobs with Job Alert
    And   I fill search results job alerts email with random email id
    And   I click on Create Job Alert
    And   I should see "To make your job search a little easier we've set up a Job Alert for you. We've also created a Resume-Library profile for you"
    And   I navigate to page "Candidate My Profile"
    Then  I should see text "Resume not uploaded"
    And   I should see text "We can accept the following file types:"
    And   I should see text "doc, docx, pdf, txt, odt, wps, html, htm that are no larger than 2 MB"
    And   I upload resume "Test Cv"
    Then  I should be able to see in browser URL "Candidate My Profile"
    Then  I should see text "Your resume is currently processing, you will be able to apply for jobs in just a few moments."

 @MyProfileUploadResumeValidation
  Scenario: Validation of Resume Upload with different files
    Given I navigate to page "Candidate Registration"
    And   I register as a new candidate
    When  I navigate to page "Candidate My Profile"
    Then  I should see text "My Profile"
    And   I should see text "Your Current Resume"
    And   I should see text "Upload a New Resume"
    And   I should see text "doc, docx, pdf, txt, odt, wps, html, htm that are no larger than 2 MB"
    When  I upload resume "PROJECT STRUCTURE IMAGE"
    Then  I should see "We can only accept .doc .docx .pdf .txt .odt .wps .html .htm files"
    When  I upload resume "Index html"
    Then  I should see "This file is less than 1kb or bigger than 2mb"
