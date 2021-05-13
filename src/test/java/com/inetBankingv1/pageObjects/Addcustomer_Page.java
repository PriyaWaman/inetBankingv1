package com.inetBankingv1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Addcustomer_Page {
	WebDriver ldriver;

	public Addcustomer_Page(WebDriver rdriver)

	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	@FindBy(how = How.XPATH, using = "//tbody/tr[4]/td[2]/input[1]")
	@CacheLookup
	WebElement newcustomer;
	@FindBy(how = How.XPATH, using = "//tbody/tr[5]/td[2]/input[1]")
	@CacheLookup
	WebElement btngendor_M;
	@FindBy(how = How.XPATH, using = "//tbody/tr[5]/td[2]/input[2]")
	@CacheLookup
	WebElement btngendor_F;
	@FindBy(how = How.CSS, using = "#dob")
	@CacheLookup
	WebElement txtDOB;
	@FindBy(how = How.CSS, using = "textarea[name=addr]")
	@CacheLookup
	WebElement txtadress;
	@FindBy(how = How.CSS, using = "input[name=city]")
	@CacheLookup
	WebElement txtcity;
	@FindBy(how = How.CSS, using = "input[name=state]")
	@CacheLookup
	WebElement txtstate;
	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtpin;
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtmobileno;
	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtemailid;
	@FindBy(how = How.XPATH, using = "//tbody/tr[13]/td[2]/input[1]")
	@CacheLookup
	WebElement txtpswd;
	@FindBy(how = How.XPATH, using = "//tbody/tr[14]/td[2]/input[1]")
	@CacheLookup
	WebElement btnsubmit;
	@FindBy(how = How.XPATH, using = "//tbody/tr[14]/td[2]/input[2]")
	@CacheLookup
	WebElement btnreset;

	public void clickOnAddnewCustomer() {
		lnkAddNewCustomer.click();
	}

	public void customerName(String cname) {
		newcustomer.sendKeys(cname);

	}

	public void clickON_Male_Rediobtn() {
		btngendor_M.click();

	}

	public void clickON_fMale_Rediobtn() {
		btngendor_F.click();

	}

	public void custDOB(String dd, String mm, String yy) {
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(mm);
		txtDOB.sendKeys(yy);
	}
	public void customerAdress(String adress) {
		txtadress.sendKeys(adress);}
	
	public void customerCityName(String city) {
		txtcity.sendKeys(city);
	}

	public void customerState(String state) {
		txtstate.sendKeys(state);

	}

	public void customerPin(String pin) {
		txtpin.sendKeys(pin);

	}
	public void customerMobileno(String mono) {
		txtmobileno.sendKeys(mono);

	}

	public void customerEmail(String email) {
		txtemailid.sendKeys(email);
	}

	public void customerpswd(String pswd) {
		txtpswd.sendKeys(pswd);
	}

	public void clickON_Submit() {
		btnsubmit.click();

	}

	public void clickON_Reset() {
		btnreset.click();

	}

}
