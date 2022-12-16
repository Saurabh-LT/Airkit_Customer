package com.resumelibrary.cucumber.stepdefinitions.web.client;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.client.ResourcesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Resources extends Utility {

    @When("I click on search our candidate database link")
    public void iClickOnSearchOurCandidateDatabaseLink() {
        new ResourcesPage().clickOnSearchOurCandidateTodayLink();
    }

    @And("I should contact us email link")
    public void iShouldContactUsEmailLink() {
        Assert.assertTrue(new ResourcesPage().ContactUsEmailAddressLinkIsDisplay(),"[---> contact us email link is not displayed <---]");
    }

    @When("I click on contact form btn")
    public void iClickOnContactFormBtn() {
        new ResourcesPage().clickOnContactFormBtn();
    }

    @When("I click on help center btn")
    public void iClickOnHelpCenterBtn() {
        new ResourcesPage().clickOnHelpCenterBtn();
    }

    @When("I click on client contact us btn")
    public void iClickOnClientContactUsBtn() {
        new ResourcesPage().clickOnClientContactUsBtn();
    }

    @When("I mouse hover to link {string}")
    public void iMouseHoverToLink(String text) {
        new ResourcesPage().mouseHoverHyperLink(text);
    }

    @Then("I click on authentication required popup close btn")
    public void iClickOnAuthenticationRequiredPopupCloseBtn() {
        new ResourcesPage().clickOnAuthenticationRequiredPopupCloseBtn();
    }

    @Then("I click on resume search builder popup close btn")
    public void iClickOnResumeSearchBuilderPopupCloseBtn() {
        new ResourcesPage().clickOnResumeSearchBuilderPopupCloseBtn();
    }

    @And("I should not see shopping cart link")
    public void iShouldNotSeeShoppingCartLink() {
        new ResourcesPage().shouldNotSeeShoppingCartLink();
    }

    @Then("I click on client help popup close btn")
    public void iClickOnClientHelpPopupCloseBtn() {
        new ResourcesPage().clientHelpPopupCloseBtn();

    }

    @When("I click on link {string} in {string} footer")
    public void iClickOnLinkINFooter(String link, String footer) {
        new ResourcesPage().clickOnLinkInFooter(link,footer);
    }

    @Then("I click on resume search builder popup")
    public void iClickOnResumeSearchBuilderPopup() {
        new ResourcesPage().clickOnResumeSearchBuilderPopup();

    }

    @Then("I should see transparent-button envelope is displayed")
    public void iShouldSeeTransparentButtonEnvelopeIsDisplayed() {
        Assert.assertTrue(new ResourcesPage().ChatWindowIsDisplayed(),"[---> transparent button envelope is not displayed <---]");
    }

    @When("I click on the envelope")
    public void iClickOnTheEnvelope() {
        new ResourcesPage().clickOnEnevolope();
    }

    @Then("I should see {string} popup displayed")
    public void iShouldSeePopupDisplayed(String text) {
        Assert.assertTrue(new ResourcesPage().contctUspopupDisplayed(text),"[---> " + text + " is not displayed <---]");
    }
}
