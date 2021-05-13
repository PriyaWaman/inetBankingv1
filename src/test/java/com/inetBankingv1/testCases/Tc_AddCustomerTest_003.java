package com.inetBankingv1.testCases;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingv1.pageObjects.Addcustomer_Page;
import com.inetBankingv1.pageObjects.Login;

public class Tc_AddCustomerTest_003 extends Baseclass {
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		Login l = new Login(driver);
		driver.get(baseURL);
		l.setUsername(username);
		logger.info("username is entered");
		l.setPassword(password);
		logger.info("password is entered");
		l.clicksubmit();
		logger.info("info is submitted");
		Thread.sleep(3000);
		Addcustomer_Page addcust = new Addcustomer_Page(driver);
		addcust.clickOnAddnewCustomer();
		logger.info("providing customer details");
		addcust.customerName("Priya");

		addcust.clickON_fMale_Rediobtn();

		addcust.custDOB("03", "01", "1993");
		addcust.customerAdress("Pune  Moshi Pradhikaran");
		addcust.customerCityName("Pune");
		addcust.customerState("Maharashtra");
		addcust.customerPin("420605");
		String mono = randomnumber();
		addcust.customerMobileno(mono);
		String email = randomString() + "@gmail.com";
		addcust.customerEmail(email);
		addcust.customerpswd("1111@Heaven.com");
		addcust.clickON_Submit();
		Thread.sleep(3000);
		logger.info("validation startde!!");
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (result == true) {
			Assert.assertTrue(true);
			logger.info("Test case is passes!!!");
		} else {
			getScreenshot(driver, "addnewcustomer");
			logger.info("Test case is failed!!!");
			Assert.assertTrue(false);

		}

	}

}
