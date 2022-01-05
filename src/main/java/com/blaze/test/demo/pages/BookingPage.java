package com.blaze.test.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BookingPage {
	
	private WebDriver driver;
	
	private By name = By.name("inputName");
	private By address = By.id("address");
	private By city = By.id("city");
	private By state = By.id("state");
	private By zipcode = By.id("zipCode");
	private By cardType = By.id("cardType");
	private By creditCardNumber = By.id("creditCardNumber");
	private By creditCardMonth = By.id("creditCardMonth");
	private By creditCardYear = By.id("creditCardYear");
	private By nameOnCard = By.id("nameOnCard");
	private By purchaseFlight = By.xpath("//input[@value='Purchase Flight']");
	
	public BookingPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void enterName(String strname){
		driver.findElement(name).sendKeys(strname);
	}
	
	public void enterAddress(String straddress){
		driver.findElement(address).sendKeys(straddress);
	}
	
	public void enterCity(String strcity){
		driver.findElement(city).sendKeys(strcity);
	}
	
	public void enterstate(String strstate){
		driver.findElement(state).sendKeys(strstate);
	}
	
	public void enterzipCode(String strzCode){
		driver.findElement(zipcode).sendKeys(strzCode);
	}
	
	public void selectCardType(String strcType){
		Select select = new Select(driver.findElement(cardType));
		select.selectByVisibleText(strcType);
	}
	
	public void enterCreditCardNumber(String strccNumber){
		driver.findElement(creditCardNumber).sendKeys(strccNumber);
	}
	
	public void enterCreditCardMonth(String strMonth){
		driver.findElement(creditCardMonth).sendKeys(strMonth);
	}
	
	public void enterCreditCardYear(String strYear){
		driver.findElement(creditCardYear).sendKeys(strYear);
	}
	
	public void enterNameOnCard(String strname){
		driver.findElement(nameOnCard).sendKeys(strname);
	}
	
	public void clickPurchaseFlight(){
		driver.findElement(purchaseFlight).click();
	}
	
	
}
