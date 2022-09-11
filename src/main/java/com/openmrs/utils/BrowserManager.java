package com.openmrs.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserManager {

	/**
     * This method is to launch the specified browser
     * @param strBrowserName
     * @return driver
     */
	public static WebDriver doBrowserSetup(String strBrowserName) {

		WebDriver driver = null;
		if (strBrowserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("-headed");
			driver = new ChromeDriver(chromeOptions);
		} else if (strBrowserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//Drivers//geckodriver");
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver(options);
		}else {
			System.out.println("Browser not specified");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}

}
