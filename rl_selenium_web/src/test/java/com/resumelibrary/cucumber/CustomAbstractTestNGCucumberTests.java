package com.resumelibrary.cucumber;

import com.resumelibrary.utilities.Constants;
import io.cucumber.testng.CucumberPropertiesProvider;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apiguardian.api.API;
import org.apiguardian.api.API.Status;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;


@API(
        status = Status.STABLE
)
/*
  This is customized version of TestNG framework provided class "AbstractTestNGCucumberTests"
  In addition to the standard features provided in framework below are some of the extra
 */
public abstract class CustomAbstractTestNGCucumberTests implements Constants {
    private static final Logger logger = LogManager.getLogger(CustomAbstractTestNGCucumberTests.class);
    private TestNGCucumberRunner testNGCucumberRunner;

    public CustomAbstractTestNGCucumberTests() {
    }
    String runnerClass;
    String browser;
    String machine;

    @BeforeClass(
            alwaysRun = true
    )
    public void setUpClass() {
        this.testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(
            groups = {"cucumber"},
            description = "Runs Cucumber Scenarios",
            dataProvider = "scenarios", retryAnalyzer = RetryAnalyzer.class
    )
    /*
  This method is customized version of the runScenario() in AbstractTestNGCucumberTests test NG class.
  In RL context we are using browsers chrome firefox and remote browsers for 2 physical machines. those parameters
  set as properties for the system to access anywhere .

 */
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper, ITestContext context) {
        String browserName= context.getCurrentXmlTest().getAllParameters().get("browser");
        String machineName=   context.getCurrentXmlTest().getAllParameters().get("machine");
        String runnerClass = context.getCurrentXmlTest().getClasses().get(0).getName();
        logger.info("[--->CustomListener: onStart :" + browserName + ":" + machineName + "<---]");
        this.browser = browserName;
        this.machine = machineName;
        this.runnerClass=runnerClass;
        System.setProperty("browserName",  browserName);
        System.setProperty("machineName",  machineName);
        System.setProperty("runnerClass",runnerClass);
        this.testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    /*
      DataProvider returns the array of scenarios for the corresponding runner class
     */
    @DataProvider
    public Object[][] scenarios() {
        return this.testNGCucumberRunner == null ? new Object[0][0] : this.testNGCucumberRunner.provideScenarios();
    }
    /*
     This method is customized version of the setUpClass() in AbstractTestNGCucumberTests.
   */
    @BeforeClass(alwaysRun = true)
    public void setUpClass(ITestContext context) {
        logger.info("[--->In CustomAbstractTestNGCucumberTests: Before Class"+ context.getCurrentXmlTest().getAllParameters()+"<---]");
        XmlTest currentXmlTest = context.getCurrentXmlTest();
        if (System.getProperty("Tag1") != null || System.getProperty("Tag2") != null ){
            String tag1 = System.getProperty("Tag1");
            String tag2 = System.getProperty("Tag2");
            String currentXMLName = currentXmlTest.getClasses().get(0).getName();

            switch (currentXMLName) {
                case RUNNER:
                    if (!tag1.isEmpty()) {
                        currentXmlTest.addParameter("cucumber.filter.tags", tag1);
                    }
                    break;
                case RUNNER2:
                    if (!tag2.isEmpty()) {
                        currentXmlTest.addParameter("cucumber.filter.tags", tag2);
                    }
                    break;
            }
        }
        CucumberPropertiesProvider properties = currentXmlTest::getParameter;
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass(), properties);
    }
    @AfterClass(
            alwaysRun = true
    )

    public void tearDownClass() {
        if (this.testNGCucumberRunner != null) {
            this.testNGCucumberRunner.finish();
        }
    }

    public String getConstantsURL(String URL){
        return null;
    }
}