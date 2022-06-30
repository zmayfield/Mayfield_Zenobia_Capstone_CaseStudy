package com.ecomm.alexandnova.zenobiamayfield.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FaceCoveringPage {
    WebDriver driver;

    By selectProduct = By.linkText("Organic Cotton Reusable Face Mask");
// List<WebElement> webElementList = driver.findElements(By.linkText("Printed Pattern Reusable Face Mask [Set of 2]"));



    public FaceCoveringPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickItemToSelect() {

        driver.findElement(selectProduct).click();
    }
}
