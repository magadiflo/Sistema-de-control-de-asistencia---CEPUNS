<%@page import="com.empresa.proyecto.entidad.MatriculaBE"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<%
    List<MatriculaBE> listaMatricula = (List<MatriculaBE>) request.getAttribute("listaMatricula");
%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Titulo | www.tuDominio.com</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.5 -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-select.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="css/font-awesome.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="css/_all-skins.min.css">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
        <link rel="shortcut icon" href="img/favicon.ico">

    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <!-- <div class="wrapper">  -->


        <jsp:include page="WEB-INF/layout/header.jsp"/>
        <jsp:include page="WEB-INF/layout/menu.jsp"/>






        <!--Contenido-->
        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">

            <!-- Main content -->
            <section class="content">

                <div class="row">
                    <div class="col-md-12">
                        <div class="box">
                            <div class="box-header with-border">
                                <h3 class="box-title">Sistema de Asistencia</h3>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>

                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <!--Contenido-->
                                        <div class="row">
                                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
                                                <h3>Historial de Ciclos Aperturados</h3>
                                                <h2><a href="<%=request.getContextPath()%>/aperturarCiclo"> <button class="btn btn-success">Aperturar Nuevo Ciclo</button> </a></h2>
                                            </div>
                                        </div>
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="table-responsive">

                                                <table class="table table-striped table-bordered table-condensed table-hover" id="tableasistencia">
                                                    <thead>
                                                    <th>#</th>
                                                    <th>Año</th>
                                                    <th>Ciclo</th>
                                                    <th>Estado</th>
                                                    <th>Accion</th>
                                                    </thead>
                                                    <tbody>
                                                        <%
                                                            int i = 0;
                                                            if (!listaMatricula.isEmpty()) {
                                                                for (MatriculaBE item : listaMatricula) {
                                                        %>

                                                        <tr>
                                                            <td><%= ++i%></td>
                                                            <td><%=item.getAnio()%></td>
                                                            <td><%= item.getCiclo().getDescripcion()%></td>
                                                            <td><%= item.getEstadoMatricula().getDescripcion()%></td>
                                                            <td>
                                                                <a href="?idMatricula=<%=item.getIdentMatricula()%>"><button class="btn btn-info">Ver Matricula</button></a>
                                                                <a href="<%=request.getContextPath()%>/alumnolistar?idMatricula=<%=item.getIdentMatricula()%>"><button class="btn btn-info">Ver Alumnos</button></a>
                                                                <a href="<%=request.getContextPath()%>/asistenciaFecha?idMatricula=<%=item.getIdentMatricula()%>"><button class="btn btn-info">Ver Asistencia</button></a>
                                                            </td>
                                                        </tr>

                                                        <%
                                                                }
                                                            }
                                                        %>
                                                    </tbody>
                                                </table>

                                            </div>
                                        </div>


                                        <!--Fin Contenido-->
                                    </div>
                                </div>

                            </div>
                        </div><!-- /.row -->
                    </div><!-- /.box-body -->
                </div><!-- /.box -->

            </section><!-- /.content -->
        </div><!-- /.content-wrapper -->
        <!--Fin-Contenido-->
        <script>

        </script>
        <footer class="main-footer">
            <div class="pull-right hidden-xs">
                <b>Version</b> 2.3.0
            </div>
            <strong>Copyright &copy; 2015-2020 <a href="#">Company</a>.</strong> All rights reserved.
        </footer>


        <!-- jQuery 2.1.4 -->
        <script src="js/jQuery-2.1.4.min.js"></script>

        <!-- Bootstrap 3.3.5 -->
        <script src="js/bootstrap.min.js"></script>
        <script src="js/bootstrap-select.min.js"></script>
        <!-- AdminLTE App -->
        <script src="js/app.min.js"></script>

        <%
            String mensaje = (String) request.getAttribute("mensaje");
        %>
        <script type="text/javascript">
            $(document).ready(function () {
                        var mensaje = "<%=mensaje%>";
                if (mensaje !== "null" && mensaje !== '') {
                    alert(mensaje);
                }
            });
        </script>
        
    </body>
</html>
