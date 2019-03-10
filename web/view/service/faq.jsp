<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./serviceError.jsp" %>
<%@ page import="service.faq.model.vo.FAQ, java.util.ArrayList" %>
<%
	ArrayList<FAQ> faqlist = (ArrayList<FAQ>)request.getAttribute("list");
 	int listCount = ((Integer)request.getAttribute("listCount")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue(); 
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DIE DIE</title>
		<script src="/diedie/assets/js/jquery.min.js"></script>
		<style type="text/css">
			a { border-bottom: none !important; }
		</style>
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
									<a class="logo"><strong>FAQ</strong></a>
								</header>

							<!-- Content -->
								<section>
									<div class="table-wrapper">
										<table class="col-6 col-12-midium">
											<thead>
												<tr>
													<th>제목</th>
												</tr>
											</thead>
											<tbody>
												<% for(FAQ faq : faqlist){ %>
												<tr>
													<td>
														<a href="/diedie/fdetail?fnum=<%= faq.getfNo() %>&page=<%= currentPage %>">
														<%= faq.getfTitle() %>
														</a>
													</td>
												</tr>
												<% } %>
											</tbody>
										</table>
									</div>
									
									<div align="right">
										<a href="/diedie/view/service/service.jsp" class="button small">이전
										</a>
									</div>
									<hr>
									
									<div>
										<ul class="pagination" align="center">
											<% if((currentPage - 10) < startPage && (currentPage - 10) > 1){ %>
												<li>
													<a href="/diedie/flist?page=<%= startPage - 10 %>" class="button">이전</a>
												</li>
											<% } %>
											<% for(int p = startPage; p <= endPage; p++){ 
												if(p == currentPage){%>
													<li>
														<a class="page active"><%= p %></a>
													</li>
												<% }else{ %>
													<li>
														<a href="/diedie/flist?page=<%= p %>" class="page"><%= p %></a>												
													</li>
												<% }} %>
											<% if((currentPage + 10) > endPage && (currentPage + 10) < maxPage){ %>
												<li>
													<a href="/diedie/flist?page=<%= endPage + 10 %>" class="button">다음</a>
												</li>
											<% } %>
										</ul>
									</div>
								</section>
				
						</div>
					</div>


				<!-- Sidebar -->
					<%@ include file="../common/sidebar.jsp" %>

			</div>

		<!-- Scripts -->

			<script src="/diedie/assets/js/browser.min.js"></script>
			<script src="/diedie/assets/js/breakpoints.min.js"></script>
			<script src="/diedie/assets/js/util.js"></script>
			<script src="/diedie/assets/js/main.js"></script>

	</body>
</html>