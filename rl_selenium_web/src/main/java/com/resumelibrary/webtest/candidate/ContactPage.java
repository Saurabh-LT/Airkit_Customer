package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;

public class ContactPage extends Utility {

    public ContactPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(ContactPage.class);

    @FindBy(id = "faq-search-type")
    WebElement FaqSearchTypeDropdown;
    @FindBy(id = "faq-search-input")
    WebElement FaqSearchInputField;
    @FindBy(id = "cand-delete")
    WebElement CandidateDeleteText;
    @FindBy(id = "name")
    WebElement NameField;
    @FindBy(id = "message")
    WebElement MessageField;
    @FindBy(id = "confirm_email")
    WebElement ConfirmEmailField;
    @FindBy(xpath = "//*[@class = 'success-div mt20 delay-fade']")
    WebElement SuccessMessage;

    public void selectFaqSearchTypeFromDropdown(String text) {
        logger.info("Selected faq search type from dropdown" + FaqSearchTypeDropdown.toString());
        selectByVisibleTextFromDropDown(FaqSearchTypeDropdown, text);
    }

    public void EnterFaqSearchInInputField(String input) {
        logger.info("Entered faq search in to input field" + FaqSearchInputField.toString());
        FaqSearchInputField.sendKeys(input);
    }

    public String getTextFromElement(String text) {
        logger.info("Getting text to verify faq search" + CandidateDeleteText.toString());
        return getTextFromElement(CandidateDeleteText);
    }

    public void enterName(String name) {
        logger.info("Entered name to field" + NameField.toString());
        NameField.sendKeys(name);
    }

    public void enterConfirmEmail(String confirmEmail) {
        logger.info("Entered confirm email address" + ConfirmEmailField);
        ConfirmEmailField.sendKeys(confirmEmail);
    }

    public void enterMessage(String message) {
        logger.info("Entered message" + MessageField.toString());
        MessageField.sendKeys(message);
    }

    public void ContactPageLinks(String links) {
        List<WebElement> linkList = getThreadDriver().findElements(By.xpath("//*[@class='btn-sm help-center-btn']"));
        for (WebElement ele : linkList) {
            if (ele.getText().contains(links)) {
                clickOnElement(By.xpath("//*[@class='btn-sm help-center-btn'][contains(text(),'" + links + "')]"));
                break;
            }
        }
    }

    public void shouldSeeMessageInContactXpath(String text) {
        waitUntilElementIsLocated(SuccessMessage, 10);
        String successMessageText = SuccessMessage.getText();
        logger.info("success message " + successMessageText);
        Assert.assertEquals(successMessageText, text);
    }
}