<%@page import="com.empresa.proyecto.entidad.AsistenciaDetalleBE"%>
<%@page import="com.empresa.proyecto.entidad.ParametroBE"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<%
   String mensaje = (String)request.getAttribute("mensaje");
    int idAsistencia = (Integer)request.getAttribute("idAsistencia");
    List<ParametroBE> estadosAsistencia = (List<ParametroBE>) request.getAttribute("estadosAsistencia");
    List<AsistenciaDetalleBE> listaDetalle = (List<AsistenciaDetalleBE>)request.getAttribute("listDetalle");

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

                                            <h4>Registrar Asistencia</h4>
                                            <form action="asistenciaRegistrar" method="POST">
                                                <div class="form-group">
                                                    <input type="hidden" name="idAsistencia" value="<%=idAsistencia%>">
                                                    <label for="codigo">Codigo del alumno</label>
                                                    <input type="text" class="form-control" id="codigo" name="codigo" >
                                                </div>
                                                <div class="form-group">
                                                    <label for="fecha">Asistencia</label>
                                                    <select id="estado_asistencia" name="estado_asistencia">
                                                        <option value="0">Seleccionar</option>
                                                        <%
                                                            for(ParametroBE estado : estadosAsistencia){
                                                        %>
                                                        <option value="<%=estado.getIdentParametro()%>"><%=estado.getDescripcion()%></option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                                    <div class="form-group">
                                                    <label for="observaciones">Observaciones</label>
                                                    <input type="text" class="form-control" id="observaciones" name="observaciones" >
                                                </div>
                                                <div class="form-group">
                                                    <button class="btn btn-primary" type="button" value="08/08/2018">Agregar</button>
                                                </div>
                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                    <div class="table-responsive">

                                                        <table class="table table-striped table-bordered table-condensed table-hover">
                                                            <thead>
                                                                <th>#</th>
                                                                <th>Alumno</th>
                                                                <th>Estado</th>
                                                                <th>Observaciones</th>
                                                            </thead>
                                                            <%
                                                                int i = 0;
                                                                for(AsistenciaDetalleBE item: listaDetalle){
                                                            %>
                                                            <tr>
                                                                <td><%= ++i%></td>
                                                                <td><%= item.getAlumno().getPersona().getNombreCompleto()%></td>
                                                                <td><%= item.getEstadoAsistencia().getDescripcion()%></td>
                                                                <td><%= item.getObservacion()%></td>
                                                            </tr>
                                                            <%
                                                                }
                                                            %>
                                                        </table>

                                                    </div>
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
            <script type="text/javascript">
               
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
