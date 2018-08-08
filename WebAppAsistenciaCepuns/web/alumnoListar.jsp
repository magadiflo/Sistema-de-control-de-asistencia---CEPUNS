<%@page import="com.empresa.proyecto.entidad.MatriculaEspecialidadBE"%>
<%@page import="com.empresa.proyecto.entidad.MatriculaBE"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<%
    MatriculaBE matricula = (MatriculaBE) request.getAttribute("matricula");
    List<MatriculaEspecialidadBE> listaEspecialidad = (List<MatriculaEspecialidadBE>) request.getAttribute("listaEspecialidad");
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
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

        <!-- DATATABLES -->
        <link rel="stylesheet" type="text/css" href="datatables/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="datatables/buttons.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="datatables/responsive.dataTables.min.css"/>


        <script type="text/javascript">
            var numero_fila = 0;
            function buscar() {
                if (validar()) {
                    var idMatricula = $("#idMatricula").val();
                    var idEspecialidad = $("#especialidad").val();
                    var buscar = $("#buscar").val();
                    var filtro = $("#filtro").val();
                    var codigo = '';
                    var documento = '';
                    var nombre = '';

                    if (filtro == 1) {
                        codigo = buscar;
                    }
                    if (filtro == 2) {
                        documento = buscar;
                    }
                    if (filtro == 3) {
                        nombre = buscar;
                    }

                    $.ajax({
                        url: 'alumnobuscar',
                        data: {
                            codigo: codigo,
                            documento: documento,
                            idMatricula: idMatricula,
                            idMatriculaEspecialidad: idEspecialidad,
                            nombre: nombre,
                            busqueda: 2
                        },
                        type: 'GET',
                        dataType: 'json',
                        success: function (listaalumno) {
                            var count = Object.keys(listaalumno).length;
                            console.log("Count: " + count);
                            console.log(listaalumno);
                            if (count > 0) {
                                $("#tbodyid").empty();
                                for (var i in listaalumno) {
                                    var alumno = listaalumno[i];
                                    numero_fila++;
                                    console.log(alumno);

                                    $("#tablaalumnos tbody").append("<tr>" +
                                            "<td>" + numero_fila + "</td>" +
                                            "<td>" + alumno.codigo + "</td>" +
                                            "<td>" + alumno.persona.documento + "</td>" +
                                            "<td>" + alumno.persona.nombres + ' ' + alumno.persona.paterno + ' ' + alumno.persona.materno + "</td>" +
                                            "<td>" + alumno.matriculaEspecialidad.especialidad.descripcion + "</td>" +
                                            "<td>" + "<a href=\"<%=request.getContextPath()%>/alumnover?idAlumno=" + alumno.identAlumno + "\"><button class=\"btn btn-info\">Ver</button></a>" + "</td>" +
                                            "</tr>"
                                            );


                                }
                                limpiar();

                            } else {
                                alert('No hay un alumno con dicho filtro');
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

            function validar() {
                var filtro = $("#filtro").val();
                var buscar = $("#buscar").val();
                var especialidad = $("#especialidad").val();

                if ((buscar == '') && (especialidad == 0)) {
                    alert('Debe realizar al menos un filtro');
                    return false;
                } else {
                    if ((buscar != '') && filtro == 0) {
                        alert('Debe seleccionar el filtro');
                        return false;
                    }
                }
                return true;

            }

            function limpiar() {
                numero_fila = 0;
                $("#especialidad").val(0);
                $("#buscar").val('');
                $("#filtro").val(0);
            }

        </script>

    </head>
    <body class="hold-transition skin-blue sidebar-mini" style="background: #222D32;">
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
                                <h1 class="box-title"><label>SISTEMA DE ASISTENCIA</label></h1>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <!--Contenido-->
                                        <div class="row">
                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                <h3 class="list-group-item list-group-item-success">Alumnos  <%=matricula.getIdentMatricula() != 0 ? "del Ciclo " + matricula.getAnio() + " " + matricula.getCiclo().getDescripcion() : ""%></h3>
                                            </div>
                                        </div>
                                        <div class="box-header with-border">
                                            <h1 class="box-title">
                                                <button class="btn btn-success" id="btnAgregar">
                                                    <a href="<%=request.getContextPath()%>/alumnoRegistrar">
                                                        <span style="color:white;">
                                                            <i class="fa fa-plus-circle"></i> 
                                                            Nuevo Alumno
                                                        </span>
                                                    </a>
                                                </button>
                                                <button class="btn btn-primary" type="button" onclick="buscar()"> 
                                                    <i class="fa fa-search"></i>
                                                    Buscar
                                                </button>
                                            </h1>
                                        </div>

                                        <!-- Inicio Panel - Filtrado -->
                                        <div class="panel panel-primary">
                                            <div class="panel-heading">
                                                <h3 class="panel-title">Configuración de Turnos</h3>
                                            </div>
                                            <div class="panel-body">
                                                <div class="form-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                    <label for="fecha">Especialidad</label>
                                                    <select id="especialidad" name="especialidad" class="form-control selectpicker" data-live-search="true">
                                                        <option value="0">Seleccionar</option>
                                                        <%
                                                            for (MatriculaEspecialidadBE item : listaEspecialidad) {
                                                        %>
                                                        <option value="<%=item.getIdentMatriculaEspecialidad()%>"><%=item.getEspecialidad().getDescripcion()%></option>    
                                                        <%
                                                            }
                                                        %>
                                                    </select>   
                                                </div>
                                                <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                    <label for="fecha">Filtro</label>
                                                    <select id="filtro" name="filtro" class="form-control selectpicker" data-live-search="true">
                                                        <option value="0">Seleccionar</option>
                                                        <option value="1">Codigo</option>
                                                        <option value="2">Documento</option>
                                                        <option value="3">Nombre</option>
                                                    </select> 
                                                </div>
                                                <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                    <label>&nbsp;</label>
                                                    <input type="hidden" id="idMatricula" name="idMatricula" class="form-control" value="<%=matricula.getIdentMatricula()%>">
                                                    <input type="text" id="buscar" class="form-control">
                                                </div>
                                            </div>
                                        </div>

                                        <!-- Fin Panel - Filtrado-->



                                        <div class="row">
                                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">

                                            </div>
                                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">

                                            </div>

                                        </div>  


                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="table-responsive">

                                                <table class="table table-striped table-bordered table-condensed table-hover" id="tablaalumnos">
                                                    <thead>
                                                    <th>#</th>
                                                    <th>Codigo</th>
                                                    <th>Documento</th>
                                                    <th>Alumno</th>
                                                    <th>Especialidad</th>
                                                    <th>Accion</th>
                                                    </thead>
                                                    <tbody id="tbodyid">

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

        <!-- Librerías del DATATABLES -->
        <script src="datatables/jquery.dataTables.min.js"></script>
        <script src="datatables/dataTables.buttons.min.js"></script>
        <script src="datatables/buttons.html5.min.js"></script>
        <script src="datatables/buttons.colVis.min.js"></script>

        <script src="datatables/jszip.min.js"></script>
        <script src="datatables/pdfmake.min.js"></script>
        <script src="datatables/vfs_fonts.js"></script>

        <%
            String mensaje = (String) request.getAttribute("mensaje");
        %>
        <script>
            $(document).ready(function () {

                var mensaje = "<%=mensaje%>";
                if (mensaje !== "null" && mensaje !== '') {

                    swal(mensaje, "", "success");
                }

                $('#tablaalumnos').DataTable({
                    "paging": false,
                    "ordering": true,
                    "info": false,
                    "language": {
                        "lengthMenu": "Mostrar _MENU_ registros por página",
                        "zeroRecords": "Registro no encontrado - ¡Lo siento!",
                        "info": "Mostrando página _PAGE_ de _PAGES_",
                        "infoEmpty": "No hay registros disponibles",
                        "infoFiltered": "(filtrado de los registros totales de _MAX_ )"
                    },
                    dom: '<"row" lr> <"row" <"col-xs-12" t >> <"row" <"col-sm-6" i> < "col-sm-6" p >> '
                });
            });
        </script>




    </body>
</html>
