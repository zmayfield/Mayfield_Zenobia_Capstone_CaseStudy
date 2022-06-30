package com.ecomm.alexandnova.zenobiamayfield.testcases;


import com.ecomm.alexandnova.zenobiamayfield.pages.LoginPage;
import com.ecomm.alexandnova.zenobiamayfield.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginNegativeTest extends BaseTest {


    LoginPage loginPage;
    RegistrationPage registrationPage;

    //*************************************************************************************************************
    // Test Case# 7: This test case is to verify that registered user shouldn't be able to login using invalid credentials
    //*************************************************************************************************************

    @Test(priority = 7)
    public void tc0007_login_with_invalid_credentials_test() throws InterruptedException {
        driver.get("https://www.alexandnova.com/account/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        loginPage = new LoginPage(driver);
        loginPage.setInvalidLoginEmail("Testing@gmail.com");
        loginPage.setInvalidLoginPassword("pass");
        loginPage.clickLoginButton();
        Thread.sleep(300);
        registrationPage= new RegistrationPage(driver);
        String expectedMessage = "Sorry! Please try that again.";
        String actualMessage = registrationPage.getInvalidEmailErrorMessage();

        Assert.assertEquals(expectedMessage, actualMessage);

    }

}