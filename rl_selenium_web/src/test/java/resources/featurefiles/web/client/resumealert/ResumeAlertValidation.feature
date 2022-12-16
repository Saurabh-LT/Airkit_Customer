@ResumeAlertValidation @Regression @Web  @Recruiters
Feature: Client ResumeAlert ResumeAlertValidation

  @resumeAlertFieldValidation
  Scenario: Create Alert page field validation
    Given I login as a client
    When  I navigate to page "Client Resume Alert Create"
    And   I click on "Create Resume Alert"
    Then  I should see text "Please enter an alert name"
    Then  I should see text "Please enter keywords"
    Then  I should see text "Enter a location or select Nationwide"
    And   I click on "Search Builder"
    Then  I should see text "Please enter an alert name"
    Then  I should see text "Enter a location or select Nationwide"
    And   I click on "Create Resume Alert"
    Then  I should see text "Please enter an alert name"
    Then  I should see text "Please enter keywords"
    Then  I should see text "Enter a location or select Nationwide"

  @resumeAlertPagination
  Scenario:Create Alert Page Pagination
    Given I login as testers client
    And   I navigate to page "Client Resume Alert"
    And   I should see text p tag "Displaying" and verify message "Displaying 1 to 20 of"
    And   I scroll down 0,2000
    And   I click on "2"
    Then  I should be on page "Client Resume Alerts 2"
    And   I should see text p tag "Displaying" and verify message "Displaying 21 to 40 of"
    And   I should see "Prev" link
    And   I scroll down 0,2000
    When  I click on "Prev"
    Then  I should be on page "Client Resume Alerts 1"
    And   I should not see "Prev" link

