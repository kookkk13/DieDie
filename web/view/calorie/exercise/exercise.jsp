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
			function exerexer(){
				var searche = $("#searchexer").val();
				if(searche.length == 0 || searche == ""){
					alert("검색할 운동명을 입력해 주십시오.");
				} else {
					$.ajax({
						url: "/diedie/esearch",
						type: "get",
						data: {searchexer: searche},
						dataType: "json",
						success: function(data){
	
							var jsonStr = JSON.stringify(data);
							var json = JSON.parse(jsonStr);
							
							var values = "";
							
							if(json.list.length != 0){
								for(var i in json.list){
									values += "<tr><td></td><td>" + i + "</td><td>" + decodeURIComponent(json.list[i].ename).replace(/\+/gi, " ") +
									"</td><td>" + json.list[i].etime + "</td><td>" + json.list[i].ecalorie +"</td><td><button onclick='goexerdetail(" + json.list[i].eno + ");'>상세보기</button></td></tr>";
								}
							} else {
								values += "<tr><td colspan='6'>검색 결과가 없습니다.</td></tr>";
							}
							
							$("#exerlist").html(values);							
						},
						error: function(jqXHR, textStatus, errorThrown){
							console.log("error : " + jqXHR + ", " + testStatus + ", " + errorThrown);
						}
					}); //ajax
				} //ifelse
			}; //exerexer
			
			function goexerdetail(data){
				window.open("/diedie/edetail?eno=" + data, 'DIE DIE', 'width=400, height=560');
			};
			
			var selectArray = new Array();
			
			function imchange(){
				var text = $("#childcommon").val();
				if(selectArray[0] == null){
					selectArray[0] = text;
				} else {
					selectArray[selectArray.length] = text;
				}
				
				var exervalues = "";
				for(var i in selectArray){
					if(selectArray[i] != 0){
						var exervalue = selectArray[i].split(",");
						exervalues += "<tr><td>" + i + "</td><td>" + exervalue[0] +
						"</td><td>" + exervalue[1] + "</td><td>" + exervalue[2] +
						"</td><td><button onclick='deleterow(" + i + ");'>삭제</button></td></tr>";
					}
				}
				
				$("#selectlist").html(exervalues);
				
				var gogosh = "<tr><td></td><td>연동 날짜 : </td><td><input type='date' id='imdate'></td>" + 
				"<td colspan='2'><button>내 스케쥴러에 연동하기</button></td></tr>"
				
				$("#goscheduler").html(gogosh);
				
				document.getElementById('imdate').value = new Date().toISOString().slice(0, 10);
			}; //imchange
			
			function deleterow(no){
				selectArray[no] = 0;
				var exervalues = "";
				for(var i in selectArray){
					if(selectArray[i] != 0){
						var exervalue = selectArray[i].split(",");
						exervalues += "<tr><td>" + i + "</td><td>" + exervalue[0] +
						"</td><td>" + exervalue[1] + "</td><td>" + exervalue[2] +
						"</td><td><button onclick='deleterow(" + i + ");'>삭제</button></td></tr>";
					}
				}
				$("#selectlist").html(exervalues);
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
									<a href="/diedie/view/calorie/exercise/exercise.jsp" class="logo"><strong>운동 칼로리 계산</strong></a>
								</header>

							<!-- Content -->
								<section>
									<div class="row gtr-uniform">
										<div class="col-11">
											<input type="text" name="searchexer" id="searchexer" placeholder="운동명을 입력하세요." onKeyPress="if (event.keyCode==13){exerexer();}">
										</div>
										<div class="col-1">
											<button class="primary" onclick="exerexer();">검색</button>
										</div>
									</div>
								</section>
								<section>
									<h4>운동 칼로리 목록</h4>
									<div class=table-wrapper style="height: 350px;">
										<table class="mytable">
											<thead>
												<tr>
													<th></th>
													<th>번호</th>
													<th>운동명</th>
													<th>운동시간(분)</th>
													<th>60kg 기준 칼로리 소모량(kcal)</th>
													<th></th>
												</tr>
											</thead>
											<tbody id="exerlist">
											</tbody>
										</table>
									</div>
								</section>
								<section>
									<h4>추가한 운동 칼로리</h4>
									<div class=table-wrapper style="height: 350px;">
										<table class="mytable">
											<thead>
												<tr>
													<th>번호</th>
													<th>운동명</th>
													<th>운동시간(분)</th>
													<th>칼로리 소모량(kcal)</th>
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