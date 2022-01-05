package com.blaze.test.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	private WebDriver driver;
	
	private By from = By.name("fromPort");
	private By to = By.name("toPort");
	private By findFlights = By.xpath("//input[@value='Find Flights']");
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public void selectFrom(String value){
		Select sel = new Select(driver.findElement(from));
        sel.selectByValue(value);
	}
	
	public void selectTo(String value){
		Select sel = new Select(driver.findElement(to));
        sel.selectByValue(value);
	}
	
	public void clickfindFlights(){
		driver.findElement(findFlights).click();
	}

}
