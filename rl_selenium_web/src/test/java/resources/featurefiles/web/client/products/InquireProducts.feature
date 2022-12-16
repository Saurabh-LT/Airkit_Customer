@InquireProducts @Regression @Web  @Recruiters
Feature: Client Products InquireProducts

  Background: Login as a client
    Given   I login as a client

  @InquireProductContactCredits
  Scenario: As a logged In user validating the Inquire Now link for Contact Credits Product
    When   I navigate to page "Resources"
    Then   I should see text "Products"
    When   I mouse hover Products Navigation menu
    Then   I should see text "Contact Credits"
    Then   I should see text "Job Postings"
    And    I click on "Contact Credits"
    Then   I should be able to see in browser URL "Client Products Contact Credits"
    When   I click on "Inquire Now"
    Then   I should be able to see in browser URL "Client Contact"
    And    I select the option "Resume Search" from inquiry type