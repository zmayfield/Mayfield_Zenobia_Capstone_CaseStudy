package com.ecomm.alexandnova.zenobiamayfield.testcases;

import com.ecomm.alexandnova.zenobiamayfield.pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTest extends BaseTest{


    SearchPage searchPage;


    //*************************************************************************************************************
    // Test Case# 8: This test case is to verify that end users can search for products with search field
    //*************************************************************************************************************
    @Test(priority = 8)
    public void tc0008_search_products_test(){

        searchPage = new SearchPage(driver);
        searchPage.searchItem("baby shoes");
        searchPage.clickSearchIcon();

        Assert.assertTrue(searchPage.searchResultPageDisplayed());
    }

    //*************************************************************************************************************
    // Test Case# 9: This test case is to verify that if search is performed without inserting anything in search
    // field, user should see an error message
    //*************************************************************************************************************

    @Test(priority = 9)
    public void tc0009_search_with_blank_search_field_test() throws InterruptedException {
        searchPage = new SearchPage(driver);
        //Thread.sleep(600);
        WebElement search = driver.findElement(By.name("q"));
        search.clear();
        searchPage.searchItem(" ");
        searchPage.clickSearchIcon();
        //Thread.sleep(400);
        //searchPage.clickSearchIcon();
        Thread.sleep(500);
        String expectedMessage = "No results found. Showing top popular products you might want to consider...";
        String actualMessage = searchPage.getBlankSearchResultMessage();

        System.out.println("Actual message: " + actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage);

    }

}
