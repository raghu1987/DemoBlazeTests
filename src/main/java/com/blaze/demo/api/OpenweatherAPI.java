package com.blaze.demo.api;

import com.blaze.demo.model.Model;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OpenweatherAPI {
	
	private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";
	private static String apiKey = "831ce5030fc71fe81b1cefe992a3a00b";
	private static int responseCode;
	
	public static int getResponseCode() {
		return responseCode;
	}

	public static void setResponseCode(int responseCode) {
		OpenweatherAPI.responseCode = responseCode;
	}
	
	public static Model getWeather(String location) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json").param("appid", apiKey).param("q", location);
        Response resp = request.get("/").then().extract().response();
        setResponseCode(resp.getStatusCode());
        return resp.getBody().as(Model.class);
    }

	

}
