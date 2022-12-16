package com.resumelibrary.cucumber.stepdefinitions.web.misc;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.misc.MiscPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Misc extends Utility {
    public Misc()
    {
        PageFactory.initElements(getThreadDriver(),this);
    }
    @FindBy(id = "pass-reset-success-text")
    WebElement ResetPasswordSuccessMessage;

    @Given("I am on home page")
    public void iAmOnHomePage() {
        loadWebHomePage();
    }

    @Then("I reload the page")
    public void iReloadThePage() {
        reloadPage();
    }

    @And("I should see text {string}")
    public void iShouldSeeText(String textMessage) {
        Assert.assertTrue(new MiscPage().shouldSeeText(textMessage),"[---> " + textMessage + " is not displayed <---]");
    }

    @And("I should see a text message \"([^\"]*)\"$")
    public void iShouldSeeATextMessage(String textMessage) {
        Assert.assertTrue(verifyTextMessageUsingId(ResetPasswordSuccessMessage, textMessage), "[---> " + textMessage + " is not displayed <---]");
    }

    @When("I click {string} in the footer")
    public void iClickInTheFooter(String link) {
        new MiscPage().clickLinkInTheFooter(link);
    }

    @Then("I should be on {string} page")
    public void iShouldBeOnPage(String page) {
        new MiscPage().shouldBeOnThePage(page);
    }

    @When("I click {string} icon in the footer")
    public void iClickIconInTheFooter(String icon) {
        new MiscPage().clickIconInTheFooter(icon);
    }

    @Then("the response code should be {int}")
    public void theResponseCodeShouldBe(int responseCode) {
        new MiscPage().responseCodeShouldBe(responseCode);
    }

    @And("I should see text message \"([^\"]*)\"$")
    public void iShouldSeeTextMessage(String message) {
        Assert.assertEquals(message, verifyTextMessageReplaceAll("Welcome to Our"));
    }

    @And("I should see text message {string} and verify {string}")
    public void iShouldSeeTextMessageAndVerify(String message1, String message2) {
        Assert.assertEquals(message2, verifyTextMessageReplaceAll(message1));
    }

    @Then("I should see text {string} on the page")
    public void iShouldSeeTextOnThePage(String message) {
        Assert.assertTrue(verifyTextMessageOnThePage(message), "[---> " + message + " is not displayed <---]");
    }

    @And("I should see {string} on the page")
    public void iShouldSeeOnThePage(String text) {
        Assert.assertEquals(verifyTextMessageH1Tags(text), text);
    }

    @Then("I login as a candidate")
    public void iLoginAsACandidate() {
        new MiscPage().loginAsCandidate();
    }

    @Then("I login as a client")
    public void iLoginAsAClient() {
        new MiscPage().loginAsClient();
    }

    @And("I should see H two tag {string} and verify message {string}")
    public void iShouldSeeHTwoTagAndVerifyMessage(String text, String message) {
        Assert.assertEquals(verifyTextMessageH2Tags(text), message);
    }

    @Then("the url should match {string}")
    public void theUrlShouldMatch(String url) {
        webUrlVerify(url);
    }

    @And("I should not see {string} footer link")
    public void iShouldNotSeeFooterLink(String link) {
        new MiscPage().verifyFooterLinksIsDisplay(link);
    }

    @And("I click on I AGREE")
    public void iClickOnIAGREE() {
        new MiscPage().clickOnIAgreeBtn();
    }

    @And("I click on Accept All")
    public void iClickOnAcceptAll() {
        try {
            clickOnElementUsingText("Accept All");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @And("I should see either of the text {string} or {string}")
    public void iShouldSeeEitherOfTheTextOr(String text1, String text2) {
        Assert.assertTrue(verifyEitherTextMessage(text1, text2),"[---> " + text1 + " or " + text2 + " is not displayed <---]");
    }
    @Then("I should not see {string} link")
    public void iShouldNotSeeLink(String text) {
        Assert.assertFalse(isAnchorElementDisplayed(text),"[---> " + text + " is displayed <---]");
    }

    @Given("I login as testers client")
    public void iLoginAsTestersClient() {
        new MiscPage().loginAsTesterClient();
    }

    @And("I click on value {string}")
    public void iClickOnValue(String value) {
        clickOnAttributeValueOnInputTag(value);
    }

    @Then("I should see hyperlink {string}")
    public void iShouldSeeHyperlink(String text) {
        Assert.assertEquals(verifyTextMessageATags(text), text);
    }

    @And("I should not see {string} text")
    public void iShouldNotSeeText(String text) {
        Assert.assertFalse(isElementDisplay(text),"[---> " + text + "is displayed <---]");
    }

    @Then("I should see file in my download folder {string}")
    public void iShouldSeeFileInMyDownloadFolder(String folderName) {
        new MiscPage().createFolderAndDelete(folderName);
    }
}