/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.controlador.matricula;

import com.empresa.proyecto.entidad.EspecialidadBE;
import com.empresa.proyecto.entidad.ParametroBE;
import com.empresa.proyecto.negocio.EspecialidadManager;
import com.empresa.proyecto.negocio.ParametroManager;
import com.empresa.proyecto.util.constante.ParametroTipoConstante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author VICTOR
 */
@WebServlet(name = "MatriculaRegistrarServlet", urlPatterns = {"/aperturarCiclo"})
public class MatriculaRegistrarServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MatriculaRegistrarServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MatriculaRegistrarServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        ParametroBE filtroCiclo = new ParametroBE();
        filtroCiclo.getParametroTipo().setIdentParametroTipo(ParametroTipoConstante.CICLO);
        List<ParametroBE> ciclos = new ParametroManager().obtener(filtroCiclo);
        
        List<EspecialidadBE> especialidades = new EspecialidadManager().obtener(new EspecialidadBE());
        
        request.setAttribute("ciclos", ciclos);
        request.setAttribute("especialidades", especialidades);
        request.getRequestDispatcher("aperturarCiclo.jsp").forward(request, response);
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
