package com.ecomm.alexandnova.zenobiamayfield.library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;


public class BrowserSelection {

    static WebDriver driver;


    public static WebDriver StartBrowser(String browsername) {
        // ---If the browser is Firefox----
        if (browsername.equalsIgnoreCase("Firefox")) {
            // Set the path for geckodriver.exe
            System.setProperty("webdriver.firefox.marionette","src/test/resources/geckodriver.exe");
            driver = new FirefoxDriver();

        }
        //---- If the browser is Chrome--
        else if (browsername.equalsIgnoreCase("Chrome")) {
            // Set the path for chromedriver.exe
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();

        }
        // ----If the browser is  Edge----
        else if (browsername.equalsIgnoreCase("Edge")) {
            // Set the path for MSEdgedriver
            System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
            // Instantiate a EdgeDriverclass.
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);

        }

        driver.manage().window().maximize();
        return driver;


    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
