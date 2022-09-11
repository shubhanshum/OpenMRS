package com.openmrs.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.openmrs.utils.UtilMethods;

public class LoginPage {

	WebDriver driver;
	
	@FindBy(id ="username")
	WebElement emailtextbox;
	
	@FindBy(id ="password")
	WebElement passwordtextbox;
	
	@FindBy(id ="loginButton")
	WebElement loginButton;
	
	@FindBy(id ="Inpatient Ward")
	WebElement inpatientWardLink;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUsername(String strUserName) {
		emailtextbox.sendKeys(strUserName);
	};
	
	public void setPassword(String strPassword) {
		passwordtextbox.sendKeys(strPassword);
	};
	
	public void clickInpatientWardLnk() {
		inpatientWardLink.click();
	}
	
	public void clickLoginBtn() {
		loginButton.click();
	};
	
	/**
     * This POM method will be exposed in test case to login in the application
     * @return
     */
	public void loginToOpenmrs() {
		String filePath=System.getProperty("user.dir")+"//src//main//java//com//openmrs//config//config.properties";
		String username=UtilMethods.getPropFileData(filePath,"openmrs_username");
		String password=UtilMethods.getPropFileData(filePath, "openmrs_password");
		this.setUsername(username);
		this.setPassword(password);
		this.clickInpatientWardLnk();
		this.clickLoginBtn();
	};
}
