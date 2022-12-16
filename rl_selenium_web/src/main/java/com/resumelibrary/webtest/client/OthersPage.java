package com.resumelibrary.webtest.client;

import com.resumelibrary.utilities.DataHelper;
import com.resumelibrary.utilities.Utility;
import com.resumelibrary.utilities.WebURLHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OthersPage extends Utility {

    public OthersPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(OthersPage.class);

    @FindBy(id = "saved_action_1")
    WebElement SavedAction1;
    @FindBy(id = "saved-unlocked-resume-name-asc")
    WebElement CandidateNameAsc;
    @FindBy(id = "saved-unlocked-resume-name-desc")
    WebElement CandidateNameDesc;
    @FindBy(id = "saved-unlocked-resume-user-asc")
    WebElement SavedByAsc;
    @FindBy(id = "saved-unlocked-resume-user-desc")
    WebElement SavedByDesc;
    @FindBy(id = "footer-events-link")
    WebElement FooterEventsLink;
    @FindBy(id = "footer-work-permits-and-visas-link")
    WebElement FooterWorkPermitsAndVisasLink;
    @FindBy(id = "action-toggle-btn-1")
    WebElement ActionToggleBtn1;
    @FindBy(id = "view-guide-zoho")
    WebElement ViewGuideZoho;
    @FindBy(id = "generate-new-key-1")
    WebElement GenerateNewKey1;
    @FindBy(css = ".form-tag")
    WebElement FormTagText;
    @FindBy(id = "submit2")
    WebElement SearchResumes;
    @FindBy(id = "email_address")
    WebElement EmailAddress;
    @FindBy(id = "keywords")
    WebElement Keywords;
    @FindBy(id = "location")
    WebElement Location;
    @FindBy(id = "name")
    WebElement Name;
    @FindBy(id = "keywords_builder_textarea_input")
    WebElement KeywordsBuilderTextareaInput;
    @FindBy(id = "salary_from")
    WebElement SalaryMin;
    @FindBy(id = "salary_to")
    WebElement SalaryTo;
    @FindBy(id = "address_1")
    WebElement Address1;
    @FindBy(id = "state")
    WebElement State;
    @FindBy(id = "recruiter_type")
    WebElement RecruiterType;
    @FindBy(xpath = "//button[@id='rs-more-toggle']/span")
    WebElement MoreSearchOptions;
    @FindBy(xpath = "//*[@id=\"main\"]/section[4]/div/div/div[2]/div[12]/a")
    WebElement PostJobsButton;
    @FindBy(xpath = "//*[@id=\"player\"]/div[*]/div[3]/button/div[2]")
    WebElement VideoPlayButton;
    @FindBy(xpath = "//*[@id=\"player\"]/div[*]/div[3]/button/div[3]")
    WebElement VideoPauseButton;

    public void clickOnSavedAction1() {
        logger.info("Clicking on saved action 1 ");
        waitFor(1);
        clickOnElement(SavedAction1);
        waitFor(1);
    }

    public void clickOnCandidateNameByAscOrder() {
        logger.info("Clicking on candidate name or job title by asc order ");
        clickOnElement(CandidateNameAsc);
        waitFor(1);
    }

    public void clickOnCandidateNameByDescOrder() {
        logger.info("Clicking on candidate name or job title by desc order  ");
        clickOnElement(CandidateNameDesc);
        waitFor(1);
    }

    public void clickOnSavedByAscOrder() {
        logger.info("Clicking on saved by asc order ");
        clickOnElement(SavedByAsc);
        waitFor(1);
    }

    public void clickOFooterEventsLinkAndVerifyLink(String url) {
        logger.info("Clicking on footer event link");
        clickOnElement(FooterEventsLink);
        String presentURL = getPresentURL();
        logger.info("present url :" + presentURL);
        Assert.assertTrue(presentURL.contains(getURL(url)),"[---> " + presentURL + " doesn't contain " + url + " <---]");
    }

    public void clickOnSavedByDescOrder() {
        logger.info("Clicking on saved by desc order ");
        clickOnElement(SavedByDesc);
        waitFor(1);
    }

    public void clickOnFooterWorkPermitsAndVisasLink() {
        logger.info("Clicking on footer work permits ans visas link ");
        clickOnElement(FooterWorkPermitsAndVisasLink);
    }

    public void clickOnActionToggleButton1() {
        logger.info("Clicking on action toggle button 1 ");
        clickOnElement(ActionToggleBtn1);
        waitFor(2);
    }

    public void clickOnViewGuideZoho() {
        logger.info("Clicking on view guide zoho ");
        clickOnElement(ViewGuideZoho);
    }

    public void clickOnGenerateKey1() {
        logger.info("Clicking on generate key 1 ");
        clickOnElement(GenerateNewKey1);
        waitFor(2);
    }

    public String getTextFromFormTagElement() {
        logger.info("Getting text from element");
        return getTextFromElement(FormTagText);
    }

    public void clickOnSearchResumes() {
        logger.info("Clicking on Search Resumes button : " + SearchResumes.getAttribute("value"));
        clickOnElement(SearchResumes);
    }

    public void enterRandomClientEmailAddress() {
        logger.info("Entered email address ");
        EmailAddress.sendKeys(new DataHelper().getRandomClientEmail());
    }

    public void enterLocation(String location) {
        logger.info("Entered location : " + location);
        Location.clear();
        Location.sendKeys(location);
        Location.sendKeys(Keys.ENTER);
    }

    public void enterName(String name) {
        logger.info("Entered name field : " + name);
        sendTextToElement(Name, name);
    }

    public void enterSearchBuilderKeywordsTextArea(String keywords) {
        logger.info("Entered search builder keywords : " + keywords);
        clearTextFromField(KeywordsBuilderTextareaInput);
        sendTextToElement(KeywordsBuilderTextareaInput, keywords);
        waitFor(2);
        KeywordsBuilderTextareaInput.sendKeys(Keys.ESCAPE);
    }
    public void enterSearchBuilderKeywordsTextAreaWithEnterKey(String keywords) {
        logger.info("Entered search builder keywords : " + keywords);
        clearTextFromField(KeywordsBuilderTextareaInput);
        sendTextToElement(KeywordsBuilderTextareaInput, keywords);
        waitFor(2);
        KeywordsBuilderTextareaInput.sendKeys(Keys.ENTER);
    }

    public void enterBasicSearchKeywords(String keywords) {
        logger.info("Entered basic search keywords : " + keywords);
        clearTextFromField(Keywords);
        sendTextToElement(Keywords, keywords);
        Keywords.sendKeys(Keys.ESCAPE);
    }

    public void fillInBasicSearchKeywords(String keywords) {
        logger.info("Fill in basic search keywords : " + keywords);
        clearTextFromField(Keywords);
        sendTextToElement(Keywords, keywords);
    }

    public void selectMinSalary(String salMin) {
        logger.info("select the option min salary :" + salMin);
        selectByValueFromDropDown(SalaryMin, salMin);
    }

    public void selectMaxSalary(String salTo) {
        logger.info("select the option Max salary :" + salTo);
        selectByValueFromDropDown(SalaryTo, salTo);
    }

    public void clickOnMoreSearchOptions() {
        JavascriptExecutor js = (JavascriptExecutor) getThreadDriver();
        js.executeScript("window.scrollBy(0,-250)", "");
        clickOnElement(MoreSearchOptions);
    }

    public String verifySearchTextI() {
        String text = getThreadDriver().findElement(By.xpath("//div[@class='rs-limit-bar']/p")).getText();
        logger.info("first string : " + text);
        return text;
    }

    public void enterAddress(String address) {
        logger.info("Entered address field : " + address);
        Address1.sendKeys(address);
    }

    public void enterState(String state) {
        logger.info("Entered state field : " + state);
        State.sendKeys(state);
    }

    public void selectRecruiterType(String recruiterType) {
        logger.info("select recruiter type option : " + recruiterType);
        selectByVisibleTextFromDropDown(RecruiterType, recruiterType);
    }

    public void scrollUpToHeader() {
        JavascriptExecutor js = (JavascriptExecutor) getThreadDriver();
        js.executeScript("window.scrollBy(0,-250)", "");
    }

    public void logoutDirectly() {
        getDriverWithUrl(WebURLHelper.getWebUrl(), WebURLHelper.getLoggedOutUrl());
        webDriverWaitContainsUrl(WebURLHelper.getHiringUrl());
    }

    public void verifyKeywordsBuilderTextAreaInput(String text) {
        Keywords.sendKeys("");
        logger.info("text in keywords builder text area input is : " + KeywordsBuilderTextareaInput.getText());
        Assert.assertNull(KeywordsBuilderTextareaInput.getText());
    }

    public void verifyBasicSearchKeywords(String text) {
        Keywords.sendKeys("");
        logger.info("text in basic search keywords is : " + Keywords.getText());
        Assert.assertNull(Keywords.getText());
    }

    public void clickOnPostJobsButton() {
        logger.info("Clicking on Post Jobs button ");
        clickOnElement(PostJobsButton);
    }

    public void clickOnLink(String link) {
        logger.info("Clicking on hyper link " + link);
        String xpathString = String.format("//a[text()='%s']", link);
        clickOnElement(By.xpath(xpathString));
    }

    public void clickOnVideoPlayButton(String iframe) {
        waitFor(1);
        if (iframe.contains("No")) {
            scrollDown(1500, 1500);
            WebElement element = getThreadDriver().findElement(By.xpath("//*[text()='Search Builder Tips']/..//iframe"));
            getThreadDriver().switchTo().frame(element);
            logger.info("moving to iframe ");
            //waitUntilElementToBeClickable(VideoPlayButton,5);
        } else {
            String iframeId = "iframe-" + iframe;
            logger.info("moving to iframe " + iframeId);
            WebElement Element = getThreadDriver().findElement(By.id(iframeId));
            getThreadDriver().switchTo().frame(Element);
            //waitUntilElementToBeClickable(VideoPlayButton, 5);
        }
        waitFor(1);
          clickOnElement(VideoPlayButton);
        waitUntilElementIsLocated(VideoPauseButton, 10);
    }

    public void clickOnVideoPauseButton(String iframe) {
        String iframeId = "iframe-" + iframe;
        logger.info("moving to iframe " + iframeId);
        clickOnElement(VideoPauseButton);
    }

    public String getTheDurationVideoPlayed() {
        String xpathDuration = "//*[@id=\"player\"]/div[*]/div[3]/div/div[3]/div[8]/div";
        String durationPlayed = getThreadDriver().findElement(By.xpath(xpathDuration)).getText();
        logger.info("duration of the time video played is : " + durationPlayed);
        return durationPlayed;
    }
}