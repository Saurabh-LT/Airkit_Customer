package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationPage extends Utility {

    public ApplicationPage()
    {
        PageFactory.initElements(getThreadDriver(),this);
    }
    private static final Logger logger = LogManager.getLogger(ApplicationPage.class);

    @FindBy(id = "hide_expired")
    WebElement HideExpiredCheckbox;

    public boolean verifyThatHideExpiredCheckboxIsNotSelected(){
        logger.info("Verifying that hide expired check box is not selected "+ HideExpiredCheckbox);
       if (!HideExpiredCheckbox.isSelected()){
       }
        return true;
    }

    public boolean verifyThatHideExpiredCheckboxIsSelected(){
        logger.info("Verifying that hide expired check box is selected "+ HideExpiredCheckbox);
        if (HideExpiredCheckbox.isSelected()){
        }
        return true;
    }
}