<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./memberError.jsp" %>
<%@ page import="user.model.vo.User" %>
<%
	User user = (User)session.getAttribute("loginUser");
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
                           <a class="logo"><strong>회원정보 수정</strong></a>
                        </header>

                     <!-- Content -->
				<head>

<script type="text/javascript">
	function checkValidate() {
		var pwd1 = document.getElementById("userpwd");
		var pwd2 = document.getElementById("userpwd2");

		if (pwd1.value != pwd2.value) {
			alert("암호와 암호확인이 일치하지 않습니다.\n" + "다시 확인하고 입력하십시요.");
			pwd1.select();
			return false; //submit 취소
		} else {
			return true; //submit 실행
		}
	}
</script>
				</head>
				<body>

					<h3><%=user.getUserNm()%>
						님의 회원 정보 수정페이지
					</h3>
					<form action="/diedie/uupdate" method="post"
						onsubmit="return checkValidate();">
						<table align="center" width="600" border="1">
							<tr>
								<th>아이디</th>
								<td><input type="text" name="userid"
									value="<%=user.getUserId()%>" readonly></td>
							</tr>
							<tr>
								<th>이 름</th>
								<td><input type="text" name="username"
									value="<%=user.getUserNm()%>"></td>
							</tr>
							<tr>
								<th>닉네임</th>
								<td><input type="text" name="nickname"
									value="<%=user.getNickName()%>"></td>
							</tr>
							<tr>
								<th>암 호</th>
								<td><input type="password" id="userpwd1"
									value="<%=user.getUserPwd()%>"></td>
							</tr>
							<tr>
								<th>암호확인</th>
								<td><input type="password" id="userpwd2"
									value="<%=user.getUserPwd()%>"></td>
							</tr>
							<tr>
								<th>성 별</th>
								<td>
									<%
										if (user.getGender().equals("M")) {
									%> <input type="radio"
									id="gender1" name="gender" value="M" checked> <label
									for="gender1">남</label> &nbsp; &nbsp; <input type="radio"
									id="gender2" name="gender" value="F"> <label
									for="gender2">여</label> <%} else {%> <input type="radio"
									id="gender1" name="gender" value="M"> <label
									for="gender1">남</label> &nbsp; &nbsp; <input type="radio"
									id="gender2" name="gender" value="F" checked> <label
									for="gender2">여</label> <%}%>
								</td>
							</tr>
							<tr>
								<th>주소</th>
								<td><input type="text" name="address" id="address"></td>
							</tr>
							<tr>
								<th>이메일</th>
								<td><input type="email" name="email"
									value="<%= user.getEmail() %>"></td>
							</tr>
							<tr>
								<th>자기 소개</th>
								<td><textarea name="etc" rows="5" cols="50"><%= user.getProfile() %></textarea></td>
							</tr>
							<tr>
								<th>가입날짜</th>
								<td><input type="date" name="enrolldate"
									value="<%= user.getEnrollDate() %>" readonly></td>
							</tr>
							<tr>
								<th colspan="2"><input type="submit" value="수정하기">
									&nbsp; &nbsp; <a href="javascript:history.go(-1);">이전페이지로
										이동</a></th>
							</tr>
						</table>
					</form>

				</body>

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