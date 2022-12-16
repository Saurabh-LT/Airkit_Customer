package com.resumelibrary.webtest.client;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class ResumeSearchPage extends Utility {

    public ResumeSearchPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(ResumeSearchPage.class);

    @FindBy(id = "save-search-submit-btn")
    WebElement SaveSearchSubmitBtn;
    @FindBy(id = "saved_search_name")
    WebElement SavedSearchName;
    @FindBy(id = "saved-search-delete-btn")
    WebElement SavedSearchDeleteBtn;
    @FindBy(id = "p_saved_search_action_1")
    WebElement PSavedSearchAction1;
    @FindBy(id = "run_saved_search_1")
    WebElement RunSavedSearch1;
    @FindBy(id = "delete_saved_search")
    WebElement DeleteSavedSearch;
    @FindBy(id = "saved-candidates-search-name-asc")
    WebElement SavedCandidatesSearchNameAsc;
    @FindBy(id = "saved-candidates-search-name-desc")
    WebElement SavedCandidatesSearchNameDesc;
    @FindBy(id = "saved-candidates-search-keywords-desc")
    WebElement SavedCandidatesSearchKeywordsDesc;
    @FindBy(id = "saved-candidates-search-keywords-asc")
    WebElement SavedCandidatesSearchKeywordsAsc;
    @FindBy(id = "my-searches-run-btn")
    WebElement MySearchesRunBtn;
    @FindBy(id = "location")
    WebElement Location;
    @FindBy(id = "tab-saved-searches")
    WebElement TabSavedSearches;
    @FindBy(xpath = "//*[@id=\"panel-saved-searches\"]/div[1]/div[2]/p[1]/text()[1]")
    WebElement Displaying1to1;
    @FindBy(id = "keywords")
    WebElement KeywordsBuilderTextArea;
    @FindBy(id = "keywords_builder_textarea_input")
    WebElement KeywordsBuilderTextareaInput;
    @FindBy(id = "preview_locked_resume_2")
    WebElement PreviewLockedResume1;
    @FindBy(id = "unlocked-resume")
    WebElement UnlockedResume;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[9]/div[2]/div")
    WebElement ViewContactDetails;
    @FindBy(id = "table_action_search_btn")
    WebElement TableActionSearchBtn;
    @FindBy(id = "alert_name")
    WebElement AlertName;
    @FindBy(id = "create_alert_submit")
    WebElement CreateAlertSubmit;
    @FindBy(xpath = "//div[@class=\"view-resume-options top-options\"]/ul/li[*]/a/span")
    WebElement PrintResume;
    @FindBy(id = "report-this-resume")
    WebElement ReportResume;
    @FindBy(id = "unlocked_only")
    WebElement UnlockedOnly;
    @FindBy(id = "keywords")
    WebElement Keywords;
    @FindBy(id = "email_candidates_amount")
    WebElement EmailCandidatesAmount;
    @FindBy(id = "message")
    WebElement Message;
    @FindBy(xpath = "//*[@id='email-top-candidates-form']/div[5]/button[1]")
    WebElement PreviewButton;
    @FindBy(id = "updated_on")
    WebElement ActiveWithin;
    @FindBy(xpath = "//input[@id='subject']")
    WebElement Subjecteditbox;
    @FindBy(xpath = "//*[@id=\"resume-search-form\"]/div[5]/a[1]")
    WebElement MySearchesLink;
    @FindBy(id = "wd-submit")
    WebElement SearchResumeBtn;
    @FindBy(css = ".popular-searches-link")
    WebElement PopularSearchesLink;
    @FindBy(id = "clear_form")
    WebElement ResetForm;
    @FindBy(id = "basic")
    WebElement Basic;
    @FindBy(id = "builder")
    WebElement Builder;
    @FindBy(id = "table_action_deactivate_btn")
    WebElement TableActionDeactivateButton;
    @FindBy(id = "table_action_activate_btn")
    WebElement TableActionActivateButton;
    @FindBy(xpath = "//*[@id=\"resume-search-results\"]/div[1]/h3")
    WebElement DisplayingText;
    @FindBy(id = "actions_btn_1")
    WebElement ActionsButtonOne;
    @FindBy(xpath = "//*[@id=\"search\"]/div/div[1]/table/tbody/tr[@class=\" \"]")
    List<WebElement> ActiveInAlertTable;


    public void enterSubject(String Subject) {
        logger.info("entering the Subject name : " + Subject);
        Subjecteditbox.sendKeys(Subject);
    }

    public void enterMessage(String message) {
        logger.info("entering the Message : " + message);
        Message.sendKeys(message);
    }

    public void enterSavedSearchName(String searchName) {
        logger.info("entering the search name : " + searchName);
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(2);
        }
        SavedSearchName.sendKeys(searchName);
    }

    public void clickOnSaveSearch() {
        logger.info("click on save search : ");
        clickOnElement(SaveSearchSubmitBtn);
    }

    public void clickOnSaveSearchDeleteBtn() {
        logger.info("click on  SavedSearchDeleteBtn : ");
        clickOnElement(SavedSearchDeleteBtn);
    }

    public void clickOnSavedSearchActionsOne() {
        logger.info("click on  PSavedSearchAction1 : ");
        clickOnElement(PSavedSearchAction1);
    }

    public void clickOnRunSavedSearchOne() {
        logger.info("click on  RunSavedSearch1 : ");
        clickOnElement(RunSavedSearch1);
    }

    public void clickOnDeleteSavedSearch() {
        logger.info("click on  delete_saved_search : ");
        clickOnElement(DeleteSavedSearch);
        waitFor(2);
    }

    public void sortByNameInAscendingOrder() {
        logger.info("sort the saved search results in ascending order by name : ");
        clickOnElement(SavedCandidatesSearchNameAsc);
        waitFor(2);
    }

    public void sortByNameInDescendingOrder() {
        logger.info("sort the saved search results in descending order by name : ");
        clickOnElement(SavedCandidatesSearchNameDesc);
        waitFor(2);
    }

    public void sortByKeywordsInDescendingOrder() {
        logger.info("sort the saved search results in descending order by keyword : ");
        clickOnElement(SavedCandidatesSearchKeywordsDesc);
        waitFor(2);
    }

    public void sortByKeywordsInAscendingOrder() {
        logger.info("sort the saved search results in ascending order by keyword : ");
        clickOnElement(SavedCandidatesSearchKeywordsAsc);
        waitFor(2);
    }

    public String verifyLocationField(String locationText) {
        String textOnLocationField = Location.getAttribute("value");
        logger.info("text on location field is   : " + textOnLocationField);
        return textOnLocationField;
    }

    public void clickOnTabSavedSearches() {
        logger.info("click on  Tab Saved Searches : ");
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(2);
        }
        clickOnElement(TabSavedSearches);
    }

    public void clickOnRunSearch() {
        logger.info("click on  Run Search button : ");
        clickOnElement(MySearchesRunBtn);
    }

    public String verifyButtonText(String buttonText) {
        String text = getDisplayedElement(buttonText).getText();
        //  String text = MySearchesRunBtn.getText();
        logger.info("verify Button Text found   : " + text);
        return text;
    }

    public void enterSearchBuilderKeywordsTextAreaWithToAutocomplete(String text) {
        logger.info("Entered keyword ");
        sendTextToElement(KeywordsBuilderTextareaInput, text);
    }

    public void hoverToAutocomplete(String autoCompleteText) {
        waitFor(2);
        List<WebElement> optionsToSelect = getThreadDriver().findElements(By.xpath("//ul[@id='ui-id-3']/li/a/span"));
        for (int i = 0; i < optionsToSelect.size(); i++) {
            logger.info("finding the element  " + optionsToSelect.get(i).getText());
            System.out.println("sysout finding the element  " + optionsToSelect.get(i).getText());
            if (optionsToSelect.get(i).getText().equalsIgnoreCase(autoCompleteText)) {
                logger.info("Trying to select: " + optionsToSelect.get(i).getText());
                mouseHoverToElement(optionsToSelect.get(i));
                mouseHoverToElement(optionsToSelect.get(i + 1));
                mouseHoverToElement(optionsToSelect.get(i));
                // clickOnElement(option);
                break;
            }
        }
     //  waitUntilElementIsLocated(getThreadDriver().findElement(By.xpath("//*[contains(.,'"+autoCompleteText+"')]")),10);
      //  mouseHoverToElement(getThreadDriver().findElement(By.xpath("//*[contains(.,'"+autoCompleteText+"')]")));
    }

    public void mouseHoverResumeUnlocked() {
        mouseHoverToElement(UnlockedResume);
    }

    public void verifyText(String text1, String text2) {
        WebElement element;
        int row = 1;
        logger.info("finding the web element with text1 : " + text1 + "and text2 :" + text2);
        List<WebElement> contactDetails = getThreadDriver().findElements(By.xpath("//*[@id=\"main\"]/div/div[9]/div[2]/div"));
        logger.info("Number of elements : " + contactDetails.size());
        for (WebElement contact : contactDetails) {
            element = getThreadDriver().findElement(By.xpath("//*[@id=\"main\"]/div/div[9]/div[2]/div[" + String.valueOf(row) + "]"));
            logger.info("web element with text  : " + element.getText());
            if (contact.getText().contains(text1) && contact.getText().contains(text2)) {
                logger.info("found the web element with text1 and text 2 : " + contact.getText());
                break;
            }
        }
    }

    public void verifyValueInSearchBuilderKeywords(String text) {
        logger.info("verifying the value in Search Builder Keywords : " + text);
        String InputValue = getThreadDriver().findElement(By.id("builder_keywords")).getAttribute("value");
        logger.info("the value in Search Builder Keywords : " + InputValue);
        Assert.assertEquals(InputValue, text);
    }

    public void verifyElementIsDisabled(String text) {
        boolean isElementDisplayed = isElementDisplay(text);
        logger.info("Web element is displayed : " + isElementDisplayed);
        Assert.assertFalse(isElementDisplayed,"[---> " + text + " is not displayed <---]");
    }

    public void clickOnTableActionSearch() {
        logger.info("click on  Run Search button in the list of displayed alerts:");
        clickOnElement(TableActionSearchBtn);
    }

    public void enterAlertName(String alertName) {
        logger.info("entering the alert name : " + alertName);
        AlertName.sendKeys(alertName);
    }

    public void clickOnCreateAlert() {
        logger.info("click on  Create Alert Button");
        clickOnElement(CreateAlertSubmit);
        waitFor(2);
    }

    public void findElementsWithClass(String elementClass) {
        logger.info("finding elements with class : " + elementClass);
        List<WebElement> elements = getThreadDriver().findElements(By.cssSelector(elementClass));
        logger.info("elements : " + Arrays.toString(elements.toArray()));
        Assert.assertTrue(elements.size() > 0);
    }

//    public void hoverToAutoCompleteAndSelectAll(String text)   {
//        List<WebElement> optionsToSelect = getThreadDriver().findElements(By.tagName("span"));
//        for (int i=0 ;i< optionsToSelect.size();i++) {
//
//            if (optionsToSelect.get(i).getText().equalsIgnoreCase(text)) {
//                logger.info("Trying to select: " + optionsToSelect.get(i).getText());
//                mouseHoverToElement(optionsToSelect.get(i));
//                mouseHoverToElement(optionsToSelect.get(i+1));
//                mouseHoverToElement(optionsToSelect.get(i));
//                break;
//            }
//        }
//    }

    public void verifyElementIsEnabled(String text) {
        switch (text) {
            case "Print Resume":
                Assert.assertTrue(isElementDisplay(PrintResume),"[---> " + PrintResume + " is not displayed <---]");
                break;
            case "Report Resume":
                Assert.assertTrue(isElementDisplay(ReportResume),"[---> " + ReportResume + " is not displayed <---]");
                break;
        }
        Assert.assertTrue(isElementDisplay(PrintResume),"[---> " + PrintResume + " is not displayed <---]");
    }

    public boolean verifyTableActionButtonIsDisabled(String text) {
        switch (text) {
            case "deactivate":
                logger.info("Has deactivate button been disabled? = : " + hasDisabledClass(TableActionDeactivateButton));
                Assert.assertTrue(hasDisabledClass(TableActionDeactivateButton),"[---> Deactivate button is not disabled <---]");
                break;
            case "reactivate":
                logger.info("Has activate button been disabled? = : " + hasDisabledClass(TableActionActivateButton));
                Assert.assertTrue(hasDisabledClass(TableActionActivateButton),"[---> Deactivate button is not disabled <---]");
                break;
        }
        return true;
    }

    public void clickOnActionsButtonOne() {
        logger.info("Clicking on actions button one");
        clickOnElement(ActionsButtonOne);
        waitFor(1);
    }

    public void toggleActionButtonStatus() {
        if (hasDisabledClass(TableActionDeactivateButton)) {
            logger.info("as deactivated is disabled then click activate:");
            clickOnElementUsingText("Activate");
            waitFor(1);
            clickOnActionsButtonOne();
            logger.info("testing disabled is set for reactivate");
            verifyTableActionButtonIsDisabled("reactivate");
        } else {
            logger.info("as activated is disabled click Deactivate:");
            clickOnElementUsingText("Deactivate");
            waitFor(1);
            clickOnActionsButtonOne();
            logger.info("testing disabled is set for deactivate");
            verifyTableActionButtonIsDisabled("deactivate");
        }
    }

    public void checkShowMeUnlockedCandidatesOnly() {
        logger.info("click on check show me unlocked Candidates Only:");
        clickOnElement(UnlockedOnly);
    }

    public void mouseHoverToResumeSearch() {
        WebElement resumeSearch = getThreadDriver().findElement(By.xpath("//*[@id=\"resume-search\"]/header/div/nav/ul/li[3]/a"));
        waitUntilElementIsLocated(resumeSearch, 10);
        logger.info("found element with name :" + resumeSearch.getText());
        mouseHoverToElement(resumeSearch);
    }

    public void selectEmailCandidatesAmountFromList() {
        logger.info("Select email candidate amount from list");
        selectByIndexFromDropDown(EmailCandidatesAmount, 1);
    }

    public void selectRelatedJobsFromList(String text) {
        clickOnId("job");
        List<WebElement> optionsToSelect = getThreadDriver().findElements(By.xpath("//*[@id='ui-id-4']/li/a"));
        for (WebElement option : optionsToSelect) {
            if (option.getText().contains(text)) {
                logger.info("Trying to select: " + option.getText());
                clickOnElement(By.xpath("//*[@id='ui-id-4']/li/a[contains(text(),'" + text + "')]"));
                break;
            }
        }
    }

    public String getTextFromMessageTextField(String text) {
        logger.info("Getting message from text field ");
        return getTextFromElement(Message).replaceAll("\n", " ");
    }

    public void clickOnPreviewBtn() {
        logger.info("clicking on preview button ");
        clickOnElement(PreviewButton);
    }

    public void selectActiveWithinFromList(String text) {
        logger.info("Select active within  from list");
        selectByVisibleText(ActiveWithin, text);
    }

    public String getTextFromKeywordsBuilderTextArea() {
        logger.info("Getting text from keywords builder text area field ");
        return getTextFromElement(KeywordsBuilderTextArea);
    }

    public String getTextFromKeywords() {
        logger.info("Getting text from basic search keywords field ");
        return getTextFromElement(Keywords);
    }

    public void clickOnMySearchesLink() {
        logger.info("Clicking on my searches link ");
        clickOnElement(MySearchesLink);
    }

    public void clickOnSearchResumes() {
        clickOnElement(SearchResumeBtn);
        logger.info("Clicking on Search Resumes button ");
    }

    public void clickOnBasic() {
        clickOnElement(Basic);
        logger.info("Clicking on Basic tab ");
    }

    public void clickOnBuilder() {
        clickOnElement(Builder);
        logger.info("Clicking on Builder tab ");
    }

    public void deleteSavedSearch() {
        if (isElementOrTextDisplayed("Keywords")) {
            PSavedSearchAction1.click();
            clickOnElement(DeleteSavedSearch);
            clickOnElement(SavedSearchDeleteBtn);
            waitFor(1);
        }
    }

    public void deactivateAllActiveAlerts() {
        int activeAlerts = ActiveInAlertTable.size();
        logger.info("Number of active rows in this table : " + activeAlerts);
        for (int i = 0; i < activeAlerts; i++) {
            clickOnActionsButtonOne();
            if (!hasDisabledClass(TableActionDeactivateButton)) {
                clickOnElementUsingText("Deactivate");
            }
        }
    }

    public void clickOnPopularSearchesLink() {
        logger.info("Click on popular searches link ");
        clickOnElement(PopularSearchesLink);
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(2);
        }
    }

    public void clickOnResetFormLink() {
        logger.info("Click on reset form link ");
        clickOnElement(ResetForm);
    }

    public void verifyDisplayingText(String displayingText) {
        waitUntilElementIsLocated(DisplayingText, 15);
        String textOnElement = DisplayingText.getText();
        logger.info("text to be verified :" + displayingText + "against text :" + textOnElement);
        Assert.assertTrue(displayingText.contains(textOnElement),"[---> " + displayingText + " is not displayed <---]");
    }
    public void clickOnLinkFromKeywordsSearchResults(String linkName) throws InterruptedException {
        waitUntilElementIsLocated(getThreadDriver().findElement(By.xpath("//div[@class='synonym-chips']//span[contains(text(),'" + linkName + "')]")), 15);
        if(linkName.equals("+ Add all terms".trim()))
        {
            clickOnElement(By.xpath("//div[@class='synonym-chips']/span[contains(text(),'" + linkName + "')]"));
        }
        else {
            clickOnElement(By.xpath("//div[@class='synonym-chips']//span[contains(text(),'" + linkName + "')]"));
        }
    }
}