package com.resumelibrary.webdriverprovider;

import com.resumelibrary.utilities.Constants;
import com.resumelibrary.utilities.PropertyFileReader;
import com.resumelibrary.utilities.WebURLHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverController  extends CloudDriverProvider implements Constants{

    private static final Logger logger = LogManager.getLogger(DriverController.class);


    public DriverController() {
        PageFactory.initElements(getThreadDriver(), this);
        PropertyConfigurator.configure(System.getProperty("user.dir") + LOG_PROPERTY_FILE_PATH);
    }

    public void getDriver(String browserName, String machineName, Map threadMap, String testName) {

        switch (browserName) {
            case "chrome":
                logger.info("[--->Using chrome browser<---]");
                chromeBrowser(threadMap);
                break;
            case "edge":
                logger.info("[--->Using Edge browser<---]");
                edgeBrowser(threadMap);
                break;

            case "chromeHeadless":
                logger.info("[--->Using chrome Head less browser<---]");
                headLessChromeBrowser(threadMap);
                break;
            case "firefoxHeadless":
                logger.info("[--->Using firefox Head less browser<---]");
                headLessFirefoxBrowser(threadMap);
                break;
            case "firefox":
                logger.info("[--->Using firefox browser<---]");
                firefoxBrowser(threadMap);
                break;
            case "remoteChromeBrowser":
                logger.info("[--->Using remote chrome browser<---]");
                remoteChromeBrowser(machineName, threadMap);
                break;
            case "remoteFirefoxBrowser":
                logger.info("[--->Using remote firefox browser<---]");
                remoteFirefoxBrowser(machineName, threadMap);
                break;
            case "remoteEdgeBrowser":
                logger.info("[--->Using remote edge browser<---]");
                remoteEdgeBrowser(machineName,threadMap);
                break;
            case "lambdaTestChrome":
                logger.info("[--->Using lambdatest cloud chrome browser<---]");
                remoteLambdaTestinChrome(threadMap, testName);
                break;
            case "lambdaTestSafari":
                logger.info("[--->Using lambdatest cloud safari browser<---]");
                remoteLambdaTestinSafari(threadMap, testName);
                break;
            case "lambdaTestFirefox":
                logger.info("[--->Using lambdatest cloud firefox browser<---]");
                remoteLambdaTestinFirefox(threadMap, testName);
                break;
            case "browserStackChrome":
                logger.info("[--->Using browser stack cloud chrome browsers<---]");
                remoteBrowserStackChrome(threadMap, testName);
                break;
            case "browserStackFireFox":
                logger.info("[--->Using browser stack cloud firefox browsers<---]");
                remoteBrowserStackFireFox(threadMap, testName);
           break;
        }
        manageBrowser();
    }

    private void manageBrowser() {
        getThreadDriver().manage().window().maximize();
        getThreadDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        getThreadDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(PropertyFileReader.getInstance().getProperty("implicitlyWait"))));
        getThreadDriver().manage().deleteAllCookies();
    }

    public WebDriver getThreadDriver() {
        WebDriver webdriverObj = null;
        try {
            webdriverObj = (WebDriver) ((Map) threadLocalMap.get()).get("webdriverObj");
        } catch (Exception e) {

        }
        return webdriverObj;
    }

    public String getRunnerName() {
        return (((Map) threadLocalMap.get()).get("runnerClass")).toString();
    }

    public String isSkipTest() {
        String isSkipTest="No";
try {
    if (((Map) threadLocalMap.get()).get("skipTest").toString() != null) {
        isSkipTest = ((Map) threadLocalMap.get()).get("skipTest").toString();
    }
}catch (Exception e){

}

        return isSkipTest;
    }

    public String getRandomEmail() {
        return ((Map) threadLocalMap.get()).get("randomEmail").toString();
    }

    public void setRandomEmail(String email) {
        ((Map) threadLocalMap.get()).put("randomEmail", email);
    }

    public String getConstantsURL(String URL) {
        return null;
    }
}