package com.ecomm.alexandnova.zenobiamayfield.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    //Element for login page title
    By loginPageTitle = By.cssSelector("#keyboard-nav-3 > h1");
    //for email test field
    By loginEmailField = By.id("ispbxii_1");
    //for password text field
    By loginPasswordField = By.name("customer[password]");
    //for login button
    By loginButton = By.xpath("//*[@id=\"customer_login\"]/div[3]/input");
    //welcome user message
    By welcomeMessage = By.xpath("//*[@id=\"keyboard-nav-3\"]/h1");



    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setLoginEmail(String email)
    {
        driver.findElement(loginEmailField).sendKeys(email);
    }
    public void setInvalidLoginEmail(String invalidEmail)
    {
        driver.findElement(loginEmailField).sendKeys(invalidEmail);
    }
    public void setLoginPassword(String password)
    {
        driver.findElement(loginPasswordField).sendKeys(password);
    }
    public void setInvalidLoginPassword(String wrongPass)
    {
        driver.findElement(loginPasswordField).sendKeys(wrongPass);
    }
    public void clickLoginButton()
    {
        driver.findElement(loginButton).click();
    }
    public String getWelcomeNewUserMessage()
    {
        return driver.findElement(welcomeMessage).getText();
    }

    public String verifyPageTitle()
    {
        return driver.findElement(loginPageTitle).getText();
    }
}
