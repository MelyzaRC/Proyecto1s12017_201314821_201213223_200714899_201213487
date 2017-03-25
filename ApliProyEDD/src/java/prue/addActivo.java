/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prue;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Astrid Hernandez
 */
public class addActivo extends HttpServlet {

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
           List lista = new ArrayList();
            HttpSession session = request.getSession(true);
          String inputUsuario, inputContrasena,inputDepartamento,inputEmpresa,id,nombreProducto,descripcionActivo;
         /* inputUsuario = request.getParameter("inputUsuario");
          inputContrasena = request.getParameter("inputContrasena");
          inputEmpresa= request.getParameter("inputEmpresa");
          inputDepartamento= request.getParameter("inputDepartamento");*/
          
          /*session.setAttribute("user", inputUsuario);
          session.setAttribute("contrasena",inputContrasena);
          session.setAttribute("departamento",inputDepartamento);
          session.setAttribute("empresa",inputEmpresa);*/
               
         inputUsuario = (String)session.getAttribute("inputUsuario");
           inputDepartamento = (String)session.getAttribute("inputDepartamento");
             inputEmpresa = (String)session.getAttribute("inputEmpresa");
               inputContrasena = (String)session.getAttribute("inputContrasena");
          /*
           inputUsuario = (String)request.getSession().getAttribute("inputUsuario");
           inputContrasena = (String)request.getSession().getAttribute("inputContrasena");
           inputEmpresa = (String)request.getSession().getAttribute("inputEmpresa");
           inputDepartamento = (String)request.getSession().getAttribute("inputDepartamento");*/
        
        
          nombreProducto = request.getParameter("NombreProducto");
           descripcionActivo = request.getParameter("desActivo");
          
          String activo = Prueba.Activo(inputUsuario, inputDepartamento, inputEmpresa, inputContrasena,nombreProducto,descripcionActivo);
      response.sendRedirect("ingresaractivos.jsp");
      
      session.setAttribute("NombreProducto",nombreProducto);
      session.setAttribute("desActivo",descripcionActivo);
     
    
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
