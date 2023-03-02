<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.PrimerTrabajo.bbdd.Consultasrepositorios" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
	<html>
	<body>
	
		<a href="cerrarsesion">Cerrar sesion</a>
		<%out.println(request.getSession().getAttribute("login"));%>
		<h1>Ventas filtradas por id</h1>
		
		
		<c:set var="lista" value="${requestScope.lista}" />

		<c:forEach var="venta" items="${lista}">
 		  <p>Id: ${venta['id']}</p>
		  <p>Nombre: ${venta['nombre']}</p>
		  <p>Direccion: ${venta['direccion']}</p>
		  <p>Municipio: ${venta['municipio']}</p>
		  <p>Provincia: ${venta['provincia']}</p>
		  <p>Codigo Postal: ${venta['codigo_postal']}</p>
		  <p>Telefono: ${venta['telefono']}</p>
		  <p>Precio: ${venta['precio']}</p>
		  <br>
		</c:forEach>
		
   		
		
	</body>
	</html>