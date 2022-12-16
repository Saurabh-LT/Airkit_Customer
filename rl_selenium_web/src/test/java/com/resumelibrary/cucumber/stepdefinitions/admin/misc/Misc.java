package com.resumelibrary.cucumber.stepdefinitions.admin.misc;

import com.resumelibrary.admintest.misc.MiscPage;
import com.resumelibrary.cucumber.stepdefinitions.web.candidate.Others;
import com.resumelibrary.utilities.AdminURLHelper;
import com.resumelibrary.utilities.Utility;
import com.resumelibrary.utilities.WebURLHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Misc extends Utility {
    public Misc() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(Misc.class);

    @Then("I should be on dashboard")
    public void iShouldBeOnDashboard() {
        new MiscPage().shouldBeOnDashBoard();
    }

    @Given("I login as an admin user")
    public void iLoginAsAnAdminUser() {
        new MiscPage().loginAsAdminUser();
    }

    @When("I go to add partner page")
    public void iGoToAddPartnerPage() {
        new MiscPage().goToAddPartnerPage();
    }

    @And("I click Add PartnerAlliance button")
    public void iClickAddPartnerAllianceButton() {
        new MiscPage().clickAddPartnerAllianceButton();
    }

    @And("I fill in {string}")
    public void iFillIn(String field) {
        new MiscPage().fillIn(field);
    }

    @And("I select the option {string} from {string} field")
    public void iSelectTheOptionFromField(String option, String field) {
        new MiscPage().selectOptionFromField(option, field);
    }

    @When("I go to add jobs page")
    public void iGoToAddJobsPage() {
        new MiscPage().goToAddJobsPage();
    }

    @When("I click Add Job button")
    public void iClickAddJobButton() {
        new MiscPage().clickAddJobButton();
    }

    @Then("I fill in Description in the text area")
    public void iFillInDescriptionInTheTextArea() {
        new MiscPage().fillInDescriptionInTheTextArea();
    }

    @When("I am on admin page {string}")
    public void iAmOnAdminPage(String url) {
        logger.info("Web page url to load is : " + AdminURLHelper.getAdminUrl() + getURL(url));
        getDriverWithUrl(AdminURLHelper.getAdminUrl(), getURL(url));
        webDriverWaitContainsUrl(getURL(url));
    }

    @And("I select {string} from spend credit dropdown")
    public void iSelectFromSpendCreditDropdown(String credit) {
        new MiscPage().selectSpendCreditFromDropDown(credit);
    }

    @And("I fill in expiry date with {string}")
    public void iFillInExpiryDateWith(String date) {
        new MiscPage().enterExpiryDate(date);
    }

    @And("I fill in posted with {string}")
    public void iFillInPostedWith(String date) {
        new MiscPage().enterPostedDate(date);
    }

    @And("I fill in premium until  with {string}")
    public void iFillInPremiumUntilWith(String date) {
        new MiscPage().enterPremiumUntil(date);
    }

    @And("I click on update job")
    public void iClickOnUpdateJob() {
        new MiscPage().clickOnUpdateJob();
    }

    @And("I fill in title name with {string}")
    public void iFillInTitleNameWith(String title) {
        new MiscPage().enterJobTitle(title);
    }

    @And("I select option {string} from contact")
    public void iSelectOptionFromContact(String contact) {
        new MiscPage().selectContact(contact);
    }

    @And("I select option {string} from sales person")
    public void iSelectOptionFromSalesPerson(String salesPerson) {
        new MiscPage().selectSalesPerson(salesPerson);
    }

    @And("I select option {string} from product")
    public void iSelectOptionFromProduct(String product) {
        new MiscPage().selectProduct(product);
    }

    @And("I select option {string} apply to")
    public void iSelectOptionApplyTo(String applyTo) {
        new MiscPage().selectApplyTo(applyTo);
    }

    @And("I select option {string} from payment type")
    public void iSelectOptionFromPaymentType(String paymentType) {
        new MiscPage().selectPaymentType(paymentType);
    }

    @And("I click on Mark as Paid")
    public void iClickOnMarkAsPaid() {
        new MiscPage().clickOnMarkAsPaid();
    }

    @When("I click Save this card")
    public void iClickSaveThisCard() {
        new MiscPage().clickOnSaveThisCard();
    }

    @And("I click on Confirm payment")
    public void iClickOnConfirmPayment() {
        new MiscPage().clickOnConfirmPayment();
    }

    @And("I enter custom product description {string}")
    public void iEnterCustomProductDescription(String description) {
        new MiscPage().enterProductDescription(description);
    }

    @And("I enter custom product unit cost {string}")
    public void iEnterCustomProductUnitCost(String unitCost) {
        new MiscPage().enterUnitCost(unitCost);
    }

    @And("I click on Active Jobs$")
    public void iClickActiveJobs() {
        new MiscPage().clickActiveJobs();
    }

    @And("I click on Applications$")
    public void iClickApplications() {
        new MiscPage().clickApplications();
    }

    @And("I should see header text \"([^\"]*)\"$")
    public void iShouldSeeHeaderText(String textMessage) {
        new MiscPage().waitUntilTextIsPresentInHeader(textMessage);
        Assert.assertTrue(new MiscPage().verifyTextMessageinTH(textMessage),"[---> " + textMessage + " is not visible <---]");
    }

    @And("I should see header text with BR \"([^\"]*)\"$")
    public void iShouldSeeHeaderTextWithBR(String textMessage) {
        new MiscPage().waitUntilTextIsPresentInHeaderWithBR(textMessage);
        Assert.assertTrue(new MiscPage().verifyTextMessageinTHwithBR(textMessage),"[---> " + textMessage + " is not visible <---]");
    }
}