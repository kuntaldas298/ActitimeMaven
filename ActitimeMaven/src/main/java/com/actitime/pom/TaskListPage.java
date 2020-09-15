package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
	@FindBy (xpath = "//div[.='Add New']")
	private WebElement addNewBtn;

	@FindBy (xpath = "//div[.='+ New Customer']")
	private WebElement newCustomerBtn;

	@FindBy (xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement enterCustomerNameTbx;

	@FindBy (xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement enterCustomerDescriptionTbx;

	@FindBy (xpath = "(//div[.='- Select Customer -'])[2]")
	private WebElement projectDropDown;

	@FindBy (xpath = "(//div[@class='searchItemList'])[15]/div[.='Our company']")
	private WebElement ourCompanyOption;

	@FindBy (xpath = "//div[.='Create Customer']")
	private WebElement createCustomerBtn;

	@FindBy (xpath = "//div[@class='title' and @title]")
	private WebElement createdCustomer;

	public TaskListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddNewBtn() {
		return addNewBtn;
	}

	public WebElement getNewCustomerBtn() {
		return newCustomerBtn;
	}

	public WebElement getEnterCustomerNameTbx() {
		return enterCustomerNameTbx;
	}

	public WebElement getEnterCustomerDescriptionTbx() {
		return enterCustomerDescriptionTbx;
	}

	public WebElement getProjectDropDown() {
		return projectDropDown;
	}

	public WebElement getOurCompanyOption() {
		return ourCompanyOption;
	}

	public WebElement getCreateCustomerBtn() {
		return createCustomerBtn;
	}

	public WebElement getCreatedCustomer() {
		return createdCustomer;
	}

}
