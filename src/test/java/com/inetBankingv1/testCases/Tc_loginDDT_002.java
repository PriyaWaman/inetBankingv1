package com.inetBankingv1.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBankingv1.pageObjects.Login;
import com.inetBankingv1.utilities.XLUtils;

public class Tc_loginDDT_002 extends Baseclass {
	@Test(dataProvider = "Logindata")
	public void loginDDT(String user, String pswd) throws InterruptedException {
		driver.get(baseURL);
		logger.info(driver.getCurrentUrl());
		logger.info("URL is open");
		Login l = new Login(driver);
		l.setUsername(user);
		logger.info("username is provided");
		l.setPassword(pswd);
		logger.info("password is provided");
		l.clicksubmit();
		Thread.sleep(3000);
		if (isAlertPresent() == true) {
			Assert.assertTrue(false);
			logger.info("login failed!!!");
			Thread.sleep(5000);
			driver.switchTo().alert().accept();

			driver.switchTo().defaultContent();
		} else {
			Assert.assertTrue(true);
			logger.info("login passed");
			Thread.sleep(3000);
			l.clicklogout();
			driver.switchTo().alert().accept(); // close the logout allert

			driver.switchTo().defaultContent();
		}

	}

	public boolean isAlertPresent() // user defined method created to check
									// alert is present or not
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DataProvider(name = "Logindata")
	public String[][] getDta() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetBankingv1/testData/loginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "sheet1");
		int columncount = XLUtils.getCellCount(path, "sheet1", 1);
		String logindata[][] = new String[rownum][columncount];
		for (int i = 1; i < rownum; i++) {
			for (int j = 0; j < columncount; j++) {

				logindata[i - 1][j] = XLUtils.getCellData(path, "sheet1", i, j);
			}

		}
		return logindata;

	}
}
