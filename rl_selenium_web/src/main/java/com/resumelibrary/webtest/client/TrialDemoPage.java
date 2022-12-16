package com.resumelibrary.webtest.client;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrialDemoPage extends Utility {

    public TrialDemoPage()
    {
        PageFactory.initElements(getThreadDriver(),this);
    }
    private static final Logger logger = LogManager.getLogger(TrialDemoPage.class);

    @FindBy(id = "approx_hires")
    WebElement ApproxHires;

    public void selectFromApproxHires(String hires){
        logger.info("Selected approximate hires per year "+hires);
        selectByValueFromDropDown(ApproxHires,hires);
    }
}