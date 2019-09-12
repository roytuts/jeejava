package com.roytuts.springjspservlet.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.roytuts.springjspservlet.dao.TodoDao;
import com.roytuts.springjspservlet.model.Todo;
import com.roytuts.springjspservlet.service.ToDoService;

public class ToDoServiceImpl implements ToDoService {

	@Override
	public List<Todo> getToDos() {
		List<Todo> todos = new ArrayList<>();
		todos.addAll(TodoDao.instance.getModel().values());
		return todos;
	}

	@Override
	public Todo getToDo(String id) {
		Todo todo = TodoDao.instance.getModel().get(id);
		return (todo != null ? todo : null);
	}

}
