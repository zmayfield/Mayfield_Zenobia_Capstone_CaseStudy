package com.ecomm.alexandnova.zenobiamayfield.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage {

    WebDriver driver;

    By continueToPaymentButton = By.id("continue_button");

    public ShippingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickContinuePaymentButton()
    {
        driver.findElement(continueToPaymentButton).click();
    }
}

