package com.resumelibrary.webtest.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.utilities.WebURLHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class JobSearchPage extends Utility {

    public JobSearchPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(JobSearchPage.class);

    @FindBy(id = "top-search-q")
    WebElement SearchKeyword;
    @FindBy(id = "top-search-loc")
    WebElement TopSearchLocation;
    @FindBy(id = "search_radius")
    WebElement Radius;
    @FindBy(id = "top-search-jobs-btn")
    WebElement SearchJobsButton;
    @FindBy(id = "search_loc")
    WebElement SearchLocation;
    @FindBy(id = "q")
    WebElement JobTitleQ;
    @FindBy(id = "home-search-submit")
    WebElement FindJobs;
    @FindBy(id = "annual_salary_from")
    WebElement SalaryMin;
    @FindBy(id = "annual_salary_to")
    WebElement SalaryMax;
    @FindBy(id = "job_type")
    WebElement JobType;
    @FindBy(id = "pd")
    WebElement PostedSince;
    @FindBy(xpath = "//a[text() = \"2\"]")
    WebElement LinkIndexPage;
    @FindBy(id = "search-results-distance")
    WebElement SearchResultDistance;
    @FindBy(id = "posted_date")
    WebElement PostedDate;
    @FindBy(id = "displaying-text")
    WebElement DisplayingText;
    @FindBy(id = "results-pp")
    WebElement ResultsPerPage;
    @FindBy(id = "job_title__nat_prem_1")
    WebElement FeaturedJobOne;
    @FindBy(id = "suggested-locations-1")
    WebElement SuggestedLocationsOne;
    @FindBy(id = "suggested-locations-2")
    WebElement SuggestedLocationsTwo;
    @FindBy(xpath = "//*[@class='search-result-info-desc desc--location']")
    WebElement JobCardLocation;
    @FindBy(xpath = "//*[@class='search-result-info-term term--salary']")
    WebElement JobCardSalaryLabel;
    @FindBy(xpath = "//*[@id=\"show_our_jobs\"]/div[1]/div[1]/div/p/span")
    WebElement JobCardPostedWithin;
    //xpath for "San Francisco"
    @FindBy(xpath = "//*[@id=\"location-jobs-module\"]/div/ul/li[*]/a")
    WebElement LocationLinkFromModule;
    @FindBy(css = ".reasons-other-input")
    WebElement ReasonsOtherInput;
    @FindBy(css = ".search-job-title-link")
    WebElement SearchJobTitle;
    @FindBy(id = "order_by")
    WebElement OrderBy;
    @FindBy(id = "results-order")
    WebElement SortBy;
    @FindBy(xpath = "//section[@id='similar-jobs-module-jobview']//h4[.='Similar Jobs']")
    WebElement SimilarJobSectionToggle;
    @FindBy(id = "similar-jobs-jobview")
    WebElement SimilarJobsJobView;
    @FindBy(xpath = "//*[@id=\"similar-jobs-job-view\"]/p[1]/a")
    WebElement SimilarJobOne;
    String SearchJobsNavigationBarButton = "top-search-jobs-btn";
    @FindBy(xpath = "//*[@id='similar-jobs-jobview']/descendant::a")
    List<WebElement> listOfSimilarJobs;
    @FindBy(xpath = "//*[@class = 'caution-div']/h3")
    WebElement CautionMessageH3;
    @FindBy(xpath = "//*[@class = 'caution-div']/p")
    WebElement CautionMessagePtag;
    @FindBy(xpath = "//*[@id='recent-jobs-module']/descendant::a")
    WebElement RecentlyViewedJob;

    public void enterSearchJobsNavBarKeyword(String keyword) {
        logger.info("Keyword entered in search jobs nav bar field is  : " + keyword);
        SearchKeyword.sendKeys(keyword);
    }

    public void enterSearchJobsNavBarLocation(String location) {
        logger.info("Location entered in search jobs nav bar location field is  : " + location);
        TopSearchLocation.sendKeys(location);
    }

    public void selectDistance(String distance) {
        logger.info("Select the radius from dropdown is : " + distance);
        selectByVisibleTextFromDropDown(Radius, distance);
    }

    public String getDistanceAttributeValue() {
        logger.info("Verifying distance value " + SearchResultDistance);
        return SearchResultDistance.getAttribute("data-orig");
    }

    public void clickButtonSearchJobs() {
        logger.info("click on Search Jobs button");
        clickOnElement(SearchJobsButton);
    }

    public void verifySearchJobsNavigationBarButtonHasText(String text) {
        logger.info("verifying the search jobs navigation bar button has text : " + text);
        String InputValue = getThreadDriver().findElement(By.id("top-search-jobs-btn")).getAttribute("value");
        Assert.assertTrue(text.equalsIgnoreCase(InputValue), "[---> " + InputValue + " button is not visible <---]");
    }

    public void verifyThatSearchJobsNavigationBarButtonIsNotDisplay() {
        logger.info("Verifying search jobs navigation bar button is not display ");
        Assert.assertFalse(verifyThatElementIsDisplayedUsingLocator("id", SearchJobsNavigationBarButton),"[---> Find jobs button is visible <---]");
    }

    public void enterJobTitle(String jobTitle) {
        logger.info("Keyword/title filled with :" + jobTitle);
        JobTitleQ.sendKeys(jobTitle);
    }

    public String getJobTitleAttributeValue() {
        logger.info("Verifying job title value " + JobTitleQ);
        return JobTitleQ.getAttribute("data-orig");
    }

    public void enterSearchLocation(String location) {
        logger.info("Entered search location is " + location);
        SearchLocation.sendKeys(location);
    }

    public String getLocationAttributeValue() {
        logger.info("Verifying location value " + SearchLocation);
        return SearchLocation.getAttribute("data-orig");
    }

    public void clickFindJobs() {
        logger.info("click on Find jobs button");
        clickOnElement(FindJobs);
    }

    public void verifyRedirectURL() {
        try {
            logger.info("verify redirect url");
            HttpURLConnection conn = (HttpURLConnection) (new URL(getThreadDriver().getCurrentUrl()).openConnection());
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            boolean redirect = false;
            int status = conn.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK) {
                if (status == HttpURLConnection.HTTP_MOVED_TEMP
                        || status == HttpURLConnection.HTTP_MOVED_PERM
                        || status == HttpURLConnection.HTTP_SEE_OTHER)
                    redirect = true;
            }
            logger.info("Response Code :" + status + "     Redirected :" + redirect);
            if (redirect) {
                // get redirect url from "location" header field
                String newUrl = conn.getHeaderField("Location");
                // get the cookie if need, for login
                String cookies = conn.getHeaderField("Set-Cookie");
                // open the new connnection again
                conn = (HttpURLConnection) new URL(newUrl).openConnection();
                conn.setRequestProperty("Cookie", cookies);
                conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
                conn.addRequestProperty("User-Agent", "Mozilla");
                conn.addRequestProperty("Referer", "google.com");
                Assert.assertEquals(status, 200, "Response Code is not 200 while search in home page and URL Redirected to:" + newUrl);
            } else {
                Assert.assertEquals(status, 200, "Response Code is not 200 while search in home page");
            }
        } catch (Exception e) {
            Assert.fail("Failed redirect url :" + e.getMessage());
        }


    }

    public void selectMinSalary(String salMin) {
        logger.info("select the option min salary :" + salMin);
        selectByValueFromDropDown(SalaryMin, salMin);
    }

    public String getSalaryMinAttributeValue() {
        logger.info("Verifying salary min value " + SalaryMin);
        return SalaryMin.getAttribute("data-orig");
    }

    public void selectMaxSalary(String salMax) {
        logger.info("select the option max salary :" + salMax);
        selectByValueFromDropDown(SalaryMax, salMax);
    }

    public String getSalaryMaxAttributeValue() {
        logger.info("Verifying salary max value " + SalaryMax);
        return SalaryMax.getAttribute("data-orig");
    }

    public void selectJobType(String jobType) {
        logger.info("select the option job type as  :" + jobType);
        selectByValueFromDropDown(JobType, jobType);
    }

    public String getJobTypeAttributeValue() {
        logger.info("Verifying job type value " + JobType);
        return JobType.getAttribute("data-orig");
    }

    public void selectPostedSince(String pd) {
        logger.info("select the option posted since  :" + pd);
        selectByValueFromDropDown(PostedSince, pd);
    }

    public String getPostedSinceAttributeValue() {
        logger.info("Verifying posted since value " + PostedDate);
        return PostedDate.getAttribute("data-orig");
    }

    public boolean verifyPageContainsLinkwithId(String link, String elementId) {
        logger.info("link/button : " + link + " to be verified with element id :" + elementId);
        int i = 0;
        do {
            waitFor(1);
            List<WebElement> linkWithId = getThreadDriver().findElements(By.xpath("//a[@id='" + elementId + "']"));
            List<WebElement> otherElementWithId = getThreadDriver().findElements(By.xpath("//*[@id='" + elementId + "']"));
            if (linkWithId.size() > 0 || otherElementWithId.size() > 0) {
                return true;
            }
            i++;
            if (elementId.equalsIgnoreCase("save_toggle_20")) {
                i = 4;
            }
        } while (i < 4);

        return false;
    }

    public void verifyLinkOnThePage(String link) {
        logger.info("link/button :" + link + "is to be verified");
        Assert.assertTrue(isAnchorElementDisplayed(link), "[---> Link " + link + " is not visible <---]");
    }

    public void verifyLinkUsingIdOnThePage(String link) {
        logger.info("link/button :" + link + "is to be verified");
        Assert.assertTrue(isAnchorElementUsingIdDisplayed(link), "[---> Link " + link + " is not visible <---]");
    }

    public void clickOnLink(String link) {
        logger.info("link/button :" + link + " clicked");
        clickOnElement(LinkIndexPage);
    }

    public void verifyDisplayingText(String displayingText) {
        waitUntilElementIsLocated(DisplayingText, 15);
        String textOnElement = DisplayingText.getText();
        logger.info("text to be verified :" + displayingText + "against text :" + textOnElement);
        Assert.assertEquals(textOnElement, displayingText);
    }

    public void selectResultsPerPage(String searchResults) {
        logger.info("selected the option  :" + searchResults);
        selectByVisibleText(ResultsPerPage, searchResults);
    }

    public void verifyResultsPerPage(String option) {
        Select select = new Select(ResultsPerPage);
        WebElement optionSelected = select.getFirstSelectedOption();
        String defaultItem = optionSelected.getText();
        logger.info("selected the option  :" + defaultItem);
        Assert.assertEquals(option, defaultItem);
    }

    public void clickOnFeaturedJobOne() {
        logger.info("Click on first link form the featured Jobs list ");
        clickOnElement(FeaturedJobOne);
    }

    public void clickOnSuggestedLocationsOne() {
        logger.info("Click on first link form the suggested locations list ");
        clickOnElement(SuggestedLocationsOne);
    }

    public void clickOnSuggestedLocationsTwo() {
        logger.info("Click on second link form the suggested locations list ");
        clickOnElement(SuggestedLocationsTwo);
    }

    public String verifyJobCardLocation(String location) {
        logger.info("Verifying Job Card location: " + location);
        return JobCardLocation.getText();
    }

    public void verifyJobCardLocationDistance(String distance) {
        logger.info("Verifying Job Card location Distance: " + distance);
        Assert.assertTrue(JobCardLocation.getText().contains(distance), "[---> " + distance + " is not displayed in the job card <---]");
    }

    public boolean verifyJobCardPostedWithin() {
        logger.info("Verifying Job Card location: ");
        switch (JobCardPostedWithin.getText()) {
            case "Today":
            case "Yesterday":
            case "2 days ago":
            case "3 days ago":
            case "4 days ago":
            case "5 days ago":
                return true;
        }
        return false;
    }

    public String verifyJobCardSalary(String salary) {
        logger.info("Verifying Job Card location: " + salary);
        return JobCardSalaryLabel.getText();
    }

    public void clickOnInLocationModule(String location) {
        logger.info("Clicking on San Francisco link from jobs by location module" + location);
        List<WebElement> elements = getThreadDriver().findElements(By.xpath("//*[@id='location-jobs-module']/div/ul/li[*]/a"));
        for (WebElement ele : elements) {
            if (ele.getText().contains(location)) {
                clickOnElement(By.xpath("//*[@id='location-jobs-module']/div/ul/li[*]/a[contains(text(),'" + location + " ')]"));
                break;
            }
        }
    }

    public void scrollDownToElement(String text) {
        Point location = getElementLocation(text);
        scrollDown(location.x, location.y);
        waitFor(1);
    }

    public void enterReasonsOtherInput(String input) {
        logger.info("Entered reasons other input : " + input);
        ReasonsOtherInput.sendKeys(input);
    }

    public void clickOnSearchJobTitle() {
        logger.info("click on Search Jobs title");
        clickOnElement(SearchJobTitle);
    }

    public String getDistanceIsSelected() {
        logger.info("Verifying distance selected");
        return getFirstSelectedOption(SearchResultDistance);
    }

    public String getSalMinIsSelected() {
        logger.info("Verifying sal min selected");
        return getFirstSelectedOption(SalaryMin);
    }

    public String getSalMaxIsSelected() {
        logger.info("Verifying sal max selected");
        return getFirstSelectedOption(SalaryMax);
    }

    public void selectOrderByFromList(String orderBy) {
        logger.info("Selected order by from dropdown : " + orderBy);
        selectByVisibleTextFromDropDown(OrderBy, orderBy);
    }

    public void selectSortByFromList(String sortBy) {
        logger.info("Selected order by from dropdown : " + sortBy);
        selectByVisibleTextFromDropDown(SortBy, sortBy);
    }

    public String getSortByIsSelected() {
        logger.info("Verifying sort by is selected");
        return getFirstSelectedOption(SortBy);
    }

    public String getPostedInTheIsSelected() {
        logger.info("Verifying posted in the is selected");
        return getFirstSelectedOption(PostedDate);
    }

    public String getJobTypeIsSelected() {
        logger.info("Verifying job type is selected");
        return getFirstSelectedOption(JobType);
    }

    public void clickOnJobFromSimilarJobs() {
        logger.info("click On Similar Jobs");
        WebElement similarJobElement = getThreadDriver().findElement(By.xpath("(//*[@id=\"similar-jobs-module-jobview\"]//a)[1]"));
        System.setProperty("SimilarJob", similarJobElement.getText());
        clickOnElement(similarJobElement);
    }

    public boolean similarJobsSectionDisplayStyle() {
        clickOnElement(SimilarJobSectionToggle);
        logger.info("Similar jobs section displayed" + hasDisplayedNoneStyle(SimilarJobsJobView));
        return hasDisplayedNoneStyle(SimilarJobsJobView);
    }

    public boolean hasSimilarJobLoaded() {
        waitUntilElementIsLocated(SimilarJobOne,10);
        return true;
    }

    public void iShouldBeAbleToSeeInBrowserURL() {
        logger.info("click On Similar Jobs");
        String url = "";
        if (System.getProperty("SimilarJob").contains(" ")) {
            url = (System.getProperty("SimilarJob").split(" ")[0]).toLowerCase() + "-" + (System.getProperty("SimilarJob").split(" ")[1]).toLowerCase();
        } else {
            url = (System.getProperty("SimilarJob").toLowerCase());
        }
        new OthersPage().verifyURLText(url,"");
    }

    public String getCautionMessageH3Tag() {
        return getTextFromElement(CautionMessageH3);
    }

    public String getCautionMessagePtag() {
        return getTextFromElement(CautionMessagePtag);
    }

    public void clickOnSimilarJobs() {

        for (int i = 0; i < listOfSimilarJobs.size(); i++) {
            if (i <= 2) {
                String titleText = getTextFromElement(listOfSimilarJobs.get(i));
                clickOnElement(listOfSimilarJobs.get(i));
                switchWindowIndex(1);
                waitFor(2);
                Assert.assertTrue(getTitleOfThePage().contains(titleText),"[---> " + titleText + " is not title of current page <---]");
                new OthersPage().verifyTextInURL("/job/view");
                getThreadDriver().close();
                switchWindowIndex(0);
            } else if (i > 2) {
                clickOnElement(listOfSimilarJobs.get(i));
                switchWindowIndex(1);
                new OthersPage().verifyTextInURL("/register/apply");
                Assert.assertFalse(getTitleOfThePage().contains("404"),"[---> 404 is title of the page <---]");
                logger.info("Similar jobs module for external URLs should not contains 404");
                getThreadDriver().close();
                switchWindowIndex(0);
            }
        }
    }
    public void clickJobTitleOnRecentlyViewedJobs() {
        logger.info("click on title of the recently viewed jobs");
        clickOnElement(RecentlyViewedJob);
    }
}
