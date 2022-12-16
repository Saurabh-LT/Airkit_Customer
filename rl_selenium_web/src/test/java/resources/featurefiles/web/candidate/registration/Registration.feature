@CandidateRegistration  @Regression @Web  @Candidate
Feature: Candidate Registration Registration

  @candidateValidRegistration @ReleaseRegression1 @CandidateE2E
  Scenario Outline: Register a new candidate with all valid details
    Given I am on home page
    When  I click on Register button
    Then  I should be on page "Candidate Registration Page"
    When  I enter email address "<Email>"
    And   I enter first name "<FirstName>"
    And   I enter last name "<LastName>"
    And   I enter password "<Password>"
    And   I enter latest job title "<JobTitle>"
    And   I enter zip code "<ZipCode>"
    And   I upload resume "<Resume>"
    And   I click on register button
    Then  I should be on page "Candidate Registration Page"
    When  I enter phone number "<Phone>"
    And   I enter desired job title "<DesiredJobTitle>"
    And   I select job type "<JobType>"
    And   I select minimum salary "<SalMin>" and maximum salary "<SalMax>"
    And   I click on on add job title link and enter keyword "<Keyword>"
    And   I click on complete button
    Then  I should see text "<Msg>"
    And   I should see text "<Msg1>"
    Then  I click on "Yes Please"
    And   I should see element with text "Yes Please" to be "invisible"
    Examples:
      | Email          | FirstName | LastName | Password | Resume  | JobTitle     | ZipCode   | Phone        | DesiredJobTitle | JobType  | SalMin | SalMax | Keyword                 | Msg                                                    | Msg1                                   |
      | test@gmail.com | Bob       | Russel   | 123456   | Test Cv | Test Analyst | 50001, IA | 012345678912 | QA Analyst      | Contract | 60,000 | 70,000 | Automation Test Analyst | Success! Your resume has been added to Resume-Library! | Increase your chances of getting hired |

  @CandidateInvalidRegistration1
  Scenario Outline: Register page 1 field validation
    Given I am on home page
    When  I click on Register button
    Then  I should be on page "Candidate Registration Page"
    When  I enter email address "<Email>"
    And   I enter first name "<FirstName>"
    And   I enter last name "<LastName>"
    And   I enter password "<Password>"
    And   I enter latest job title "<JobTitle>"
    And   I enter zip code "<ZipCode>"
    And   I click on register button
    Then  I should see text "<Msg>"
    And   I should see text "<Msg1>"
    And   I should see text "<Msg2>"
    And   I should see text "<Msg3>"
    And   I should see text "<Msg4>"
    And   I should see text "<Msg5>"
    Examples:
      | Email | FirstName | LastName | Password | JobTitle | ZipCode | Msg                                | Msg1                   | Msg2                  | Msg3                 | Msg4                         |  Msg5                         |
      |       |           |          |          |          | 50001, IA  | Please enter a valid email address | First name is required | Last name is required | Password is required | Latest job title is required | Resume is required         |

  @CandidateInvalidRegistration2
  Scenario Outline: Register page 2 field validation
    Given I am on home page
    When  I click on Register button
    Then  I should be on page "Candidate Registration Page"
    When  I enter email address "<Email>"
    And   I enter first name "<FirstName>"
    And   I enter last name "<LastName>"
    And   I enter password "<Password>"
    And   I enter latest job title "<JobTitle>"
    And   I enter zip code "<ZipCode>"
    And   I upload resume "<Resume>"
    And   I uncheck the label Claim my free professional Resume Review
    And   I click on register button
    Then  I should be on page "Candidate Registration Confirm"
    And   I enter phone number "<Phone>"
    When  I enter desired job title "<DesiredJobTitle>"
    And   I select job type "<JobType>"
    And   I select minimum salary "<SalMin>" and maximum salary "<SalMax>"
    Then  I should see text from salary swap"<Msg>"
    And   I should see text "<Msg1>"
    And   I select minimum salary "<SalMin1>" and maximum salary "<SalMax1>"
    And   I should see text from error salary expectation "<Msg2>"
    And   I select minimum salary "<SalMin2>" and maximum salary "<SalMax2>"
    And   I should see text from error salary expectation "<Msg2>"
    And   I select minimum salary "<SalMin3>" and maximum salary "<SalMax3>"
    And   I should see text from error salary expectation "<Msg3>"
    Examples:
      | Email          | FirstName | LastName | Password | JobTitle     | ZipCode   | Resume  | Phone | DesiredJobTitle | JobType  | SalMin | SalMax | SalMin1 | SalMax1       | SalMin2       | SalMax2 | SalMin3 | SalMax3       | Msg                                                                        | Msg1                              | Msg2                           | Msg3                           |
      | test@gmail.com | Bob       | Russel   | 123456   | Test Analyst | 50001, IA | Test cv | 0123  | Test Analyst    | Contract | 30,000 | 20,000 | 0       | Please select | Please select | 70,000  | 50,000  | Please select | Oops that salary range is invalid. We've adjusted it to 20k - 30k for you. | Please enter a valid phone number | Please select a desired salary | Please select a desired salary |

  @nonUSCandidateRegistration
  Scenario Outline: Register as a non-US candidate and verify the display of cannot apply job banner
    Given I navigate to page "Candidate Registration For Country Code GB"
    And   I should see text "You appear to be registering from the UK"
    And   I should see text "To register with Resume-Library, you must have:"
    And   I should see text "Authorization to work in the U.S."
    And   I should see text "A valid U.S. address"
    And   I should see text "If you would like to search for jobs in the UK, please use our UK site:"
    And   I should see text "Continue to CV-Library"
    Then  I click on register popup close btn
    When  I enter email address "<Email>"
    And   I enter first name "<FirstName>"
    And   I enter last name "<LastName>"
    And   I enter password "<Password>"
    And   I enter latest job title "<JobTitle>"
    And   I select country from dropdown "<Country>"
    And   I enter home town "<City>"
    And   I enter zip code "<ZipCode>"
    And   I upload resume "<Resume>"
    And   I click on register button
    Then  I should be on page "Candidate Registration Confirm"
    When  I enter phone number "<Phone>"
    And   I enter desired job title "<DesiredJobTitle>"
    And   I click on complete button
    Then  I should be on page "Candidate My Dashboard"
    And   I should see text "My Dashboard"
    And   I should see text p tag "Thanks for registering with " and verify message "Thanks for registering with Resume-Library!"
    And   I should see text p tag "Unfortunately, you won't be able to apply for US jobs because you don't have a permanent US address." and verify message "Unfortunately, you won't be able to apply for US jobs because you don't have a permanent US address. What does this mean?"
    When  I navigate to page "Jobs"
    And   I should see text p tag "Unfortunately, you can't apply for jobs on this page as you don't have a permanent US address. " and verify message "Unfortunately, you can't apply for jobs on this page as you don't have a permanent US address. What does this mean?"
    And   I should not see text "Apply now"
    When  I follow link containing text "More"
    And   I switch to window 1
    Then  I should see text p tag "Unfortunately, you can't apply for this job because you don't have a permanent US address. " and verify message "Unfortunately, you can't apply for this job because you don't have a permanent US address. What does this mean?"
    Examples:
      | Email          | FirstName | LastName | Password | Resume  | JobTitle     | Country  | City    | ZipCode | Phone        | DesiredJobTitle |
      | test@gmail.com | Bob       | Russel   | 123456   | Test Cv | Test Analyst | Thailand | Lampang | 52160   | 012345678912 | QA Analyst      |