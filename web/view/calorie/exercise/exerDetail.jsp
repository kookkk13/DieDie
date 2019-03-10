<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="calorie.exercise.model.vo.Exercise, java.util.*, java.sql.*" %>
<%
	Exercise e = (Exercise)request.getAttribute("exer");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DIE DIE</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="/diedie/assets/css/main.css" />
		<script src="/diedie/assets/js/jquery.min.js"></script>
		<style>
			#firsttable th, #firsttable td{ text-align: center !important }
			input[type=number]::-webkit-inner-spin-button,
			input[type=number]::-webkit-outer-spin-button,
			input[type=date]::-webkit-inner-spin-button,
			input[type=date]::-webkit-outer-spin-button {
    			-webkit-appearance: none;
   				 margin: 0;
			}
		</style>
		<script>
			function changetime(){
				var ctime = $("#timeexer").val();
				var weight = $("#weight").val();
				$("#kcalexer").val(((<%= e.getMet() %> * 3.5 * weight * ctime) * 0.001 * 5).toFixed(2));
			};
			function changekcal(){
				var kcal = $("#kcalexer").val();
				var weight = $("#weight").val();
				$("#timeexer").val((kcal / ((<%= e.getMet() %> * 3.5 * weight) * 0.001 * 5)).toFixed(2));
			};
			function changeweight(){
				var cweight = $("#weight").val();
				var ctime = $("#timeexer").val();
				$("#kcalexer").val(((<%= e.getMet() %> * 3.5 * cweight * ctime) * 0.001 * 5).toFixed(2));
			};
			function parentgo(){
				console.log("실행!");
				var value = "<%= e.getExerNm() %>" + "," + $("#timeexer").val() + "," + $("#kcalexer").val()
				window.opener.document.getElementById("childcommon").value = value;
				$(opener.location).attr("href", "javascript:imchange();");
				window.close();
			};
		</script>
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Content -->
								<section>
									<div class=table-wrapper style="width: 300px; margin: 0 auto; text-align: center;">
										<h2 style="word-break: break-word;"><%= e.getExerNm() %></h2>
										<table id=firsttable class="alt">
											<tbody>
												<tr>
													<td><b>칼로리 소모량</b></td>
													<td><b>운동시간</b></td>
												</tr>
												<tr>
													<td><%= e.getExerKcal() %> kcal</td>
													<td><%= (int)e.getExerTime() %> 분</td>
												</tr>
											</tbody>
										</table>
										<hr>
										<h3>운동 칼로리 설정</h3>
										<table>
											<tr>
												<td>몸무게(kg)</td>
												<td><input type="number" id="weight" name="weight" value="60" onchange="changeweight();"></td>
											</tr>
											<tr>
												<td>운동시간(분)</td>
												<td><input type="number" id="timeexer" name="timeexet" value="<%= e.getExerTime() %>" onchange="changetime();"></td>
											</tr>
											<tr>
												<td>칼로리 소모량(kcal)</td>
												<td><input type="number" id="kcalexer" name="kcalexer" value="<%= e.getExerKcal() %>" onchange="changekcal();"></td>
											</tr>
											<tr>
												<td colspan="2">
													<button class="primary" onclick="parentgo();">추가</button>
													&nbsp; &nbsp; &nbsp; &nbsp; 
													<button class="primary" onclick="window.close();">닫기</button>
												</td>
											</tr>
										</table>
									</div>
								</section>
							<!-- Content End!!!!!!!! -->
						</div>
					</div>
			</div>

		<!-- Scripts -->
			<script src="/diedie/assets/js/browser.min.js"></script>
			<script src="/diedie/assets/js/breakpoints.min.js"></script>
			<script src="/diedie/assets/js/util.js"></script>
			<script src="/diedie/assets/js/main.js"></script>
	</body>
</html>