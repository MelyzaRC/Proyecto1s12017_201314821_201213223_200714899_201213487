package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.List;
import java.util.ArrayList;
import prue.Activo;
import prue.Prueba;

public final class modificar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n");
      out.write("    <title>Proyecto 1</title>\n");
      out.write("  <script type=\"text/javascript\" src=\"./js/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write(" <script type=\"text/javascript\"> \n");
      out.write(" $variable = $_POST['combo'];\n");
      out.write("  </script>\n");
      out.write("  \n");
      out.write("  \n");
      out.write("    <!-- Bootstrap -->\n");
      out.write("    <link href=\"./bootstrapp/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <style>\n");
      out.write("        body{\n");
      out.write("            padding-top: 60px;\n");
      out.write("        }\n");
      out.write("      </style>  \n");
      out.write("      <style type=\"text/css\">      \n");
      out.write("body{\n");
      out.write("    padding-top: 70px;\n");
      out.write("    padding-bottom: 40px;\n");
      out.write("    background-color: #f5f5f5;\n");
      out.write("}\n");
      out.write(".form-eliminar{\n");
      out.write("    max-width: 300px;\n");
      out.write("    padding: 19px 25px 20px;\n");
      out.write("    margin: 0 auto 20px;\n");
      out.write("    background-color: #fff;\n");
      out.write("    border: 1px solid #e5e5e5;\n");
      out.write("    -webkit-border-radius: 5px;\n");
      out.write("        -moz-border-radius: 5px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("\n");
      out.write("    -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);\n");
      out.write("        -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);\n");
      out.write("            box-shadow: 0 1px 2px rgba(0,0,0, .05);\n");
      out.write("}\n");
      out.write("\n");
      out.write(".form-eliminar .form-eliminar-heading,\n");
      out.write(".form-eliminar .dropdown-menu-right{\n");
      out.write("margin-bottom: 10px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".form-eliminar input[type=\"text\"],\n");
      out.write(".form-eliminar input[type=\"password\"]{\n");
      out.write("font-size: 16px;\n");
      out.write("heigh: auto;\n");
      out.write("margin-bottom: 15px;\n");
      out.write("padding: 7px 9px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");

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
 
      out.write("     \n");
      out.write("      <form class=\"form-eliminar\" method=\"post\" action=\"p\">\n");
      out.write("          <h2 class=\"form-eliminar-heading\">Eliminar Activos</h2>\n");
      out.write("          <br><br>\n");
      out.write("          \n");
      out.write("\n");
      out.write("       \n");
      out.write("<select name=\"combo\" ID=\"combo\" onchange=\"\"> \n");
      out.write("    ");
 
       for(int i=0; i<lista.size();i++){
   
          out.println("<option value='"+i+"'>"+lista.get(i).getId()+"</option>");
       }
   
      out.write("  \n");
      out.write("\n");
      out.write("           \n");
      out.write("   \n");
      out.write(" \n");
      out.write("</select>\n");
      out.write("   <head>\n");
      out.write("   <script type=\"text/javascript\">\n");
      out.write("       $('#combo').change(function() {\n");
      out.write("            opt = $(this).val();\n");
      out.write("            ");
 
                
                for(int i=0; i<lista.size();i++){
                    if(i!=0){
                        out.println("else ");
                    }
                    out.println("if (opt=='"+i+"') { $('#descripcionActivo').val('"+lista.get(i).getDescripcion()+"'); $('#nombreActivo').html('"+lista.get(i).getNombre()+"'); }");
                }
            
      out.write("\n");
      out.write("        });\n");
      out.write("   \n");
      out.write("   </script>\n");
      out.write("   </head>\n");
      out.write(" \n");
      out.write(" \n");
      out.write("       \n");
      out.write("        \n");
      out.write("   \n");
      out.write("  </ul>\n");
      out.write("</div>\n");
      out.write("        \n");
      out.write("    \n");
      out.write("      \n");
      out.write(" <br><br><br><br>\n");
      out.write(" \n");
      out.write(" \n");
      out.write(" \n");
      out.write("\n");
      out.write("      <form role=\"form\"  >\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <span id=\"nombreActivo\" class=\"form-control\"></span>\n");
      out.write("            <br><br>\n");
      out.write("          <textarea id=\"descripcionActivo\" class=\"form-control\" rows=\"3\"></textarea>\n");
      out.write("        </div>\n");
      out.write("          <br>\n");
      out.write("          \n");
      out.write("    \n");
      out.write("          \n");
      out.write("         \n");
      out.write("        <input class=\"btn btn-success\" id=\"eliminar-btn\" type=\"submit\">\n");
      out.write("         <br><br>\n");
      out.write("         \n");
      out.write("              \n");
      out.write("      <br><br>\n");
      out.write("   \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("      <form>\n");
      out.write("\n");
      out.write("\n");
      out.write("  </head>\n");
session.getAttribute("inputUsuario");
session.getAttribute("inputEmpresa");
session.getAttribute("inputContrasena");
session.getAttribute("inputDepartamento");







      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  <body>\n");
      out.write("   \n");
      out.write("      \n");
      out.write("    <nav class=\"navbar navbar-inverse navbar-fixed-top\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"navbar-header\">\n");
      out.write("          <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n");
      out.write("            <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("          </button>\n");
      out.write("          <a class=\"navbar-brand\" href=\"#\">Proyecto 1</a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"navbar\" class=\"collapse navbar-collapse\">\n");
      out.write("          <ul class=\"nav navbar-nav\">\n");
      out.write("            <li class=\"active\"><a href=\"Cuenta.jsp\">Cuenta</a></li>\n");
      out.write("            <li><a href =\"ingresaractivos.jsp\">Ingresar Activos </a></li>\n");
      out.write("            <li><a href=\"eliminar.jsp\"> Eliminar Activos </a></li>\n");
      out.write("            <li><a href=\"modificar.jsp\">Modificar la descripcion de un activo </a></li>\n");
      out.write("            \n");
      out.write("            <li><a href =\"cerrar.jsp\">Cerrar Sesion </a></li>\n");
      out.write("            \n");
      out.write("          </ul>\n");
      out.write("        </div><!--/.nav-collapse -->\n");
      out.write("      </div>\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("      \n");
      out.write("      \n");
      out.write("    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("    <!-- Include all compiled plugins (below), or include individual files as needed -->\n");
      out.write("    <script src=\"./bootstrapp/js/bootstrap.min.js\"></script>\n");
      out.write("  </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
