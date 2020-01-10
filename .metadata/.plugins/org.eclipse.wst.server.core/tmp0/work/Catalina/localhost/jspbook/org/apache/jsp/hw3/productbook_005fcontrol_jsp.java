/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.93
 * Generated at: 2019-05-20 04:48:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.hw3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jspbook.hw3.*;
import java.util.*;

public final class productbook_005fcontrol_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=utf-8");
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
      out.write("\r\n");
      out.write("\r\n");
      jspbook.hw3.ProductBean pb = null;
      pb = (jspbook.hw3.ProductBean) _jspx_page_context.getAttribute("pb", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (pb == null){
        pb = new jspbook.hw3.ProductBean();
        _jspx_page_context.setAttribute("pb", pb, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write(' ');
      out.write('\r');
      out.write('\n');
      jspbook.hw3.ProductBook productbook = null;
      productbook = (jspbook.hw3.ProductBook) _jspx_page_context.getAttribute("productbook", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (productbook == null){
        productbook = new jspbook.hw3.ProductBook();
        _jspx_page_context.setAttribute("productbook", productbook, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("productbook"), request);
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
 
	// 액션값으로 컨트롤러 행위 분별
	String action = request.getParameter("action");

	// 파라미터에 따른 요청 처리
	// 쇼핑몰 목록 요청인 경우
	if(action.equals("list")) {
		ArrayList<ProductBook> datas = pb.getDBList();
		
		request.setAttribute("datas_product", datas);
		pageContext.forward("productbook_list.jsp");
		
	}
	else if(action.equals("clist")) {
		
		ArrayList<ProductBook> datas = pb.getDBList();
		request.setAttribute("datas_product", datas);
		
		// 고객 화면에서는 전환 되는 화면만 list action과 다르게 하겠다. (고객용 화면으로 전환하겠다) 
		pageContext.forward("c_productbook_list.jsp");
		
	}
	// 쇼핑몰 등록 요청인 경우
	else if(action.equals("insert")) {
		
		if(pb.insertDB(productbook)){// insert 성공
			response.sendRedirect("productbook_control.jsp?action=list");
		} else{ // insert 오류
			throw new Exception("DB 입력 오류");
		}
		
	}
	// 쇼핑몰 수정 페이지 요청인 경우
	else if(action.equals("edit")) {
		ProductBook pbook = pb.getDB(Integer.parseInt(request.getParameter("pb_id")));
		if(!request.getParameter("pwd").equals("1234")) {
			out.println("<script>alert('비밀번호가 틀렸습니다.!!'); history.go(-1); </script>");
			}
			else {
			request.setAttribute("pb",pbook);
			pageContext.forward("productbook_edit_form.jsp");
		}
	}
	// 쇼핑몰 업데이트 등록 요청인 경우
	else if(action.equals("update")) {
		if(pb.updateDB(productbook)){
			response.sendRedirect("productbook_control.jsp?action=list");
		} else{ 
			throw new Exception("DB 입력 오류");
		}
	}
	// 쇼핑몰 삭제 요청인 경우
	else if(action.equals("delete")) {
		if(pb.deleteDB(Integer.parseInt(request.getParameter("product_id")))){
			response.sendRedirect("productbook_control.jsp?action=list");
		} else{ 
			throw new Exception("DB 삭제 오류");
		}
	}
	else {
	}

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
