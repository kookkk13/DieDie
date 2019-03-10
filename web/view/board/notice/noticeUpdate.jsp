<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="board.model.vo.Board"%> 
<%
	Board b = (Board)request.getAttribute("board");
	int currentPage = ((Integer)request.getAttribute("page")).intValue();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DIE DIE</title>
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
					<a class="logo"><strong>공지사항</strong></a>
				</header>

<!-- 게시글 상세보기 -->
<section>
	<form action="/diedie/nup" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" value="<%= b.getbNo() %>">
		<input type="hidden" name="ofile" value="<%= b.getFile1() %>">
		<input type="hidden" name="refile" value="<%= b.getRefile1() %>">
		<input type="hidden" name="page" value="<%= currentPage %>">
		<table class="col-6 col-12-midium">
			<thead>
				<tr>
					<th width="200px;">게시글 수정</th>
				</tr>
				</thead>
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3"><input type="text" name="ntitle" value="<%= b.getbTtitle() %>"></td>
					</tr>
					<tr>
						<th>작성자</th>													
						<td colspan="3"><input type="text" name="nwriter" value="<%= b.getUserId() %>"></td>
					</tr>								
 					<tr>
						<th>첨부파일</th>
						<td id=file><%= b.getFile1() %>&nbsp;&nbsp;&nbsp;
						<input type="file" value="파일첨부" id='file'>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea rows="17" cols="100" name="ncontent"><%= b.getContent() %></textarea></td>
					</tr>
				</tbody>
			</table>
			<div align="center">
			<input type="submit" class="button" value="완료">
			<a class="button" href="/diedie/nlist?page=<%= currentPage %>">취소</a>
					</div>
				</form>
			
			</section>					

	</div>
</div>

	<!-- Sidebar -->
	<%@ include file="../../common/sidebar.jsp" %>

			</div>

	<!-- Scripts -->
	<script src="/diedie/assets/js/jquery.min.js"></script>
	<script src="/diedie/assets/js/browser.min.js"></script>
	<script src="/diedie/assets/js/breakpoints.min.js"></script>
	<script src="/diedie/assets/js/util.js"></script>
	<script src="/diedie/assets/js/main.js"></script>

	</body>
</html>