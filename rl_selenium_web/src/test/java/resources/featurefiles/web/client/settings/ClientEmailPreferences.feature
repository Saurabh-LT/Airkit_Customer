@ClientEmailPreferences @Regression @Web  @ReleaseRegression2 @Traffic
Feature: Client Settings ClientEmailPreferences

  Background: Navigating to Client Email Preferences
    Given  I login as a client
    When  I mouse hover "Hi Resume library"
    Then  I should see text "Email Preferences"
    When  I click on "Email Preferences"
    Then  I should be able to see in browser URL "Client Email Preferences"

  @emailPreferencesClient
  Scenario: Check email preferences for client side
    Then  I Verify and click "I would like to receive all of the above"
    Then  I should see text H one tag "My Email Preferences"
    And   I should see text "I would like to receive:"
    And   I should see text message email preferences "Please note: You will still receive emails regarding job postings, as well as any system updates."
    And   I should see "Remember to add us to your safe senders list! Check your email settings if you're unsure how to do this."
    And   I click on client newsletter emails
    And   I click product updates emails
    And   I click resume match emails
    And   I click marketing emails
    And   I click resume alerts emails
    And   I click on update profile button
    Then  I should see text "Your email preferences have now been updated."
    And   I should see text "You are no longer subscribed to Resume-Library emails. To start receiving emails, please use the checkboxes below."
    And   I click I would like to receive all of the above
    And   I click on update profile button
    And   I should not see "You are no longer subscribed to Resume-Library emails. To start receiving emails, please use the checkboxes below."
    Then  I should see text "Your email preferences have now been updated."