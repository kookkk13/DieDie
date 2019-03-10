<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./partnerError.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DIE DIE</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="/diedie/assets/css/main.css" />
		<script src="/diedie/assets/js/jquery.min.js"></script>
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
								<div>
									<form action="/diedie/plist" method="post" name="condition" id="condition">
										<table>
											<tr>
												<th>지역</th>
												<td colspan="2">
													<select id="location" name="location">
														<option value="서울">서울</option>
														<option value="경기">경기</option>
													</select>
												</td>
											<tr>
												<th>성별</th>
												<td class="gender">
													<input type="radio" id="f" name="gender" value="F">
													<label for="f">여자</label>
													<input type="radio" id="m" name="gender" value="M">
													<label for="m">남자</label>
												</td>
											</tr>
											<tr>
												<th>나이</th>
												<td class="age">
													<input type="radio" id="c2" name="age" value="2">
													<label for="c2">20대</label>
													<input type="radio" id="c3" name="age" value="3">
													<label for="c3">30대</label>
													<input type="radio" id="c4" name="age" value="4">
													<label for="c4">40대</label>
													<input type="radio" id="c5" name="age" value="5">
													<label for="c5">50대</label>
													<input type="radio" id="c6" name="age" value="6">
													<label for="c6">60대</label>
													<input type="radio" id="c7" name="age" value="7">
													<label for="c7">70대</label>
													<input type="radio" id="c8" name="age" value="8">
													<label for="c8">80대</label>
													
												<td>
											</tr>								
											<tr>
												<th>활동 점수</th>
												<td>
													<select id="score" name="score">
														<option value="0">0~1000</option>
														<option value="1001">1001~2500</option>
														<option value="2501">2501~4500</option>
													</select>
												<td>
											</tr>								
										</table>
										<div align="center">
											<input type="submit" class="button" value="조회">
										</div>
									</form>
									<br>
									<br>
									
							</div>
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