package com.resumelibrary.utilities;

public class WebURLHelper  {

    static String loginPageUrl = "/login";
    static String loggedOutUrl = "/logout";
    static String siteMapUrl = "/sitemap";
    static String pressUrl = "/press";
    static String hiringUrl = "/hiring";
    static String hiringPostJobsUrl = "/hiring/post-jobs";
    static String partnerNetworkUrl = "/hiring/partner-network";
    static String aboutUsUrl = "/about";
    static String meetTheTeamUrl = "/meet-the-team";
    static String workForUsUrl = "/company/4394/resume-library-jobs";
    static String workForUsAcmeUrl = "/company/4394/acme-company-no-4570-jobs";
    static String fiveHundredUrl = "/500.html";
    static String fourZeroThreeUrl = "/403.html";
    static String candidateLoginUrl = "/login";
    static String clientLoginUrl = "/hiring/login";
    static String candidateAccountUrl = "/candidate/my-dashboard";
    static String clientAccountUrl = "/client/account";
    static String clientAccountUsersUrl = "/client/account/users";
    static String jobApplyUrl = "/job/apply/";
    static String jobApplyConfirmUrl = "/job/apply/confirm/";
    static String jobPostUrl = "/job/post";
    static String jobTemplateUrl = "/client/jobs/templates";
    static String candidateRegisterConfirmationUrl = "/candidate/registration/confirm";
    static String CVLibraryUrl = "https://www.cv-library.co.uk/search-jobs";
    static String facebookUrl = "https://www.facebook.com/";
    static String twitterUrl = "https://twitter.com/ResumeLibrary";
    static String instagramUrl = "https://www.instagram.com/";
    static String googlePlayUrl = "https://play.google.com/store/apps/details?id=com.resumelibrary.app";
    static String appStoreUrl = "https://apps.apple.com/us/app/resume-library/id1095745879?ls=1";
    static String linkedinUrl = "https://www.linkedin.com/";
    static String youTubeUrl = "https://www.youtube.com/channel/UCBcvEY3m1qhw3-A61XJD3Yw";
    static String productHistoryUrl = "/client/purchase-history";

    /**
     * Prepare host name using env or system property or default values.
     * @return String
     */
    public static String getWebHostName() {
        String webHostName = null;

        if (isParameterSetInEnvOrParam("BRANCH")) {
            String branchName = getParameterFromEnvOrSysParam("BRANCH", "master");

            // we get branch name in form of: feature/<branch_name> so we need to swap / . _ with -
            branchName = branchName.toLowerCase().replaceAll("[/._]","-");

            // create host name from branch name
            webHostName = "https://www-" + branchName + ".ci.resume-library.com";
        }

        System.out.println("Web URL is : " + webHostName);

        return webHostName;
    }

    /**
     * Get parameter from either environment or system parameters or default value
     * @return String
     */
    public static String getParameterFromEnvOrSysParam(String name, String defaultValue) {
        if (System.getenv(name) != null) {
            return System.getenv(name).trim();
        } else if (System.getProperty(name) != null) {
            return System.getProperty(name).trim();
        }

        return defaultValue;
    }

    /**
     * Check if parameter is set either in env or system param
     * @return boolean
     */
    public static boolean isParameterSetInEnvOrParam(String name) {
        if (System.getenv(name) != null) {
            return true;
        } else if (System.getProperty(name) != null) {
            return true;
        }

        return false;
    }

    public static String getLoginPageUrl() {
        return loginPageUrl;
    }

    public static String getLoggedOutUrl() {
        return loggedOutUrl;
    }

    public static String getWebUrl() {
        String webPageUrl;

        if (getParameterFromEnvOrSysParam("USER", "jenkins").equals("jenkins")) {
            webPageUrl = getWebHostName();
        } else {
            webPageUrl = DataHelper.getWebUrl();
        }

        return webPageUrl;
    }

    public static String getAboutUsUrl() {
        return aboutUsUrl;
    }

    public static String getCandidateLoginUrl() {
        return candidateLoginUrl;
    }

    public static String getCandidateAccountUrl() {
        return candidateAccountUrl;
    }

    public static String getClientLoginUrl() {
        return clientLoginUrl;
    }

    public static String getFiveHundredUrl() {
        return fiveHundredUrl;
    }

    public static String getFourZeroThreeUrl() {
        return fourZeroThreeUrl;
    }

    public static String getClientAccountUrl() {
        return clientAccountUrl;
    }

    public static String getSiteMapUrl() {
        return siteMapUrl;
    }

    public static String getHiringUrl() {
        return hiringUrl;
    }

    public static String getPressUrl() {
        return pressUrl;
    }

    public static String getHiringPostJobsUrl() {
        return hiringPostJobsUrl;
    }

    public static String getMeetTheTeamUrl() {
        return meetTheTeamUrl;
    }

    public static String getPartnerNetworkUrl() {
        return partnerNetworkUrl;
    }

    public static String getWorkForUsUrl() {
        return workForUsUrl;
    }

    public static String getWorkForUsAcmeUrl() {
        return workForUsAcmeUrl;
    }

    public static String getAppStoreUrl() {
        return appStoreUrl;
    }

    public static String getCVLibraryUrl() {
        return CVLibraryUrl;
    }

    public static String getFacebookUrl() {
        return facebookUrl;
    }

    public static String getGooglePlayUrl() {
        return googlePlayUrl;
    }

    public static String getInstagramUrl() {
        return instagramUrl;
    }

    public static String getTwitterUrl() {
        return twitterUrl;
    }

    public static String getLinkedinUrl() {
        return linkedinUrl;
    }

    public static String getYouTubeUrl() {
        return youTubeUrl;
    }

    public static String getJobApplyUrl() {
        return jobApplyUrl;
    }

    public static String getJobApplyConfirmUrl() {
        return jobApplyConfirmUrl;
    }

    public static String getJobPostUrl() {
        return jobPostUrl;
    }

    public static String getJobTemplateUrl() {
        return jobTemplateUrl;
    }

    public static String getCandidateRegisterConfirmationUrl() {
        return candidateRegisterConfirmationUrl;
    }

    public static String getClientAccountUsersUrlUserUrl() {
        return clientAccountUsersUrl;
    }

    public static String getProductHistoryUrl() {
        return productHistoryUrl;
    }
}