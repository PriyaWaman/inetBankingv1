package com.inetBankingv1.utilities;
//Listener class used to generate ExtentReport  
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reporting extends TestListenerAdapter {
	public ExtentReports extent;
	public ExtentTest logger;
	public ExtentHtmlReporter htmlreporter;
	public WebDriver driver;
@Test
	public void onStart() {
		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		String reportname = "Test-Report" + timestamp +".html";
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"\\test-output" + reportname);
		htmlreporter.loadXMLConfig(System.getProperty("user.dir") + "\\extent-config.xml");
		htmlreporter.config().setDocumentTitle("Inetbanking's Extent report");// title
																				// of
																				// report
		htmlreporter.config().setReportName("Functional test automation result");// name
																					// of
																					// the
																					// report
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);// location
																			// of
																			// chart
		extent = new ExtentReports();

		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Testername", "Priya");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("hoat name", "local host");
		extent.setSystemInfo("Environment", "QA");
	}




	public void onTestSucces(ITestResult tr) {
		logger = extent.createTest(tr.getName());// create new entry in report
		System.out.println("paased tc name is"+tr);
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));// send
																							// the
																							// pass
																							// test
																							// info
	}

	public void onTestFailure(ITestResult tr) {
		logger=extent.createTest(tr.getName()+"failTest");// create new entry in report
		System.out.println("failes tc name is"+tr);
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));// send
																							// the
																							// FAILED
																							// test
																							// info
		String screenshotpth = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png";
		File f = new File(screenshotpth);
		if (f.exists()) {
			try {
				logger.fail("Screenshot is below:+" + logger.addScreenCaptureFromPath(screenshotpth));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName());// create new entry in report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	public void onTestFinish() {
		extent.flush();
	}

	

	

}
