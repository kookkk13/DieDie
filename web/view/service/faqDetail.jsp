<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="service.faq.model.vo.FAQ" errorPage="./serviceError.jsp" %>
<%
	FAQ faq = (FAQ)request.getAttribute("faq");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DIE DIE</title>
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
									<a class="logo"><strong>고객센터</strong></a>
								</header>

							<!-- Content -->
								<section>
									<div class="table-wrapper">
										<table class="col-6 col-12-midium">
											<thead>
												<tr>
													<th>
														<%= faq.getfTitle() %>
													</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>
														<%= faq.getContent() %>
														<br>
														<br>
														<br>
													</td>
												</tr>
											</tbody>
										</table>
									</div>
									<div align="right">
										<a href="/diedie/flist" class="button small">목록</a>
									</div>
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