package com.resumelibrary.utilities;

public class DataHelper extends Utility {

    static String candidateEmailAddress = "automation-selenium-candidate@resume-library.com";
    static String clientEmailAddress = "automation-selenium-client@resume-library.com";
    static String candidateFirstName = "Selenium Candidate";
    static String clientFirstName = "Selenium Client";
    static String candidateId = "10749400";
    static String invalidCandidateId = "999999";
    static String LastName = "Automation";
    static String password = "123456";
    static String latestJobTitle = "Test Analyst";
    static String zipCode = "50001, IA";
    static String resumeFileName = "Test CV";
    static String clientCompanyName = "resume-library";
    static String clientPhonenUmber = "012345678912";
    static String recruiterType = "Staffing Agency";
    static String clientCity="Boston";
    static String clientState="Massachusetts";
    static String clientZipCode="02108";
   static String clientAddress="1st street";
    static String jobPostingTitle = "NonExternalTestJob";
    static String jobPostingLocation = "California";
    static String jobPostingCity = "90001";
    static String jobPostingSalaryMin = "10000";
    static String jobPostingSalaryMax = "30000";
    static String jobPostingDescription = "Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job Project via Test 1 Project via Test 1 test job";

    static String TownCity = "Manchester, TN";
    static String RetryPaymentBtn = "Retry Payment";
    static String ValidCardNumber = "370123456789116";
    static String ValidCvv = "1023";
    static String InvalidCardNumber = "5100400000000000";
    static String InvalidCvv = "666";
    static String ExpiryDate = "1023";

    String randomCandidateEmail = "automation-selenium-candidate-" + getRandomString(10) + System.currentTimeMillis() + "@resume-library.com";
    String randomPartnerEmail = "automation-selenium-partner-" + getRandomString(10) + System.currentTimeMillis() + "@resume-library.com";
    String randomClientEmail = "automation-selenium-client-" + getRandomString(10) + System.currentTimeMillis() + "@resume-library.com";
    String randomAccountEmail = "automation-selenium-account-" + getRandomString(10) + System.currentTimeMillis() + "@resume-library.com";
    String randomCompanyName = "automation-selenium-company-" + getRandomString(10);
    String randomEmail = "automation-selenium-test-" + getRandomString(10) + System.currentTimeMillis() + "@resume-library.com";

    static String webUrl = PropertyFileReader.getInstance().getProperty("webUrl");
    static String adminUrl = PropertyFileReader.getInstance().getProperty("adminUrl");

    static String testCandidateEmail = PropertyFileReader.getInstance().getProperty("candidateEmailAddress");
    static String candidatePassword = PropertyFileReader.getInstance().getProperty("candidatePassword");
    static String testClientEmail = PropertyFileReader.getInstance().getProperty("clientEmailAddress");
    static String testClientEmailWithNoCredits = PropertyFileReader.getInstance().getProperty("clientEmailAddressNoCredits");
    static String testClientPassword = PropertyFileReader.getInstance().getProperty("clientPassword");
    static String adminUsername = PropertyFileReader.getInstance().getProperty("adminUserName");
    static String adminPassword = PropertyFileReader.getInstance().getProperty("adminPassword");

    public static String getCandidateEmailAddress() {
        return candidateEmailAddress;
    }

    public static String getClientEmailAddress() {
        return clientEmailAddress;
    }

    public static String getCandidateFirstName() {
        return candidateFirstName;
    }

    public static String getClientFirstName() {
        return clientFirstName;
    }

    public static String getLastName() {
        return LastName;
    }
    public static String getClientCity() {
               return clientCity;
           }
    public static String getClientState() {
               return clientState;
           }
    public static String getClientZipCode() {
                return clientZipCode;
           }
   public static String getClientAddress() {
               return clientAddress;
           }
    public static String getClientCompanyName() {
               return clientCompanyName;
    }
   public static String getClientPhoneNUmber() {
               return clientPhonenUmber;
    }
    public static String getClientRecruiterType() {
              return recruiterType;}
    public static String getLatestJobTitle() {
        return latestJobTitle;
    }

    public static String getPassword() {
        return password;
    }

    public static String getZipCode() {
        return zipCode;
    }

    public static String getResumeFileName() {
        return resumeFileName;
    }

    public static String getJobPostingCity() {
        return jobPostingCity;
    }

    public static String getJobPostingDescription() {
        return jobPostingDescription;
    }

    public static String getJobPostingLocation() {
        return jobPostingLocation;
    }

    public static String getJobPostingSalaryMin() {
        return jobPostingSalaryMin;
    }

    public static String getJobPostingSalaryMax() {
        return jobPostingSalaryMax;
    }

    public static String getJobPostingTitle() {
        return jobPostingTitle;
    }

    public static String getWebUrl() {
        return webUrl;
    }

    public static String getAdminUrl() {
        return adminUrl;
    }

    public static String getTestCandidateEmail() {
        return testCandidateEmail;
    }

    public static String getCandidatePassword() {
        return candidatePassword;
    }

    public static String getCandidateId() { return candidateId; }

    public static String getInvalidCandidateId() { return invalidCandidateId; }

    public static String getTestClientEmail() {
        return testClientEmail;
    }

    public static String getTestClientEmailWithNoCredits() {
        return testClientEmailWithNoCredits;
    }

    public static String getTestClientPassword() {
        return testClientPassword;
    }

    public static String getAdminUsername() {
        return adminUsername;
    }

    public static String getAdminPassword() {
        return adminPassword;
    }

    public String getRandomCandidateEmail() {
        return randomCandidateEmail;
    }

    public String getRandomPartnerEmail() {
        return randomPartnerEmail;
    }

    public  String getRandomClientEmail() {
        return randomClientEmail;
    }

    public  String getRandomCompanyName() {
        return randomCompanyName;
    }

    public  String getRandomAccountEmail() {
        return randomAccountEmail;
    }

    public  String getRandomEmail() {
        return randomEmail;
    }

    public static String getTownCity() {
        return TownCity;
    }

    public static String getExpiryDate() {
        return ExpiryDate;
    }

    public static String getInvalidCardNumber() {
        return InvalidCardNumber;
    }

    public static String getInvalidCvv() {
        return InvalidCvv;
    }

    public static String getValidCardNumber() {
        return ValidCardNumber;
    }

    public static String getValidCvv() {
        return ValidCvv;
    }

    public static String getRetryPaymentBtn() {
        return RetryPaymentBtn;
    }
}