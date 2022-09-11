package com.openmrs.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientsDetailsPage {

	WebDriver driver;

	@FindBy(css = "span.PersonName-givenName")
	WebElement patientFirstNameTxt;
	
	@FindBy(css = "span.PersonName-familyName")
	WebElement patientFamilyNameTxt;
	
	@FindBy(css = "div.gender-age")
	WebElement genderAgeTxt;
	
	@FindBy(id = "patient-header-contactInfo")
	WebElement showContactInfoLnk;
	
	@FindBy(id = "coreapps-telephoneNumber")
	WebElement telephoneNumberTxt;
	
	@FindBy(xpath = "//a[contains(@href,'requestAppointment')]")
	WebElement requestAppointmentLnk;
	
	@FindBy(xpath = "//a[contains(@href,'referenceapplication/home')]")
	WebElement homeLink;
	
	@FindBy(id = "org.openmrs.module.coreapps.createVisit")
	WebElement startVisitLnk;
	
	@FindBy(id = "start-visit-with-visittype-confirm")
	WebElement startVisitConfirmBtn;
	
	@FindBy(id = "org.openmrs.module.coreapps.deletePatient")
	WebElement deletePatientLink;
	
	@FindBy(id = "delete-reason")
	WebElement reasonTxtBox;
	
	@FindBy(css = "div#delete-patient-creation-dialog>div.dialog-content>button.confirm")
	WebElement deleteConfirmBtn;
	
	
	public PatientsDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	};
	
	public String getPatientFirstName() {
		return patientFirstNameTxt.getText().trim();
	};
	
	public String getPatientFamilyName() {
		return patientFamilyNameTxt.getText().trim();
	};
	
	public String getPatientGender() {
		String displayStr=genderAgeTxt.getText().trim();
		String [] strArray=displayStr.split(" ");
		return strArray[0].trim();
	};
	
	public void clickContactInfoBtn() {
		showContactInfoLnk.click();
	};
	
	public String getPatientPhoneNo() {
		return telephoneNumberTxt.getText().trim();
	};
	
	public void clickRequestAppointmentLnk() {
		Actions actions=new Actions(driver);
		actions.moveToElement(requestAppointmentLnk).click().perform();
	};
	
	public void clickStartVisitLnk() {
		startVisitLnk.click();
	}
	
	public void clickStartVisitConfirmBtn() {
		startVisitConfirmBtn.click();
	}
	
	public void clickDeletePatientLink() {
		deletePatientLink.click();
	}
	
	public void enterDeleteReason(String strDeleteReason) {
		reasonTxtBox.sendKeys(strDeleteReason);
	}
	
	public void clickDeleteConfirmBtn() {
		deleteConfirmBtn.click();
	}
	
	/**
     * This POM method will be exposed in test case to start patient visit in the application
     * @return
     */
	public void startPatientVisit() {
		this.clickStartVisitLnk();
		this.clickStartVisitConfirmBtn();
	}
	
	/**
     * This POM method will be exposed in test case to delete patient in the application
     * @param strDeleteReason
     * @return
     */
	public void deletePatient(String strDeleteReason) {
		this.clickDeletePatientLink();
		this.enterDeleteReason(strDeleteReason);
		this.clickDeleteConfirmBtn();
	}
	
}
