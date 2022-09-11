package com.openmrs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.openmrs.config.PatientTestData;
import com.openmrs.pageobjects.FindPatientRecordPage;
import com.openmrs.pageobjects.HomePage;
import com.openmrs.pageobjects.LoginPage;
import com.openmrs.pageobjects.PatientsDetailsPage;

public class DeletePatientTest extends RunnerTest{

	LoginPage loginPage;
	HomePage homePage;
	FindPatientRecordPage findPatientRecordPage;
	PatientsDetailsPage patientDetailsPage;
	
	@Test
	public void uploadFileTest() throws InterruptedException {
		loginPage=new LoginPage(getDriver());
		homePage=new HomePage(getDriver());
		findPatientRecordPage=new FindPatientRecordPage(getDriver());
		patientDetailsPage=new PatientsDetailsPage(getDriver());
		loginPage.loginToOpenmrs();
		homePage.clickFindPatientRecordTab();
		String patientName=PatientTestData.firstName;
		findPatientRecordPage.searchAndOpenPatientRecord(patientName);
		String deleteReason="Not required";
		patientDetailsPage.deletePatient(deleteReason);
		boolean actResult=findPatientRecordPage.isPatientExists(patientName);
		Assert.assertTrue(actResult);
	}
}
