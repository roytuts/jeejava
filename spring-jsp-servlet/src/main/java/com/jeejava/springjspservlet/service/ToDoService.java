package com.jeejava.springjspservlet.service;

import java.util.List;

import com.jeejava.springjspservlet.model.Todo;

public interface ToDoService {

	List<Todo> getToDos();

	Todo getToDo(String id);
}
