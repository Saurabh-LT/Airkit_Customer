package com.resumelibrary.cucumber;

import com.resumelibrary.utilities.*;
import org.testng.*;

import java.io.*;

import com.lambdatest.tunnel.Tunnel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomListener extends Utility implements ITestListener, IExecutionListener {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CustomListener.class);
   List<Tunnel>  tunnelObject=null;

    @Override
    public void onExecutionStart() {
        tunnelObject=new ArrayList<Tunnel>();
        boolean flag=false;
        String username = PropertyFileReader.getInstance().getProperty("lambdaUsername");
        String accessKey = PropertyFileReader.getInstance().getProperty("lambdaAccessKey");
        int noOfTunnels = Integer.parseInt(WebURLHelper.getParameterFromEnvOrSysParam("TUNNELS", PropertyFileReader.getInstance().getProperty("nooftunnels")));
        for(int j=0;j<noOfTunnels;j++){

            HashMap<String, String> option = new HashMap<String, String>();
            option.put("user", username);
            option.put("key", accessKey);
            option.put("load-balanced","true");
            option.put("mitm","true");
            option.put("sharedTunnel","true");

            option.put("tunnelName", "RLWebRegressionTunnel");
            int i=0;
            do{
                flag= startTunnel(option);
                i++;
            }while(!flag && i<2);
        }


        ASCIIArtGenerator artGen = new ASCIIArtGenerator();
        try {
            artGen.printText("RL Regression started");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaBuildId");
        String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
        ExcelUtil excelUtil = new ExcelUtil();
        excelUtil.createFailedExcel(buildId);
    }

    @Override
    public void onExecutionFinish() {
       try {
            for(int i=0;i<tunnelObject.size();i++){
                    tunnelObject.get(i).stopTunnel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ExcelUtil excelUtil=new ExcelUtil();
        excelUtil.createSummarySheet(verticalScenarioCountPojo);
        ASCIIArtGenerator artGen = new ASCIIArtGenerator();
        try {
            artGen.printText("RL Regression Finished");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ITestContext arg0) {

    }
    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
    }

    @Override
    public void onTestFailure(ITestResult arg0) {
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
    }

    @Override
    public void onTestStart(ITestResult arg0) {
    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
    }

    public synchronized boolean startTunnel(Map options) {
        boolean flag = false;
        try{
            for(int i = 0; i < 5; ++i) {
                Thread.sleep(1000L);
            }
            Tunnel t=new Tunnel();
                flag = t.start(options);
            if(flag) {
                tunnelObject.add(t);
            }
        }catch (Exception e){
            flag=false;

        }
        return flag;
    }
}