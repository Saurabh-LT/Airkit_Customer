import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class Airkit {


    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "" : System.getenv("LT_ACCESS_KEY");
        ;

        String LT_USER_NAME = System.getProperty("LT_USER_NAME", "");
        String LT_ACCESS_KEY = System.getProperty("LT_ACCESS_KEY", "");
        String tunnelFlag = System.getProperty("TUNNEL_FLAG");
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
        caps.setCapability("performance", true);
        caps.setCapability("tunnel",  tunnelFlag);


        String[] Tags = new String[] { "Feature", "Magicleap", "Severe" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + LT_USER_NAME + ":" + LT_ACCESS_KEY + hub), caps);
    }

    @Test
    public void basicTest() throws InterruptedException, IOException {
        String spanText;
        System.out.println("Loading Url");
        driver.get("https://app.airkit.com/u/2q5Cg2pt088IeM9AWZbet?");
        // explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Branch 1']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src, '.com')]")));
        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File("src/test/java/Images/test.png");

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);
        //navigating to different url
        driver.get("https://lambdatest.github.io/sample-todo-app/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
