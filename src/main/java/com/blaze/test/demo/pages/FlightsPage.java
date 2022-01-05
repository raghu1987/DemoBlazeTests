package com.blaze.test.demo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightsPage {
	
	private WebDriver driver;
	
	private By table = By.className("table");
	
	public FlightsPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void selectFlight(String colNameValue){
		String colName = colNameValue.split(":")[0];
		String colValue = colNameValue.split(":")[1];
		int colIndex = -1;
		int rowIndex = -1;
		List<WebElement> columns = driver.findElement(table).findElements(By.xpath("//thead/tr/th"));
		int colCount = columns.size();
		for(int i = 0; i < colCount; i++){
			if(columns.get(i).getText().contains(colName)){
				colIndex = i+1;
				break;
			}
		}
		
		List<WebElement> rows = driver.findElement(table).findElements(By.xpath("//tbody/tr/td["+colIndex+"]"));
		int rowCount = rows.size();
		for(int j = 0; j < rowCount; j++){
			if(rows.get(j+1).getText().contains(colValue)){
				rowIndex = j+1;
				break;
			}
		}
		
		driver.findElement(table).findElement(By.xpath("//tbody/tr["+rowIndex+"]/td[1]/input")).click();
	}

}
