package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.*;
import com.resumelibrary.webtest.candidate.FastTrackRegisterPage;
import com.resumelibrary.webtest.candidate.JobSearchPage;
import com.resumelibrary.webtest.candidate.OthersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.*;

public class Others extends Utility {

    public Others() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(Others.class);

    @When("I click Send Request button")
    public void iClickSendRequestButton() {
        new OthersPage().clickSendRequestButton();
    }

    @And("I fill in Email address with {string}")
    public void iFillInEmailAddressWith(String text) {
        new OthersPage().fillInEmailAddressWith(text);
    }

    @Then("I fill in Email address with random client email")
    public void iFillInEmailAddressWithRandomClientEmail() {
        new OthersPage().fillInRandomClientEmailAddress();
    }

    @And("I fill in Message")
    public void iFillInMessage() {
        new OthersPage().fillInMessage();
    }

    @And("I select the option {string} from Request")
    public void iSelectTheOptionFromRequest(String text) {
        new OthersPage().selectTheOptionFromRequest(text);
    }

    @And("I fill in Name")
    public void iFillInName() {
        new OthersPage().fillInName();
    }

    @When("I click Login button")
    public void iClickLoginButton() {
        new OthersPage().clickLoginButton();
    }

    @Then("I click Employer login")
    public void iClickEmployerLogin() {
        new OthersPage().clickEmployerLogin();
    }

    @When("I find value {string} and store as a variable")
    public void iFindValueAndStoreAsAVariable(String value) {
        new OthersPage().findValueAndStoreAsVariable();
    }

    @And("I get cookie value with name {string} and store as a variable")
    public void iGetCookieValueWithNameAndStoreAsAVariable(String cookieName) {
        new OthersPage().getCookieValueWithNameAndStoreAsAVariable();
    }

    @And("I compare both variable to verify its not the same")
    public void iCompareBothVariableToVerifyItsNotTheSame() {
        Assert.assertFalse(new OthersPage().compareBothVariableToVerifyItsNotTheSame(),"[---> Both csrf token are same <---]");
        logger.info("Currently both csrf_rl are not same and it should not match!");
    }

    @When("I click on Register button")
    public void iClickOnRegisterButton() {
        new OthersPage().clickRegisterButton();
    }

    @And("I wait for {string} seconds")
    public void iWaitForSeconds(String seconds) {
        waitFor(Integer.parseInt(seconds));
    }

    @Given("I go to page {string}")
    @Given("I am on page {string}")
    public void iAmOnPage(String url) {

        getDriverWithUrl(WebURLHelper.getWebUrl(), getURL(url));
        webDriverWaitContainsUrl(getURL(url));





    }

    @Given("I navigate to page {string}")
    public void iNavigateToPage(String url) {
        logger.info("Web page url to load is : " + WebURLHelper.getWebUrl() + getURL(url));

        getDriverWithUrl(WebURLHelper.getWebUrl(), getURL(url));
        webDriverWaitContainsUrl(getURL(url));


          }

    @Given("I browse the url {string}")
    public void iBrowseTheUrl(String url) {
        logger.info("Web page url to load is : " + WebURLHelper.getWebUrl() + getURL(url));
        getDriverWithUrl(WebURLHelper.getWebUrl(), getURL(url));
    }

    @Given("I navigate to page on admin {string}")
    public void iNavigateToPageAdmin(String url) {
        logger.info("Web page url to load is : " + AdminURLHelper.getAdminUrl() + getURL(url));
        getDriverWithUrl(AdminURLHelper.getAdminUrl(), getURL(url));
        webDriverWaitContainsUrl(getURL(url));
    }

    @Then("I should be on page {string}")
    public void iShouldBeOnPage(String url) {
        String pageURL = WebURLHelper.getWebUrl() + getURL(url);
        logger.info("url to be verified is  : " + pageURL);

        webDriverWaitContainsUrl(getURL(url));
        logger.info("Current url with page is : " + getThreadDriver().getCurrentUrl());
        String verifyUrl = WebURLHelper.getWebUrl() + getURL(url);

        Assert.assertEquals(pageURL, verifyUrl);
    }

    @Then("I should be able to see in browser URL {string}")
    public void iShouldBeAbleToSeeInBrowserURL(String url) {
        new OthersPage().verifyURLText(url,"");
    }

    @Then("I should be able to see in browser obfuscated URL {string}")
    public void iShouldBeAbleToSeeInBrowserObfuscatedURL(String url) {
        new OthersPage().verifyURLText(url,"assets");
    }

    @Then("I should be able to see in browser as URL {string}")
    public void iShouldBeAbleToSeeInBrowserAsURL(String url) {
        new OthersPage().verifyURL(url);
    }

    @Then("I should be able to see {string} in browser url")
    public void iShouldBeAbleToSeeInBrowserUrl(String textInUrl) {
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(2);
        }
        new OthersPage().verifyTextInURL(textInUrl);
    }

    @Then("I click on id {string}")
    public void iClickOnId(String id) {
        clickOnId(id);
    }

    @And("I switch to window {int}")
    public void iSwitchToWindow(int window) {
        switchWindowIndex(window);
    }

    @And("I should not see text {string}")
    public void iShouldNotSeeText(String text) {
        Assert.assertFalse(verifyPageContainsText(text),"[---> " + text + " is not displayed <---]");
    }

    @And("I should see text p tag replace all {string}")
    public void iShouldSeeTextPTagReplaceAll(String text) {
        Assert.assertEquals(verifyTextMessagePTags(text, text), text);
    }

    @And("I should see text p tag {string} and verify message {string}")
    public void iShouldSeeTextPTagAndVerifyMessage(String ptagText, String textTobeVerified) {
        Assert.assertTrue(verifyTextMessagePTags(ptagText, textTobeVerified).toLowerCase().contains(textTobeVerified.toLowerCase()),"[---> " + textTobeVerified + " is not displayed <---]");
    }

    @And("I fill in {string} with random candidate email")
    public void iFillInWithRandomCandidateEmail(String id) {
        fillFieldUsingIdAndText(id, (new DataHelper().getRandomCandidateEmail()));
        waitFor(1);
    }

    @When("I select the option {string} from dropdown with id {string}")
    public void iSelectTheOptionFromDropdownWithId(String text, String id) {
        WebElement we = getElementById(id);
        selectByValueFromDropDown(we, text);
    }

    @Then("I should see text {string} label tag")
    public void iShouldSeeTextLabelTag(String text) {
        Assert.assertEquals(text, verifyTextLabelTag(text));
    }

    @Then("I should see text {string} on the page source")
    public void iShouldSeeTextOnThePageSource(String text) {
        Assert.assertTrue(verifyPageContainsText(text),"[---> " + text + " is not displayed <---]");
    }

    @When("I fill text field where id is {string}  with attribute value {string}")
    public void iFillTextFieldWhereIdIsWithAttributeValue(String id, String value) {
        String javaScript = "document.getElementById('skills-input').value='" + value + "'";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getThreadDriver();
        javascriptExecutor.executeScript(javaScript);
    }

    @When("I fill the text field where id is {string} with: {string}")
    public void iFillTheTextFieldWhereIdIsWith(String id, String text) {
        fillFieldUsingIdAndText(id, text);
    }

    @And("I should see text H one tag {string}")
    public void iShouldSeeTextHOneTag(String text) {
        verifyTextMessageH1Tags(text);
    }

    @And("I click on send application button")
    public void iClickOnSendApplicationButton() {
        new OthersPage().clickOnSendApplicationButton();
    }

    @Then("I click on modify profile link")
    public void iClickOnModifyProfileLink() {
        new OthersPage().clickOnModifyProfileLink();
    }

    @And("I mouse hover to users profile")
    public void iMouseHoverToUsersProfile() {
        new OthersPage().mouseHoverToUsersProfile();
    }

    @And("I click on apply now")
    public void iClickOnApplyNow() {
        new FastTrackRegisterPage().clickOnApplyLinkNow();
    }

    @And("I click on title of the job")
    public void iClickOnTitleOfTheJob() {
        new OthersPage().clickOnJobTitleFromSearchPage();
    }

    @And("I click on apply now job view page")
    public void iClickOnApplyNowJobViewPage() {
        new OthersPage().clickOnJobViewApplyNowButton();
    }

    @And("I should see text with id hide expired application {string}")
    public void iShouldSeeTextWithIdHideExpiredApplication(String text) {
        Assert.assertEquals(new OthersPage().getTextFromElement(), text);
    }

    @And("I click on View button")
    public void iClickOnViewButton() {
        new OthersPage().clickOnViewApplicationButton();
    }

    @When("I click on job title applied link")
    public void iClickOnJobTitleAppliedLink() {
        new OthersPage().clickOnJobTitleAppliedLink();
    }

    @And("I click on {string}")
    public void iClickOn(String text) {
        clickOnElementUsingText(text);
    }

    @When("I click on non external job to apply")
    public void iClickOnNonExternalJobToApply() {
        new JobSearchPage().selectResultsPerPage("250");
        new OthersPage().clickOnNonExternalApplyNowButton();
    }

    @And("I move backward one page")
    public void iMoveBackwardOnePage() {
        backwardOnThePage();
    }

    @And("I should see text H two tag {string}")
    public void iShouldSeeTextHTwoTag(String text) {
        Assert.assertEquals(verifyTextMessageH2Tags(text), text);
    }

    @And("I should see text H three tag {string}")
    public void iShouldSeeTextHThreeTag(String text) {
        Assert.assertEquals(verifyTextMessageH3Tags(text), text);
    }

    @And("I should see text H four tag {string}")
    public void iShouldSeeTextHFourTag(String text) {
        Assert.assertEquals(verifyTextMessageH4Tags(text), text);
    }

    @And("I should see text div tags {string} and verify {string}")
    public void iShouldSeeTextDivTagsAndVerify(String text, String text1) {
        Assert.assertEquals(verifyTextMessageDivTags(text), text1);
    }

    @And("I should see text span tags {string}")
    public void iShouldSeeTextSpanTags(String text) {
        Assert.assertEquals(verifyTextMessageSpanTag(text), text);
    }

    @Then("I should see text a tags {string} and verify {string}")
    public void iShouldSeeTextATagsAndVerify(String text, String text1) {
        Assert.assertEquals(verifyTextMessageATags(text), text1);
    }

    @Then("I should see the external url {string}")
    public void iShouldSeeTheExternalUrl(String URL) {
        Assert.assertEquals(getThreadDriver().getCurrentUrl(), URL);
    }

    @And("I should see text h one tags {string} and verify message {string}")
    public void iShouldSeeTextHOneTagsAndVerifyMessage(String text, String text1) {
        Assert.assertEquals(verifyTextMessageH1Tags(text), text1);
    }

    @And("I confirm browser popup")
    public void iConfirmBrowserPopup() {
        try {
            acceptAlertPopUp();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Then("I should see bread crumbs {string} with class name: {string}")
    public void iShouldSeeBreadCrumbs(String text, String className) {
        List<String> textTobVerified = Arrays.asList(text.split(">"));
        logger.info("Bread crumbs to be verified : " + textTobVerified);
        boolean foundAllBreadCrumbs = false;
        String textActualOnPage = verifyBreadCrumbs(className);
        logger.info("Bread crumbs on page : " + textActualOnPage);
        for (Object obj : textTobVerified) {
            if (textActualOnPage.contains(obj.toString())) {
                logger.info("Bread crumb found on page : " + obj);
                foundAllBreadCrumbs = true;
            } else {
                logger.info("Bread crumb not found on page : " + obj);
                foundAllBreadCrumbs = false;
            }
        }
        Assert.assertTrue(foundAllBreadCrumbs,"[---> " + text + " breadcrumbs is not visible <---]");
    }

    @Then("I should see label tag {string} and verify {string}")
    public void iShouldSeeLabelTagAndVerify(String label, String labelText) {
        Assert.assertTrue(labelText.contains(verifyTextLabelTag(label)),"[---> " + labelText + " is not displayed <---]");
    }

    @When("I find a non external job to apply for")
    public void iFindANonExternalJobToApplyFor() {
        new OthersPage().clickOnNonExternalApplyNowButton();
    }

    @And("I should see text h two tag {string} and verify message {string}")
    public void iShouldSeeTextHTwoTagAndVerifyMessage(String text, String text1) {
        Assert.assertEquals(verifyTextMessageH2Tags(text), text1);
    }

    @And("I scroll down (\\d+),(\\d+)$")
    public void iScrollDown(int y, int x) {
        scrollDown(y, x);
    }

    @And("I scroll up (\\d+),(\\d+)$")
    public void iScrollUp(int y, int x) {
        scrollUp(y, x);
    }

    @And("I click on id starts with {string}")
    public void iClickOnIdStartsWith(String id) {
        clickOnIdStartsWith(id);
    }

    @And("I click on id ends with {string}")
    public void iClickOnIdEndsWith(String id) {
        clickOnIdEndsWith(id);
    }

    @And("I scroll to an element {string}")
    public void iScrollToAnElement(String text) {
        scrollToAnElement(text);
    }

    @Then("I should be able to see in browser http URL {string}")
    public void iShouldBeAbleToSeeInBrowserHttpURL(String url) {
        new OthersPage().verifyHTTPURLText(url);
    }

    @And("I should see element with text {string} to be {string}")
    public void iShouldSeeElementWithTextVisibleOrInvisible(String elementText, String condition) {
        new OthersPage().iShouldSeeElementWithTextVisibleOrInvisible(elementText, condition);
    }
    @And("I should see element with id {string} to be {string}")
    public void iShouldSeeElementWithIdVisibleOrInvisible(String elementId, String condition) {
        new OthersPage().iShouldSeeElementWithIdVisibleOrInvisible(elementId, condition);
    }
    @Then("I click on link text {string}")
    public void iClickOnLinkText(String text) {
        clickOnElementUsingLinkText(text);
    }
}