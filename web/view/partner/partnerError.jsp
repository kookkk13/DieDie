<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DIE DIE</title>
		<style type="text/css">
			#centerWindow {
				position: absolute;
				top: 50%;
				left: 45%;
				margin-top: -50px;
				margin-left: -50px;
			}
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
									<a class="logo"><strong>파트너</strong></a>
								</header>

							<!-- Content -->
							<section>
								<% if(exception != null){ %>
									Error : <%= (String)request.getAttribute("message") %> 관리자에게 문의하세요.													
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