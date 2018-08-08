<%-- 
    Document   : header
    Created on : 04/08/2018, 12:26:29 PM
    Author     : VICTOR
--%>
<%@page import="com.empresa.proyecto.util.constante.Constante"%>
<%@page import="com.empresa.proyecto.entidad.UsuarioBE"%>
<%
    UsuarioBE usuario = (UsuarioBE) request.getSession().getAttribute(Constante.USUARIO_LOGUEADO);
    if(usuario == null){
        response.sendRedirect(request.getContextPath() + "/login");
    }
%>

<header class="main-header">

    <!-- Logo -->
    <a href="#" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>AD</b>V</span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>CEPUNS</b></span>
    </a>

    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Navegacion</span>
        </a>
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- Messages: style can be found in dropdown.less-->

                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <small class="bg-red">Online</small>
                        <span class="hidden-xs"><%=usuario != null ? usuario.getPersona().getNombreCompleto() + " - " + usuario.getRol().getDescripcion() : "" %></span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">

                            <p>
                                www.tuDomino.com - Desarrollando Software
                                <small>www.tuDominio.com/</small>
                            </p>
                        </li>

                        <!-- Menu Footer-->
                        <li class="user-footer">

                            <div class="pull-right">
                                <a href="#" class="btn btn-default btn-flat">Cerrar</a>
                            </div>
                        </li>
                    </ul>
                </li>

            </ul>
        </div>

    </nav>
</header>