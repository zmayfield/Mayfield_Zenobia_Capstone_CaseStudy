package com.ecomm.alexandnova.zenobiamayfield.testcases;

import com.ecomm.alexandnova.zenobiamayfield.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class LoginPositiveTest extends BaseTest {


    LoginPage loginPage;


    //*************************************************************************************************************
    // Test Case# 6: This test case is to verify that registered user should be able to login using valid credentials
    //*************************************************************************************************************

    @Test(priority = 6)
    public void tc0006_login_with_valid_credentials_test() throws InterruptedException, IOException {

        driver.get("https://www.alexandnova.com/account/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        loginPage = new LoginPage(driver);
        loginPage.setLoginEmail("IamTesting@gmail.com");
        loginPage.setLoginPassword("P@ssword");
        loginPage.clickLoginButton();
        Thread.sleep(300);

        String expectedMessage = "Welcome, John";
        String actualMessage = loginPage.getWelcomeNewUserMessage();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

 }
