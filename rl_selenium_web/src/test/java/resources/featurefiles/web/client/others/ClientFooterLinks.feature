@ClientFooterOnlyLinks @Regression @Web  @ReleaseRegression2 @Recruiters
Feature: Client Others ClientFooterLinks

@ClientFooterOnlyLinksLoggedInAndLoggedOut
Scenario: Client login and Logged out footer links 
  Given I login as a client
  And   I should not see "App Store" footer link
  And   I should not see "Google Play" footer link
  When  I am on page "Logout" and I should see browser URL "Hiring"
  Then  I should see text "Events"
  And   I should see text "Work Permits & Visas"
  And   I should not see "App Store" footer link
  And   I should not see "Google Play" footer link
  When  I click on footer events link and I should see in browser url "Resources Events"
  And   I should see text "Resume-Library Events"
  And   I should see text "Find Us at the Following Events…"
  And   I should see text "Past Events"
  When  I navigate to page "Hiring"
  And   I click on footer work permits and visas link
  Then  I should be able to see in browser URL "Resources A Guide To Visas And Work Permits For Foreign Nationals"
  And   I should see text H one tag "A Guide to Visas and Work Permits for Foreign Nationals"