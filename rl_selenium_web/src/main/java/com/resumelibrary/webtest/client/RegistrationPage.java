package com.resumelibrary.webtest.client;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends Utility {

    public RegistrationPage()
    {
        PageFactory.initElements(getThreadDriver(),this);
    }
    private static final Logger logger = LogManager.getLogger(RegistrationPage.class);

    @FindBy(id = "enter-address-manually-link")
    WebElement EnterAddressManuallyLink;
    @FindBy(id = "address_1")
    WebElement Address1;
    @FindBy(id = "state")
    WebElement State;
    @FindBy(id = "recruiter_type")
    WebElement RecruiterType;

    public void clickOnEnterAddressManuallyLink() {
        logger.info("clicking on enter address manually link ");
        clickOnElement(EnterAddressManuallyLink);
    }

    public void enterAddress1(String address) {
        logger.info("Entered address 1 " + address);
        Address1.sendKeys(address);
    }

    public void enterState(String state) {
        logger.info("Entered state " + state);
        State.sendKeys(state);
    }

    public void selectRecruiterType(String type) {
        logger.info("Selected recruiter type " + type);
        selectByVisibleText(RecruiterType, type);
    }
}