<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.PrimerTrabajo.bbdd.Consultasrepositorios" %>
<!DOCTYPE html>
<html>
<body>
   <h1>Login</h1>
   
   <form name='f' action="primera" method='GET'>
      <table>
         <tr>
            <td>Usuario:</td>
            <td><input type='text' name='usuario'></td>
         </tr>
         <tr>
            <td>Clave:</td>
            <td><input type='password' name='contrasena' /></td>
         </tr>
         <% if(request.getAttribute("error") != null) {out.println(request.getAttribute("error"));} %>
         <tr>
            <td><input name="enviar" type="submit" value="Enviar" /></td>
         </tr>
      </table>
  </form>
</body>
</html>