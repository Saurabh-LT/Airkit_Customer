package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Login extends Utility {
    
    @And("I fill in Email address")
    public void iFillInEmailAddress() {
        new LoginPage().fillInEmailAddress();
    }

    @And("I fill in Password")
    public void iFillInPassword() {
        new LoginPage().fillInPassword();
    }

    @And("I click Login as Jobseeker button")
    public void iClickLoginAsJobseekerButton() {
        new LoginPage().clickLoginAsJobSeekerButton();
    }

    @And("I click Forgot password?")
    public void iClickForgotPassword() {
        new LoginPage().clickForgotPassword();
    }

    @When("I fill in Email address to reset password")
    public void iFillInEmailAddressToResetPassword() {
        new LoginPage().fillInEmailAddressToResetPassword();
    }

    @And("I click Reset Password button")
    public void iClickResetPasswordButton() {
        new LoginPage().clickResetPasswordButton();
    }

    @And("I fill in invalid Password")
    public void iFillInInvalidPassword() {
        new LoginPage().fillInInvalidPassword();
    }

    @And("I click on Login now button")
    public void iClickOnLoginNowButton() {
        new LoginPage().clickOnLoginNowButton();
    }

    @And("I click on recruiter login icon")
    public void iClickOnRecruiterLoginIcon() {
        new LoginPage().clickOnRecruiterLoginIcon();
    }

    @And("I should see login as employer button")
    public void iShouldSeeLoginAsEmployerButton() {
        new LoginPage().loginAsEmployerButtonIsDisplay();
    }

    @And("I press login and review my resume button")
    public void iPressLoginAndReviewMyResumeButton() {
        new LoginPage().clickOnLoginAndReviewMyResume();
    }

    @And("I enters Changed password as {string}")
    public void iEntersChangedPasswordAs(String passWord) {
        new LoginPage().entersChangedPasswordAs(passWord);
    }
}