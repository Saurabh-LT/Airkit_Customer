package com.resumelibrary.webtest.client;

import com.resumelibrary.utilities.DataHelper;
import com.resumelibrary.utilities.Utility;
import com.resumelibrary.utilities.WebURLHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends Utility {

    public ProductsPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(ProductsPage.class);

    List<String> sortedList;
    List<Double> sortedInvoiceNoList;
    List<Double> sortedPurchasePriceList;
    @FindBy(xpath = "//div[@class='table-wrap']/table/tbody/tr/td[1]")
    List<WebElement> dates;
    @FindBy(xpath = "//div[@class='table-wrap']/table/tbody/tr/td[2]")
    List<WebElement> invoiceNo;
    @FindBy(xpath = "//div[@class='table-wrap']/table/tbody/tr/td[4]")
    List<WebElement> products;
    @FindBy(xpath = "//div[@class='table-wrap']/table/tbody/tr/td[5]")
    List<WebElement> purchasePrice;
    @FindBy(xpath = "//a[@class='btn buy-btn']")
    WebElement BuyOnlineBtn;
    @FindBy(id = "purchase_checkout")
    WebElement CheckoutBtn;
    @FindBy(xpath = "//button[@class='btn pay']")
    WebElement PayNowBtn;
    @FindBy(xpath = "//*[@id=\"save_card_label\"]")
    WebElement SaveThisCardCheckBox;
    @FindBy(xpath = "//a[@class='btn-sm border-btn view-btn']")
    WebElement ViewInvoiceBtn;
    @FindBy(id = "card-number-iframe")
    WebElement CardNumberIframe;
    @FindBy(id = "card-number")
    WebElement CardNumberTextBox;
    @FindBy(id = "city")
    WebElement TownCityField;
    @FindBy(id = "cvc-iframe")
    WebElement CvvIframe;
    @FindBy(id = "cvv")
    WebElement CvvTextBox;
    @FindBy(id = "expiry-date-iframe")
    WebElement ExpiryDateIframe;
    @FindBy(id = "expiry-date")
    WebElement ExpiryDateTextBox;
    @FindBy(id = "delete-saved-card-btn")
    WebElement DeleteSavedCardIcon;
    @FindBy(id = "delete-card-btn")
    WebElement DeleteCardConfirmButton;
    @FindBy(xpath = "//nav[@label='Site Navigation']/ul/li[9]/a")
    WebElement ProductsNavigationMenu;
    @FindBy(xpath = "//a[text()='Buy online']")
    WebElement BuyOnlineLink;
    @FindBy(xpath = "//span[@class='remove-product']")
    List<WebElement> RemoveLinkList;
    @FindBy(xpath = "//nav[@label='Site Navigation']/ul/li[12]/a[@class='cart-link']")
    WebElement ShoppingCartLink;
    @FindBy(xpath = "//div[@id='product-table-vue']//section")
    WebElement CartProductSection;
    @FindBy(xpath = "//nav[@label='Site Navigation']/ul/li[12]/a[@class='cart-link']/span")
    WebElement CartItemCount;
    @FindBy(xpath = "//input[@value='payment.created DESC']")
    WebElement datePurchasedDesc;
    @FindBy(xpath = "//input[@value='payment.created ASC']")
    WebElement datePurchasedAsc;
    @FindBy(xpath = "//input[@value='invoice_no DESC']")
    WebElement invoiceNoDesc;
    @FindBy(xpath = "//input[@value='invoice_no ASC']")
    WebElement invoiceNoAsc;
    @FindBy(xpath = "//input[@value='products DESC']")
    WebElement productDesc;
    @FindBy(xpath = "//input[@value='products ASC']")
    WebElement productAsc;
    @FindBy(xpath = "//input[@value='total DESC']")
    WebElement purchasePriceDesc;
    @FindBy(xpath = "//input[@value='total ASC']")
    WebElement purchasePriceAsc;
    @FindBy(xpath = "//*[text()='View']")
    List<WebElement> listOfPurchases;
    @FindBy(xpath = "//div[@class='empty-cart-div']/h3")
    WebElement CartIsEmptyText;

    public void clickBuyOnlineButton() {
        logger.info("Clicking on Buy online button on job posting card");
        clickOnElement(BuyOnlineBtn);
    }

    public void clickCheckoutButton() {
        logger.info("Clicking on Checkout button on cart page");
        clickOnElement(CheckoutBtn);
    }

    public void fillInTownCity() {
        logger.info("Fill in town/city field on cart page");
        TownCityField.sendKeys(DataHelper.getTownCity());
    }

    public void clickSaveCardCheckbox() {
        logger.info("Click save this card checkbox");
        clickOnElement(SaveThisCardCheckBox);
    }

    public void clickRetryPaymentButton() {
        logger.info("Click retry payment button");
        clickOnElementUsingText(DataHelper.getRetryPaymentBtn());
    }

    public void clickViewButtonToSeeInvoice() {
        logger.info("Click view button to see invoice");
        clickOnElement(ViewInvoiceBtn);
    }

    public void clickPayNowButton() {
        logger.info("Click Pay now button");
        clickOnElementWithJS(PayNowBtn);
    }

    public void clickDeletedSavedCardIcon() {
        logger.info("clicking delete saved card icon");
        clickOnElement(DeleteSavedCardIcon);
        waitUntilElementToBeClickable(DeleteCardConfirmButton, 15);
    }

    public void clickDeleteCardConfirmButton() {
        logger.info("clicking delete saved card icon");
        clickOnElement(DeleteCardConfirmButton);
        waitUntilElementToBeDisappear(DeleteSavedCardIcon, 20);
    }

    public void fillInCardNumber(String cardType) {
        logger.info("Switching into iframe to fill in card number");
        getThreadDriver().switchTo().frame(CardNumberIframe);
        waitUntilElementToBeClickable(CardNumberTextBox, 5);

        logger.info("Filling in card number");
        if (cardType.equals("valid")) {
            CardNumberTextBox.sendKeys(DataHelper.getValidCardNumber());
        } else {
            CardNumberTextBox.sendKeys(DataHelper.getInvalidCardNumber());
        }

        logger.info("Switching out of iframe");
        getThreadDriver().switchTo().defaultContent();
    }

    public void fillInCvv(String cvvType) {
        logger.info("Switching into iframe to fill in cvv");
        getThreadDriver().switchTo().frame(CvvIframe);
        waitUntilElementToBeClickable(CvvTextBox, 5);

        logger.info("Filling in cvv");
        if (cvvType.equals("valid")) {
            CvvTextBox.sendKeys(DataHelper.getValidCvv());
        } else {
            CvvTextBox.sendKeys(DataHelper.getInvalidCvv());
        }

        logger.info("Switching out of iframe");
        getThreadDriver().switchTo().defaultContent();
    }

    public void fillInExpiryDate() {
        logger.info("Switching into iframe to fill in expiry date");
        getThreadDriver().switchTo().frame(ExpiryDateIframe);
        waitUntilElementToBeClickable(ExpiryDateTextBox, 5);

        logger.info("Filling in expiry date");
        ExpiryDateTextBox.sendKeys(DataHelper.getExpiryDate());

        logger.info("Switching out of iframe");
        getThreadDriver().switchTo().defaultContent();
    }

    public void mouseHoverProductsMenu() {
        waitUntilElementToBeClickable(ProductsNavigationMenu, 30);
        mouseHoverToElement(ProductsNavigationMenu);
    }

    public void shouldSeeShoppingCartImage() {
        logger.info("checking for element shopping cart");
        waitUntilElementToBeClickable(BuyOnlineLink, 30);
        Assert.assertTrue(verifyThatElementIsDisplayed(ShoppingCartLink),"[---> " + ShoppingCartLink + " is not visible <---]");
    }

    public void clickOnShoppingCartImage() {
        logger.info("Clicking on Shopping Cart Image");
        clickOnElement(ShoppingCartLink);
    }

    public void checkTheCartPage(String text) {
        try {
            Assert.assertEquals(getTextFromElement(CartIsEmptyText), text);
        } catch (Exception e) {
            for (WebElement link : RemoveLinkList) {
                logger.info("Removing the Existing products on Your cart Page");
                clickOnElement(link);
            }
            waitUntilElementToBeClickable(CartIsEmptyText, 5);
        }
    }


    public void clickOnRemoveLink() {
        for (WebElement link : RemoveLinkList) {
            logger.info("Clicking on Remove link");
            clickOnElement(link);
            break;
        }
    }

    public void CheckTheCartItemsCount(int cartItemsCount) {
        logger.info("Check the cart count");
        synchronized (this) {
            waitUntilTextToBePresent(CartItemCount, String.valueOf(cartItemsCount));
            Assert.assertEquals(Integer.parseInt(getTextFromElement(CartItemCount)), cartItemsCount);
        }
    }

    public void clickOnDatePurchasedDesc() {
        logger.info("Clicking on desc arrow on date purchased ");
        clickOnElement(datePurchasedDesc);
        webDriverWaitContainsUrl(WebURLHelper.getProductHistoryUrl());
    }

    public void clickOnDatePurchasedAsc() {
        logger.info("Clicking on desc arrow on date purchased ");
        clickOnElement(datePurchasedAsc);
        webDriverWaitContainsUrl(WebURLHelper.getProductHistoryUrl());
    }

    public List<String> getListOfDates() {
        sortedList = getDataList(dates);
        logger.info("Getting list of dates ");
        return sortedList;
    }

    public List<String> descendingOrderDatesPurchased() {
        sortedList = getListByDescOrder(dates);
        logger.info("Sorting date name by desc order" + sortedList);
        return getSortedDatesDesc(sortedList);
    }

    public List<String> ascendingOrderDatesPurchased() {
        sortedList = getListByAscOrder(dates);
        logger.info("Sorting date name by asc order" + sortedList);
        return getSortedDatesAsc(sortedList);
    }

    public void clickOnInvoiceNoDesc() {
        logger.info("Clicking on desc arrow on Invoice No");
        clickOnElement(invoiceNoDesc);
        webDriverWaitContainsUrl(WebURLHelper.getProductHistoryUrl());
    }

    public void clickOnInvoiceNoAsc() {
        logger.info("Clicking on desc arrow oon Invoice No ");
        clickOnElement(invoiceNoAsc);
        webDriverWaitContainsUrl(WebURLHelper.getProductHistoryUrl());
    }

    public List<Double> getListOfInvoiceNo() {
        sortedInvoiceNoList = getNumberDataList(invoiceNo);
        logger.info("Getting list of Invoice No Actual" + sortedInvoiceNoList);
        return sortedInvoiceNoList;
    }

    public List<Double> descendingOrderInvoiceNo() {

        sortedInvoiceNoList = getNumberListByDescOrder(invoiceNo);
        logger.info("Sorting Invoice No by desc order" + sortedInvoiceNoList);
        return sortedInvoiceNoList;
    }

    public List<Double> ascendingOrderInvoiceNo() {
        sortedInvoiceNoList = getNumberListByAscOrder(invoiceNo);
        logger.info("Sorting Invoice by asc order" + sortedInvoiceNoList);
        return sortedInvoiceNoList;
    }

    public void clickProductDesc() {
        logger.info("Clicking on desc arrow on Product");
        clickOnElement(productDesc);
        webDriverWaitContainsUrl(WebURLHelper.getProductHistoryUrl());
    }

    public void clickProductAsc() {
        logger.info("Clicking on asc arrow on Product");
        clickOnElement(productAsc);
        webDriverWaitContainsUrl(WebURLHelper.getProductHistoryUrl());
    }

    public List<String> getListOfProducts() {
        sortedList = getDataList(products);
        logger.info("Getting list of Invoice No Actual" + sortedList);
        return sortedList;
    }

    public List<String> descendingOrderOfProdutcts() {
        sortedList = getListByDescOrder(products);
        logger.info("Sorting Invoice No by desc order" + sortedList);
        return sortedList;
    }

    public List<String> ascendingOrderOfProdutcts() {
        sortedList = getListByAscOrder(products);
        logger.info("Sorting Invoice by asc order" + sortedList);
        return sortedList;
    }

    public void clickPurchasePriceDesc() {
        logger.info("Clicking on desc arrow on Purchase price");
        clickOnElement(purchasePriceDesc);
        webDriverWaitContainsUrl(WebURLHelper.getProductHistoryUrl());
    }

    public void clickPurchasePriceAsc() {
        logger.info("Clicking on asc arrow on Purchase price");
        clickOnElement(purchasePriceAsc);
        webDriverWaitContainsUrl(WebURLHelper.getProductHistoryUrl());
    }

    public List<Double> getListOfPurchasePrice() {
        sortedPurchasePriceList = getPriceDataList(purchasePrice);
        logger.info("Getting list of Purchase Price Actual" + sortedPurchasePriceList);
        return sortedPurchasePriceList;
    }

    public List<Double> descendingOrderOfPurchasePrice() {
        sortedPurchasePriceList = getPriceListByDescOrder(purchasePrice);
        logger.info("Sorting Purchase Price by desc order" + sortedPurchasePriceList);
        return sortedPurchasePriceList;
    }

    public List<Double> ascendingOrderOfPurchasePrice() {
        sortedPurchasePriceList = getPriceListByAscOrder(purchasePrice);
        logger.info("Sorting Purchase Price Asc order" + sortedPurchasePriceList);
        return sortedPurchasePriceList;
    }

    public List<Double> getPriceListByDescOrder(List<WebElement> elements) {
        return getPriceDataList(elements).stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

    public List<Double> getPriceListByAscOrder(List<WebElement> elements) {
        return getPriceDataList(elements).stream().sorted().collect(Collectors.toList());
    }

    public List<Double> getPriceDataList(List<WebElement> elements) {
        return elements.stream().map(s -> Double.parseDouble(s.getText().replace("$", ""))).collect(Collectors.toList());
    }

    public int getPurchaseCount() {
        return listOfPurchases.size();
    }

    public boolean checkIfCardIsSaved() {
        getThreadDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        boolean isCardSaved = getThreadDriver().findElements(By.id("delete-saved-card-btn")).size() > 0;
        getThreadDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return isCardSaved;
    }
}