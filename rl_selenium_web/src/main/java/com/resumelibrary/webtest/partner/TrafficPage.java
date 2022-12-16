package com.resumelibrary.webtest.partner;

import com.resumelibrary.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrafficPage extends Utility {

    public TrafficPage()
    {
        PageFactory.initElements(getThreadDriver(),this);
    }

    @FindBy(id = "traffic-partners-btn")
    WebElement TrafficPartners;
    @FindBy(id = "become_a_partner")
    WebElement BecomeAPartner;

    public void clickOnBecomeAPartnerButton() {
        clickOnElement(BecomeAPartner);
    }

    public void clickOnTrafficPartnersButton() {
        clickOnElement(TrafficPartners);
    }
}