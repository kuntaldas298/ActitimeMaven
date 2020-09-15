package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generics.BaseClass;

public class LoginPage extends BaseClass{
	@FindBy (id = "username")
	private WebElement untbx;

	@FindBy (name = "pwd")
	private WebElement pwtbx;

	@FindBy (id = "loginButton")
	private WebElement lgbtn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//business logic method
	public void setLogin(String un, String pd) {
		untbx.sendKeys(un);
		pwtbx.sendKeys(pd);
		lgbtn.click();

	}
}
