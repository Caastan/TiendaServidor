<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.PrimerTrabajo.bbdd.Consultasrepositorios" %>
<!DOCTYPE html>
	<html>
	<body>
	
		<a href="cerrarsesion">Cerrar sesion</a>
		<%out.println(request.getSession().getAttribute("login"));%>
		<h1>Ventas</h1>
		
		   <% for(int i = 0; i < (int)request.getAttribute("tamanoVentas"); i++){
			   int id = (int) request.getAttribute("id"+i);
			   String nombre = request.getAttribute("nombre"+i).toString();
			   String direccion = request.getAttribute("direccion"+i).toString();
			   String municipio = request.getAttribute("municipio"+i).toString();
			   String provincia = request.getAttribute("provincia"+i).toString();
			   int cod_postal = (int)request.getAttribute("cod_postal"+i);
			   int telefono = (int)request.getAttribute("telefono"+i);
			   
		   
		   out.println("<div><h2>Venta"+id+"</h2><br>" +nombre+" "+direccion+" "+municipio+" "+provincia+" "+cod_postal+" "+telefono+" <a href='producto"+id+"'>Venta"+ id+" productos</a><br />");
		   out.println("<div><h2>Venta"+id+"</h2><br>" +nombre+" "+direccion+" "+municipio+" "+provincia+" "+cod_postal+" "+telefono+" <a href='producto?idVenta="+id+"'>Venta"+ id+" productos</a>");
   		}
   
   		%>

		
   		
		
	</body>
	</html>