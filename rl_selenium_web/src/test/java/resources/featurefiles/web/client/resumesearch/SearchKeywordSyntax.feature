# Test scenarios
  #1. Run basic search then run Search Builder then Basic search again
  # these tests record the sometimes unexpected outcomes when
  # using multiple words  AND OR NOT COMMA parenthesis or brackets
  # the outcomes are under review by the search team and the tests
  # will need amending if the current outcomes are considered bugs

@ResumeSearchKeywordSyntax @Regression @Web  @Search
Feature: Client ResumeSearch Keyword Syntax

  Background: On resume search page
    Given I login as a client
    When  I navigate to page "Client Resume Search"
    And   I reload the page
    And   I click on Basic

 @resumeSearchBasicAndBuilderKeywordsUsingNoQuotes @ReleaseRegression2
 Scenario: Resume basic search and builder with keywords using no quotes
    And   I navigate to page "Client Resume Search With Keywords Using No Quotes"
    And   I click on Builder
    And   I should see value "\"strange test\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "\"strange test\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingDoubleQuotes
 Scenario: Resume basic search and builder with keywords using double quotes
    And   I navigate to page "Client Resume Search With Keywords Using Double Quotes"
    And   I click on Builder
    And   I should see value "\"strange test\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "\"strange test\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordUsingNoQuotes
 Scenario: Resume basic search and builder with keyword using no quotes
    And   I navigate to page "Client Resume Search With Keyword Using No Quotes"
    And   I click on Builder
    And   I should see value "strange " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "strange" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordUsingDoubleQuotes @ReleaseRegression2
 Scenario: Resume basic search and builder with keyword using Double quotes
    And   I navigate to page "Client Resume Search With Keyword Using Double Quotes"
    And   I click on Builder
    And   I should see value "\"strange\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "\"strange\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingAndVariants
 Scenario: Resume basic search and builder with keywords using and variants
    And   I navigate to page "Client Resume Search With Keywords Using And"
    And   I click on Builder
    And   I should see value "strange AND test " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "strange AND test" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingAmpersand
 Scenario: Resume basic search and builder with keywords using ampersand
    And   I navigate to page "Client Resume Search With Keywords Using Ampersand"
    And   I click on Builder
    And   I should see value "\"strange & test\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "\"strange & test\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingDoubleAmpersand
 Scenario: Resume basic search and builder with keywords using double ampersand
    And   I navigate to page "Client Resume Search With Keywords Using Double Ampersand"
    And   I click on Builder
    And   I should see value "\"strange && test\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "\"strange && test\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingSpacedDot
 Scenario: Resume basic search and builder with keywords using spaced dot
    And   I navigate to page "Client Resume Search With Keywords Using Spaced Dot"
    And   I click on Builder
    And   I should see value "\"strange . test\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "\"strange . test\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingUnspacedDot
 Scenario: Resume basic search and builder with keywords using unspaced dot
    And   I navigate to page "Client Resume Search With Keywords Using Unspaced Dot"
    And   I click on Builder
    And   I should see value "\"strange.test\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "\"strange.test\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingPlus
 Scenario: Resume basic search and builder with keywords using Plus
    And   I navigate to page "Client Resume Search With Keywords Using Plus"
    And   I click on Builder
    And   I should see value "\"strange+test\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "\"strange+test\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordUsingSingleQuotes @ReleaseRegression2
 Scenario: Resume basic search and builder with keyword using single quotes
    And   I navigate to page "Client Resume Search With Keyword Using Single Quotes"
    And   I click on Builder
    And   I should see value "\"test\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "\"test\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingSingleQuotes
 Scenario: Resume basic search and builder with keywords using single quotes
    And   I navigate to page "Client Resume Search With Keywords Using Single Quotes"
    And   I click on Builder
    And   I should see value "\"strange test\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "\"strange test\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordUsingSmartQuotes
 Scenario: Resume basic search and builder with keyword using smart quotes
    And   I navigate to page "Client Resume Search With Keyword Using Smart Quotes"
    And   I click on Builder
    And   I should see value "\"“test”\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "\"“test”\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingSmartQuotes
 Scenario: Resume basic search and builder with keywords using smart quotes
    And   I navigate to page "Client Resume Search With Keywords Using Smart Quotes"
    And   I click on Builder
    And   I should see value "\"“strange test”\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "\"“strange test”\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordUsingUnpairedInitialQuotes
 Scenario: Resume basic search and builder with keyword using unpaired initial quotes
    And   I navigate to page "Client Resume Search With Keyword Using Unpaired Initial Quotes"
    And   I click on Builder
    And   I should see value "\"test\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "\"test\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingUnpairedInitialQuotes
 Scenario: Resume basic search and builder with keywords using unpaired initial quotes
    And   I navigate to page "Client Resume Search With Keywords Using Unpaired Initial Quotes"
    And   I click on Builder
    And   I should see value "\"strange test\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "\"strange test\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordUsingUnpairedTerminalQuotes @ReleaseRegression2
 Scenario: Resume basic search and builder with keyword using unpaired terminal quotes
    And   I navigate to page "Client Resume Search With Keyword Using Unpaired Terminal Quotes"
    And   I click on Builder
    And   I should see value "\"test\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "\"test\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingUnpairedTerminalQuotes
 Scenario: Resume basic search and builder with keywords using unpaired terminal quotes
    And   I navigate to page "Client Resume Search With Keywords Using Unpaired Terminal Quotes"
    And   I click on Builder
    And   I should see value "\"strange test\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "\"strange test\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingOr
 Scenario: Resume basic search and builder with keywords using or
    And   I navigate to page "Client Resume Search With Keywords Using Or"
    And   I click on Builder
    And   I should see value "strange OR test " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "strange OR test" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingComma
 Scenario: Resume basic search and builder with keywords using comma
    And   I navigate to page "Client Resume Search With Keywords Using Comma"
    And   I click on Builder
    And   I should see value "strange OR test " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "strange OR test" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingVerticalBar
 Scenario: Resume basic search and builder with keywords using vertical bar
    And   I navigate to page "Client Resume Search With Keywords Using Vertical Bar"
    And   I click on Builder
    And   I should see value "\"strange | test\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "\"strange | test\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingNot
 Scenario: Resume basic search and builder with keywords using not
    And   I navigate to page "Client Resume Search With Keywords Using Not"
    And   I click on Builder
    And   I should see value "strange NOT test " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "strange NOT test" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingGreaterThanLessThan
 Scenario: Resume basic search and builder with keywords using <>
    And   I navigate to page "Client Resume Search With Keywords Using Gt Lt"
    And   I click on Builder
    And   I should see value "\"strange <> test\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "\"strange &lt;> test\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingNotEqual
 Scenario: Resume basic search and builder with keywords using not equal
    And   I navigate to page "Client Resume Search With Keywords Using Not Equal"
    And   I click on Builder
    And   I should see value "\"strange != test\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "\"strange != test\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingParenthesisFirst
 Scenario: Resume basic search and builder with keywords using parenthesis First
    And   I navigate to page "Client Resume Search With Keywords Using Parenthesis First"
    And   I click on Builder
    And   I should see value "( testers AND sales ) OR recruit " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "( testers AND sales ) OR recruit" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingParenthesisLast
 Scenario: Resume basic search and builder with keywords using parenthesis Last
    And   I navigate to page "Client Resume Search With Keywords Using Parenthesis Last"
    And   I click on Builder
    And   I should see value "testers AND ( sales OR recruit ) " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "testers AND ( sales OR recruit )" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingParenthesisTwice @ReleaseRegression2
 Scenario: Resume basic search and builder with keywords using parenthesis Twice
    And   I navigate to page "Client Resume Search With Keywords Using Parenthesis Twice"
    And   I click on Builder
    And   I should see value "( testers OR something ) AND ( sales AND recruit ) " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "( testers OR something ) AND ( sales AND recruit )" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingSquareBrackets
 Scenario: Resume basic search and builder with keywords using square brackets
    And   I navigate to page "Client Resume Search With Keywords Using Square Brackets"
    And   I click on Builder
    And   I should see value "( testers AND \"[sales\" ) OR \"recruit]\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "( testers AND \"[sales\" ) OR \"recruit]\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordsUsingCurlyBrackets
 Scenario: Resume basic search and builder with keywords using curly brackets
    And   I navigate to page "Client Resume Search With Keywords Using Curly Brackets"
    And   I click on Builder
    And   I should see value "( testers AND \"{ sales\" ) OR \"recruit }\" " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "( testers AND \"{ sales\" ) OR \"recruit }\"" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordUsingUpperCase
 Scenario: Resume basic search and builder with keyword using upper case
    And   I navigate to page "Client Resume Search With Keyword Using Upper Case"
    And   I click on Builder
    And   I should see value "TEST " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "TEST" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordUsingLowerCase
 Scenario: Resume basic search and builder with keyword using lower case
    And   I navigate to page "Client Resume Search With Keyword Using Lower Case"
    And   I click on Builder
    And   I should see value "test " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "test" in basic keywords field

 @resumeSearchBasicAndBuilderKeywordUsingMixedCase
 Scenario: Resume basic search and builder with keyword using mixed case
    And   I navigate to page "Client Resume Search With Keyword Using Mixed Case"
    And   I click on Builder
    And   I should see value "tEsT " in search builder keywords
    And   I click on Search Resumes
    And   I click on Basic
    And   I should see "tEsT" in basic keywords field