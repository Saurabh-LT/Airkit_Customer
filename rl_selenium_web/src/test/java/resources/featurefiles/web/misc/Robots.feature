@Robots @Regression @Web @Misc @Traffic
Feature: Misc Robots

  Scenario: Verify robots.txt page
    Given  I navigate to page "Robots"
    Then I should see text "# candidate/registration removed 10/11/2020"
    And I should see text "# Baidu Chinese search engine"
    And I should see text "# Yandex RU search engine"
    And I should see text "# Yahoo"