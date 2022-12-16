@CoverLetter @Regression @Web  @Candidate
Feature: Candidate CoverLetter CoverLetter

  @verifyCoverLetterPage
  Scenario: Verify some elements
    Given  I login as a candidate
    When   I navigate to page "Candidate Cover Letter"
    Then   I should see text H one tag "Modify Cover Letter"
    Then   I should see text "Edit your Cover Letter"
    And    I should see text "Tips to write the perfect Cover Letter…"
    Then   I click on edit profile link
    And    I should be on page "Candidate My Profile"
    Then   I click on my cover letters link
    Then   I click on job alert link
    And    I should be on page "Candidate Job Alerts"
    Then   I click on my cover letters link
    Then   I click on application link
    And    I should be on page "Candidate MyApplications"
    Then   I click on my cover letters link
    Then   I click on saved job link
    And    I should be on page "Candidate Saved Jobs"
    Then   I click on my cover letters link
    Then   I click on edit profile link
    And    I should be on page "Candidate My Profile"

  @updateCoverLetter @ReleaseRegression1
  Scenario: Update cover letter and verify success message
    Given  I login as a candidate
    When   I navigate to page "Candidate Cover Letter"
    When   I enter "test cover letter" to edit your cover letter
    Then   I click on reset button
    And    I should see text "Edit your Cover Letter"
    When   I enter "test cover letter" to edit your cover letter
    Then   I click on save changes button
    And    I should see text "Cover letter saved successfully"

  @jobApplyAddCoverLetter @ReleaseRegression1
  Scenario: Add cover letter when applying for email type job
    Given  I navigate to page "Candidate Registration"
    And    I register as a new candidate resume check
    When   I navigate to page "Jobs Non External Test Jobs"
    And    I click on non external job to apply
    And    I switch tab
    Then   I should be able to see in browser URL "Job Apply"
    And    I should see text "Your cover letter"
    And    I click add-cover-letter-toggle
    And    I should see text "Your cover letter"
    And    I click "View Cover Letter tips" button
    And    I should see text "Keep it short (we advise 250-400 words)"
    Then   I enter "test cover letter - update on job application" to edit your cover letter
    And    I enter phone number "012345678"
    And    I click on send application button
    And    I should see text H one tag "Application sent - the employer will be in touch if you are successful"
    When   I navigate to page "Candidate Myapplications"
    And    I click on View button
    Then   I should be able to see in browser URL "Candidate Myapplications Viewapplication"
    And    I should see "Your Cover Letter"
    And    I should see "test cover letter - update on job application"