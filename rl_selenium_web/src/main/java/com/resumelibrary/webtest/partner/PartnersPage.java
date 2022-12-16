package com.resumelibrary.webtest.partner;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PartnersPage extends Utility {

    public PartnersPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(PartnersPage.class);

    @FindBy(id = "become-a-partner-btn")
    WebElement BecomeAPartner;
    @FindBy(id = "send")
    WebElement RequestACallBack;

    @FindBy(id = "checkbox-all-integrations")
    WebElement AllIntegrationsCheckbox;

    @FindBy(id = "checkbox-ats-import")
    WebElement ATSImportCheckbox;

    @FindBy(xpath = "//*[@id=\"player\"]/div[*]/div[3]/button/div[2]")
    WebElement VideoIntegrationsPage;
    @FindBy(xpath = "//*[@id=\"player\"]/div[*]/div[3]/button/div[3]")
    WebElement VideoPauseBtn;


    public void clickOnBecomeAPartnerButton() {
        clickOnElement(BecomeAPartner);
    }

    public void clickOnRequestCallBackButton() {
        clickOnElement(RequestACallBack);
    }

    public boolean verifyThatAllIntegrationsCheckboxIsSelected() {
        return AllIntegrationsCheckbox.isSelected();
    }

    public boolean verifyThatAllIntegrationsCheckboxIsNotSelected() {
        return !AllIntegrationsCheckbox.isSelected();
    }

    public void clickATSImportCheckbox() {
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(1);
        }
        clickOnElement(ATSImportCheckbox);
    }

    public void clickOnVideoIntegrationsPage(String iframe) {
        WebElement Element = getThreadDriver().findElement(By.xpath("//*[@id=\"main\"]/section[1]/div/div[2]/div/div/iframe"));
        getThreadDriver().switchTo().frame(Element);
        clickOnElement(VideoIntegrationsPage);
        waitFor(5);
        clickOnElement(VideoPauseBtn);
        getThreadDriver().switchTo().defaultContent();
    }
}