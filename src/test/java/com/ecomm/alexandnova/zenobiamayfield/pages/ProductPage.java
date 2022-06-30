package com.ecomm.alexandnova.zenobiamayfield.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

     //launch the browser
    WebDriver driver;

    By skipperMeshShoes = By.xpath("//*[@id=\"shopify-section-product\"]/section/div/div[3]/div/h1");
    By skipperShoesPrice = By.xpath("//*[@id=\"shopify-section-product\"]/section/div/div[3]/div/p/span[1]");
    By productSize = By.xpath("//*[@id=\"bcpo-select-option-0\"]/div[3]/label");
    By productColor = By.xpath("//*[@id=\"bcpo-select-option-1\"]/div[3]/label");
    By addToCart = By.xpath("//*[@id=\"product_form_2325367881785\"]/div[4]/input");
    By successMessage = By.xpath("//*[@id=\"product_form_2325367881785\"]/div[5]");
    By clickCartLink = By.linkText("cart");

    By clickCartPage = By.xpath("//*[@id=\"shopify-section-header\"]/section/header/div[1]/div/div[2]/div[2]/a/span[1]");
    By faceCoveringColor =By.xpath("//*[@id=\"bcpo-select-option-1\"]/div[3]/label");
    By faceCoveringSize = By.xpath("//*[@id=\"bcpo-select-option-0\"]/div[1]/label");
    By faceCoveringQuantity = By.id("ispbxii_1");
    By addFaceCoveringToCart = By.xpath("//*[@id=\"product_form_4502868951093\"]/div[4]/input");
    By clickCartLinkForCheckout =By.xpath("//*[@id=\"product_form_4502868951093\"]/div[5]/a[1]");

    By accountLink = By.xpath("//*[@id=\"shopify-section-header\"]/section/header/div[1]/div/div[2]/div[1]/a");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getItemDescription()
    {
        return driver.findElement(skipperMeshShoes).getText();
    }
    public String getItemPrice()
    {
        return driver.findElement(skipperShoesPrice).getText();
    }
    public void selectProductSize()
    {
        driver.findElement(productSize).click();
    }
    public void selectProductColor()
    {
        driver.findElement(productColor).click();
    }
    public void addProductToCart()
    {
        driver.findElement(addToCart).click();
    }
    public String getAddedToCartSuccessMessage()
    {
        return driver.findElement(successMessage).getText();
    }
    public void clickOnCartLink()
    {
        driver.findElement(clickCartLink).click();
    }
    public void clickViewCartLink()
    {
        driver.findElement(clickCartPage).click();
    }
    public void selectFaceCoveringSize()
    {
        driver.findElement(faceCoveringSize).click();
    }

    public void selectFaceCoveringColor()
    {
        driver.findElement(faceCoveringColor).click();
    }
    public void clearQuantityField()
    {
        driver.findElement(faceCoveringQuantity).clear();
    }
    public void setFaceCoveringQuantity()
    {
        driver.findElement(faceCoveringQuantity).sendKeys("3");
    }
    public void addFaceCoveringProductToCart()
    {
        driver.findElement(addFaceCoveringToCart).click();
    }
    public void clickOnCartLinkToCheckout()
    {
        driver.findElement(clickCartLinkForCheckout).click();
    }
}

