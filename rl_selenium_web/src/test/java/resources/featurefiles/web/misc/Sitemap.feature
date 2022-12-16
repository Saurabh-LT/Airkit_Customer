@SitemapPage @Regression @Web @Misc @Traffic
Feature: Misc Sitemap

  Scenario: Sitemap use links
    Given I navigate to page "Site Map"
    Then    I should see text "General"
    And     I should see text "Jobseekers"
    And     I should see text "For Employers"
    And     I should see text "Career advice"
    And     I should see text "For The Media"
    And     I should see text "Partners"
    And     I should see text "Other"
    And     I should see text "Jobs by industry"
    And     I should see text "Jobs by location"