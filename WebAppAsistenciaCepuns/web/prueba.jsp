<%-- 
    Document   : especialidad
    Created on : 05/08/2018, 10:11:26 PM
    Author     : Martín
--%>
<%@page import="com.empresa.proyecto.entidad.EspecialidadBE"%>
<%@page import="java.util.List"%>
<%@page import="com.empresa.proyecto.entidad.ParametroBE"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<ParametroBE> ciclos = (List<ParametroBE>) request.getAttribute("ciclos");
    List<EspecialidadBE> especialidades = (List<EspecialidadBE>) request.getAttribute("especialidades");
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

        <!-- DATATABLES -->
        <link rel="stylesheet" type="text/css" href="datatables/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="datatables/buttons.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="datatables/responsive.dataTables.min.css"/>

    </head>

    <body class="hold-transition skin-blue sidebar-mini" style="background: #222D32; ">
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
                                <div class="form-group">
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <h3 class="list-group-item list-group-item-success">
                                            DATOS DEL ALUMNO
                                        </h3>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <h1 style="font-weight: bold;" class="list-group-item list-group-item-warning form-control">
                                            INGENIERÍA EN ENERGÍA
                                        </h1>
                                    </div>
                                </div>
                            </div>


                            <!-- /.box-header -->
                            <!-- centro -->
                            <div class="panel-body " id="formularioRegistros">
                                <form action="#" name="formularioApertura" id="formularioApertura" method="POST">
                                    <!-- Inicio Panel - Datos personales -->
                                    <div class="panel panel-primary">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">Datos personales</h3>
                                        </div>
                                        <div class="panel-body">
                                            <div class="form-group">
                                                <div class="form-group col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                                    <label>Nombres: </label>
                                                    <input type="time" class="form-control" name="hora_inicio" id="hora_inicio" value="07:00:00" required>
                                                </div>
                                                <div class="form-group col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                                    <label>Apellido paterno: </label>
                                                    <input type="time" class="form-control" name="hora_fin" id="hora_fin" value="13:00:00" required>
                                                </div>
                                                <div class="form-group col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                                    <label>Apellido materno: </label>
                                                    <input type="time" class="form-control" name="hora_fin" id="hora_fin" value="13:00:00" required>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="form-group col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                                    <label>Tipo documento: </label>
                                                    <select id="id_004_ciclo" name="id_004_ciclo" class="form-control selectpicker" data-live-search="true" required>
                                                        <option value=8>DNI</option>
                                                        <option value=9>RUC</option>
                                                    </select>
                                                </div>
                                                <div class="form-group col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                                    <label>Num. documento: </label>
                                                    <input type="time" class="form-control" name="hora_fin" id="hora_fin" value="13:00:00" required>
                                                </div>
                                                <div class="form-group col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                                    <label>Fecha nacimiento: </label>
                                                    <input type="time" class="form-control" name="hora_fin" id="hora_fin" value="13:00:00" required>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                    <label>Teléfono: </label>
                                                    <input type="time" class="form-control" name="hora_inicio" id="hora_inicio" value="07:00:00" required>
                                                </div>
                                                <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                    <label>Email: </label>
                                                    <input type="time" class="form-control" name="hora_fin" id="hora_fin" value="13:00:00" required>
                                                </div>
                                            </div>
                                            <div class="form-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                <label>Dirección </label>
                                                <input type="time" class="form-control" name="hora_fin" id="hora_fin" value="13:00:00" required>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Fin Panel - personales -->
                                    <!-- Inicio Panel - otros -->
                                    <div class="panel panel-primary">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">Datos del apoderado</h3>
                                        </div>
                                        <div class="panel-body">
                                            <div class="form-group">
                                                <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                    <label>Apoderado: </label>
                                                    <input type="time" class="form-control" name="hora_inicio" id="hora_inicio" value="07:00:00" required>
                                                </div>
                                                <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                    <label>Telefono de contacto: </label>
                                                    <input type="time" class="form-control" name="hora_fin" id="hora_fin" value="13:00:00" required>
                                                </div>
                                            </div>        
                                        </div>
                                        <!-- Fin Panel - otros -->

                                        <!--
                                                                                <div class="form-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                                                    <button class="btn btn-success" type="submit" id="btnGuardar"><i class="fa fa-save"></i> Iniciar ciclo académico</button>
                                        <!--<button class="btn btn-primary" onclick="agregarEspecialidad()" type="button"><i class="fa fa-arrow-circle-left"></i>Agregar</button>
                                    </div>
                                        -->
                                </form>
                            

                            <!--Fin centro -->
                        </div><!-- /.box -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </section><!-- /.content -->

        </div><!-- /.content-wrapper -->
        <!--Fin-Contenido-->


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

        <script>
            $(document).ready(function () {
                $('#tblEspecialidad').DataTable({
                    "paging": true,
                    "ordering": true,
                    "info": true,
                    "language": {
                        "lengthMenu": "Mostrar _MENU_ registros por página",
                        "zeroRecords": "Registro no encontrado - ¡Lo siento!",
                        "info": "Mostrando página _PAGE_ de _PAGES_",
                        "infoEmpty": "No hay registros disponibles",
                        "infoFiltered": "(filtrado de los registros totales de _MAX_ )"
                    },
                    "iDisplayLength": 25
                });
            });

            //Detectar el valor inicial del Limite de faltas
            //Solo se usa una vez al cargar la página.
            var limite = $("#limite_faltas_porcentaje").val();
            mover(limite);

            //Detecta cambio del Límite de faltas
            $('#div-limite').on('input', ':input', function () {
                var value = $(this).val();//Obtiene el valor actual del input
                var name = $(this).prop('name');
                if (value.length > 0) {
                    console.log(name + ": " + value);
                    mover(value);
                }
            });

            function mover(value) {
                var elem = document.getElementById("bar");
                var width = value;
                elem.style.width = width + '%';
                $('#limite-valor').text(width + '%');
            }

            var cont = 0;
            var iniciar = true;
            function agregarUnidad() {
                var inicio_unidad = $("#fecha_inicio_unidad").val();
                var fin_unidad = $("#fecha_fin_unidad").val();
                var num_unidad = $("#numero_unidad").val();
                var fila = '<tr class="filas" id="fila' + cont + '">' +
                        '<td><button type="button" class="btn btn-danger" onClick=eliminarFila(' + cont + ')>X</button></td>' +
                        '<td>' + num_unidad + '</td>' +
                        '<td><input type="hidden" name="fecha_inicio_unidad_agregada" value="' + inicio_unidad + '" >' + inicio_unidad + '</td>' +
                        '<td><input type="hidden" name="fecha_fin_unidad_agregada" value="' + fin_unidad + '" >' + fin_unidad + '</td>' +
                        '<td>Abierto</td>' +
                        '</tr>';
                cont++;
                $('#tblUnidades').append(fila);
                inicializarTablaUnidad(iniciar);
            }

            function inicializarTablaUnidad(flag) {
                if (flag) {
                    $(document).ready(function () {
                        $('#tblUnidades').DataTable({
                            "paging": false,
                            "ordering": true,
                            "info": false
                        });
                    });
                    iniciar = false;
                }
            }
            function eliminarFila(indice) {
                $("#fila" + indice).remove();
            }
        </script>

    </body>
</html>
