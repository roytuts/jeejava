package com.roytuts.springjspservlet.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.roytuts.springjspservlet.model.Todo;
import com.roytuts.springjspservlet.service.ToDoService;

@WebServlet("/todos")
public class ToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//We have already configured in applicationContext.xml for annotation
	@Autowired
	private ToDoService toDoService;
	
	//Spring ApplicationContext to get the beans
	private WebApplicationContext webApplicationContext;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ToDoServlet() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// get Spring ApplicationContext
		webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
		// get the bean from ApplicationContext
		toDoService = (ToDoService) webApplicationContext.getBean("todoService");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get the data from source using Spring Service
		List<Todo> todos = toDoService.getToDos();
		// set the returned data to the variable for later use
		request.setAttribute("todos", todos);
		// forward the response to the jsp page
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
