package com.ecomm.alexandnova.zenobiamayfield.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClearencePage {

          WebDriver driver;

        By selectProduct = By.linkText("Skipper Mesh First Walker Sneakers Shoes");

        public ClearencePage(WebDriver driver) {
            this.driver = driver;
        }

        public void clickOnProduct()
        {
            driver.findElement(selectProduct).click();
        }
}
