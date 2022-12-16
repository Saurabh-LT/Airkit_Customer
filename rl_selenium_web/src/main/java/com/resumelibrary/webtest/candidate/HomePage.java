package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    @FindBy(id = "home-search-more")
    WebElement MoreSearchOptionsLink;
    @FindBy(id = "annual_salary_from")
    WebElement SalaryMinHomePage;
    @FindBy(id = "annual_salary_to")
    WebElement SalaryMaxHomePage;
    @FindBy(id = "job_type")
    WebElement JobTypeDropdownHomePage;
    @FindBy(id = "pd")
    WebElement PostedSinceDropdownHomepage;
    @FindBy(id = "home-search-submit")
    WebElement FindJobsBtnHomePage;
    @FindBy(xpath = "//a[@class='rl-logo-svg  USA']")
    WebElement HomepageLogo;
    @FindBy(className = "recent-searches-desktop-btn")
    WebElement RecentSearchesLink;
    @FindBy(className = "clear-recent-searches")
    WebElement ClearRecentSearchesLink;
    @FindBy(id = "app-store-icon-link")
    WebElement AppStoreIconLink;
    @FindBy(id = "play-store-icon-link")
    WebElement PlayStoreIconLink;
    String linksUnderJobsByIndustryTab = "//div[@id='home-jobs-by-industry']/ul/li";
    String linksUnderJobsByStateTab = "//div[@id='home-jobs-by-state']/ul/li";
    String linksUnderJobsByCityTab = "//div[@id='home-jobs-by-city']/ul/li";
    String linksUnderPopularJobsTab = "//div[@id='home-popular-jobs']/ul/li";
    @FindBy(xpath = "//a[@class='account-link']")
    WebElement CandidateDropdownHeaderLink;
    @FindBy(id = "nav_my_account")
    WebElement myDashBoardHeaderLink;
    @FindBy(id = "nav_modify_resume")
    WebElement myProfileHeaderLink;
    @FindBy(id = "nav_jobalerts")
    WebElement jobAlertsHeaderLink;
    @FindBy(xpath = "//nav[@label='Site Navigation']/ul/li/a[text()='Saved Jobs']")
    WebElement savedJobsHeaderLink;
    @FindBy(xpath = "//a[@class='account-link']")
    WebElement profileIconHeaderLink;
    @FindBy(xpath = "//li/a[text()='My Email Preferences']")
    WebElement myEmailPreferencesHeaderLink;
    @FindBy(xpath = "//li/a[text()='My Applications']")
    WebElement myApplicationHeaderLink;
    @FindBy(xpath = "//li[@id='user-nav']/ul/li/a[text()='My Settings']")
    WebElement mySettingsHeaderLink;
    @FindBy(xpath = "//li[@class='logout']/a[text()='Logout']")
    WebElement logOutHeaderLink;
    @FindBy(id = "home-signin")
    WebElement logInHeaderLink;
    public void clickOnMoreSearchOptionLink() {
        logger.info("Clicking on more search options link ");
        clickOnElement(MoreSearchOptionsLink);
    }

    public void selectSalaryMinFromDropdown(String salMin) {
        logger.info("Selected salary min from dropdown " + salMin);
        selectByValueFromDropDown(SalaryMinHomePage, salMin);
    }

    public void selectSalaryMaxFromDropdown(String salMax) {
        logger.info("Selected salary max from dropdown " + salMax);
        selectByValueFromDropDown(SalaryMaxHomePage, salMax);
    }

    public void selectJobTypeFromDropdown(String jobType) {
        logger.info("Selected job type from dropdown " + jobType);
        selectByVisibleTextFromDropDown(JobTypeDropdownHomePage, jobType);
    }

    public void selectPostedSinceFromDropdown(String postedSince) {
        logger.info("Selected posted since from dropdown " + postedSince);
        selectByVisibleTextFromDropDown(PostedSinceDropdownHomepage, postedSince);
    }

    public void clickOnFindJobsButton() {
        logger.info("Clicking on find jobs button ");
        clickOnElement(FindJobsBtnHomePage);
    }

    public Boolean homePageLogoIsVisible() {
        return isElementDisplay(HomepageLogo);
    }

    public void clickOnRecentSearchesLink() {
        logger.info("Clicking on recent searches link");
        clickOnElement(RecentSearchesLink);
    }

    public void clickOnClearRecentSearchesLink() {
        logger.info("Clicking on clear recent searches link");
        clickOnElement(ClearRecentSearchesLink);
    }

    public void clickOnAppStoreIconLink() {
        logger.info("Clicking on app store icon link ");
        clickOnElement(AppStoreIconLink);
    }

    public void clickOnPlayStoreIconLink() {
        logger.info("Clicking on play store icon link ");
        clickOnElement(PlayStoreIconLink);
    }

    public Boolean verifyTheLinkTextUnderJobsByIndustryTab(String jobsByIndustry) {
        logger.info("Verifying the links text under Jobs By Industry Tab");
        return compareTextFromElementUsingXpath(linksUnderJobsByIndustryTab, jobsByIndustry);
    }

    public Boolean verifyTheLinkTextUnderJobsByStateTab(String jobsByState) {
        logger.info("Verifying the links text under Jobs By State Tab");
        return compareTextFromElementUsingXpath(linksUnderJobsByStateTab, jobsByState);
    }

    public Boolean verifyTheLinkTextUnderJobsByCityTab(String jobsByCity) {
        logger.info("Verifying the links text under Jobs By City Tab");
        return compareTextFromElementUsingXpath(linksUnderJobsByCityTab, jobsByCity);
    }

    public Boolean verifyTheLinkTextUnderPopularJobsTab(String populatJobs) {
        logger.info("Verifying the links text under Popular Jobs Tab");
        return compareTextFromElementUsingXpath(linksUnderPopularJobsTab, populatJobs);
    }
    public void ClickOnHeaderLink(String headerLink)   {

         switch (headerLink) {
            case "My Dashboard":
                logger.info("clicked on link");
                clickOnElement(myDashBoardHeaderLink);
                break;
            case "My Profile":
                clickOnElement(myProfileHeaderLink);
                break;
            case "Job Alerts":
                clickOnElement(jobAlertsHeaderLink);
                break;
            case "Saved Jobs":
                clickOnElement(savedJobsHeaderLink);
                break;
            case "My Email Preferences":
                mouseHoverToElement(CandidateDropdownHeaderLink);
                clickOnElement(myEmailPreferencesHeaderLink);
                break;
            case "My Applications":
                mouseHoverToElement(CandidateDropdownHeaderLink);
                clickOnElement(myApplicationHeaderLink);
                break;
            case "My Settings":
                mouseHoverToElement(CandidateDropdownHeaderLink);
                clickOnElement(mySettingsHeaderLink);
                break;
            case "Logout":
                mouseHoverToElement(CandidateDropdownHeaderLink);
                clickOnElement(logOutHeaderLink);
                break;
            case "Login":
                clickOnElement(logInHeaderLink);
                break;
            default:
                logger.info("Invalid Field Name");
                break;
        }
    }
}