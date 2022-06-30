package com.ecomm.alexandnova.zenobiamayfield.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Alex and Nova.Zenobia Mayfield
//This page is the main page of Alex and Nova
public class HomePage {

// pom model

    WebDriver driver;

    By accountButton = By.id("customer_login_link");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAccountLink ()
    {
        driver.findElement(accountButton).click();
    }



}
