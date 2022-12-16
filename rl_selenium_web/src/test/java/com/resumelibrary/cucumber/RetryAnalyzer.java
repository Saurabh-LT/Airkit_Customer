package com.resumelibrary.cucumber;

import com.resumelibrary.utilities.PropertyFileReader;
import com.resumelibrary.utilities.WebURLHelper;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RetryAnalyzer implements IRetryAnalyzer, ITestListener {
    //  List<String> scenarioList=new ArrayList<String>();
    Map<String,Integer> scenarioRetryMap=new HashedMap();
    String GREEN_BACKGROUND = "\033[42m";
    String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";
    String RED_BOLD_BRIGHT = "\033[1;91m";
    String ANSI_RESET = "\u001B[0m";
    String GREEN_BOLD_BRIGHT = "\033[1;92m";
    String WHITE_BOLD_BRIGHT = "\033[1;97m";
    private static final Logger logger = LogManager.getLogger(RetryAnalyzer.class);
    public boolean retry(ITestResult result) {

        if (scenarioRetryMap.get(result.getParameters()[0].toString()) == null) {
            scenarioRetryMap.put(result.getParameters()[0].toString(), 0);
        }
        int curretntRetryCount = ((Integer) scenarioRetryMap.get(result.getParameters()[0].toString()));


        String retryCount = WebURLHelper.getParameterFromEnvOrSysParam("RETRYCOUNT", PropertyFileReader.getInstance().getProperty("retryCount"));
        int givenRetryCount=Integer.parseInt(retryCount);
        if (curretntRetryCount < givenRetryCount) {
            if (result.getParameters().length > 0) {
                logger.info(RED_BOLD_BRIGHT+"[--->"+GREEN_BACKGROUND + WHITE_BOLD_BRIGHT+"Retrying ["+(curretntRetryCount+1)+"] for the Scenario [" + result.getParameters()[0] + "] as its  status is"+ANSI_RESET+BLACK_BACKGROUND_BRIGHT+RED_BOLD_BRIGHT+" [" + getResultStatusName(result.getStatus()) +"]"+ ANSI_RESET+RED_BOLD_BRIGHT+"<---]" + ANSI_RESET);// Parameters of above tests are " + result.getParameters()[0]);
                scenarioRetryMap.put(result.getParameters()[0].toString(), curretntRetryCount + 1);
            } else {
                logger.info("[--->Retrying test [" + result.getName() + "] as its status is [" + getResultStatusName(result.getStatus()) + "]<---]");
            }
            return true;
        }else{
            scenarioRetryMap.remove(result.getParameters()[0].toString());
        }
        return false;
    }

    public String getResultStatusName(int status) {
        String resultName = null;
        if (status == 1)
            resultName = "SUCCESS";
        if (status == 2)
            resultName = "FAILURE";
        if (status == 3)
            resultName = "SKIP";
        return resultName;
    }
}

