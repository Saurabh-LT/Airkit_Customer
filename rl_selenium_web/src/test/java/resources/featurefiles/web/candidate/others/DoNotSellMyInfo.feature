@DoNotSellMyInfo @Regression @Web  @ReleaseRegression1 @Candidate
Feature: Candidate Others DoNotSellMyInfo

   Scenario: Validate the Logged Out Do Not Sell My Info form and submit
   Given    I am on home page
   When     I click "Do Not Sell My Info" in the footer
   Then     I should see text "Worried about your personal information on Resume-Library?"
   When     I click Send Request button
   Then     I should see text "Name is required"
   And      I should see text "Email address is required"
   And      I should see text "Request is required"
   And      I should see text "Message is required"
   When     I reload the page
   And      I fill in Email address with "e"
   Then     I should see text "Please enter a valid email address"
   When     I reload the page
   Then     I fill in "email" with random candidate email
   And      I fill in Name
   And      I fill in Message
   And      I select the option "Send me my personal information" from Request
   When     I click Send Request button
   Then     I should see text "Thanks for getting in touch. A member of our team will get back to you shortly."