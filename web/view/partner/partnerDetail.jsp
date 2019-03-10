<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.model.vo.User" %>
<%
	User user = (User)request.getAttribute("partner");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DIE DIE</title>
		<style type="text/css">
			.gender {
				display: block !importants;
			}
		</style>
		<script src="/diedie/assets/js/jquery.min.js"></script>
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
									<a class="logo"><strong>프로필</strong></a>
								</header>

							<!-- Content -->
									<div style="height: 180px;">
										<table>
											<tbody>
												<tr><th>닉네임</th><td><%= user.getNickName() %></td></tr>
												<tr><th>성별</th><td><%= user.getGender() %></td></tr>
												<tr><th>생일</th><td><%= user.getBirth() %></td></tr>
												<tr><th>지역</th><td><%= user.getAddress() %></td></tr>
												<tr><th>목적</th><td><%= user.getPurpose() %></td></tr>
												<tr><th>가입 날짜</th><td><%= user.getEnrollDate() %></td></tr>
												<tr><th>활동 점수</th><td><%= user.getScore() %></td></tr>
												<tr><th>자기 소개</th><td><%= user.getProfile() %></td></tr>
											</tbody>
										</table>
										<div align="center">
											<a class="button small" onclick="closepopup">닫기</a>
										</div>
									</div>
								</div>
							</div>
						</div>

		<!-- Scripts -->
			<script src="/diedie/assets/js/browser.min.js"></script>
			<script src="/diedie/assets/js/breakpoints.min.js"></script>
			<script src="/diedie/assets/js/util.js"></script>
			<script src="/diedie/assets/js/main.js"></script>

	</body>
</html>