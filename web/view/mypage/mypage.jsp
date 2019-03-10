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
                           <a class="logo"><strong>내 정보</strong></a>
                        </header>

                     <!-- Content -->
				<section>
					<head>

<script type="text/javascript">
	function moveUpdatePage() {
		location.href = "/diedie/view/mypage/userUpdatePage.jsp";
	}
</script>
					</head>
					<body>
						<h3><%=loginUser.getUserNm()%>
							님의 회원 정보
						</h3>

						<table align="center" width="600" border="1">
							<tr>
								<th>닉네임</th>
								<td><%=loginUser.getNickName()%></td>
							</tr>
							<tr>
								<th>이 름</th>
								<td><%=loginUser.getUserNm()%></td>
							</tr>
							<tr>
								<th>생년월일</th>
								<td><%=loginUser.getBirth()%></td>
							</tr>
							<tr>
								<th>성 별</th>
								<td><%=loginUser.getGender()%></td>
							</tr>
							<tr>
								<th>주 소</th>
								<td><%=loginUser.getAddress()%></td>
							</tr>
							<tr>
								<th>이메일</th>
								<td><%= loginUser.getEmail() %></td>
							</tr>
							<tr>
								<th>자기소개</th>
								<td><%= loginUser.getProfile() %></td>
							</tr>
							<tr>
								<th colspan="2">
									<button onclick="moveUpdatePage();">수정페이지로 이동</button>
								</th>
							</tr>
						</table>
					</body>
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