/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.controlador.asistencia;

import com.empresa.proyecto.entidad.AsistenciaBE;
import com.empresa.proyecto.entidad.AsistenciaDetalleBE;
import com.empresa.proyecto.entidad.MatriculaBE;
import com.empresa.proyecto.negocio.AsistenciaDetalleManager;
import com.empresa.proyecto.negocio.AsistenciaManager;
import com.empresa.proyecto.negocio.MatriculaManager;
import com.empresa.proyecto.util.Util;
import com.empresa.proyecto.util.UtilSeguridad;
import com.empresa.proyecto.util.constante.Constante;
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
@WebServlet(name = "AsistenciaFechaServlet", urlPatterns = {"/asistenciaFecha"})
public class AsistenciaFechaServlet extends HttpServlet {

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
            out.println("<title>Servlet AsistenciaFechaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AsistenciaFechaServlet at " + request.getContextPath() + "</h1>");
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
                int idMatricula = Util.obtenerValorEntero(request.getParameter("idMatricula"));
                MatriculaBE matricula = new MatriculaBE();
                AsistenciaBE asistencia = new AsistenciaBE();
                asistencia.getProgramacionHorario().getMatricula().setIdentMatricula(idMatricula);
                List<AsistenciaBE> listaAsistencia = new ArrayList<AsistenciaBE>();
                if (idMatricula != 0) {
                    matricula = new MatriculaManager().obtener(new MatriculaBE(idMatricula)).get(0);
                    listaAsistencia = new AsistenciaManager().obtener(asistencia);
                }

                request.setAttribute("matricula", matricula);
                request.setAttribute("listaAsistencia", listaAsistencia);

            } catch (Exception e) {
                e.printStackTrace();
                Util.guardarMensaje(request, Constante.MENSAJE_ERROR);
                Util.enviarMensaje(request);
            }
            request.getRequestDispatcher("asistenciaSeleccionarFecha.jsp").forward(request, response);
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
        if (UtilSeguridad.estaLogueado(request, response)) {
            try {
                String fecha = request.getParameter("fecha");
                int idAsistencia = new AsistenciaManager().obtenerAsistenciaPorFecha(fecha);
                if (idAsistencia == 0) {
                    request.getSession().setAttribute("mensaje", "No existe una asistencia para la fecha indicada");
                    response.sendRedirect(request.getContextPath() + "/asistenciaFecha");
                } else {
                    response.sendRedirect(request.getContextPath() + "/asistenciaRegistrar?idasistencia=" + idAsistencia);
                }
            } catch (Exception e) {
                e.printStackTrace();
                Util.guardarMensaje(request, Constante.MENSAJE_ERROR);
                response.sendRedirect(request.getContextPath() + "/asistenciaFecha");
            }

        }

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
