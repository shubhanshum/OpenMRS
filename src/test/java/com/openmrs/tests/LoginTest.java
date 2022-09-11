package com.openmrs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.openmrs.pageobjects.HomePage;
import com.openmrs.pageobjects.LoginPage;

public class LoginTest extends RunnerTest{

	LoginPage loginPage;
	HomePage homePage;
	
	@Test
	public void loginTest() {
		loginPage=new LoginPage(getDriver());
		homePage=new HomePage(getDriver());
		loginPage.loginToOpenmrs();
		Assert.assertTrue(homePage.checkLogoutLnkExists());
	}
}
