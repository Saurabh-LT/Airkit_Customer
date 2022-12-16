# Test scenarios
  #1. Resume search builder form validation
  #2. Resume search basic form validation (default tab)

@ResumeSearchForm @Regression @Web  @Search
Feature: Client ResumeSearch SearchValidations

  Background: On resume search page
    Given I login as a client
    When  I navigate to page "Client Resume Search"

  @resumeSearchBasicValidations
  Scenario: Validations for resume search on basic tab
    And   I click on Search Resumes
    Then  I should see "No Search Criteria"
    Then  I click on "Close"
    And   I fill in basic search keywords with "sales"
    And   I select the option "15" from dropdown with id "distance"
    And   I click on Search Resumes
    Then  I should see "Invalid Distance"
    And   I click on "Close"
    And   I enter location with "somewhere"
    And   I click on Search Resumes
    Then  I should see text "Please enter a valid location"
    When  I click on "Reset form"
    Then  I should not see "Please enter a valid location"

  @resumeSearchBasicFormSalaryValidation
  Scenario: Resume search basic form salary validation
    And   I fill in basic search keywords with "sales"
    And   I select option "125000" from Salary Min
    And   I click on Search Resumes
    And   I scroll into view header
    And   I select option "30000" from Salary Max
    And   I click on Search Resumes
    And   I scroll into view header
    Then  I should see "Invalid Salary"

  @resumeSearchBasicFormKeywordsValidation
  Scenario: Resume search Basic form keywords validation
    And   I fill in basic search keywords with "striker"
    And   I fill in basic search keywords with "stranger"
    And   I click on Search Resumes
    Then  I should see text "stranger"
    Then  I should not see "striker"
    When  I click on "Reset form"

  @resumeSearchBuilderFormValidation
  Scenario: Resume search builder form validation
    And   I click on id "builder"
    And   I click on Search Resumes
    Then  I should see "No Search Criteria"
    And   I click on "Close"
    And   I enter search builder keywords text area with "sales"
    And   I select the option "15" from dropdown with id "distance"
    And   I click on Search Resumes
    Then  I should see text "Invalid Distance"
    And   I click on "Close"
    And   I enter location with "somewhere"
    And   I click on Search Resumes
    Then  I should see text "Please enter a valid location"
    When  I click on "Reset form"
    Then  I should not see "Please enter a valid location"

  @resumeSearchBuilderFormSalaryValidation
  Scenario: Resume search builder form salary validation
    And   I click on id "builder"
    And   I click on "More Search Options"
    And   I enter search builder keywords text area with "sales"
    And   I select option "125000" from Salary Min
    And   I select option "100000" from Salary Max
    And   I click on Search Resumes
    And   I scroll into view header
    And   I click on "More Search Options"
    When  I select option "30000" from Salary Max
    And   I click on Search Resumes
    And   I scroll into view header
    Then  I should see text "Invalid Salary"

  @resumeSearchBuilderFormKeywordsValidation @ReleaseRegression2
  Scenario: Resume search builder form keywords validation
    And   I click on id "builder"
    When  I enter search builder keywords text area with "strange"
    And   I enter location with "10010"
    When  I enter search builder keywords text area with "manager"
    Then  I should see text "strange"
    And   I should see text "manager"
    And   I click on id "builder"
    When  I click on "Reset form"
    And   I click on id "keywords_builder_textarea_input"
    When  I enter search builder keywords text area with "java" to autocomplete
    And   I hover from autocomplete for keywords textarea input for the option "Java Developer"
    Then  I should see all elements for ".synonyms-popup" class
    When  I click on "Java Developer" link from keywords search results
    And   I click on id "builder"
    Then  I should see text "Java Developer"
    When  I click on "Reset form"
    Then  I reload the page
    And   I click on id "keywords_builder_textarea_input"
    When  I enter search builder keywords text area with "java" to autocomplete
    And   I hover from autocomplete for keywords textarea input for the option "Java Developer"
    Then  I should see all elements for ".synonyms-popup" class
    When  I click on "+ Add all terms" link from keywords search results
    And   I click on id "builder"
    Then  I should see text "Java Developer"
    And   I should see text "java consultant"
    And   I should see text "java engineer"
    Then  I click on "Reset form"
    When  I enter search builder keywords text area with "Java Developer" with enter key
    Then  I should see text "Add Related Terms"
