<%@page import="com.empresa.proyecto.entidad.AsistenciaBE"%>
<%@page import="com.empresa.proyecto.entidad.AsistenciaDetalleBE"%>
<%@page import="com.empresa.proyecto.entidad.ParametroBE"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<%
    String mensaje = (String) request.getAttribute("mensaje");
    AsistenciaBE asistencia = (AsistenciaBE) request.getAttribute("asistencia");
    List<ParametroBE> estadosAsistencia = (List<ParametroBE>) request.getAttribute("estadosAsistencia");
    List<AsistenciaDetalleBE> listaDetalle = (List<AsistenciaDetalleBE>) request.getAttribute("listDetalle");

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

        <script type="text/javascript">
            var numeroagregados = 0;
            function agregarAlumno() {
                if (validarCampos()) {
                    var codigo = $("#codigo").val();
                    var estado_asistencia = $("#estado_asistencia option:selected").text();
                    var id_estado_asistencia = $("#estado_asistencia").val();
                    var observaciones = $("#observaciones").val();
                    $.ajax({
                        url: 'alumnobuscar',
                        data: {
                            codigo: codigo,
                            busqueda: 1
                        },
                        type: 'GET',
                        dataType: 'json',
                        success: function (alumno) {
                            if (alumno.identAlumno > 0) {
                                numeroagregados++;
                                console.log(alumno);

                                $("#tableasistencia tbody").append("<tr>" +
                                        "<td><input type=\"hidden\" name=\"idalumno"+numeroagregados+"\" value=\""+alumno.identAlumno+"\" >" + "<input type=\"hidden\" name=\"idestadoasistencia"+numeroagregados+"\" value=\""+id_estado_asistencia+"\" >"+ "<input type=\"hidden\" name=\"observaciones"+numeroagregados+"\" value=\""+observaciones+"\" >" + 0 + "</td>" +
                                        "<td>" + alumno.codigo + "</td>" +
                                        "<td>" + alumno.persona.nombres + ' ' + alumno.persona.paterno + ' ' + alumno.persona.materno + "</td>" +
                                        "<td>" + estado_asistencia + "</td>" +
                                        "<td>" + observaciones + "</td>" +
                                        "</tr>"
                                        );
                                
                                limpiar();
                                $("#numeroAgregados").val(numeroagregados);

                            } else {
                                alert('No hay un alumno con dicho codigo');
                            }

                        }, error: function (jqXHR, exception) {
                            var msg = '';
                            if (jqXHR.status === 0) {
                                msg = 'Not connect.\n Verify Network.';
                            } else if (jqXHR.status == 404) {
                                msg = 'Requested page not found. [404]';
                            } else if (jqXHR.status == 500) {
                                msg = 'Internal Server Error [500].';
                            } else if (exception === 'parsererror') {
                                msg = 'Requested JSON parse failed.';
                            } else if (exception === 'timeout') {
                                msg = 'Time out error.';
                            } else if (exception === 'abort') {
                                msg = 'Ajax request aborted.';
                            } else {
                                msg = 'Uncaught Error.\n' + jqXHR.responseText;
                            }
                            alert(msg);
                        }
                    });
                }
            }

            function validarCampos() {
                var codigo = $("#codigo").val();
                var id_estado_asistencia = $("#estado_asistencia").val();
                
                if(codigo == null || codigo == ''){
                    alert('Debe colocar el codigo del alumno');
                    return false;
                }
                if(id_estado_asistencia == 0){
                    alert('Debe seleccionar el estado de la asistencia');
                    return false;
                }
                return true;
            }
            
            function limpiar(){
                $("#codigo").val('');
                $("#estado_asistencia").val(0);
                $("#observaciones").val('');
            }
            

        </script>



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

                                        <h4>Asistencia Ciclo <%=asistencia.getProgramacionHorario().getMatricula().getAnio() + "  " +asistencia.getProgramacionHorario().getMatricula().getCiclo().getDescripcion()%></h4>
                                        <h5>Semana <%=asistencia.getNumeroSemana()%> Dia <%=asistencia.getDia().getDescripcion()%></h5>
                                        <form action="asistenciaRegistrar" method="POST">
                                            <div class="form-group">
                                                <input type="hidden" name="idAsistencia" value="<%=asistencia.getIdentAsistencia()%>">
                                                <input type="hidden" id="numeroAgregados" name="numeroAgregados" value="0">
                                                <label for="codigo">Codigo del alumno</label>
                                                <input type="text" class="form-control" id="codigo" name="codigo" >
                                            </div>
                                            <div class="form-group">
                                                <label for="fecha">Asistencia</label>
                                                <select id="estado_asistencia" name="estado_asistencia">
                                                    <option value="0">Seleccionar</option>
                                                    <%
                                                        for (ParametroBE estado : estadosAsistencia) {
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
                                                <button class="btn btn-primary" type="button" value="08/08/2018" onclick="agregarAlumno()">Agregar</button>
                                            </div>
                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                <div class="table-responsive">

                                                    <table class="table table-striped table-bordered table-condensed table-hover" id="tableasistencia">
                                                        <thead>
                                                        <th>#</th>
                                                        <th>Codigo</th>
                                                        <th>Alumno</th>
                                                        <th>Estado</th>
                                                        <th>Observaciones</th>
                                                        </thead>
                                                        <tbody>
                                                        <%
                                                            int i = 0;
                                                            for (AsistenciaDetalleBE item : listaDetalle) {
                                                        %>
                                                        
                                                            <tr>
                                                                <td><%= ++i%></td>
                                                                <td><%=item.getAlumno().getCodigo()%></td>
                                                                <td><%= item.getAlumno().getPersona().getNombreCompleto()%></td>
                                                                <td><%= item.getEstadoAsistencia().getDescripcion()%></td>
                                                                <td><%= item.getObservacion()%></td>
                                                            </tr>
                                                        
                                                        <%
                                                            }
                                                        %>
                                                        </tbody>
                                                    </table>
                                                        
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <button class="btn btn-primary" type="submit">Actualizar Asistencia</button>
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
