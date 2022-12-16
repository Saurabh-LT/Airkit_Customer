package com.resumelibrary.cucumber.stepdefinitions.web.client;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.client.RegistrationPage;
import io.cucumber.java.en.And;

public class Registration extends Utility {

    @And("I click on enter address manually link")
    public void iClickOnEnterAddressManuallyLink() {
        new RegistrationPage().clickOnEnterAddressManuallyLink();
    }

    @And("I enter address one {string}")
    public void iEnterAddressOne(String address) {
        new RegistrationPage().enterAddress1(address);
    }

    @And("I select {string} from recruiter type")
    public void iSelectFromRecruiterType(String type) {
        new RegistrationPage().selectRecruiterType(type);
    }
}