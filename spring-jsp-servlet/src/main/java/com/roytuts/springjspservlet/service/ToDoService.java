package com.roytuts.springjspservlet.service;

import java.util.List;

import com.roytuts.springjspservlet.model.Todo;

public interface ToDoService {

	List<Todo> getToDos();

	Todo getToDo(String id);
}
