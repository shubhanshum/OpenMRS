package com.openmrs.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.openmrs.utils.BrowserManager;

public class RunnerTest {

	protected static 
    ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	@Parameters({ "browserName","url" })
    @BeforeClass
    public void Setup(String browserName,String url){
        WebDriver driver = BrowserManager.doBrowserSetup(browserName);
        threadLocalDriver.set(driver);
        getDriver().get(url);
    }

    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }


    @AfterClass
    public void tearDown(){
        getDriver().quit();
        threadLocalDriver.remove();
    }

}
