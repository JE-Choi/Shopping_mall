/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.93
 * Generated at: 2019-05-20 04:49:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.hw3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jspbook.hw3.*;

public final class c_005faddrbook_005fedit_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			"addrbook_error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"addrbook.css\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>고객 수정화면</title>\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction delcheck(){\r\n");
      out.write("\t\tresult = confirm(\"정말로 삭제하겠습니까?\");\r\n");
      out.write("\t\tif(result == true){ // 삭제 진행\r\n");
      out.write("\t\t\tdocument.form1.action.value = \"delete\";\r\n");
      out.write("\t\t\tdocument.form1.submit();\r\n");
      out.write("\t\t} else{ // 삭제 취소\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      jspbook.hw3.AddrBook ab = null;
      ab = (jspbook.hw3.AddrBook) _jspx_page_context.getAttribute("ab", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (ab == null){
        ab = new jspbook.hw3.AddrBook();
        _jspx_page_context.setAttribute("ab", ab, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("<H2>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(": 고객 수정화면 </H2>\r\n");
      out.write("<HR>\r\n");
      out.write("[<a href =\"productbook_control.jsp?action=clist\">고객 홈페이지로</a>]\r\n");
      out.write("<form name=form1 method=post action=addrbook_control.jsp>\r\n");
      out.write("<input type=hidden name=\"ab_id\" value=\"");
      out.print(ab.getAb_id());
      out.write("\">\r\n");
      out.write("<input type=hidden name = \"action\" value = \"cupdate\">\r\n");
      out.write(" \r\n");
      out.write("<table border=\"1\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("    <th>아이디</th>\r\n");
      out.write("    <td><input type=\"text\" name=\"ab_id\" value=\"");
      out.print(ab.getAb_id() );
      out.write("\" readonly></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <th>비밀번호</th>\r\n");
      out.write("    <td><input type=\"password\" name=\"ab_pwd\" value=\"");
      out.print(ab.getAb_pwd() );
      out.write("\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <th>이 름</th>\r\n");
      out.write("    <td><input type=\"text\" name=\"ab_name\" value=\"");
      out.print(ab.getAb_name() );
      out.write("\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <th>이메일</th>\r\n");
      out.write("    <td><input type=\"text\" name=\"ab_email\" value=\"");
      out.print(ab.getAb_email() );
      out.write("\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    <th>전화번호</th>\r\n");
      out.write("    <td><input type=\"text\" name=\"ab_tel\" value=\"");
      out.print(ab.getAb_tel() );
      out.write("\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("    <th>생 일</th>\r\n");
      out.write("    <td><input type=\"date\" name=\"ab_birth\" value=\"");
      out.print(ab.getAb_birth() );
      out.write("\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <th>회 사</th>\r\n");
      out.write("    <td><input type=\"text\" name=\"ab_comdept\" value=\"");
      out.print(ab.getAb_comdept() );
      out.write("\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <th>메 모</th>\r\n");
      out.write("    <td><input type=\"text\" name=\"ab_memo\" value=\"");
      out.print(ab.getAb_memo() );
      out.write("\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td colspan=2 align=center><input type=submit value=\"저장\"><input type=reset value=\"취소\"><input type=\"button\" value=\"삭제\" onClick=\"delcheck()\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
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
