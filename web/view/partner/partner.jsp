<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./partnerError.jsp" %>
<%@ page import="java.util.ArrayList, java.sql.Date, user.model.vo.User" %>
<%
	User loginUser = (User)session.getAttribute("loginUser");
	User partner = (User)request.getAttribute("partner");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DIE DIE</title>
		<script type="text/javascript">
			function delectPartner(){
				if(confirm("파트너를 해지하시겠습니까?") == true){
					location.href = "/diedie/pdelect?loginUser=" + "<%= loginUser.getUserId() %>";	
				}
			}
		</script>
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
								<section>
									<table>
										<tbody>
											<tr>
												<td rowspan="6" width="200">
												</td>
											</tr>
											<tr>
												<td></td>
												<th>닉네임</th>
												<td>
													<% if(partner != null){ %>
														<%= partner.getNickName() %>													
													<% }else{ %>
														없음
													<% } %>
												</td>
											</tr>
											<tr>
												<td></td>
												<th>성별</th>
												<td>
													<% if(partner != null){ %>
														<%= partner.getGender() %>													
													<% }else{ %>
														없음
													<% } %>
												</td>
											</tr>
											<tr>
												<td></td>
												<th>지역</th>
												<td>
													<% if(partner != null){ %>
														<%= partner.getAddress() %>													
													<% }else{ %>
														없음
													<% } %>
		
												</td>
											</tr>
											<tr>
												<td></td>
												<th>활동 점수</th>
												<td>
													<% if(partner != null){ %>
														<%= partner.getScore() %>													
													<% }else{ %>
														없음
													<% } %>
												</td>
											</tr>
											<tr>
												<td></td>
												<th>운동 목적</th>
												<td>
													<% if(partner != null){ %>
														<%= partner.getPurpose() %>													
													<% }else{ %>
														없음
													<% } %>
												</td>
											</tr>
										</tbody>
									</table>
									<% if(loginUser != null){ %>
									 	<% if(loginUser.getPartnerId() != null){ %>
											<div align="center">
												<a href="/diedie/view/partner/chatting.jsp" class="button">1:1 채팅</a> &nbsp;
												<button onclick="delectPartner()">파트너 해지</button>							
											</div>
											<br>
											<br>
											<table>
												<thead>
													<tr>
														<th>파일 이름</th>
														<th>보낸 사람</th>
														<th>보낸 날짜</th>
													</tr>
												</thead>
											</table>
									 	<% }else{ %> 
										<div align="center">
											<button onclick="location='view/partner/partnerSearch.jsp'" class="button primary">파트너 찾기</button>
										</div>
										<% } %>
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