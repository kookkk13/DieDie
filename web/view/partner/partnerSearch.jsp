<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DIE DIE</title>
		<style type="text/css">
			.gender {
				display: block !importants;
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
									<a class="logo"><strong>파트너 찾기</strong></a>
								</header>

							<!-- Content -->
								<form>
									<table>
										<tr>
											<th>지역</th>
											<td>
												<select name="location">
													<option value="seoul">서울
													<option value="gwangju">광주
													<option value="suwon">수원
													<option value="anyang">안양				
												</select>
										<tr>
											<th>성별</th>
											<td class="gender">
												<input type="radio" name="gender" value="f">여자
												<input type="radio" name="gender" value="m">남자
											</td>
										</tr>
										<tr>
											<th>나이</th>
											<td>
												<input type="number" name="age" min="20" max="120">
											<td>
										</tr>								
										<tr>
											<th>등급</th>
											<td>
												<input type="range" name="grade" vlaue="0" min="1" max="3" onchange="SetValue(this)">
											<td>
										</tr>								
									</table>
								</form>
								<div align="center">
									<input type="submit" value="조회">
								</div>
								<br>
								<br>
								
								<table>
									<tr>
										<th>이름</th>
										<th>성별</th>
										<th>나이</th>
										<th>지역</th>
										<th>목적</th>
										<th>등급</th>
									</tr>
								</table>
									
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