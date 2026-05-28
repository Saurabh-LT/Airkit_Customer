import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class JenkinsDemo {


    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String LT_USER_NAME = System.getProperty("LT_USER_NAME", "");
        String LT_ACCESS_KEY = System.getProperty("LT_ACCESS_KEY", "");
        String buildName = System.getProperty("BUILD_NAME");
        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "MacOS Monterey");
        caps.setCapability("browserName", "Safari");
        caps.setCapability("version", "latest");
        caps.setCapability("build", buildName);
        caps.setCapability("name", m.getName() + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        caps.setCapability("visual", true);

        // SmartUI visual regression (https://www.testmuai.com/support/docs/selenium-visual-regression/)
        caps.setCapability("smartUI.project", System.getProperty("SMARTUI_PROJECT", "Airkit_Customer"));
        caps.setCapability("smartUI.build", buildName);
        caps.setCapability("smartUI.baseline", Boolean.parseBoolean(System.getProperty("SMARTUI_BASELINE", "false")));

        // To view performance metrics
        String[] Tags = new String[] { "Feature", "Magicleap", "Severe" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + LT_USER_NAME + ":" + LT_ACCESS_KEY + hub), caps);
    }

    public void wait(RemoteWebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver,  timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Test
    public void basicTest() throws InterruptedException {
        String[] urls = new String[] {
                "https://ltqa-frontend.lambdatestinternal.com/dynamic-colour-testing",
                "https://ltqa-frontend.lambdatestinternal.com/cross-browser-testing",
                "https://ltqa-frontend.lambdatestinternal.com/dynamic-data-testing",
                "https://ltqa-frontend.lambdatestinternal.com/"
        };

        for (int i = 0; i < urls.length; i++) {
            String url = urls[i];
            String screenshotName = "page-" + (i + 1) + "-" + url.replaceAll("https?://", "").replaceAll("[^a-zA-Z0-9]+", "_");
            System.out.println("Opening (" + (i + 1) + "/" + urls.length + "): " + url);
            driver.executeScript("lambda-name=" + url);
            try {
                driver.get(url);
                wait(driver, By.tagName("body"), 30);
                String title = driver.getTitle();
                System.out.println("  -> Title: " + title + " | URL: " + driver.getCurrentUrl());
                if (title == null) {
                    throw new AssertionError("Page did not load — title was null for " + url);
                }
                Thread.sleep(2000);
                System.out.println("  -> SmartUI screenshot: " + screenshotName);
                driver.executeScript("smartui.takeScreenshot=" + screenshotName);
            } catch (Throwable t) {
                System.out.println("  -> FAILED on " + url + ": " + t.getMessage());
                Status = "failed";
                driver.executeScript("lambda-status=failed");
                throw t;
            }
        }

        System.out.println("All URLs opened successfully.");
        Status = "passed";
    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }
}
