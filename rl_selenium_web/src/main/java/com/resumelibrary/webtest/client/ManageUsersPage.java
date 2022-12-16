package com.resumelibrary.webtest.client;

import com.resumelibrary.utilities.DataHelper;
import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ManageUsersPage extends Utility {

    public ManageUsersPage()
    {
        PageFactory.initElements(getThreadDriver(),this);
    }
    private static final Logger logger = LogManager.getLogger(ManageUsersPage.class);

    @FindBy(id = "manage-users-active-action-1")
    WebElement ManageUsersActiveActionOne;
    @FindBy(id = "popup-title2")
    WebElement PopupTitleTwo;
    @FindBy(id = "manage-users-inactive-action-95")
    WebElement ManageUsersInactiveActionNinetyFive;
    @FindBy(id = "from_client")
    WebElement FromClient;
    @FindBy(id = "to_client")
    WebElement ToClient;
    @FindBy(id = "amount")
    WebElement Amount;
    @FindBy(css = ".submit-transfer-btn")
    WebElement SubmitTransferButton;
    @FindBy(id = "reset-email")
    WebElement ResetEmailAddress;
    @FindBy(id = "signin-as-jobseeker")
    WebElement SigninAsJobseeker;
    @FindBy(xpath = "//*[@class='success-div mt20 mb20']")
    WebElement SuccessMessage;
    @FindBy(xpath = "//*[@id=\"main\"]/div/form/button")
    WebElement addUserBtn;

    public void clickOnManageUsersActiveActionOne() {
        waitUntilElementIsLocated(ManageUsersActiveActionOne,20);
        clickOnElement(ManageUsersActiveActionOne);
        waitFor(1);
    }

    public String verifyTextDeactivateUser(String text) {
        logger.info("verifying text : " + PopupTitleTwo.toString() + "against : " + text);
        return PopupTitleTwo.getText();
    }

 /*   public void clickOnManageUsersInactiveActionNinetyFive() {
        logger.info("finding the web element with Inactive text");
        WebElement inactiveWebElement;
        List<WebElement> webElementList = driver.findElements(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[2]/table/tbody/tr/td[3]"));
        int row = 1;
        for (WebElement w : webElementList) {

            if (w.getText().contains("Inactive")) {
                logger.info("found the web element with Inactive text in the table row number : " + row);
                inactiveWebElement = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[2]/table/tbody/tr[" + String.valueOf(row) + "]/td[5]"));
                logger.info("found the web element : " + inactiveWebElement.getText());
                clickOnElement(inactiveWebElement);
                break;
            }
            row++;
        }

        //ManageUsersInactiveActionNinetyFive.click();
        waitFor(1);
    }*/

    public void clickOnManageUsersInactiveAction() {
        WebElement inactiveWebElement = getThreadDriver().findElement(By.xpath("//*[starts-with(@id,'manage-users-inactive-action')]"));
        logger.info("finding the web element with Inactive text " + inactiveWebElement.getText());
        inactiveWebElement.click();
    }

    public void selectFromClient(String fromValue) {
        logger.info("select value from client : " + fromValue);
        selectByValueFromDropDown(FromClient, fromValue);
    }

    public void selectToClient(String toValue) {
        logger.info("select value to client : " + toValue);
       selectByValueFromDropDown(ToClient, toValue);
    }

    public void enterAmount(String amount) {
        logger.info("entered the value for amount is : " + amount);
        Amount.sendKeys(amount);
    }

    public void clickOnTransferButton() {
        logger.info("clicked on <Transfer> Button");
        clickOnElement(SubmitTransferButton);
        waitFor(1);
    }

    public void enterEmailAddressToResetPassword() {
        logger.info("Entered email address " + DataHelper.getTestClientEmail());
        ResetEmailAddress.sendKeys(DataHelper.getTestClientEmail());
    }

    public void verifyButton(String text) {
        logger.info("verifying the button with text : " + text);
        Assert.assertTrue(text.equalsIgnoreCase(SigninAsJobseeker.getText()),"[---> " + SigninAsJobseeker.getText() + " is not visible <---]");
    }

    public WebElement verifyAndUpdate(String text) {
        logger.info("verifying the button with text : " + text);
        WebElement transferCreditsElem = getThreadDriver().findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
        return getElementByText(text);
    }

    public void shouldSeeMessageInTheManageUsersXpath(String text) {
        waitUntilElementIsLocated(SuccessMessage,5);
        String successMessageText = SuccessMessage.getText();
        logger.info("success message " + successMessageText);
        Assert.assertEquals(successMessageText,text);
    }

    public void clickOnAddUserBtn() {
        clickOnElement(addUserBtn);
    }
}