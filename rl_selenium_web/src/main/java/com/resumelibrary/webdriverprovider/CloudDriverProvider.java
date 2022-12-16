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
import org.openqa.selenium.remote.http.ClientConfig;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CloudDriverProvider extends WebDriverProvider implements Constants {

    private static final Logger logger = LogManager.getLogger(CloudDriverProvider.class);


    public CloudDriverProvider() {
       PropertyConfigurator.configure(System.getProperty("user.dir") + LOG_PROPERTY_FILE_PATH);
    }

    void remoteLambdaTestinSafari(Map threadMap, String testName) {
        try {
            String username = PropertyFileReader.getInstance().getProperty("lambdaUsername");
            String accessKey = PropertyFileReader.getInstance().getProperty("lambdaAccessKey");

            String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaStackBuildId");
            String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
            String jobnameFromConfig = PropertyFileReader.getInstance().getProperty("jobname");
            String jobBaseName = WebURLHelper.getParameterFromEnvOrSysParam("JOB_BASE_NAME", jobnameFromConfig);

            logger.info("[--->jenkinsBuildNumber = " + buildId+"<---]");
            String project = "[" + jobBaseName + "-Build:" + buildId + "]";
            final String driverURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";
            logger.info("[--->driverURL:" + driverURL+"<---]");
            SafariOptions browserOptions = new SafariOptions();
            browserOptions.setPlatformName("MacOS Ventura");
            browserOptions.setBrowserVersion("16.0");
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("build", "RL Regression[" + jobBaseName + "-Build:" + buildId + "]");
            ltOptions.put("project", project);
            ltOptions.put("name", testName);
            ltOptions.put("console", true);
            ltOptions.put("visual", true);
            ltOptions.put("video", true);
         //   ltOptions.put("selenium_version", "4.1.2");
           // ltOptions.put("driver_version", "100.0");
            //ltOptions.put("resolution", "1920x1080");
            ltOptions.put("network", false);
            ltOptions.put("tunnel", true);
            ltOptions.put("tunnelName", "RLWebRegressionTunnel");
            ltOptions.put("w3c", true);
          
            browserOptions.setCapability("LT:Options", ltOptions);
            threadMap.put("webdriverObj", new RemoteWebDriver(new URL(driverURL), browserOptions));
            threadLocalMap.set(threadMap);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       void remoteLambdaTestinChrome(Map threadMap, String testName) {
        try {
            String username = PropertyFileReader.getInstance().getProperty("lambdaUsername");
            String accessKey = PropertyFileReader.getInstance().getProperty("lambdaAccessKey");

            String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaStackBuildId");
            String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
            String jobnameFromConfig = PropertyFileReader.getInstance().getProperty("jobname");
            String jobBaseName = WebURLHelper.getParameterFromEnvOrSysParam("JOB_BASE_NAME", jobnameFromConfig);

            logger.info("[--->jenkinsBuildNumber = " + buildId+"<---]");
            String project = "[" + jobBaseName + "-Build:" + buildId + "]";
            final String driverURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";
            logger.info("[--->driverURL:" + driverURL+"<---]");

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "Chrome");
            caps.setCapability("browserVersion", "100.0");

            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("build", "Build-15-Dec-4");
            ltOptions.put("project", project);
            ltOptions.put("name", testName);
            ltOptions.put("console", "info");
            ltOptions.put("visual", true);
            ltOptions.put("platformName", "Windows 10");
            ltOptions.put("selenium_version", "4.1.2");
            ltOptions.put("driver_version", "100.0");
            ltOptions.put("resolution", "1920x1080");
           ltOptions.put("idleTimeout","1800");
            ltOptions.put("network", false);
            ltOptions.put("tunnel", true);
            ltOptions.put("tunnelName","SharedTunnel");
            caps.setCapability("LT:Options", ltOptions);
//            caps.setCapability("tunnelName", "SharedTunnel");
//            ClientConfig config = ClientConfig.defaultConfig()
//                    .connectionTimeout(Duration.ofMinutes(5))
//                    .readTimeout(Duration.ofMinutes(3));
           ClientConfig config = ClientConfig.defaultConfig().connectionTimeout(Duration.ofMinutes(20)).readTimeout(Duration.ofMinutes(20));
            WebDriver testDriver =  RemoteWebDriver.builder().oneOf(caps).address(driverURL).config(config).build();

            threadMap.put("webdriverObj", testDriver);
            threadLocalMap.set(threadMap);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     void remoteLambdaTestinFirefox(Map threadMap, String testName) {
        try {
            String username = PropertyFileReader.getInstance().getProperty("lambdaUsername");
            String accessKey = PropertyFileReader.getInstance().getProperty("lambdaAccessKey");

            String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaStackBuildId");
            String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
            String jobnameFromConfig = PropertyFileReader.getInstance().getProperty("jobname");
            String jobBaseName = WebURLHelper.getParameterFromEnvOrSysParam("JOB_BASE_NAME", jobnameFromConfig);

            System.out.println("jenkinsBuildNumber = " + buildId);
            String project = "[" + jobBaseName + "-Build:" + buildId + "]";
            final String driverURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";
            logger.info("[--->driverURL:" + driverURL+"<---]");

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "Firefox");
            caps.setCapability("browserVersion", "100.0");

            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("build", "RL Regression[" + jobBaseName + "-Build:" + buildId + "]");
            ltOptions.put("project", project);
            ltOptions.put("name", testName);
            ltOptions.put("console", "info");
            ltOptions.put("visual", true);
            ltOptions.put("platformName", "Windows 10");
            ltOptions.put("selenium_version", "4.1.2");
            ltOptions.put("driver_version", "v0.31.0");
            ltOptions.put("resolution", "1920x1080");
            ltOptions.put("network", false);
            ltOptions.put("tunnel", true);
            caps.setCapability("LT:Options", ltOptions);
            caps.setCapability("tunnelName", "RLWebRegressionTunnel");
            threadMap.put("webdriverObj", new RemoteWebDriver(new URL(driverURL), caps));
            threadLocalMap.set(threadMap);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     void remoteBrowserStackChrome(Map threadMap, String testName) {
        try {
            String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaStackBuildId");
            String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
            String jobnameFromConfig = PropertyFileReader.getInstance().getProperty("jobname");
            String jobBaseName = WebURLHelper.getParameterFromEnvOrSysParam("JOB_BASE_NAME", jobnameFromConfig);

            logger.info("[--->jenkinsBuildNumber = " + buildId+"<---]");
            String project = "[" + jobBaseName + "-Build:" + buildId + "]";

            String username = PropertyFileReader.getInstance().getProperty("browserStackUsername");
            String accessKey = PropertyFileReader.getInstance().getProperty("browserStackAccessKey");
            final String driverURL = "https://" + username + ":" + accessKey + "@hub-scale.browserstack.com/wd/hub";

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "Chrome");
            caps.setCapability("browserVersion", "100.0");

            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
            browserstackOptions.put("os", "Windows");
            browserstackOptions.put("osVersion", "10");

            //for Chrome + Mac
            //browserstackOptions.put("os", "OS X");
            //browserstackOptions.put("osVersion", "Big Sur");

            browserStackCommonCapblts(threadMap, project, driverURL, caps, browserstackOptions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

      void browserStackCommonCapblts(Map threadMap, String buildId, String driverURL, DesiredCapabilities caps, HashMap<String, Object> browserstackOptions) throws MalformedURLException {

        browserstackOptions.put("debug", "true");  // for enabling visual logs
        browserstackOptions.put("consoleLogs", "info");  // to enable console logs at the info level. You can also use other log levels here
        browserstackOptions.put("networkLogs", "false");  // to enable network logs to be logged
        browserstackOptions.put("video", "true");
        browserstackOptions.put("projectName", "rl-selenium-tests");
        //browserstackOptions.put("seleniumVersion", "4.1.2");
        browserstackOptions.put("autoWait", "0");
        browserstackOptions.put("local", "false");
        browserstackOptions.put("buildName", buildId);
        caps.setCapability("bstack:options", browserstackOptions);
        threadMap.put("webdriverObj", new RemoteWebDriver(new URL(driverURL), caps));
        threadLocalMap.set(threadMap);
    }

     void remoteBrowserStackFireFox(Map threadMap, String testName) {
        try {
            String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaStackBuildId");
            String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
            String jobnameFromConfig = PropertyFileReader.getInstance().getProperty("jobname");
            String jobBaseName = WebURLHelper.getParameterFromEnvOrSysParam("JOB_BASE_NAME", jobnameFromConfig);

            logger.info("[--->jenkinsBuildNumber : " + buildId+"<---]");
            String project = "[" + jobBaseName + "-Build:" + buildId + "]";

            String username = PropertyFileReader.getInstance().getProperty("browserStackUsername");
            String accessKey = PropertyFileReader.getInstance().getProperty("browserStackAccessKey");
            final String driverURL = "https://" + username + ":" + accessKey + "@hub-scale.browserstack.com/wd/hub";

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "Firefox");
            caps.setCapability("browserVersion", "100.0");

            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
            browserstackOptions.put("os", "Windows");
            browserstackOptions.put("osVersion", "10");

            //for Firefox + Mac
            //browserstackOptions.put("os", "OS X");
            //browserstackOptions.put("osVersion", "Big Sur");

            browserStackCommonCapblts(threadMap, project, driverURL, caps, browserstackOptions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getConstantsURL(String URL) {
        return null;
    }
}