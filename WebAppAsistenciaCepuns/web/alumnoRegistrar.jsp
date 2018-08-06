<%@page import="com.empresa.proyecto.entidad.MatriculaEspecialidadBE"%>
<%@page import="com.empresa.proyecto.entidad.MatriculaBE"%>
<%@page import="java.util.List"%>
<%@page import="com.empresa.proyecto.entidad.ParametroBE"%>
<%
    List<ParametroBE> tiposDocumento = (List<ParametroBE>) request.getAttribute("tiposDocumento");
    MatriculaBE matricula = (MatriculaBE) request.getAttribute("matriculaActual");
    List<MatriculaEspecialidadBE> listEspecialidades = (List<MatriculaEspecialidadBE>) request.getAttribute("listEspecialidades");
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

        <script type="text/javascript">
            function validarDocumento(){
                var documento = $("#documento").val();
                
                $.ajax({
                        url: 'alumnobuscar',
                        data: {
                            documento: documento
                        },
                        type: 'GET',
                        dataType: 'json',
                        success: function (alumno) {
                            if (alumno.identAlumno > 0) {
                                console.log(alumno);
                                $("#idPersona").val(alumno.persona.identPersona);
                                $("#tipo_documento").val(alumno.persona.tipoDocumento.identParametro);
                                $("#paterno").val(alumno.persona.paterno);
                                $("#materno").val(alumno.persona.materno);
                                $("#nombres").val(alumno.persona.nombres);
                                $("#fecha").val("1999-08-05");
                                $("#direccion").val(alumno.persona.direccion);
                                $("#telefono").val(alumno.persona.telefono);
                                $("#email").val(alumno.persona.email);
                            } else {
                                alert('No hay una persona registrada con dicho documento');
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
                                    <script>
                                        function val(e) {
                                            tecla = (document.all) ? e.keyCode : e.which;
                                            if (tecla == 8)
                                                return true;
                                            patron = /[A-Za-z]/;
                                            te = String.fromCharCode(tecla);
                                            return patron.test(te);
                                        }
                                    </script>
                                
                                <script>

                                    function valida(e) {
                                        tecla = (document.all) ? e.keyCode : e.which;
                                        //Tecla de retroceso para borrar, siempre la permite
                                        if(tecla == 13){
                                            validarDocumento();
                                        }
                                        if (tecla == 8) {
                                            return true;
                                        }
                                        // Patron de entrada, en este caso solo acepta numeros
                                        patron = /[0-9]/;
                                        tecla_final = String.fromCharCode(tecla);
                                        return patron.test(tecla_final);
                                    }
                                </script>

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
                                                    <input type="hidden" id="idPersona" name="idPersona" value="0">
                                                    <input type="hidden" id="idMatricula" name="idMatricula" value="<%=matricula.getIdentMatricula()%>">
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
                                                    <input type="text" class="form-control" id="documento" name="documento" onkeypress="return valida(event)" maxlength='12'>
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
                                                    <label for="codigo">Nombres</label>
                                                    <input type="text" class="form-control" id="nombres" name="nombres" >
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
                                                <div class="form-group">
                                                <label for="fecha">Especialidad</label>
                                                    <select id="especialidad" name="especialidad">
                                                        <option value="0">Seleccionar</option>
                                                        <%
                                                            for (MatriculaEspecialidadBE item : listEspecialidades) {
                                                        %>
                                                        <option value="<%=item.getIdentMatriculaEspecialidad()%>"><%=item.getEspecialidad().getDescripcion()%></option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label for="codigo">Apoderado</label>
                                                    <input type="text" class="form-control" id="apoderado" name="apoderado" >
                                                </div>
                                                <div class="form-group">
                                                    <label for="codigo">Telefono de Contacto</label>
                                                    <input type="text" class="form-control" id="telefono_contacto" name="telefono_contacto" >
                                                </div>
                                                <div class="form-group">
                                                    <button class="btn btn-primary" type="submit">REGISTRAR</button>
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
