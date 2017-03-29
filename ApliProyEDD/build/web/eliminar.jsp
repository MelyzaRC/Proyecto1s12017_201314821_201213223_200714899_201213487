<%-- 
    Document   : eliminar.jsp
    Created on : 15-mar-2017, 20:57:51
    Author     : Astrid Hernandez
--%>


<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="prue.Activo"%>
<%@page import="prue.Prueba"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Proyecto 1</title>
  <script type="text/javascript" src="./js/jquery.min.js"></script>
  <script type="text/javascript">
      $(document).ready(function(){
          $("#eliminar-btn").click(function(){
              var indexsel = $('#combo').val();
              var idsel = $('#val_'+indexsel).val();
              $.get('http://192.168.43.81/webapi/api/ArbolB/eliminarActivo',{assetID:idsel})
          });
      })
      
  </script>
 <script type="text/javascript"> 
 $variable = $_POST['combo'];
  </script>
  
  
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
.form-eliminar{
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

.form-eliminar .form-eliminar-heading,
.form-eliminar .dropdown-menu-right{
margin-bottom: 10px;
}

.form-eliminar input[type="text"],
.form-eliminar input[type="password"]{
font-size: 16px;
heigh: auto;
margin-bottom: 15px;
padding: 7px 9px;
}
</style>

<%
    ArrayList<Activo> lista = new ArrayList<Activo>();
    try{
        String inputUsuario, inputContrasena,inputDepartamento,inputEmpresa;
        inputUsuario = (String)session.getAttribute("inputUsuario");
        inputDepartamento = (String)session.getAttribute("inputDepartamento");
        inputEmpresa = (String)session.getAttribute("inputEmpresa");
        inputContrasena = (String)session.getAttribute("inputContrasena");

        String devolver = Prueba.Devolver(inputUsuario, inputDepartamento, inputEmpresa, inputContrasena);
        JSONParser parser = new JSONParser();

        if(!devolver.isEmpty()){
            lista = new ArrayList<Activo>();
            Object obj = parser.parse(devolver);//(String)session.getAttribute("txtjson"));
            JSONObject jsonObject =(JSONObject) obj;

            JSONArray tag = (JSONArray) jsonObject.get("activos");
            for(int i=0; i<tag.size();i++){
                JSONObject tagi = (JSONObject) tag.get(i);
                String id = (String)tagi.get("id");

                String nombre = (String) tagi.get("nombre");

                String descripcion = (String) tagi.get("descripcion");

                String estado = (String) tagi.get("estado");



                System.out.println("id:"+id);
                System.out.println("nombre:"+nombre);
                System.out.println("descripcion:"+descripcion);
                System.out.println("estado:"+estado);

                Activo act = new Activo(descripcion, id, nombre, estado);
                lista.add(act);
                
            }
            System.out.println("listaid:"+lista);
            session.setAttribute("lista", lista);
            
        }
    } catch(Exception ex){
        
    }
 %>     
      <form class="form-eliminar" method="post" action="eliminar">
          <h2 class="form-eliminar-heading">Eliminar Activos</h2>
          <br><br>
          
<% 
       for(int i=0; i<lista.size();i++){
   
          out.println("<input type='hidden' name='val_"+i+"' id='val_"+i+"' value='"+lista.get(i).getId()+"' />");
       }
   %> 
       
<select name="combo" ID="combo" onchange=""> 
    <% 
       for(int i=0; i<lista.size();i++){
   
          out.println("<option value='"+i+"'>"+lista.get(i).getId()+"</option>");
       }
   %>  

           
   
 
</select>
   <head>
   <script type="text/javascript">
       $('#combo').change(function() {
            opt = $(this).val();
            <% 
                
                for(int i=0; i<lista.size();i++){
                    if(i!=0){
                        out.println("else ");
                    }
                    out.println("if (opt=='"+i+"') { $('#descripcionActivo').val('"+lista.get(i).getDescripcion()+"'); $('#nombreActivo').html('"+lista.get(i).getNombre()+"'); }");
                }
            %>
        });
   
   </script>
   </head>
 
 
       
        
   
  </ul>
</div>
        
    
      
 <br><br><br><br>
 
 
 

      <form role="form"  >
        <div class="form-group">
            <span id="nombreActivo" class="form-control"></span>
            <br><br>
          <textarea id="descripcionActivo" class="form-control" rows="3"></textarea>
        </div>
          <br>
          
    
          
         
        <input class="btn btn-success" id="eliminar-btn" type="submit">
         <br><br>
         
              
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
          <a class="navbar-brand" href="#"><%out.println("USUARIO:"+session.getAttribute("inputUsuario"));%></a>
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