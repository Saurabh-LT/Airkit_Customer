package com.resumelibrary.cucumber.stepdefinitions.web.client;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.utilities.WebURLHelper;
import com.resumelibrary.webtest.client.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Products extends Utility {

    @And("I click Buy online button")
    public void iClickBuyOnlineButton() {
        new ProductsPage().clickBuyOnlineButton();
    }

    @And("I click Checkout button")
    public void iClickCheckoutButton() {
        new ProductsPage().clickCheckoutButton();
    }

    @And("I fill in town city field")
    public void iFillInTownCityField() {
        new ProductsPage().fillInTownCity();
    }

    @And("I fill in {string} card number")
    public void iFillInCardNumber(String cardType) {
        new ProductsPage().fillInCardNumber(cardType);
    }

    @And("I fill in {string} cvc")
    public void iFillInCvc(String cvvType) {
        new ProductsPage().fillInCvv(cvvType);
    }

    @And("I fill in expiry date")
    public void iFillInExpiryDate() {
        new ProductsPage().fillInExpiryDate();
    }

    @When("I click Save this card checkbox")
    public void iClickSaveThisCardCheckbox() {
        new ProductsPage().clickSaveCardCheckbox();
    }

    @When("I click Retry Payment button")
    public void iClickRetryPaymentButton() {
        new ProductsPage().clickRetryPaymentButton();
    }

    @When("I click View button to see invoice")
    public void iClickViewButtonToSeeInvoice() {
        new ProductsPage().clickViewButtonToSeeInvoice();
    }

    @Then("I click Pay Now button")
    public void iClickPayNowButton() {
        new ProductsPage().clickPayNowButton();
        waitFor(2);
    }

    @When("I click delete saved card icon")
    public void iClickDeleteSavedCardIcon() {
        new ProductsPage().clickDeletedSavedCardIcon();
    }

    @When("I click delete card confirm button")
    public void iClickDeleteCardConfirmButton() {
        new ProductsPage().clickDeleteCardConfirmButton();
    }

    @When("I mouse hover Products Navigation menu")
    public void iMouseHoverProductsNavigationMenu() {
        new ProductsPage().mouseHoverProductsMenu();
    }

    @Then("I should see a Shopping Cart image")
    public void iShouldASeeShoppingCartImage() {
        new ProductsPage().shouldSeeShoppingCartImage();
    }

    @When("I click on Shopping Cart Image")
    public void iClickOnShoppingCartImage() {
        new ProductsPage().clickOnShoppingCartImage();
    }

    @And("I should see text {string} if Cart Is Empty otherwise Remove the Existing Products")
    public void iShouldSeeTextIfCartIsEmptyOtherwiseRemoveTheExistingProducts(String text){
        new ProductsPage().checkTheCartPage(text);
    }

    @And("I should see “{int}” in the shopping cart")
    public void iShouldSeeInTheShoppingCart(int cartItemsCount) throws InterruptedException {
        new ProductsPage().CheckTheCartItemsCount(cartItemsCount);
    }

    @Then("I click on Remove link in Your cart page")
    public void iClickOnRemoveLinkInYourCartPage() {
        new ProductsPage().clickOnRemoveLink();
    }

    @When("I click on dates purchased descending order")
    public void iClickOnDatesPurchasedDescendingOrder() {
        new ProductsPage().clickOnDatePurchasedDesc();
    }

    @When("I click on dates purchased ascending order")
    public void iClickOnDatesPurchasedAscendingOrder() {
        new ProductsPage().clickOnDatePurchasedAsc();
    }

    @Then("I should see purchased dates in desc order")
    public void iShouldSeePurchasedDatesInDescOrder() {
        Assert.assertEquals(new ProductsPage().getListOfDates(), new ProductsPage().descendingOrderDatesPurchased());
    }

    @Then("I should see in purchased dates in asc order")
    public void iShouldSeeInPurchasedDatesInAscOrder() {
        Assert.assertEquals(new ProductsPage().getListOfDates(), new ProductsPage().ascendingOrderDatesPurchased());
    }

    @When("I click on Invoice No descending order")
    public void iClickOnInvoiceNoDescendingOrder() {
        new ProductsPage().clickOnInvoiceNoDesc();
    }

    @Then("I should see Invoice No in desc order")
    public void iShouldSeeInvoiceNoInDescOrder() {
        Assert.assertEquals(new ProductsPage().getListOfInvoiceNo(), new ProductsPage().descendingOrderInvoiceNo());
    }

    @When("I click on Invoice No ascending order")
    public void iClickOnInvoiceNoAscendingOrder() {
        new ProductsPage().clickOnInvoiceNoAsc();
    }

    @Then("I should see Invoice No in asc order")
    public void iShouldSeeInvoiceNoInAscOrder() {
        Assert.assertEquals(new ProductsPage().getListOfInvoiceNo(), new ProductsPage().ascendingOrderInvoiceNo());
    }

    @When("I click on Product Name descending order")
    public void iClickOnProductNameDescendingOrder() {
        new ProductsPage().clickProductDesc();
    }

    @Then("I should see in Product name in desc order")
    public void iShouldSeeInProductNameInDescOrder() {
        Assert.assertEquals(new ProductsPage().getListOfProducts(), new ProductsPage().descendingOrderOfProdutcts());
    }

    @When("I click on Product name ascending order")
    public void iClickOnProductNameAscendingOrder() {
        new ProductsPage().clickProductAsc();
    }

    @Then("I should see in Product name in asc order")
    public void iShouldSeeInProductNameInAscOrder() {
        Assert.assertEquals(new ProductsPage().getListOfProducts(), new ProductsPage().ascendingOrderOfProdutcts());
    }

    @When("I click on Price descending order")
    public void iClickOnPriceDescendingOrder() {
        new ProductsPage().clickPurchasePriceDesc();
    }

    @When("I click on Price ascending order")
    public void iClickOnPriceAscendingOrder() {
        new ProductsPage().clickPurchasePriceAsc();
    }

    @Then("I should see Purchase Price in desc order")
    public void iShouldSeePurchasePriceInDescOrder() {
        Assert.assertEquals(new ProductsPage().getListOfPurchasePrice(), new ProductsPage().descendingOrderOfPurchasePrice());
    }

    @Then("I should see in Purchase Price asc order")
    public void iShouldSeeInPurchasePriceAscOrder() {
        Assert.assertEquals(new ProductsPage().getListOfPurchasePrice(), new ProductsPage().ascendingOrderOfPurchasePrice());
    }
    @Then("I go to page {string} and to get pagination purchase credits in the page {string}")
    public void iClickNextInPurchaseHistory(String purchaseHistoryURL, String creditsURL) {
        boolean increasedPurchases = false;
        getDriverWithUrl(WebURLHelper.getWebUrl(), getURL(purchaseHistoryURL));
        int purchaseCount = new ProductsPage().getPurchaseCount();
        if (!isAnchorElementDisplayed("2")) {
            while (purchaseCount < 21) {
                getDriverWithUrl(WebURLHelper.getWebUrl(), getURL(creditsURL));
                webDriverWaitContainsUrl(getURL(creditsURL));
                iClickBuyOnlineButton();
                iClickCheckoutButton();
                iFillInTownCityField();
                waitFor(2);
                iFillInCardNumber("valid");
                iFillInCvc("valid");
                iFillInExpiryDate();
                iClickSaveThisCardCheckbox();
                iClickPayNowButton();
                Assert.assertTrue(verifyTextMessage("Thank you for your purchase!"),"[---> Thank you for your purchase! is not displayed <---]");
                purchaseCount++;
            }
            increasedPurchases = true;
        }
        if (increasedPurchases) {
            getDriverWithUrl(WebURLHelper.getWebUrl(), getURL(purchaseHistoryURL));
            webDriverWaitContainsUrl(getURL(purchaseHistoryURL));
        }
    }

    @And("I see if a card is saved then delete it")
    public void iSeeIfACardIsSaved() {
        if(new ProductsPage().checkIfCardIsSaved()) {
            new ProductsPage().clickDeletedSavedCardIcon();
            waitFor(2);
            new ProductsPage().clickDeleteCardConfirmButton();
            waitFor(2);
        }
    }
}