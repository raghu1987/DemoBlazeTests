package com.blaze.demo.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

import com.blaze.demo.Base;
import com.blaze.demo.api.OpenweatherAPI;
import com.blaze.demo.dataprovider.TestDataProvider;
import com.blaze.demo.model.Model;
import com.blaze.test.demo.pages.BookingConfirmationPage;
import com.blaze.test.demo.pages.BookingPage;
import com.blaze.test.demo.pages.FlightsPage;
import com.blaze.test.demo.pages.HomePage;

public class AssesmentTest extends Base{

	@Test(dataProvider = "td", description = "Book Flight", priority = 1)
	public void book_A01(TestDataProvider data) {
	  HomePage home = new HomePage(driver);
		home.selectFrom(data.getFrom());
		home.selectTo(data.getTo());
		home.clickfindFlights();
		
		FlightsPage flights = new FlightsPage(driver);
		flights.selectFlight(data.getColnameval());
		
		 BookingPage book = new BookingPage(driver);
		 book.enterName(data.getName());
		 book.enterAddress(data.getAddress());
		 book.enterCity(data.getCity());
		 book.enterstate(data.getState());
		 book.enterzipCode(data.getZip());
		 book.selectCardType(data.getCardtype());
		 book.enterCreditCardNumber(data.getCardnum());
		 book.enterCreditCardMonth(data.getCardmon());
		 book.enterCreditCardYear(data.getCardyear());
	     book.enterNameOnCard(data.getCardname());
	     book.clickPurchaseFlight();
	        
	     BookingConfirmationPage conf = new BookingConfirmationPage(driver);
	     assertFalse(conf.getConfNumber().isEmpty());
	     System.out.println(conf.getConfNumber());
  }

	@Test(dataProvider = "td",description = "API Get Request with Valid city name", priority = 2)
	  public void weatherAPI_A02(TestDataProvider data) {
		System.out.println(data.getFrom());
		Model mod = OpenweatherAPI.getWeather(data.getFrom());
		assertEquals(OpenweatherAPI.getResponseCode(), 200);
		assertEquals(mod.getName(), data.getFrom());
	  }
}
