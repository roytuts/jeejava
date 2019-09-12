package com.roytuts.cache.resource.enums;

public enum Cacheability {

	PUBLIC("public"),

	PRIVATE("private");

	private String value;

	private Cacheability(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}
