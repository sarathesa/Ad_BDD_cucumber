package com.stepdefinition;

import java.io.IOException;

import org.adactin_pages.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class HooksClass extends BaseClass{
	@Before
	public void beforeScenario() throws IOException {
		getDriver(getPropertyValue("browserName"));
		implicitywait(5);
		loadUrl(getPropertyValue("url"));
		maximize();	
		LoginPage loginpages=new LoginPage();
		loginpages.login(getPropertyValue("userName"), getPropertyValue("password"));
	}
	@After
	public void afterScenario(Scenario scenario) {
	TakesScreenshot screenshot=(TakesScreenshot)driver;
	byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);

	
	scenario.attach(screenshotAs, "png", "Screenshot");
	driver.quit();
	
	
	
	
	
	
	
	}
	
	

}
