package com.resumelibrary.cucumber.stepdefinitions.web.client;

import com.resumelibrary.webtest.client.HiringPage;
import io.cucumber.java.en.When;

public class Hiring {

    @When("I click on next icon")
    public void iClickOnNextIcon() {
        new HiringPage().clickOnNextIcon();
    }

    @When("I click on prev icon")
    public void iClickOnPrevIcon() {
        new HiringPage().clickOnPrevIcon();
    }

    @When("I click on slide {string} where title is {string}")
    public void iClickOnSlideWhereTitleIs(String slideNum, String name) {
        new HiringPage().clickOnPSList(slideNum,name);
    }
}
