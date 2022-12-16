package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JobApplyPage extends Utility {

    public JobApplyPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(JobApplyPage.class);

    @FindBy(id = "title")
    WebElement JobTitle;
    @FindBy(id = "fast-track-registration-email1")
    WebElement Email1;
    @FindBy(id = "fast-track-registration-first-name1")
    WebElement FirstName1;
    @FindBy(id = "fast-track-registration-password1")
    WebElement Password1;
    @FindBy(id = "question_1")
    WebElement Question1;
    @FindBy(name = "question[1][answers][1][answer]")
    WebElement Answer1;
    @FindBy(name = "question[1][answers][2][answer]")
    WebElement Answer2;
    @FindBy(id = "desirable-question-1-answers-1")
    WebElement DeirableAnswer1;
    @FindBy(id = "ans_")
    WebElement VacancySpecificQuestion;
    @FindBy(id = "job-details-title")
    WebElement JobDetailsTitleText;

    public void enterJobTitle(String title) {
        logger.info("The entered Job Title is : " + title);
        JobTitle.sendKeys(title);
    }

    public void enterFirstName(String firstName) {
        logger.info("The entered Job First Name is : " + firstName);
        FirstName1.sendKeys(firstName);
    }

    public void clickOnFirstName() {
        logger.info("Click on First Name ");
        clickOnElement(FirstName1);
    }

    public void enterEmail(String email) {
        logger.info("The entered email is : " + email);
        Email1.sendKeys(email);
    }

    public void enterPassword(String password) {
        logger.info("The entered password is : " + password);
        Password1.sendKeys(password);
    }

    public void enterQuestion1(String question) {
        logger.info("The entered question 1 is : " + question);
        Question1.sendKeys(question);
    }

    public void enterAnswer1(String answer1) {
        logger.info("The entered answer 1 is : " + answer1);
        Answer1.sendKeys(answer1);
    }

    public void enterAnswer2(String answer2) {
        logger.info("The entered answer 2 is : " + answer2);
        Answer2.sendKeys(answer2);
    }

    public void clickOnDesirableAnswer1() {
        logger.info("selected desirable Answer 1");
        clickOnElement(DeirableAnswer1);
    }

    public void selectVacancySpecificQuestion(String answer) {
        logger.info("selected the option from vacancy specific question " + answer);
        selectByVisibleText(VacancySpecificQuestion, answer);
    }

    public void verifyOneClickApplyText(String text) {
        logger.info("The text : " + text + " to be verified on the page for web element id : ");
        Assert.assertTrue(text.contains(JobDetailsTitleText.getText()),"[---> " + text + " is not visible <---]");
    }
}