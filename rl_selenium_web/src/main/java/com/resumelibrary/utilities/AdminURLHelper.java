package com.resumelibrary.utilities;

public class AdminURLHelper {

    static String accountViewPage = "/account/view/";
    static String accountSearchResultsPage = "/search/?search=1478&search_type=accounts";
    static String addPartnerUrl = "/partners/add";
    static String addJobsUrl = "/jobs/add";
    static String loggedOutUrl = "/access/logout";
    static String accountViewUrl = "/account/view/1478";

    /**
     * Prepare host name using env or system property or default values.     *
     * @return String
     */
    public static String getAdminHostName() {
        String adminHostName = null;

        if (WebURLHelper.isParameterSetInEnvOrParam("BRANCH")) {
            String branchName = WebURLHelper.getParameterFromEnvOrSysParam("BRANCH", "master");

            // we get branch name in form of: feature/<branch_name> so we need to swap / with -
            branchName = branchName.toLowerCase().replaceAll("[/._]","-");

            // create host name from branch name
            adminHostName = "https://admin-" + branchName + ".ci.resume-library.com";
        }

        System.out.println("Admin URL is : " + adminHostName);

        return adminHostName;
    }

    public static String getAdminUrl() {
        String adminPageUrl = null;

        if (WebURLHelper.getParameterFromEnvOrSysParam("USER", "jenkins").equals("jenkins")) {
            adminPageUrl = getAdminHostName();
        } else {
            adminPageUrl = DataHelper.getAdminUrl();
        }

        return adminPageUrl;
    }

    public static String getAccountViewPage() {
        return accountViewPage;
    }

    public static String getAccountSearchResultsPage() {
        return accountSearchResultsPage;
    }

    public static String getAddJobsUrl() {
        return addJobsUrl;
    }

    public static String getAddPartnerUrl() {
        return addPartnerUrl;
    }

    public static String getLoggedOutUrl() {
        return loggedOutUrl;
    }

    public static String getAccountViewUrl() {
        return accountViewUrl;
    }
}