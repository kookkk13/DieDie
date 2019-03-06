<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DIE DIE</title>
		<link rel="stylesheet" href="/diedie/assets/css/main.css" />
	</head>
<script type="text/javascript" src="/diedie/assets/js/jquery-3.3.1.min.js"></script>

<body class="is-preload">
<!-- Wrapper -->
<div id="wrapper">

	<!-- Main -->
	<div id="main">
		<div class="inner">
			<!-- Header -->
				<header id="header">
					<a class="logo"><strong>공지사항</strong></a>
				</header>
				
<!-- 게시글 작성란 -->
<section>
<div class="row gtr-uniform">
	<div class="col-6 col-12-xsmall">
		<input type="text" name="title" placeholder="제목">
	</div>
	<div class="col-12">
		<textarea name="content" id="summernote"></textarea>
	</div>
</div>
	
	

			
			
			
			
			
			
</section>			
									
		</div>
	</div>


<!-- Sidebar -->
<%@ include file="../../common/sidebar.jsp" %>
</div>

<!-- Scripts -->
<script src="/diedie/assets/js/jquery.min.js"></script>
<script src="/diedie/assets/js/browser.min.js"></script>
<script src="/diedie/assets/js/breakpoints.min.js"></script>
<script src="/diedie/assets/js/util.js"></script>
<script src="/diedie/assets/js/main.js"></script>

</body>
</html>