<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./serviceError.jsp" %>
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
									<a class="logo"><strong>고객센터</strong></a>
								</header>

							<!-- Content -->
							
							<div id="centerWindow">
								<button class="button primary large" style="width: 300px; height: 200px; font-size: 25px;" onclick="location='/diedie/flist'">
									FAQ
								</button>
								<button class="button primary large" style="width: 300px; height: 200px; font-size: 25px;" onclick="location='/diedie/qlist'">
									QNA
								</button>
							</div>
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