<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>DIE DIE</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/diedie/assets/css/main.css" />
<style>
h2 {
	padding-top: 0px;
}

* {
	padding-left: 10px;
}

select option {
	text-align: center;
}

select, select option {
	background-color: darkgrey !important;
	font-weight: bold !important;
	color: black !important;
}
</style>
</head>

<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<a href="/diedie/index.jsp" class="logo"><strong>DIE
							DIE</strong></a>
				</header>

				<!-- Content -->

				<p style="padding-top: 10px;">
				<h2 style="font-family: '나눔스퀘어라운드'; font-size: 20pt">제재 회원관리</h2>
				</p>
				<font face="나눔스퀘어라운드" size="2pt">- 제재당한 회원을 검색, 관리 할 수 있습니다.</font>
				<br>
				<form id="test" style="padding-top: 15px">
					<select id="class" style="width: 100px; height: 40px; float: left;">
						<option selected>아이디</option>
						<option>이름</option>
						<option>닉네임</option>
					</select><input type="text" style="width: 200px; height: 40px;"><img
						src="/diedie/images/검색.png"
						style="width: 37px; position: absolute; left: 360px; top: 250px;">
				</form>

				<article
					style="width: 900px; height: 350px; border: 1px solid white; background: azure;">
					<table>
						<tr>
							<th>1</th>
							<th>2</th>
							<th>3</th>
							<th>4</th>
							<th>5</th>
							<th>6</th>
						</tr>
						<tr>
							<th>1</th>
							<th>2</th>
							<th>3</th>
							<th>4</th>
							<th>5</th>
							<th>6</th>
						</tr>

					</table>
				</article>
				<div>
					<ul class="pagination">
						<li><span class="button disabled">Prev</span></li>
						<li><a href="#" class="page active">1</a></li>
						<li><a href="#" class="page">2</a></li>
						<li><a href="#" class="page">3</a></li>
						<li><span>…</span></li>
						<li><a href="#" class="page">8</a></li>
						<li><a href="#" class="page">9</a></li>
						<li><a href="#" class="page">10</a></li>
						<li><a href="#" class="button">Next</a></li>
					</ul>
				</div>



			</div>
		</div>


		<!-- Sidebar -->
		<%@ include file="../../common/adminSidebar.jsp"%>

	</div>

	<!-- Scripts -->
	<script src="/diedie/assets/js/jquery.min.js"></script>
	<script src="/diedie/assets/js/browser.min.js"></script>
	<script src="/diedie/assets/js/breakpoints.min.js"></script>
	<script src="/diedie/assets/js/util.js"></script>
	<script src="/diedie/assets/js/main.js"></script>

</body>

</html>