package com.inetBankingv1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver driver;

	public Login(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "uid")
	WebElement txtusername;
	@FindBy(xpath = "/html/body/form/table/tbody/tr[2]/td[2]/input")
	WebElement txtpassword;
	@FindBy(css = "input[name=btnLogin]")
	WebElement btnlogin;
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement linklogout;
	

	public void setUsername(String uname) {
		txtusername.sendKeys(uname);
	}

	public void setPassword(String pswd) {
		txtpassword.sendKeys(pswd);
	}

	public void clicksubmit() {
		btnlogin.click();

	}
	public void clicklogout() {
		linklogout.click();
}}