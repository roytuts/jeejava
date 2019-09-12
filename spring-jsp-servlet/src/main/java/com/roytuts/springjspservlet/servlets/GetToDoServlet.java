package com.roytuts.springjspservlet.servlets;

import java.io.IOException;

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
import com.roytuts.springjspservlet.utils.Utils;

@WebServlet("/todo")
public class GetToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ToDoService toDoService;

	private WebApplicationContext webApplicationContext;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetToDoServlet() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
		toDoService = (ToDoService) webApplicationContext.getBean("todoService");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		boolean isInt = Utils.isInteger(id);
		if (isInt) {
			Todo todo = toDoService.getToDo(id);
			if (todo == null) {
				request.setAttribute("error", "No ToDo found for this id: " + id);
			} else {
				request.setAttribute("todo", todo);
			}
		} else {
			request.setAttribute("error", "id must be an integer value.");
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
		requestDispatcher.forward(request, response);
	}

}
