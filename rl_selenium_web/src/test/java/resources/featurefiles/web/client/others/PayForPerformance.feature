@PayForPerformance @Regression @Web  @Traffic
Feature: Client Others PayForPerformance

  @payForPerformanceAssertAndActions
  Scenario: Verify elements in Pay For Performance page
    Given I navigate to page "Hiring Post Jobs"
    And   I click on "Learn More"
    Then  I should be able to see in browser URL "Hiring Pay For Performance Job Advertising"
    And   I should see text h one tags "Achieve Total Control with " and verify message "Achieve Total Control with Pay for Performance Advertising"
    And   I should see text "Tailored Hiring Solutions For your Team"
    And   I scroll down 0,800
    And   I should see text "Which Job Posting Model is Right for Me?"
    And   I scroll down 0,1200
    Then  I click on post jobs button
    Then  I should be able to see in browser URL "/client/registration?redirect=%2Fclient%2Fpurchase"
    And   I should see text p tag "Start Hiring with " and verify message "Start Hiring with Resume-Library Today"
    When  I navigate to page "Hiring Pay For Performance Job Advertising"
    And   I scroll down 0,800
    Then  I click on "Request a demo"
    And   I should be able to see in browser URL "Hiring Request A Demo"
    And   I should see text "Request a Demo"
    When  I navigate to page "Hiring Pay For Performance Job Advertising"
    And   I scroll down 0,800
    And   I should see text "Ready to Get Started?"
    Then  I click on "Get started"
    And  I should be able to see in browser URL "Client Registration"