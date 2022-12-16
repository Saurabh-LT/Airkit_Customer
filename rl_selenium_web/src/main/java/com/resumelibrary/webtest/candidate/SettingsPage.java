package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends Utility {

    public SettingsPage()
    {
        PageFactory.initElements(getThreadDriver(),this);
    }
    private static final Logger logger = LogManager.getLogger(SettingsPage.class);

    @FindBy(id = "old_pass")
    WebElement OldPasswordField;
    @FindBy(id = "new_pass")
    WebElement NewPasswordField;
    @FindBy(id = "new_pass_confirm")
    WebElement ConfirmNewPasswordField;
    @FindBy(id = "change_password")
    WebElement SaveNewPasswordField;
    @FindBy(id = "tab-change-email")
    WebElement ChangeEmailButton;
    @FindBy(id = "new_email")
    WebElement NewEmailField;
    @FindBy(id = "confirm_email")
    WebElement ConfirmNewEmailField;
    @FindBy(id = "change_email_address")
    WebElement SaveNewEmailButton;
    @FindBy(id = "delete-submit-button")
    WebElement DeleteMyAccountButton;
    @FindBy(xpath = "//*[@class='btn hold-btn']")
    WebElement HideMyProfileButton;
    @FindBy(id = "comments")
    WebElement CommentsField;

    public void fillOldPassword(String password) {
        logger.info("Entered old password " + password);
        OldPasswordField.clear();
        OldPasswordField.sendKeys(password);
    }

    public void fillNewPassword(String newPassword) {
        logger.info("Entered new password " + newPassword);
        NewPasswordField.clear();
        NewPasswordField.sendKeys(newPassword);
    }

    public void fillConfirmNewPassword(String confirmPassword) {
        logger.info("Entered confirm new  password " + confirmPassword);
        ConfirmNewPasswordField.clear();
        ConfirmNewPasswordField.sendKeys(confirmPassword);
    }

    public void clickOnSaveNewPasswordButton(){
        logger.info("Clicking on save new password button ");
        clickOnElement(SaveNewPasswordField);
    }

    public void clickOnChangeEmailButton(){
        logger.info("Clicking on change email button ");
        clickOnElement(ChangeEmailButton);
        waitFor(2);
    }

    public void fillNewEmail(String newEmail) {
        waitUntilElementIsLocated(NewEmailField,10);
        logger.info("Entered new email " + newEmail );
        NewEmailField.sendKeys(newEmail);
    }

    public void fillConfirmNewEmail(String confirmEmail) {
        waitUntilElementIsLocated(ConfirmNewEmailField,10);
        logger.info("Entered confirm new  email " + confirmEmail);
        ConfirmNewEmailField.sendKeys(confirmEmail);
    }

    public void clickOnSaveNewEmailButton(){
        logger.info("Clicking on save new email button ");
        clickOnElement(SaveNewEmailButton);
    }

    public void clickOnDeleteMyAccountButton(){
        logger.info("Clicking on delete my account button ");
        clickOnElement(DeleteMyAccountButton);
    }

    public void clickOnHideMyProfileButton(){
        logger.info("Clicking on hide my profile button ");
        clickOnElement(HideMyProfileButton);
    }

    public void fillInComments(String comments) {
        logger.info("");
        CommentsField.sendKeys(comments);
    }
}