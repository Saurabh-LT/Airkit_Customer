package com.resumelibrary.webdriverprovider;

import com.resumelibrary.utilities.*;
import com.resumelibrary.utilities.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WebDriverProvider implements Constants {

    private static final Logger logger = LogManager.getLogger(WebDriverProvider.class);
    public static ThreadLocal<Map<String,Object>> threadLocalMap = new ThreadLocal<>();

    static void headLessChromeBrowser(Map threadMap) {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.default_directory", "/tmp");
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        // driver = new ChromeDriver(options);
        threadMap.put("webdriverObj", new ChromeDriver(options));
        threadLocalMap.set(threadMap);
    }

    void headLessFirefoxBrowser(Map threadMap) {
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("browser.download.folderList", 2);
        options.addPreference("download.default_directory", "/tmp");
        options.addPreference("browser.download.useDownloadDir", true);
        options.addPreference("browser.download.viewableInternally.enabledTypes", "");
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf;text/plain;application/text;text/xml;application/xml");
        //options.addPreference("pdfjs.disabled", true);
        options.addArguments("--headless");
        WebDriverManager.firefoxdriver().setup();
        // driver = new ChromeDriver(options);
        threadMap.put("webdriverObj", new FirefoxDriver(options));
        threadLocalMap.set(threadMap);
    }

    static void edgeBrowser(Map threadMap) {
        EdgeOptions options = new EdgeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.default_directory", "/tmp");
        options.setExperimentalOption("prefs", prefs);
        WebDriverManager.edgedriver().setup();
        //  driver = new ChromeDriver(options);
        threadMap.put("webdriverObj", new EdgeDriver(options));
        threadLocalMap.set(threadMap);
    }
    static void chromeBrowser(Map threadMap) {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.default_directory", "/tmp");
        options.setExperimentalOption("prefs", prefs);
        WebDriverManager.chromedriver().setup();
        //  driver = new ChromeDriver(options);
        threadMap.put("webdriverObj", new ChromeDriver(options));
        threadLocalMap.set(threadMap);
    }

    static void firefoxBrowser(Map threadMap) {
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("browser.download.folderList", 2);
        options.addPreference("download.default_directory", "/tmp");
        options.addPreference("browser.download.useDownloadDir", true);
        options.addPreference("browser.download.viewableInternally.enabledTypes", "");
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf;text/plain;application/text;text/xml;application/xml");
        // options.addPreference("pdfjs.disabled", true);
        WebDriverManager.firefoxdriver().setup();
        // driver = new FirefoxDriver(options);
        threadMap.put("webdriverObj", new FirefoxDriver(options));
        threadLocalMap.set(threadMap);
    }

    void remoteFirefoxBrowser(String machineName, Map threadMap) {
        try {
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("browser.download.folderList", 2);
            options.addPreference("download.default_directory", "/tmp");
            options.addPreference("browser.download.useDownloadDir", true);
            options.addPreference("browser.download.viewableInternally.enabledTypes", "");
            options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf;text/plain;application/text;text/xml;application/xml");
            //   options.addPreference("pdfjs.disabled", true);
            String remoteMachineUrl, remoteMachine;
            switch (machineName) {
                case STAGING_1:
                    if (WebURLHelper.isParameterSetInEnvOrParam("MACHINE")) {
                        remoteMachine = WebURLHelper.getParameterFromEnvOrSysParam("MACHINE", STAGING_1);
                        if (remoteMachine.equals(STAGING_1)) {
                            remoteMachineUrl = STAGING_HOST_1;
                            logger.info("[--->Creating remote firefox driver in the machin: " + remoteMachine + " :rl-staging-web-php01<---]");
                            threadMap.put("webdriverObj", new RemoteWebDriver(new URL(remoteMachineUrl + ":4444/wd/hub"), options));
                            threadLocalMap.set(threadMap);
                            break;
                        } else if (remoteMachine.equals(STAGING_2)) {
                            remoteMachineUrl = STAGING_HOST_2;
                            logger.info("[--->Creating remote firefox driver in the machine: " + remoteMachine + " :rl-staging-web02<---]");
                            threadMap.put("webdriverObj", new RemoteWebDriver(new URL(remoteMachineUrl + ":4444/wd/hub"), options));
                            threadLocalMap.set(threadMap);
                            break;
                        }
                    }
                case STAGING_2:
                    logger.info("[--->Creating remote firefox driver in the machine: " + machineName + " :rl-staging-web02<---]");
                    threadMap.put("webdriverObj", new RemoteWebDriver(new URL(STAGING_HOST_2 + ":4444/wd/hub"), options));
                    threadLocalMap.set(threadMap);
                    break;
                case "Local":
                    logger.info("[--->Creating firefox driver in the machine: " + machineName+"<---]");
                    threadMap.put("webdriverObj", new RemoteWebDriver(new URL(LOCAL_HOST + ":4444/wd/hub"), options));
                    threadLocalMap.set(threadMap);
                    break;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    void remoteChromeBrowser(String machineName, Map threadMap) {
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--window-size=1920,1080");
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.prompt_for_download", false);
            prefs.put("download.default_directory", "/tmp");
            options.setExperimentalOption("prefs", prefs);

            String remoteMachineUrl, remoteMachine;
            switch (machineName) {
                case STAGING_1:
                    if (WebURLHelper.isParameterSetInEnvOrParam("MACHINE")) {
                        remoteMachine = WebURLHelper.getParameterFromEnvOrSysParam("MACHINE", STAGING_1);
                        if (remoteMachine.equals(STAGING_1)) {
                            remoteMachineUrl = STAGING_HOST_1;
                            logger.info("[--->Creating remote chrome driver in the machine: " + remoteMachine + " :rl-staging-web-php01<---]");
                            threadMap.put("webdriverObj", new RemoteWebDriver(new URL(remoteMachineUrl + ":4444/wd/hub"), options));
                            threadLocalMap.set(threadMap);
                            break;
                        } else if (remoteMachine.equals(STAGING_2)) {
                            remoteMachineUrl = STAGING_HOST_2;
                            logger.info("[--->Creating remote chrome driver in the machine===>: " + remoteMachine + " :rl-staging-web02<---]");
                            threadMap.put("webdriverObj", new RemoteWebDriver(new URL(remoteMachineUrl + ":4444/wd/hub"), options));
                            threadLocalMap.set(threadMap);
                            break;
                        }
                    }
                case STAGING_2:
                    logger.info("[--->Creating remote chrome driver in the machine===>: " + machineName + " :rl-staging-web02<---]");

                    threadMap.put("webdriverObj", new RemoteWebDriver(new URL(STAGING_HOST_2 + ":4444/wd/hub"), options));
                    threadLocalMap.set(threadMap);
                    break;
                case "Local":
                    logger.info("[--->Creating chrome driver in the machine: " + machineName+"<---]");
                    threadMap.put("webdriverObj", new RemoteWebDriver(new URL(LOCAL_HOST + ":4444/wd/hub"), options));
                    threadLocalMap.set(threadMap);
                    break;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    void remoteEdgeBrowser(String machineName,Map threadMap) {
        try {
            EdgeOptions options = new EdgeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.prompt_for_download", false);
            prefs.put("download.default_directory", "/tmp");
            options.setExperimentalOption("prefs", prefs);

            String remoteMachineUrl, remoteMachine;
            switch (machineName) {
                case STAGING_1:
                    if (WebURLHelper.isParameterSetInEnvOrParam("MACHINE")) {
                        remoteMachine = WebURLHelper.getParameterFromEnvOrSysParam("MACHINE", STAGING_1);
                        if (remoteMachine.equals(STAGING_1)) {
                            remoteMachineUrl = STAGING_HOST_1;
                            System.out.println("Creating remote edge driver in the machine===>: " + remoteMachine + " :rl-staging-web-php01");
                            //tlDriver.set(new RemoteWebDriver(new URL(remoteMachineUrl + ":4444/wd/hub"), options));
                            threadMap.put("webdriverObj",new RemoteWebDriver(new URL(remoteMachineUrl + ":4444/wd/hub"), options));
                            threadLocalMap.set(threadMap);
                            break;
                        } else if (remoteMachine.equals(STAGING_2)) {
                            remoteMachineUrl = STAGING_HOST_2;
                            System.out.println("Creating remote edge driver in the machine===>: " + remoteMachine + " :rl-staging-web02");
                            //  tlDriver.set(new RemoteWebDriver(new URL(remoteMachineUrl + ":4444/wd/hub"), options));
                            threadMap.put("webdriverObj",new RemoteWebDriver(new URL(remoteMachineUrl + ":4444/wd/hub"), options));
                            threadLocalMap.set(threadMap);
                            break;
                        }
                    }
                case STAGING_2:
                    System.out.println("Creating remote edge driver in the machine===>: " + machineName + " :rl-staging-web02");
                    //  tlDriver.set(new RemoteWebDriver(new URL(STAGING_HOST_2 + ":4444/wd/hub"), options));
                    threadMap.put("webdriverObj",new RemoteWebDriver(new URL(STAGING_HOST_2 + ":4444/wd/hub"), options));
                    threadLocalMap.set(threadMap);
                    break;
                case "Local":
                    System.out.println("Creating edge driver in the machine: " + machineName);
                    // tlDriver.set(new RemoteWebDriver(new URL(LOCAL_HOST + ":4444/wd/hub"), options));
                    threadMap.put("webdriverObj",new RemoteWebDriver(new URL(LOCAL_HOST + ":4444/wd/hub"), options));
                    threadLocalMap.set(threadMap);

                    break;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public String getConstantsURL(String URL) {
        return null;
    }
}