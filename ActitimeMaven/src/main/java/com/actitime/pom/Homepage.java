package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generics.BaseClass;

public class Homepage extends BaseClass {
	@FindBy(id = "logoutLink")
	private WebElement logout;

	@FindBy(id = "container_tasks")
	private WebElement taskTab;

	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setLogout() {
		logout.click();
	}

	public void clickTaskTab() {
		taskTab.click();
	}
}
