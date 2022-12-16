package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JobAlertPage extends Utility {

    public JobAlertPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(JobAlertPage.class);

    @FindBy(id = "email_1")
    WebElement Email1;
    @FindBy(id = "create_alert_1")
    WebElement CreateAlertButton;
    @FindBy(id = "ja-keywords")
    WebElement JaKeywords;
    @FindBy(id = "ja-location")
    WebElement Jalocation;
    @FindBy(xpath = "//button[contains(text(),'Create Job Alerts')]")
    WebElement CreateJobAlerts;
    @FindBy(id = "create_alert_q")
    WebElement Keyword;
    @FindBy(id = "create_alert_loc")
    WebElement CreateAlertLoc;
    @FindBy(id = "create_alert_radius")
    WebElement CreateAlertRadius;
    @FindBy(id = "create_alert_submit_btn")
    WebElement CreateAlertSubmitBtn;
    @FindBy(xpath = "/html/body/dialog[2]/div/div/div[1]/a")
    WebElement DeleteAlert;
    @FindBy(xpath = "//*[@id=\"jbe\"]/dialog[2]/div/div/p")
    WebElement VerifyTextPopup;
    @FindBy(id = "delete_alert_action_row_btn_active_1")
    WebElement DeleteAlertActionRowBtnActive1;
    @FindBy(id = "run_search_btn_active_1")
    WebElement RunSearchBtnActive1;
    @FindBy(id = "edit_alert_btn_active_1")
    WebElement EditAlertBtnActive1;
    @FindBy(id = "edit_alert_q_active_1")
    WebElement EditAlertQActive1;
    @FindBy(id = "edit_alert_save_btn_active_1")
    WebElement EditAlertSaveBtnActive1;
    @FindBy(id = "ja_status_toggle_active_1")
    WebElement JaStatusToggleActive1;
    @FindBy(id = "snooze_btn_active_1")
    WebElement SnoozeBtnActive1;
    @FindBy(id = "ja_status_toggle_snoozed_1")
    WebElement JaStatusToggleSnoozed1;
    @FindBy(id = "unsnooze_btn_snoozed_1")
    WebElement UnsnoozeBtnSnoozed1;
    @FindBy(id = "search-results-jbe-email")
    WebElement SearchResultsJbeEmail;
    @FindBy(name = "password")
    WebElement Password;
    @FindBy(id = "email_1")
    WebElement EmailOne;
    @FindBy(css = "dialog[name='delete-popup-daily'] #delete-alert-confirm")
    WebElement DeleteAlertConfirmButton;
    @FindBy(id = "password_1")
    WebElement PasswordOne;
    @FindBy(id = "ja-email")
    WebElement JaEmail;
    @FindBy(id = "ja-password")
    WebElement JaPassword;
    @FindBy(xpath = "//form[@id='alert_form_active_1']//input[@name='keywords']")
    WebElement keywordOrJobTitleInputField;
    @FindBy(xpath = "(//div[@class='jbe-form-results-center'])[2]")
    WebElement jbeFormResultsCenter;
    @FindBy(id = "edit_alert_save_btn_active_1")
    WebElement SaveChangesButton;
    @FindBy(xpath = "//*[@class = 'success-div mt0']")
    WebElement SuccessMessage;
    @FindBy(id = "ja_status_toggle_deactivated_1")
    WebElement JaStatusToggleInActive1;
    @FindBy(xpath = "(//div[@id='jbe-form-no-results'])[2]/h3")
    WebElement jbeFormNoResultsText;
    @FindBy(xpath = "(//div[@id='jbe-form-results-jobs'])[2]/div")
    WebElement jbeFormResults;
    @FindBy(id = "activate_alert_btn_deactivated_1")
    WebElement activateAlertBtn;

    String jbeFormResultsXpath = "(//div[@id='jbe-form-results-jobs'])[2]/div";

    public void fillInEmail(String emailText) {
        logger.info("Entered the email is : " + emailText);
        Email1.sendKeys(emailText);
    }

    public void clickOnCreateAlert() {
        logger.info("click on create alert ");
        clickOnElement(CreateAlertButton);
        waitFor(2);
    }

    public void enterKeywords(String keyWords) {
        logger.info("Entered the job title is : " + keyWords);
        JaKeywords.sendKeys(keyWords);
    }

    public void enterLocation(String location) {
        logger.info("Entered the job location is : " + location);
        Jalocation.sendKeys(location);
    }

    public void clickJobAlertsButton() {
        logger.info("click on create alert ");
        clickOnElement(CreateJobAlerts);
        waitFor(2);
    }

    public void enterKeywordAndLocation(String keyword, String location) {
        logger.info("Entered the job location & Job title : " + keyword + "and" + location);
        sendTextToElement(Keyword, keyword);
        sendTextToElement(CreateAlertLoc, location);

    }

    public void enterDistance(String radius) {
        logger.info("Entered the distance is   : " + radius);
        selectByVisibleText(CreateAlertRadius, radius);
    }


    public void clickOnCreateJobAlert() {
        logger.info("Clicking on create job alert btn ");
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(2);
        }
        clickOnElement(CreateAlertSubmitBtn);
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(2);
        }
    }

    public void clickOnDeleteAlert() {
        logger.info("click on Delete alert ");
        clickOnElement(DeleteAlert);
        waitFor(2);
    }

    public void clickOnDelete() {
        logger.info("click on Delete alert ");
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(2);
        }
        clickOnElement(DeleteAlertActionRowBtnActive1);
    }

    public void verifyTextPopup(String text) {
        waitUntilElementIsLocated(DeleteAlertConfirmButton, 5);
        String textOnPopup = VerifyTextPopup.getText();
        logger.info("text to be verified:" + text + "against: " + textOnPopup);
        Assert.assertEquals(textOnPopup, text);
    }

    public void clickOnRunSearch() {
        logger.info("click on Run Search Button");
        clickOnElement(RunSearchBtnActive1);
        waitFor(2);
    }

    public void clickEditJobAlert() {
        logger.info("click on Edit Job Alert ");
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(2);
        }
        clickOnElement(EditAlertBtnActive1);
        waitFor(2);
    }

    public void enterEditAlertKeyword(String text) {
        logger.info("click on Edit Alert Keyword  : " + text);
        EditAlertQActive1.sendKeys(text);
    }

    public void clickOnSaveChanges() {
        logger.info("click on Save Changes Button ");
        clickOnElement(EditAlertSaveBtnActive1);
        waitFor(3);
    }

    public void clickOnActiveInactiveStatus(String status) {
        if (status.equals("active")) {
            logger.info("click on Active status Link ");
            if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
                waitFor(2);
            }
            clickOnElementWithJS(JaStatusToggleActive1);
        } else if (status.equals("inactive")) {
            logger.info("click on Active status Link ");
            waitUntilElementIsLocated(JaStatusToggleActive1, 5);
            clickOnElementWithJS(JaStatusToggleInActive1);
            clickOnElementWithJS(activateAlertBtn);
        }
    }

    public void clickOnSnoozeButton() {
        logger.info("click on Snooze Button ");
        clickOnElement(SnoozeBtnActive1);
        waitFor(2);
    }

    public void clickOnSnoozed() {
        logger.info("click on Snooze Button ");
        clickOnElement(JaStatusToggleSnoozed1);
    }

    public void clickOnUnSnooze() {
        logger.info("click on Un Snooze Button ");
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(1);
        }
        clickOnElement(UnsnoozeBtnSnoozed1);
    }

    public void enterSearchResultsJbeEmail(String email) {
        logger.info("Email entered is : " + email);
        SearchResultsJbeEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        logger.info("Password entered is : " + password);
        Password.sendKeys(password);
    }

    public void clickOnDeleteThisAlert() {
        logger.info("Click on Yes, delete this alert ");
        clickOnElement(DeleteAlertConfirmButton);
        waitFor(1);
    }

    public void enterEmailOne(String email) {
        logger.info("Email entered is : " + email);
        EmailOne.sendKeys(email);
    }

    public void enterPasswordOne(String password) {
        logger.info("Password entered is : " + password);
        PasswordOne.sendKeys(password);
    }

    public void enterJaEmail(String email) {
        logger.info("Email entered is : " + email);
        JaEmail.sendKeys(email);
        JaEmail.sendKeys(Keys.ENTER);
    }

    public void enterJaPassword(String password) {
        logger.info("Password entered is : " + password);
        JaPassword.sendKeys(password);
    }

    public void ClickOnExampleJobMatchesHeader(String linkText) {
        logger.info("Click on Example job matches header");
        clickOnElementUsingText(linkText);
    }

    public void ClickOnSaveChangesButton() {
        logger.info("Click on Save Changes Button");
        SaveChangesButton.click();
    }

    public void EnterKeywordOrJobTitle(String text) throws InterruptedException {
        logger.info("input the Keyword/Jobtitle");
        keywordOrJobTitleInputField.clear();
        keywordOrJobTitleInputField.sendKeys(text);
        synchronized (this) {
            wait(10);
        }
    }

    public void CompareExampleJobWithKeyword(String text) {
        logger.info("Comparing Example Job with Keyword/Title");
        waitUntilElementIsLocated(jbeFormResultsCenter, 10);
        if (getThreadDriver().findElements(By.xpath(jbeFormResultsXpath)).size() < 1) {
            Assert.assertEquals(getTextFromElement(jbeFormNoResultsText), text);
        } else {
            String keywordOrJobtitle = getTextFromElement(keywordOrJobTitleInputField);
            String jbeformResultsText = getTextFromElement(jbeFormResults);
            logger.info(jbeformResultsText);
            if (jbeformResultsText.contains(keywordOrJobtitle)) {
                logger.info("Example Job Description contains the Keyword/Title");
            } else {
                logger.info("Example Job Description does not contains the Keyword/Title");
            }
        }
    }

    public void shouldSeeMessageInJbeXpath(String text) {
        String successMessageText = SuccessMessage.getText();
        logger.info("success message " + successMessageText);
        Assert.assertEquals(successMessageText, text);
    }
}