package com.blaze.test.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingConfirmationPage {
	
	WebDriver driver;
	
	private By id = By.xpath("//td[text()='Id']/following-sibling::td");
	
	public BookingConfirmationPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getConfNumber(){
		return driver.findElement(id).getText();
	}

}
