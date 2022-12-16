@Ads @Regression @Web @Misc @ReleaseRegression2 @Traffic
Feature: Misc Ads

  Scenario: Verify ads.txt page
    Given I navigate to page "Ads"
    Then I should see text "#TOTALMedia"
    And I should see text "#Teads"
    And I should see text "#152Media"
    And I should see text "#152Media_New"
    And I should see text "#Sovrn"
    And I should see text "#AdSense"
    And I should see text "#DistrictM"
    And I should see text "#EMX Digital"
    And I should see text "#Mediagrid"
    And I should see text "#TradeHouse Media"
    And I should see text "#index exchange"
    And I should see text "#Brightcom"
    And I should see text "#Rhythm One"
    And I should see text "#AMX"
    And I should see text "#Outbrain"
    And I should see text "#Amazon"