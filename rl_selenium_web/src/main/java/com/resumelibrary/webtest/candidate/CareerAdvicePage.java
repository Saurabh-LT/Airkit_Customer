package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

public class CareerAdvicePage extends Utility {

    public CareerAdvicePage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(CareerAdvicePage.class);

    @FindBy(xpath = "//p[@class='sub-header-jobcount']/a[2]/span")
    WebElement SubHeaderCompaniesCount;
    @FindBy(xpath = "//*[@class='sub-header-jobcount']/a[1]")
    WebElement SubHeaderSearchJobsLink;
    @FindBy(xpath = "//*[@class='sub-header-jobcount']/a[1]/span")
    WebElement SubHeaderSearchJobs;
    @FindBy(xpath = "//a[@class='rl-logo-svg USA']")
    WebElement ResumeLibraryHeaderLogo;
    @FindBy(xpath = "//a[@class='rl-logo-svg  USA']")
    WebElement ResumeLibraryLoggedOutHeaderLogo;
    @FindBy(xpath = "//a[@class='rl-logo-svg USA']")
    WebElement ResumeLibraryFooterLogo;
    @FindBy(xpath = "//a[@class='rl-logo-svg recruiters-nav-logo USA']")
    WebElement ResumeLibraryEmployersHeaderLogo;
    @FindBy(id = "RL_Career_Advice_Dyn_Banner")
    WebElement RLCareerAdviceDynBanner;
    @FindBy(id = "RL_Career_Advice_160x600")
    WebElement RLCareerAdvice160x600;
    @FindBy(className = "blog-fb-banner")
    WebElement BlogFBBanner;
    @FindBy(id = "resume-upload-btn")
    WebElement ResumeUploadBtn;
    @FindBy(xpath = "//*[@class='sub-header-jobcount']/a[2]")
    WebElement SubHeaderCompaniesLink;
    @FindBy(id = "back-to-top")
    WebElement BackToTopButton;

    public boolean getTextFromSubHeaderCompaniesCount() {
        logger.info("Getting text from sub header companies count");
        return !(Objects.equals(SubHeaderCompaniesCount.getText(), String.valueOf(0)));
    }

    public boolean isRLHeaderLogoDisplayed() {
        if (isElementDisplay(ResumeLibraryHeaderLogo)) {
            logger.info("Resume library header logo is displayed");
            return true;
        } else if (isElementDisplay(ResumeLibraryLoggedOutHeaderLogo)) {
            logger.info("Resume library header logo is displayed");
            return true;
        } else {
            logger.info("Resume library header logo is not displayed");
        }
        return false;
    }

    public void clickOnLoggedInRLHeaderLogo() {
        logger.info("click on Resume library header logo");
        clickOnElement(ResumeLibraryHeaderLogo);
    }

    public void clickOnLoggedOutRLHeaderLogo() {
        logger.info("click on Resume library header logo");
        clickOnElement(ResumeLibraryLoggedOutHeaderLogo);
    }

    public boolean getTextFromSiteStartsSearchCount() {
        logger.info("Getting text from sub header companies count");
        waitUntilElementIsLocated(SubHeaderSearchJobsLink, 15);
        if (isElementDisplay(SubHeaderSearchJobsLink)) {
            return true;
        }
        return false;
    }

    public void clickOnSearchJobsLink() {
        logger.info("Clicking Search jobs link");
        clickOnElement(SubHeaderSearchJobs);
    }

    public void clickOnCareerAdviceNavLinks(String links) {
        List<WebElement> linkList = getThreadDriver().findElements(By.xpath("//ul[@id='menu-grey-nav']/li/a"));
        for (WebElement ele : linkList) {
            if (ele.getText().contains(links)) {
                logger.info("Clicking on element contains text :" + links);
                clickOnElement(ele);
                break;
            }
        }
    }

    public boolean isRLFooterLogoDisplayed() {
        if (isElementDisplay(ResumeLibraryFooterLogo)) {
            logger.info("Resume library footer logo is displayed");
            waitUntilElementIsLocated(ResumeLibraryFooterLogo, 15);
            return true;
        } else {
            logger.info("Resume library footer logo is not displayed");
            return false;
        }
    }

    public void clickOnRLFooterLogo() {
        logger.info("click on Resume library footer logo");
        clickOnElement(ResumeLibraryFooterLogo);
    }

    public void clickOnRLEmployersHeaderLogo() {
        logger.info("click on Resume library Employers header logo");
        clickOnElement(ResumeLibraryEmployersHeaderLogo);
    }

    public boolean isRLEmployersHeaderLogo() {
        waitUntilElementIsLocated(ResumeLibraryEmployersHeaderLogo, 5);
        if (isElementDisplay(ResumeLibraryEmployersHeaderLogo)) {
            logger.info("Resume library Employer Header logo is displayed");
            return true;
        } else {
            logger.info("Resume library Employer Header logo is not displayed");
            return false;
        }
    }

    public void clickOnLinkJobSeekerToolsMenu(String link) {
        logger.info("validate Jobseeker Tools Menu");
        List<WebElement> linkList = getThreadDriver().findElements(By.xpath("//*[starts-with(@id,\"footer-jobseeker\")]/ul/li/a"));
        for (WebElement ele : linkList) {
            if (ele.getText().contains(link)) {
                logger.info("Clicking on element contains text :" + link);
                waitUntilElementToBeClickable(ele, 5);
                clickOnElementUsingActions(ele);
                break;
            }
        }
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(2);
        }
    }

    public void clickOnAccountOptionsLink(String link) {
        logger.info("validate Account Options Menu");
        List<WebElement> linkList = getThreadDriver().findElements(By.xpath("//*[@id=\"footer-account-options\"]/ul/li/a"));
        for (WebElement ele : linkList) {
            if (ele.getText().contains(link)) {
                logger.info("Clicking on element contains text : " + link);
                clickOnElement(ele);
                break;
            }
        }
    }

    public void clickOnLinkAboutRLMenu(String link) {
        logger.info("validate About Resume Library Menu" + link);
        String locator = "";
        String offset = "";
        waitFor(1);
        WebElement ele = getThreadDriver().findElement(By.xpath("//*[@id='footer-resume-library']/ul/li//a[text()='"+link+"']"));
        waitUntilElementToBeClickable(ele,5);
        logger.info("n element contains text : " + ele.getText());
        clickOnElement(ele);
        waitFor(1);
    }


    public boolean isRLCareerAdviceDynBannerDisplayed() {
        waitUntilElementIsLocated(RLCareerAdviceDynBanner, 15);
        if (isElementDisplay(RLCareerAdviceDynBanner)) {
            logger.info("RL Career Advice Dyn Banner is displayed");
            return true;
        } else {
            logger.info("RL Career Advice Dyn Banner is not displayed");
            return false;
        }
    }

    public boolean isRLCareerAdvice160x600Displayed() {
        waitUntilElementIsLocated(RLCareerAdvice160x600, 15);
        if (isElementDisplay(RLCareerAdvice160x600)) {
            logger.info("RL Career Advice 160x600 is displayed");
            return true;
        } else {
            logger.info("RL Career Advice 160x600 is not displayed");
            return false;
        }
    }

    public boolean isBlogFBBannerDisplayed() {
        waitUntilElementIsLocated(BlogFBBanner, 15);
        if (isElementDisplay(BlogFBBanner)) {
            logger.info("Blog FB Banner is displayed");
            return true;
        } else {
            logger.info("Blog FB Banner is not displayed");
            return false;
        }
    }

    public void clickOnResumeUploadBtn() {
        logger.info("click on Resume Upload Btn");
        clickOnElement(ResumeUploadBtn);
    }

    public void clickOnAndVeryUrlForJobseekersFooter(String text, String url) {
        logger.info("validate job seekers footer menu");
        String menuXpath = "//*[@id=\"footer-jobseeker\"]/ul/li/a";
        clickOnElementAndVerifyUrl(text, menuXpath, getURL(url));

    }

    public void clickOnAndVerifyUrlForHiringFooter(String text, String url) {
        logger.info("validate job seekers footer menu");
        String menuXpath = "//*[@id=\"footer-hiring\"]/ul/li/a";
        clickOnElementAndVerifyUrl(text, menuXpath, url);

    }

    public void clickOnInFooterMenuResumeLibraryAndVerifyUrl(String text, String url) {
        logger.info("validate resume-library footer menu");
        String menuXpath = "//*[@id=\"footer-resume-library\"]/ul/li/a";
        clickOnElementAndVerifyUrl(text, menuXpath, url);
    }

    private void clickOnElementAndVerifyUrl(String text, String menuXpath, String url) {
        List<WebElement> linkList = getThreadDriver().findElements(By.xpath(menuXpath));
        for (WebElement ele : linkList) {
            if (ele.getText().contains(text)) {
                logger.info("Clicking on element contains text :" + text);
                clickOnElement(ele);
                new OthersPage().verifyURLText(url,"");
                break;
            }
        }
    }

    public void clickOnCompaniesLink() {
        logger.info("Clicking Companies link");
        clickOnElement(SubHeaderCompaniesLink);
    }

    public void clickOnBackToTopButton() {
        logger.info("clicking on back to top button");
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitUntilElementIsLocated(BackToTopButton, 20);
        }
        clickOnElementWithJS(BackToTopButton);
    }
}