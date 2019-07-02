package com.jeejava.cache.resource.enums;

public enum HTTPCacheHeader {

	CACHE_CONTROL("Cache-Control"),

	EXPIRES("Expires"),

	PRAGMA("Pragma"),

	ETAG("ETag");

	private String name;

	private HTTPCacheHeader(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
