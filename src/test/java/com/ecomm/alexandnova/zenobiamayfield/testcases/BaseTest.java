package com.ecomm.alexandnova.zenobiamayfield.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ecomm.alexandnova.zenobiamayfield.library.BrowserSelection;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;


public class BaseTest {
    static WebDriver driver;



    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;

    static {
      driver= BrowserSelection.StartBrowser("Chrome");
    }
    @BeforeSuite
    public void setUpReport() {

        //create HtmlReporter in that path by the name of MyReport.html
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/AddToCart.html");
        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "DESKTOP-93CMEQ7");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Owner");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting Add To Cart Test Display report");
        htmlReporter.config().setReportName("AddToCartTest Report ");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @BeforeMethod
    public void setUpTestsReport(Method method) throws IOException {
        String methodName = method.getName();
        test = extent.createTest(methodName);
        test.addScreenCaptureFromPath(methodName + ".png");
    }
 /*   @AfterMethod
    public void recordTestResults(ITestResult result) throws IOException {

        if(result.getStatus() == ITestResult.FAILURE)
        {
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.move(screenshotFile, new File("test-output/screenshots/" +result.getName() +".png"));
            test.log(
                    Status.FAIL
                    ,result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.move(screenshotFile, new File("test-output/screenshots/" +result.getName() +".png"));
            test.log(Status.PASS, result.getTestName());
        }
        else
        {
            test.log(Status.SKIP, result.getTestName());
        }
    }
*/
    @AfterSuite
    public void tearDown()
    {
        extent.flush();
        driver.close();
    }


}
