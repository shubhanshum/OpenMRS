package com.openmrs.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.openmrs.utils.UtilMethods;

public class RegisterPatientPage {

	WebDriver driver;
	
	@FindBy(name ="givenName")
	WebElement nameTxtField;
	
	@FindBy(name ="familyName")
	WebElement familyNameTxtField;
	
	@FindBy(id ="next-button")
	WebElement nextButton;
	
	@FindBy(id ="gender-field")
	WebElement genderDropdown;
	
	@FindBy(id ="birthdateDay-field")
	WebElement dayTxtField;
	
	@FindBy(id ="birthdateMonth-field")
	WebElement monthdropdown;
	
	@FindBy(id ="birthdateYear-field")
	WebElement yearTxtField;
	
	@FindBy(id ="address1")
	WebElement address1TxtField;
	
	@FindBy(id ="address2")
	WebElement address2TxtField;
	
	@FindBy(id ="cityVillage")
	WebElement cityTxtField;
	
	@FindBy(id ="stateProvince")
	WebElement stateTxtField;
	
	@FindBy(id ="country")
	WebElement countryTxtField;
	
	@FindBy(id ="postalCode")
	WebElement postalTxtField;
	
	@FindBy(name ="phoneNumber")
	WebElement phoneTxtField;
	
	@FindBy(id ="relationship_type")
	WebElement relationShipDropdown;
	
	@FindBy(xpath ="//input[@ng-model='relationship.name']")
	WebElement personNameTxtField;
	
	@FindBy(id ="submit")
	WebElement confirmButton;
	
	@FindBy(css ="span.PersonName-givenName")
	WebElement patientName;
	
	public RegisterPatientPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String name) {
		nameTxtField.sendKeys(name);
	}
	
	public void enterFamilyName(String familyName) {
		familyNameTxtField.sendKeys(familyName);
	}
	
	public void clickNextArrow() {
		nextButton.click();
	}
	
	public void selectGender(String gender) {
		Select select=new Select(genderDropdown);
		select.selectByVisibleText(gender);
	}
	
	public void enterDayOfBirth(String day) {
		dayTxtField.sendKeys(day);
	}
	
	public void selectMonthOfBirth(String month) {
		Select select=new Select(monthdropdown);
		select.selectByVisibleText(month);
	}
	
	public void enterYearOfBirth(String year) {
		yearTxtField.sendKeys(year);
	}
	
	public void enteraddress1(String address1) {
		address1TxtField.sendKeys(address1);
	}
	
	public void enteraddress2(String address2) {
		address2TxtField.sendKeys(address2);
	}
	
	public void enterCity(String city) {
		cityTxtField.sendKeys(city);
	}
	
	public void enterState(String state) {
		stateTxtField.sendKeys(state);
	}
	
	public void enterCountry(String country) {
		countryTxtField.sendKeys(country);
	}
	
	public void enterPostalCode(String postalCode) {
		postalTxtField.sendKeys(postalCode);
	}
	
	public void enterMobileNumber(String mobileNo) {
		phoneTxtField.sendKeys(mobileNo);
	}
	
	public void selectRelationship(String relationshipType) {
		Select select=new Select(relationShipDropdown);
		select.selectByVisibleText(relationshipType);
	}
	
	public void enterPersonName(String personName) {
		personNameTxtField.sendKeys(personName);
	}
	
	public void clickConfirmButton() {
		confirmButton.click();
	}
	
	public String getPatientName() {
		return patientName.getText();
	}
	
	/**
     * This POM method will be exposed in test case to register a patient in the application
     * @param strName
     * @param strFamilyName
     * @param strGender
     * @param strGender
     * @param strBirthDay
     * @param strBirthMonth
     * @param strBirthYear
     * @param strAddress1
     * @param strAddress2
     * @param strCity
     * @param strState
     * @param strCountry
     * @param strPostalCode
     * @param strMobileNo
     * @param strRelationshipType
     * @param strPersonName
     * @return
     */
	
	public void registerPatient(String strName, String strFamilyName, String strGender, String strBirthDay,
			String strBirthMonth, String strBirthYear, String strAddress1, String strAddress2, String strCity,
			String strState, String strCountry, String strPostalCode, String strMobileNo, String strRelationshipType,
			String strPersonName) {
		this.enterFirstName(strName);
		this.enterFamilyName(strFamilyName);
		this.clickNextArrow();
		this.selectGender(strGender);
		this.clickNextArrow();
		this.enterDayOfBirth(strBirthDay);
		this.selectMonthOfBirth(strBirthMonth);
		this.enterYearOfBirth(strBirthYear);
		this.clickNextArrow();
		this.enteraddress1(strAddress1);
		this.enteraddress2(strAddress2);
		this.enterCity(strCity);
		this.enterState(strState);
		this.enterCountry(strCountry);
		this.enterPostalCode(strPostalCode);
		this.clickNextArrow();
		this.enterMobileNumber(strMobileNo);
		this.clickNextArrow();
		this.selectRelationship(strRelationshipType);
		this.enterPersonName(strPersonName);
		this.clickNextArrow();
		this.clickConfirmButton();
	};
	
}
