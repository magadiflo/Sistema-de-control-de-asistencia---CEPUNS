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
                                            "<td>" + numero_fila +"</td>" +
                                            "<td>" + alumno.codigo + "</td>" +
                                            "<td>" + alumno.persona.documento + "</td>" +
                                            "<td>" + alumno.persona.nombres + ' ' + alumno.persona.paterno + ' ' + alumno.persona.materno + "</td>" +
                                            "<td>" + alumno.matriculaEspecialidad.especialidad.descripcion + "</td>" +
                                            "<td>" + "<a href=\"<%=request.getContextPath()%>/alumnover?idAlumno="+alumno.identAlumno+"\"><button class=\"btn btn-info\">Ver</button></a>" + "</td>" +
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
            
            function limpiar(){
                numero_fila = 0;
                $("#especialidad").val(0);
                $("#buscar").val('');
                $("#filtro").val(0);
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
                                        <div class="row">
                                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
                                                <h3>Alumnos  <%=matricula.getIdentMatricula() != 0 ? "del Ciclo " + matricula.getAnio() + " " + matricula.getCiclo().getDescripcion() : ""%></h3>
                                                <h2><a href="<%=request.getContextPath()%>/alumnoRegistrar"> <button class="btn btn-primary">Nuevo Alumno</button> </a></h2>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
                                                <label for="fecha">Filtro</label>
                                                <select id="filtro" name="filtro">
                                                    <option value="0">Seleccionar</option>
                                                    <option value="1">Codigo</option>
                                                    <option value="2">Documento</option>
                                                    <option value="3">Nombre</option>
                                                </select>
                                                <input type="text" id="buscar">
                                                <input type="hidden" id="idMatricula" name="idMatricula" value="<%=matricula.getIdentMatricula()%>">
                                            </div>
                                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
                                                <label for="fecha">Especialidad</label>
                                                <select id="especialidad" name="especialidad">
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
                                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
                                                <button class="btn btn-primary" type="button" onclick="buscar()">Buscar</button>
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

    </body>
</html>
