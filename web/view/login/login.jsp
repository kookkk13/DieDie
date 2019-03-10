<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.vo.User, java.util.*"%>
<%
	User loginUser = (User)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>DIE DIE</title>
      <script type="text/javascript" src="/diedie/assets/js/jquery.min.js"></script>
      <script type="text/javascript"></script>
      <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
      <link rel="stylesheet" href="/diedie/assets/css/main.css" />
   </head>
   <body class="is-preload">

      <!-- Wrapper -->
         <div id="wrapper">

            <!-- Main -->
               <div id="main">
                  <div class="inner">

                     <!-- Header -->
                        <header id="header">
                           <a class="logo"><strong>로그인</strong></a>
                        </header>

                     <!-- Content -->
				<section>
					<%-- 로그인하기 전일 때 보여지는 부분 --%>
					<%
						if (loginUser == null) {
					%>
					<!-- <form action="login" method="post"> -->
					<!-- 상대경로임. -->
					<form action="/diedie/login" method="post">
						<!-- 절대경로임. -->
						<table width="300" cellpadding="0" cellspacing="5" border="0">
							<tr>
								<td>아이디</td>
								<td><input type="text" name="userid"></td>
							</tr>
							<tr>
								<td>암 호</td>
								<td><input type="password" name="userpwd"></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="submit"
									value="로그인"> &nbsp; <a href="#">아이디조회</a> &nbsp; <a
									href="#">암호 조회</a></td>
							</tr>
						</table>
					</form>
					<%
						} else {
					%>
					<%-- 로그인한 상태일 때 보여지는 부분 --%>
					<table width="200" cellpadding="0" cellspacing="5" border="0">
						<tr>
							<td><%=loginUser.getUserNm()%>님 환영합니다!</td>
							<%-- 쿼리스트링(query string) 서블릿매핑이름?이름=값&이름=값 --%>
							<td><a
								href="/diedie/view/mypage/mypage.jsp">내
									정보 보기</a></td>
						</tr>
					</table>
					<% } %>
				</section>

			</div>
               </div>


            <!-- Sidebar -->
               <%@ include file="../common/sidebar.jsp" %>

         </div>

      <!-- Scripts -->
         <script src="/diedie/assets/js/jquery.min.js"></script>
         <script src="/diedie/assets/js/browser.min.js"></script>
         <script src="/diedie/assets/js/breakpoints.min.js"></script>
         <script src="/diedie/assets/js/util.js"></script>
         <script src="/diedie/assets/js/main.js"></script>

   </body>
</html>