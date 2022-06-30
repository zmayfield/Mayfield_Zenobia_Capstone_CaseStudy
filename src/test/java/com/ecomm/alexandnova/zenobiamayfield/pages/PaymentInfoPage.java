package com.ecomm.alexandnova.zenobiamayfield.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentInfoPage {
    WebDriver driver;

    By cardNumber = By.id("number");
    By errorMessage = By.xpath("/html/body/div/div/div/main/div[1]/div/form/div[1]/div[2]/div[2]/div/p");
    By payNowButton = By.id("continue_button");
    By nameOnCard = By.id("name");
    By expirationDate = By.id("expiry");
    By securityCode = By.id("verification_value");
    By visaCard = By.xpath("//div/ul/li[@class='payment-icon payment-icon--visa']");
    By masterCard = By.xpath("//div/ul/li[@class='payment-icon payment-icon--master']");
    By discoverCard = By.xpath("//div/ul/li[@class='payment-icon payment-icon--discover']");
    By shopPay = By.xpath("//div/label/img[@class='offsite-payment-gateway-logo']");
//    By payPalDisplay = By.xpath("")

    By creditCardNumberFrame = By.xpath("//iframe[contains(@id,'card-fields-number-')]");
    //By creditCardNumberFrame = By.xpath("//iframe[contains(@id,'card-fields-verification_-')]");
    By cardholderNameFrame = By.xpath("*//iframe[contains(@id,'card-fields-name')]");
    By cardExpiryFrame = By.xpath("*//iframe[contains(@id,'card-fields-expiry')]");
    By securityCodeFrame = By.xpath("*//iframe[contains(@id,'card-fields-verification_value')]");



    public PaymentInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getVisaCardField()
    {
        return driver.findElement(visaCard).getAttribute("data-payment-icon");
    }
    public String getMasterCardField()
    {
        return driver.findElement(masterCard).getAttribute("data-payment-icon");
    }
    public String getDiscoverCardField()
    {
        return driver.findElement(discoverCard).getAttribute("data-payment-icon");
    }
    public String getShopPayField()
    {
        return driver.findElement(shopPay).getAttribute("alt");
    }

    public void switchToCardNumberFrame()
    {
        WebElement iframe = driver.findElement(creditCardNumberFrame);
        driver.switchTo().frame(iframe);
    }
    public void switchToCardHolderNameFrame()
    {
        WebElement iframe = driver.findElement(cardholderNameFrame);
        driver.switchTo().frame(iframe);
    }
    public void switchToExpiryDateFrame()
    {
        WebElement iframe = driver.findElement(cardExpiryFrame);
        driver.switchTo().frame(iframe);
    }
    public void switchToSecurityCodeFrame()
    {
        WebElement iframe = driver.findElement(securityCodeFrame);
        driver.switchTo().frame(iframe);
    }

    public void setCreditCardNumber(String number)
    {
        driver.findElement(cardNumber).sendKeys(number);
    }
    public void setNameOnCreditCard(String arg1)
    {
        driver.findElement(nameOnCard).sendKeys(arg1);
    }

    public void setExpirationDate(String date)
    {
        driver.findElement(expirationDate).sendKeys(date);
    }
    public void setSecurityCode(String code)
    {
        driver.findElement(securityCode).sendKeys(code);
    }
    public void clickPayNow(){ driver.findElement(payNowButton).click();}
    public String getErrorMessage(){return driver.findElement(errorMessage).getText();}
    public void payNowButtonDisplayed(){driver.findElement(payNowButton).isDisplayed();}

}

