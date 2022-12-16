package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.CompaniesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class Companies extends Utility {

   // public Companies(WebDriver driver) {
   //     super(driver);
   // }

    @When("I enter company name {string}")
    public void iEnterCompanyName(String name) {
        new CompaniesPage().enterCompaniesName(name);
    }

    @And("I click on search companies button")
    public void iClickOnSearchCompaniesButton() {
        new CompaniesPage().clickOnSearchCompaniesButton();
    }

    @And("I click on {string} pagination")
    public void iClickOnPagination(String pageNumber) {
        new CompaniesPage().clickOnPageNumber(pageNumber);
    }

    @Then("I click on companies page title {string}")
    public void iClickOnCompaniesPageTitle(String title) {
        new CompaniesPage().clickOnTitle(title);
    }

    @And("I click on companies {string}")
    public void iClickOnCompanies(String company) {
        new CompaniesPage().clickOnCompany(company);
    }

    @And("I click on View All")
    public void iClickOnViewAll() {
        new CompaniesPage().clickOnViewAllLink();
    }

    @And("I click on companies by state from list {string}")
    public void iClickOnCompaniesByStateFromList(String byState) {
    }

    @Then("I click on popular job title {string}")
    public void iClickOnPopularJobTitle(String title) {
        new CompaniesPage().clickOnPopularJobTitle(title);
    }

    @When("I click on Also in other locations")
    public void iClickOnAlsoInOtherLocations() {
    }

    @Then("I should see text View all locations")
    public void iShouldSeeTextViewAllLocations() {
    }

    @When("I click on {string} and see link {string}")
    public void iClickOnAndSeeLink(String alsoInOtherLocations, String viewAllLocations) {
        new CompaniesPage().clickOnAlsoOtherLocations(alsoInOtherLocations,viewAllLocations);
    }
}