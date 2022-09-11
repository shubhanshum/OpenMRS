package com.openmrs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.openmrs.config.PatientTestData;
import com.openmrs.pageobjects.FindPatientRecordPage;
import com.openmrs.pageobjects.HomePage;
import com.openmrs.pageobjects.LoginPage;
import com.openmrs.pageobjects.RegisterPatientPage;

public class FindPatientTest extends RunnerTest{

	LoginPage loginPage;
	HomePage homePage;
	FindPatientRecordPage findPatientRecordPage;
	RegisterPatientPage registerPatientpage;
	
	@Test
	public void findPatientTest() throws InterruptedException {
		loginPage = new LoginPage(getDriver());
		homePage = new HomePage(getDriver());
		registerPatientpage=new RegisterPatientPage(getDriver());
		findPatientRecordPage=new FindPatientRecordPage(getDriver());
		loginPage.loginToOpenmrs();
		homePage.clickFindPatientRecordTab();
		String patientName=PatientTestData.firstName;
		findPatientRecordPage.searchAndOpenPatientRecord(patientName);
		Assert.assertEquals(registerPatientpage.getPatientName(), patientName);
	};
	
	
}
