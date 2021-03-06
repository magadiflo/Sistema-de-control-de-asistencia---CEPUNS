/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.controlador.alumno;

import com.empresa.proyecto.entidad.AlumnoBE;
import com.empresa.proyecto.negocio.AlumnoManager;
import com.empresa.proyecto.util.Util;
import com.empresa.proyecto.util.UtilSeguridad;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "AlumnoBuscarServlet", urlPatterns = {"/alumnobuscar"})
public class AlumnoBuscarServlet extends HttpServlet {

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
            out.println("<title>Servlet AlumnoBuscarServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlumnoBuscarServlet at " + request.getContextPath() + "</h1>");
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
        if (UtilSeguridad.estaLogueado(request, response)) {
            String codigo = request.getParameter("codigo");
            String documento = request.getParameter("documento");
            int idMatricula = Util.obtenerValorEntero(request.getParameter("idMatricula"));
            int idMatriculaEspecialidad = Util.obtenerValorEntero(request.getParameter("idMatriculaEspecialidad"));
            int busqueda = Util.obtenerValorEntero(request.getParameter("busqueda"));
            String nombre = request.getParameter("nombre");
            System.out.println("codigo: " + codigo);
            System.out.println("documento: " + documento);
            System.out.println("idMatricula: " + idMatricula);
            System.out.println("idMatriculaEspecialidad: " + idMatriculaEspecialidad);
            System.out.println("nombre: " + nombre);
            AlumnoBE alumno = new AlumnoBE();
            List<AlumnoBE> listaAlumno = null;
            try {
                alumno.setCodigo(codigo);
                alumno.getPersona().setDocumento(documento);
                alumno.getMatriculaEspecialidad().getMatricula().setIdentMatricula(idMatricula);
                alumno.getMatriculaEspecialidad().setIdentMatriculaEspecialidad(idMatriculaEspecialidad);
                alumno.getPersona().setNombres(nombre);
                listaAlumno = new AlumnoManager().obtener(alumno);
                if (listaAlumno.size() > 0) {
                    alumno = listaAlumno.get(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
                alumno = new AlumnoBE();
                listaAlumno = new ArrayList<AlumnoBE>();
            } finally {
                if (busqueda == 1) {
                    Util.retornarJson(alumno, request, response);
                } else {
                    Util.retornarJson(listaAlumno, request, response);
                }

            }
        }

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
