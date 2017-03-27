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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Astrid Hernandez
 */
public class p extends HttpServlet {

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
            List lista = new ArrayList();
            String inputUsuario, inputContrasena,inputDepartamento,inputEmpresa;
         inputUsuario = (String)session.getAttribute("inputUsuario");
           inputDepartamento = (String)session.getAttribute("inputDepartamento");
             inputEmpresa = (String)session.getAttribute("inputEmpresa");
               inputContrasena = (String)session.getAttribute("inputContrasena");
          String devolver = Prueba.Devolver(inputUsuario, inputDepartamento, inputEmpresa, inputContrasena);
     
         
          
          
          
          
          
          
          
          session.setAttribute("txtjson",devolver);
            System.out.println("c"+devolver);
          response.sendRedirect("eliminar.jsp");
          /*Json json = new Json();
          json.metodo((String) session.getAttribute("txtjson"));
           */
       
/*  JSONParser parser = new JSONParser();
          try{
              Object obj = parser.parse((String)session.getAttribute("txtjson"));
              JSONObject jsonObject =(JSONObject) obj;
       
             /* String id = (String) jsonObject.get("id");
              System.out.println("i:"+id);
              String nombre = (String) jsonObject.get("nombre");
              System.out.println("n:"+nombre);
            */
              
            
         /*     JSONArray tag = (JSONArray) jsonObject.get("Activos");
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
                 
           
             lista.add(id);
                 System.out.println("listaid:"+lista);
                 
                String deli = "[\\[\\],]+";
             String[] idArray= lista.toString().split(deli);
                  
                  for (String idArray1 : idArray) {
                      System.out.println(idArray1);
                

                    
                   //   session.setAttribute("idArray1",idArray1);
                  }
                 
            
                 
                  /* System.out.println("Activos");
                  Iterator iterator = tag.iterator();
                  while(iterator.hasNext()){
                  System.out.println(iterator.next());
                  Activo activo = new Activo();
                  System.out.println("1"+activo.nombre);
                  System.out.println("2"+activo.id);
                   */
                  
                  
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
