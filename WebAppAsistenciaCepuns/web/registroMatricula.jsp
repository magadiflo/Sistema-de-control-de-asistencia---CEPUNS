<%-- 
    Document   : especialidad
    Created on : 05/08/2018, 10:11:26 PM
    Author     : Martín
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                <h1 class="box-title"><label>REGISTRO DE MATRÍCULA - CEPUNS</label></h1>
                            </div>
                            <!-- /.box-header -->
                            <!-- centro -->
                            <div class="panel-body " id="formularioRegistros">
                                <form action="#" name="formulario" id="formulario" method="POST">
                                    <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <label>Año: </label>
                                        <%
                                            java.util.Calendar fecha = java.util.Calendar.getInstance();
                                        %>
                                        <input type="number" class="form-control" name="anio" id="anio" maxlength="4" 
                                               value=<% out.println(fecha.get(java.util.Calendar.YEAR)); %>required>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <label>Ciclo: </label>
                                        <select id="ciclo" class="form-control selectpicker" data-live-search="true" name="ciclo" required>
                                            <option value=8>I</option>
                                            <option value=9>II</option>
                                            <option value=10>III</option>                                            
                                            <!--<option value=11>IV</option>-->
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <label>Fecha Inicio: </label>
                                        <input type="date" class="form-control" name="fechainicio" id="fechainicio" required>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <label>Fecha Inicio: </label>
                                        <input type="date" class="form-control" name="fechafin" id="fechafin" required>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <label>Estado: </label>
                                        <div>
                                            <input type="radio" value="activo" name="estado" checked>Activo
                                            <input type="radio" value="inactivo" name="estado"> Inactivo
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                        <label>Límite de faltas: </label>
                                        <input type="number" class="form-control" name="limite" maxlength="3" id="limite" value="30" required>
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-striped active" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:30%">
                                                30%
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-2 col-md-2 col-sm-2 col-xs-12">
                                        <label>Turno: </label>
                                        <input type="number" class="form-control" name="turno" id="turno" min="1" max="2" value="1" required>
                                    </div>
                                    
                                    <!-- De tabla Turno -->
                                    
                                    <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <label>Seleccione los días para su matrícula: </label><br>
                                        <input type="checkBox" name="dias" value="12"> Lunes &nbsp;&nbsp;
                                        <input type="checkBox" name="dias" value="13"> Martes&nbsp;&nbsp;
                                        <input type="checkBox" name="dias" value="14"> Miércoles&nbsp;&nbsp;
                                        <input type="checkBox" name="dias" value="15"> Jueves&nbsp;&nbsp;
                                        <input type="checkBox" name="dias" value="16"> Viernes&nbsp;&nbsp;
                                        <input type="checkBox" name="dias" value="17"> Sábado&nbsp;&nbsp;
                                        <input type="checkBox" name="dias" value="18"> Domingo&nbsp;&nbsp;
                                    </div>
                                    
                                    <div class="form-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <button class="btn btn-primary" type="submit" id="btnGuardar"><i class="fa fa-save"></i> Guardar</button>
                                        <!--<button class="btn btn-primary" onclick="agregarEspecialidad()" type="button"><i class="fa fa-arrow-circle-left"></i>Agregar</button>-->
                                    </div>
                                </form>
                            </div>
                                    
                            
                                    <!--
                            <div class="panel-body table-responsive" id="listadoRegistros">
                                <h4 class="box-title"><label>LISTADO DE MATRICULADOS</label></h4>
                                <table id="tblEspecialidad" class="table table-striped table-bordered table-condensed table-hover">
                                    <thead>
                                    <th>#</th>
                                    <th>Facultad</th>
                                    <th>Especialidad</th>
                                    <th>Código</th>
                                    <th>Estado</th>
                                    </thead>
                                    <tbody>
                                        
                                    </tbody>
                                    <tfoot>
                                    <th>#</th>
                                    <th>Facultad</th>
                                    <th>Especialidad</th>
                                    <th>Código</th>
                                    <th>Estado</th>
                                    </tfoot>
                                </table>
                            </div>
                                   --> 
                            <!--Fin centro -->
                        </div><!-- /.box -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
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
