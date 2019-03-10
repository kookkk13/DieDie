<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.model.vo.User" %>
<%
	User loginUser2;
	try {
		loginUser2 = (User)session.getAttribute("loginUser");
	} catch(Exception e) {
		loginUser2 = null;	
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DIE DIE</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="/diedie/assets/css/main.css" />
		<style type="text/css">
			.footerfont { border-bottom: dotted 1px; }
			.footerfont:hover {
			border-bottom-color: #f56a6a;
			color: #f56a6a !important;
			}
		</style>
	</head>
	<body>
	<!-- Sidebar -->
		<div id="sidebar">
			<div class="inner">
			
				<!-- Logo -->
					<section class="alt">			
						<div class="mini-posts">
							<article>
							<br>
								<a href="/diedie/index.jsp" class="image"><img src="/diedie/images/logo2.png" alt="" /></a>
							</article>
						</div>
					</section>

				<!-- Menu -->
					<nav id="menu">
						<header class="major">
							<h2>&nbsp;메뉴</h2>
						</header>
						<ul>
							<!-- 샘픔데이터. 나중에 지워야 함 -->
							<li><a href="/diedie/generic.html">generic</a></li>
							<li><a href="/diedie/elements.html">elememnts</a></li>


							<li><a href="/diedie/index.jsp">&nbsp;홈</a></li>
							<% if(loginUser2 == null){ %>
							<li><a href="/diedie/view/login/login.jsp">&nbsp;로그인</a></li>
							<li><a href="/diedie/view/join/join.jsp">&nbsp;회원가입</a></li>
		                    <% }else{ %>
		                     <li><a href="/diedie/logout">&nbsp;로그아웃</a></li>
		                     <li>
		                        <span class="opener">&nbsp;마이페이지</span>
		                        <ul>
		                           <li><a href="/diedie/view/mypage/mypage.jsp">&nbsp;내 정보</a></li>
		                           <li><a href="/diedie/view/mypage/userUpdatePage.jsp">&nbsp;회원정보 수정</a></li>
		                           <li><a href="#">&nbsp;비밀번호 변경</a></li>
		                           <li><a href="#">&nbsp;회원탈퇴</a></li>
		                        </ul>
		                     </li>
		                     <% } %>
		                     <li>
                        <span class="opener">&nbsp;칼로리</span>
                        <ul>
                           <li><a href="/diedie/view/calorie/food/food.jsp">&nbsp;음식칼로리</a></li>
                           <li><a href="/diedie/view/calorie/exercise/exercise.jsp">&nbsp;운동칼로리</a></li>
                       </ul>
                  		   </li>
                 		    <li><a href="/diedie/view/scheduler/scheduler.jsp">&nbsp;스케쥴러</a>
                 		    </li>
							<% if(loginUser2 != null){ %>
							<li><a href="/diedie/partner?loginUser=<%= loginUser2.getUserId() %>">&nbsp;파트너</a></li>
							<% }else{ %>
							<li><a href="/diedie/partner">&nbsp;파트너</a></li>
							<% } %>
							<li>
								<span class="opener">&nbsp;게시판</span>
								<ul>
									<li><a href="/diedie/nlist?page=1">&nbsp;공지사항</a></li>
									<li><a href="#">&nbsp;정보 공유</a></li>
									<li><a href="#">&nbsp;갤러리</a></li>
									<li><a href="#">&nbsp;질문 게시판</a></li>
									<li><a href="#">&nbsp;자유 게시판</a></li>
								</ul>
							</li>
							<li><a href="/diedie/view/fitness/fitness.jsp">&nbsp;생활체육시설</a></li>
							<li><a href="/diedie/view/service/service.jsp">&nbsp;고객센터</a></li>
							<!-- <li>
								<span class="opener">Another Submenu</span>
								<ul>
									<li><a href="#">Lorem Dolor</a></li>
									<li><a href="#">Ipsum Adipiscing</a></li>
									<li><a href="#">Tempus Magna</a></li>
									<li><a href="#">Feugiat Veroeros</a></li>
								</ul>
							</li> -->
						</ul>
					</nav>


				<!-- Section -->
					<section>
						<header class="major">
							<h4>&nbsp;연락처</h4>
						</header>
						<ul class="contact">
							<li class="fa-envelope-o">jjjein13@gmail.com</li>
						</ul>
					</section>
					
				<!-- Footer -->
					<footer id="footer">
						<p class="copyright">Copyright ⓒ <font class="footerfont">운동하고건강하조</font> All rights reserved.</p>
					</footer>

			</div>
		</div>
	</body>
</html>