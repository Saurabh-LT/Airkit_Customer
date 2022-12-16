package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.LoginViaRegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LoginViaRegistration extends Utility {

    @Then("I click Register & apply button")
    public void iClickRegisterApplyButton() {
        new LoginViaRegistrationPage().clickOnRegisterApply();
    }

    @And("I fill in email address with {string}")
    public void iFillInEmailAddressWith(String email) {
        new LoginViaRegistrationPage().enterEmail(email);
    }

    @And("I fill in password with {string}")
    public void iFillInPasswordWith(String password) {
        new LoginViaRegistrationPage().enterPassword(password);
    }

    @And("I click Login & apply button")
    public void iClickLoginApplyButton() {
        new LoginViaRegistrationPage().clickLoginApply();
    }

    @And("I click on Login as Jobseeker>")
    public void iClickOnLoginAsJobseeker() {
        new LoginViaRegistrationPage().clickLoginApply();
    }
}