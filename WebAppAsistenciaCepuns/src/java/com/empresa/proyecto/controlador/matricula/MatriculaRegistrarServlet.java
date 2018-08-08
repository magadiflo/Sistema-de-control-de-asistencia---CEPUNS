/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.controlador.matricula;

import com.empresa.proyecto.entidad.EspecialidadBE;
import com.empresa.proyecto.entidad.MatriculaBE;
import com.empresa.proyecto.entidad.MatriculaDiasBE;
import com.empresa.proyecto.entidad.MatriculaEspecialidadBE;
import com.empresa.proyecto.entidad.ParametroBE;
import com.empresa.proyecto.entidad.ProgramacionHorarioBE;
import com.empresa.proyecto.entidad.TurnoBE;
import com.empresa.proyecto.negocio.EspecialidadManager;
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
        if (UtilSeguridad.estaLogueado(request, response)) {
            try {
                Util.enviarMensaje(request);
                ParametroBE filtroCiclo = new ParametroBE();
                filtroCiclo.getParametroTipo().setIdentParametroTipo(ParametroTipoConstante.CICLO);
                List<ParametroBE> ciclos = new ParametroManager().obtener(filtroCiclo);

                List<EspecialidadBE> especialidades = new EspecialidadManager().obtener(new EspecialidadBE());

                request.setAttribute("ciclos", ciclos);
                request.setAttribute("especialidades", especialidades);
            } catch (Exception e) {
                e.printStackTrace();
                Util.guardarMensaje(request, Constante.MENSAJE_ERROR);
                Util.enviarMensaje(request);
            }

            request.getRequestDispatcher("aperturarCiclo.jsp").forward(request, response);
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
            
            String characterSplit = "-";
            String[] idDias = null;
            String[] idEspecialidades = null;
            String[] checkEspecialidades = null;
            String[] fecha_inicio_unidad = null;
            String[] fecha_fin_unidad = null;
            MatriculaDiasBE matriculaDias = null;
            MatriculaEspecialidadBE matriculaEspecialidad = null;
            ProgramacionHorarioBE unidad = null;
            try {
                MatriculaBE matricula = new MatriculaBE();
                matricula.setAnio(Util.obtenerValorEntero(request.getParameter("anio")));
                matricula.getCiclo().setIdentParametro(Util.obtenerValorEntero(request.getParameter("id_004_ciclo")));
                matricula.setLimiteFaltasPorcentaje(Util.obtenerValorEntero(request.getParameter("limite_faltas_porcentaje")));
                matricula.setAsignarPrimerTurnoDefecto(true);

                TurnoBE turno = new TurnoBE();
                turno.setHoraInicio(request.getParameter("hora_inicio"));
                turno.setHoraFin(request.getParameter("hora_fin"));
                matricula.getListTurno().add(turno);

                idDias = request.getParameterValues("dias");
                for (int i = 0; i < idDias.length; i++) {
                    matriculaDias = new MatriculaDiasBE();
                    matriculaDias.getDia().setIdentParametro(Util.obtenerValorEntero(idDias[i]));
                    matricula.addMatriculaDia(matriculaDias);
                }

                checkEspecialidades = request.getParameterValues("checkEspecialidades");
                idEspecialidades = request.getParameterValues("idEspecialidades");
                for (int i = 0; i < checkEspecialidades.length; i++) {
                    if (Constante.CHECKED_ON.equals(checkEspecialidades[i])) {
                        matriculaEspecialidad = new MatriculaEspecialidadBE();
                        matriculaEspecialidad.getEspecialidad().setIdentEspecialidad(Util.obtenerValorEntero(idEspecialidades[i]));
                        matricula.addMatriculaEspecialidad(matriculaEspecialidad);
                    }
                }

                fecha_inicio_unidad = request.getParameterValues("fecha_inicio_unidad_agregada");
                fecha_fin_unidad = request.getParameterValues("fecha_fin_unidad_agregada");
                for (int i = 0; i < fecha_inicio_unidad.length; i++) {
                    unidad = new ProgramacionHorarioBE();
                    unidad.setFechaInicio(Util.obtenerDateFormatoAnioMesDia(fecha_inicio_unidad[i], characterSplit));
                    unidad.setFechaFin(Util.obtenerDateFormatoAnioMesDia(fecha_fin_unidad[i], characterSplit));
                    matricula.addProgramacionHorario(unidad);
                }

                int idMatricula = new MatriculaManager().registrar(matricula);
                
                Util.guardarMensaje(request, Constante.REGISTRO_EXITOSO);
                
            } catch (Exception e) {
                e.printStackTrace();
                Util.guardarMensaje(request, Constante.MENSAJE_ERROR);
            }
            response.sendRedirect(request.getContextPath() + "/aperturarCiclo");
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
