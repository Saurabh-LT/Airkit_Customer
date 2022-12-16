package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.utilities.WebURLHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResourcesPage extends Utility {

    public ResourcesPage()
    {
        PageFactory.initElements(getThreadDriver(),this);
    }
    private static final Logger logger = LogManager.getLogger(ResourcesPage.class);

    @FindBy(xpath = "//*[@label='Site Navigation']/ul/li[5]/a")
    WebElement ResourcesNavigationMenu;

    @FindBy(xpath = "//p[@class='sub-nav-p']")
    WebElement EmailUSText;

    @FindBy(xpath = "//img[@src='/images/resources-blog-search-resumes.gif']")
    WebElement ImageResumeSearch;

    @FindBy(xpath = "//img[@src='/images/resources-blog-post-jobs.gif']")
    WebElement ImagePostAJob;

    public String verifyTextMessageEmailUs() {
        logger.info("verifying the text :" );
        return getTextFromElement(EmailUSText);
    }

    public void mouseHoverResourcesMenu() {
        waitFor(2);
        mouseHoverToElement(ResourcesNavigationMenu);
    }

    public void verifyResourcesSwitchBanner(String text) {
        logger.info("validate resources-switch-banner is displayed");
        waitFor(2);
        if ("Resume Search".equals(text)) {
            logger.info("clicking on Resume Search image");
            clickOnElement(ImageResumeSearch);
        } else if ("Post A Job".equals(text)) {
            logger.info("clicking on Post A job now image");
            waitUntilElementIsLocated(ImagePostAJob,30);
            clickOnElement(ImagePostAJob);
        }
    }

    public void onPage(String url) {
            logger.info("web page url is : " + WebURLHelper.getWebUrl() + url );
            getDriverWithUrl(WebURLHelper.getWebUrl(), url);
        }
}