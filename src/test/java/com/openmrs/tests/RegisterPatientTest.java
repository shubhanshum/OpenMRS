package com.openmrs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.openmrs.config.PatientTestData;
import com.openmrs.pageobjects.HomePage;
import com.openmrs.pageobjects.LoginPage;
import com.openmrs.pageobjects.RegisterPatientPage;

public class RegisterPatientTest extends RunnerTest {

	LoginPage loginPage;
	HomePage homePage;
	RegisterPatientPage registerPatientpage;

	@Test
	public void registerPatientTest() {
		loginPage = new LoginPage(getDriver());
		homePage = new HomePage(getDriver());
		registerPatientpage = new RegisterPatientPage(getDriver());
		loginPage.loginToOpenmrs();
		homePage.clickRegisterPatientTab();
		registerPatientpage.registerPatient(PatientTestData.firstName, PatientTestData.lastName, PatientTestData.gender,
				PatientTestData.day, PatientTestData.month, PatientTestData.year, PatientTestData.address1,
				PatientTestData.address2, PatientTestData.city, PatientTestData.state, PatientTestData.country,
				PatientTestData.postalCode, PatientTestData.patientMobileNo, PatientTestData.relationshipType,
				PatientTestData.personName);
		Assert.assertEquals(registerPatientpage.getPatientName(), PatientTestData.firstName);
	}
}
