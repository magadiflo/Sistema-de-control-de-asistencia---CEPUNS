<%@page import="com.empresa.proyecto.entidad.MatriculaBE"%>
<%@page import="java.util.List"%>
<%@page import="com.empresa.proyecto.entidad.ParametroBE"%>
<%
    List<ParametroBE> tiposDocumento = (List<ParametroBE>) request.getAttribute("tiposDocumento");
    MatriculaBE matricula = (MatriculaBE) request.getAttribute("matriculaActual");
%>
<!DOCTYPE html>
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

                                            <h4>Registrar Alumno al Ciclo <%=matricula.getAnio() + "-" + matricula.getCiclo().getDescripcion() %></h4>
                                            <form action="alumnoRegistrar" method="POST">
                                                <div class="form-group">
                                                <label for="fecha">Tipo de Documento</label>
                                                    <select id="tipo_documento" name="tipo_documento">
                                                        <option value="0">Seleccionar</option>
                                                        <%
                                                            for (ParametroBE tipo : tiposDocumento) {
                                                        %>
                                                        <option value="<%=tipo.getIdentParametro()%>"><%=tipo.getDescripcion()%></option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label for="codigo">Ingrese Documento</label>
                                                    <input type="text" class="form-control" id="codigo" name="dni" >
                                                </div>
                                                <div class="form-group">
                                                    <label for="codigo">Apellido Paterno</label>
                                                    <input type="text" class="form-control" id="paterno" name="paterno" >
                                                </div>
                                                <div class="form-group">
                                                    <label for="codigo">Apellido Materno</label>
                                                    <input type="text" class="form-control" id="materno" name="materno" >
                                                </div>
                                                <div class="form-group">
                                                    <label for="fecha">Fecha de Nacimiento</label>
                                                    <input type="date" class="form-control" id="fecha" value="2018-09-10" name="fecha" >
                                                </div>
                                                <div class="form-group">
                                                    <label for="codigo">Direccion</label>
                                                    <input type="text" class="form-control" id="direccion" name="direccion" >
                                                </div>
                                                <div class="form-group">
                                                    <label for="codigo">Telefono</label>
                                                    <input type="text" class="form-control" id="telefono" name="telefono" >
                                                </div>
                                                <div class="form-group">
                                                    <label for="codigo">Email</label>
                                                    <input type="text" class="form-control" id="email" name="email" >
                                                </div>
                                            </form>




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

    </body>
</html>
