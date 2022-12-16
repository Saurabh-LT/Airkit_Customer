@CandidateContact @Regression @Web  @Candidate
Feature: Candidate Contact Contact

  Background: Candidate Contact page
    Given I login as a candidate
    When  I navigate to page "Contact"

  @validateAndSubmitContactForm @ReleaseRegression1
  Scenario Outline: Validate the Contact form and submit
    When   I should see text H one tag "How can we help you?"
    And    I click on id "send"
    And    I click on id "send"
    Then   I should see text "Name is required"
    And    I should see "Email is required"
    And    I should see "Confirm email is required"
    And    I should see "Message is required"
    When   I reload the page
    And    I enter email address only "<Email>"
    And    I enter confirm email address "<ConfirmEmail>"
    And    I enter name "<Name>"
    And    I enter phone number "<Phone>"
    And    I enter message "<Message>"
    And    I click on id "send"
    #And    I should see message "Thanks for getting in touch. A member of our team will get back to you shortly" in contact xpath
    Examples:
      | Email                                          | ConfirmEmail                                   | Name       | Phone        | Message    |
      | automation-selenium-contact@resume-library.com | automation-selenium-contact@resume-library.com | Automation | 012345678912 | Trial only |

  @verifyOtherLinks
  Scenario: Verifying other links on the Contact form
    When   I click on contact page "Visit help center" links
    Then   I should be on page "/faq?type=candidate"
    And    I should see text "Job Seeker Help"
    When   I navigate to page "Contact"
    And    I click on "Upload your Resume"
    And    I should be on page "Candidate My Profile"
    And    I should see text H one tag "My Profile"
    When   I navigate to page "Contact"
    And    I click "Forgot your password?" button
    And    I should be on page "Candidate Settings"
    And    I should see text H one tag "My Settings"
    When   I navigate to page "Contact"
    And    I click "Unsubscribe from emails" button
    And    I should be on page "Candidate Email Preferences"
    And    I should see text H one tag "My Email Preferences"