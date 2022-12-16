package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.ContactPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Contact extends Utility {

    @And("I select faq type {string} from dropdown")
    public void iSelectFaqTypeFromDropdown(String text) {
        new ContactPage().selectFaqSearchTypeFromDropdown(text);
    }

    @Then("I enter faq query to search field {string}")
    public void iEnterFaqQueryToSearchField(String input) {
        new ContactPage().EnterFaqSearchInInputField(input);
    }

    @Then("I should see to march with question {string}")
    public void iShouldSeeToMarchWithQuestion(String text) {
        new ContactPage().getTextFromElement(text);
    }

    @And("I enter confirm email address {string}")
    public void iEnterConfirmEmailAddress(String email) {
        new ContactPage().enterConfirmEmail(email);
    }

    @And("I enter name {string}")
    public void iEnterName(String name) {
        new ContactPage().enterName(name);
    }

    @And("I enter message {string}")
    public void iEnterMessage(String message) {
        new ContactPage().enterMessage(message);
    }

    @And("I click on contact page {string} links")
    public void iClickOnContactPageLinks(String links) {
        new ContactPage().ContactPageLinks(links);
    }

    @And("I should see message {string} in contact xpath")
    public void iShouldSeeMessageInTheXpath(String text) {
        new ContactPage().shouldSeeMessageInContactXpath(text);
    }
}