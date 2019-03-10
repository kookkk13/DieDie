<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DIE DIE</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="/diedie/assets/css/main.css" />
		<script src="/diedie/assets/js/jquery.min.js"></script>
		<style>
			section { border-top: none !important; }
			table th { text-align: center !important; }
			.mytable { text-align: center; }
			.mytable button { box-shadow: inset 0 0 0 1px #f56a6a; height: 3em; line-height: 3em; padding: 0 2em; }
			.hidetext { display: none !important; }
			input[type=date]::-webkit-inner-spin-button,
			input[type=date]::-webkit-outer-spin-button {
    			-webkit-appearance: none;
   				 margin: 0;
			}
		</style>
		<script type="text/javascript">	
			function foodfood(){
				var searchf = $("#searchfood").val();
				if(searchf.length == 0 || searchf == ""){
					alert("검색할 음식명을 입력해 주십시오.");
				} else {
					$.ajax({
						url: "/diedie/fsearch",
						type: "get",
						data: {searchfood: searchf},
						dataType: "json",
						success: function(data){
	
							var jsonStr = JSON.stringify(data);
							var json = JSON.parse(jsonStr);
							
							var values = "";
							
							if(json.list.length != 0){
								for(var i in json.list){
									values += "<tr><td></td><td>" + i + "</td><td>" + decodeURIComponent(json.list[i].fname).replace(/\+/gi, " ") +
									"</td><td>" + json.list[i].foncein + "</td><td>" + json.list[i].fcalorie +
									"</td><td><button onclick='gofooddetail(" + json.list[i].fno + ");'>상세보기</button></td></tr>";
								}
							} else {
								values += "<tr><td colspan='6'>검색 결과가 없습니다.</td></tr>";
							}
							
							$("#foodlist").html(values);							
						},
						error: function(jqXHR, textStatus, errorThrown){
							console.log("error : " + jqXHR + ", " + testStatus + ", " + errorThrown);
						}
					}); //ajax
				} //ifelse
			}; //foodfood
			
			function gofooddetail(data){
				window.open("/diedie/foodetail?fno=" + data, 'DIE DIE', 'width=400, height=760');
			};
			
			var selectArray = new Array();
			
			function imchange(){
				var text = $("#childcommon").val();
				if(selectArray[0] == null){
					selectArray[0] = text;
				} else {
					selectArray[selectArray.length] = text;
				}
				
				var foodvalues = "";
				for(var i in selectArray){
					if(selectArray[i] != 0){
						var foodvalue = selectArray[i].split(",");
						foodvalues += "<tr><td>" + i + "</td><td>" + foodvalue[0] +
						"</td><td>" + foodvalue[1] + "</td><td>" + foodvalue[2] +
						"</td><td><button onclick='deleterow(" + i + ");'>삭제</button></td></tr>";
					}
				}
				
				$("#selectlist").html(foodvalues);
				
				var gogosh = "<tr><td></td><td>연동 날짜 : </td><td><input type='date' id='imdate'></td>" + 
				"<td colspan='2'><button>내 스케쥴러에 연동하기</button></td></tr>"
				
				$("#goscheduler").html(gogosh);
				
				document.getElementById('imdate').value = new Date().toISOString().slice(0, 10);
			}; //imchange
			
			function deleterow(no){
				selectArray[no] = 0;
				var foodvalues = "";
				for(var i in selectArray){
					if(selectArray[i] != 0){
						var foodvalue = selectArray[i].split(",");
						foodvalues += "<tr><td>" + i + "</td><td>" + foodvalue[0] +
						"</td><td>" + foodvalue[1] + "</td><td>" + foodvalue[2] +
						"</td><td><button onclick='deleterow(" + i + ");'>삭제</button></td></tr>";
					}
				}
				$("#selectlist").html(foodvalues);
			};
		</script>
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
								<header id="header">
									<a href="/diedie/view/calorie/food/food.jsp" class="logo"><strong>음식 칼로리 계산</strong></a>
								</header>

							<!-- Content -->
								<section>
										<div class="row gtr-uniform">
											<div class="col-11">
												<input type="text" name="searchfood" id="searchfood" placeholder="음식명을 입력하세요." onKeyPress="if (event.keyCode==13){foodfood();}">
											</div>
											<div class="col-1">
												<button class="primary" onclick="foodfood();">검색</button>
											</div>
										</div>
								</section>
								<section>
									<h4>음식 칼로리 목록</h4>
									<div class=table-wrapper style="height: 350px;">
										<table class="mytable">
											<thead>
												<tr>
													<th></th>
													<th>번호</th>
													<th>음식명</th>
													<th>1회제공량(g)</th>
													<th>칼로리 섭취랑(kcal)</th>
													<th></th>
												</tr>
											</thead>
											<tbody id="foodlist">
											</tbody>
										</table>
									</div>
								</section>
								<section>
									<h4>추가한 음식 칼로리</h4>
									<div class=table-wrapper style="height: 350px;">
										<table class="mytable">
											<thead>
												<tr>
													<th>번호</th>
													<th>음식명</th>
													<th>제공량(g)</th>
													<th>칼로리 섭취량(kcal)</th>
													<th></th>
												</tr>
											</thead>
											<tbody id="selectlist">
												
											</tbody>
											<tfoot id="goscheduler">
											</tfoot>
										</table>
									</div>
								</section>
								<input class="hidetext" type="text" id="childcommon">
							<!-- Content End!!!!!!!! -->
						</div>
					</div>
					
				<!-- Sidebar -->
					<%@ include file="../../common/sidebar.jsp" %>
			</div>

		<!-- Scripts -->
			<script src="/diedie/assets/js/browser.min.js"></script>
			<script src="/diedie/assets/js/breakpoints.min.js"></script>
			<script src="/diedie/assets/js/util.js"></script>
			<script src="/diedie/assets/js/main.js"></script>

	</body>
</html>