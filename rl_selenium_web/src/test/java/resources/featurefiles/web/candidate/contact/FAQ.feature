@CandidateFAQ @Regression @Web  @Candidate
Feature: Candidate Contact FAQ

  @candidateDeleteAccountFAQ
  Scenario Outline: As a candidate I search for a frequently asked question to find out how to delete my account.
    Given I navigate to page "Faq"
    And   I should see text H one tag "How Can We Help You?"
    And   I select faq type "<Type>" from dropdown
    Then  I enter faq query to search field "<Search>"
    And   I click "Find Answers" button
    Then  I should see to march with question "<Text>"
    Examples:
      | Type              | Search                                     |Text|
      | I am a Job Seeker | how do i delete my resume-library account? |How do I delete my Resume-Library account?|