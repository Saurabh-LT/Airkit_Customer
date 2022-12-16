@NoEcomValidatedClientProductsPurchase @Regression @Web  @Recruiters
Feature: Client Ecommerce ValidatedEmailVerifiedClientProducts

  Background:
    Given I navigate to page "Client Registration"
    And   I enter first name "automation"
    And   I enter last name "client"
    And   I enter password "123456"
    And   I enter client company name "resume-library"
    And   I enter phone number "012345678912"
    And   I click on enter address manually link
    And   I enter address one "1st street"
    And   I enter city "Boston"
    And   I enter state "Massachusetts"
    And   I enter zip code "02108"
    And   I select "Staffing Agency" from recruiter type
    When  I enter client email address "registration@resume-library.com"
    And   I click on Submit inquiry
    Then  I should be on page "Client Account"
    And   I should see text "Popular Products"
    And   I login as an admin user
    When  I search for "registration@resume-library.com" in the navigation bar on admin
    And   I scroll up 0,600
    And   I click on product details Edit button
    Then  I click on actions btn
    And   I should see element with text "Validate account" to be "visible"
    And   I click on link text "Validate account"
    And   I confirm browser popup
    Then  I click on actions btn
    And   I click on link text "Fixed users"
    Then  I click on "Edit" button to activate user in admin page
    Then  I select the option "yes" from dropdown with id "email_confirmed"
    Then  I click on button "Update User" in admin page
    And   I should see element with text "User Information" to be "visible"

  @ValidatedEmailVerifiedPurchaseProducts30Days @ReleaseRegression2
  Scenario: as an validated verified email account with ecommerce enabled client can purchase products 30 days
    Given I navigate to page "Client Purchase"
    Then  I should see logo empty cart image
    And   I should see text "Your cart is empty"
    And   I navigate to page "Client Resume Search With Keywords"
    Then  I should be able to see in browser URL "Client Resume Search Results"
    And   I find a locked candidate and click on unlock resume
    And   I should see text H three tag "Unlock this Resume"
    And   I should see text "Single Unlock"
    And   I should see text "View the full resume"
    And   I should see text "Access the candidates' full contact details"
    And   I should see text "Unlimited resume searches and views"
    And   I should see text "Unlimited user licenses for your whole team"
    And   I click on "Buy Now"
    Then  the url should match "Client Purchase"
    And   I should see text "1 Resume Unlock"
    And   I should see text p tag replace all "Instantly reveal the candidate's contact details"
    And   I should see text "Product Price"
    And   I should see "Total"
    And   I should see text "$9.99"
    And   I should see text H two tag "Need more than one resume? We recommend:"
    And   I should see text p tag replace all "30-Day Resume Search"
    And   I should see text "Unlimited resume searches & views"
    And   I should see text "Unlimited users"
    And   I should see text "Only $279.00 per month"

  @ValidatedEmailVerifiedPurchaseProducts3Months @ReleaseRegression2
  Scenario: as an validated verified email account with ecommerce enabled client can purchase products 3 months
    And   I navigate to page "Client Resume Search With Keywords"
    And   I find a locked candidate and click on unlock resume
    And   I should see text H three tag "Unlock this Resume"
    And   I click on "Buy Now"
    And   I click Checkout button
    And   I should see element with text "Card Details" to be "visible"
    And   I fill in "valid" card number
    And   I fill in "valid" cvc
    And   I fill in expiry date
    When  I click Save this card checkbox
    Then  I click Pay Now button
    And   I should see text "Order Summary"
    Then  I switch to window 0
    Then  I am on admin page "/"
    When  I search for "registration@resume-library.com" in the navigation bar on admin
    Then  I click on id "actions-btn"
    And   I click on "Update product balances"
    And   I enter new balance "0" for contact credits
    Then  I click on "Update Balance"
    And   I am on page "/client/resume-search/results?keywords=sales+OR+php+OR+test&submt_btn=1&updated_on=2+years"
    And   I find a locked candidate and click on unlock resume
    And   I should see text H three tag "Unlock this Resume"
    And   I should see text "Single Unlock"
    And   I should see text "3 Month Access"
    And   I should see text "View the full resume"
    And   I should see text "Access the candidates' full contact details"
    And   I should see text "Unlimited resume searches and views"
    And   I should see text "Unlimited user licenses for your whole team"
    And   I should see text "$597.00"
    And   I should see text p tag "Only" and verify message "Only $597.00"
    When  I click on Buy Now 3 Month Access package
    Then  the url should match "Client Purchase"
    And   I should see text p tag "3-month Resume Search" and verify message "3-Month Resume Search"
    And   I should see text "$597.00"

  @ValidatedClientYetToPurchase
  Scenario: As a validated logged in client who has yet to make a purchase
    When  I navigate to page "Client Products Contact Credits"
    Then  I should see text "Starter Package"
    Then  I should see text "30-day Resume Search Package"
    Then  I should see "1 fully branded Job Posting"
    Then  I should see price "$348" for class "price"
    Then  I should see price "$428" for class "price-was"
    When  I click on "Buy online" in "Starter Package" module
    Then  I should be able to see in browser URL "Client Purchase"
    And   I should see "Job Postings"
    And   I should see text p tag "30-day Resume Search" and verify message "30-Day Resume Search"

  @ValidatedClientStarterDefaultPackage @ReleaseRegression2
  Scenario: As a validated logged in client who has yet to make a purchase default package
    When  I navigate to page "Client Products Contact Credits"
    When  I click on "Buy online" in "Starter Package" module
    Then  I should be able to see in browser URL "Client Purchase"
    And   I should see text p tag replace all "Job Postings"
    And   I should see text p tag "Use within" and verify message "Use within 12 months"
    And   I should see text p tag "job posting" and verify message "30-day job posting"
    And   I should see option "1" selected for product quantity
    And   I should see text "$149.00"
    And   I should see text "$79.00"
    And   I should see text "$70.00"
    And   I should see text "Remove"
    And   I should see text p tag "30-day Resume Search" and verify message "30-Day Resume Search"
    And   I should see text p tag "Resume Search & views" and verify message "Unlimited Resume Search & views"
    And   I should see text p tag "Resume Search & views" and verify message "Unlimited Resume Search & views"
    And   I should see text "New Customer Offer!*"
    And   I should see text p tag replace all "Savings:"
    And   I should see text "$80.00"
    And   I should see text p tag replace all "Total:"
    And   I should see text "$348.00"
    And   I should see text "*This package is available to new customers only and subject to Resume-Library's fair usage policy."
    And   I should see text "We take our data seriously and work hard to ensure that our candidate data is not misused. This package is restricted by our fair usage policy of 300 resume unlocks per month."
    When  I click on "Checkout"
    Then  I should see text H two tag "Order Summary"
    And   I should see text "Contact Credit"
    And   I should see text "1"
    And   I should see text "$269.00"
    And   I should see text "Job Posting"
    And   I should see text "1"
    And   I should see text "$79.00"
    And   I should see text "Order Total"
    And   I should see text "$348.00"
    And   I should see text "Pay Now"

  @ValidatedClientYetToPurchaseRemoveJobPostings
  Scenario: As a validated logged in client who has yet to make a purchase remove job postings
    When  I navigate to page "Client Products Contact Credits"
    And   I click on "Buy online" in "Starter Package" module
    Then  I should be able to see in browser URL "Client Purchase"
    And   I should see text "*This package is available to new customers only and subject to Resume-Library's fair usage policy."
    And   I should see text "We take our data seriously and work hard to ensure that our candidate data is not misused. This package is restricted by our fair usage policy of 300 resume unlocks per month."
    And   I should see "Job Postings"
    And   I should see text p tag "30-day Resume Search" and verify message "30-Day Resume Search"
    When  I click on "Remove" in "30-day Resume Search" your cart module
    Then  I should not see button "Remove" in "30-day Resume Search" your cart module
    When  I click on "Remove" in "Job Postings" your cart module
    And   I should see element with text "Your cart is empty" to be "visible"
    Then  I should not see button "Remove" in "Job Postings" your cart module

    #XT-1583
    When  I navigate to page "Client Products Contact Credits"
    And   I click on "Buy online" in "Starter Package" module
    Then  I should be able to see in browser URL "Client Purchase"
    Then  I select option "3" from job posting credit quantity
    And   I should see text "$447.00"
    And   I should see text "$198.00"
    And   I should see text "$249.00"
    And   I should see text p tag replace all "Savings:"
    And   I should see text "$259.00"
    And   I should see text p tag replace all "Total:"
    And   I should see text "$467.00"
    When  I click on "Checkout"
    Then  I should see text H two tag "Order Summary"
    And   I should see text "Contact Credit"
    And   I should see text "1"
    And   I should see text "$269.00"
    And   I should see text "Job Posting"
    And   I should see text "3"
    And   I should see text "$198.00"
    And   I should see text "Order Total"
    And   I should see text "$467.00"
    And   I should see text "Pay Now"

    When  I navigate to page "Client Products Contact Credits"
    And   I click on "Buy online" in "Starter Package" module
    Then  I should be able to see in browser URL "Client Purchase"
    Then  I select option "5" from job posting credit quantity
    And   I should see text "$299.00"
    And   I should see text "$446.00"
    And   I should see text "$269.00"
    And   I should see text p tag replace all "Savings:"
    And   I should see text "456.00"
    And   I should see text p tag replace all "Total:"
    And   I should see text "$568.00"
    When  I click on "Checkout"
    Then  I should see text H two tag "Order Summary"
    And   I should see text "Contact Credit"
    And   I should see text "1"
    And   I should see text "$269.00"
    And   I should see text "Job Posting"
    And   I should see text "5"
    And   I should see text "$299.00"
    And   I should see text "Order Total"
    And   I should see text "$568.00"
    And   I should see text "Pay Now"

    When  I navigate to page "Client Products Contact Credits"
    And   I click on "Buy online" in "Starter Package" module
    Then  I should be able to see in browser URL "Client Purchase"
    And   I should see text "*This package is available to new customers only and subject to Resume-Library's fair usage policy."
    And   I should see text "We take our data seriously and work hard to ensure that our candidate data is not misused. This package is restricted by our fair usage policy of 300 resume unlocks per month."
    Then  I select option "None" from job posting credit quantity
    And   I should see text H three tag "Your cart is empty"

  @EcommValidatedLoggedInEmailVerifiedBanner
  Scenario: As a logged in validated user on the ecommerce journey, who has not made a purchase, I see the 3-month Resume Search banners and see starter package prices.
    When  I navigate to page "Resources"
    And   I scroll down 0,600
    And   I should see resources-3-month-banner "3-month Resume Search"
    Then  I click on resources-3-month-banner "3-month Resume Search"
    Then  I should be able to see in browser URL "Client Products Contact Credits"
    And   I should see text H two tag "30-day Resume Search"
    And   I should see text H two tag "Starter Package"

    And   I click on "Buy online"
    And   I click Checkout button
    And   I should see element with text "Card Details" to be "visible"
    And   I fill in "valid" card number
    And   I fill in "valid" cvc
    And   I fill in expiry date
    When  I click Save this card checkbox
    Then  I click Pay Now button
    And   I should see text "Order Summary"

    Then  I navigate to page "Resources"
    And   I scroll down 0,600
    And   I should see resources-3-month-banner "3-month Resume Search"
    Then  I click on resources-3-month-banner "3-month Resume Search"
    Then  I should be able to see in browser URL "Client Products Contact Credits"
    And   I should see text H two tag "Greater Hiring Needs?"

  @ValidatedClientYetToPurchaseRemove30daysResumeSearch
  Scenario: As a validated logged in client who has yet to make a purchase remove 30 days resume search
    When  I navigate to page "Client Products Contact Credits"
    And   I click on "Buy online" in "Starter Package" module
    When  I click on "Remove" in "30-day Resume Search" your cart module
#    And   I should not see "*This package is available to new customers only and subject to Resume-Library's fair usage policy."
#    And   I should not see "We take our data seriously and work hard to ensure that our candidate data is not misused. This package is restricted by our fair usage policy of 300 resume unlocks per month."
    And   I should see text p tag replace all "Savings:"
    And   I should see text "$70.00"
    And   I should see text p tag replace all "Savings:"
    And   I should see text "$79.00"
    When  I click on "Checkout"
    Then  I should see text H two tag "Order Summary"
    And   I should see text "$79.00"
    And   I should see text "Job Posting"
    And   I should see text "$79.00"
    And   I should see text "Order Total"
    And   I should see text "$79.00"
    And   I should see text "Pay Now"