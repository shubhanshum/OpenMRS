package com.openmrs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.openmrs.config.PatientTestData;
import com.openmrs.pageobjects.FindPatientRecordPage;
import com.openmrs.pageobjects.HomePage;
import com.openmrs.pageobjects.LoginPage;
import com.openmrs.pageobjects.PatientVisitPage;
import com.openmrs.pageobjects.PatientsDetailsPage;

public class UploadAttachmentTest extends RunnerTest{

	LoginPage loginPage;
	HomePage homePage;
	FindPatientRecordPage findPatientRecordPage;
	PatientsDetailsPage patientDetailsPage;
	PatientVisitPage patientVisitPage;
	
	@Test
	public void uploadFileTest() throws InterruptedException {
		loginPage=new LoginPage(getDriver());
		homePage=new HomePage(getDriver());
		findPatientRecordPage=new FindPatientRecordPage(getDriver());
		patientDetailsPage=new PatientsDetailsPage(getDriver());
		patientVisitPage=new PatientVisitPage(getDriver());
		loginPage.loginToOpenmrs();
		homePage.clickFindPatientRecordTab();
		String patientName=PatientTestData.firstName;
		findPatientRecordPage.searchAndOpenPatientRecord(patientName);
		patientDetailsPage.startPatientVisit();
		String uploadFilePath=System.getProperty("user.dir")+"//TestFile//uploadImage.jpeg";
		patientVisitPage.uploadFile(uploadFilePath, "Demo");
		Assert.assertTrue(patientVisitPage.verifyUploadedfileDisplayed());
	}
}
