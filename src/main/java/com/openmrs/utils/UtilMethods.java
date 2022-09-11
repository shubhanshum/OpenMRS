package com.openmrs.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtilMethods {

	static WebDriver driver;

	/**
     * This method is to get data from properties file
     * @param strFilePath
     * @param strKey
     * @return value
     */
	public static String getPropFileData(String strFilePath, String strKey) {
		FileInputStream fileInputStream = null;
		String value = "";
		if (fileInputStream == null) {
			try {
				fileInputStream = new FileInputStream(strFilePath);
				Properties properties = new Properties();
				properties.load(fileInputStream);
				value = properties.getProperty(strKey);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return value;
	};

	/**
     * This method is to wait till element become visible
     * @param WebElement
     * @return true/false
     */
	public static boolean waitForElementVisibility(WebElement element) {
		for (int index = 0; index < 10; index++) {
			try {
				element.isDisplayed();
				return true;
			} catch (Exception e1) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	};

	public static void waitForElement(int secs) {
		try {
			Thread.sleep(secs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
