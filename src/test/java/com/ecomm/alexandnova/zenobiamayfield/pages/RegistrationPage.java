package com.ecomm.alexandnova.zenobiamayfield.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver driver;
    By registerButton = By.xpath("//a[contains(text(),'Register')]");
    By signUpPageTitle = By.xpath("//*[@id=\"keyboard-nav-3\"]/h1");
    By firstNameField = By.id("ispbxii_1");
    By lastNameField = By.id("ispbxii_2");
    By emailField = By.id("ispbxii_3");
    By passwordField = By.name("customer[password]");
    By newUserRegister = By.xpath("//*[@id=\"create_customer\"]/div[5]/input");
    By invalidEmailMessage = By.xpath("//*[@id=\"customer_login\"]/p");



    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegisterButton()
    {
        driver.findElement(registerButton).click();
    }

    public String checkSignUpPageTitle()
    {
        return driver.findElement(signUpPageTitle).getText();
    }

    public void setFirstName(String fName)
    {
        driver.findElement(firstNameField).sendKeys(fName);
    }
    public void setFirstNameBlank(String blank)
    {
        driver.findElement(firstNameField).sendKeys(blank);
    }
    public void setLastName(String lName)
    {
        driver.findElement(lastNameField).sendKeys(lName);
    }
    public void setEmail(String email)
    {
        driver.findElement(emailField).sendKeys(email);
    }
    public void setInvalidEmail(String wrongEmail)
    {
        driver.findElement(emailField).sendKeys(wrongEmail);
    }
    public void setPassword(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void setInvalidPassword(String wrongPass)
    {
        driver.findElement(passwordField).sendKeys(wrongPass);
    }
    public void createNewUser()
    {
        driver.findElement(newUserRegister).click();
    }
    public String getInvalidEmailErrorMessage()
    {
        return driver.findElement(invalidEmailMessage).getText();
    }
}
