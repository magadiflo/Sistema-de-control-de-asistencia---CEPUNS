/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.controlador.alumno;

import com.empresa.proyecto.entidad.AlumnoBE;
import com.empresa.proyecto.entidad.MatriculaBE;
import com.empresa.proyecto.entidad.MatriculaEspecialidadBE;
import com.empresa.proyecto.entidad.ParametroBE;
import com.empresa.proyecto.negocio.AlumnoManager;
import com.empresa.proyecto.negocio.MatriculaEspecialidadManager;
import com.empresa.proyecto.negocio.MatriculaManager;
import com.empresa.proyecto.negocio.ParametroManager;
import com.empresa.proyecto.util.Util;
import com.empresa.proyecto.util.UtilSeguridad;
import com.empresa.proyecto.util.constante.Constante;
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
@WebServlet(name = "AlumnoEditarServlet", urlPatterns = {"/alumnover"})
public class AlumnoEditarServlet extends HttpServlet {

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
            out.println("<title>Servlet AlumnoEditarServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlumnoEditarServlet at " + request.getContextPath() + "</h1>");
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
            try {
                Util.enviarMensaje(request);
                int idAlumno = Util.obtenerValorEntero(request.getParameter("idAlumno"));

                ParametroBE parametro = new ParametroBE();
                parametro.getParametroTipo().setIdentParametroTipo(ParametroTipoConstante.TIPO_DOCUMENTO);
                List<ParametroBE> tiposDocumento = new ParametroManager().obtener(parametro);

                MatriculaBE matriculaActual = new MatriculaManager().obtenerCicloActual();

                MatriculaEspecialidadBE matriculaEspecialidad = new MatriculaEspecialidadBE();
                matriculaEspecialidad.getMatricula().setIdentMatricula(matriculaActual.getIdentMatricula());
                List<MatriculaEspecialidadBE> listEspecialidades = new MatriculaEspecialidadManager().obtener(matriculaEspecialidad);

                AlumnoBE alumno = new AlumnoBE();
                alumno.setIdentAlumno(idAlumno);
                alumno = new AlumnoManager().obtener(alumno).get(0);

                request.setAttribute("tiposDocumento", tiposDocumento);
                request.setAttribute("matriculaActual", matriculaActual);
                request.setAttribute("listEspecialidades", listEspecialidades);
                request.setAttribute("alumno", alumno);

            } catch (Exception e) {
                e.printStackTrace();
                Util.guardarMensaje(request, Constante.MENSAJE_ERROR);
                Util.enviarMensaje(request);
            }
            request.getRequestDispatcher("alumnoVer.jsp").forward(request, response);

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
