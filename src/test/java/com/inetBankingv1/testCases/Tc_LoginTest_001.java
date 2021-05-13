package com.inetBankingv1.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingv1.pageObjects.Login;
import com.inetBankingv1.testCases.Baseclass;

public class Tc_LoginTest_001 extends Baseclass {
	@Test
	public void loginTest() throws IOException {

		driver.get(baseURL);
		logger.info(driver.getCurrentUrl());
		logger.info("URL is open");
		Login l = new Login(driver);

		l.setUsername(username);
		logger.info("Entered Username");

		// new WebDriverWait(driver,
		// 20).until(ExpectedConditions.elementToBeVisible
		l.setPassword(password);
		logger.info("Password is entered");
		l.clicksubmit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Login done");
		// System.out.println(driver.getTitle());
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("login test passed");
		} else {
			getScreenshot(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("login test failed");
			
		}

	}
}
