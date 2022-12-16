@HiringPage @Regression @Web  @Traffic
Feature: Client Others HiringPage

  Background:
    Given I navigate to page "Hiring"
    And   I reload the page

  @AdvertisingPrevNextIcon @ReleaseRegression2
  Scenario: Advertising highlights Prev and next icon
    Then  I should see text "Attracting millions of jobseekers in 2022"
    And   I should see text "We're reaching more jobseekers than ever before with our outdoor advertising campaigns across key states including New York, California, Georgia and Illinois."
    And   I should see text p tag "With clear messaging and a standout format, this advertising can be seen by " and verify message "With clear messaging and a standout format, this advertising can be seen by millions of commuters in hand-picked, high footfall locations across the country."
    And   I should see text "Atlanta"
    And   I should see text "Heavy, round-the-clock traffic receives head-on exposure to this digital display located on I-75, just south of Roswell Street."
    When  I click on next icon
    Then  I should see text "Boston"
    And   I should see text "This south facing board is located 1 mile north of Tobin Bridge targeting outbound traffic on U.S. Route 1 leaving the Downtown Boston core."
    When  I click on prev icon
    Then  I should see text "Atlanta"
    And   I should see text "Heavy, round-the-clock traffic receives head-on exposure to this digital display located on I-75, just south of Roswell Street."

  @AdvertisingVariousLocations
  Scenario: Advertising highlights in Various Locations
    And   I should see text "Atlanta"
    And   I should see text "Heavy, round-the-clock traffic receives head-on exposure to this digital display located on I-75, just south of Roswell Street."
    When  I click on slide "2" where title is "Boston"
    Then  I should see text "Boston"
    And   I should see text "This south facing board is located 1 mile north of Tobin Bridge targeting outbound traffic on U.S. Route 1 leaving the Downtown Boston core."
    When  I click on slide "3" where title is "Chicago"
    Then  I should see text "Chicago"
    And   I should see text "Located on Interstate 294, the Tri-State Tollway, this screen is viewed by five lanes of southbound traffic. I-294 is one of the heaviest traveled arteries in Chicago."
    When  I click on slide "4" where title is "Chicago"
    Then  I should see text "Chicago"
    And   I should see text "This outstanding display is on I-55, Stevenson Expy just west of First Ave and is highly visible to three lanes of eastbound motorists."
    When  I click on slide "5" where title is "Dallas"
    Then  I should see text "Dallas"
    And   I should see text "Reaching northbound traffic on Central Expressway (Hwy 75) heading from Downtown Dallas to North suburbs/high 5 area."
    When  I click on slide "6" where title is "Los Angeles"
    Then  I should see text "Los Angeles"
    And   I should see text "This digital bulletin is located on the 91 freeway near the city of Artesia, targeting westbound traffic from Riverside and Orange County heading towards Los Angeles."
    When  I click on slide "7" where title is "Los Angeles"
    Then  I should see text "Los Angeles"
    And   I should see text "This newly built, state of the art digital bulletin targets traffic traveling East from Los Angeles."
    When  I click on slide "8" where title is "Miami"
    Then  I should see text "Miami"
    And   I should see text "Targeting commuters in the heart of Lake Worth, centrally located in Palm Beach county, reaching target audiences traveling through West Palm Beach and Boca Raton."
    When  I click on slide "9" where title is "New York"
    Then  I should see text "New York"
    And   I should see text "This digital bulletin is visible to traffic headed towards Long Island and Northern Queens. Northern Boulevard is used as an alternate to the busy Long Island Expressway and Grand Central Parkway."
    When  I click on slide "10" where title is "New York"
    Then  I should see text "New York"
    And   I should see text "This digital spectacular targets traffic from the affluent and upscale suburbs of Westchester & Connecticut, heading into NYC. This unit is at the I-95 & Hutchinson River interchange facing NYC."
    When  I click on slide "11" where title is "New York"
    Then  I should see text "New York"
    And   I should see text "The West Side Highway is the most heavily traveled north/south arterial in Manhattan. This digital unit targets northbound traffic heading from midtown/lower Manhattan, originating towards upper Manhattan."
    When  I click on slide "12" where title is "New York"
    Then  I should see text "New York"
    And   I should see text "Strategically positioned in the highest traffic locations of Times Square subway, targeting people as they work, shop and play in the Big Apple."