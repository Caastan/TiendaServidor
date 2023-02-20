<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.PrimerTrabajo.bbdd.Consultasrepositorios" %>
<!DOCTYPE html>
	<html>
	<body>
		<h2>En la venta 2 usted ha comprado:</h2>
		<%
		double total= 0;
		int tamanio = (int)request.getAttribute("tamanoproducto");
		
		for(int i = 0; i < tamanio; i++){
			 String nombre = request.getAttribute("nombre"+i).toString();
			 String img = request.getAttribute("img"+i).toString();
			 double precio = (double)request.getAttribute("precio"+i);
			 total +=precio; 
		  	out.println("<p>"+nombre+"  "+ precio+"</p>");
		  	out.println("<img src=" +img+ " width='250' height='150'>");
		  
   		}
   	
		out.println("<h3>El precio total es: "+total+"</h3>");   		
		%>
   		
   		
		
	</body>
	</html>