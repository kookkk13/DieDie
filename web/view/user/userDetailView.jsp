<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./memberError.jsp" import="user.model.vo.User" %>
<%
	User loginUser = (User)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 보기</title>
<script type="text/javascript">
	function moveUpdatePage(){
		location.href = "/first/views/member/memberUpdatePage.jsp";
	}
	
</script>
</head>
<body>
<h1 align="center">
<%= loginUser.getUserNm() %> 님의 회원 정보
</h1>
<table align="center" width="600" border="1">
<tr height="20"><th bgcolor="orange">닉네임</th><td><%= loginUser.getNickName() %></td></tr>
<tr height="20"><th bgcolor="orange">이 름</th><td><%= loginUser.getUserNm() %></td></tr>
<tr height="20"><th bgcolor="orange">생년월일</th><td><%= loginUser.getBirth() %></td></tr>
<tr height="20"><th bgcolor="orange">성 별</th><td><%= loginUser.getGender() %></td></tr>
<tr height="20"><th bgcolor="orange">주 소</th><td><%= loginUser.getAddress() %></td></tr>
<tr height="20"><th bgcolor="orange">이메일</th><td><%= loginUser.getEmail() %></td></tr>
<tr height="20"><th bgcolor="orange">자기소개</th><td><%= loginUser.getProfile() %></td></tr>
<tr height="20"><th colspan="2">
<button onclick="moveUpdatePage();">수정페이지로 이동</button>
</th></tr>
</table>
</body>
</html>