/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.controlador.login;

import com.empresa.proyecto.entidad.UsuarioBE;
import com.empresa.proyecto.negocio.LoginManager;
import com.empresa.proyecto.util.Util;
import com.empresa.proyecto.util.constante.Constante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author VICTOR
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        Util.enviarMensaje(request);
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
        //processRequest(request, response);
        String nombreCookie = Constante.COOKIE_DE_ESPERA;
        UsuarioBE usuario = new UsuarioBE();
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        System.out.println("USER: " + user);        
        System.out.println("PASS: " + pass);
        /*
            Validar si esta esperando los 5 minutos, por haber fallado 3 veces
         */
        boolean esperaPorFallidos = validarEsperaPorFallidos(request, nombreCookie);
        if (esperaPorFallidos) {
            //Enviamos el atributo mensaje, que sera utilizado en el JSP login.jsp
            request.getSession().setAttribute("mensaje", Constante.MENSAJE_ESPERA_COOKIE);
            //Redireccionamos al login.jsp
            //request.getRequestDispatcher("login.jsp").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            /*
                Logica si no tiene 3 intentos fallidos
             */
            //Obtenemos los valores del formulario
            usuario.setCuenta(user);
            usuario.setPassword(pass);
            
            //Validamos si son las credenciales correctas (Aqui hariamos una llamada a base de datos para validar)
            usuario = new LoginManager().validarLogin(usuario);
            if (usuario.getIdentUsuario() > 0) {
                //Reiniciar los intentos fallidos a 0
                request.getSession().setAttribute("intentosFallidos", "0");
                //Enviar un mensaje que mostraremos con ayuda de javascript en la vista JSP (En index.jsp)
                Util.guardarMensaje(request, "Bienvenido " + usuario.getCuenta());
                //request.getSession().setAttribute("mensaje", "Bienvenido " + usuario.getCuenta());
                //Guardamos al usuario logueado en sesion:
                request.getSession().setAttribute(Constante.USUARIO_LOGUEADO, usuario);
                //Redireccional a la vista index.jsp. Importante redireccionar de esta forma.
                //request.getRequestDispatcher("index.jsp").forward(request, response);
                response.sendRedirect(request.getContextPath() + "/home");
            } else {
                /*
                    Aumentamos los intentos fallidos
                */
                // --Inicio aumentar intentos--
                String intentosFallidos = (String) request.getSession().getAttribute("intentosFallidos");
                int fallidos = 0;
                if (intentosFallidos != null) {
                    fallidos = Integer.parseInt(intentosFallidos);
                }
                request.getSession().setAttribute("intentosFallidos", String.valueOf(++fallidos));
                // --Fin aumentar intentos--
                /*
                    Si llego a los 3 intentos fallidos: Creamos la cookie de espera.
                */
                // --Inicio Crear cookie--
                if(fallidos >= 3){
                    Cookie cookieEspera = new Cookie(nombreCookie, "");
                    //Le asignamos un tiempo de vida a la cookie
                    
                    cookieEspera.setMaxAge(60*5); //60 segundos * 5 = 5 minutos
                    //cookieEspera.setMaxAge(60); //60 segundos = 1 minutp (Si quiere esperar 1 minuto, comentar la linea de arriba y descomentar esta linea)
                    response.addCookie(cookieEspera);
                    //Reiniciamos los intentos a 0
                    request.getSession().setAttribute("intentosFallidos", "0");
                    //Mensaje que enviaremos al JSP
                    //request.setAttribute("mensaje", Constante.MENSAJE_ESPERA_COOKIE);
                    Util.guardarMensaje(request, Constante.MENSAJE_ESPERA_COOKIE);
                }
                // --Fin crear cookie--
                else{
                    //Mensaje que enviaremos al JSP
                    //request.setAttribute("mensaje", Constante.MENSAJE_LOGIN_FALLIDO);
                    Util.guardarMensaje(request, Constante.MENSAJE_LOGIN_FALLIDO);
                }
                //En cualquier de los dos casos: Redireccionamos al login
                response.sendRedirect(request.getContextPath() + "/home");
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

    public boolean validarEsperaPorFallidos(HttpServletRequest request, String nombreCookie) {
        List<Cookie> cookieDeEspera = Arrays.asList(request.getCookies()).stream()
                .filter(x -> nombreCookie.equals(x.getName()))
                .collect(Collectors.toList());
        //Si existe una cookie activa con ese nombre, quiere decir que el usuario aun espera
        // un tiempo por haber fallado muchos logins
        return (cookieDeEspera == null || cookieDeEspera.isEmpty()) ? false : true;
        
    }

}
