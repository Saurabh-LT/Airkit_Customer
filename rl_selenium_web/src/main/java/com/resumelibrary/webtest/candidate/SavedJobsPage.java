package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavedJobsPage extends Utility {

    public SavedJobsPage()
    {
        PageFactory.initElements(getThreadDriver(),this);
    }
    private static final Logger logger = LogManager.getLogger(SavedJobsPage.class);

    @FindBy(id = "save_toggle_1")
    WebElement SaveToggle1;
    @FindBy(id = "save_toggle_2")
    WebElement SaveToggle2;
    @FindBy(id = "save_toggle_3")
    WebElement SaveToggle3;
    @FindBy(id = "saved_job_title_1")
    WebElement SavedJobLink;
    @FindBy(xpath= "//select[@class='table-bar-select']")
    WebElement DeleteJobButton;
    @FindBy(css = ".table-actions-btn")
    WebElement ActionsLink;
    @FindBy(id = "saved-jobs-btn")
    WebElement SavedJobsButton;
    @FindBy(css= ".basket-delete")
    WebElement SavedJobsBasketDeleteButton;
    @FindBy(id = "apply_now_1 partner-job-click-event")
    WebElement ApplyNowPartnerJobClickEvent;
    @FindBy(xpath = "//label/input[@name='table_select_all']")
    WebElement allSavedJobsCheckBox;

    public void clickOnSaveToggle1() {
        logger.info("Clicking on save button " );
        clickOnElement(SaveToggle1);
        String text = getThreadDriver().findElement(By.id("saved-jobs-btn")).getText();
        waitUntilTextToBePresent(SavedJobsButton,"Saved Jobs (1)");
        logger.info("After clicking save button, saved jobs basket text: " + text );
    }

    public void clickOnSaveToggle2() {
        logger.info("Clicking on save button " );
        clickOnElement(SaveToggle2);
        waitFor(1);
    }

    public void clickOnSaveToggle3() {
        logger.info("Clicking on save button " );
        clickOnElement(SaveToggle3);
        waitFor(1);
    }

    public void clickOnSavedJobLink() {
        logger.info("Clicking on saved job link " );
        clickOnElement(SavedJobLink);
    }

    public void clickOnDeleteJobButton() {
        logger.info("Clicking on delete button  " );
        selectByValueFromDropDown(DeleteJobButton,"Delete");
    }

    public void clickOnActionsLink() {
        logger.info("Clicking on actions link  " );
        clickOnElement(ActionsLink);
        waitFor(1);
    }
    public boolean selectAllSavedJobs() {
        logger.info("Selecting all the saved jobs " );
        boolean flag=false;
        try {
            clickOnElementWithJS(allSavedJobsCheckBox);
            waitFor(1);
            flag = true;
        }catch (Exception e) {

        }
        return flag;
    }

    public void mouseHoverToSavedJobs() {
        logger.info("Mouse hover to saved jobs " );
        mouseHoverToElement(SavedJobsButton);
        waitFor(1);
    }

    public void clickOnSavedJobButton() {
        logger.info("Clicking on Saved job button " );
        clickOnElement(SavedJobsButton);
        waitFor(1);
    }

    public void clickOnSavedJobsBasketDeleteButton() {
        logger.info("Clicking on delete button from basket  " );
        clickOnElement(SavedJobsBasketDeleteButton);
        waitFor(1);
    }

    public void clickOnApplyNowPartnerJobClickEvent() {
        logger.info("Clicking on Apply now link ");
        clickOnElement(ApplyNowPartnerJobClickEvent);
        waitFor(1);
    }
}