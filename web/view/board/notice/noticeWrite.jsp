<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DIE DIE</title>
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
						<a class="logo"><strong>고객센터</strong></a>
					</header>

				<!-- Content -->
					<section>
						<form action="/diedie/nwriter" method="post" enctype="multipart/form-data">
							<table class="col-6 col-12-midium">
								<thead>
									<tr>
										<th width="200px;">게시글 작성</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>제목</th>
										<td colspan="3"><input type="text" name="ntitle"></td>
									</tr>
									<tr>
										<th>작성자</th>													
										<td colspan="3"><input type="text" name="nwriter" value="작성자 ID"></td>
									</tr>								
									<tr>
										<th>첨부파일</th>
										<td>
											<input type="file" name="file1" class="button"><br>
											<input type="file" name="file2" class="button"><br>
											<input type="file" name="file3" class="button"><br>
										</td>
									</tr>
									<tr>
										<th>내용</th>
										<td colspan="3"><textarea rows="17" cols="100" name="ncontent"></textarea></td>
									</tr>
								</tbody>
							</table>
							<div align="center">
							<input type="submit" class="button" value="등록">
							<input type ="button" class="button" value="이전" onclick ="history.go(-1);">
							</div>
						</form>
					
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