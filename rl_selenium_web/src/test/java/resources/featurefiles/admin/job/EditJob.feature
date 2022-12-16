@editAdminJob @Regression @Admin @ReleaseRegression1 @Recruiters
Feature: Admin Job EditJob

  Background: Navigating to Add A Job page
    Given I login as an admin user

  @editAdminFeatureJob
  Scenario: Edit an admin feature job
    When   I navigate to page on admin "Jobs Edit 24746408"
    And    I select the option "Active" from "Status" field
    And    I scroll down 0,2000
    And    I select "0" from spend credit dropdown
    And    I fill in expiry date with "01/01/2025"
    And    I fill in posted with "07/06/2021"
    And    I fill in title name with "Test Featured"
    And    I fill in premium until  with "01/01/2025"
    And    I click on update job
    Then   I should see text "Job successfully updated"

  @editAdminPremiumFeatureJob
  Scenario: Edit an admin premium feature job
    When   I navigate to page on admin "Jobs Edit 25759485"
    And    I select the option "Active" from "Status" field
    And    I select "0" from spend credit dropdown
    And    I fill in expiry date with "01/08/2022"
    #this date must not be older than 30 days
    And    I fill in posted with "01/09/2021"
    And    I fill in premium until  with "01/08/2022"
    And    I click on update job
    Then   I should see text "Job successfully updated"