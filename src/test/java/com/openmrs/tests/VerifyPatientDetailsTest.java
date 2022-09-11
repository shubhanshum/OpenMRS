package com.openmrs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.openmrs.config.PatientTestData;
import com.openmrs.pageobjects.FindPatientRecordPage;
import com.openmrs.pageobjects.HomePage;
import com.openmrs.pageobjects.LoginPage;
import com.openmrs.pageobjects.PatientsDetailsPage;
import com.openmrs.pageobjects.RegisterPatientPage;

public class VerifyPatientDetailsTest extends RunnerTest{

	LoginPage loginPage;
	HomePage homePage;
	FindPatientRecordPage findPatientRecordPage;
	RegisterPatientPage registerPatientpage;
	PatientsDetailsPage patientDetailsPage;
	
	@Test
	public void verifyPatientDetailsTest() throws InterruptedException {
		loginPage = new LoginPage(getDriver());
		homePage = new HomePage(getDriver());
		registerPatientpage=new RegisterPatientPage(getDriver());
		findPatientRecordPage=new FindPatientRecordPage(getDriver());
		loginPage.loginToOpenmrs();
		homePage.clickFindPatientRecordTab();
		String patientName=PatientTestData.firstName;
		findPatientRecordPage.searchAndOpenPatientRecord(patientName);
		patientDetailsPage=new PatientsDetailsPage(getDriver());
		Assert.assertEquals(patientDetailsPage.getPatientFirstName(), PatientTestData.firstName);
		Assert.assertEquals(patientDetailsPage.getPatientFamilyName(), PatientTestData.lastName);
		Assert.assertEquals(patientDetailsPage.getPatientGender(), PatientTestData.gender);
		patientDetailsPage.clickContactInfoBtn();
		Assert.assertEquals(patientDetailsPage.getPatientPhoneNo(), PatientTestData.patientMobileNo);
	}
}
