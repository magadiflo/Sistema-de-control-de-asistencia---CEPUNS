package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <title>Titulo | www.tuDominio.com</title>\r\n");
      out.write("        <!-- Tell the browser to be responsive to screen width -->\r\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\r\n");
      out.write("        <!-- Bootstrap 3.3.5 -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap-select.min.css\">\r\n");
      out.write("        <!-- Font Awesome -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/font-awesome.css\">\r\n");
      out.write("        <!-- Theme style -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/AdminLTE.min.css\">\r\n");
      out.write("        <!-- AdminLTE Skins. Choose a skin from the css/skins\r\n");
      out.write("             folder instead of downloading all of them to reduce the load. -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/_all-skins.min.css\">\r\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"img/apple-touch-icon.png\">\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"img/favicon.ico\">\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body class=\"hold-transition skin-blue sidebar-mini\">\r\n");
      out.write("        <!-- <div class=\"wrapper\">  -->\r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "WEB-INF/layout/header.jsp", out, false);
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "WEB-INF/layout/menu.jsp", out, false);
      out.write("\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!--Contenido-->\r\n");
      out.write("            <!-- Content Wrapper. Contains page content -->\r\n");
      out.write("            <div class=\"content-wrapper\">\r\n");
      out.write("\r\n");
      out.write("                <!-- Main content -->\r\n");
      out.write("                <section class=\"content\">\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-md-12\">\r\n");
      out.write("                            <div class=\"box\">\r\n");
      out.write("                                <div class=\"box-header with-border\">\r\n");
      out.write("                                    <h3 class=\"box-title\">Sistema de Asistencia</h3>\r\n");
      out.write("                                    <div class=\"box-tools pull-right\">\r\n");
      out.write("                                        <button class=\"btn btn-box-tool\" data-widget=\"collapse\"><i class=\"fa fa-minus\"></i></button>\r\n");
      out.write("\r\n");
      out.write("                                        <button class=\"btn btn-box-tool\" data-widget=\"remove\"><i class=\"fa fa-times\"></i></button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <!-- /.box-header -->\r\n");
      out.write("                                <div class=\"box-body\">\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col-md-12\">\r\n");
      out.write("                                            <!--Contenido-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                            <!--Fin Contenido-->\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div><!-- /.row -->\r\n");
      out.write("                        </div><!-- /.box-body -->\r\n");
      out.write("                    </div><!-- /.box -->\r\n");
      out.write("\r\n");
      out.write("                </section><!-- /.content -->\r\n");
      out.write("            </div><!-- /.content-wrapper -->\r\n");
      out.write("            <!--Fin-Contenido-->\r\n");
      out.write("            <script>\r\n");
      out.write("                \r\n");
      out.write("            </script>\r\n");
      out.write("            <footer class=\"main-footer\">\r\n");
      out.write("                <div class=\"pull-right hidden-xs\">\r\n");
      out.write("                    <b>Version</b> 2.3.0\r\n");
      out.write("                </div>\r\n");
      out.write("                <strong>Copyright &copy; 2015-2020 <a href=\"#\">Company</a>.</strong> All rights reserved.\r\n");
      out.write("            </footer>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- jQuery 2.1.4 -->\r\n");
      out.write("            <script src=\"js/jQuery-2.1.4.min.js\"></script>\r\n");
      out.write("            \r\n");
      out.write("            <!-- Bootstrap 3.3.5 -->\r\n");
      out.write("            <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("            <script src=\"js/bootstrap-select.min.js\"></script>\r\n");
      out.write("            <!-- AdminLTE App -->\r\n");
      out.write("            <script src=\"js/app.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
