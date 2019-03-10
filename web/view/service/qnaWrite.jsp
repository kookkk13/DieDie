<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./serviceError.jsp" %>
<%@ page import="user.model.vo.User" %>
<%
	User loginUser = (User)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DIE DIE</title>
		<script src="/diedie/assets/js/jquery.min.js"></script>
		<script type="text/javascript">
			function pwd(){
				$("#qpwd").attr("type", "text");
			}
			function dispwd(){
				$("#qpwd").attr("type", "hidden")
			}
		</script>
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
									<form action="/diedie/qwrite" method="post" enctype="multipart/form-data">
										<table class="col-6 col-12-midium">
											<thead>
												<tr>
													<th width="100px;">게시글 작성</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<th colspan="4">
														<select name="qcategory">
															<option value="문의">문의</option>
															<option value="신고">신고</option>
														</select>
													</th>
												</tr>
												<tr>
													<th>제목</th>
													<td colspan="3"><input type="text" name="qtitle"></td>
												</tr>
												<tr>
													<th>작성자</th>													
													<td colspan="3"><input type="text" readonly name="qwriter" value="<%= loginUser.getUserId() %>"></td> 
												</tr>
												<tr>
													<th>비밀글</th>
													<td class="secret">
														<input type="radio" id="ok" name="secret" value="ok" onclick="pwd()">
														<label for="ok">비밀</label>
														<input type="radio" id="no" name="secret" value="no" onclick="dispwd()">
														<label for="no">공개</label>
													<td>
													<td>
														<input type="hidden" name="qpwd" id="qpwd">
													</td>
												</tr>
												<tr>
													<th>첨부파일</th>
													<td><input type="file" name="file1"></td>
													<td><input type="file" name="file2"></td>
													<td><input type="file" name="file3"></td>
												</tr>
												<tr>
													<th>내용</th>
													<td colspan="3"><textarea rows="17" cols="100" name="qcontent"></textarea></td>
												</tr>
											</tbody>
										</table>
										<div align="center">
										<input type="submit" class="button" value="등록">
										<a href="/diedie/qlist" class="button">이전</a>
										</div>
									</form>
								
								</section>					
		
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