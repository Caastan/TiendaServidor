<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.PrimerTrabajo.bbdd.Consultasrepositorios" %>
<!DOCTYPE html>
<html>
<body>
	<a href="cerrarsesion">Cerrar sesion</a>
	
	<%out.println(request.getSession().getAttribute("login"));%>
   <h1>Principal</h1>
   
   <% for(int i = 0; i < (int)request.getAttribute("tamanoProductos"); i++){
	   String url = request.getAttribute("url"+i).toString();
	   String nombre = request.getAttribute("nombre"+i).toString();
	   double precio = (double)request.getAttribute("precio"+i);
	   int id = (int) request.getAttribute("id"+i);
	   out.println("<div><img src="+url+" width='250' height='150'><br>"+nombre+" "+precio);
	   out.println("<input type='button' name="+id+" value='Añadir al carrito' onclick='anadircarrito("+id+","+nombre+","+precio+")'><div><br>");
   }
   
   %>
   
   
   
   
   
   <a href="primerajstl">Ver Productos en JSTL</a>
   
   <br><br>
   
   <a href="ventaId">Ver Ventas por JSTL</a>
   

</body>
</html>