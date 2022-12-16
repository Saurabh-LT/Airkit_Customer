package com.resumelibrary.webtest.client;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;

public class ResourcesPage extends Utility {

    public ResourcesPage()
    {
        PageFactory.initElements(getThreadDriver(),this);
    }
    private static final Logger logger = LogManager.getLogger(ResourcesPage.class);

    @FindBy(xpath = "//a[contains(text(),'Resume Search')]")
    WebElement ResumeSearch;
    @FindBy(xpath = "//*[@id=\"resume-search\"]/dialog[10]/div/button")
    WebElement PopupCloseResumeSearchBuilder;
    @FindBy(xpath = "//*[@id=\"resume-search\"]/dialog[9]/div/button")
    WebElement PopupCloseResumeSearchBuilder9;
    @FindBy(xpath = "//*[@id=\"job-dashboard\"]/dialog[2]/div/button")
    WebElement PopupAuthenticationRequired;
    @FindBy(xpath = "//*[@id=\"client-help\"]/dialog[2]/div/button")
    WebElement PopupClientHelp;
    @FindBy(xpath = "//nav[@label='Site Navigation']/ul/li[12]/a[@class='cart-link']")
    WebElement ShoppingCartLink;
    @FindBy(xpath = "//p[@class='sub-nav-p']/a")
    WebElement CandidateDatabase;
    @FindBy(xpath = "//div[@class='col-crc-details']/a")
    WebElement ContactUsEmailAddress;
    @FindBy(id = "contact-form-btn")
    WebElement ContactFormBtn;
    @FindBy(id = "help-center-btn")
    WebElement HelpCenterBtn;
    @FindBy(id = "client-contact-us-btn")
    WebElement ClientContactUsBtn;
    @FindBy(id = "transparent-button")
    WebElement TransparentButton;
    @FindBy(xpath = "//*[@id=\"header-text\"]")
    WebElement ContactUsHeaderText;

    public void clickOnSearchOurCandidateTodayLink() {
        logger.info("Clicking on search our candidate today link");
        clickOnElement(CandidateDatabase);
    }

    public boolean ContactUsEmailAddressLinkIsDisplay() {
        logger.info("Verifying contact us email address link is display");
        if (isElementDisplay(ContactUsEmailAddress)) {
            return true;
        }
        return false;
    }

    public void clickOnContactFormBtn() {
        logger.info("Clicking on contact form button");
        clickOnElement(ContactFormBtn);
    }

    public void clickOnHelpCenterBtn() {
        logger.info("Clicking on help center button");
        clickOnElement(HelpCenterBtn);
    }

    public void clickOnClientContactUsBtn() {
        logger.info("Clicking on client contact us button");
        clickOnElement(ClientContactUsBtn);
        waitFor(2);
    }

    public void mouseHoverHyperLink(String text) {
        mouseHoverToElementLink(text);
    }

    public void clickOnAuthenticationRequiredPopupCloseBtn() {
        logger.info("Clicking on PopupAuthenticationRequired ");
        clickOnElement(PopupAuthenticationRequired);
    }

    public void clickOnResumeSearchBuilderPopupCloseBtn() {
        logger.info("Clicking on PopupCloseResumeSearchBuilder ");
        clickOnElement(PopupCloseResumeSearchBuilder);
    }

    public void shouldNotSeeShoppingCartLink() {
        logger.info("checking for element shopping cart");
        Assert.assertFalse(verifyThatElementIsDisplayed(ShoppingCartLink),"[---> " + ShoppingCartLink + " is displayed <---]");
    }

    public void clientHelpPopupCloseBtn() {
        logger.info("Clicking on PopupClientHelp ");
        clickOnElement(PopupClientHelp);
    }

    public void clickOnLinkInFooter(String link, String footer) {
      //  String module = footer.replaceAll(" ", "-");
       // logger.info("module  text :" + module);
        //String xpath="(//*[text()='"+link+"'])[2]";
        String xpath= "//*[text()='"+footer+"' and @class='mobile-hidden-footer']/..//a[text()='"+link+"']";
        logger.info("Footer link xpath  is :" + xpath);
        WebElement element=getThreadDriver().findElement(By.xpath(xpath));
        clickOnElement(element);
//        List<WebElement> linkList = getThreadDriver().findElements(By.xpath(String.format("//*[@id='footer-%s']/ul/li/a", module)));
//        for (WebElement ele : linkList) {
//            if (ele.getText().contains(link)) {
//                logger.info("Clicking on element contains text :" + link);
//                try {
//                    clickOnElement(ele);
//                }catch (StaleElementReferenceException e){
//                        getThreadDriver().navigate().to(getThreadDriver().getCurrentUrl());
//                        webDriverWait();
//                            JavascriptExecutor executor = (JavascriptExecutor)getThreadDriver();
//                            executor.executeScript("arguments[0].click();", ele);
//                        break;
//                    }
//                }
//                break;
//            }
        }

    public void clickOnResumeSearchBuilderPopup() {
        logger.info("Clicking on PopupCloseResumeSearchBuilder9 ");
        clickOnElement(PopupCloseResumeSearchBuilder9);
    }

    public boolean ChatWindowIsDisplayed() {
        waitFor(2);
        logger.info("verifying the chat window is displayed.");
        return isElementDisplay(TransparentButton);
    }

    public void clickOnEnevolope() {
        logger.info("click on  the chat window ");
        clickOnElement(TransparentButton);
    }

    public boolean contctUspopupDisplayed(String text) {
        getThreadDriver().switchTo().frame("designstudio-iframe");
        logger.info("pop up is displayed with text :" + text + "text from element :  " + ContactUsHeaderText.getText());
        return ContactUsHeaderText.getText().equals(text);
    }
}
