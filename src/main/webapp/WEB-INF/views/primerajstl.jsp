<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.PrimerTrabajo.bbdd.Consultasrepositorios" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
	<a href="cerrarsesion">Cerrar sesion</a>
	
	<%out.println(request.getSession().getAttribute("login"));%>
   <h1>PRODUCTOS PRINTADOS POR JSTL</h1>
   
   
   
   
		<c:set var="lista" value="${requestScope.lista}" />

		<c:forEach var="producto" items="${lista}">
 		  <img src="${producto['url']}" width='250' height='150'><br>
		  <p>Nombre: ${producto['nombre']}</p>
		  <p>Precio: ${producto['precio']}</p>
		  <br>
		</c:forEach>
   
   
   
   
   

</body>
</html>