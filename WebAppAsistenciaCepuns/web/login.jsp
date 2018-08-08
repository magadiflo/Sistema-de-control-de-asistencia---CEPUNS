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

        <!-- Theme style -->
        <link rel="stylesheet" href="css/AdminLTE.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="css/blue.css">

    </head>

    <body class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">
                <a href="login.jsp">
                    <b class="">Sistema de Control de Asistencias</b>
                </a>
            </div>
            <!-- /.login-logo -->
            <div class="login-box-body">
                <p class="login-box-msg">Ingrese sus datos de Acceso</p>
                <form id="frmAcceso" action="login" method="post">
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" id="cuenta" name="cuenta" placeholder="Usuario">
                        <span class="fa fa-user form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" id="password" name="password" class="form-control" placeholder="Password">
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
                    alert(mensaje);
                }
            });
        </script>


    </body>
</html>