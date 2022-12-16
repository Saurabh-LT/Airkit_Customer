@IntegratedServices @Regression @Web  @Recruiters
Feature: Client Others IntegratedServices

  Background: Navigating to Integrated Services page
    Given  I login as a client
    When   I navigate to page "Client Account Integrated Services"

  @verifyIntegratedServicesPage @ReleaseRegression2
  Scenario: Verify page elements in Integrated Services page
    Then  I should see text "Integrated Services"
    And   I should see text "Please be aware that your account will need Job Posting Credits to post jobs with our partners."
    And   I should see text p tag "Your account ID is:" and verify message "Your account ID is: 1478"
    And   I should see text "Service Provider"
    And   I should see text "Integration Guide"
    And   I should see text "Account Key"
    And   I should see text "ATS Import"
    And   I should see text "Actions"
    When  I click on "Dashboard"
    Then  I should be on page "Client Account"

  @validateIntegratedServicesPage
  Scenario: Validate other links in Integrated Services page
    #When  I click on "Generate New Key"
    #And   I should see element with text "Are you sure you want to generate a new key?" to be "visible"
    #And   I click on "Yes"
    #Then  I should be able to see in browser URL "Client Account Integrated Services"
    #And   I click on action toggle btn one
    #And   I should see element with text "Are you sure you want to turn off this service provider?" to be "visible"
    #And   I click on "Yes"
    Then  I should be able to see in browser URL "Client Account Integrated Services"
    #And   I click on action toggle btn one
    When  I click on view guide zoho
    Then  I should be able to see in browser URL "Partner Integrations Zoho"
    And   I should see text "Zoho Recruit"