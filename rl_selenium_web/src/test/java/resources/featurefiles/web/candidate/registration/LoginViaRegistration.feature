  @LoginViaRegistration @Regression @Web  @Traffic
  Feature: Candidate Registration LoginViaRegistration

    @registerApplyLogin
    Scenario: Login as an existing candidate via Register and Apply
      Given  I navigate to page "Jobs Non External Test Jobs"
      And   I click on non external job to apply
      And   I click Register & apply button
      Then  I should see "Upload Resume & Apply" on the page
      And   I fill in email address with "testers+candidate@resume-library.com"
      And   I fill in password with "rl"
      Then  I should see text "This email already exists, please login"
      And   I fill in password with "rltest01"
      And   I click Login & apply button
      Then  I should see text p tag replace all "Resume-Library, you're applying for:"
      And   I should be able to see in browser URL "Job Apply"