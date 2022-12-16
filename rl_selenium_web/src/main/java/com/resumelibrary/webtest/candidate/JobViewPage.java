package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JobViewPage extends Utility {

    public JobViewPage()
    {
        PageFactory.initElements(getThreadDriver(),this);
    }
    private static final Logger logger = LogManager.getLogger(JobViewPage.class);

    @FindBy(id = "save-job")
    WebElement SaveButton;
    @FindBy(xpath = "//*[@class='btn blue-btn']")
    WebElement ViewButton;
    @FindBy(id = "recent_job_title_1")
    WebElement RecentJobTitle;
    @FindBy(id = "job_title_1")
    WebElement JobTitle1;

    public void saveButtonIsDisplay() {
        logger.info("Verifying that save button is display  ");
        Assert.assertTrue(verifyThatElementIsDisplayed(SaveButton), "[---> " + SaveButton + " is not visible <---]");
    }

    public void clickOnViewButton() {
        logger.info("Clicking on view button ");
        clickOnElement(ViewButton);
    }

    public void clickOnRecentJobTitle() {
        logger.info("Clicking recent job title ");
        clickOnElement(RecentJobTitle);
    }

    public void clickOnJobTitle1() {
        logger.info("Clicking recent job title ");
        clickOnElement(JobTitle1);
    }
}