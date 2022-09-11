package com.openmrs.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.openmrs.utils.UtilMethods;

public class FindPatientRecordPage {

	WebDriver driver;

	@FindBy(id = "patient-search")
	WebElement patientSearchTxtField;
	
	@FindBy(xpath = "//table[@id='patient-search-results-table']")
	WebElement patientTable;
	
	@FindBy(css = "img.search-spinner")
	WebElement searchLoader;
	
	@FindBy(css = "td.dataTables_empty")
	WebElement noRecordFoundStr;
	
	public FindPatientRecordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterPatientName(String patientName) {
		patientSearchTxtField.sendKeys(patientName);
	}
	
	public boolean noRecordFoundDisplayed() {
		return noRecordFoundStr.isDisplayed();
	}
	
	
	/**
     * This POM method will be exposed in test case to register a patient in the application
     * @param strPatientName
     * @return
     */
	public void searchAndOpenPatientRecord(String strPatientName) {
		this.enterPatientName(strPatientName);
		boolean status=UtilMethods.waitForElementVisibility(searchLoader);
		System.out.println("status:"+status);
		if (status==true) {
			int resultLength=patientTable.findElements(By.xpath("//tbody/tr")).size();
			if (resultLength>0) {
				for (int i=0;i<resultLength;i++) {
					String reqXpath="//tbody/tr["+(i+1)+"]/td["+(i+2)+"]";
					if (patientTable.findElements(By.xpath(reqXpath)).get(i).getText().contains(strPatientName)) {
						patientTable.findElements(By.xpath(reqXpath)).get(i).click();
						break;
					}
				}
			}
			else {
				System.out.println("No registered patient found with name:"+strPatientName);
			}
		}
	};
	
	/**
     * This POM method will be exposed in test case to check if patient is deleted
     * @param strPatientName
     * @return true/false
     */
	public boolean isPatientExists(String strPatientName) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(9));
		wait.until(ExpectedConditions.visibilityOf(patientSearchTxtField));
		this.enterPatientName(strPatientName);
		return this.noRecordFoundDisplayed();
	}
}
