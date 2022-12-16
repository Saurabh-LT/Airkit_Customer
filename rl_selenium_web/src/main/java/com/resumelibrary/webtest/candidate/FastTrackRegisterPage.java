package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FastTrackRegisterPage extends Utility {

    public FastTrackRegisterPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(FastTrackRegisterPage.class);

    @FindBy(id = "apply_now_1")
    WebElement ApplyNow1;
    @FindBy(id = "job_title_1")
    WebElement JobTitle1;
    @FindBy(id = "more_1")
    WebElement More1;
    @FindBy(id = "fasttrack-reg-trigger1")
    WebElement FastTrackRegTrigger1;
    @FindBy(id = "fasttrack-reg-trigger")
    WebElement FastTrackRegTrigger;
    @FindBy(id = "fast-track-registration-email1")
    WebElement FTREmail1;
    @FindBy(id = "fast-track-registration-email4")
    WebElement FTREmail4;
    @FindBy(id = "fast-track-registration-first-name4")
    WebElement FTRFirstName4;
    @FindBy(id = "fast-track-registration-last-name4")
    WebElement FTRLastName4;
    @FindBy(id = "fast-track-registration-password4")
    WebElement FTRPassword4;
    @FindBy(id = "fast-track-registration-first-name1")
    WebElement FTRFirstName1;
    @FindBy(id = "fast-track-registration-last-name1")
    WebElement FTRLastName1;
    @FindBy(id = "fast-track-registration-password1")
    WebElement FTRPassword1;
    @FindBy(id = "fast-track-registration-first-name")
    WebElement FTRFirstName;
    @FindBy(id = "fast-track-registration-last-name")
    WebElement FTRLastName;
    @FindBy(id = "fast-track-registration-password")
    WebElement FTRPassword;
    @FindBy(id = "fasttrack-form-login-link")
    WebElement FTRLoginLink;
    @FindBy(id = "fasttrack-form-register-link")
    WebElement FTRRegisterLink;
    @FindBy(id = "resume_check1")
    WebElement ResumeCheck1;
    @FindBy(xpath = "//*[contains(text(),'Apply now')]")
    WebElement ApplyNowLink;

    public void setCookieWith(String key, String value) {
        logger.info("set cookie :" + key + " with  value : " + value);
        setCookie(key, value);
    }

    public void clickOnApplyNow() {
        logger.info("Click on 'Apply now ' button");
        clickOnElement(FastTrackRegTrigger1);
        waitFor(2);
    }

    public void fillEmail(String email) {
        logger.info("entered email is : " + email);
        FTREmail1.clear();
        FTREmail1.sendKeys(email);
    }

    public void fillACMEEmail(String email) {
        logger.info("entered acme email is : " + email);
        FTREmail4.sendKeys(email);
    }

    public void fillEmailField(String email) {
        logger.info("entered email is : " + email);
        waitUntilElementIsLocated(FTREmail1, 5);
        FTREmail1.sendKeys(email);
        FTREmail1.sendKeys(Keys.ENTER);
    }

    public void fillFirstName(String firstName) {
        logger.info("first name is : " + firstName);
        FTRFirstName1.clear();
        FTRFirstName1.sendKeys(firstName);
    }

    public void fillFirstNameField(String firstName) {
        logger.info("entered first name  is : " + firstName);
        FTRFirstName.clear();
        FTRFirstName.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        logger.info("entered last name  is : " + lastName);
        FTRLastName1.clear();
        FTRLastName1.sendKeys(lastName);
    }

    public void fillLastNameField(String lastName) {
        logger.info("entered last name  is : " + lastName);
        FTRLastName.clear();
        FTRLastName.sendKeys(lastName);
    }

    public void enterPassword(String password) {
        logger.info("entered password : " + password);
        FTRPassword1.sendKeys(password);
    }

    public void enterPasswordField(String password) {
        logger.info("entered password : " + password);
        FTRPassword.clear();
        FTRPassword.sendKeys(password);
    }

    public void clickOnApplyLinkNow() {
        waitUntilElementToBeClickable(ApplyNow1, 5);
        clickOnElement(ApplyNow1);
    }

    public void switchToNewTab() {
        switchTab();
    }

    public void switchToNewTab2() {
        switchTab2();
    }

    public void clickOnApplyButton() {
        logger.info("user click on apply now link from new tab" + ApplyNowLink.getText());
        waitUntilElementToBeClickable(ApplyNowLink, 5);
        clickOnElement(ApplyNowLink);
    }

    public void clickOnJobTitle() {
        logger.info(" click on Job title ");
        clickOnElement(JobTitle1);
    }

    public void clickOnApplyLink() {
        logger.info("user click on apply now link from new tab" + FastTrackRegTrigger.getText());
        clickOnElement(FastTrackRegTrigger);
    }

    public void clickOnMoreLink() {
        logger.info("user click on 'More' link " + More1.getText());
        clickOnElement(More1);
        waitFor(1);
    }

    public void verifyTextP(String text) {
        String verifiedText = verifyTextMessagePTags(text, text);
        logger.info("Text message to be verified is :" + text + " against the text on page is : " + verifiedText);
        Assert.assertTrue(verifiedText.contains(text), "[---> " + text + " is not visible <---]");
    }

    public void verifyText(String text) {
        String verifiedText = getElementByText(text).getText();
        logger.info("Text message to be verified is :" + text + " against the text on page is : " + verifiedText);
        Assert.assertTrue(verifiedText.contains(text),"[---> " + text + " is not visible <---]");
    }

    public void clickOnLoginLink() {
        logger.info("Click on login link on the page");
        clickOnElement(FTRLoginLink);
        waitFor(1);
    }

    public void clickOnJobSeeker() {
        logger.info("Click on Job Seeker link on the page");
        clickOnElement(FTRRegisterLink);
        waitFor(2);
    }

    public void unCheckResume1View() {
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(3);
        } else {
            waitFor(1);
        }
        logger.info("Clicking Send me a free resume review check box");
        clickOnElement(ResumeCheck1);
    }

    public void fillACMEFirstName(String firstName) {
        logger.info("entered first name  is : " + firstName);
        FTRFirstName4.sendKeys(firstName);
    }

    public void fillACMELastName(String lastname) {
        logger.info("entered acme last name  is : " + lastname);
        FTRLastName4.sendKeys(lastname);
    }

    public void fillACMEPassword(String password) {
        logger.info("entered password is : " + password);
        FTRPassword4.sendKeys(password);
    }
}