/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2019-03-05 03:41:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view.service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import user.model.vo.User;

public final class serviceError_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/view/service/../common/sidebar.jsp", Long.valueOf(1551747974440L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("user.model.vo.User");
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

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    java.lang.Throwable exception = org.apache.jasper.runtime.JspRuntimeLibrary.getThrowable(request);
    if (exception != null) {
      response.setStatus(javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t\t<title>DIE DIE</title>\r\n");
      out.write("\t\t<style type=\"text/css\">\r\n");
      out.write("\t\t\t#centerWindow {\r\n");
      out.write("\t\t\t\tposition: absolute;\r\n");
      out.write("\t\t\t\ttop: 50%;\r\n");
      out.write("\t\t\t\tleft: 45%;\r\n");
      out.write("\t\t\t\tmargin-top: -50px;\r\n");
      out.write("\t\t\t\tmargin-left: -50px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/diedie/assets/css/main.css\" />\r\n");
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
      out.write("\t\t\t\t\t\t\t<!-- Header -->\r\n");
      out.write("\t\t\t\t\t\t\t\t<header id=\"header\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a class=\"logo\"><strong>고객센터</strong></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</header>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<!-- Content -->\r\n");
      out.write("\t\t\t\t\t\t\t<section>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
 if(exception != null){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\tError : ");
      out.print( (String)request.getAttribute("message") );
      out.write(" 관리자에게 문의하세요.\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</section>\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Sidebar -->\r\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("\r\n");

	User loginUser2 = (User)session.getAttribute("loginUser");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t\t<title>DIE DIE</title>\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/diedie/assets/css/main.css\" />\r\n");
      out.write("\t\t<style type=\"text/css\">\r\n");
      out.write("\t\t\t.footerfont { border-bottom: dotted 1px; }\r\n");
      out.write("\t\t\t.footerfont:hover {\r\n");
      out.write("\t\t\tborder-bottom-color: #f56a6a;\r\n");
      out.write("\t\t\tcolor: #f56a6a !important;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t<!-- Sidebar -->\r\n");
      out.write("\t\t<div id=\"sidebar\">\r\n");
      out.write("\t\t\t<div class=\"inner\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<!-- Logo -->\r\n");
      out.write("\t\t\t\t\t<section class=\"alt\">\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"mini-posts\">\r\n");
      out.write("\t\t\t\t\t\t\t<article>\r\n");
      out.write("\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"/diedie/index.jsp\" class=\"image\"><img src=\"/diedie/images/logo2.png\" alt=\"\" /></a>\r\n");
      out.write("\t\t\t\t\t\t\t</article>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</section>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Menu -->\r\n");
      out.write("\t\t\t\t\t<nav id=\"menu\">\r\n");
      out.write("\t\t\t\t\t\t<header class=\"major\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>&nbsp;메뉴</h2>\r\n");
      out.write("\t\t\t\t\t\t</header>\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<!-- 샘픔데이터. 나중에 지워야 함 -->\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/diedie/generic.html\">generic</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/diedie/elements.html\">elememnts</a></li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/diedie/index.jsp\">&nbsp;홈</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t");
 if(loginUser2 == null){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/diedie/view/login/login.jsp\">&nbsp;로그인</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/diedie/view/join/join.jsp\">&nbsp;회원가입</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t");
 }else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/diedie/view/mypage/mypage.jsp\">&nbsp;마이페이지</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"opener\">&nbsp;칼로리</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">&nbsp;음식칼로리</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">&nbsp;운동칼로리</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/diedie/view/scheduler/scheduler.jsp\">&nbsp;스케쥴러</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/diedie/view/partner/partner.jsp\">&nbsp;파트너</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"opener\"><a href=\"/diedie/view/board/board.jsp\">&nbsp;게시판</a></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">&nbsp;공지사항</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">&nbsp;정보 공유</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">&nbsp;갤러리</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">&nbsp;질문 게시판</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">&nbsp;자유 게시판</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/diedie/view/fitness/fitness.jsp\">&nbsp;생활체육시설</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/diedie/view/service/service.jsp\">&nbsp;고객센터</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<!-- <li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"opener\">Another Submenu</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Lorem Dolor</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Ipsum Adipiscing</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Tempus Magna</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Feugiat Veroeros</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</li> -->\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Section -->\r\n");
      out.write("\t\t\t\t\t<section>\r\n");
      out.write("\t\t\t\t\t\t<header class=\"major\">\r\n");
      out.write("\t\t\t\t\t\t\t<h4>&nbsp;연락처</h4>\r\n");
      out.write("\t\t\t\t\t\t</header>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"contact\">\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"fa-envelope-o\">jjjein13@gmail.com</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</section>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- Footer -->\r\n");
      out.write("\t\t\t\t\t<footer id=\"footer\">\r\n");
      out.write("\t\t\t\t\t\t<p class=\"copyright\">Copyright ⓒ <font class=\"footerfont\">운동하고건강하조</font> All rights reserved.</p>\r\n");
      out.write("\t\t\t\t\t</footer>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Scripts -->\r\n");
      out.write("\t\t\t<script src=\"/diedie/assets/js/jquery.min.js\"></script>\r\n");
      out.write("\t\t\t<script src=\"/diedie/assets/js/browser.min.js\"></script>\r\n");
      out.write("\t\t\t<script src=\"/diedie/assets/js/breakpoints.min.js\"></script>\r\n");
      out.write("\t\t\t<script src=\"/diedie/assets/js/util.js\"></script>\r\n");
      out.write("\t\t\t<script src=\"/diedie/assets/js/main.js\"></script>\r\n");
      out.write("\r\n");
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