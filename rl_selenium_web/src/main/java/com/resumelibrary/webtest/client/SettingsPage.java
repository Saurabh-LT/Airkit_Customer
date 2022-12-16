package com.resumelibrary.webtest.client;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.EmailPreferencesPage;
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

    @FindBy(id = "email_type_5")
    WebElement EmailType5;
    @FindBy(id = "email_type_6")
    WebElement EmailType6;
    @FindBy(id = "email_type_7")
    WebElement EmailType7;
    @FindBy(id = "email_type_9")
    WebElement EmailType9;
    @FindBy(id = "email_type_10")
    WebElement EmailType10;
    @FindBy(id = "email_type_all")
    WebElement EmailTypeAll;
    @FindBy(css = ".small-text")
    WebElement TextMessage;

    public void clickOnEmailType5() {
        logger.info("Clicking client newsletter emails");
        clickOnElement(EmailType5);
    }
    public void iVerifyAndClickCheckBox(String content) {
        logger.info("verify and click "+content);
        if(!EmailTypeAll.isSelected()) {
            logger.info(content+"not selected selecting now");
            waitFor(1);
            clickOnElement(EmailTypeAll);
            new EmailPreferencesPage().clickOnUpdateProfileButton();
        }
        waitFor(2);

    }

    public void clickOnEmailType6() {
        logger.info("Clicking product updates emails");
        clickOnElement(EmailType6);
    }

    public void clickOnEmailType7() {
        logger.info("Clicking resume match emails");
        clickOnElement(EmailType7);
    }

    public void clickOnEmailType9() {
        logger.info("Clicking marketing emails");
        clickOnElement(EmailType9);
    }

    public void clickOnEmailType10() {
        logger.info("Clicking resume alerts emails");
        clickOnElement(EmailType10);
    }

    public void clickOnEmailTypeAll() {
        logger.info("Clicking I would like to receive all of the above.");
        clickOnElement(EmailTypeAll);
    }

    public String gettingTextToVerify() {
        logger.info("Verifying text message ");
        return getTextFromElement(TextMessage);
    }
}