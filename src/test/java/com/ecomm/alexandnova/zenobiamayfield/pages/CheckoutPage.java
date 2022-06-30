package com.ecomm.alexandnova.zenobiamayfield.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    //By discountCode = By.xpath("//*[@id=\"order-summary\"]/div/div[2]/div/div/form/div/span/span/span");
    By discountCodeField = By.id("checkout_reduction_code");
    //By.xpath(//*[@id="checkout_reduction_code"]);
    By applyButton = By.id("checkout_submit");
    By firstName = By.id("checkout_shipping_address_first_name");
    By lastName = By.id("checkout_shipping_address_last_name");
    By checkoutEmail = By.id("checkout_email");
    By address = By.id("checkout_shipping_address_address1");
    By city = By.id("checkout_shipping_address_city");
    By zipCode = By.id("checkout_shipping_address_zip");
    By continueToPaymentButton = By.id("continue_button");



    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setDiscountCode(String arg1)
    {
        driver.findElement(discountCodeField).sendKeys(arg1);
    }
    public void clickApplyButton()
    {
        driver.findElement(applyButton).click();
    }
    public String getDiscountCodeEntered()
    {
        return driver.findElement(discountCodeField).getAttribute("value");
    }
    public void setCheckoutEmail(String Email)
    {
        driver.findElement(checkoutEmail).sendKeys(Email);
    }
    public void setFirstName(String firstname)
    {
        driver.findElement(firstName).sendKeys(firstname);
    }
    public void setLastName(String lastname)
    {
        driver.findElement(lastName).sendKeys(lastname);
    }
    public void setStreetAddress(String address1)
    {
        driver.findElement(address).sendKeys(address1);
    }
    public void setAddressCity(String City)
    {
        driver.findElement(city).sendKeys(City);
    }
    public void setZipCode(String zip)
    {
        driver.findElement(zipCode).sendKeys(zip);
    }
    public void clickContinueToPaymentButton()
    {
        driver.findElement(continueToPaymentButton).click();
    }





}
