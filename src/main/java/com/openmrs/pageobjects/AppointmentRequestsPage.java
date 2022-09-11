package com.openmrs.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppointmentRequestsPage {

	WebDriver driver;

	@FindBy(xpath = "//div[contains(@class,'ngCellText') and contains(@class,'col0')]")
	List<WebElement> appointmentBookedPatientsList;

	@FindBy(css = "div.ngPagerNextTriangle")
	WebElement nextButton;

	public AppointmentRequestsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	};

	public void clickNextButton() {
		nextButton.click();
	}

	/**
	 * This POM method will be exposed in test case to get patients that have booked
	 * the appointment in the application
	 * 
	 * @param strPatientName
	 * @return strReqPatientName
	 */
	public String getAppointmentBookedPatient(String strPatientName) {
		String strReqPatientName = "";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
		int patientsLen = appointmentBookedPatientsList.size();
		for (int i = 0; i < patientsLen; i++) {
			wait.until(ExpectedConditions.visibilityOf(appointmentBookedPatientsList.get(i)));
			if (appointmentBookedPatientsList.get(i).getText().equalsIgnoreCase(strPatientName)) {
				strReqPatientName = appointmentBookedPatientsList.get(i).getText();
				break;
			} else {
				this.clickNextButton();
			}
		}
		;
		return strReqPatientName;
	}
}
