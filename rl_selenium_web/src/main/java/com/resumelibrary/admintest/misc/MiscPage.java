package com.resumelibrary.admintest.misc;

import com.resumelibrary.utilities.AdminURLHelper;
import com.resumelibrary.utilities.DataHelper;
import com.resumelibrary.utilities.Utility;
import net.bytebuddy.asm.Advice;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MiscPage extends Utility {

    public MiscPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(MiscPage.class);

    String adminHomePageTitle = "Resume Library Admin";

    @FindBy(name = "username")
    WebElement UserName;
    @FindBy(name = "password")
    WebElement Password;
    @FindBy(id = "loginButton")
    WebElement LoginButton;
    @FindBy(id = "add_partner")
    WebElement AddPartnerAllianceButton;
    @FindBy(name = "company_name")
    WebElement PartnerCompanyName;
    @FindBy(name = "first_name")
    WebElement FirstName;
    @FindBy(name = "last_name")
    WebElement LastName;
    @FindBy(name = "email")
    WebElement Email;
    @FindBy(id = "partner-type")
    WebElement PartnerType;
    @FindBy(id = "save_job")
    WebElement AddJobButton;
    @FindBy(id = "region_select")
    WebElement State;
    @FindBy(id = "salary_time_period")
    WebElement SalaryTimePeriod;
    @FindBy(id = "job_type")
    WebElement JobType;
    @FindBy(id = "state")
    WebElement JobStatus;
    @FindBy(id = "apply_api_type")
    WebElement ATSApply;
    @FindBy(id = "location")
    WebElement TownCityZip;
    @FindBy(name = "title")
    WebElement JobTitle;
    @FindBy(id = "salary_min")
    WebElement MinimumSalary;
    @FindBy(id = "salary_max")
    WebElement MaximumSalary;
    @FindBy(id = "account")
    WebElement Account;
    @FindBy(id = "company_name")
    WebElement JobCompanyName;
    @FindBy(id = "account_type")
    WebElement AccountType;
    @FindBy(id = "sector")
    WebElement Sector;
    @FindBy(id = "apply_type")
    WebElement applyType;

    @FindBy(name = "spend_credit")
    WebElement SpendCredit;
    @FindBy(name = "expiry_date")
    WebElement ExpiryDate;
    @FindBy(id = "posted")
    WebElement Posted;
    @FindBy(id = "premium_until")
    WebElement PremiumUntil;
    @FindBy(id = "update_job")
    WebElement UpdateJob;
    @FindBy(name = "title")
    WebElement Title;
    @FindBy(id = "select-product-type")
    WebElement SelectProductType;
    @FindBy(id = "payment_type")
    WebElement PaymentType;
    @FindBy(id = "select-apply-to-user")
    WebElement SelectApplyToUser;
    @FindBy(id = "mark-paid-no")
    WebElement MarkAspPidYesNo;
    @FindBy(id = "pay_as_user_id")
    WebElement PayAsUserId;
    @FindBy(id = "sales_user_id")
    WebElement SalesUserId;
    @FindBy(xpath = "//*[@id=\"save-this-card\"]")
    WebElement SaveThisCardCheckBox;
    @FindBy(id = "confirm-payment-btn")
    WebElement ConfirmPaymentBtn;
    @FindBy(xpath = "//textarea[@class='form-control product_description']")
    WebElement ProductDescription;
    @FindBy(xpath = "//input[@class='form-control unit_cost']")
    WebElement UnitCost;
    @FindBy(xpath = "//*[@id=\"candidate_unlock_spend_type\"]")
    WebElement candiateUnlock;
    @FindBy(xpath = "//*[contains(text(),'Product Details')]/button")
    WebElement editButton;
    @FindBy(xpath = "//*[@class='overview-cell']/p[text()='Active Jobs']/..//a")
    WebElement activeJobs;
    @FindBy(xpath = "//*[@class='overview-cell']/p[text()='Applications']/..//a")
    WebElement applications;

    public void loginAsAdminUser() {
        loadAdminHomePage();
        UserName.sendKeys(DataHelper.getAdminUsername());
        Password.sendKeys(DataHelper.getAdminPassword());
        clickOnElement(LoginButton);
    }

    public void shouldBeOnDashBoard() {
        String currentPageTitle = getThreadDriver().getTitle();
        Assert.assertEquals(currentPageTitle, adminHomePageTitle);
    }

    public void goToAddPartnerPage() {
        loadAdminUrl(AdminURLHelper.getAddPartnerUrl());
    }

    public void goToAddJobsPage() {
        loadAdminUrl(AdminURLHelper.getAddJobsUrl());
    }

    public void clickAddPartnerAllianceButton() {
        clickOnElement(AddPartnerAllianceButton);
    }

    public void clickAddJobButton() {
        clickOnElement(AddJobButton);
    }

    public void fillIn(String field) {
        switch (field) {
            case "Partner Company Name":
                PartnerCompanyName.sendKeys(new DataHelper().getRandomCompanyName());
                break;
            case "Contact First Name":
                FirstName.sendKeys("Automation partner");
                break;
            case "Contact Last Name":
                LastName.sendKeys("Admin Test");
                break;
            case "Contact Email":
                Email.sendKeys(new DataHelper().getRandomPartnerEmail());
                break;
            case "Town/City/Zip":
                TownCityZip.sendKeys("Los Angeles, CA");
                waitFor(2);
                TownCityZip.sendKeys(Keys.ESCAPE);
                break;
            case "Job Title":
                JobTitle.sendKeys("Automation test job - admin");
                break;
            case "Minimum Salary":
                MinimumSalary.sendKeys("10000");
                break;
            case "Maximum Salary":
                MaximumSalary.sendKeys("20000");
                break;
            case "Account":
                Account.sendKeys("Acme Company No 1728 - 1478");
                setAccountIdToHiddenField();
                break;
            case "Company Name":
                JobCompanyName.sendKeys(new DataHelper().getRandomCompanyName());
                waitFor(2);
                JobCompanyName.sendKeys(Keys.ESCAPE);
                break;
        }
    }

    public void selectOptionFromField(String option, String field) {
        switch (field) {
            case "Partner Type":
                selectByVisibleText(PartnerType, option);
                break;
            case "State":
                selectByVisibleText(State, option);
                break;
            case "Job Type":
                selectByVisibleText(JobType, option);
                break;
            case "Salary Time Period":
                selectByVisibleText(SalaryTimePeriod, option);
                break;
            case "Status":
                if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
                    waitFor(1);
                }
                selectByVisibleText(JobStatus, option);
                break;
            case "ATS Apply":
                selectByVisibleText(ATSApply, option);
                break;
            case "Account Type":
                selectByVisibleTextFromDropDown(AccountType, option);
                break;
            case "Sector":
                if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
                    waitFor(1);
                }
                selectByVisibleText(Sector, option);
                break;
            case "Apply Type":
                selectByVisibleText(applyType, option);
                break;
        }
    }

    public void fillInDescriptionInTheTextArea() {
        String javaScript = "CKEDITOR.instances[\"description\"].setData(\"This is automation test job. Please ignore This is automation test job. Please ignore This is automation test job. Please ignore This is automation test job. Please ignore This is automation test job. Please ignore This is automation test job. Please ignore This is automation test job. Please ignore This is automation test job. Please ignore This is automation test job. Please ignore This is automation test job. Please ignore This is automation test job. Please ignore This is automation test job. Please ignore This is automation test job. Please ignore This is automation test job. Please ignore This is automation test job. Please ignore\");";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getThreadDriver();
        javascriptExecutor.executeScript(javaScript);
    }

    public void setAccountIdToHiddenField() {
        String javaScript = "document.getElementById('account_id').value='1478'";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getThreadDriver();
        javascriptExecutor.executeScript(javaScript);
    }

    public void setAccountIdToHiddenField(String value) {
        String javaScript = "document.getElementById('account_id').value='" + value + "'";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getThreadDriver();
        javascriptExecutor.executeScript(javaScript);
    }

    public void selectSpendCreditFromDropDown(String credit) {
        logger.info("Selected spend credit from dropdown  " + credit);
        selectByValueFromDropDown(SpendCredit, credit);
    }

    public void enterExpiryDate(String date) {
        logger.info("Entered expiry date with : " + date);
        ExpiryDate.clear();
        ExpiryDate.sendKeys(date);
    }

    public void enterPostedDate(String date) {
        logger.info("Entered posted date with : " + date);
        Posted.clear();
        Posted.sendKeys(date);
    }

    public void enterPremiumUntil(String date) {
        logger.info("Entered premium until date with : " + date);
        PremiumUntil.clear();
        PremiumUntil.sendKeys(date);
    }

    public void clickOnUpdateJob() {
        logger.info("Clicking on updater job ");
        clickOnElement(UpdateJob);
    }

    public void enterJobTitle(String title) {
        logger.info("The entered Job Title is : " + title);
        clearTextFromField(Title);
        Title.sendKeys(title);
    }

    public void selectContact(String contact) {
        logger.info("select the option : " + contact + " from contact");
        selectByVisibleTextFromDropDown(PayAsUserId, contact);
    }

    public void selectSalesPerson(String salesPerson) {
        logger.info("select the option : " + salesPerson + " from salesPerson");
        selectByVisibleTextFromDropDown(SalesUserId, salesPerson);
    }

    public void selectProduct(String product) {
        logger.info("select the option : " + product + " from Product");
        selectByVisibleTextFromDropDown(SelectProductType, product);
    }

    public void selectApplyTo(String applyTo) {
        logger.info("select the option : " + applyTo + " from Apply To");
        selectByVisibleTextFromDropDown(SelectApplyToUser, applyTo);
    }

    public void selectPaymentType(String paymentType) {
        logger.info("select the option : " + paymentType + " from Payment Type");
        selectByVisibleTextFromDropDown(PaymentType, paymentType);
    }

    public void clickOnMarkAsPaid() {
        logger.info("click on Mark as Paid : " + MarkAspPidYesNo.getText());
        clickOnElement(MarkAspPidYesNo);
    }

    public void clickOnSaveThisCard() {
        logger.info("click on Save This Card CheckBox :");
        clickOnElement(SaveThisCardCheckBox);
    }

    public void clickOnConfirmPayment() {
        logger.info("click on Confirm Payment button");
        clickOnElement(ConfirmPaymentBtn);
    }

    public void enterProductDescription(String description) {
        logger.info("Entering the product description as : " + description);
        ProductDescription.sendKeys(description);
    }

    public void enterUnitCost(String unitCost) {
        logger.info("Entering the unit cost as : " + unitCost);
        UnitCost.sendKeys(unitCost);
    }

    public void updateCandidateUnlock() {
        logger.info("Update account details as CLIENT in Admin Page");
        if (verifyThatElementIsDisplayed(editButton)) {
            clickOnElement(editButton);
        }
        selectByVisibleText(candiateUnlock, "CLIENT");
        clickOnElementUsingText("Save Changes");
    }

    public void clickActiveJobs() {
        clickOnElement(activeJobs);
    }

    public void clickApplications() {
        clickOnElement(applications);
    }

    public void waitUntilTextIsPresentInHeaderWithBR(String text) {
        String str = text.split(" ")[0];
        WebElement result = getThreadDriver().findElement(By.xpath("//th[text()[contains(.,'" + text.split(" ")[0] + "')] and text()[contains(.,'" + text.split(" ")[1] + "')]]"));
        System.out.println("result.getText()" + result.getText() + "text:" + text);
        waitUntilTextToBePresent(result, str);
    }

    public void waitUntilTextIsPresentInHeader(String text) {
        WebElement result = getThreadDriver().findElement(By.xpath("//th[contains(text(),\"" + text + "\")]"));
        waitUntilTextToBePresent(result, text);
    }

    public boolean verifyTextMessageinTHwithBR(String text) {
        logger.info("Verifying text message " + text);
        String str = text.split(" ")[0];

        waitFor(1);
        WebElement result = null;
        try {
            result = getThreadDriver().findElement(By.xpath("//th[text()[contains(.,'" + text.split(" ")[0] + "')] and text()[contains(.,'" + text.split(" ")[1] + "')]]"));
            logger.info("Element : " + result.toString() + "found with text " + result.getText());
            waitUntilTextToBePresent(result, str);
        } catch (NoSuchElementException nse) {
            logger.info("No Element found with text " + text);
        }
        assert result != null;
        if (!result.isDisplayed()) {
            return getTextFromElement(result).contains(str);
        }
        waitUntilTextToBePresent(result, str);
        return result.getText().replace("\n", " ").contains(text);
    }

    public boolean verifyTextMessageinTH(String text) {
        logger.info("Verifying text message " + text);
        waitFor(1);
        WebElement result = null;
        try {
            result = getThreadDriver().findElement(By.xpath("//th[contains(text(),\"" + text + "\")]"));
            logger.info("Element : " + result.toString() + "found with text " + result.getText());

        } catch (NoSuchElementException nse) {
            logger.info("No Element found with text " + text);
        }
        assert result != null;
        if (!result.isDisplayed()) {
            return getTextFromElement(getDisplayedElement(text)).contains(text);
        }
        waitUntilTextToBePresent(result, text);
        return getTextFromElement(result).contains(text);
    }

    public void enterAccountNumber(String accountNum) {
        logger.info("Entering the account number as : " + accountNum);
        Account.sendKeys(accountNum);
    }
}