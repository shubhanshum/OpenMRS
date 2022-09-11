package com.openmrs.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath ="//a[contains(@id,'registerPatient-homepageLink')]")
	WebElement registerPatientTab;
	
	@FindBy(xpath ="//a[contains(@href,'findpatient')]")
	WebElement findPatientRecordTab;
	
	@FindBy(xpath ="//a[contains(@id,'appointmentschedulingui-homeAppLink')]")
	WebElement appointmentSchedulingTab;
	
	@FindBy(linkText  ="Logout")
	WebElement logoutButton;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkLogoutLnkExists() {
		return logoutButton.isDisplayed();
	}
	
	public void clickRegisterPatientTab() {
		registerPatientTab.click();
	}
	
	public void clickFindPatientRecordTab() {
		findPatientRecordTab.click();
	}
	
	/**
	 * This POM method will be exposed in test case to click on Appointment
	 * scheduling tab
	 * @return
	 */
	public void clickAppointmentSchedulingTab() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOf(appointmentSchedulingTab));
		appointmentSchedulingTab.click();
	}
	
	/**
	 * This POM method will be exposed in test case to logout user
	 * from Patients details page
	 * @return
	 */
	public void logoutFromPatientDetailsPage() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(9));
		wait.until(ExpectedConditions.visibilityOf(logoutButton));
		logoutButton.click();
	}
}
