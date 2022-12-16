package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.DataHelper;
import com.resumelibrary.utilities.WebURLHelper;
import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OthersPage extends Utility {

    public OthersPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(OthersPage.class);

    @FindBy(id = "send-request-btn")
    WebElement SendRequestButton;
    @FindBy(id = "email")
    WebElement EmailAddress;
    @FindBy(id = "name")
    WebElement Name;
    @FindBy(id = "message")
    WebElement Message;
    @FindBy(id = "request_type")
    WebElement RequestType;
    @FindBy(id = "home-signin")
    WebElement LoginButton;
    @FindBy(id = "recruiter-login-icon")
    WebElement EmployerLogin;
    @FindBy(name = "csrf_rl")
    WebElement CsrfRl;
    @FindBy(id = "nav_upload_resume")
    WebElement RegisterButton;
    @FindBy(id = "salary-swap-msg")
    WebElement SalarySwapMsg;
    @FindBy(id = "error_salary_expectation")
    WebElement ErrorSalaryExpectation;
    @FindBy(xpath = "//a[@class='btn-sm results-apply-btn js-apply-btn email']")
    WebElement NonExternalApplyNowButton;
    @FindBy(id = "apply-send-application")
    WebElement SendApplicationBtn;
    @FindBy(id = "nav_modify_resume")
    WebElement ModifyProfileLink;
    @FindBy(xpath = "//*[@class='account-link']")
    WebElement UsersProfileLink;
    @FindBy(id = "job_title_1")
    WebElement JobTitleFromSearchPage;
    @FindBy(id = "job-view-apply-now-btn")
    WebElement JobViewApplyNowBtn;
    @FindBy(id = "hide-expired-applications")
    WebElement GetTextFromElementHideExpiredApplications;
    @FindBy(id = "view_application_1")
    WebElement ViewApplicationButton;
    @FindBy(id = "job_title_applied_1")
    WebElement JobTitleAppliedLink;

    public void clickSendRequestButton() {
        logger.info("Clicking on send request button ");
        clickOnElement(SendRequestButton);
        waitFor(1);
    }

    public void fillInRandomClientEmailAddress() {
        logger.info("Entered email address ");
        EmailAddress.sendKeys(new DataHelper().getRandomClientEmail());
        //EmailAddress.isDisplayed()

    }

    public void fillInMessage() {
        logger.info("Sending message ");
        Message.sendKeys("This is selenium automation test");
    }

    public void selectTheOptionFromRequest(String text) {
        logger.info("Selected  " + text + "  from dropdown ");
        selectByVisibleText(RequestType, text);
    }

    public void fillInEmailAddressWith(String text) {
        logger.info("Entered email address " + text);
        EmailAddress.sendKeys(text);
        clickOnElement(Message);
    }

    public void fillInName() {
        logger.info("Entered name ");
        Name.sendKeys("This is selenium automation test");
    }

    public void clickLoginButton() {
        logger.info("Clicking on login button ");
        clickOnElement(LoginButton);
        waitUntil(WebURLHelper.getLoginPageUrl());
    }

    public void clickEmployerLogin() {
        logger.info("Clicking on employer login ");
        clickOnElement(EmployerLogin);
    }

    public String findValueAndStoreAsVariable() {
        logger.info("Finding value ");
        return CsrfRl.getAttribute("value");
    }

    public String getCookieValueWithNameAndStoreAsAVariable() {
        logger.info("Getting cookie with name and store as variable ");
        return getThreadDriver().manage().getCookieNamed("csrf_rl").getValue();
    }

    public boolean compareBothVariableToVerifyItsNotTheSame() {
        logger.info("Comparing both variable to verity its not the same ");
        return !findValueAndStoreAsVariable().equals(getCookieValueWithNameAndStoreAsAVariable());
    }

    public void clickRegisterButton() {
        logger.info("Clicking on register button");
        clickOnElement(RegisterButton);
    }


    public String getTextFromSalarySwap() {
        logger.info("Getting text from salary swap");
        return SalarySwapMsg.getText();
    }

    public String getTextFromErrorSalaryExpectation() {
        logger.info("Getting text from error salary expectation");
        return ErrorSalaryExpectation.getText();
    }

    public void clickOnSendApplicationButton() {
        logger.info("Clicking on send application button ");
        clickOnElement(SendApplicationBtn);
    }

    public void clickOnModifyProfileLink() {
        logger.info("Clicking on modify profile link ");
        clickOnElement(ModifyProfileLink);
    }

    public void clickOnNonExternalApplyNowButton() {
        logger.info("Clicking on non external apply now button");
        clickOnElement(NonExternalApplyNowButton);
        waitFor(2);
    }

    public void mouseHoverToUsersProfile() {
        logger.info("Mouse hover to users profile ");
        waitUntilElementIsLocated(UsersProfileLink, 10);
        mouseHoverToElement(UsersProfileLink);
        waitFor(2);
    }

    public void clickOnJobTitleFromSearchPage() {
        logger.info("Clicking on job title ");
        clickOnElement(JobTitleFromSearchPage);
    }

    public void clickOnJobViewApplyNowButton() {
        logger.info("Clicking on job view apply now button ");
        clickOnElement(JobViewApplyNowBtn);
    }

    public String getTextFromElement() {
        logger.info("Getting test from element ");
        return getTextFromElement(GetTextFromElementHideExpiredApplications);
    }

    public void clickOnViewApplicationButton() {
        logger.info("Clicking on view application button ");
        clickOnElement(ViewApplicationButton);
    }

    public void clickOnJobTitleAppliedLink() {
        logger.info("Clicking on job title ");
        clickOnElement(JobTitleAppliedLink);
    }

    public void verifyURLText(String url, String text) {
        if (!text.equals("assets")) {
            waitUntil(WebURLHelper.getWebUrl() + getURL(url));
        }
        String presentURL = getPresentURL();
        logger.info("The present URL is --> : " + presentURL);
        logger.info("The URL --> : " + url + " to be verified against : " + presentURL + " boolean value: " + presentURL.contains(getURL(url)));
        Assert.assertTrue(presentURL.contains(getURL(url)),"[---> " + presentURL + " doesn't contain " + url + " <---]");
    }

    public void verifyURL(String url) {
        waitUntil(WebURLHelper.getWebUrl() + getURL(url));
        String presentURL = getPresentURL();
        logger.info("The present URL is --> : " + presentURL);
        logger.info("The URL --> : " + url + " to be verified against : " + presentURL);
        Assert.assertTrue(presentURL.contains(getURL(url)),"[---> " + presentURL + " doesn't contain " + url + " <---]");
    }

    public void verifyTextInURL(String urlText) {
        String presentURL = getPresentURL();
        logger.info("The present URL is --> : " + presentURL);
        logger.info("The URL --> : " + urlText + " to be verified against : " + presentURL);
        Assert.assertTrue(presentURL.contains(urlText),"[---> " + presentURL + " doesn't contain " + urlText + " <---]");
    }

    public void verifyHTTPURLText(String url) {
        String presentURL = getPresentURL();
        logger.info("The present URL is --> : " + presentURL);
        logger.info("The URL --> : " + url + " to be verified against : " + presentURL);
        logger.info("The URL --> : " + url + " to be verified against : " + presentURL + "boolean value:" + presentURL.contains(url));
        Assert.assertTrue(presentURL.contains(getURL(url)),"[---> " + presentURL + " doesn't contain " + url + " <---]");
    }

    public void iShouldSeeElementWithTextVisibleOrInvisible(String elementText, String condition) {
        logger.info("get the element using the text : " + elementText);
        WebElement element = getElementByText(elementText);
        checkVisibilityOfElement(element, condition);
    }

    public void iShouldSeeElementWithIdVisibleOrInvisible(String elementId, String condition) {
        logger.info("get the element using the text : " + elementId);
        WebElement element = getElementById(elementId);
        checkVisibilityOfElement(element, condition);
    }

    private void checkVisibilityOfElement(WebElement element, String condition) {
        if (condition.equals("visible")) {
            logger.info("wait until element : " + element.getText() + " to be " + condition);
            waitUntilElementIsLocated(element, 15);
        }
       else if (condition.equals("invisible")) {
            logger.info("wait until element : " + element.getText() + " to be " + condition);
            waitUntilElementToBeDisappear(element, 15);
        }
    }
}