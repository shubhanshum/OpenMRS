package com.openmrs.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestAppointmentPage {

	WebDriver driver;

	@FindBy(id = "appointment-type")
	WebElement appointmentTypeTxtField;

	@FindBy(xpath = "//ul[@role='listbox' and @aria-hidden='false']/li/a")
	List<WebElement> appointmentTypeOptions;

	@FindBy(id = "provider")
	WebElement providerTxtField;

	@FindBy(id = "min-time-frame-value")
	WebElement minTimeTxtField;

	@FindBy(id = "min-time-frame-units")
	WebElement minTimeDropdown;

	@FindBy(id = "max-time-frame-value")
	WebElement maxTimeTxtField;

	@FindBy(id = "max-time-frame-units")
	WebElement maxTimeDropdown;

	@FindBy(id = "notes")
	WebElement notesTxtField;

	@FindBy(id = "save-button")
	WebElement saveBtn;

	public RequestAppointmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	};

	public void enterAppointmentType(String strAppointmentType) {
		appointmentTypeTxtField.sendKeys(strAppointmentType);
	};

	public void selectAppointmentType(String strOptionName) {
		int optionsLen = appointmentTypeOptions.size();
		for (int i = 0; i < optionsLen; i++) {
			if (appointmentTypeOptions.get(i).getText().equalsIgnoreCase(strOptionName)) {
				appointmentTypeOptions.get(i).click();
				break;
			}
		}
	};

	public void enterProvider(String strProviderName) {
		providerTxtField.sendKeys(strProviderName);
	};

	public void selectProviderName(String strProviderName) {
		int optionsLen = appointmentTypeOptions.size();
		for (int i = 0; i < optionsLen; i++) {
			if (appointmentTypeOptions.get(i).getText().equalsIgnoreCase(strProviderName)) {
				appointmentTypeOptions.get(i).click();
				break;
			}
		}
	};

	public void enterMinTime(int intMinTime) {
		minTimeTxtField.sendKeys(Integer.toString(intMinTime));
	};

	public void selectMinTimeUnit(String strMinTimeUnit) {
		Select select = new Select(minTimeDropdown);
		select.selectByVisibleText(strMinTimeUnit);
	};

	public void enterMaxTime(int intMaxTime) {
		maxTimeTxtField.sendKeys(Integer.toString(intMaxTime));
	};

	public void selectMaxTimeUnit(String strMaxTimeUnit) {
		Select select = new Select(maxTimeDropdown);
		select.selectByVisibleText(strMaxTimeUnit);
	};

	public void enterNotes(String strNotes) {
		notesTxtField.sendKeys(strNotes);
	};

	public void clickSaveBtn() {
		saveBtn.click();
	};

	/**
	 * This POM method will be exposed in test case to fill appointment details in
	 * the application
	 * 
	 * @param strAppointmentType
	 * @param strOptionName
	 * @param strProviderName
	 * @param intMinTime
	 * @param strMinTimeUnit
	 * @param intMaxTime
	 * @param strMaxTimeUnit
	 * @param strNotes
	 * @return
	 */
	public void requestAppointment(String strAppointmentType, String strOptionName, String strProviderName,
			int intMinTime, String strMinTimeUnit, int intMaxTime, String strMaxTimeUnit, String strNotes) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(9));
		this.enterAppointmentType(strAppointmentType);
		this.selectAppointmentType(strOptionName);
		this.enterProvider(strProviderName);
		this.selectProviderName(strProviderName);
		this.enterMinTime(intMinTime);
		this.selectMinTimeUnit(strMinTimeUnit);
		this.enterMaxTime(intMaxTime);
		this.selectMaxTimeUnit(strMaxTimeUnit);
		this.enterNotes(strNotes);
		this.clickSaveBtn();
		wait.until(ExpectedConditions.invisibilityOf(saveBtn));
	};
};
