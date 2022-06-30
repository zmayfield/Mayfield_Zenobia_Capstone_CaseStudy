package com.ecomm.alexandnova.zenobiamayfield.testcases;

import com.ecomm.alexandnova.zenobiamayfield.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationNegativeTest extends BaseTest{


    RegistrationPage registrationPage;


    //*************************************************************************************************************
    // Test Case# 3: This test case is to verify that the new user shouldn't be able to register using invalid email ID
    //*************************************************************************************************************

    @Test(priority = 3)
    public void tc0003_register_with_invalid_email_test(){
        driver.get("https://www.alexandnova.com/account/register");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        registrationPage = new RegistrationPage(driver);
        registrationPage.setFirstName("John");
        registrationPage.setLastName("Fink");
        registrationPage.setInvalidEmail("Testing@gmailcom");
        registrationPage.setPassword("P@ssword");
        registrationPage.createNewUser();

        String expectedMessage = "Sorry! Please try that again.";
        String actualMessage = registrationPage.getInvalidEmailErrorMessage();

        Assert.assertEquals(expectedMessage, actualMessage);

    }

    //*************************************************************************************************************
    // Test Case# 4: This test case is to verify that new user shouldn't be able to register if any of the mandatory fields
    // are left blank in registration page
    //*************************************************************************************************************

    @Test(priority = 4)
    public void tc0004_registration_with_mandatory_field_blank_test(){
        registrationPage = new RegistrationPage(driver);
        registrationPage.clickRegisterButton();
        registrationPage.setFirstNameBlank("");
        registrationPage.setLastName("Fink");
        registrationPage.setEmail("IamTesting@gmail.com");
        registrationPage.setPassword("P@ssword");
        registrationPage.createNewUser();

        String expectedMessage = "Sorry! Please try that again.";
        String actualMessage = registrationPage.getInvalidEmailErrorMessage();

        Assert.assertEquals(expectedMessage, actualMessage);

    }

    //*************************************************************************************************************
    // Test Case# 5: This test case is to verify that the new user shouldn't be able to register using invalid password
    //*************************************************************************************************************

    @Test(priority = 5)
    public void tc0005_register_with_invalid_password_test() throws InterruptedException {
        registrationPage = new RegistrationPage(driver);
        registrationPage.clickRegisterButton();
        Thread.sleep(400);
        registrationPage.setFirstName("John");
        registrationPage.setLastName("Fink");
        registrationPage.setEmail("IamTesting@gmail.com");
        registrationPage.setInvalidPassword("pass");
        registrationPage.createNewUser();
        Thread.sleep(300);

        String expectedMessage = "Sorry! Please try that again.";
        String actualMessage = registrationPage.getInvalidEmailErrorMessage();

        Assert.assertEquals(expectedMessage, actualMessage);

    }
}
