package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.utilities.WebURLHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends Utility {

    public LogoutPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(LogoutPage.class);

    public void clickLogout() {
        logger.info("Go to logout url directly ");
        getDriverWithUrl(WebURLHelper.getWebUrl(), WebURLHelper.getLoggedOutUrl());
        waitFor(2);
    }

    public void clickViewAllJobMatches(String element) {
        logger.info("Clicking on view all job matches " + element);
        clickOnElementUsingText(element);
    }

    public void mouseHover(String element) {
        logger.info("Mouse hover to element " + element);
        mouseHoverOnElement(element);
    }
}