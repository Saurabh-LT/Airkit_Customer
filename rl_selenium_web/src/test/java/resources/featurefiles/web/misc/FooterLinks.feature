@FooterOnlyLinks @Regression @Web @Misc @Candidate
Feature: Misc FooterLinks

  Background: Logged out
    Given   I am on home page

  Scenario: Footer link press
    Then    I should see text "Press"
    When    I click "Press" in the footer
    Then    I should be on "Press" page
    And     I should see text message "Welcome to Our Press Center!"
    #Can't verify below steps on through Jenkins
    #And     I scroll down 0,800
    #And     I should see text H two tag "Our Latest News Stories"
    #And     I should see text "Media Images"

  @footerLinkCVLibrary @ReleaseRegression2
  Scenario: Footer link CV-Library
    Then    I should see text "CV-Library.co.uk"
    And     I click "CV-Library" in the footer
    Then    I should be on "CV-Library" page
    And     I should see text "Popular industries"
    And     I should see text "Browse industry job titles and locations"

  Scenario: Footer link employers
    Then    I should see text "Employers"
    And     I click "Employers" in the footer
    Then    I should be on "Hiring" page
    Then    I should see text "America's Fastest-Growing Job Board" on the page

  Scenario: Footer link post jobs
    Then    I should see text "Post Jobs"
    And     I click "Post Jobs" in the footer
    Then    I should be on "Hiring Post Jobs" page
    And     I should see text "30-day Job Posting"
    And     I should see text "Pay for Performance"

  Scenario: Footer link partner network
    Then    I should see text "Partner Network"
    And     I click "Partner Network" in the footer
    Then    I should be on "Partner Network" page
    And     I should see text "Become part of our network"

  Scenario: Footer link about us
    Then    I should see text "About Us"
    And     I click "About Us" in the footer
    Then    I should be on "About Us" page
    And     I should see text "How does Resume-Library work?"
    And     I should see text "Our CEO: Lee Biggins"

  Scenario: Footer link meet the team
    Then    I should see text "Meet the Team"
    And     I click "Meet the Team" in the footer
    Then    I should be on "Meet the Team" page
    And     I should see text "Meet the Resume-Library Team"
    And     I should see text "About Resume-Library"
    And     I should see text "The Whole Resume-Library Team"

  Scenario: Footer link work for us
    Then    I should see text "Work For Us"
    And     I click "Work For Us" in the footer
    Then    I should be on "Work For Us" page
    #And     I should see text h two tag "Find a job at " and verify message "Find a job at Resume-Library"
    And     I should see text h two tag "About " and verify message "About Resume-Library"
    And     I should see text "Why join Resume-Library?"

    @footerLinkFacebook @ReleaseRegression2
  Scenario: Footer link facebook
    When    I click "Facebook" icon in the footer
    Then    I should be on "Facebook" page
  #  And     I should see text "Resume-Library"

  Scenario: Footer link twitter
    When    I click "Twitter" icon in the footer
    Then    I should be on "Twitter" page
    And     I should see text "Resume-Library"

  Scenario: Footer link instagram
    When    I click "Instagram" icon in the footer
    And     I click on Accept All
    Then    I should be on "Instagram" page

    @footerLinkPlayStore @ReleaseRegression2
  Scenario: Footer link play store
    When    I click "Google Play" icon in the footer
    Then    I should be on "Google Play" page
    And     I should see text "Resume-Library"
    And     I should see text "Business"

  Scenario: Footer link app store
    When    I click "App Store" icon in the footer
    Then    I should be on "App Store" page
    #And     I should see text H one tag "Resume-Library"
    #And     I should see text "Resume Library Ltd"

  Scenario: Footer link linkedin
    When   I click "Linkedin" icon in the footer
    Then   I should be on "Linkedin" page
#    Then   I should see text "Sign up for free to get more"
#    And    I should see text "By clicking Agree & Join, you agree to the LinkedIn "

  Scenario: Footer link youtube
    When   I click "YouTube" icon in the footer
    And    I click on I AGREE
    Then   I should be on "YouTube" page
    And    I should see text "Resume-Library"
    And    I should see text "Employers"
    And    I should see text "Integrations"