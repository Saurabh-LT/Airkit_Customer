# Tests coverage
    # 1. Purchasing Job posting credits with payments (test card)
    # 2. Purchasing Contact credits with payments (test card)
    # 3. Verify invoice generated in Purchase History page
    # 4. Testing decline transaction by invalid cvc
    # 5. Saving and deleting card details

@PurchaseProducts @Regression @Web  @Recruiters
Feature: Client Products PurchaseProducts

  Background: Login as a client
    Given   I login as a client

  @purchaseJobPostingCredits @ReleaseRegression2
  Scenario: Purchase Job posting credits
    When    I navigate to page "Client Products Jobs"
    And     I click Buy online button
    Then    I should be on page "Client Purchase"
    And     I click Checkout button
    And     I should see text "Card Details" if not then delete saved card
    Then    the url should match "Client Purchase Pay Now"
    And     I fill in town city field
    And     I fill in "valid" card number
    And     I fill in "valid" cvc
    And     I fill in expiry date
    When    I click Save this card checkbox
    Then    I click Pay Now button
    And     I should see element with text "Order Confirmation" to be "visible"
    And     the url should match "Client Purchase Auth"
    And     I should not see text "Payment Declined"
    And     I should see text "Order Confirmation"
    And     I should see text "Order Summary"
    And     I should see text "Thank you for your purchase!"
    And     I should see text "You're ready to start hiring with Resume-Library."
    And     I should see text p tag "Before you can use your products we may need to validate your account." and verify message "Before you can use your products we may need to validate your account. One of our team will do this right away, or you can call us on 1-857-239-0143."

  @purchaseContactCredits @ReleaseRegression2
  Scenario: Purchase Contact credits
    When    I navigate to page "Client Products Contact Credits"
    And     I click Buy online button
    Then    I should be on page "Client Purchase"
    And     I click Checkout button
    And     I should see text "Card Details" if not then delete saved card
    Then    the url should match "Client Purchase Pay Now"
    And     I fill in town city field
    And     I fill in "valid" card number
    And     I fill in "valid" cvc
    And     I fill in expiry date
    When    I click Save this card checkbox
    Then    I click Pay Now button
    And     I should see element with text "Order Confirmation" to be "visible"
    And     the url should match "Client Purchase Auth"
    And     I should not see text "Payment Declined"
    And     I should see text "Order Confirmation"
    And     I should see text "Order Summary"
    And     I should see text "Thank you for your purchase!"
    And     I should see text "You're ready to start hiring with Resume-Library."
    And     I should see text p tag "Before you can use your products we may need to validate your account." and verify message "Before you can use your products we may need to validate your account. One of our team will do this right away, or you can call us on 1-857-239-0143."

  @declineTransaction @ReleaseRegression2
  Scenario: Verify decline transaction
    When    I navigate to page "Client Products Jobs"
    And     I click Buy online button
    Then    I should be on page "Client Purchase"
    And     I click Checkout button
    And     I should see text "Card Details" if not then delete saved card
    Then    the url should match "Client Purchase Pay Now"
    And     I fill in town city field
    And     I fill in "invalid" card number
    And     I fill in "invalid" cvc
    And     I fill in expiry date
    When    I click Save this card checkbox
    Then    I click Pay Now button
    And     I should see element with text "Payment Declined" to be "visible"
    And     the url should match "Client Purchase Auth"
    And     I should see text "Payment Declined"
    And     I should see text "We're sorry, this payment has been declined."
    And     I should see either of the text "Your request has failed the CVC check. Please note that the amount may still have been reserved on the card, in which case it will be released in" or "There was a problem with your CVC, please try again, or call for additional help."
    And     I should see text p tag "You have not been charged for this transaction." and verify message "You have not been charged for this transaction. Please return to payment and try again. If you need any help, please call us on 1-800-672-6706."
    When    I click Retry Payment button
    And     the url should match "Client Purchase Pay Now"
    And     I should see text "Card Details"
    And     I should see text "Secure payments guaranteed by Paysafe"
    And     I should see text "Order Summary"

  @saveAndDeleteCard @ReleaseRegression2
  Scenario: Save valid card and delete the card details
    When    I navigate to page "Client Products Contact Credits"
    And     I click Buy online button
    Then    I should be on page "Client Purchase"
    And     I click Checkout button
    And     I should see text "Card Details" if not then delete saved card
    Then    the url should match "Client Purchase Pay Now"
    And     I fill in town city field
    And     I fill in "valid" card number
    And     I fill in "valid" cvc
    And     I fill in expiry date
    Then    I click Pay Now button
    And     I should see element with text "Order Confirmation" to be "visible"
    When    I go to page "Client Products Jobs"
    And     I click Buy online button
    Then    I should be on page "Client Purchase"
    And     I click Checkout button
    And     I should see element with text "Select a Card" to be "visible"
    Then    the url should match "Client Purchase Pay Now"
    And     I should see text "Select a Card"
    And     I should see text "Pay with a different card"
    When    I click delete saved card icon
    And     I should see element with text "Delete a card" to be "visible"
    When    I click delete card confirm button
    Then    I should see element with text "Card Details" to be "visible"

  @verifyPurchaseHistory
  Scenario: Verify Purchase History
    When    I mouse hover "Hi Resume library"
    And     I should see text "Purchase History"
    When    I click on "Purchase History"
    Then    I should be able to see in browser URL "Client Purchase History"
    Then    I should see text "Purchase History"
    And     I should see text p tag "Bank transfers and failed transactions will not be displayed" and verify message "Bank transfers and failed transactions will not be displayed. For more information or help with your purchase history please contact your Client Response Coordinator."
    And     I should see text "Date"
    And     I should see text "Invoice No"
    And     I should see text "Status"
    And     I should see text "Product"
    And     I should see text "Price"
    And     I should see text "Actions"
    When    I click View button to see invoice
    And     I switch tab
    Then    the url should match "Client Purchase History View"

  @PurchaseHistoryPagination
  Scenario:My Purchase History Page Pagination
    When  I go to page "Client Purchase History" and to get pagination purchase credits in the page "Client Products Contact Credits"
    And   I scroll down 0,2000
    Then  I click on "2"
    And   I should be on page "Client Purchase History 2"
    And   I should see "prev" link
    And   I scroll down 0,2000
    When  I click on "prev"
    Then  I should be on page "Client Purchase History"
    And   I should not see "prev" link

  @PurchaseProductsValidateCartCount
  Scenario: As a logged In user validating the Product menu headers and shopping cart count
    When   I navigate to page "Resources"
    Then   I should see text "Products"
    When   I mouse hover Products Navigation menu
    Then   I should see text "Contact Credits"
    Then   I should see text "Job Postings"
    And    I click on "Contact Credits"
    Then   I should be able to see in browser URL "Client Products Contact Credits"
    Then   I should see a Shopping Cart image
    When   I click on Shopping Cart Image
    Then   I should be able to see in browser URL "Client Purchase"
    And    I should see text "Your cart is empty" if Cart Is Empty otherwise Remove the Existing Products
    When   I navigate to page "Resources"
    Then   I mouse hover Products Navigation menu
    And    I click on "Contact Credits"
    Then   I should be able to see in browser URL "Client Products Contact Credits"
    When   I click Buy online button
    Then   I should be on page "Client Purchase"
    And    I should see “1” in the shopping cart
    Then   I mouse hover Products Navigation menu
    And    I click on "Job Postings"
    When   I click Buy online button
    Then   I should be on page "Client Purchase"
    And    I should see “2” in the shopping cart
    Then   I click on Remove link in Your cart page
    Then   I mouse hover Products Navigation menu
    And    I click on "Job Postings"
    And    I should see “1” in the shopping cart

  @PurchasedSortingByDateSaved @ReleaseRegression2
  Scenario: Sorting by Date Purchased
    And   I navigate to page "Client Purchase History"
    When  I click on dates purchased descending order
    Then  I should see purchased dates in desc order
    When  I click on dates purchased ascending order
    Then  I should see in purchased dates in asc order

  @PurchasedSortingByInvoiceNo
  Scenario: Sorting by Invoice number
    And   I navigate to page "Client Purchase History"
    When  I click on Invoice No descending order
    Then  I should see Invoice No in desc order
    When  I click on Invoice No ascending order
    Then  I should see Invoice No in asc order

  @sortingByProduct
  Scenario: Sorting by Product Name
    And   I navigate to page "Client Purchase History"
    When  I click on Product Name descending order
    Then  I should see in Product name in desc order
    When  I click on Product name ascending order
    Then  I should see in Product name in asc order

  @sortingByPurchasePrice
  Scenario: Sorting by Purchased Price
    And   I navigate to page "Client Purchase History"
    When  I click on Price descending order
    Then  I should see Purchase Price in desc order
    When  I click on Price ascending order
    Then  I should see in Purchase Price asc order