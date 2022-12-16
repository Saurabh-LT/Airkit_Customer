@PartnersAlliance @Regression @Web @Partner @ReleaseRegression2 @Partnerships
Feature: Partner PartnersAlliance

  Scenario: Partner Alliance - Validate the form and submit
    Given   I am on home page
    When    I click "Partners" in the footer
    Then    I should see text "Resume-Library Partner Center"
    And     I should see text "Work with Resume-Library to maximize the performance of your platform!"
    When    I click Alliance Partners button
    Then    I should see text "Monetize Your Candidate Database as an Alliance Partner"
    When    I click Become an Alliance Partner button
    Then    I click Request a call back button
    Then    I should see text "Please enter your name"
    Then    I should see text "Please enter your email address"
    Then    I should see text "Please enter your contact number"
    And     I should see text "Please enter your inquiry"
    Then    I fill in the partner form
    And     I click Request a call back button
    #And     I should see text "Thank you for your enquiry. A member of our friendly team will be in touch soon to discuss your requirements. Kind regards, Resume-Library"