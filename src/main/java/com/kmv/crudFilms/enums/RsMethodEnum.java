package com.kmv.crudFilms.enums;


public enum RsMethodEnum {
	GET("GET"), POST("POST"), PUT("PUT"), DELETE("DELETE");

	private final String value;

	private RsMethodEnum(String value) {
	this.value = value;
	}

	/**
	* @return the value
	*/
	public String getValue() {
	return value;
	}
}
