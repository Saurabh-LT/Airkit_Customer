package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverLetterPage extends Utility {

    public CoverLetterPage()
    {
        PageFactory.initElements(getThreadDriver(),this);
    }
    private static final Logger logger = LogManager.getLogger(CoverLetterPage.class);

    @FindBy(xpath = "//a[@class='c-aside-profile__edit']")
    WebElement EditProfileLink;
    @FindBy(xpath = "//a[@class='c-aside-stats__icon letters']")
    WebElement ModifyCoverLetterLink;
    @FindBy(xpath = "//a[@class='c-aside-stats__icon jobalerts']")
    WebElement JobAlertLink;
    @FindBy(xpath = "//a[@class='c-aside-stats__icon apps']")
    WebElement ApplicationsLink;
    @FindBy(xpath = "//a[@class='c-aside-stats__icon jobs']")
    WebElement SavedJobLinks;
    @FindBy(id = "ch-mr")
    WebElement ModifyProfileLinks;
    @FindBy(id = "ch-ep")
    WebElement EmailPreferencesLinks;
    @FindBy(id = "cover_letter")
    WebElement EditYourCoverLetterField;
    @FindBy(id = "form-reset")
    WebElement ResetButton;
    @FindBy(xpath = "//*[@value='Save Changes']")
    WebElement SaveChangesButton;
    @FindBy(id = "add-cover-letter-toggle")
    WebElement AddCoverLetterToggle;

    public void clickOnEditProfileLink() {
        logger.info("Clicking on Edit Profile link" + EditProfileLink.toString());
        clickOnElement(EditProfileLink);
    }

    public void clickOnMyCoverLettersLink() {
        logger.info("Clicking on modify cover letter link" + ModifyCoverLetterLink.toString());
        clickOnElement(ModifyCoverLetterLink);
    }

    public void clickOnJobAlertLink() {
        waitForPageLoad();
        if(!getBrowserName().contains("Safari")) {
            logger.info("Clicking on job alert link" + JobAlertLink.toString());
        }
        clickOnElement(JobAlertLink);
    }

    public void clickOnApplicationsLink() {
        logger.info("Clicking on application link" + ApplicationsLink.toString());
        clickOnElement(ApplicationsLink);
    }

    public void clickOnSavedJobLinks() {
        logger.info("Clicking on saved job link" + SavedJobLinks.toString());
        clickOnElement(SavedJobLinks);
    }

    public void clickOnModifyProfileLinks() {
        logger.info("Clicking on modify Profile link" + ModifyProfileLinks.toString());
        clickOnElement(ModifyProfileLinks);
    }

    public void clickOnEmailPreferencesLinks() {
        logger.info("Clicking on email preferences link" + EmailPreferencesLinks.toString());
        clickOnElement(EmailPreferencesLinks);
    }

    public void EnterTextToEditYourCoverLetterField(String text) {
        logger.info("Entered text to edit your cover letter field" + EditYourCoverLetterField.toString());
        clearTextFromField(EditYourCoverLetterField);
        EditYourCoverLetterField.sendKeys(text);
    }

    public void clickOnResetButton(){
        logger.info("Clicking on reset button"+ResetButton.toString());
        clickOnElement(ResetButton);
    }

    public void clickOnSaveChangesButton(){
        logger.info("Clicking on save changes button"+SaveChangesButton.toString());
        clickOnElement(SaveChangesButton);
    }

    public void clickOnAddCoverLetterToggle(){
        logger.info("Clicking on add cover letter toggle"+AddCoverLetterToggle.toString());
        clickOnElement(AddCoverLetterToggle);
    }
}