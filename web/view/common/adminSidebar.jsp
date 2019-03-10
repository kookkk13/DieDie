<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
							<h2>&nbsp;관리자 페이지</h2>
						</header>
						<ul>
							<li><a href="index.jsp">&nbsp;홈</a></li>
							<li><a href="/diedie/view/login/login.html">&nbsp;로그인</a></li>
							<li><a href="/diedie/view/join/join.html">&nbsp;회원가입</a></li>
							<li><a href="/diedie/view/mypage/mypage.html">&nbsp;마이페이지</a></li>
							<li>
								<span class="opener">&nbsp;칼로리</span>
								<ul>
									<li><a href="#">&nbsp;음식칼로리</a></li>
									<li><a href="#">&nbsp;운동칼로리</a></li>
								</ul>
							</li>
							<li><a href="/diedie/view/scheduler/scheduler.html">&nbsp;스케쥴러</a></li>
							<li><a href="/diedie/view/partner/partner.html">&nbsp;파트너</a></li>
							<li>
								<span class="opener"><a href="/diedie/view/board/board.html">&nbsp;게시판</a></span>
								<ul>
									<li><a href="#">&nbsp;Lorem Dolor</a></li>
									<li><a href="#">&nbsp;Ipsum Adipiscing</a></li>
									<li><a href="#">&nbsp;Tempus Magna</a></li>
									<li><a href="#">&nbsp;Feugiat Veroeros</a></li>
								</ul>
							</li>
							<li><a href="/diedie/view/fitness/fitness.jsp">&nbsp;생활체육시설</a></li>
                            <li><a href="/diedie/view/service/service.html">&nbsp;고객센터</a></li>
                            
                            <br>
                            <span style="text-align: center;">관리자 메뉴</span>

							<li>
								<span class="opener">&nbsp;회원관리</span>
								<ul>
                                    <li><a href="/diedie/searchmem?page=1">&nbsp;전체회원 관리</a></li>
									<li><a href="/diedie/view/manager/member/sanctionMember.jsp">&nbsp;제재회원 관리</a></li>
								</ul>
							</li>
							<li><a href="/diedie/view/manager/board/boardSearch.jsp">&nbsp;게시글 관리</a></li>
							<li><a href="/diedie/view/manager/fitness/fitnessManager.jsp">&nbsp;운동시설 관리</a></li>
							<li>
								<span class="opener">&nbsp;고객센터 관리</span>
								<ul>
									<li><a href="/diedie/view/manager/service/FAQboardSearch.jsp">&nbsp;FAQ 관리</a></li>
									<li><a href="/diedie/view/manager/service/QNAboardSearch.jsp">&nbsp;QNA 관리</a></li>
								</ul>
							</li>
						</ul>
					</nav>


				<!-- Section -->
					<section>
						<header class="major">
							<h4>&nbsp;연락처</h4>
						</header>
						<ul class="contact">
							<li class="fa-envelope-o"><a href="#">jjjein13@gmail.com</a></li>
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