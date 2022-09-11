package com.openmrs.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentSchedulingPage {

	
	WebDriver driver;

	@FindBy(xpath = "//a[contains(@id,'appointmentRequests-app')]")
	WebElement appointmentRequestsTab;
	
	public AppointmentSchedulingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	};
	
	public void clickAppointmentRequestsTab() {
		appointmentRequestsTab.click();
	};
}
