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
        caps.setCapability("visual",true);
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
    public void basicTest() {
        System.out.println("Loading LambdaTest Website");
        driver.get("https://www.lambdatest.com/");
        wait(driver, By.cssSelector("a[href*='/login']"), 30);
        driver.findElement(By.cssSelector("a[href*='/login']")).click();
        wait(driver, By.id("email"), 30);
        driver.findElement(By.id("email")).sendKeys("Enter you email");
        driver.findElement(By.id("password")).sendKeys("Enter you password");
        driver.findElement(By.id("login-button")).click();
        System.out.println("Test Executed successfully.");
        Status = "passed";
    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }
}
