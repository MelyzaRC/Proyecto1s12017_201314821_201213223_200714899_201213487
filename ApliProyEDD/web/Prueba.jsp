<%-- 
    Document   : Prueba.jsp
    Created on : 20-mar-2017, 22:47:03
    Author     : Astrid Hernandez
--%>

<%@page import="prue.Prueba"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%!
           String Nombre ;
           String NombreUsuario;
           String Contrasena;
           String Empresa;
           String Departamento;
           
           %>
           <%Nombre=request.getParameter("Nombre");
           NombreUsuario=request.getParameter("NombreUsuario");
           Contrasena=request.getParameter("Contrasena");
           Empresa=request.getParameter("Empresa");
           Departamento=request.getParameter("Departamento");
           String hola = Prueba.Matriz(NombreUsuario, Departamento, Empresa, Contrasena, Nombre);
           %>
         
    </body>
</html>
