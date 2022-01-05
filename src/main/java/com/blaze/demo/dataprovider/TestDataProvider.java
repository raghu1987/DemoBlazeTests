package com.blaze.demo.dataprovider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataProvider {
	
	private String from;
	private String to;
	private String colnameval;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String cardtype;
	private String cardnum;
	private String cardmon;
	private String cardyear;
	private String cardname;
	
	
	public TestDataProvider(String primaryKey) throws Exception{
		File file = new File(System.getProperty("user.dir")+"/src/test/resources/Data/MasterTestData.xlsx");
	    FileInputStream fileInputStream = new FileInputStream(file);
	    XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
	    XSSFSheet xssfSheet = xssfWorkbook.getSheet("data");
	    int lastRowNum = xssfSheet.getLastRowNum();
	    for (int i=1; i <= lastRowNum; i++) {
	    	if(xssfSheet.getRow(i).getCell(0).getStringCellValue().contains(primaryKey)){
		    	from=xssfSheet.getRow(i).getCell(1).getStringCellValue();
		    	to=xssfSheet.getRow(i).getCell(2).getStringCellValue();
		    	colnameval=xssfSheet.getRow(i).getCell(3).getStringCellValue();
		    	name=xssfSheet.getRow(i).getCell(4).getStringCellValue();
		    	address=xssfSheet.getRow(i).getCell(5).getStringCellValue();
		    	city=xssfSheet.getRow(i).getCell(6).getStringCellValue();
		    	state=xssfSheet.getRow(i).getCell(7).getStringCellValue();
		    	zip=xssfSheet.getRow(i).getCell(8).getStringCellValue();
		    	cardtype=xssfSheet.getRow(i).getCell(9).getStringCellValue();
		    	cardnum=xssfSheet.getRow(i).getCell(10).getStringCellValue();
		    	cardmon=xssfSheet.getRow(i).getCell(11).getStringCellValue();
		    	cardyear=xssfSheet.getRow(i).getCell(12).getStringCellValue();
		    	cardname=xssfSheet.getRow(i).getCell(13).getStringCellValue();
	    	}
	    }
	}


	public String getFrom() {
		return from;
	}


	public String getTo() {
		return to;
	}


	public String getColnameval() {
		return colnameval;
	}


	public String getName() {
		return name;
	}


	public String getAddress() {
		return address;
	}


	public String getCity() {
		return city;
	}


	public String getState() {
		return state;
	}


	public String getZip() {
		return zip;
	}


	public String getCardtype() {
		return cardtype;
	}


	public String getCardnum() {
		return cardnum;
	}


	public String getCardmon() {
		return cardmon;
	}


	public String getCardyear() {
		return cardyear;
	}


	public String getCardname() {
		return cardname;
	}
}
