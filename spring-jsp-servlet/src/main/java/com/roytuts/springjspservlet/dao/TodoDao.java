package com.roytuts.springjspservlet.dao;

import java.util.HashMap;
import java.util.Map;

import com.roytuts.springjspservlet.model.Todo;

public enum TodoDao {

	instance;
	private Map<String, Todo> contentProvider = new HashMap<String, Todo>();

	private TodoDao() {
		Todo todo1 = new Todo();
		Todo todo2 = new Todo();
		todo1.setId("0001");
		todo1.setDesc("Todo One");
		todo2.setId("0002");
		todo2.setDesc("Todo Two");
		contentProvider.put(todo1.getId(), todo1);
		contentProvider.put(todo2.getId(), todo2);
	}

	public Map<String, Todo> getModel() {
		return contentProvider;
	}

}
