package com.resumelibrary.webtest.client;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.WeakHashMap;

public class HiringPage extends Utility {

    public HiringPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(HiringPage.class);

    @FindBy(xpath = "//*[@class='ps-current']/span[1]")
    WebElement psPrev;
    @FindBy(xpath = "//*[@class='ps-current']/span[3]")
    WebElement psNext;

    public void clickOnPrevIcon() {
        logger.info("clicking on prev icon ");
        clickOnElement(psPrev);
    }

    public void clickOnNextIcon() {
        logger.info("clicking on next icon ");
        clickOnElement(psNext);
    }

    public void clickOnPSList(String slideNumber,String name) {
        logger.info("clicking on slide " + name);
        List<WebElement> listOfSlides = getThreadDriver().findElements(By.xpath("//li[@class=\"elt_" + slideNumber + "\"]/span/img"));
        for (WebElement ele : listOfSlides) {
            if (ele.getAttribute("alt").equals(name)) {
                ele.click();
                break;
            }
        }
    }

}
