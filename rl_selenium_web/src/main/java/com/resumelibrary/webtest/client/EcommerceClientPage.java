package com.resumelibrary.webtest.client;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class EcommerceClientPage extends Utility {

    public EcommerceClientPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(EcommerceClientPage.class);

    @FindBy(xpath = "//*[text()='Featured Job Posting']/../..//a[text()='Buy Online Now']")
    WebElement FeatureJobPostingBuyOnlineNow;
    @FindBy(xpath = "//*[text()='Resume Search']/../..//a[text()='Buy Online Now']")
    WebElement ResumeSearchBuyOnlineNow;
    @FindBy(xpath = "//*[@id=\"client-home\"]/dialog[2]/div/button")
    WebElement AccountAuthenticationRequiredPopup;
    @FindBy(xpath = "//*[@id=\"unlock_popup\"]/div/button")
    WebElement AccountAuthenticationResumeView;
    @FindBy(xpath = "//span[text()='Main number']/../span[2]/a")
    WebElement MainNumberViewContactDetails;
    @FindBy(xpath = "//span[text()='Email address']/../span[2]/a")
    WebElement EmailAddressViewContactDetails;
    @FindBy(xpath = "//*[@id=\"job-dashboard\"]/dialog[2]/div/button")
    WebElement closeAccountAuthenticationForJobDashboard;
    @FindBy(xpath = "//*[@id=\"client-products\"]/dialog[2]/div/button")
    WebElement closeAccountAuthenticationForClientProducts;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/section[1]/a")
    WebElement Button30DayResumeSearchBuyOnline;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/section[2]/a")
    WebElement ButtonStarterPackageBuyOnline;
    @FindBy(xpath = "//*[@id=\"unlock_popup\"]/div/button")
    WebElement PurchaseProductPopupForUnlockResume;
    @FindBy(xpath = "//*[@id=\"client-home\"]/dialog[2]/div/button")
    WebElement PostAJobPopup;
    @FindBy(xpath = "//*[@id=\"main\"]/section[1]/div/div[2]/div[1]/div/a")
    WebElement LearnMoreForSearchResumes;
    @FindBy(xpath = "//*[@id=\"main\"]/section[1]/div/div[2]/div[2]/div/a")
    WebElement LearnMoreForPostJobs;
    @FindBy(xpath = "//*[@id=\"recruiters\"]/dialog[2]/div/button")
    WebElement AccountAuthenticationForRecruiters;
    @FindBy(xpath = "//input[@name='select_all_candidates']")
    WebElement SelectAllCandidates;
    @FindBy(xpath = "//*[@class='rs-multi-trigger']")
    WebElement ResumeSearchMultiTrigger;
    @FindBy(xpath = "//*[@id=\"client-home\"]/dialog/div/button")
    WebElement EmailVerificationRequiredPopup;
    @FindBy(xpath = "//*[@id=\"resume-search\"]/dialog[14]/div/button")
    WebElement EmailVerificationRequiredPopupForResumeSearch;
    @FindBy(xpath = "//*[@id=\"unlock_popup\"]/div/button")
    WebElement EmailVerificationRequiredUnlockPopup;
    @FindBy(xpath = "/html/body/dialog[14]/div/button")
    WebElement EmailVerificationRequiredPopupForInviteToApply;
    @FindBy(xpath = "//*[@class=\"btn btn-xs btn-primary\"][text()='Edit']")
    WebElement EditButtonEmailVerification;
    @FindBy(xpath = "//*[@class=\"empty-cart-div\"]")
    WebElement EmptyCartLogo;
    @FindBy(xpath = "//button[text()='Update User']")
    WebElement ButtonUpdateUser;
    @FindBy(xpath = "//*[text()='Client Level']/..//*[@id=\"product-account-unlock-credit\"]")
    WebElement ContactCreditsNewBalance;
    @FindBy(xpath = "//*[@class='unlock-popup-option option--regular']/a")
    WebElement BuyNow3MonthsAccess;
    @FindBy(xpath = "//select[@name='job-posting-credit']")
    WebElement SelectJobPostingCredit;
    @FindBy(xpath = "//img[@src='/images/resources-blog-new-customer-offer.png']")
    WebElement Image3MonthResumeSearch;
    @FindBy(xpath = "//img[@src='/images/resources-blog-search-resumes.gif']")
    WebElement ImageResumeSearch;
    @FindBy(xpath = "//img[@src='/images/resources-blog-post-jobs.gif']")
    WebElement ImagePostAJob;
    @FindBy(xpath = "//*[@id=\"resume-search\"]/dialog[10]/div/button")
    WebElement ResumeSearchPopupButton;
    @FindBy(css = ".request-pricing")
    WebElement RequestPricingBtn;
    @FindBy(xpath = "//*[@id=\"unlock_popup\"]")
    WebElement AccountAuthenticationPopup;

    String image3MonthResumeSearchXpath = "//img[@src='/images/resources-blog-new-customer-offer.png']";
    String imageResumeSearchXpath = "//img[@src='/images/resources-blog-search-resumes.gif']";
    String imagePostAJobXpath = "//img[@src='/images/resources-blog-post-jobs.gif']";

    public void clickOnFeatureJobPostingBuyOnlineNow() {
        logger.info("click on element FeatureJobPostingBuyOnlineNow");
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(2);
        }
        clickOnElementWithJS(FeatureJobPostingBuyOnlineNow);
    }

    public void closeAccountAuthenticationRequiredPopup() {
        logger.info("click on element AccountAuthenticationRequiredPopup");
        clickOnElement(AccountAuthenticationRequiredPopup);
    }

    public void clickOnMONTHSResumeSearchBuyOnlineNow() {
        logger.info("click on element AccountAuthenticationRequiredPopup");
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(2);
        }
        clickOnElement(ResumeSearchBuyOnlineNow);
    }

    public void closeAccountAuthenticationForUnlockResume() {
        logger.info("click on element AccountAuthenticationResumeView");
        clickOnElement(AccountAuthenticationResumeView);
        waitFor(2);
    }

    public void waitForAccountAuthenticationPopup() {
        waitUntilElementIsLocated(AccountAuthenticationPopup,5);
    }

    public void clickOnMainNumberViewContactDetails() {
        logger.info("click on element MainNumberViewContactDetails");
        clickOnElement(MainNumberViewContactDetails);
    }

    public void clickOnMainEmailAddressViewContactDetails() {
        logger.info("click on element EmailAddressViewContactDetails");
        clickOnElement(EmailAddressViewContactDetails);
    }

    public void closePurchaseProductPopupForUnlockResume() {
        logger.info("click on element PurchaseProductPopupForUnlockResume");
        clickOnElement(PurchaseProductPopupForUnlockResume);
    }

    public void closeAccountAuthenticationForJobDashboard() {
        logger.info("click on element closeAccountAuthenticationForJobDashboard");
        clickOnElement(closeAccountAuthenticationForJobDashboard);
    }

    public void closeAccountAuthenticationForClientProducts() {
        logger.info("click on element closeAccountAuthenticationForClientProducts");
        clickOnElement(closeAccountAuthenticationForClientProducts);
    }

    public void click30DayResumeSearchBuyOnline() {
        logger.info("click on element click30DayResumeSearchBuyOnline");
        clickOnElement(Button30DayResumeSearchBuyOnline);
    }

    public void clickButtonStarterPackageBuyOnline() {
        logger.info("click on element ButtonStarterPackageBuyOnline");
        clickOnElement(ButtonStarterPackageBuyOnline);
    }

    public void closePostAJobPopup() {
        logger.info("click on element PostAJobPopup");
        clickOnElement(PostAJobPopup);
    }

    public void clickOnLearnMoreForSearchResumes() {
        logger.info("click on element LearnMoreForSearchResumes");
        clickOnElement(LearnMoreForSearchResumes);
    }

    public void clickOnLearnMoreForPostJobs() {
        logger.info("click on element LearnMoreForPostJobs");
        clickOnElement(LearnMoreForPostJobs);
    }

    public void clickOnAccountAuthenticationForRecruiters() {
        logger.info("click on element AccountAuthenticationForRecruiters");
        clickOnElement(AccountAuthenticationForRecruiters);
    }

    public void tickSelectAllCheckboxForInviteToApply() {
        logger.info("click on element SelectAllCandidates");
        List<WebElement> selectCheckBoxes = getThreadDriver().findElements(By.xpath("//*[starts-with(@class,'candidate-checkbox-label')]"));
        clickOnElement(selectCheckBoxes.get(0));
        waitFor(1);
    }

    public void verifyAllCheckBoxesTicked() {
        logger.info("verify All Check Boxes Ticked");
        List<WebElement> selectCheckBox = getThreadDriver().findElements(By.xpath("//*[starts-with(@class,'candidate-checkbox-label')]"));
        for (WebElement select : selectCheckBox) {
            if (select.isSelected()) {
                logger.info(" selected the check box :" + select.getTagName());
            }
        }
    }

    public void selectOption(String optionText) {
        logger.info("Selected the option from dropdown : " + optionText);
        selectByVisibleText(ResumeSearchMultiTrigger, optionText);
    }

    public void closeEmailVerificationRequiredPopup() {
        logger.info("click on element EmailVerificationRequiredPopup");
        clickOnElement(EmailVerificationRequiredPopup);
    }

    public void closeEmailVerificationRequiredPopupForResumeSearch() {
        logger.info("click on element EmailVerificationRequiredPopupForResumeSearch");
        clickOnElement(EmailVerificationRequiredPopupForResumeSearch);
    }


    public void closeEmailVerificationRequiredUnlockPopup() {
        logger.info("click on element EmailVerificationRequiredUnlockPopup");
        clickOnElement(EmailVerificationRequiredUnlockPopup);
    }

    public void closeEmailVerificationRequiredPopupForInviteToApply() {
        logger.info("click on element EmailVerificationRequiredPopupForInviteToApply");
        clickOnElement(EmailVerificationRequiredPopupForInviteToApply);
    }

    public void clickOnEditButton() {
        logger.info("click on edit button for Email Verification");
        clickOnElement(EditButtonEmailVerification);
    }

    public boolean verifyLogoEmptyShoppingCart() {
        logger.info("verify empty cart logo");
        if (isElementDisplay(EmptyCartLogo)) {
            logger.info("Empty cart logo is displayed");
            return true;
        } else {
            logger.info("Empty cart logo is not displayed");
            return false;
        }
    }

    public void clickOnButton(String text) {
        logger.info("click on Button Update User");
        clickOnElement(ButtonUpdateUser);
    }

    public void iShouldSeeTextTotal(String text) {
        System.out.println("--->" + getThreadDriver().findElement(By.xpath("//div[@class='totals-wrap']")).toString()+"<---");
    }

    //@TODO fix the below. clear all the fields and set it to zero
    public void enterContactCredits(String text) {
        waitFor(2);
        logger.info("entering contact credits :  " + text);
        ContactCreditsNewBalance.clear();
        ContactCreditsNewBalance.sendKeys(text);
    }

    public void clickOnMonthAccessPackage() {
        clickOnElement(BuyNow3MonthsAccess);
    }

    public String verifyPriceForClass(String price, String clazz) {
        logger.info("find the price : " + price + "for the class : " + clazz);
        String xpath = String.format("//*[@class='%s']", clazz);
        return getTextFromElementUsingXpath(price, xpath);
    }

    public String verifyOptionSelected(String option) {
        return getFirstSelectedOption(SelectJobPostingCredit);
    }

    public String verifyTextInOrderSummaryTable(String text) {
        logger.info("find the text : " + text);
        String xpath = String.format("//*[@class='%s']/tbody/tr/td", "summary-table");
        logger.info("xpath string is : " + xpath);
        return getTextFromElementUsingXpath(text, xpath);
    }

    public void selectJobPostingCreditQuantity(String option) {
        logger.info("select the option text : " + option);
        selectByVisibleText(SelectJobPostingCredit, option);
    }

    public boolean verifyImage(String text) {
        logger.info("verify the image with text " + text + "is displayed");
        waitUntilElementIsLocated(Image3MonthResumeSearch,5);
        return isElementDisplay(Image3MonthResumeSearch);
    }

    public void clickOnElement(String text) {
        logger.info("click on the image with text " + text + "is displayed");
        clickOnElement(Image3MonthResumeSearch);
    }

    public boolean verifyImageIsDisplayed(String text) {
        logger.info("verify the image with text " + text + "is displayed");
        boolean isDisplayed = false;
        getThreadDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        if ("3-month Resume Search".equals(text)) {
            if (getThreadDriver().findElements(By.xpath((image3MonthResumeSearchXpath))).size() != 0) {
                getThreadDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                isDisplayed = true;
            }
        } else if ("Resume Search".equals(text)) {
            if (getThreadDriver().findElements(By.xpath((imageResumeSearchXpath))).size() != 0) {
                getThreadDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                isDisplayed = true;
            }
        } else if ("Post A Job".equals(text)) {
            if (getThreadDriver().findElements(By.xpath((imagePostAJobXpath))).size() != 0) {
                getThreadDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                isDisplayed = true;
            }
        }
        return isDisplayed;
    }

    public void closePopupIntroducingOurNewResumeSearchBuilder() {
        logger.info("click on lose popup introducing our new resume search builder");
        clickOnElement(ResumeSearchPopupButton);
    }

    public void clickOnPreviewResume(String number) {
        logger.info("click on preview_locked_resume_" + number);
        String xpath = "//*[@id=\"preview_locked_resume_" + number + "\"]";
        logger.info("finding the web element with xpath : " + xpath);
        WebElement lockedProfile = getThreadDriver().findElement(By.xpath(xpath));
        clickOnElement(lockedProfile);
        waitFor(1);
        switchWindowIndex(1);
        getThreadDriver().close();
        switchWindowIndex(0);
    }

    public void clickOnRequestPricingBtn() {
        logger.info("click on request pricing button ");
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(2);
        }
        clickOnElement(RequestPricingBtn);
    }
}