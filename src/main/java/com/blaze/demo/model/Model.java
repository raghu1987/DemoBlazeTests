package com.blaze.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Model {
	
	private Coord coord;
	private List<Weather> weather;
	private String base;
	private Main main;
	private String visibility;
	private Wind wind;
	private Clouds clouds;
	private int dt;
	private Sys sys;
	private int timezone;
	private int id;
	private String name;
	private String cod;
	
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Coord {
		
		private float lon;
		private float lat;
		
	}
	
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Weather {
		private int id;
		private String main;
		private String description;
		private String icon;	
	}
	
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Main {
		private float temp;
		private float feels_like;
		private float temp_min;
		private float temp_max;
		private int pressure;
		private int humidity;
		private int sea_level;
		private int grnd_level;
	}
	
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Wind {
		private float speed;
		private int deg;
		private float gust;
		
	}
	
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Clouds {
		private int all;
		
	}
	
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Sys {
		private int type;
	    private int id;
	    private float message;
	    private String country;
	    private int sunrise;
	    private int sunset;
	}
	
}
