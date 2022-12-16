# Test Coverage
# 1. Create an alert from the create alert (basic) page using enter keys
# 2. Edit an alert
# 3. Create an alert from Resume Search page (builder)
# 4. Create an alert from the create alert page using Create Resume Alert button
# 5. Each test deactivates the alert it creates and asserts the action
# 6. Test the action toggle links for activate/deactivate
#    Adhoc selenium testing may add alerts so can't guarantee the first alert is
#    always going to be active

@ResumeAlert @Regression @Web  @Recruiters
Feature: Client ResumeAlert ResumeAlert

  Background: Resume alert test
    Given I login as a client

  @resumeAlertCreate1 @ReleaseRegression2 @ClientE2E
  Scenario: Create Resume Alert on Resume Alerts page using enter key
    When I navigate to page "Client Resume Alert Create"
    And  I should see text H one tag "Create Resume Alert"
    And  I enter name field with "test alert"
    And  I enter location with "10001"
    And  I enter basic search keywords with "\"sales manager\""
    And  I click on "Create Resume Alert"
    Then I should be able to see in browser as URL "Client Resume Alerts Msg Created"
    And  I should see text "Your Resume Alert has been created successfully."
    When I navigate to page "Client Resume Alert"
    When I click on actions button one
    And  I click on "Deactivate"
    Then I wait for "2" seconds
    And  I should see table action "deactivate" button is disabled

  @resumeAlertEdit @ReleaseRegression2
  Scenario: Edit resume alert and deactivate it using enter key
    When I navigate to page "Client Resume Alert Create"
    And  I should see text H one tag "Create Resume Alert"
    And  I enter name field with "test alert"
    And  I enter location with "10001"
    And  I enter basic search keywords with "sales manager"
    And  I click on "Create Resume Alert"
    When I navigate to page "Client Resume Alert"
    When I click on actions button one
    And  I click on "Edit"
    Then I should be able to see in browser URL "Client Resume Alert Edit"
    And  I enter name "test alert2"
    And  I enter location with "10002"
    And  I enter basic search keywords with "sales manager"
    And  I click on "Update Resume Alert"
    Then I should be able to see in browser as URL "Client Resume Alerts Msg Saved"
    And  I should see text "Your Resume Alert has been modified successfully"
    When I click on actions button one
    And  I click on "Deactivate"
    Then I wait for "2" seconds
    And  I should see table action "deactivate" button is disabled

  @resumeAlertCreate2
  Scenario: Create Resume Alert on Resume Search page
    When I am on page "Client Resume Search With Keywords Location"
    And  I should see text "Create Alert"
    Then I click on "Create Alert"
    And  I should see element with text "Alert name" to be "visible"
    And  I should see text "Create a Resume Alert from this search"
    And  I enter alert name with "Selenium alert"
    Then I click on resume Create Alert
    And  I should see text "ResumeAlert created successfully!"
    When I navigate to page "Client Resume Alerts"
    And  I should see text "Selenium alert"
    Then I click on actions button one
    And  I click on "Deactivate"
    Then I wait for "2" seconds
    And  I should see table action "deactivate" button is disabled

  @resumeAlertCreate3
  Scenario: Create Resume Alert on Resume Alerts page using Create alert button
    When I navigate to page "Client Resume Alert Create"
    And  I should see text H one tag "Create Resume Alert"
    And  I enter name field with "test alert"
    And  I enter location with "10001"
    And  I fill in basic search keywords with "\"sales manager\""
    And  I click on "Create Resume Alert"
    Then I should be able to see in browser as URL "Client Resume Alerts Msg Created"
    And  I should see text "Your Resume Alert has been created successfully."
    When I navigate to page "Client Resume Alert"
    And  I should see text "test alert"
    Then I click on actions button one
    And  I click on "Deactivate"
    Then I wait for "2" seconds
    And  I should see table action "deactivate" button is disabled

  @resumeAlertToggleAction @ReleaseRegression2
  Scenario: Toggle Resume Alert Action button
    Given I navigate to page "Client Resume Alert"
    Then I deactivate all active alerts
    Then I click on actions button one
    Then I toggle action button status
    #and again to check toggle both ways
    Then I toggle action button status