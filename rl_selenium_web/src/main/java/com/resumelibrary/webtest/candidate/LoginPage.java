package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.DataHelper;
import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends Utility {

    public LoginPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(id = "email")
    WebElement EmailAddress;
    @FindBy(id = "pass")
    WebElement Password;
    @FindBy(id = "signin-as-jobseeker")
    WebElement LoginAsJobseekerButton;
    @FindBy(id = "password-reset-link")
    WebElement ForgotPasswordLink;
    @FindBy(id = "reset-email")
    WebElement ResetEmailAddress;
    @FindBy(id = "login-reset-submit-btn")
    WebElement ResetPasswordButton;
    @FindBy(id = "login_now")
    WebElement LoginNowButton;
    @FindBy(id = "recruiter-login-icon")
    WebElement RecruiterLoginIcon;
    @FindBy(id = "client-login-submit-btn")
    WebElement LoginAsEmployerButton;
    @FindBy(id = "signup-get-review-btn")
    WebElement LoginAndReviewMyResumeButton;

    public void fillInEmailAddress() {
        logger.info("Entered email address ");
        EmailAddress.sendKeys(DataHelper.getTestCandidateEmail());
    }

    public void fillInPassword() {
        logger.info("Entered password ");
        Password.sendKeys(DataHelper.getCandidatePassword());
    }

    public void entersChangedPasswordAs(String newPassword) {
        Password.sendKeys(newPassword);
    }

    public void fillInInvalidPassword() {
        logger.info("Entered password ");
        Password.sendKeys("1234567");
    }

    public void clickLoginAsJobSeekerButton() {
        logger.info("Clicking on login as job seeker button ");
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(1);
        }
        clickOnElement(LoginAsJobseekerButton);
    }

    public void clickForgotPassword() {
        logger.info("clicking on forgot password link ");
        clickOnElement(ForgotPasswordLink);
    }

    public void fillInEmailAddressToResetPassword() {
        logger.info("Entered email address ");
        ResetEmailAddress.sendKeys(DataHelper.getTestCandidateEmail());
    }

    public void clickResetPasswordButton() {
        logger.info("Clicking on reset password button ");
        clickOnElement(ResetPasswordButton);
    }

    public void clickOnLoginNowButton() {
        logger.info("Clicking on login now button ");
        clickOnElement(LoginNowButton);
        waitFor(1);
    }

    public void clickOnRecruiterLoginIcon() {
        logger.info("Clicking on recruiter login icon ");
        clickOnElement(RecruiterLoginIcon);
    }

    public void loginAsEmployerButtonIsDisplay() {
        logger.info("Verifying that login as employer button is display ");
        Assert.assertTrue(verifyThatElementIsDisplayed(LoginAsEmployerButton), "[---> " + LoginAsEmployerButton + " is not visible <---]");
    }

    public void clickOnLoginAndReviewMyResume() {
        logger.info("Clicking on login and review my resume button ");
        clickOnElement(LoginAndReviewMyResumeButton);
    }
}