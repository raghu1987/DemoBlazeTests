package com.blaze.demo;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.blaze.demo.dataprovider.TestDataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

    private Properties config;
    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void init() throws Throwable {
    	config = new Properties();
    	config.load(new FileReader(System.getProperty("user.dir")+"/src/test/resources/Data/config.properties"));    	
        launchApp();
    }

    private void launchApp() {
    	 if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
                 WebDriverManager.chromedriver().setup();
                 ChromeOptions options = new ChromeOptions();
         	 options.addArguments("--headless");
         	 options.addArguments("--no-sandbox");
         	 options.addArguments("--disable-dev-shm-usage");
         	 driver = new ChromeDriver(options);
                 driver.get(config.getProperty("url"));
         }
    	
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        try {
            driver.quit();
        } catch (Exception e) {
        	System.out.println(e.getLocalizedMessage());
        }
    }
    
    @DataProvider(name = "td")
    public Object[][] getData(Method m) throws Exception{
    	String name = m.getName();
		String[] name_arr = name.split("_");
		String primaryKey = name_arr[1];
		return new Object[][]{{new TestDataProvider(primaryKey)}};
    }


}
