package com.actitime.generics;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.Homepage;
import com.actitime.pom.LoginPage;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
		}
	public static WebDriver driver;
	public FileLib f = new FileLib();
	public WebDriverCommonLib wcl = new WebDriverCommonLib();
	
	@BeforeTest
	public void openBrowser() throws IOException {
		String url = f.getPropertyValue("url");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		wcl.waitForElementInGUI(driver);
		driver.get(url);
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	@BeforeMethod
	public void login() throws IOException {		
		String un = f.getPropertyValue("username");
		String pd = f.getPropertyValue("password");
		LoginPage l = new LoginPage(driver);
		l.setLogin(un, pd);
	}
	@AfterMethod
	public void logout() {
		Homepage home = new Homepage(driver);
		wcl.waitForElementInGUI(driver);
		home.setLogout();
	}
}
