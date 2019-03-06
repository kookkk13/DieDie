<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="board.model.vo.Board, java.util.*, java.sql.Date" %>

<%
	Board b = (Board)request.getAttribute("board");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
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
<div>
	<table>
		<thead>
			<tr>
				<th><%= b.getbTtitle()  %></th>
			</tr>
		</thead>
		<tbody>
		<tr>
			<td>작성자 : <%= b.getUserId() %></td>
			<td>작성일 : <%= b.getbDate() %></td>
			<td>조회수 : <%= b.getbHits() %></td>
		</tr>
		<tr>
			<td colspan="3">
				<%= b.getContent() %>
			</td>
		</tr>
		</tbody>
	</table>
</div>
<div align="left" !important;><a class="button small" href=/diedie/nlist?page<%= currentPage %>>목록</a></div>
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