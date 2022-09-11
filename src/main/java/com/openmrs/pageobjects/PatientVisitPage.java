package com.openmrs.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PatientVisitPage {

	WebDriver driver;

	@FindBy(id = "attachments.attachments.visitActions.default")
	WebElement attachmentBtn;

	@FindBy(id = "visit-documents-dropzone")
	WebElement dropFileBtn;

	@FindBy(xpath = "//textarea[contains(@ng-model,'fileCaption')]")
	WebElement captionTextBox;

	@FindBy(xpath = "//button[contains(@ng-click,'uploadFile')]")
	WebElement uploadFileBtn;

	@FindBy(xpath = "//button[contains(@ng-click,'uploadFile') and (@disabled='disabled')]")
	WebElement uploadFileDisabledBtn;

	@FindBy(xpath = "//div[contains(@ng-show,'contentFamily')]")
	WebElement uploadedFile;

	public PatientVisitPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	};

	public void clickAttachmentBtn() {
		attachmentBtn.click();
	}

	public void enterCaption(String captionNote) {
		captionTextBox.sendKeys(captionNote);
	}

	public void clickUploadFileButton() {
		uploadFileBtn.click();
	}

	public boolean verifyUploadedfileDisplayed() {
		if (uploadedFile.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	};

	public void uploadFile(String strFilePath, String strCaptionNote) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
		this.clickAttachmentBtn();
		((JavascriptExecutor) driver).executeScript("HTMLInputElement.prototype.click = function() {"
				+ "if(this.type !== 'file') HTMLElement.prototype.click.call(this);" + "};");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", dropFileBtn);
		dropFileBtn.click();
		driver.findElement(By.cssSelector("input[type=file]")).sendKeys(strFilePath);
		wait.until(ExpectedConditions.visibilityOf(uploadFileBtn));
		this.enterCaption(strCaptionNote);
		this.clickUploadFileButton();
		wait.until(ExpectedConditions.visibilityOf(uploadFileDisabledBtn));
		wait.until(ExpectedConditions.visibilityOf(uploadedFile));
	};
}
