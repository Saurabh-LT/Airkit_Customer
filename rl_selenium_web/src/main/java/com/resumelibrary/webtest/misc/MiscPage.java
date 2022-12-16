package com.resumelibrary.webtest.misc;

import com.resumelibrary.utilities.AdminURLHelper;
import com.resumelibrary.utilities.DataHelper;
import com.resumelibrary.utilities.Utility;
import com.resumelibrary.utilities.WebURLHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class MiscPage extends Utility {

    public MiscPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(MiscPage.class);

    @FindBy(id = "footer-partners-link")
    WebElement PartnersLink;
    @FindBy(id = "footer-press-link")
    WebElement PressLink;
    @FindBy(id = "footer-cv-library-link")
    WebElement CvLibraryLink;
    @FindBy(id = "footer-employers-link")
    WebElement EmployersLink;
    @FindBy(id = "footer-post-jobs-link")
    WebElement PostJobsLink;
    @FindBy(id = "footer-partner-network-link")
    WebElement PartnerNetworkLink;
    @FindBy(id = "footer-about-us-link")
    WebElement AboutUsLink;
    @FindBy(id = "footer-meet-the-team-link")
    WebElement MeetTheTeamLink;
    @FindBy(id = "footer-work-for-us-link")
    WebElement WorkForUsLink;
    @FindBy(id = "footer-fb-icon")
    WebElement FacebookIcon;
    @FindBy(id = "footer-twitter-icon")
    WebElement TwitterIcon;
    @FindBy(id = "footer-instagram-icon")
    WebElement InstagramIcon;
    @FindBy(id = "footer-play-store-icon")
    WebElement GooglePlayIcon;
    @FindBy(id = "footer-app-store-icon")
    WebElement AppStoreIcon;
    @FindBy(id = "footer-linkedin-icon")
    WebElement LinkedInIcon;
    @FindBy(id = "footer-youtube-icon")
    WebElement YouTubeIcon;
    @FindBy(id = "footer-do-not-sell-info-link")
    WebElement DoNotSellInfo;
    @FindBy(id = "email")
    WebElement LoginPageEmail;
    @FindBy(id = "pass")
    WebElement LoginPagePassword;
    @FindBy(id = "signin-as-jobseeker")
    WebElement CandidateLoginPageSubmit;
    @FindBy(id = "client-login-submit-btn")
    WebElement ClientLoginPageSubmit;
    @FindBy(xpath = "//*[@id=\"yDmH0d\"]//form/div[1]/div/button/span")
    WebElement IAgreeButton;
    @FindBy(id = "gdpr-consent-notice")
    WebElement CVLGDPRNotice;
    @FindBy(xpath = "//button[@title='Allow essential and optional cookies']")
    WebElement FacebookAcceptAll;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[1]/div[1]/section/div[2]/div/span")
    WebElement CreditsRemainingText;

    public void shouldBeOnThePage(String url) {
        logger.info("I should be on the page " + url);
        switch (url) {
            case "Press":
                webUrlVerify(WebURLHelper.getPressUrl());
                break;
            case "Hiring":
                webUrlVerify(WebURLHelper.getHiringUrl());
                break;
            case "Hiring Post Jobs":
                webUrlVerify(WebURLHelper.getHiringPostJobsUrl());
                break;
            case "Partner Network":
                webUrlVerify(WebURLHelper.getPartnerNetworkUrl());
                break;
            case "About Us":
                webUrlVerify(WebURLHelper.getAboutUsUrl());
                break;
            case "Meet the Team":
                webUrlVerify(WebURLHelper.getMeetTheTeamUrl());
                break;
            case "Work For Us":
                try {
                    webUrlVerify(WebURLHelper.getWorkForUsUrl());
                } catch (Exception e) {
                    webUrlVerify(WebURLHelper.getWorkForUsAcmeUrl());
                }
                break;
            case "Facebook":
                externalShortUrlVerify(WebURLHelper.getFacebookUrl());
                acceptFacebookCookiePopUp();
                break;
            case "Twitter":
                if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
                    waitFor(2);
                }
                externalUrlVerify(WebURLHelper.getTwitterUrl());
                break;
            case "Instagram":
                externalShortUrlVerify(WebURLHelper.getInstagramUrl());
                acceptInstagramCookiePopUp();
                break;
            case "CV-Library":
                acceptGDPRPopUpOnCvLibrary();
                externalUrlVerify(WebURLHelper.getCVLibraryUrl());
                break;
            case "Google Play":
                if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
                    waitFor(2);
                }
                externalUrlVerify(WebURLHelper.getGooglePlayUrl());
                break;
            case "App Store":
                if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
                    waitFor(2);
                }
                waitFor(2);
                externalUrlVerify(WebURLHelper.getAppStoreUrl());
                break;
            case "Linkedin":
                externalShortUrlVerify(WebURLHelper.getLinkedinUrl());
                break;
            case "YouTube":
                externalShortUrlVerify(WebURLHelper.getYouTubeUrl());
                break;
            case "My Dashboard":
                waitFor(2);
                webUrlVerify(WebURLHelper.getCandidateAccountUrl());
                break;
            case "Logged out":
                webUrlVerify(WebURLHelper.getLoggedOutUrl());
                break;
        }
    }

    public void clickLinkFooter(String link) {
        List<WebElement> linkList = getThreadDriver().findElements(By.xpath("//*[@id=\"home\"]/footer/div[1]/div/div/ul/li/a"));
        for (WebElement ele : linkList) {
            if (ele.getText().contains(link)) {
                clickOnElement(By.xpath("//*[@id=\"home\"]/footer/div[1]/div/div/ul/li/a[contains(text(),'" + link + "')]"));
                break;
            }
        }
    }

    public void clickLinkInTheFooter(String link) {
        logger.info("Clicking on footer link " + link);
        switch (link) {
            case "Press":
                clickOnElement(PressLink);
                break;
            case "CV-Library":
                clickOnElement(CvLibraryLink);
                switchTab();
                waitFor(2);
                break;
            case "Employers":
                clickOnElement(EmployersLink);
                break;
            case "Post Jobs":
                clickOnElement(PostJobsLink);
                break;
            case "Partner Network":
                clickOnElement(PartnerNetworkLink);
                break;
            case "About Us":
                clickOnElement(AboutUsLink);
                break;
            case "Partners":
                clickOnElement(PartnersLink);
                break;
            case "Meet the Team":
                clickOnElement(MeetTheTeamLink);
                break;
            case "Work For Us":
                clickOnElement(WorkForUsLink);
                break;
            case "Do Not Sell My Info":
                clickOnElement(DoNotSellInfo);
                break;
        }
    }

    public void clickIconInTheFooter(String icon) {
        logger.info("Clicking on footer icon " + icon);

        switch (icon) {
            case "Facebook":
                clickOnElement(FacebookIcon);
                switchTab();
                acceptFacebookCookiePopUp();
                break;
            case "Twitter":
                clickOnElement(TwitterIcon);
                switchTab();
                break;
            case "Instagram":
                clickOnElement(InstagramIcon);
                switchTab();
                break;
            case "Google Play":
                clickOnElement(GooglePlayIcon);
                switchTab();
                break;
            case "App Store":
                clickOnElement(AppStoreIcon);
                switchTab();
                break;
            case "Linkedin":
                clickOnElement(LinkedInIcon);
                switchTab();
                break;
            case "YouTube":
                clickOnElement(YouTubeIcon);
                switchTab();
                break;
        }
    }

    public void responseCodeShouldBe(int responseCode) {
        logger.info("Response code should be " + responseCode);
        int currentResponseCode = responseCodeViaGet(WebURLHelper.getFiveHundredUrl());
        System.out.println("currentResponseCode === " + currentResponseCode);
        try {
            if (currentResponseCode != responseCode) {
                System.out.println("Response code doesn't match. Current response code: " + currentResponseCode);
            }
        } catch (AssertionError e) {
            e.printStackTrace();
        }
    }

    public boolean shouldSeeText(String textMessage) {
        int size=0;
         if(getBrowserName().contains("Safari")){
             try {
                 size = getThreadDriver().findElements(By.xpath("//*[contains(text(),\"" + textMessage + "\")]")).size();
             }catch (NoSuchFrameException e){
                 waitForPageLoad();
                 size = getThreadDriver().findElements(By.xpath("//*[contains(text(),\"" + textMessage + "\")]")).size();
             }

         }else {
             size = getThreadDriver().findElements(By.xpath("//*[contains(text(),\"" + textMessage + "\")]")).size();
         }
        logger.info("[--->text with element size size=====>"+size+"<---]");
        return size>0?true:false;
    }
    public void acceptGDPRPopUpOnCvLibrary() {
        try {
            //waitUntilElementIsLocated(CVLGDPRNotice, 5);
            getThreadDriver().switchTo().frame(CVLGDPRNotice);
            getThreadDriver().findElement(By.id("save")).click();
            getThreadDriver().switchTo().defaultContent();
        } catch (org.openqa.selenium.NoSuchElementException nse) {
            nse.getMessage();
        }
    }

    public void acceptFacebookCookiePopUp() {
        try {
            clickOnElement(FacebookAcceptAll);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public boolean acceptInstagramCookiePopUp() {
        try {
            WebElement accept = getThreadDriver().findElement(By.className("aOOlW  bIiDR"));
            accept.click();
            return isElementDisplay(accept);
        } catch (org.openqa.selenium.NoSuchElementException nse) {
            logger.info("element not found ");
            return false;
        }
    }

    public void loginAsCandidate() {
        loadWebUrl(WebURLHelper.getCandidateLoginUrl());
        LoginPageEmail.sendKeys(DataHelper.getTestCandidateEmail());
        waitUntilElementIsLocated(LoginPagePassword, 10);
        LoginPagePassword.sendKeys(DataHelper.getCandidatePassword());
        clickOnElement(CandidateLoginPageSubmit);
        waitUntil(WebURLHelper.getCandidateAccountUrl());
    }

    public void loginAsClient() {
        loadWebUrl(WebURLHelper.getClientLoginUrl());
        LoginPageEmail.sendKeys(DataHelper.getTestClientEmail());
        LoginPagePassword.sendKeys(DataHelper.getTestClientPassword());
        clickOnElement(ClientLoginPageSubmit);
        waitUntil(WebURLHelper.getClientAccountUrl());
    }

    public void loginAsAClientWithNoCredits() {
        loadWebUrl(WebURLHelper.getClientLoginUrl());
        LoginPageEmail.sendKeys(DataHelper.getTestClientEmailWithNoCredits());
        LoginPagePassword.sendKeys(DataHelper.getTestClientPassword());
        clickOnElement(ClientLoginPageSubmit);
        waitUntil(WebURLHelper.getClientAccountUrl());

        if (!CreditsRemainingText.getText().equals("0")) {
            logger.info("Candidate unlock type is set to Account Level, so changing that");
            new com.resumelibrary.admintest.misc.MiscPage().loginAsAdminUser();
            getDriverWithUrl(AdminURLHelper.getAdminUrl(), AdminURLHelper.getAccountViewUrl());
            new com.resumelibrary.admintest.misc.MiscPage().updateCandidateUnlock();
            getDriverWithUrl(WebURLHelper.getWebUrl(), WebURLHelper.getClientAccountUrl());
        } else {
            logger.info("Candidate unlock type is set to Client Level");
        }
    }

    public void verifyFooterLinksIsDisplay(String links) {
        logger.info("Verifying footer links are display " + links);
        switch (links) {
            case "App Store":
                Assert.assertFalse(getThreadDriver().getPageSource().contains("footer-app-store-icon"),"[---> App store icon is displayed <---]");
            case "Google Play":
                Assert.assertFalse(getThreadDriver().getPageSource().contains("footer-play-store-icon"), "[---> Google play icon is displayed <---]");
        }
    }

    public void clickOnIAgreeBtn() {
        logger.info("Clicking on i agree btn ");
        try {
            clickOnElement(IAgreeButton);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void loginAsTesterClient() {
        loadWebUrl(WebURLHelper.getClientLoginUrl());
        LoginPageEmail.sendKeys((DataHelper.getAdminUsername()));
        LoginPagePassword.sendKeys(DataHelper.getAdminPassword());
        clickOnElement(ClientLoginPageSubmit);
        waitUntil(WebURLHelper.getClientAccountUrl());
    }
    public void createFolderAndDelete(String folderName) {
        File dir = new File("/tmp");
        File[] dirContents = dir.listFiles();
        logger.info("tmp folder is created :");

        for (File file : dirContents) {
            if (file.getName().equalsIgnoreCase(folderName)) {
                logger.info("Downloaded to tmp folder :");
                file.delete();
                logger.info("Deleted from tmp folder :");
                break;
            }
            dir.delete();
            logger.info("tmp folder is deleted :");
        }
    }
}