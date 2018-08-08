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
                                <h1 class="box-title"><label>APERTURAR CICLO ACADÉMICO</label></h1>
                            </div>
                            <!-- /.box-header -->
                            <!-- centro -->
                            <div class="panel-body " id="formularioRegistros">
                                <form action="#" name="formularioApertura" id="formularioApertura" method="POST">
                                    <!-- Inicio Panel - Configuración General -->
                                    <div class="panel panel-primary">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">Configuración General</h3>
                                        </div>
                                        <!-- Inicio del cuerpo - panel Configuración General -->
                                        <div class="panel-body">
                                            <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                <label>Año: </label>
                                                <%
                                                    java.util.Calendar fecha = java.util.Calendar.getInstance();
                                                    int anio = fecha.get(Integer.parseInt(java.util.Calendar.YEAR + ""));

                                                %>
                                                <input type="number" class="form-control" name="anio" id="anio" maxlength="4" 
                                                       value=  <% out.print(anio); %>
                                                       min= <% out.print(anio); %>
                                                       max= <% out.print(anio + 1);%>  required>
                                            </div>
                                            <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                <label>Ciclo: </label>
                                                <select id="id_004_ciclo" name="id_004_ciclo" class="form-control selectpicker" data-live-search="true" required>
                                                    <option value=8>I</option>
                                                    <option value=9>II</option>
                                                    <option value=10>III</option>                                            
                                                    <!--<option value=11>IV</option>-->
                                                </select>
                                            </div>
                                            <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                <label>Fecha de apertura: </label>
                                                <input type="date" class="form-control" name="fecha_inicio_ciclo" id="fecha_inicio" required>
                                            </div>
                                            <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                <label>Fecha de finalización: </label>
                                                <input type="date" class="form-control" name="fecha_fin_ciclo" id="fecha_fin" required>
                                            </div>
                                        </div>
                                        <!-- Fin del cuerpo - panel Configuración General -->
                                    </div>
                                    <!-- Fin Panel - Configuración General -->
                                    <!-- Inicio Panel - Configuración de Faltas -->
                                    <div class="panel panel-primary">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">Configuración de Faltas</h3>
                                        </div>
                                        <div class="panel-body">
                                            <div id="div-limite" class="form-group col-lg-2 col-md-2 col-sm-2 col-xs-12">
                                                <label>Límite de faltas: </label>
                                                <input type="number" class="form-control" name="limite_faltas_porcentaje" maxlength="3" 
                                                       id="limite_faltas_porcentaje" value="30" 
                                                       min="0" max="100" required>
                                            </div>
                                            <div class="form-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                <div class="progress">
                                                    <div id="bar" class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
                                                        <p id="limite-valor"></p>
                                                    </div>
                                                </div>                                                
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Fin Panel - Configuración de Faltas -->
                                    <!-- Inicio Panel - Configuración de Turnos -->
                                    <div class="panel panel-primary">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">Configuración de Turnos</h3>
                                        </div>
                                        <div class="panel-body">
                                            <div class="form-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                <label>Turno: </label>
                                                <input type="number" class="form-control" name="asignar_primer_turno_defecto"  
                                                       id="asignar_primer_turno_defecto" value="1" min="1" max="2" required>
                                            </div>
                                            <div class="form-group">
                                                <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                    <label>Hola inicio: </label>
                                                    <input type="time" class="form-control" name="hora_inicio" id="hora_inicio" value="07:00:00" required>
                                                </div>
                                                <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                    <label>Hora fin: </label>
                                                    <input type="time" class="form-control" name="hora_fin" id="hora_fin" value="13:00:00" required>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Fin Panel - Configuración de Turnos -->
                                    <!-- Inicio Panel - Configuración de Días a Estudiar -->
                                    <div class="panel panel-primary">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">Configuración de Días Académicos</h3>
                                        </div>
                                        <div class="panel-body">
                                            <div class="form-group col-lg-3 col-md-3 col-sm-3 col-xs-12">
                                                <ul style="list-style: none;">
                                                    <li><input type="checkBox" name="dias" value="12" checked> Lunes</li>
                                                    <li><input type="checkBox" name="dias" value="13" checked> Martes</li>
                                                </ul>
                                            </div>
                                            <div class="form-group col-lg-3 col-md-3 col-sm-3 col-xs-12">
                                                <ul style="list-style: none;">
                                                    <li><input type="checkBox" name="dias" value="14" checked> Miércoles</li>
                                                    <li><input type="checkBox" name="dias" value="15" checked> Jueves</li>
                                                </ul>
                                            </div>
                                            <div class="form-group col-lg-3 col-md-3 col-sm-3 col-xs-12">
                                                <ul style="list-style: none;">
                                                    <li><input type="checkBox" name="dias" value="16" checked> Viernes</li>
                                                    <li><input type="checkBox" name="dias" value="17"> Sábado</li>
                                                </ul>
                                            </div>
                                            <div class="form-group col-lg-3 col-md-3 col-sm-3 col-xs-12">
                                                <ul style="list-style: none;">
                                                    <li><input type="checkBox" name="dias" value="18"> Domingo</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Fin Panel - Configuración de Días a Enseñar -->
                                    <!-- Inicio Panel - Configuración de Especialidades -->
                                    <div class="panel panel-primary">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">Configuración de Especialidades</h3>
                                        </div>
                                        <div class="panel-body table-responsive" id="listadoRegistros">
                                            <table id="tblEspecialidad" class="table table-striped table-bordered table-condensed table-hover">
                                                <thead>
                                                <th>#</th>
                                                <th>Facultad</th>
                                                <th>Especialidad</th>
                                                <th>Código</th>
                                                <th>Estado</th>
                                                </thead>
                                                <tbody>
                                                    <%
                                                        int i = 0;
                                                        for (EspecialidadBE item : especialidades) {
                                                    %>
                                                    <tr>
                                                        <td><input type="hidden" name="idEspecialidades" value="<%=item.getIdentEspecialidad()%>"><%=++i%></td>
                                                        <td><%=item.getFacultad().getDescripcion()%></td>
                                                        <td><%=item.getDescripcion()%></td>
                                                        <td><%=item.getCodigo()%></td>
                                                        <td><input type="checkbox" name="checkEspecialidades" checked> Activo</td>
                                                    </tr>
                                                    <%
                                                        }
                                                    %>

                                                </tbody>

                                            </table>
                                        </div>
                                    </div>
                                    <!-- Fin Panel - Configuración de Especialidades -->
                                    <!-- Inicio Panel - Configuración de Unidades -->
                                    <div class="panel panel-primary">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">Configuración de Unidades (Semanas)</h3>
                                        </div>
                                        <br>
                                        <div class="form-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <label>Unidad: </label>
                                            <input type="number" class="form-control" name="numero_unidad"  
                                                   id="numero_unidad" value="1" min="1" required>
                                        </div>
                                        <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                            <label>Inicio de la unidad: </label>
                                            <input type="date" class="form-control" name="fecha_inicio_unidad" id="fecha_inicio_unidad" required>
                                        </div>
                                        <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                            <label>Fin de la unidad: </label>
                                            <input type="date" class="form-control" name="fecha_fin_unidad" id="fecha_fin_unidad" required>
                                        </div>
                                        <div class="form-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <button class="btn btn-primary" type="button" id="btnAgregar" name="btnAgregar" onclick="agregarUnidad()"><i class="fa fa-plus-circle"></i> Agregar</button>
                                        </div>
                                        <div class="panel-body table-responsive" id="listadoRegistros">
                                            <table id="tblUnidades" class="table table-striped table-bordered table-condensed table-hover">
                                                <thead>
                                                <th>Opciones</th>
                                                <th>Unidad</th>
                                                <th>Fecha inicio</th>
                                                <th>Fecha fin</th>
                                                <th>Estado</th>
                                                </thead>
                                                <tbody>
                                                    <tr style="display: none;">
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                    </tr>
                                                </tbody>                                      
                                            </table>
                                        </div>
                                    </div>
                                    <!-- Fin Panel - Configuración de Unidades -->

                                    <div class="form-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <button class="btn btn-success" type="submit" id="btnGuardar"><i class="fa fa-save"></i> Iniciar ciclo académico</button>
                                        <!--<button class="btn btn-primary" onclick="agregarEspecialidad()" type="button"><i class="fa fa-arrow-circle-left"></i>Agregar</button>-->
                                    </div>
                                </form>
                            </div>

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

        <%
            String mensaje = (String) request.getAttribute("mensaje");
        %>
        
        <script>
                                                $(document).ready(function () {
                                                    
                                                            var mensaje = "<%=mensaje%>";
                if (mensaje !== "null" && mensaje !== '') {
                    alert(mensaje);
                }
                                                    
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
                                                        "iDisplayLength":25
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
                                                            '<td><input type="hidden" name="fecha_inicio_unidad_agregada" value="'+inicio_unidad+'" >' + inicio_unidad + '</td>' +
                                                            '<td><input type="hidden" name="fecha_fin_unidad_agregada" value="'+fin_unidad+'" >' + fin_unidad + '</td>' +
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
