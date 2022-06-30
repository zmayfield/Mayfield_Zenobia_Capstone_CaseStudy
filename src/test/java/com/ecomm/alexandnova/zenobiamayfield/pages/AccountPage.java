package com.ecomm.alexandnova.zenobiamayfield.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    WebDriver driver;

    By clearanceLink = By.id("navigation-clearance");
    By faceCoveringLink = By.cssSelector("#navigation-face-covering");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickClearanceLink()
    {
        driver.findElement(clearanceLink).click();
    }

    public void clickFaceCoveringLink()
    {
        driver.findElement(faceCoveringLink).click();
    }
    }













