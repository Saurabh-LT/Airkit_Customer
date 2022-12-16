package com.resumelibrary.webtest.client;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SavedResumesPage extends Utility {

    public SavedResumesPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(ResumeViewPage.class);

    List<String> sortedList;
    @FindBy(xpath = "//div[@class='table-wrap']/table/tbody/tr/td[4]/a")
    List<WebElement> listOfCandidate;
    @FindBy(xpath = "//div[@class='table-wrap']/table/tbody/tr/td[3]")
    List<WebElement> dates;
    @FindBy(xpath = "//input[@value='datetime DESC']")
    WebElement dateSavedDesc;
    @FindBy(xpath = "//input[@value='datetime ASC']")
    WebElement dateSavedAsc;
    @FindBy(xpath = "//div[@class='table-wrap']/table/tbody/tr/td[6]")
    List<WebElement> SavedBy;

    public List<String> getListOfCandidates() {
        sortedList = getDataList(listOfCandidate);
        logger.info("Getting list of candidates ");
        return sortedList;

    }

    public List<String> ascendingOrderCandidateName() {
        sortedList = getListByAscOrder(listOfCandidate);
        logger.info("Sorting candidate name by asc order" + sortedList);
        return sortedList;
    }

    public List<String> descendingOrderCandidateName() {
        sortedList = getListByDescOrder(listOfCandidate);
        logger.info("Sorting candidate name by desc order" + sortedList);
        return sortedList;
    }

    public List<String> getListOfDates() {
        sortedList = getDataList(dates);
        logger.info("Getting list of dates ");
        return sortedList;

    }

    public List<String> ascendingOrderDatesSaved() {
        sortedList = getListByAscOrder(dates);
        logger.info("Sorting date name by asc order" + sortedList);
        return getSortedDatesAsc(sortedList);
    }

    public List<String> descendingOrderDatesSaved() {
        sortedList = getListByDescOrder(dates);
        logger.info("Sorting date name by desc order" + sortedList);
        return getSortedDatesDesc(sortedList);

    }

    public void clickOnDateSavedDesc() {
        logger.info("Clicking on desc arrow on date save ");
        clickOnElement(dateSavedDesc);
    }

    public void clickOnDateSavedAsc() {
        logger.info("Clicking on asc arrow on date save ");
        clickOnElement(dateSavedAsc);
    }

    public List<String> getListOfSavedByNames() {
        sortedList = getDataList(SavedBy);
        logger.info("Getting list of Saved by names ");
        return sortedList;

    }

    public List<String> ascendingOrderSavedByNames() {
        sortedList = getListByAscOrder(SavedBy);
        logger.info("Sorting Saved by asc order" + sortedList);
        return sortedList;
    }

    public List<String> descendingOrderSavedByNames() {
        sortedList = getListByDescOrder(SavedBy);
        logger.info("Sorting Saved by desc order" + sortedList);
        return sortedList;
    }
}
