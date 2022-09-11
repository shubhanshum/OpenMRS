package com.openmrs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.openmrs.config.PatientTestData;
import com.openmrs.pageobjects.AppointmentRequestsPage;
import com.openmrs.pageobjects.AppointmentSchedulingPage;
import com.openmrs.pageobjects.FindPatientRecordPage;
import com.openmrs.pageobjects.HomePage;
import com.openmrs.pageobjects.LoginPage;
import com.openmrs.pageobjects.PatientsDetailsPage;
import com.openmrs.pageobjects.RequestAppointmentPage;

public class RequestAppointmentTest extends RunnerTest {

	LoginPage loginPage;
	HomePage homePage;
	FindPatientRecordPage findPatientRecordPage;
	RequestAppointmentPage requestAppointmentPage;
	PatientsDetailsPage patientDetailsPage;
	AppointmentSchedulingPage appointmentschedulingPage;
	AppointmentRequestsPage appointmentRequestspage;

	@Test
	public void requestAppointmentTest() {
		loginPage = new LoginPage(getDriver());
		homePage = new HomePage(getDriver());
		findPatientRecordPage = new FindPatientRecordPage(getDriver());
		requestAppointmentPage = new RequestAppointmentPage(getDriver());
		patientDetailsPage = new PatientsDetailsPage(getDriver());
		appointmentschedulingPage = new AppointmentSchedulingPage(getDriver());
		appointmentRequestspage = new AppointmentRequestsPage(getDriver());
		loginPage.loginToOpenmrs();
		homePage.clickFindPatientRecordTab();
		String patientName = PatientTestData.firstName;
		findPatientRecordPage.searchAndOpenPatientRecord(patientName);
		patientDetailsPage.clickRequestAppointmentLnk();
		requestAppointmentPage.requestAppointment(PatientTestData.appointmentType, PatientTestData.strOptionName,
				PatientTestData.strProviderName, PatientTestData.intMinTime, PatientTestData.strMinTimeUnit,
				PatientTestData.intMaxTime, PatientTestData.strMaxTimeUnit, PatientTestData.strNotes);
		homePage.logoutFromPatientDetailsPage();
		loginPage.loginToOpenmrs();
		homePage.clickAppointmentSchedulingTab();
		appointmentschedulingPage.clickAppointmentRequestsTab();
		String reqPatientName = PatientTestData.firstName.concat(" ").concat(PatientTestData.lastName);
		String actPatientName = appointmentRequestspage.getAppointmentBookedPatient(reqPatientName);
		Assert.assertEquals(actPatientName, reqPatientName);
	}
}
