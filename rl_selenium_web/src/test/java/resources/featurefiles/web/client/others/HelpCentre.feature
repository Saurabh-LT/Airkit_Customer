@ClientHelpCentre @Regression @Web  @ReleaseRegression2 @Recruiters
Feature: Client Others HelpCentre

  Background: Client Login
    Given I login as a client

  @helpCentreVideos
  Scenario: Verify Client Help Centre Videos
    Given I navigate to page "Client Help Videos"
    Then  I should see text "Video Guides"
    And   I should see text "Our Helpful Video Guides"
    And   I click on "Search Builder"
    Then  I should be able to see in browser URL "Client Help Videos Search Builder"
    And   I should see text "Search Builder"
    And   I should see "Our innovative Resume search tool helps you source the best candidates matches in seconds"
    When  I click on video play button in the frame "search-builder"
    #We need this wait because, we are playing video for 5 seconds and pausing
    And   I wait for "5" seconds
    And   I click on video pause button in the frame "search-builder"
    And   I should see the video played up to "00:05" seconds
    And   I navigate to page "Client Help Videos"
   # And   I move backward one page
    And   I click on "Screening Questions"
    Then  I should be able to see in browser URL "Client Help Videos Screening Questions"
    And   I should see text "Screening Questions"
    And   I should see "Add custom questions to every job posting to help you quickly identity that best applicants"

    When  I click on video play button in the frame "screening-questions"
    #We need this wait because, we are playing video for 5 seconds and pausing
    And   I wait for "5" seconds
    And   I click on video pause button in the frame "screening-questions"
    And   I should see the video played up to "00:05" seconds
    And   I navigate to page "Client Help Videos"
    #And   I move backward one page
    And   I click on "Video Interviews"
    Then  I should be able to see in browser URL "Client Help Videos Video Interviews"
    And   I should see text "Video Interviews"
    And   I should see "Set up video interviews with your candidate shortlist in seconds and recruit remotely"

    When  I click on video play button in the frame "video-interviews"
    #We need this wait because, we are playing video for 5 seconds and pausing
    And   I wait for "5" seconds
    And   I click on video pause button in the frame "video-interviews"
    And   I should see the video played up to "00:05" seconds
    And   I navigate to page "Client Help Videos"
    #And   I move backward one page
    And   I click on "Invite to Apply"
    Then  I should be able to see in browser URL "Client Help Videos Invite To Apply"
    And   I should see text "Invite to Apply"
    And   I should see "Contact candidates directly and invite them to apply to your jobs."
    When  I click on video play button in the frame "ita"
    #We need this wait because, we are playing video for 5 seconds and pausing
    And   I wait for "5" seconds
    And   I click on video pause button in the frame "ita"
    And   I should see the video played up to "00:05" seconds