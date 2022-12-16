package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPreferencesPage extends Utility {

    public EmailPreferencesPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(EmailPreferencesPage.class);

    @FindBy(id = "create_alert_q")
    WebElement CreateAlertKeyword;
    @FindBy(id = "create_alert_loc")
    WebElement CreateAlertLocation;
    @FindBy(id = "job_instant")
    WebElement JobApplicationConfirmationIndividual;
    @FindBy(id = "job_combined")
    WebElement JobApplicationConfirmationCombined;
    @FindBy(id = "ja_individual")
    WebElement JobAlertsIndividual;
    @FindBy(id = "ja_combined")
    WebElement JobAlertsCombined;
    @FindBy(id = "email_unsub_type_1")
    WebElement EmailUnSubType1;
    @FindBy(id = "email_unsub_type_2")
    WebElement EmailUnSubType2;
    @FindBy(id = "update_profile")
    WebElement UpdateProfileBtn;
    @FindBy(id = "email_type_all_label")
    WebElement EmailTypeAllLabel;
    @FindBy(id = "email_type_2")
    WebElement JobAlertsCheckBox;
    @FindBy(id = "email_type_1")
    WebElement UpdatesCheckBox;


    public void enterKeywordToCreateJobAlert(String keyword) {
        logger.info("Entered keyword to create job alert " + keyword);
        CreateAlertKeyword.sendKeys(keyword + System.nanoTime());
    }

    public void enterLocationToCreateJobAlert(String location) {
        logger.info("Entered location to create job alert " + location);
        CreateAlertLocation.sendKeys(location);
    }

    public void clickOnUpdateProfileButton() {
        logger.info("Clicking on update profile button");
        clickOnElement(UpdateProfileBtn);
    }

    public boolean verifyCheckboxIsNotSelected(String id) {
        boolean isSelected = getThreadDriver().findElement(By.id(id)).isSelected();
        logger.info("Element is selected " + isSelected);
        return isSelected;
    }

    public boolean verifyJobAlertsIsSelected() {
        boolean isSelected = JobAlertsCheckBox.isSelected();
        logger.info("Element job alerts checkbox  is selected " + isSelected);
        return isSelected;
    }

    public boolean verifyUpdatesIsSelected() {
        boolean isSelected = UpdatesCheckBox.isSelected();
        logger.info("Element updates check box is selected " + isSelected);
        return isSelected;
    }


    public void untickJobAlerts() {
        logger.info("Clicking on Job alerts check box ");
        clickOnElement(EmailUnSubType1);

    }

    public void untickUpdates() {
        logger.info("Clicking on updates check box ");
        clickOnElement(EmailUnSubType2);

    }

    public boolean verifyUnsubscribeAllEmailsIsSelected() {
        return verifyCheckboxIsNotSelected("email_type_all");

    }

    public void verifyUnsubscribeAllEmails() {
        logger.info("Clicking on EmailTypeAll check box ");
        clickOnElement(EmailTypeAllLabel);
    }

    public void saveToDefaultSelections() {
        logger.info("Clicking on job alerts check box ");
        clickOnElement(EmailUnSubType1);
        logger.info("Clicking on updates check box ");
        clickOnElement(EmailUnSubType2);
        clickOnElement(UpdateProfileBtn);

    }

    public void tickJobAlerts() {
        logger.info("Clicking on job alerts check box ");
        clickOnElement(EmailUnSubType1);
    }

    public void tickUpdate() {
        logger.info("Clicking on updates check box ");
        clickOnElement(EmailUnSubType2);
    }

    public void clickOnJobApplicationConfirmIndividual() {
        logger.info("Clicking on Job application confirmation individual button");
        clickOnElementWithJS(JobApplicationConfirmationIndividual);
    }

    public void clickOnJobApplicationConfirmCombined() {
        logger.info("Clicking on Job application confirmation combined button");
        clickOnElementWithJS(JobApplicationConfirmationCombined);
    }

    public void clickOnJobJobAlertsIndividual() {
        logger.info("Clicking on Job job alerts individual button ");
        clickOnElementWithJS(JobAlertsIndividual);
    }

    public void clickOnJobJobAlertsCombined() {
        logger.info("Clicking on Job job alerts Combined button ");
        clickOnElementWithJS(JobAlertsCombined);
    }
}