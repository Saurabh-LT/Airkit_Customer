package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CompaniesPage extends Utility {

    public CompaniesPage()
    {
        PageFactory.initElements(getThreadDriver(),this);
    }



    private static final Logger logger = LogManager.getLogger(CompaniesPage.class);

    @FindBy(id = "keywords")
    WebElement CompanyNameField;
    @FindBy(id = "search_companies_btn")
    WebElement SearchCompaniesBtn;
    @FindBy(xpath = "//div[@class='list-more-toggle']/a")
    WebElement ViewAllLink;
    @FindBy(xpath = "//button[starts-with(@id,'also-in-other-locations')]")
    WebElement AlsoInOtherLocation;
    @FindBy(id = "view-all-locations-link")
    WebElement ViewAllLocationLink;
    @FindBy(id = "other-locations-1")
    WebElement OtherLocation1;

    public void enterCompaniesName(String companyName) {
        logger.info("Entered company's name " + CompanyNameField.toString());
        CompanyNameField.sendKeys(companyName);
    }

    public void clickOnSearchCompaniesButton() {
        logger.info("Clicking on search companies button" + SearchCompaniesBtn.toString());
        clickOnElement(SearchCompaniesBtn);
    }

    public void clickOnPageNumber(String pageNumber) {
        List<WebElement> linkList = getThreadDriver().findElements(By.xpath("//ul[@class='pagination']/li/a"));
        for (WebElement ele : linkList) {
            if (ele.getText().contains(pageNumber)) {
                logger.info("Clicking on " + ele.toString());
                clickOnElement(By.xpath("//ul[@class='pagination']/li/a[contains(text(),'" + pageNumber + "')]"));
                break;
            }
        }
    }

    public void clickOnTitle(String title) {
        WebElement result = getThreadDriver().findElement(By.xpath("//*[@title='" + title + "']"));
        logger.info("Clicking on title " + result.toString());
        clickOnElement(result);
    }

    public void clickOnCompany(String text) {
        List<WebElement> linkList = getThreadDriver().findElements(By.xpath("//div[@class='list-main']/ul/li/a"));
        for (WebElement ele : linkList) {
            if (ele.getText().contains(text)) {
                logger.info("Clicking on " + ele.toString());
                clickOnElement(By.xpath("//div[@class='list-main']/ul/li/a[contains(text(),'" + text + "')]"));
                break;
            }
        }
    }

    public void clickOnViewAllLink() {
        logger.info("Clicking on view all link " + ViewAllLink.toString());
        clickOnElement(ViewAllLink);
    }

    public void clickOnPopularJobTitle(String text) {
        List<WebElement> linkList = getThreadDriver().findElements(By.xpath("//div[@class='popular-links']/div/ul/li/a"));
        for (WebElement ele : linkList) {
            if (ele.getText().contains(text)) {
                logger.info("Clicking on popular job title" + ele.toString());
                clickOnElement(By.xpath("//div[@class='popular-links']/div/ul/li/a[contains(text(),'" + text + "')]"));
                break;
            }
        }
    }

    public void clickOnAlsoOtherLocations(String alsoInOtherLocations, String viewAllLocations) {
        List<WebElement> alsoInOtherLocationElements = null;
        WebElement firstLocation = null;
        alsoInOtherLocationElements = getThreadDriver().findElements(By.xpath("//*[contains(text(),'" + alsoInOtherLocations + "')]"));
        logger.info("elements with text " + alsoInOtherLocationElements.size());
        try {
            for (WebElement alsoInOtherLocation : alsoInOtherLocationElements) {
                logger.info("click on element Also in other locations");
                waitFor(1);
                clickOnElement(alsoInOtherLocation);
                waitFor(1);
                if (isElementDisplay(ViewAllLocationLink)) {
                    waitFor(1);
                    logger.info("Element found with text : " + ViewAllLocationLink.getText());
                    verifyTextMessageUsingId(ViewAllLocationLink, viewAllLocations);
                    clickOnElement(ViewAllLocationLink);
                    waitFor(1);
                    WebElement locations = getThreadDriver().findElement(By.id(alsoInOtherLocation.getAttribute("aria-controls")));
                    firstLocation = getThreadDriver().findElement(By.xpath("//ul[@id='" + locations.getAttribute("id") + "']/li[1]/a"));
                    String locationToVerify = firstLocation.getText();
                    logger.info("found the element first location  with text :" + locationToVerify);
                    clickOnElement(firstLocation);
                    logger.info("clicked on first location : " + locationToVerify);
                    waitFor(1);
                    break;
                } else {
                    waitFor(1);
                    clickOnElement(alsoInOtherLocation);
                }
            }
        } catch (Exception e) {
            logger.info("No element found with text : " + "Also in other locations");
        }
        waitFor(1);
    }
}