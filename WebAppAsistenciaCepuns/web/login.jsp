<%-- 
    Document   : login
    Created on : 07/08/2018, 11:11:53 PM
    Author     : Martín
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mensaje = (String) request.getAttribute("mensaje");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>CEPUNS</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.5 -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="css/font-awesome.css">
        <link rel="stylesheet" href="css/login.css">
    </head>

    <body class="hold-transition login-page">
        <header class="encabezado" role="banner">
            <div class="contenedor form-group col-lg-4 col-md-4 col-sm-4 col-xs-12">
                <a href="#" class="logo">
                    <img src="img/logo_uns.png" alt="Logo de la web" width="270">
                </a>
            </div>
            <div class="contenedor form-group col-lg-8 col-md-8 col-sm-8 col-xs-12">
                <div class="">
                    <h1 id="titulo_cepuns">
                        CENTRO PRE-UNIVERSITARIO<br>
                        <span>CEPUNS</span>
                    </h1>
                </div>
            </div>
        </header> <!-- Fin de encabezado -->
        <div class="contenedor form-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div class="titulo_sistema_div">
                <h1 id="titulo_sistema">
                    SISTEMA DE CONTROL DE ASISTENCIA
                </h1>
            </div>
        </div>
        <div class="login-box">
            <!-- /.login-logo -->
            <div class="login-box-body">
                <p class="login-box-msg">Ingrese sus datos de Acceso</p>
                <form id="frmAcceso" action="login" method="post">
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" id="cuenta" name="user" placeholder="Usuario">
                        <span class="fa fa-user form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" id="password" name="pass" class="form-control" placeholder="Password">
                        <span class="fa fa-key form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <div class="col-xs-8">

                        </div>
                        <!-- /.col -->
                        <div class="col-xs-4">
                            <button type="submit" class="btn btn-primary btn-block btn-flat">Ingresar</button>
                        </div>
                        <!-- /.col -->
                    </div>
                </form>
                <a href="#">Olvidé mi password</a>
                <br>
            </div>
            <!-- /.login-box-body -->
        </div>
        <!-- /.login-box -->
        <!-- jQuery 3.1.1 -->
        <script src="js/jquery-2.1.4.min.js"></script>
        <!-- Bootstrap 3.3.5 -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Bootbox -->
        <script src="js/bootbox.min.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {
            var mensaje = "<%=mensaje%>";
                    if (mensaje !== null && mensaje !== '') {
            <%
                mensaje = (String) request.getAttribute("mensaje");
            %>
        <script type="text/javascript">
                $(document).ready(function () {


     
                    var mensaje = "<%=mensaje%>";
                    if (mensaje !== "null" && mensaje !== '') {
            alert(mensaje);
        }
        
  
                }
                        );
        </script>


    </body>
</html>