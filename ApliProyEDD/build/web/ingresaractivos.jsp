<%-- 
    Document   : ingresaractivos.jsp
    Created on : 16-mar-2017, 10:36:26
    Author     : Astrid Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Proyecto 1</title>

    <!-- Bootstrap -->
    <link href="./bootstrapp/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body{
            padding-top: 60px;
        }
      </style>  
      <style type="text/css">      
body{
    padding-top: 70px;
    padding-bottom: 40px;
    background-color: #f5f5f5;
}
.form-ingresar{
    max-width: 300px;
    padding: 19px 25px 20px;
    margin: 0 auto 20px;
    background-color: #fff;
    border: 1px solid #e5e5e5;
    -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
            border-radius: 5px;

    -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
        -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            box-shadow: 0 1px 2px rgba(0,0,0, .05);
}

.form-ingresar .form-eliminar-heading,
.form-ingresar .dropdown-menu-right{
margin-bottom: 10px;
}

.form-ingresar input[type="text"],
.form-ingresar input[type="password"]{
font-size: 16px;
heigh: auto;
margin-bottom: 15px;
padding: 7px 9px;
}
</style>
    
      <form class="form-ingresar" action="addActivo" method="post">
          <h2 class="form-eliminar-heading">Ingresar Activo</h2>
          <br><br>

          
   
        <label for="NombreProducto" class="sr-only">Nombre</label>
        <input type="NombreProducto" name="NombreProducto" id="NombreProducto" class="form-control"/>
        <br>
       
      
 <br><br><br><br>
      <form role="form">
        <div class="form-group">
          <textarea class="form-control" name="desActivo" id="desActivo"rows="3"></textarea>
        </div>
          <br>
        <input type="submit" class="btn btn-success" role="button" href="ingresaractivos">
       
      </form>
      <br><br>





      <form>


  </head>
  
<%session.getAttribute("inputUsuario");
session.getAttribute("inputEmpresa");
session.getAttribute("inputContrasena");
session.getAttribute("inputDepartamento");

%>
  <body>
   
      
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Proyecto 1</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="Cuenta.jsp">Cuenta</a></li>
            <li><a href ="ingresaractivos.jsp">Ingresar Activos </a></li>
            <li><a href="eliminar.jsp"> Eliminar Activos </a></li>
            <li><a href="modificar.jsp">Modificar la descripcion de un activo </a></li>
            
            <li><a href ="cerrar.jsp">Cerrar Sesion </a></li>
            
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

      
      
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="./bootstrapp/js/bootstrap.min.js"></script>
  </body>
</html>
