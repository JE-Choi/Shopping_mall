/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.93
 * Generated at: 2019-06-09 18:34:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.ch08;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public final class connectionPool_005fjdbctest_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<!-- (1)JDBC쓰는 방법 _1 : connectionPool 쓰려면 꼭 import하기 -->\r\n");
      out.write("\t");
 request.setCharacterEncoding("utf-8"); 
      out.write("\r\n");
      out.write("\t<!-- (2) 요청에 대한 한글 처리를 위해서 추가 -->\r\n");
      out.write("\t");

		// 데이터베이스 연결 관련 변수 선언
		Connection conn = null;
		// 데이터베이스 연결로 부터 SQL문을 수행할 수 있도록 해주는 클래스
		PreparedStatement pstmt = null;
	
		try{
			// connectionPool 사용 -> 1)servers -> context.xml, 2) WEB-INF -> web.xml
			Context initContext = new InitialContext(); // Context객체 확보
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/mysql");
			conn = ds.getConnection(); //커넥션 얻기
			
			// 3단계: Statement생성
			String sql = "insert into jdbc_test values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,request.getParameter("username"));
			pstmt.setString(2, request.getParameter("email"));
			
			// 4단계: SQL문 전송
			if(request.getParameter("username") != null){
				// select이면 executeQuery()일것임.
				pstmt.executeUpdate();
			}
			// 5단계 결과 받기
			
			
		}catch(Exception e){
			System.out.println(e);
		}
	
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>ch08 : JDBC 테스트</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t<h2>이벤트 등록</h2>\r\n");
      out.write("\t<hr/>\r\n");
      out.write("\t<!-- 자기 자신에게 요청 보내기 -->\r\n");
      out.write("\t<form name=form1 method=post action=jdbctest.jsp>\r\n");
      out.write("\t\t등록이름: <input type=text name=username/>\r\n");
      out.write("\t\temail주소: <input type=text name=email size = 20/>\r\n");
      out.write("\t\t<input type=submit value= \"등록\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t<hr/>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t# 등록 목록 <p>\r\n");
      out.write("\t");

	 try{
		 String sql = "select username, email from jdbc_test";
		 
		 pstmt = conn.prepareStatement(sql);
		 
		 // select구문이기 때문에 이 함수로 실행하고 반환값 받음.
		 ResultSet rs = pstmt.executeQuery();
		 int i = 1;
		 
		 // 마지막 데이터까지 반복
		 while(rs.next()){
			 String username = rs.getString("username");
			 String email = rs.getString(2);
			 
			 out.println(i+" : "+username+" , "+email+"<br/>");
			 i++;
		 }
		 
		 // 사용 완료 후 자원 반납
		 rs.close();
		 pstmt.close();
		 conn.close();
	 }catch(Exception e){
		 System.out.println(e);
	 }
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t</p>\r\n");
      out.write("</body>\r\n");
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
