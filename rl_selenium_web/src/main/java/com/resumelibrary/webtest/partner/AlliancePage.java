package com.resumelibrary.webtest.partner;

import com.resumelibrary.utilities.DataHelper;
import com.resumelibrary.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlliancePage extends Utility {

    public AlliancePage()
    {
        PageFactory.initElements(getThreadDriver(),this);
    }
    String fullName = "Automation Selenium Partner";
    String phoneNumber = "123456789";
    String inquiry = "Automation Selenium Partner form";

    @FindBy(id = "alliance-partners-btn")
    WebElement AlliancePartners;
    @FindBy(id = "become_a_partner")
    WebElement BecomeAPartner;
    @FindBy(id = "request_callback")
    WebElement RequestACallBack;
    @FindBy(id = "name")
    WebElement FullName;
    @FindBy(id = "email")
    WebElement Email;
    @FindBy(id = "number")
    WebElement PhoneNumber;
    @FindBy(id = "inquiry")
    WebElement Inquiry;

    public void clickOnBecomeAnAlliancePartnerButton() {
        clickOnElement(BecomeAPartner);
    }

    public void clickOnRequestCallBackButton() {
        clickOnElement(RequestACallBack);
        waitFor(2);
    }

    public void fillInPartnerForm() {
        FullName.sendKeys(fullName);
        Email.sendKeys(new DataHelper().getRandomPartnerEmail());
        PhoneNumber.sendKeys(phoneNumber);
        Inquiry.sendKeys(inquiry);
    }

    public void clickOnAlliancePartnersButton(){
        clickOnElement(AlliancePartners);
    }
}