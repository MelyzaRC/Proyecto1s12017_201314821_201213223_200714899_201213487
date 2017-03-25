/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prue;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Astrid Hernandez
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
      
          
          HttpSession session = request.getSession(true);
          String inputUsuario, inputContrasena,inputDepartamento,inputEmpresa;
          inputUsuario = request.getParameter("inputUsuario");
          inputContrasena = request.getParameter("inputContrasena");
          inputEmpresa= request.getParameter("inputEmpresa");
          inputDepartamento= request.getParameter("inputDepartamento");
          String log = Prueba.Login(inputUsuario, inputDepartamento, inputEmpresa, inputContrasena);
 
          
          if(log.equals("Ok")){
              session.setAttribute("inputUsuario",inputUsuario);
         session.setAttribute("inputDepartamento",inputDepartamento);
            session.setAttribute("inputEmpresa",inputEmpresa);
           session.setAttribute("inputContrasena",inputContrasena);
response.sendRedirect("Cuenta.jsp");
          /*session.setAttribute("user", inputUsuario);
          session.setAttribute("contrasena",inputContrasena);
          session.setAttribute("departamento",inputDepartamento);
          session.setAttribute("empresa",inputEmpresa);
          response.sendRedirect("Cuenta.jsp");
          */
      
        }else{
              response.sendRedirect("datos.jsp");
            
          }
    }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
