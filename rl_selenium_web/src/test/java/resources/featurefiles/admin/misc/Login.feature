@AdminLogin @Regression @Admin @ReleaseRegression1 @Recruiters @AdminE2E
Feature: Admin Misc Login

  Scenario: Login into admin and verify some elements
    Given   I login as an admin user
    Then    I should be on dashboard
    And     I should see text "Dashboard"
    And     I should see text "Sales"
    And     I should see text "CRC"
    And     I should see text "Marketing"