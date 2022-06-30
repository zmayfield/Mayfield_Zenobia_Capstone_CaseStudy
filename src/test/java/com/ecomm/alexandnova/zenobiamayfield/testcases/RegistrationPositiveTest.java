package com.ecomm.alexandnova.zenobiamayfield.testcases;

import com.ecomm.alexandnova.zenobiamayfield.pages.HomePage;
import com.ecomm.alexandnova.zenobiamayfield.pages.LoginPage;
import com.ecomm.alexandnova.zenobiamayfield.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class RegistrationPositiveTest extends BaseTest{


    HomePage homePage;
    RegistrationPage registrationPage;
    LoginPage loginPage;

    @BeforeClass
    public void launch_application() {
        driver.get("https://www.alexandnova.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

    }

    //*************************************************************************************************************
    // Test Case# 1 This test case is to verify the User can click on the Account Link on the home page and taken to the
    // registration page
    //*************************************************************************************************************
    @Test(priority = 1)
    public void tc0001_new_user_registration_page_test() throws IOException {

        homePage = new HomePage(driver);
        homePage.clickAccountLink();
        registrationPage = new RegistrationPage(driver);
        registrationPage.clickRegisterButton();

        String actualPageTitle = registrationPage.checkSignUpPageTitle();
        String expectedPageTitle = "Sign up";
        Assert.assertEquals(actualPageTitle ,expectedPageTitle);

    }

    //*************************************************************************************************************
    // Test Case# 2: This test case is to verify that new User can create an account by clicking on the Register button
    //*************************************************************************************************************

    @Test(priority = 2,enabled = true)
    public void tc0002_new_user_registration_test() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        homePage.clickAccountLink();
        registrationPage = new RegistrationPage(driver);
        registrationPage.clickRegisterButton();
        registrationPage.setFirstName("John");
        registrationPage.setLastName("Fink");
        registrationPage.setEmail("IamTesting09@gmail.com");
        registrationPage.setPassword("P@ssword");
        registrationPage.createNewUser();
        Thread.sleep(200);
        loginPage =new LoginPage(driver);

        String actualPageTitle = loginPage.verifyPageTitle();
        String expectedPageTitle = "Log in";

        Assert.assertEquals(actualPageTitle ,expectedPageTitle);
        System.out.println(actualPageTitle);


    }
    }

