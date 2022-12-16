package com.resumelibrary.cucumber.stepdefinitions.web.client;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.client.ClientPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Client extends Utility {

    @Then("I select the option {string} from inquiry type")
    public void iSelectTheOptionStringFromInquiryType(String inquiryType) {
        new ClientPage().selectInquiryType(inquiryType);
    }

    @Then("I fill in inquiry messages text area with {string}")
    public void iFillInInquiryMessagesInTheTextArea(String message) {
        new ClientPage().enterMessage(message);
    }

    @Then("I click on Submit inquiry")
    public void iClickOnSubmitInquiry() {
        new ClientPage().clickOnSubmitInquiry();
    }

    @And("I enter client company name {string}")
    public void iEnterClientCompanyName(String companyName) {
        new ClientPage().enterCompanyName(companyName);
    }

    @When("I am on page {string} and I should see browser URL {string}")
    public void iAmOnPageAndIShouldSeeBrowserURL(String url1, String url2) {
        new ClientPage().verifyUrls(url1, url2);
    }

    @And("I click on post a job button")
    public void iClickOnPostAJobButton() {
        new ClientPage().clickOnPostAJob();
    }

    @Then("I should see image is displayed")
    public void iShouldSeeImageIsDisplayed() {
        new ClientPage().isImageDisplayed();
    }
}