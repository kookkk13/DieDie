/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2019-03-10 04:05:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view.calorie.food;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import calorie.food.model.vo.Food;
import java.util.*;
import java.sql.*;

public final class foodDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("calorie.food.model.vo.Food");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

	Food f = (Food)request.getAttribute("food");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t\t<title>DIE DIE</title>\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/diedie/assets/css/main.css\" />\r\n");
      out.write("\t\t<script src=\"/diedie/assets/js/jquery.min.js\"></script>\r\n");
      out.write("\t\t<style>\r\n");
      out.write("\t\t\t#firsttable th, #firsttable td{ text-align: center !important }\r\n");
      out.write("\t\t\tinput[type=number]::-webkit-inner-spin-button,\r\n");
      out.write("\t\t\tinput[type=number]::-webkit-outer-spin-button,\r\n");
      out.write("\t\t\tinput[type=date]::-webkit-inner-spin-button,\r\n");
      out.write("\t\t\tinput[type=date]::-webkit-outer-spin-button {\r\n");
      out.write("    \t\t\t-webkit-appearance: none;\r\n");
      out.write("   \t\t\t\t margin: 0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\tfunction changeonce(){\r\n");
      out.write("\t\t\t\tvar once = $(\"#oncefood\").val();\r\n");
      out.write("\t\t\t\tvar changevalue = once / ");
      out.print( f.getOnceIn() );
      out.write("\r\n");
      out.write("\t\t\t\t$(\"#kcalfood\").val((changevalue * ");
      out.print( f.getCalorie() );
      out.write(").toFixed(2));\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t\tfunction changekcal(){\r\n");
      out.write("\t\t\t\tvar kcal = $(\"#kcalfood\").val();\r\n");
      out.write("\t\t\t\tvar changevalue = kcal / ");
      out.print( f.getCalorie() );
      out.write("\r\n");
      out.write("\t\t\t\t$(\"#oncefood\").val((changevalue * ");
      out.print( f.getOnceIn() );
      out.write(").toFixed(2));\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t\tfunction parentgo(){\r\n");
      out.write("\t\t\t\tconsole.log(\"실행!\");\r\n");
      out.write("\t\t\t\tvar value = \"");
      out.print( f.getFoodName() );
      out.write("\" + \",\" + $(\"#oncefood\").val() + \",\" + $(\"#kcalfood\").val()\r\n");
      out.write("\t\t\t\twindow.opener.document.getElementById(\"childcommon\").value = value;\r\n");
      out.write("\t\t\t\t$(opener.location).attr(\"href\", \"javascript:imchange();\");\r\n");
      out.write("\t\t\t\twindow.close();\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body class=\"is-preload\">\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Wrapper -->\r\n");
      out.write("\t\t\t<div id=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Main -->\r\n");
      out.write("\t\t\t\t\t<div id=\"main\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"inner\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<!-- Content -->\r\n");
      out.write("\t\t\t\t\t\t\t\t<section>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=table-wrapper style=\"width: 300px; margin: 0 auto; text-align: center;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h2 style=\"word-break: break-word;\">");
      out.print( f.getFoodName() );
      out.write("</h2>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<table id=firsttable class=\"alt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td><b>칼로리</b></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td><b>1회 제공량</b></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>");
      out.print( f.getCalorie() );
      out.write(" kcal</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>");
      out.print( (int)f.getOnceIn() );
      out.write(" g</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<table class=\"newtable\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<th>&nbsp; &nbsp;탄수화물</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>");
      out.print( f.getCarb() );
      out.write(" g</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<th>&nbsp; &nbsp;단백질</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>");
      out.print( f.getProtein() );
      out.write(" g</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<th>&nbsp; &nbsp;지방</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>");
      out.print( f.getFat() );
      out.write(" g</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<th>&nbsp; &nbsp;당류</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>");
      out.print( f.getSugar() );
      out.write(" g</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<th>&nbsp; &nbsp;나트륨</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>");
      out.print( f.getNa() );
      out.write(" mg</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<hr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h3>음식 칼로리 설정</h3>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td>분량(g)</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td><input type=\"number\" id=\"oncefood\" name=\"oncefood\" value=\"");
      out.print( f.getOnceIn() );
      out.write("\" onchange=\"changeonce();\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td>칼로리(kcal)</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td><input type=\"number\" id=\"kcalfood\" name=\"kcalfood\" value=\"");
      out.print( f.getCalorie() );
      out.write("\" onchange=\"changekcal();\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<button class=\"primary\" onclick=\"parentgo();\">추가</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t&nbsp; &nbsp; &nbsp; &nbsp; \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<button class=\"primary\" onclick=\"window.close();\">닫기</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</section>\r\n");
      out.write("\t\t\t\t\t\t\t<!-- Content End!!!!!!!! -->\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Scripts -->\r\n");
      out.write("\t\t\t<script src=\"/diedie/assets/js/browser.min.js\"></script>\r\n");
      out.write("\t\t\t<script src=\"/diedie/assets/js/breakpoints.min.js\"></script>\r\n");
      out.write("\t\t\t<script src=\"/diedie/assets/js/util.js\"></script>\r\n");
      out.write("\t\t\t<script src=\"/diedie/assets/js/main.js\"></script>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}