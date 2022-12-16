@ClientInquiryForm @Regression @Web  @Traffic
Feature: Client Contact ClientInquire

  Background: on Client Inquiry Form page
    Given I am on page "Client Contact"

  @clientInquiryText
  Scenario: text shown on the client inquiry page.
    Then I should see text "Inquire now"
    And  I should see text "Our dedicated team is here to help answer your questions."
    And  I should see text "sales@resume-library.com"
    And  I should see text H two tag "Start Hiring with Resume-Library Today"

  @clientInquiryFormValidation
  Scenario: Validation on Client Inquiry Form
    When I click on "Submit inquiry"
    Then I should see text "First name is required"
    And  I should see text "Last name is required"
    And  I should see text "Email is required"
    And  I should see text "Company name is required"
    And  I should see text "Phone number is required"
    And  I should see text "Inquiry type is required"
    And  I should see text "Message is required"
    When I fill in email address with "testers@"
    Then I should see text "Please enter a valid email address"
    When I enter phone number "aaaaa"
    Then I should see text "Please enter a valid Phone Number"

  @clientInquiryFormSubmit @ReleaseRegression2
  Scenario: Submit Client Inquiry Form
    When I fill in Email address with random client email
    And  I enter first name "automation"
    And  I enter last name "Client Contact"
    And  I enter client company name "resume-library"
    And  I enter phone number "123456789"
    And  I select the option "Billing / Checkout" from inquiry type
    Then I fill in inquiry messages text area with "inquiry message"
    Then I click on "Submit inquiry"
    Then I should see text p tag "Thank you for your inquiry, we will be in touch soon." and verify message "Inquiry Sent Successfully. Thank you for your inquiry, we will be in touch soon."