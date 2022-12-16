package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.utilities.WebURLHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FastTrackUpdateProfilePage extends Utility {

    public FastTrackUpdateProfilePage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(FastTrackUpdateProfilePage.class);

    @FindBy(id = "search-results-jbe-cta")
    WebElement SearchResultsJbeCta;
    @FindBy(id = "search-results-jbe-email")
    WebElement SearchResultsJbeEmail;
    @FindBy(id = "search-results-jbe-submit")
    WebElement SearchResultsJbeSubmit;
    @FindBy(id = "latest_job_title")
    WebElement LatestJobTitle;
    @FindBy(id = "sidebar-save-to-profile-btn")
    WebElement SaveToProfileBtn;
    @FindBy(id = "phone")
    WebElement Phone;
    @FindBy(id = "upload_resume_toggle1")
    WebElement ResumeToggle1;
    @FindBy(id = "sidebar-upload-resume-btn")
    WebElement UploadResumeBtn;
    @FindBy(id = "cand-sidebar-prompt-skip")
    WebElement CandSidebarPromptSkip;
    @FindBy(id = "zip_code")
    WebElement ZipCode;
    @FindBy(id = "desired_job_title")
    WebElement DesiredJobTitle;
    @FindBy(id = "salary_expectation_from")
    WebElement SalaryExpectationFrom;
    @FindBy(id = "salary_expectation_to")
    WebElement SalaryExpectationTo;
    @FindBy(id = "education_level")
    WebElement EducationLevel;
    @FindBy(id = "eligibility_status")
    WebElement EligibilityStatus;
    @FindBy(id = "first_name")
    WebElement FirstName;
    @FindBy(id = "last_name")
    WebElement LastName;
    @FindBy(id = "relocate")
    WebElement Relocate;
    @FindBy(id = "work_experience")
    WebElement WorkExperience;
    @FindBy(id = "driving_licence")
    WebElement DrivingLicence;
    @FindBy(xpath = "//span[@id='percent-complete' and contains(text(),'45%')]")
    WebElement SpanPercentComplete45;
    @FindBy(xpath = "//span[@id='percent-complete' and contains(text(),'100%')]")
    WebElement SpanPercentComplete100;
    @FindBy(id = "nav_my_account")
    WebElement MyAccountNavBarMenu;

    public void clickOnGetLatestJobAlert() {
        logger.info("click on Get Latest Job Alert ");
        clickOnElement(SearchResultsJbeCta);
    }

    public void fillRandomEmailId() {
        String emailText = generateRandomEmail();
        logger.info("random email entered is  : " + emailText);
        SearchResultsJbeEmail.sendKeys(emailText);
        waitFor(1);
    }

    public void clickOnCreateJobAlert() {
        logger.info("click on Create Job Alert ");
        clickOnElement(SearchResultsJbeSubmit);
        waitFor(2);
    }


    public void fillJobTitle(String title) {
        logger.info("entered job title is   : " + title);
        LatestJobTitle.sendKeys(title);
    }

    public void clickSaveToProfile() {
        logger.info("click on 'Save to Profile' ");
        clickOnElement(SaveToProfileBtn);
        waitFor(2);
    }

    public void enterPhoneNumber(String phone) {
        logger.info("entered phone number is : " + phone);
        Phone.sendKeys(phone);
    }

    public void clickOnUploadResumeToggle() {
        logger.info("click on 'Upload Resume Toggle' ");
        clickOnElement(ResumeToggle1);
    }

    public void clickUploadResume() {
        logger.info("click on 'Upload Resume' Button ");
        clickOnElement(UploadResumeBtn);
    }

    public void clickOnSkip() {
        logger.info("click on 'Skip'  Button ");
        clickOnElement(CandSidebarPromptSkip);
        waitFor(1);
    }

    public void enterZipCode(String zipCode) {
        logger.info("entered zipcode is : " + zipCode);
        ZipCode.sendKeys(zipCode);
        clickOnId("main");
    }

    public void enterDesiredJobTitle(String jobTitle) {
        logger.info("entered the desired job title : " + jobTitle);
        clearTextFromField(DesiredJobTitle);
        sendTextToElement(DesiredJobTitle, jobTitle);
    }

    public void selectMinSalary(String minSalary) {
        logger.info("selected min salary : " + minSalary);
        selectByValueFromDropDown(SalaryExpectationFrom, minSalary);
    }

    public void selectMaxSalary(String maxSalary) {
        logger.info("selected max salary : " + maxSalary);
        selectByValueFromDropDown(SalaryExpectationTo, maxSalary);
    }

    public void enterEducation(String education) {
        logger.info("entered education level is : " + education);
        EducationLevel.sendKeys(education);
    }

    public void selectEligibilityStatus(String eligibilityStatus) {
        logger.info("selected eligibility Status  : " + eligibilityStatus);
        selectByVisibleText(EligibilityStatus, eligibilityStatus);
    }

    public void enterFirstName(String firstName) {
        logger.info("entered first name is : " + firstName);
        FirstName.clear();
        FirstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        logger.info("entered last name is : " + lastName);
        LastName.sendKeys(lastName);
    }

    public void enterSkills(String value) {
        String javaScript = "document.getElementById('skills-input').value='" + value + "'";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getThreadDriver();
        javascriptExecutor.executeScript(javaScript);
        javascriptExecutor.executeScript("document.getElementById('skills-input').click()");
        waitFor(3);
    }

    public void selectRelocateStatus(String relocate) {
        selectByVisibleText(Relocate, relocate);
    }

    public void selectWorkExp(String exp) {
        selectByVisibleText(WorkExperience, exp);
    }

    public void selectDrivingLiStatus(String licStaus) {
        selectByVisibleText(DrivingLicence, licStaus);
    }

    public String percentageComplete(String percentage) {

        String p = null;
        switch (percentage) {
            case "45%":
                p = SpanPercentComplete45.getText();
                break;
            case "100%":
                p = SpanPercentComplete100.getText();
                break;
        }
        return p;
    }

    public void clickOnCreateJobAlertAndMoveto(String url) {
        logger.info("click on Create Job Alert ");
        clickOnElement(SearchResultsJbeSubmit);
        waitFor(3);
        waitUntil(WebURLHelper.getWebUrl() + "/jobs/sales-in-houston-tx");
        waitUntilTextToBePresent(MyAccountNavBarMenu, "My Dashboard");
        getDriverWithUrl(WebURLHelper.getWebUrl(), getURL(url));
        webDriverWaitContainsUrl(getURL(url));
    }
}