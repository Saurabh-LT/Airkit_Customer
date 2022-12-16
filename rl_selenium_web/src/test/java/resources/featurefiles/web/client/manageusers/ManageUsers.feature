@ManageUsers @Regression @Web  @ReleaseRegression2 @Recruiters
Feature: Client ManageUsers ManageUsers

  Background: Navigating to Manage User page
    Given I login as a client
    When  I navigate to page "Client Account Users"
    Then  I should see text H one tag "Manage Users"

  @addUser
  Scenario: Add new client user
    When I should see text H three tag "Account Credits:"
    And  I should see text "Name"
    And  I should see text "Email"
    And  I should see text "Status"
    When I click on "Add User"
    Then I should be able to see in browser URL "Client Account Users Add"
    And  I should see text H one tag "Add User"
    When I click on Add User button
    And  I should see text "First name is required"
    And  I should see text "Last name is required"
    And  I should see text "Email is required"
    Then I reload the page
    And  I enter first name "aaaaautomation"
    And  I enter last name "client"
    When I fill in Email address with random client email
    When I click on Add User button
    Then I should be able to see in browser URL "Client Account Users"
    And  I should see message "aaaaautomation client has been added as a user to your account." in the manage users xpath

  @editUser
  Scenario: Edit an existing client user
    When I click on "Add User"
    Then I should be able to see in browser URL "Client Account Users Add"
    And  I enter first name "aaaaautomation"
    And  I enter last name "client"
    When I fill in Email address with random client email
    When I click on Add User button
    Then I should be able to see in browser URL "Client Account Users"
    When I click on manage users active action one
    And  I click on id "edit-user-btn-1"
    Then I should be able to see in browser URL "Client Account Users Edit"
    And  I should see text "Edit User"
    And  I enter first name "aaaaautomation"
    And  I enter last name "client"
    And  I click on Edit User button
    Then I should be able to see in browser URL "Client Account Users"
    And  I should see message "aaaaautomation client has been updated." in the manage users xpath

  @deactivateUser
  Scenario: Deactivate an existing client user
    When I click on "Add User"
    Then I should be able to see in browser URL "Client Account Users Add"
    And  I enter first name "aaaaautomation"
    And  I enter last name "client"
    When I fill in Email address with random client email
    When I click on Add User button
    # We need this wait for Firefox Browser
    And  I wait for "2" seconds
    Then I should be able to see in browser URL "Client Account Users"
    # We need this wait for success message banner to disappear
    And  I wait for "1" seconds
    And  I reload the page
    When I click on manage users active action one
    And  I click on id "deactivate-user-btn-1"
    And  I should see text "Deactivate User"
    And  I should see "Are you sure you want to deactivate this user?"
    And  I click on "Yes, deactivate"
    Then I should be able to see in browser URL "Client Account Users"
    And  I should see message "aaaaautomation client has been deactivated." in the manage users xpath

  @reactivateUser
  Scenario: Reactivate an existing client user
    Then I click to activate the inactive user from the list
    And  I click on "Activate"
    And  I should see text "Activate User"
    And  I should see text "Are you sure you want to activate this user?"
    And  I click on id "no-cancel-btn"
    Then I should be able to see in browser URL "Client Account Users"

  @transferContactCredits
  Scenario: Transfer contact credits from one user to other
    Then I Verify "Transfer Credits" and update account details in "/account/view/1478"
    When I click on "Transfer Credits"
    And  I should see text H three tag "Transfer Credits"
    Then I select "1360713" from from client
    And  I select "11517334" from to client
    And  I fill in amount with "1"
    And  I click on Transfer button
    And  I should see text "Transfer Successful"
    And  I click on "OK"