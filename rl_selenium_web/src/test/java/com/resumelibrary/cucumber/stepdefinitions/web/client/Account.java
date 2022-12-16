package com.resumelibrary.cucumber.stepdefinitions.web.client;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.client.AccountPage;
import com.resumelibrary.webtest.client.EcommerceClientPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Account extends Utility {

    @Then("I should see text {string} in {string} module")
    public void iShouldSeeTextInModule(String text, String module) {
        Assert.assertTrue("[---> " + text + " is not displayed in " + module + " <---]", new AccountPage().verifyTextInModule(text,module));
    }

    @When("I click on {string} in {string} module")
    public void iClickOnTextInModule(String text, String module) {
        new AccountPage().clickOnTextInModule(text,module);
    }

    @And("I should see text {string} for plan {string} in {string} module")
    public void iShouldSeeTextForPlanInModule(String text, String plan, String module) {
        new AccountPage().verifyTextInModule(text,plan,module);
    }

    @When("I click on {string} for plan {string} in {string} module")
    public void iClickOnForPlanInModule(String text, String plan, String module) {
        new AccountPage().clickOnTextInModule(text,plan,module);
    }

    @When("I click on {string} in {string} your cart module")
    public void iClickOnInYourCartModule(String text, String module) {
        new AccountPage().clickOnTextInYourCartModule(text,module);
    }

    @Then("I should not see button {string} in {string} your cart module")
    public void iShouldNotSeeButtonInYourCartModule(String text, String module) {
        Assert.assertTrue("[---> " + text + " is displayed in " + module + " <---]", new AccountPage().verifyButtonInYourCartModule(text,module));
    }

    @Then("I select option {string} from job posting credit quantity")
    public void iSelectOptionFromJobPostingCreditQuantity(String option) {
        new EcommerceClientPage().selectJobPostingCreditQuantity(option);
    }

    @When("I click on Post a Job")
    public void iClickOnPostAJob() {
        new AccountPage().clickOnPostAJob();
    }
}