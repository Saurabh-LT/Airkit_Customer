import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class AppAutomationTest {

    private AppiumDriver<MobileElement> driver;
    private String status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String user = System.getProperty("LT_USER_NAME", "").trim();
        String key = System.getProperty("LT_ACCESS_KEY", "").trim();
        String buildName = System.getProperty("BUILD_NAME", "").trim();
        String appUrl = System.getProperty("APP_URL", "").trim();
        String hub = "@mobile-hub.lambdatest.com/wd/hub";

        if (appUrl.isEmpty()) {
            throw new IllegalStateException(
                    "APP_URL system property is empty. Pass -DAPP_URL=lt://APP... from your mvn command.");
        }

        System.out.println("[DEBUG] user.len=" + user.length()
                + " key.len=" + key.length()
                + " build='" + buildName + "'"
                + " app='" + appUrl + "'");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("build", buildName);
        caps.setCapability("name", this.getClass().getSimpleName() + "." + m.getName());
        caps.setCapability("deviceName", System.getProperty("LT_DEVICE_NAME", "Galaxy S23.*"));
        caps.setCapability("platformVersion", System.getProperty("LT_PLATFORM_VERSION", "13"));
        caps.setCapability("platformName", "android");
        caps.setCapability("isRealMobile", true);
        caps.setCapability("app", appUrl);
        caps.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("console", true);
        caps.setCapability("network", true);
        caps.setCapability("visual", true);
        caps.setCapability("devicelog", true);

        driver = new AppiumDriver<>(new URL("https://" + user + ":" + key + hub), caps);
    }

    /**
     * Smoke test: launch the app on a real device, idle for 60 seconds, finish.
     */
    @Test
    public void proverbialAppFlow() throws InterruptedException {
        try {
            System.out.println("[INFO] App launched — idling for 60s");
            try { driver.executeScript("lambda-name=App launched — 60s wait"); } catch (Exception ignored) {}
            Thread.sleep(60_000);
            System.out.println("[OK] 60s wait complete");
            status = "passed";
        } catch (Throwable t) {
            status = "failed";
            System.out.println("[FAIL] " + t.getMessage());
            try { driver.executeScript("lambda-status=failed"); } catch (Exception ignored) {}
            throw t;
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver == null) return;
        try { driver.executeScript("lambda-status=" + status); } catch (Exception ignored) {}
        try { driver.quit(); } catch (Exception ignored) {}
    }
}
