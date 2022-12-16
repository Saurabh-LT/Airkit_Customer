package com.resumelibrary.webtest.candidate;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class LoginViaRegistrationPage extends Utility {

    public LoginViaRegistrationPage()
    {
        PageFactory.initElements(getThreadDriver(),this);
    }
    private static final Logger logger = LogManager.getLogger(LoginViaRegistrationPage.class);

    @FindBy(id = "reg_apply_register_btn")
    WebElement RegApplyRegisterBtn;
    @FindBy(id = "password")
    WebElement Password;
    @FindBy(id = "register_now_button")
    WebElement RegisterNowButton;
    @FindBy(id = "email")
    WebElement Email;

    public void clickOnRegisterApply() {
        clickOnElement(RegApplyRegisterBtn);
        waitFor(2);
    }

    public void enterPassword(String password) {
        logger.info("Entered password is :" + password);
        Password.clear();
        Password.sendKeys(password);
        //waitFor(2);
    }

    public void enterEmail(String email) {
        logger.info("Entered email :" + email);
        Email.sendKeys(email);
    }

    public void clickLoginApply() {
        logger.info("Clicking on login and apply " );
        clickOnElement(RegisterNowButton);
    }
}