package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.JobApplyPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class JobApply extends Utility {

    @And("I fill in title with {string}")
    public void iFillInWith(String title) {
        new JobApplyPage().enterJobTitle(title);
    }

    @When("I fill job apply email with {string} on job apply")
    public void iFillJobApplyEmailWithOnJobApply(String email) {
        new JobApplyPage().enterEmail(email);
        new JobApplyPage().clickOnFirstName();
    }

    @And("I fill job apply first name with {string} on job apply")
    public void iFillJobApplyFirstNameWithOnJobApply(String firstName) {
        new JobApplyPage().enterFirstName(firstName);
    }

    @When("I fill job apply password with {string} on job apply")
    public void iFillJobApplyPasswordWithOnJobApply(String password) {
        new JobApplyPage().enterPassword(password);
    }

    @And("I fill in Question 1  with {string}")
    public void iFillInQuestion1With(String question) {
        new JobApplyPage().enterQuestion1(question);
    }

    @And("I fill in Answer 1 with {string}")
    public void iFillInAnswer1With(String answer1) {
        new JobApplyPage().enterAnswer1(answer1);
    }

    @And("I fill in Answer 2 with {string}")
    public void iFillInAnswer2With(String answer2) {
        new JobApplyPage().enterAnswer2(answer2);
    }

    @And("I click on Desirable Answer 1")
    public void iClickOnDesirableAnswer1() {
        new JobApplyPage().clickOnDesirableAnswer1();
    }

    @And("I select the option {string} from vacancy specific questions")
    public void iSelectTheOptionFromVacancySpecificQuestions(String answer) {
        new JobApplyPage().selectVacancySpecificQuestion(answer);
    }

    @And("I should see one click apply text {string}")
    public void iShouldSeeTextC1lickApply(String text) {
        new JobApplyPage().verifyOneClickApplyText(text);
    }
}