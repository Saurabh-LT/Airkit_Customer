package com.resumelibrary.webtest.client;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends Utility {

    public AccountPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(AccountPage.class);

    @FindBy(xpath = "//section[@class='card card--shadow client-dash-module module--job-postings']/a")
    WebElement PostAJob;

    public boolean verifyTextInModule(String text, String module) {
        String xpathString = String.format("//h2[text()='%s' ]/../..//*[text()='%s']", module, text);
        logger.info("xpath string is : " + xpathString);
        WebElement result = getWebElement(text, module, xpathString);
        return getTextFromElement(result).contains(text);
    }

    public void clickOnTextInModule(String text, String module) {
        String xpathString = String.format("//h2[text()='%s' ]/../..//*[text()='%s']", module, text);
        clickOnElement(getWebElement(text, module, xpathString));
    }

    public boolean verifyTextInModule(String text, String plan, String module) {
        WebElement result = getWebElementFromModule(text, plan, module);
        return getTextFromElement(result).contains(text);
    }

    public void clickOnTextInModule(String text, String module, String plan) {
        clickOnElement(getWebElementFromModule(text, module, plan));
    }

    private WebElement getWebElementFromModule(String text, String plan, String module) {
        logger.info("Verifying text message " + text + " for plan " + plan + "in module " + module);
        String xpathString = String.format("//h2[text()='%s' ]/.././/div[1]/div//*[text()='%s']/../..//*[text()='%s']", module, plan, text);
        return getWebElement(text, module, xpathString);
    }

    private WebElement getWebElement(String text, String module, String xpathString) {
        logger.info("Verifying text message " + text + " in module " + module);
        WebElement result = null;
        try {
            result = getThreadDriver().findElement(By.xpath(xpathString));
            logger.info("Element : " + result.toString() + " found with text " + result.getText());
        } catch (NoSuchElementException nse) {
            logger.info("No Element found with text " + text);
        }
        return result;
    }

    public void clickOnTextInYourCartModule(String text, String module) {
        String xpathString = String.format("//*[text()='%s' ]/../..//*[text()='%s']", module, text);
        clickOnElement(getWebElement(text, module, xpathString));
    }

    public boolean verifyButtonInYourCartModule(String text, String module) {
        String xpathString = String.format("//*[text()='%s' ]/../..//*[text()='%s']", module, text);
        return getWebElement(text, module, xpathString) == null;
    }

    public void clickOnPostAJob() {
        logger.info("clicking on Post A Job");
        clickOnElement(PostAJob);
    }
}