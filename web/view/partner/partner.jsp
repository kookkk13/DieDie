<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, java.sql.Date, file.File, user.model.vo.User" %>
<%
	/* ArrayList<File> list = (ArrayList<File>)request.getAttribute("flist"); */
	
	User loginUser = (User)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DIE DIE</title>
		<script type="text/javascript" src="/diedie/resources/js/jquery-3.3.1.min.js"></script>
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
									<a class="logo"><strong>파트너</strong></a>
								</header>

							<!-- Content -->
								<table>
									<tr><td rowspan="6" width="200"></td></tr>
									<tr><td></td><th>이름</th><td>없음</td></tr>
									<tr><td></td><th>성별</th><td>없음</td></tr>
									<tr><td></td><th>나이</th><td>없음</td></tr>
									<tr><td></td><th>지역</th><td>없음</td></tr>
									<tr><td></td><th>등급</th><td>없음</td></tr>
								</table>
								<% if(loginUser != null){ %>
								<div align="center">
									<button onclick="location=windows.open('chatting.jsp', '1:1 채팅')">1:1 채팅</button> &nbsp;
									<button>파트너 해지</button>							
								</div>
								<br>
								<table>
									<tr></tr>
									<tr><th>파일 이름</th><th>보낸 사람</th><th>보낸 날짜</th></tr>
								</table>
								<% }else{ %>
									<div align="center">
									<button onclick="location='partnerSearch.jsp'">파트너 찾기</button>
									</div>
								<% } %>
						
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