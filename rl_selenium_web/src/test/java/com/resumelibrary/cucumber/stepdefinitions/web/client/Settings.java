package com.resumelibrary.cucumber.stepdefinitions.web.client;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.client.SettingsPage;
import io.cucumber.java.en.And;
import org.testng.Assert;

public class Settings extends Utility {

    @And("I click on client newsletter emails")
    public void iClickOnClientNewsletterEmails() {
        new SettingsPage().clickOnEmailType5();
    }

    @And("I Verify and click {string}")
    public void iVerifyAndClickCheckBox(String checkBoxContent) {
        new SettingsPage().iVerifyAndClickCheckBox(checkBoxContent);
    }

    @And("I click product updates emails")
    public void iClickProductUpdatesEmails() {
        new SettingsPage().clickOnEmailType6();
    }

    @And("I click resume match emails")
    public void iClickResumeMatchEmails() {
        new SettingsPage().clickOnEmailType7();
    }

    @And("I click marketing emails")
    public void iClickMarketingEmails() {
        new SettingsPage().clickOnEmailType9();
    }

    @And("I click resume alerts emails")
    public void iClickResumeAlertsEmails() {
        new SettingsPage().clickOnEmailType10();
    }

    @And("I click I would like to receive all of the above")
    public void iClickIWouldLikeToReceiveAllOfTheAbove() {
        new SettingsPage().clickOnEmailTypeAll();
    }

    @And("I should see text message email preferences {string}")
    public void iShouldSeeTextMessageEmailPreferences(String text) {
        Assert.assertEquals(new com.resumelibrary.webtest.client.SettingsPage().gettingTextToVerify(),text);
    }
}