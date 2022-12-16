package com.resumelibrary.cucumber;

import com.resumelibrary.utilities.PropertyFileReader;
import com.resumelibrary.webdriverprovider.WebDriverProvider;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/*public class BrowserStackListener extends WebDriverProvider implements ITestListener {

    private static final Logger logger = LogManager.getLogger(BrowserStackListener.class);
    private static final String TEST_STATUS_SCRIPT = "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"%s\", \"reason\": \"%s\"}}";
    WebDriverProvider webDriverProvider;

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("ITestResult ---> " + result.toString());
        String msg;
        String status = "PASSED";
        String reason = "Scenario Passed";
        if (null != result.getThrowable()) {
            reason = result.getThrowable().getMessage();
        }
        status = "FAILED";
        logBrowserStackError(status, reason);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    private void logBrowserStackError(String status, String reason) {
        String browser = PropertyFileReader.getInstance().getProperty("browserName");
        logger.info("browser name  ---> " + browser);
        logger.info("Status of the test case " + status);
        String STATUS_MESSAGE = reason.replaceAll("\"", "'");
        logger.info("STATUS_MESSAGE" + STATUS_MESSAGE);
        try {
            if (browser.equals("browserStack")) {
                if (status.equals("FAILED")) {
                    ((JavascriptExecutor) getThreadDriver()).executeScript(String.format(TEST_STATUS_SCRIPT, status, "Check Text Logs"));
                }
                if (status.equals("PASSED"))
                    ((JavascriptExecutor) getThreadDriver()).executeScript(String.format(TEST_STATUS_SCRIPT, status, "Test SuccessFul"));

                // quitDriver();
            }
        } catch (Exception e) {
            logger.info("" + e.getMessage());
        }
    }
}*/
