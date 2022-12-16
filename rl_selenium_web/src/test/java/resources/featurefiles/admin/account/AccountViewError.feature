@AccountView @Regression @Admin @ReleaseRegression1 @Recruiters
Feature: Admin Account AccountViewError

  @accountViewOne @AdminE2E
  Scenario: Search for an account using account number 1478 and verify page load
    Given   I login as an admin user
    When    I navigate to page on admin "Account 1478"
    Then    I should see text "Acme Company No 1728 (1478)"
    Then    I should see text "Jobs (Last 30 days)"
    Then    I should see text "Resume Search (Last 30 days)"
    Then    I should see text "Resume Alerts"
    Then    I should see text "Account Overview"
    Then    I should see text "Contact Details"
    Then    I should see text "Account Details"
    And     I should see text "Product Details"

  @accountViewTwo
  Scenario: Search for an account using account number 11626 and verify page load
    Given   I login as an admin user
    When    I navigate to page on admin "Account 11626"
    Then    I should see text "Acme Company No 11092 (11626)"
    Then    I should see text "Jobs (Last 30 days)"
    Then    I should see text "Resume Search (Last 30 days)"
    Then    I should see text "Resume Alerts"
    Then    I should see text "Account Overview"
    Then    I should see text "Contact Details"
    Then    I should see text "Account Details"
    And     I should see text "Product Details"

  @accountViewThree
  Scenario: Search for an account using account number 19088 and verify page load
    Given   I login as an admin user
    When    I navigate to page on admin "Account 19088"
    Then    I should see text "Acme Company No 787777 (19088)"
    Then    I should see text "Jobs (Last 30 days)"
    Then    I should see text "Resume Search (Last 30 days)"
    Then    I should see text "Resume Alerts"
    Then    I should see text "Account Overview"
    Then    I should see text "Contact Details"
    Then    I should see text "Account Details"
    And     I should see text "Product Details"