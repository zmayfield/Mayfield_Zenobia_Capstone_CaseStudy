package com.ecomm.alexandnova.zenobiamayfield.testcases;

import com.ecomm.alexandnova.zenobiamayfield.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class AddToCartTest extends BaseTest{

    LoginPage loginPage;
    AccountPage accountPage;
    ProductPage productPage;
    ClearencePage clearancePage;
    CartPage cartPage;


    @BeforeClass
    public void registered_user_login() throws InterruptedException {

        driver.get("https://www.alexandnova.com/account/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        loginPage = new LoginPage(driver);
        loginPage.setLoginEmail("Test@gmail.com");
        loginPage.setLoginPassword("P@ssword");
        loginPage.clickLoginButton();
        Thread.sleep(2000);

    }
    //*************************************************************************************************************
    // Test Case# 10: This test case is to verify that product price is displaying in the product page
    //*************************************************************************************************************

    @Test(priority = 10)
    public void tc0010_verify_price_is_displayed_test(){
        accountPage = new AccountPage(driver);
        accountPage.clickClearanceLink();
        clearancePage = new ClearencePage(driver);
        clearancePage.clickOnProduct();
        productPage = new ProductPage(driver);
        String itemDescription = productPage.getItemDescription();
        System.out.println("Item selected: " +itemDescription);

        String actualPrice = productPage.getItemPrice();
        String expectedPrice = "$29.95 USD";
        System.out.println("Actual total price for selected item displaying in cart is: "+actualPrice);
        Assert.assertEquals(expectedPrice, actualPrice);

    }
    //*************************************************************************************************************
    // Test Case# 11: This test case is to verify that user is able to add the selected product in to cart
    //*************************************************************************************************************

    @Test(priority = 11)
    public void tc0011_add_product_to_cart_test() throws InterruptedException {
        productPage = new ProductPage(driver);
        productPage.selectProductSize();
        productPage.selectProductColor();
        productPage.addProductToCart();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,220)");
        String actualSuccessMessage = productPage.getAddedToCartSuccessMessage();
        System.out.println("Success message confirming item was added to cart : "+ actualSuccessMessage);
        String expectedSuccessMessage = "Skipper Mesh First Walker Sneakers Shoes - US 6 / Grey has been successfully added to your cart. Feel free to continue shopping or check out.";
        Assert.assertEquals(expectedSuccessMessage, actualSuccessMessage);

    }
    //*************************************************************************************************************
    // Test Case# 12: This test case is to verify that user is able to see the selected product in to cart after
    // refreshing the browser
    //*************************************************************************************************************

    @Test(priority = 12,enabled = true)
    public void tc0012_refresh_browser_test() throws IOException {
        productPage = new ProductPage(driver);
        productPage.clickOnCartLink();
        cartPage = new CartPage(driver);
        String quantityBeforeRefresh = cartPage.getQuantityOfItemInCart();
        driver.navigate().refresh();
        cartPage.viewCartToVerifyItem();
        String quantityAfterRefresh = cartPage.getQuantityOfItemInCart();

        Assert.assertEquals(quantityBeforeRefresh, quantityAfterRefresh);
        String cartItemDescription = cartPage.getCartItemValidationMessage();
        System.out.println("The item added in the cart is: "+cartItemDescription );

    }

    //*************************************************************************************************************
    // Test Case# 13: This test case is to verify that user is able to change the quantity of the product in the cart
    //*************************************************************************************************************

    @Test(priority = 13, enabled = true)
    public void tc0013_increase_quantity_test() throws InterruptedException {
        cartPage = new CartPage(driver);
        WebElement quantityField = driver.findElement(By.id("updates_19513847218233"));
        quantityField.clear();
        String expectedQuantity = "2";
        cartPage.increaseQuantity(expectedQuantity);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,120)");
        cartPage.updateCart();
        Thread.sleep(3000);
        String actualQuantity = cartPage.getQuantityOfItemInCart();
        System.out.println("The new quantity showing in the cart after increasing: "+ actualQuantity);

        Assert.assertEquals(actualQuantity, expectedQuantity);

    }
    //*************************************************************************************************************
    // Test Case# 14: This test case is to verify that the total quantity selected by the user matches with total price
    //*************************************************************************************************************
    @Test(priority = 14, enabled = true)
    public void tc0014_verify_quantity_matches_total_Price_inCart() throws IOException {

        cartPage = new CartPage(driver);
        String expectedTotalQuantity = "2";
        String actualTotalQuantity = cartPage.getQuantityOfItemInCart();
        System.out.println("Actual quantity in the cart is: "+ actualTotalQuantity);
        Assert.assertEquals(actualTotalQuantity, expectedTotalQuantity);

        String actualTotalPrice = cartPage.getTotalPrice();
        String expectedTotalPrice = "$59.90 USD";
        System.out.println("Actual Total price displaying in cart is: "+actualTotalPrice);
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);

    }
    //*************************************************************************************************************
    // Test Case# 15: This test case is to verify that user is able to remove the product from the cart
    //*************************************************************************************************************
    @Test(priority = 15, enabled = true)
    public void tc0015_verify_cart_after_removing_items_test(){

        cartPage = new CartPage(driver);
        cartPage.removeItemfromCart();
        String messageAfterRemovingItem = cartPage.getItemRemovalMessage();
        String expectedMessage = "You don't have any items in your cart yet. Continue shopping .";
        Assert.assertEquals(expectedMessage, messageAfterRemovingItem);
        System.out.println("Actual message displaying after removing item from cart: "+ messageAfterRemovingItem);
        cartPage.SignOut();
    }
}


