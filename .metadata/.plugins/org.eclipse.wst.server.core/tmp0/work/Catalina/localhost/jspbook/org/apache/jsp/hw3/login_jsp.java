/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.93
 * Generated at: 2019-05-20 04:48:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.hw3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
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
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"addrbook_error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
 request.setCharacterEncoding("utf-8"); 
      out.write('\r');
      out.write('\n');
      jspbook.hw3.LoginBean login = null;
      login = (jspbook.hw3.LoginBean) _jspx_page_context.getAttribute("login", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (login == null){
        login = new jspbook.hw3.LoginBean();
        _jspx_page_context.setAttribute("login", login, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("login"), request);
      out.write('\r');
      out.write('\n');
      jspbook.hw3.AddrBean ab = null;
      ab = (jspbook.hw3.AddrBean) _jspx_page_context.getAttribute("ab", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (ab == null){
        ab = new jspbook.hw3.AddrBean();
        _jspx_page_context.setAttribute("ab", ab, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("<HTML>\r\n");
      out.write("<HEAD><TITLE>MyShoppingMall : 로그인 </TITLE></HEAD>\r\n");
      out.write("<BODY>\r\n");
      out.write("<div align=center>\r\n");
      out.write("<H2>로그인 예제</H2>\r\n");
      out.write("<HR>\r\n");
 
	if(!login.checkUser()) {// 관리자가 아닌경우
		if(!ab.checkUser(request.getParameter("userid"), request.getParameter("passwd"))){
			// 일반 고객도 아님.
			out.println("로그인 실패 !!");	
			pageContext.include("login_form.html");
		} else{
			// 사용자 로그인인 경우
			session.setAttribute("id", request.getParameter("userid"));
			//response.sendRedirect("customer_home.jsp");
			//최종 소스
			// list와 분별하기 위하여 clist라고 지칭.
			response.sendRedirect("productbook_control.jsp?action=clist");
			
		}
	}
	else {
		// 관리자 로그인 성공인 경우
		session.setAttribute("id", "관리자");
		response.sendRedirect("manager_home.jsp");
		// 또는
		// pageContext.forward("productbook_control.jsp?action=list");
	}

      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</BODY>\r\n");
      out.write("</HTML>");
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
