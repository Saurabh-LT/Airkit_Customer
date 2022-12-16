package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.LogoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class Logout extends Utility {

    @And("^I click Logout$")
    public void iClickLogout() {
        new LogoutPage().clickLogout();
    }

    @When("I mouse hover {string}")
    public void iMouseHover(String element) {
        new LogoutPage().mouseHover(element);
    }

    @When("I click {string} button")
    public void iClickButton(String element) {
        new LogoutPage().clickViewAllJobMatches(element);
    }
}