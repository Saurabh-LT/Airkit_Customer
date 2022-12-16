package com.resumelibrary.cucumber.stepdefinitions.web.client;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.client.ManageUsersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ManageUsers extends Utility {

    @When("I click on manage users active action one")
    public void iClickOnManageUsersActiveActionOne() {
        new ManageUsersPage().clickOnManageUsersActiveActionOne();
    }

    @And("I should see text Deactivate User {string}")
    public void iShouldSeeTextDeactivateUser(String text) {
        Assert.assertEquals(new ManageUsersPage().verifyTextDeactivateUser(text), text);
    }

    @Then("I click to activate the inactive user from the list")
    public void iClickToActivateTheInactiveUserFromTheList() {
        new ManageUsersPage().clickOnManageUsersInactiveAction();
    }

    @Then("I select {string} from from client")
    public void iSelectFromFromClient(String fromValue) {
        new ManageUsersPage().selectFromClient(fromValue);
    }

    @And("I select {string} from to client")
    public void iSelectFromToClient(String toValue) {
        new ManageUsersPage().selectToClient(toValue);
    }

    @And("I fill in amount with {string}")
    public void iFillInAmountWith(String amount) {
        new ManageUsersPage().enterAmount(amount);
    }

    @And("I click on Transfer button")
    public void iClickOnTransferButton() {
        new ManageUsersPage().clickOnTransferButton();
    }

    @When("I enter client email address to reset password")
    public void iEnterClientEmailAddressToResetPassword() {
        new ManageUsersPage().enterEmailAddressToResetPassword();
    }

    @And("I should see button {string}")
    public void iShouldSeeButton(String text) {
        new ManageUsersPage().verifyButton(text);
    }

    @And("I should see message {string} in the manage users xpath")
    public void iShouldSeeMessageInTheManageUsersXpath(String text) {
        new ManageUsersPage().shouldSeeMessageInTheManageUsersXpath(text);
    }

    @When("I click on Add User button")
    public void iClickOnAddUserButton() {
        new ManageUsersPage().clickOnAddUserBtn();
    }

    @And("I click on Edit User button")
    public void iClickOnEditUserButton() {
        new ManageUsersPage().clickOnAddUserBtn();
    }
}