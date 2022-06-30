package com.ecomm.alexandnova.zenobiamayfield.testcases;

import com.ecomm.alexandnova.zenobiamayfield.pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PaymentTest extends BaseTest {


    FaceCoveringPage faceCoveringPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    ShippingPage shippingPage;
    PaymentInfoPage paymentPage;


    //*************************************************************************************************************
    // Test Case# 16: This test case is to verify that user is able to apply discount code in the checkout page
    //*************************************************************************************************************
    @Test(priority = 16)
    public void tc0016_verify_discount_code_at_checkout_test() throws InterruptedException {
        driver.get("https://www.alexandnova.com/collections/face-covering");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        faceCoveringPage = new FaceCoveringPage(driver);
        faceCoveringPage.clickItemToSelect();
        productPage = new ProductPage(driver);
        productPage.selectFaceCoveringSize();
        productPage.selectFaceCoveringColor();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,340)");
        productPage.clearQuantityField();
        productPage.setFaceCoveringQuantity();
        productPage.addFaceCoveringProductToCart();
        Thread.sleep(300);
        productPage.clickOnCartLinkToCheckout();
        cartPage = new CartPage(driver);
        js.executeScript("window.scrollBy(0,240)");
        cartPage.clickCheckoutButton();
        Thread.sleep(500);
        checkoutPage = new CheckoutPage(driver);
        String expectedDiscountCode = "SUMMER10";
        checkoutPage.setDiscountCode(expectedDiscountCode);
        checkoutPage.clickApplyButton();
        Thread.sleep(500);
        String actualDiscountCode = checkoutPage.getDiscountCodeEntered();
        System.out.println(actualDiscountCode);
        Assert.assertEquals(actualDiscountCode, expectedDiscountCode);

    }
    //*************************************************************************************************************
    // Test Case# 17: This test case is to verify that user is able to see different payment options in at checkout
    //*************************************************************************************************************

    @Test(priority = 17, enabled = true)
    public void tc0017_payment_method_check() throws InterruptedException {

        checkoutPage = new CheckoutPage(driver);
        shippingPage = new ShippingPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,360)");
        checkoutPage.setCheckoutEmail("IamTesting@gmail.com");
        Thread.sleep(500);
        checkoutPage.setFirstName("John");
        checkoutPage.setLastName("Fink");

        checkoutPage.setAddressCity("Denver");
        checkoutPage.setStreetAddress("00 Denver St.");
        checkoutPage.setZipCode("80135");
        Thread.sleep(300);
        checkoutPage.clickContinueToPaymentButton();
        Thread.sleep(300);
        shippingPage.clickContinuePaymentButton();
        paymentPage = new PaymentInfoPage(driver);
        String actualVisaField = paymentPage.getVisaCardField();
        String expectedVisaField = "visa";
        System.out.println(actualVisaField);
        Assert.assertEquals(expectedVisaField, actualVisaField);

        String actualMasterField = paymentPage.getMasterCardField();
        String expectedMasterField = "master";
        System.out.println(actualMasterField);
        Assert.assertEquals(expectedMasterField, actualMasterField);

        String actualDiscoverField = paymentPage.getDiscoverCardField();
        String expectedDiscoverField = "discover";
        System.out.println(actualDiscoverField);
        Assert.assertEquals(expectedDiscoverField, actualDiscoverField);

        String actualShopPayField = paymentPage.getShopPayField();
        String expectedShopPayField = "Shop Pay";
        System.out.println(actualShopPayField);
        Assert.assertEquals(expectedShopPayField, actualShopPayField);


    }
    //*************************************************************************************************************
    // Test Case# 18: This test case is to verify that user should get an error message if any of the required fields
    // in payment page are left blank
    //*************************************************************************************************************

    @Test(priority = 18, enabled = true)
    public void tc0018_checkout_mandatory_fields_validation() {

        paymentPage = new PaymentInfoPage(driver);
        paymentPage.switchToCardNumberFrame();
        paymentPage.setCreditCardNumber("4212");
        paymentPage.setCreditCardNumber("1234");
        paymentPage.setCreditCardNumber("5678");
        paymentPage.setCreditCardNumber("0910");
        driver.switchTo().parentFrame();
        paymentPage.switchToCardHolderNameFrame();
        paymentPage.setNameOnCreditCard("John Fink");
        driver.switchTo().parentFrame();
        paymentPage.switchToExpiryDateFrame();
        paymentPage.setExpirationDate("06");
        paymentPage.setExpirationDate("28");
        driver.switchTo().parentFrame();
        paymentPage.switchToSecurityCodeFrame();
        paymentPage.setSecurityCode(" ");
        driver.switchTo().parentFrame();
        paymentPage.clickPayNow();
        String actualErrorMessage = paymentPage.getErrorMessage();
        String expectedErrorMessage = "Your payment details couldn't be verified. Check your card details and try again.";
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

    }
    //*************************************************************************************************************
    // Test Case# 19: This test case is to verify that user should be able to check out the product successfully
    //*************************************************************************************************************

    @Test(priority = 19,enabled = true)
    public void tc0019_product_checkout_successfully(){
        paymentPage = new PaymentInfoPage(driver);
        paymentPage.switchToCardNumberFrame();
        paymentPage.setCreditCardNumber("4212");
        paymentPage.setCreditCardNumber("1234");
        paymentPage.setCreditCardNumber("5678");
        paymentPage.setCreditCardNumber("0910");
        driver.switchTo().parentFrame();
        paymentPage.switchToCardHolderNameFrame();
        paymentPage.setNameOnCreditCard("John Fink");
        driver.switchTo().parentFrame();
        paymentPage.switchToExpiryDateFrame();
        paymentPage.setExpirationDate("06");
        paymentPage.setExpirationDate("28");
        driver.switchTo().parentFrame();
        paymentPage.switchToSecurityCodeFrame();
        paymentPage.setSecurityCode("123");
        driver.switchTo().parentFrame();
        paymentPage.clickPayNow();
        String actualErrorMessage = paymentPage.getErrorMessage();
        String expectedErrorMessage = "Your payment details couldn't be verified. Check your card details and try again.";
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        paymentPage.payNowButtonDisplayed();
    }
}