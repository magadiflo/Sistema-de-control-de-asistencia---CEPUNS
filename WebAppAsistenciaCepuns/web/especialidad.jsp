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
                                <h1 class="box-title"><label>REGISTRO DE ESPECIALIDADES - CEPUNS</label></h1>
                            </div>
                            <!-- /.box-header -->
                            <!-- centro -->
                            <div class="panel-body " id="formularioRegistros">
                                <form action="EspecialidadServlet" name="formulario" id="formulario" method="POST">
                                    <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <label>Facultad: </label>
                                        <select id="facultad" class="form-control selectpicker" data-live-search="true" name="facultad" required>
                                            <option value="ingenieria">Ingeniería</option>
                                            <option value="ciencias">Ciencias</option>
                                            <option value="educacion">Educación</option>                                            
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <label>Especialidad: </label>
                                        <input type="hidden" name="idEspecialidad" id="idEspecialidad">
                                        <input type="text" class="form-control" name="especialidad" id="especialidad" maxlength="100" placeholder="Descripción" required>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <label>Código de especialidad: </label>
                                        <input type="text" class="form-control" name="codigo" maxlength="5" id="codigo" required>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <label>Estado: </label>
                                        <div>
                                            <input type="radio" value="activo" name="estado" checked>Activo
                                            <input type="radio" value="inactivo" name="estado"> Inactivo
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <button class="btn btn-primary" type="submit" id="btnGuardar"><i class="fa fa-save"></i> Guardar</button>
                                        <button class="btn btn-danger" onclick="cancelarForm()" type="button"><i class="fa fa-arrow-circle-left"></i> Cancelar</button>
                                    </div>
                                </form>
                            </div>
                            <!-- Listado de todas las especialidades-->
                            <div class="panel-body table-responsive" id="listadoRegistros">
                                <table id="tblListado" class="table table-striped table-bordered table-condensed table-hover">
                                    <thead>
                                        <th>#</th>
                                        <th>Facultad</th>
                                        <th>Especialidad</th>
                                        <th>Código</th>
                                        <th>Estado</th>
                                    </thead>
                                    <tbody>
                                        <% 
                                            
                                        %>
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
