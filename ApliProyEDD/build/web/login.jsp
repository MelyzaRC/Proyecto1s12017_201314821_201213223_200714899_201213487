<%-- 
    Document   : login.jsp
    Created on : 15-mar-2017, 18:00:16
    Author     : Astrid Hernandez
--%>

<%@page import="prue.Prueba"%>
<%@page session="true"%>
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
.form-signin{
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

.form-signin .form-signin-heading,
.form-signin .checkbox{
margin-bottom: 10px;
}

.form-signin input[type="text"],
.form-signin input[type="password"]{
font-size: 16px;
heigh: auto;
margin-bottom: 15px;
padding: 7px 9px;
}
</style>
  
   









  </head>  

   

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
            <li class="active"><a href="login.jsp">Iniciar Sesion</a></li>
            <li><a href="ingresodatos.jsp">Ingresar Datos </a></li>
            
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
   
      

   
     
      <form class="form-signin" method="post" action="Login">
        <h2 class="form-signin-heading">Iniciar Sesion</h2>
        <label for="inputUsuario" class="sr-only">Usuario</label>
        <input type="usuario" id="inputUsuario" name="inputUsuario" value="" class="form-control" placeholder="Nombre Usuario" required autofocus>
        
        <br>
        <label for="inputContrasena" class="sr-only">Contraseña</label>
        <input type="contrasena" id="inputContrasena" name="inputContrasena" value="" class="form-control" placeholder="Contrasena" required>
        
        <br>
         <label for="inputEmpresa" class="sr-only">Empresa</label>
        <input type="empresa" id="inputEmpresa" value="" name="inputEmpresa" class="form-control" placeholder="Empresa" required autofocus>
        
        <br>
        <label for="inputDepartamento" class="sr-only">Departamento</label>
        <input type="departamento" id="inputDepartamento" name="inputDepartamento" value="" class="form-control" placeholder="Departamento" required>
        
        <br>
        
        <input class="btn btn-lg btn-primary btn-" value="submit" type="submit" role="button">
        
       
      </form> 
       
   
      
      
      

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="./bootstrapp/js/bootstrap.min.js"></script>
  </body>
</html>
