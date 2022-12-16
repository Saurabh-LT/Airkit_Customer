package com.resumelibrary.utilities;

public interface Constants {
    public static final String CLASS = "class";
    public static final String ID = "id";
    public  static final String CSS = "css";
    public static final String XPATH = "xpath";
    public   static final String NAME = "name";
    public static final String TAG_NAME = "tagname";
    public  static final String LINK = "link";
    public   static final String LINK_TEXT = "Link Text";
    public static final String PARTIAL_LINK = "partial_link";
    public  static final String TEXT_INSIDE = "Text Inside";
    public  static final String TEXT_CONTAINS="Text contains";
    public static final String STAGING_HOST_1 = "http://rl-staging-web-php01";
    public static final String STAGING_HOST_2 = "http://rl-staging-web02";
    public static final String LOCAL_HOST = "http://localhost";
    public static final String STAGING_1 = "STAGING_MACHINE_1";
    public static final String STAGING_2 = "STAGING_MACHINE_2";
    public final String RUNNER = "com.resumelibrary.cucumber.CucumberTestRunner";
    public final String RUNNER2 = "com.resumelibrary.cucumber.CucumberTestRunner2";
    //Runner classes>               com.resumelibrary.cucumber.CucumberRunnerTest

    public final String RUNNER_1 = "com.resumelibrary.cucumber.CucumberRunnerTest1";
    public final String RUNNER_2 = "com.resumelibrary.cucumber.CucumberRunnerTest2";
    public final String RUNNER_3 = "com.resumelibrary.cucumber.CucumberRunnerTest3";
    public final String RUNNER_4 = "com.resumelibrary.cucumber.CucumberRunnerTest4";
    public final String RUNNER_5 = "com.resumelibrary.cucumber.CucumberRunnerTest5";
    public final String RUNNER_6 = "com.resumelibrary.cucumber.CucumberRunnerTest6";
    public final String RUNNER_7 = "com.resumelibrary.cucumber.CucumberRunnerTest7";
    public final String RUNNER_8 = "com.resumelibrary.cucumber.CucumberRunnerTest8";
    public final String RUNNER_9 = "com.resumelibrary.cucumber.CucumberRunnerTest9";
    public final String RUNNER_10 = "com.resumelibrary.cucumber.CucumberRunnerTest10";
    public final String RUNNER_11 = "com.resumelibrary.cucumber.CucumberRunnerTest11";
    public final String RUNNER_12 = "com.resumelibrary.cucumber.CucumberRunnerTest12";
    public final String API_TEST_1 = "com.resumelibrary.cucumber.CucumberApiRunnerTest";

    //Property file
    public final String PROPERTY_FILE_PATH = "/src/test/java/com/resumelibrary/configs/config.properties";
    public final String LOG_PROPERTY_FILE_PATH = "/src/test/java/com/resumelibrary/configs/log4j.properties";
    public final String JOBS_CSV_PATH = "/src/test/java/com/resumelibrary/configs/jobs.csv";
    public final String CANDIDATE_CSV_PATH = "/src/test/java/com/resumelibrary/configs/candidatereg.csv";

    //Other variables
    public final String DISABLE_DATABASE_QUERY = "DISABLE_DB_PROFILER";
    public final String ERROR_502 = "502 Bad Gateway";

    public String getConstantsURL(String URL);
}