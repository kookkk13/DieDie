<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>DIE DIE</title>
      <script type="text/javascript" src="/diedie/assets/js/jquery.min.js"></script>
      <script type="text/javascript"></script>
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
					<a class="logo"><strong>회원 가입 페이지</strong></a>
				</header>

				<!-- Content -->
				<head>
<meta charset="UTF-8">
<title>first</title>
<script type="text/javascript" src="/diedie/assets/js/jquery.min.js">
	
</script>
<script type="text/javascript">
	$(function() {
		$("input#userpwd2").blur(function() {
			var pwd = $("#userpwd").val();
			var pwd2 = $("#userpwd2").val();
			if (pwd != pwd2) {
				alert("입력한 암호와 일치하지 않습니다.\n" + "다시 입력하십시요.");
				$("#userpwd").select();
			}
		});
	});

	function checkValidate() {
		var userid = $("#userid").val();
		var userpwd = $("#userpwd").val();
		if (!(6 <= userid.length && userid.length <= 12)) {
			alert("아이디 길이가 요구조건에 만족하지 않습니다.");
			$("#userid").select();
			return false; 
		}

		
		if (!(6 <= userpwd.length && userpwd.length <= 12)) {
			alert("암호 길이가 요구조건에 만족하지 않습니다.");
			$("#userpwd").select();
			return false; 
		}

		
		for ( var i in userid) {
			var ch = userid.charAt(i);
			if (!(('A' <= ch && ch <= 'Z') || ('a' <= ch && ch <= 'z')
					|| ('0' <= ch && ch <= '9') || (ch == '#' || ch == '_'
					|| ch == '!' || ch == '*'))) {
				alert("아이디는 영어소문자, 대문자, 숫자, 기호문자(#,_,!,*)만 허용됩니다.");
				$("#userid").select();
				return false;
			}
		}

		for ( var i in userpwd) {
			var ch = userpwd.charAt(i);
			if (!(('A' <= ch && ch <= 'Z') || ('a' <= ch && ch <= 'z')
					|| ('0' <= ch && ch <= '9') || (ch == '#' || ch == '_'
					|| ch == '!' || ch == '*'))) {
				alert("암호는 영어소문자, 대문자, 숫자, 기호문자(#,_,!,*)만 허용됩니다.");
				$("#userpwd").select();
				return false;
			}
		}
		return true;

	}

	
	function checkValidate2() {
		var userid = $("#userid").val();
		var userpwd = $("#userpwd").val();

		var re = /^[:alpha:][\w\#\!\*]{6,12}$/;

		if (!re.test(userid)) {
			alert("아이디는 영어소문자, 대문자, 숫자, 기호문자(#,_,!,*)만 허용됩니다.");
			$("#userid").select();
			return false;
		}
		if (!re.test(userpwd)) {
			alert("암호는 영어소문자, 대문자, 숫자, 기호문자(#,_,!,*)만 허용됩니다.");
			$("#userpwd").select();
			return false;
		}

		return true;
	}

	function checkId() {
		$.ajax({
			url : "/first/idchk",
			type : "post",
			data : {
				userid : $("#userid").val()
			},
			success : function(data) {
				console.log("success : " + data);

				if (data == "ok") {
					alert("사용가능한 아이디 입니다.");
					$("#nickname").focus();
				} else {
					alert("이미 존재하는 아이디 입니다.\n" + "다시 입력하십시요.");
					$("#userid").select();
				}
			},
			error : function(jqXHR, textstatus, errorthrown) {
				console.log("error : " + jqXHR + ", " + textstatus + ", "
						+ errorthrown);
			}
		});

		return false;
	}

	function checkNnd() {
		$.ajax({
			url : "/first/nnchk",
			type : "post",
			data : {
				userid : $("#nickname").val()
			},
			success : function(data) {
				console.log("success : " + data);

				if (data == "ok") {
					alert("사용가능한 닉네임 입니다.");
					$("#username").focus();
				} else {
					alert("이미 존재하는 닉네임 입니다.\n" + "다시 입력하십시요.");
					$("#nickname").select();
				}
			},
			error : function(jqXHR, textstatus, errorthrown) {
				console.log("error : " + jqXHR + ", " + textstatus + ", "
						+ errorthrown);
			}
		});

		return false;
	}

	$.ready(function($) {
		$("input[name=exercise]:checkbox").change(function() {
			var cnt = $("#selCnt").val();
			if (cnt == $("input[name=exercise]:checkbox:checked").length) {
				$(":checkbox:not(:checked)").attr("disabled", "disabled");
			} else {
				$("input[name=exercise]:checkbox").removeAttr("disabled");
			}
		});

		$("#selCnt").change(function() {
			$("input[name=exercise]:checkbox").removeAttr("checked");
			$("input[name=exercise]:checkbox").removeAttr("disabled");
		});
	});
</script>

<select id="selCnt">
	<option value="1">1개까지 선택 가능</option>
	<option value="2">2개까지 선택 가능</option>
	<option value="3" selected="selected">3개까지 선택 가능</option>
	<option value="4">4개까지 선택 가능</option>
	<option value="5">5개까지 선택 가능</option>
	<option value="6">6개까지 선택 가능</option>
	<option value="7">7개까지 선택 가능</option>
</select>

<table border="1">
	<tr>
		<td><label><input type="checkbox" id="chk1" name="chk"
				value="1" /> <label for="chk1">체크박스 1</label></td>
		<td><label><input type="checkbox" id="chk2" name="chk"
				value="2" /> <label for="chk2">체크박스 2</label></td>
		<td><label><input type="checkbox" id="chk3" name="chk"
				value="3" /> <label for="chk3">체크박스 3</label></td>
		<td><label><input type="checkbox" id="chk4" name="chk"
				value="4" /> <label for="chk4">체크박스 4</label></td>
		<td><label><input type="checkbox" id="chk5" name="chk"
				value="5" /> <label for="chk5">체크박스 5</label></td>
		<td><label><input type="checkbox" id="chk6" name="chk"
				value="6" /> <label for="chk6">체크박스 6</label></td>
	</tr>
	<tr>
		<td><label><input type="checkbox" id="chk7" name="chk"
				value="1" /> <label for="chk7">체크박스 7</label></td>
		<td><label><input type="checkbox" id="chk8" name="chk"
				value="2" /> <label for="chk8">체크박스 8</label></td>
		<td><label><input type="checkbox" id="chk9" name="chk"
				value="3" /> <label for="chk9">체크박스 9</label></td>
		<td><label><input type="checkbox" id="chk10" name="chk"
				value="4" /> <label for="chk10">체크박스 10</label></td>
		<td><label><input type="checkbox" id="chk11" name="chk"
				value="5" /> <label for="chk11">체크박스 11</label></td>
		<td><label><input type="checkbox" id="chk12" name="chk"
				value="6" /> <label for="chk12">체크박스 12</label></td>
	</tr>
</table>

				</head>

				<body>

					<form action="/first/enroll" method="post"
						onsubmit="return checkValidate();">
						<table align="center" width="600" border="1">
							<tr>
								<th>*아이디</th>
								<td><input type="text" name="userid" id="userid"
									placeholder="6글자이상 12글자이하로 작성" required> &nbsp; &nbsp;
									<button onclick="return checkId();">아이디 중복확인</button></td>
							</tr>
							<tr>
								<th>*닉네임</th>
								<td><input type="text" name="nickname" id="nickname"
									placeholder="6글자이상 12글자이하로 작성" required> &nbsp; &nbsp;
									<button onclick="return checkNnd();">닉네임 중복확인</button></td>
							</tr>
							<tr>
								<th>*이 름</th>
								<td><input type="text" name="username" id="username"
									required></td>
							</tr>
							<tr>
								<th>*암 호</th>
								<td><input type="password" name="userpwd" id="userpwd"
									required></td>
							</tr>
							<tr>
								<th>암호확인</th>
								<td><input type="password" id="userpwd2" required></td>
							</tr>


							<tr>
								<td>생년월일</td>
								<td><input type="text" name="year"
									placeholder="예)2015년생  >> 2015"></input> <select>
										<option>1월</option>
										<option>2월</option>
										<option>3월</option>
										<option>4월</option>
										<option>5월</option>
										<option>6월</option>
										<option>7월</option>
										<option>8월</option>
										<option>9월</option>
										<option>10월</option>
										<option>11월</option>
										<option>12월</option>
								</select> <select>
										<option>1일</option>
										<option>2일</option>
										<option>3일</option>
										<option>4일</option>
										<option>5일</option>
										<option>6일</option>
										<option>7일</option>
										<option>8일</option>
										<option>9일</option>
										<option>10일</option>
										<option>11일</option>
										<option>12일</option>
										<option>13일</option>
										<option>14일</option>
										<option>15일</option>
										<option>16일</option>
										<option>17일</option>
										<option>18일</option>
										<option>19일</option>
										<option>20일</option>
										<option>21일</option>
										<option>22일</option>
										<option>23일</option>
										<option>24일</option>
										<option>25일</option>
										<option>26일</option>
										<option>27일</option>
										<option>28일</option>
										<option>29일</option>
										<option>30일</option>
										<option>31일</option>
								</select></td>
							</tr>


							<tr>
								<th>*성 별</th>
								<td><input type="radio" id="gender1" name="gender"
									value="M" required> <label for="gender1">남</label>
									&nbsp; &nbsp; <input type="radio" id="gender2" name="gender"
									value="F" required> <label for="gender2">여</label></td>
							</tr>
							<tr>
								<th>주소</th>
								<td><input type="text" name="address" id="address"></td>
							</tr>
							<tr>
								<th>전화번호</th>
								<td><input type="tel" name="phone"></td>
							</tr>
							<tr>
								<th>이메일</th>
								<td><input type="email" name="email"></td>
							</tr>
							<tr>
								<th>운동 목적</th>
								<td><input type="radio" id="purpose1" name="purpose"
									value="maintain"> <label for="purpose1">몸매 유지</label>
									&nbsp; &nbsp; &nbsp; <input type="radio" id="purpose2"
									name="purpose" value="decrease"> <label for="purpose2">체중
										감량</label> &nbsp; &nbsp; &nbsp; <input type="radio" id="purpose3"
									name="purpose" value="improve"> <label for="purpose3">체질
										개선</label></td>
							</tr>
							<tr>
								<th>선호 운동</th>
								<td>2개까지 선택가능!
									<table>
										<tr>
											<td><input type="checkbox" id="exercise1"
												name="exercise" value="climb"> <label
												for="exercise1">등산</label></td>
											<td><input type="checkbox" id="exercise2"
												name="exercise" value="walking"> <label
												for="exercise2">걷기</label></td>
											<td><input type="checkbox" id="exercise3"
												name="exercise" value="running"> <label
												for="exercise3">달리기</label></td>
										</tr>
										<tr>
											<td><input onclick=CountChecked(this) type="checkbox"
												id="exercise4" name="exercise" value="swimming"> <label
												for="exercise4">수영</label></td>
											<td><input onclick=CountChecked(this) type="checkbox"
												id="exercise5" name="exercise" value="spinning"> <label
												for="exercise5">자전거</label></td>
											<td><input onclick=CountChecked(this) type="checkbox"
												id="exercise6" name="exercise" value="aerobic"> <label
												for="exercise6">에어로빅</label></td>
										</tr>
										<tr>
											<td><input onclick=CountChecked(this) type="checkbox"
												id="exercise7" name="exercise" value="pushup"> <label
												for="exercise7">팔굽혀펴기</label></td>
											<td><input onclick=CountChecked(this) type="checkbox"
												id="exercise8" name="exercise" value="situp"> <label
												for="exercise8">윗몸일으키기</label></td>
											<td><input onclick=CountChecked(this) type="checkbox"
												id="exercise9" name="exercise" value="squat"> <label
												for="exercise9">스쿼트</label></td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<th>자기 소개</th>
								<td><textarea name="etc" rows="5" cols="50"></textarea></td>
							</tr>
							<tr>
								<th colspan="2"><input type="submit" value="가입하기">
									&nbsp; &nbsp; <input type="reset" value="입력취소"> &nbsp;
									&nbsp; <a href="/diedie/index.jsp">시작페이지로 이동</a></th>
							</tr>
						</table>
					</form>
				</body>

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