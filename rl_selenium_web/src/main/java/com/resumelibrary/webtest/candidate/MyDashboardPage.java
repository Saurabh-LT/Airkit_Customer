package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.utilities.WebURLHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyDashboardPage extends Utility {

    public MyDashboardPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(MyDashboardPage.class);

    @FindBy(xpath = "//*[@id=\"cand-home-matches\"]/div[1]/a[1]")
    WebElement ViewLink;
    @FindBy(id = "apply-now-btn-1")
    WebElement ApplyNowLink;
    @FindBy(id = "nav_my_account")
    WebElement MyAccountLink;
    @FindBy(id = "candhome-tab-ra")
    WebElement RecentlyAppliedLink;
    @FindBy(id = "resume_review_side_banner")
    WebElement ResumeReviewSideBanner;
    @FindBy(id = "search_on_go_banner")
    WebElement SearchOnGoBannerLink;
    @FindBy(id = "apply-send-application")
    WebElement SendApplicationButton;
    @FindBy(id = "hide-expired-applications")
    WebElement HideExpiredApplicationLabel;
    @FindBy(xpath = "//nav[@label=\"Site Navigation\"]/ul/li[@id='user-nav']/a")
    WebElement accountLink;

    String linksUnderMyAccount = "//ul[@class='cand-sidebar-links']/li/a";
    String linksOnHeaderBanner = "//nav[@label=\"Site Navigation\"]/ul/li/a";
    String linksUnderAccountDropDown = "//li[@id='user-nav']/ul/li/a";

    public void clickOnViewLink() {
        logger.info("Clicking on view link");
        clickOnElement(ViewLink);
    }

    public void clickOnApplyNowLink() {
        logger.info("Clicking on apply now link");
        clickOnElement(ApplyNowLink);
        waitUntil(WebURLHelper.getJobApplyUrl());
    }

    public void clickOnMyAccountLink() {
        logger.info("Clicking on my account link");
        clickOnElement(MyAccountLink);
    }

    public void clickOnRecentlyAppliesLink() {
        logger.info("Clicking on recently applied link");
        reloadPage();
        clickOnElement(RecentlyAppliedLink);
    }

    public void clickOnResumeReviewSideBanner() {
        logger.info("Clicking on resume review side banner");
        clickOnElement(ResumeReviewSideBanner);
        waitFor(1);
    }

    public void clickOnSearchOnGoBannerLink() {
        logger.info("Clicking on search on go banner");
        clickOnElement(SearchOnGoBannerLink);
    }

    public void clickOnSendApplicationButton() {
        logger.info("Clicking on send application button" );
        clickOnElement(SendApplicationButton);
    }

    public String getTextFromHideExpiredApplicationsLabel() {
        logger.info("Verifying text ");
        return getTextFromElement(HideExpiredApplicationLabel);
    }

    public void clickOnHideExpiredApplicationCheckbox() {
        logger.info("Clicking on hide expired application checkbox ");
        clickOnElement(HideExpiredApplicationLabel);
    }

    public void clickOnUnderMyDashboardSection(String linkName) {
        logger.info("Clicking on the links under My Dashboard section");
        clickOnElement(By.xpath(linksUnderMyAccount + "[contains(text(),'" + linkName + "')]"));
    }

    public void clickLinkOnHeaderBanner(String linkName) {
        logger.info("Clicking on the links under My Dashboard section");
        if (linkName.equals("My Applications") || linkName.equals("My Settings") || linkName.equals("My Email Preferences") || linkName.equals("Logout")) {
            logger.info(linkName);
            String[] locator={"xpath","//nav[@label='Site Navigation']/ul/li[@id='user-nav']/a"};
            mouseHoverJScript(getElement(locator,20));
            clickOnElement(By.xpath(linksUnderAccountDropDown + "[contains(text(),'" + linkName + "')]"));
        } else {
            clickOnElement(By.xpath(linksOnHeaderBanner + "[contains(text(),'" + linkName + "')]"));
        }
        waitForPageLoad();
    }

    public void clickOnEditButton(String editDetails) {
        logger.info("Click on " + editDetails + " edit details ");
        WebElement editButton = getThreadDriver().findElement(By.xpath("//h2[text()='" + editDetails + "']/following-sibling::button[1]"));
        if (editButton.getText().equals("Edit")){
            clickOnElement(editButton);
        }
    }
}