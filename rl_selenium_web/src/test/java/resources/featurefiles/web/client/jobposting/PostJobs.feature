@PostJobs @Regression @Web  @ReleaseRegression2 @Recruiters
Feature: Client JobPosting PostJobs

  Background:
    Given I navigate to page "Hiring Post Jobs"

  @clientLogoutPostJobs
  Scenario: As a logged out client verify headers text in 'Post Jobs' page

    And   I should see text H one tag "Flexible Pricing to Suit Your Needs"
    And   I should see "Trusted with jobs from the Fortune 500"
    And   I should see text H three tag "30-day Job Posting"
    And   I should see "Recruit from as little as $79 with our duration jobs."
    And   I should see "Up to 10 Jobs"
    And   I should see text key feature "KEY FEATURES"
    And   I should see text "Pay per job posting"
    And   I should see text "Use within 12 months"
    And   I should see text "Jobs will be live for 30-days"
    When  I click on "Buy Online"
    Then  I should be on page "/client/registration?redirect=%2Fclient%2Fpurchase"
    And   I should see text p tag "Start Hiring with " and verify message "Start Hiring with Resume-Library Today"

  @clientLogoutPostJobs
  Scenario: As a logged out client verify text messages in 'Post Jobs' page

    And   I should see text H three tag "Pay for Performance"
    And   I should see "Set your own budgets with our Pay for Performance jobs."
    And   I should see "10+ Jobs"
    And   I should see text key feature "KEY FEATURES"
    And   I should see text "Complete control of your budgets"
    And   I should see text "Only pay for clicks, views or applies"
    And   I should see text "Choose the duration of your jobs"
    And   I click on "Learn More"
    Then  I should be on page "Hiring Pay For Performance Job Advertising"
    And   I should see text h one tags "Achieve Total Control with " and verify message "Achieve Total Control with Pay for Performance Advertising"

  @clientLogoutPostJobs
  Scenario: As a logged out client verify hiring text messages in 'Post Jobs' page

    And   I should see text h two tag "Advertise Your Jobs and Hire Fast with " and verify message "Advertise Your Jobs and Hire Fast with Resume-Library"
    And   I should see text p tag "Here are just some of the reasons thousands of businesses post their jobs on " and verify message "Here are just some of the reasons thousands of businesses post their jobs on Resume-Library:"
    And   I should see text H two tag "Guaranteed Exposure for Your Jobs"
    And   I should see "We'll post your jobs across relevant sites in our huge traffic network of 100+ job sites, at no extra cost."
    And   I click on "View our Traffic Network"
    Then  I should be on page "Hiring Partner Network"
    And   I should see text h one tags "Extensive Traffic Network" and verify message "Resume-Library's Extensive Traffic Network"
    When  I navigate to page "Hiring Post Jobs"
    And   I should see text H two tag "World-Class Customer Service"
    And   I should see "Our team of dedicated account managers will be on hand to help you save time and money throughout your hiring campaign."
    And   I should see "Fairlead"
    Then  I click on next-btn
    And   I should see "Resume-Library is user friendly and provides a resume overview for selected candidates. They assist their clients in research and analysis and are very responsive to inquiries"
    Then  I click on next-btn
    And   I should see "Resume-Library has given our company an extra helping hand in searching for qualified candidates through their candidate matching process."
    And   I should see text p tag "Call our sales team on: " and verify message "Call our sales team on: 1-800-672-6706 or Contact Us"
    And   I click on "Contact Us"
    Then  I should be on page "Client Contact"
    And   I should see text "Inquire now"

  @clientLogoutPostJobs
  Scenario: As a logged out client verify client contact text messages in 'Post Jobs' page

    And   I should see text H two tag "Enhance Your Hiring Process"
    And   I should see text "Fill your jobs faster"
    And   I should see "Post your jobs on Resume-Library to receive the best applications straight to your inbox."
    And   I should see text "Showcase your brand"
    And   I should see "Get your brand seen the moment they visit Resume-Library with a homepage logo."
    And   I should see text "Targeted candidate emails"
    And   I should see "Advertise your urgent positions in front of the right candidates."
    And   I click on "Contact Sales"
    Then  I should be on page "Client Contact"
    And   I should see text "Inquire now"

  @clientLogoutPostJobs
  Scenario: As a logged out client verify request trail text messages in 'Post Jobs' page

    And   I should see text p tag "Try " and verify message "Try Resume-Library for Free Today"
    And   I click on "Request Free Trial"
    Then  I should be on page "Hiring Request A Trial"
    And   I should see text "Activate Your Free Trial Today"