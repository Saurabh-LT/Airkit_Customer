package com.resumelibrary.cucumber;

import io.cucumber.testng.CucumberOptions;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        monochrome = true,
        plugin = {"pretty", "summary", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "com.resumelibrary.cucumber.CustomFormatter"},
        features = {"."},
        tags = "@Regression"
)
     /*This Runner class is created to run the scenarios on machine STAGING_MACHINE_1 on jenkins when we provide the XXXTestng.xml
        other wise if we use XXXCustomTestng.xml it will execute all scenarios on the same local machine.
        */
public class CucumberTestRunner2 extends CustomAbstractTestNGCucumberTests {
    private static final Logger logger = LogManager.getLogger(CucumberTestRunner2.class);

      /*
     DataProvider will provide all the scenarios by calling super class scenarios method
     */
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
    /*
        This method will be executed before each run to set the ThreadCount which is passed as part of the maven command line
        mvn clean install -Dsurefire.suiteXmlFiles=LocalTestng.xml -DTag1="@$1" -DThreadCount="1"
        to provide dynamically. **context.getCurrentXmlTest().getSuite()** represents the Testng xml and it wil set the value 'ThreadCount'
        to the property data-provider-thread-count
        for more information https://testng.org/doc/documentation-main.html#introduction
       */
    @BeforeClass
    public void setupClassName(ITestContext context) {
        int threadCount = Integer.parseInt(System.getProperty("ThreadCount"));
        context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(threadCount);
        context.getCurrentXmlTest().getSuite().setPreserveOrder(false);
        logger.info("[--->thread count:" + threadCount + " set for CucumberTestRunner2<---]");
    }
}