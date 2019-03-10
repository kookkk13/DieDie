<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="calorie.food.model.vo.Food, java.util.*, java.sql.*" %>
<%
	Food f = (Food)request.getAttribute("food");
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
			function changeonce(){
				var once = $("#oncefood").val();
				var changevalue = once / <%= f.getOnceIn() %>
				$("#kcalfood").val((changevalue * <%= f.getCalorie() %>).toFixed(2));
			};
			function changekcal(){
				var kcal = $("#kcalfood").val();
				var changevalue = kcal / <%= f.getCalorie() %>
				$("#oncefood").val((changevalue * <%= f.getOnceIn() %>).toFixed(2));
			};
			function parentgo(){
				console.log("실행!");
				var value = "<%= f.getFoodName() %>" + "," + $("#oncefood").val() + "," + $("#kcalfood").val()
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
										<h2 style="word-break: break-word;"><%= f.getFoodName() %></h2>
										<table id=firsttable class="alt">
											
											<tbody>
												<tr>
													<td><b>칼로리</b></td>
													<td><b>1회 제공량</b></td>
												</tr>
												<tr>
													<td><%= f.getCalorie() %> kcal</td>
													<td><%= (int)f.getOnceIn() %> g</td>
												</tr>
											</tbody>
										</table>
										<table class="newtable">
											<tbody>
												<tr>
													<th>&nbsp; &nbsp;탄수화물</th>
													<td><%= f.getCarb() %> g</td>
												</tr>
												<tr>
													<th>&nbsp; &nbsp;단백질</th>
													<td><%= f.getProtein() %> g</td>
												</tr>
												<tr>
													<th>&nbsp; &nbsp;지방</th>
													<td><%= f.getFat() %> g</td>
												</tr>
												<tr>
													<th>&nbsp; &nbsp;당류</th>
													<td><%= f.getSugar() %> g</td>
												</tr>
												<tr>
													<th>&nbsp; &nbsp;나트륨</th>
													<td><%= f.getNa() %> mg</td>
												</tr>
											</tbody>
										</table>
										<hr>
										<h3>음식 칼로리 설정</h3>
										<table>
											<tr>
												<td>분량(g)</td>
												<td><input type="number" id="oncefood" name="oncefood" value="<%= f.getOnceIn() %>" onchange="changeonce();"></td>
											</tr>
											<tr>
												<td>칼로리(kcal)</td>
												<td><input type="number" id="kcalfood" name="kcalfood" value="<%= f.getCalorie() %>" onchange="changekcal();"></td>
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