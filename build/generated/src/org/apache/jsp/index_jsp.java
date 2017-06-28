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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        \n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n");
      out.write("        <title>Airports Database</title>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap -->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-4\"></div>\n");
      out.write("            <div class=\"col-md-4\">\n");
      out.write("            <h1 style=\"text-align: center\">Airports Database</h1>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-4\"></div>\n");
      out.write("        </div>\n");
      out.write("        <hr>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-4\"></div>\n");
      out.write("            <div class  =\" col-md-4\" style=\"text-align: center\">\n");
      out.write("            <h3>Query</h3>\n");
      out.write("            <form name=\"countryForm\" action=\"desplayAirports.jsp\" method=\"POST\">\n");
      out.write("\n");
      out.write("                Enter a country code or name:\n");
      out.write("                <input type=\"text\" name=\"country\" required=\"\" value=\"\" size=\"35\" />\n");
      out.write("                <br><br>\n");
      out.write("                <input type=\"reset\" class=\"btn btn-info\" value=\"Clear\" name=\"clear\" />\n");
      out.write("                <input type=\"submit\" class=\"btn btn-info\" value=\"Submit\" name=\"submit\" />\n");
      out.write("            </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-4\"></div>\n");
      out.write("        </div>\n");
      out.write("        <hr>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-4\"></div>\n");
      out.write("            <div class=\"col-md-4\" style=\"text-align: center\">\n");
      out.write("            <h3 >Reports</h3>\n");
      out.write("            <form name=\"top10form\" action=\"desplayTop10.jsp\">\n");
      out.write("                Countries with the most airports:   <input type=\"submit\" class=\"btn btn-info\" value=\"Submit\" name=\"top10\" />\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <br>\n");
      out.write("\n");
      out.write("            <form name=\"top10lowform\" action=\"desplayTop10low.jsp\">\n");
      out.write("                Countries with the least airports:   <input type=\"submit\" class=\"btn btn-info\" value=\"Submit\" name=\"top10low\" />\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <br>\n");
      out.write("\n");
      out.write("            <form name=\"uniqueSurface\" action=\"desplaySurface.jsp\">\n");
      out.write("                Surfaces for each country:   <input type=\"submit\" value=\"Submit\" class=\"btn btn-info\" name=\"unqueSurface\" />\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <br>\n");
      out.write("\n");
      out.write("            <form name=\"top10lowform\" action=\"desplayRunways.jsp\">\n");
      out.write("                Most common Runways Identifications:   <input type=\"submit\" value=\"Submit\" class=\"btn btn-info\" name=\"top10low\" />\n");
      out.write("            </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-4\"></div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
