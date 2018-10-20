package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase{

@Test
public void loginASBankManager() throws InterruptedException{
	System.out.println("Inside Login Test");

	driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
	Thread.sleep(2000);
	Assert.assertTrue(isElementDisplayed(By.cssSelector(OR.getProperty("addCustBtn"))), "Login not successful");
	Assert.fail("Test case failed");
}


}
