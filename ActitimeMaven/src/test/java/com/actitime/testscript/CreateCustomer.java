package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.generics.BaseClass;
import com.actitime.pom.Homepage;
import com.actitime.pom.TaskListPage;


public class CreateCustomer extends BaseClass {
	@Test
	public void testCreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		String customerName = f.getExcelValue("createCustomer", 1, 0);
		String customerDesc = f.getExcelValue("createCustomer", 1, 1);
		Homepage home = new Homepage(driver);
		home.clickTaskTab();
		TaskListPage t = new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustomerBtn().click();
		t.getEnterCustomerNameTbx().sendKeys(customerName);
		t.getEnterCustomerDescriptionTbx().sendKeys(customerDesc);
		t.getProjectDropDown().click();
		t.getOurCompanyOption().click();
		t.getCreateCustomerBtn().click();

		//wcl.waitForElement(driver, t.getCreatedCustomer());
		Thread.sleep(5000);
		String actualCreatedCustomer = t.getCreatedCustomer().getText();
		Assert.assertEquals(actualCreatedCustomer, customerName);


	}
}
