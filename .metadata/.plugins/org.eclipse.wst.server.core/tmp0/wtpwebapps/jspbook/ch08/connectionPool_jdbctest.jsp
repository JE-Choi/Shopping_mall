<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
 import="java.sql.*,javax.sql.*, javax.naming.*"%>
	<!-- (1)JDBC쓰는 방법 _1 : connectionPool 쓰려면 꼭 import하기 -->
	<% request.setCharacterEncoding("utf-8"); %>
	<!-- (2) 요청에 대한 한글 처리를 위해서 추가 -->
	<%
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
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ch08 : JDBC 테스트</title>
</head>
<body>
	<div align="center">
	<h2>이벤트 등록</h2>
	<hr/>
	<!-- 자기 자신에게 요청 보내기 -->
	<form name=form1 method=post action=jdbctest.jsp>
		등록이름: <input type=text name=username/>
		email주소: <input type=text name=email size = 20/>
		<input type=submit value= "등록"/>
	</form>
	
	<hr/>
	</div>
	
	# 등록 목록 <p>
	<%
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
	%>
	
	</p>
</body>
</html>