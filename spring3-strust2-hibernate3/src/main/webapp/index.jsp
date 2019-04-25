<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String ctx = request.getContextPath();
	response.sendRedirect(ctx + "/retrieveCds");
%>