package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.SettingsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.File;

public class Settings extends Utility {

    private static final Logger logger = LogManager.getLogger(Settings.class);

    @When("I fill in old password {string}")
    public void iFillOldPassword(String password) {
        new SettingsPage().fillOldPassword(password);
    }

    @When("I fill in new password {string}")
    public void iFillNewPassword(String newPassword) {
        new SettingsPage().fillNewPassword(newPassword);
    }

    @When("I fill in confirm new password {string}")
    public void iFillConfirmNewPassword(String confirmPassword) {
        new SettingsPage().fillConfirmNewPassword(confirmPassword);
    }

    @And("I fill in the comments {string}")
    public void iFillInTheComments(String comments) {
        new SettingsPage().fillInComments(comments);
    }

    @And("I click on save new password button")
    public void iClickOnSaveNewPasswordButton() {
        new SettingsPage().clickOnSaveNewPasswordButton();
    }

    @And("I click on change email button")
    public void iClickOnChangeEmailButton() {
        new SettingsPage().clickOnChangeEmailButton();
    }

    @And("I fill in email and confirm email {string}")
    public void iFillInEmailAndConfirmEmail(String email) {
        email = getRandomString(4) + email;
        new SettingsPage().fillNewEmail(email);
        new SettingsPage().fillConfirmNewEmail(email);
        waitFor(2);
    }

    @And("I click on save new email")
    public void iClickOnSaveNewEmail() {
        new SettingsPage().clickOnSaveNewEmailButton();
    }

    @And("I click on delete my account button")
    public void iClickOnDeleteMyAccountButton() {
        new SettingsPage().clickOnDeleteMyAccountButton();
    }

    @And("I click on Hide My Profile")
    public void iClickOnHideMyProfile() {
        new SettingsPage().clickOnHideMyProfileButton();
    }

    @And("I should see download file {string} in folder")
    public void iShouldSeeDownloadFileInFolder(String downloadFile) {
        File dir = new File("/tmp");
        File[] dirContents = dir.listFiles();

        for (File file : dirContents) {
            if (file.getName().contains(downloadFile)) {
                logger.info("downloaded to tmp folder :");
                file.delete();
                logger.info("deleted from tmp folder :");
                break;
            }
            dir.delete();
            logger.info("tmp folder is deleted :");
        }
    }
}