package com.jeejava.cache.resource.enums;

public enum CacheConfigParameter {

	STATIC("static"),

	PRIVATE("private"),

	EXPIRATION_TIME("expirationTime");

	private String name;

	private CacheConfigParameter(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
