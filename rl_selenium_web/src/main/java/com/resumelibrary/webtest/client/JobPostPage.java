package com.resumelibrary.webtest.client;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JobPostPage extends Utility {

    public JobPostPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(JobPostPage.class);

    List<String> sortedList;

    @FindBy(id = "title")
    WebElement JobTitleField;
    @FindBy(id = "region")
    WebElement StateDropdown;
    @FindBy(id = "city")
    WebElement TownField;
    @FindBy(id = "salary_min")
    WebElement SalMinField;
    @FindBy(id = "salary_max")
    WebElement SalMaxField;
    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div")
    WebElement DescriptionField;
    @FindBy(id = "preview-job")
    WebElement PreviewButton;
    @FindBy(id="mobile-menu-trigger")
    WebElement menuButton;


    @FindBy(id = "quick-apply-toggle-btn")
    WebElement QuickApplyToggle;
    @FindBy(id = "post-confirm-submit")
    WebElement PostJobSubmitButton;
    @FindBy(id = "add-screening-questions-btn")
    WebElement AddScreeningQuestionsBtn;
    @FindBy(id = "save-screening-questions-btn-1")
    WebElement SaveScreeningQuestionsBtn1;
    @FindBy(id = "jobs_action_btn_1")
    WebElement JobsActionBtn1;
    @FindBy(id = "action_edit_btn")
    WebElement ActionEditBtn;
    @FindBy(id = "action_matching_btn")
    WebElement ActionMatchingBtn;
    @FindBy(id = "action_deactivate_btn")
    WebElement ActionDeactivateBtn;
    @FindBy(id = "deactivate_this_job")
    WebElement DeactivateThisJobBtn;
    @FindBy(id = "next-btn")
    WebElement NextBtn;
    @FindBy(id = "post_job")
    WebElement PostJobLink;
    @FindBy(id = "manage_job_template")
    WebElement ManageJobTemplateLink;
    @FindBy(id = "view_job_applications")
    WebElement ViewJobApplicationsLink;
    @FindBy(id = "inactive_jobs")
    WebElement InactiveJobsLink;
    @FindBy(css = ".posting-type-list-title")
    WebElement PostingTypeListTitle;
    @FindBy(xpath = "//th[6]/a[@class='order-desc']")
    WebElement PostedDesc;
    @FindBy(xpath = "//th[6]/a[@class='order-asc']")
    WebElement PostedAsc;
    @FindBy(xpath = "//th[7]/a[@class='order-desc']")
    WebElement ExpiresDesc;
    @FindBy(xpath = "//th[7]/a[@class='order-asc']")
    WebElement ExpiresAsc;
    @FindBy(xpath = "//div[@class='table-wrap']/table/tbody/tr/td[6]")
    List<WebElement> PostedDates;
    @FindBy(xpath = "//div[@class='table-wrap']/table/tbody/tr/td[7]")
    List<WebElement> ExpiresDates;
    @FindBy(id = "preview_submit_btn")
    WebElement PreviewSubmitBtn;

    public void enterJobTitle(String jobTitle) {
        logger.info("Entered job title" + jobTitle);
        clearTextFromField(JobTitleField);
        JobTitleField.sendKeys(jobTitle);
    }

    public void selectStateFromDropdown(String state) {
        logger.info("Selected state from dropdown" + state);
        selectByVisibleText(StateDropdown, state);
    }

    public void enterTown(String town) {
        logger.info("Entered town" + TownField.toString());
        TownField.sendKeys(town);
    }

    public void enterSalaryMin(String salMin) {
        logger.info("Entered salary min" + salMin);
        clearTextFromField(SalMinField);
        SalMinField.sendKeys(salMin);
    }

    public void enterSalaryMax(String salMax) {
        logger.info("Entered salary max" + salMax);
        clearTextFromField(SalMaxField);
        SalMaxField.sendKeys(salMax);
    }

    public void enterDescription(String description) {
        logger.info("Entered description" + description);
        clearTextFromField(DescriptionField);
        DescriptionField.sendKeys(description);
    }

    public void clickONQuickApplyToggle() {
        logger.info("Clicking on quick apply toggle");
        clickOnElement(QuickApplyToggle);
    }

    public void clickOnPreviewButton() {
        logger.info("Clicking on preview button");
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(1);
        }
        clickOnElement(PreviewButton);
        waitUntilElementIsLocated(PreviewSubmitBtn, 20);
    }
    public void clickOnMenuButton() {
        logger.info("Clicking on preview button");
        clickOnElement(menuButton);
    }

    public void clickOnPostJobSubmitButton() {
        logger.info("Clicking on post job confirm button");
        clickOnElement(PostJobSubmitButton);
        waitFor(1);
    }

    public void clickOnAddScreeningQuestionButton() {
        logger.info("Clicking on add screening question button");
        clickOnElement(AddScreeningQuestionsBtn);
    }

    public void clickOnSaveScreeningQuestionButton1() {
        logger.info("Clicking on save screening question button 1");
        clickOnElement(SaveScreeningQuestionsBtn1);
        waitFor(1);
    }

    public void clickOnJobsActionButton1() {
        logger.info("Clicking on jobs action button 1");
        clickOnElement(JobsActionBtn1);
    }

    public void clickOnActionEditButton() {
        logger.info("Clicking on action edit button ");
        clickOnElement(ActionEditBtn);
    }

    public void clickOnActionMatchingButton() {
        logger.info("Clicking on action matching button ");
        clickOnElement(ActionMatchingBtn);
    }

    public void clickOnActionDeactivateButton() {
        logger.info("Clicking on action deactivate button ");
        clickOnElement(ActionDeactivateBtn);
    }

    public void clickOnDeactivateThisButton() {
        logger.info("Clicking on deactivate this button ");
        clickOnElement(DeactivateThisJobBtn);
    }

    public void clickOnNextButton() {
        logger.info("Clicking on next button ");
        clickOnElement(NextBtn);
    }

    public void clickOnPostJobLink() {
        logger.info("Clicking on post jobs link ");
        clickOnElement(PostJobLink);
    }

    public void clickOnManageJobTemplateLink() {
        logger.info("Clicking on manage jobs template link  ");
        clickOnElement(ManageJobTemplateLink);
    }

    public void clickOnViewApplicationLink() {
        logger.info("Clicking on view application link ");
        clickOnElement(ViewJobApplicationsLink);
    }

    public void clickOnInactiveJobsLink() {
        logger.info("Clicking on inactivate jobs link ");
        clickOnElement(InactiveJobsLink);
    }

    public String getTextFromPostingTypeListTitleElement() {
        logger.info("Getting text from element");
        return getTextFromElement(PostingTypeListTitle);
    }

    public void clickOnPostedDesc() {
        logger.info("Clicking on desc arrow on posted ");
        clickOnElement(PostedDesc);
    }

    public void clickOnPostedAsc() {
        logger.info("Clicking on asc arrow on posted ");
        clickOnElement(PostedAsc);
    }

    public void clickOnExpiresDesc() {
        logger.info("Clicking on desc arrow on expires ");
        clickOnElement(ExpiresDesc);
    }

    public void clickOnExpiresAsc() {
        logger.info("Clicking on asc arrow on expires ");
        clickOnElement(ExpiresAsc);
    }

    public List<String> getListOfPostedDates() {
        sortedList = getDataList(PostedDates);
        logger.info("Getting list of posted dates ");
        return sortedList;
    }

    public List<String> ascendingOrderOnPostedDates() {
        sortedList = getListByAscOrder(PostedDates);
        logger.info("Sorting posted date by asc order" + sortedList);
        return getSortedDatesAsc(sortedList);
    }

    public List<String> descendingOrderOnPostedDates() {
        sortedList = getListByDescOrder(PostedDates);
        logger.info("Sorting  posted date by desc order" + sortedList);
        return getSortedDatesDesc(sortedList);
    }

    public List<String> getListOfExpiresDates() {
        sortedList = getDataList(ExpiresDates);
        logger.info("Getting list of expires dates ");
        return sortedList;
    }

    public List<String> ascendingOrderOnExpiresDates() {
        sortedList = getListByAscOrder(ExpiresDates);
        logger.info("Sorting expires date by asc order" + sortedList);
        return getSortedDatesAsc(sortedList);
    }

    public List<String> descendingOrderOnExpiresDates() {
        sortedList = getListByDescOrder(ExpiresDates);
        logger.info("Sorting expires date by desc order" + sortedList);
        return getSortedDatesDesc(sortedList);
    }
}