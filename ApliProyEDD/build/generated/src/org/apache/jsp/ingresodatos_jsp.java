package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import prue.Prueba;

public final class ingresodatos_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n");
      out.write("    <title>Proyecto 1</title>\n");
      out.write("\n");
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
      out.write(".form-signin{\n");
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
      out.write(".form-signin .form-signin-heading,\n");
      out.write(".form-signin .checkbox{\n");
      out.write("margin-bottom: 10px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".form-signin input[type=\"text\"],\n");
      out.write(".form-signin input[type=\"password\"]{\n");
      out.write("font-size: 16px;\n");
      out.write("heigh: auto;\n");
      out.write("margin-bottom: 15px;\n");
      out.write("padding: 7px 9px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("    \n");
      out.write("   \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  </head>\n");
      out.write("  \n");
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
      out.write("            <li class=\"active\"><a href=\"login.jsp\">Iniciar Sesion</a></li>\n");
      out.write("            <li><a href=\"ingresodatos.jsp\">Ingresar Datos </a></li>\n");
      out.write("           \n");
      out.write("          </ul>\n");
      out.write("        </div><!--/.nav-collapse -->\n");
      out.write("      </div>\n");
      out.write("    </nav>\n");
      out.write("     \n");
      out.write("    \n");
      out.write("  \n");
      out.write("  <form class=\"form-signin\" method=\"post\" action=\"AgreUsu\">\n");
      out.write("        <h2 class=\"form-signin-heading\">Registro de Datos</h2>\n");
      out.write("        <label for=\"Nombre\" class=\"sr-only\">Nombre Completo</label>\n");
      out.write("        <input type=\"Nombre\" id=\"Nombre\" name=\"Nombre\" class=\"form-control\" placeholder=\"Nombre Completo\" >\n");
      out.write("        <br>\n");
      out.write("        <label for=\"NombreUsuario\" class=\"sr-only\">Usuario</label>\n");
      out.write("        <input type=\"NombreUsuario\" name=\"NombreUsuario\" id=\"NombreUsuario\" class=\"form-control\" placeholder=\"Nombre Usuario\" >\n");
      out.write("     \n");
      out.write("        <br>\n");
      out.write("        <label for=\"Contrasena\" class=\"sr-only\">Contraseña</label>\n");
      out.write("        <input type=\"Contrasena\" name=\"Contrasena\" id=\"Contrasena\" class=\"form-control\" placeholder=\"Contrasena\" >\n");
      out.write("        \n");
      out.write("        <br>\n");
      out.write("        <label for=\"Empresa\" class=\"sr-only\">Empresa</label>\n");
      out.write("        <input type=\"Empresa\" name=\"Empresa\" id=\"Empresa\" class=\"form-control\" placeholder=\"Empresa\" >\n");
      out.write("        \n");
      out.write("        <br>\n");
      out.write("        <label for=\"Departamento\" class=\"sr-only\">Departamento</label>\n");
      out.write("        <input type=\"Departamento\" name=\"Departamento\" id=\"Departamento\" class=\"form-control\" placeholder=\"Departamento\">\n");
      out.write("       \n");
      out.write("        \n");
      out.write("           <input href=\"login.jsp\" class=\"btn btn-lg btn-primary btn-disabled\" type=\"submit\" role=\"button\">\n");
      out.write("      </form> \n");
      out.write("      \n");
      out.write("      \n");
      out.write("      \n");
      out.write("\n");
      out.write("    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("    <!-- Include all compiled plugins (below), or include individual files as needed -->\n");
      out.write("    <script src=\"./bootstrapp/js/bootstrap.min.js\"></script>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
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
