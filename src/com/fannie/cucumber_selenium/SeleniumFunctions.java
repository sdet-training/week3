package com.fannie.cucumber_selenium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumFunctions {

	public static WebDriver driver = null;
	public static WebDriverWait waitVar = null;

	public static String baseURL = "https://github.com/";

	public void createDriver() throws MalformedURLException,
			InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJAVATraining\\Softwares\\GeckoDriver\\64bit\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get(baseURL);

		waitVar = new WebDriverWait(driver, 15);
	}

	public void ishomepageDisplayed() {
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By
				.linkText("Sign in")));

		driver.findElement(By.linkText("Sign in")).isDisplayed();
		driver.findElement(By.className("text-gray")).isDisplayed();
	}

	public void clickSigninLink() {
		driver.findElement(By.linkText("Sign in")).click();
	}

	public void isloginsectionDisplayed() {
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By.className("auth-form-body")));
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By.name("commit")));
	}
	
	public void teardown() {
		driver.quit();
	}

}
