<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.PrimerTrabajo.bbdd.Consultasrepositorios" %>
<!DOCTYPE html>
	<html>
	<body>
		<a href="cerrarsesion">Cerrar sesion</a>
		<%out.println(request.getSession().getAttribute("login"));%>
		<p>Carrito</p>
	</body>
	</html>