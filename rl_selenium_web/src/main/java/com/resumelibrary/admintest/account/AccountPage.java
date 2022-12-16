package com.resumelibrary.admintest.account;

import com.resumelibrary.utilities.AdminURLHelper;
import com.resumelibrary.utilities.DataHelper;
import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountPage extends Utility {

    public AccountPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(AccountPage.class);

    @FindBy(id = "add_account")
    WebElement CreateAccountButton;
    @FindBy(id = "email")
    WebElement Email;
    @FindBy(id = "first_name")
    WebElement FirstName;
    @FindBy(id = "last_name")
    WebElement LastName;
    @FindBy(id = "phone")
    WebElement MainTelephone;
    @FindBy(id = "search")
    WebElement NavigationBarSearchField;
    @FindBy(id = "search_type")
    WebElement NavigationBarSearchTypeField;
    @FindBy(id = "nav-bar-search-btn")
    WebElement NavigationBarSearchButton;
    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div/div[2]/div[2]/a[2]")
    WebElement ViewAccountDetails;
    @FindBy(id = "modify-account-btn-1")
    WebElement ModifyAccountBtn1;
    @FindBy(id = "acc_property[]")
    WebElement AccountProperty;
    @FindBy(xpath = "//label[1][@class='label-radio']/span")
    WebElement ActiveAccountProperty;
    @FindBy(xpath = "//label[2][@class='label-radio']/span")
    WebElement InActiveAccountProperty;
    @FindBy(id = "update_account")
    WebElement UpdateAccount;
    @FindBy(id = "validate-account-btn-1")
    WebElement ValidateAccountButton1;
    @FindBy(id = "reject-account-btn-1")
    WebElement RejectAccountBtn1;
    @FindBy(id = "deactivate_client")
    WebElement DeactivateClient;
    @FindBy(id = "deactivate_reason")
    WebElement DeactivateReason;
    @FindBy(id = "disable_ecomm")
    WebElement DisableEcommerce;
    @FindBy(xpath = "//div[contains(text(),'Product Details')]/child::button")
    WebElement EditProductDetails;
    @FindBy(xpath = "//div[@class='checkbox-wrap']/descendant::label")
    List<WebElement> atsList;
    @FindBy(className = "view-more-fields-btn")
    WebElement ViewMoreButton;
    @FindBy(xpath = "(//*[contains(@class,'edit-trigger-btn')])[2]")
    WebElement EditButton;
    @FindBy(id = "update_account")
    WebElement SaveChangesButton;
    @FindBy(xpath = "//*[@id='edit-account-form']/div[2]/div/div[2]/div[2]/table/tbody/tr[17]/td[2]/div[1]")
    WebElement AtsApply;
    @FindBy(xpath = "//*[@id=\"edit-account-form\"]/div[2]/div/div[2]/div[2]/table/tbody/tr[3]/td[2]/div[1]/a")
    WebElement AccountUsers;
    @FindBy(id = "job_posting_spend_type")
    WebElement JobPostingSpendType;
    @FindBy(xpath = "//*[@class='col-lg-12']//a[3]")
    WebElement AddJobs;
    @FindBy(name = "spend_credit_from")
    WebElement UserList;
    @FindBy(xpath = "//*[@id=\"edit-account-form\"]/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/div[1]/a")
    WebElement JobCreditsText;
    @FindBy(css = "*[name^=\"job_posting_credits_user\"]")
    WebElement JobCredits;
    @FindBy(xpath = "//*[@class='header-title']/h1")
    WebElement AccountHeaderTitle;
    @FindBy(id = "actions-btn")
    WebElement ActionBtn;


    public void clickCreateAccountButton() {
        clickOnElement(CreateAccountButton);
    }

    public void clickViewAccountDetails() {
        clickOnElement(ViewAccountDetails);
    }

    public void fillInTheField(String field) {
        switch (field) {
            case "Email":
                Email.sendKeys(new DataHelper().getRandomAccountEmail());
                break;
            case "First Name":
                FirstName.sendKeys("Automation partner");
                break;
            case "Last Name":
                LastName.sendKeys("Admin Test");
                break;
            case "Main Telephone":
                MainTelephone.sendKeys("123456789");
                break;
        }
    }

    public void shouldBeOnAccountViewPage() {
        adminUrlMatch(AdminURLHelper.getAccountViewPage());
    }

    public void ShouldBeOnAccountSearchResultsPage() {
        adminUrlMatch(AdminURLHelper.getAccountSearchResultsPage());
    }

    public void searchForInTheNavigationBar(String text) {
        waitUntilElementToBeClickable(NavigationBarSearchField, 5);
        NavigationBarSearchField.sendKeys(text);
        logger.info("Searched email address --> : " + text);
        selectByValueFromDropDown(NavigationBarSearchTypeField, "accounts");
        clickOnElement(NavigationBarSearchButton);
    }

    public void clickOnModifyAccountBtn1() {
        logger.info("Clicking on modify account button one");
        clickOnElement(ModifyAccountBtn1);
    }

    public void selectFromAccountProperty(String value) {
        logger.info("Selected from account property" + value);
        selectByVisibleTextFromDropDown(AccountProperty, value);
    }

    public void clickOnUpdateAccount() {
        logger.info("Clicking on update account");
        clickOnElement(UpdateAccount);
    }

    public void clickOnValidateAccountButton1() {
        logger.info("Clicking on valid account button one");
        clickOnElement(ValidateAccountButton1);
    }

    public void clickOnRejectAccountBtn1() {
        logger.info("Clicking on reject account button one");
        clickOnElement(RejectAccountBtn1);
    }

    public void clickOnDeactivateClient() {
        logger.info("Clicking on deactivate client");
        clickOnElement(DeactivateClient);
    }

    public void selectDeactivateReasonFromDropdown(String reason) {
        logger.info("Selected deactivate reason from list " + reason);
        selectByVisibleTextFromDropDown(DeactivateReason, reason);
    }

    public void selectDisableEcommerceFromDropdown(String reason) {
        logger.info("Selected Disable Ecommerce from list " + reason);
        selectByVisibleTextFromDropDown(DisableEcommerce, reason);
    }

    public void clickOnEditProductDetails() {
        logger.info("Clicking on Edit button");
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(2);
        }
        clickOnElement(EditProductDetails);
    }

    public void enterAtsFromList(String text) {
        logger.info("Enter ATS ");
        for (WebElement ele : atsList) {
            if (ele.getText().replaceAll("\n", " ").equals(text)) {
                ele.click();
            }
        }
    }

    public void selectAccountTypeRadioButtonAs(String radioButtonValue) {
        if (radioButtonValue.equals("Active")) {
            clickOnElementUsingActions(ActiveAccountProperty);
        } else if (radioButtonValue.equals("Inactive")) {
            clickOnElementUsingActions(InActiveAccountProperty);
        }
    }

    public void clickViewMoreButton() {
        logger.info("Clicking on view more button");
        waitUntilElementIsLocated(ViewMoreButton, 10);
        clickOnElementWithJS(ViewMoreButton);
    }

    public void clickEditButton() {
        logger.info("Clicking on edit button ");
        clickOnElement(EditButton);
    }

    public void clickSaveChangesButton() {
        SaveChangesButton.click();
    }

    public String getAtsApplyFieldValue() {
        logger.info("Verifying Ats Apply value " + AtsApply.getText());
        return AtsApply.getText();
    }

    public void clickAccountUsers() {
        logger.info("Clicking on account users ");
        clickOnElementWithJS(AccountUsers);
    }

    public void selectJobPostingSpendType(String type) {
        logger.info("Selected job posting spend type " + type);
        waitUntilElementIsLocated(JobPostingSpendType, 10);
        selectByVisibleTextFromDropDown(JobPostingSpendType, type);
    }

    public void clickOnAddJobs() {
        logger.info("Clicking on add Jobs link ");
        clickOnElement(AddJobs);
    }

    public void selectUsersFromDropdown(String value) {
        logger.info("Selected users from list" + value);
        selectByVisibleTextFromDropDown(UserList, value);
    }

    public String getTextFromJobCredit() {
        logger.info("Getting text to verify credit is deducted");
        return getTextFromElement(JobCreditsText);
    }

    public void enterJobCredits(String text) {
        logger.info("entering job credits :  " + text);
        clearTextFromField(JobCredits);
        sendTextToElement(JobCredits, text);
    }

    public String getTextFromAccountHeaderTitle() {
        logger.info("Getting text from header title");
        return getTextFromElement(AccountHeaderTitle);
    }

    public void clickOnActionButton() {
        logger.info("Clicking on action account button ");
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(2);
        }
        clickOnElement(ActionBtn);
    }
    public void jobPostingSpendType(String account, String client) {
        logger.info("Job posting spend type is " + account + "or" + client);
        Select select = new Select(JobPostingSpendType);
        WebElement option = select.getFirstSelectedOption();
        String defaultItem = option.getText();
        if (defaultItem.equals(client)) {
            selectByVisibleText(JobPostingSpendType, account);
            new AccountPage().clickOnUpdateAccount();
        }
    }
}