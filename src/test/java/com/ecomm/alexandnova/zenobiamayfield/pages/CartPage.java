package com.ecomm.alexandnova.zenobiamayfield.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CartPage {

    WebDriver driver;

    By cartInProduct = By.linkText("Skipper Mesh First Walker Sneakers Shoes");
    By quantityField= By.id("updates_19513847218233");
    By cartUpdateButton = By.xpath("//*[@id=\"shopify-section-cart\"]/section/form/div/div/div[2]/input");
    By totalPrice = By.cssSelector("#shopify-section-cart > section > form > table > tbody > tr > td.total.last > span > span");
    By removeItem = By.xpath("//*[@id=\"shopify-section-cart\"]/section/form/table/tbody/tr/td[1]/a[2]");
    By removalMessage = By.xpath("//*[@id=\"shopify-section-cart\"]/section/p");
    By myAccountLink = By.linkText("My account");
    By signOutLink = By.id("customer_logout_link");
    By checkOutButtom = By.cssSelector("#shopify-section-cart > section > form > div > div > div.cart-buttons-container > button");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void viewCartToVerifyItem()
    {
        driver.findElement(cartInProduct).isDisplayed();
    }
    public String getCartItemValidationMessage()
    {
        return driver.findElement(cartInProduct).getText();
    }
    public void increaseQuantity(String arg1)
    {
        driver.findElement(quantityField).sendKeys(arg1);
    }
    public void updateCart()
    {
        // driver.findElement(quantityField).sendKeys(Keys.ENTER);
        driver.findElement(cartUpdateButton).click();
    }

    public String getTotalPrice()
    {
        return driver.findElement(totalPrice).getAttribute("data-vitals-cc-usd");
    }
    public String getQuantityOfItemInCart()
    {
        return driver.findElement(quantityField).getAttribute("value");
    }
    public void removeItemfromCart()
    {
        driver.findElement(removeItem).click();
    }
    public String getItemRemovalMessage()
    {
        return driver.findElement(removalMessage).getText();
    }
    public void SignOut()
    {
        WebElement MyAccount = driver.findElement(myAccountLink);
        WebElement SignOut = driver.findElement(signOutLink);
        Actions actions = new Actions(driver);
        actions.moveToElement((MyAccount)).perform();
        actions.moveToElement((SignOut)).click().perform();
    }
    public void clickCheckoutButton()
    {
        driver.findElement(checkOutButtom).click();
    }

}
