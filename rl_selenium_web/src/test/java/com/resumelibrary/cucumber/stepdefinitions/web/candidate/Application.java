package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.ApplicationPage;
import com.resumelibrary.webtest.candidate.MyDashboardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Application extends Utility {

    @Then("I should see hide expired checkbox is unchecked")
    public void iShouldSeeHideExpiredCheckboxIsUnchecked() {
        Assert.assertTrue(new ApplicationPage().verifyThatHideExpiredCheckboxIsNotSelected(),"[---> Hide expired checkbox is checked <---]");
    }

    @When("I click on Hide expired checkbox")
    public void iClickOnHideExpiredCheckbox() {
        new MyDashboardPage().clickOnHideExpiredApplicationCheckbox();
    }

    @Then("I should see hide expired checkbox is checked")
    public void iShouldSeeHideExpiredCheckboxIsChecked() {
       Assert.assertTrue(new ApplicationPage().verifyThatHideExpiredCheckboxIsSelected(),"[---> Hide expired checkbox is unchecked <---]");
    }
}