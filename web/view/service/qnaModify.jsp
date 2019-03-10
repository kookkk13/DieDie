<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./serviceError.jsp" %>
<%@ page import="user.model.vo.User, service.qna.model.vo.QNA" %>
<%
	User loginUser = (User)session.getAttribute("loginUser");
	QNA qna = (QNA)request.getAttribute("qna");
	int currentPage = ((Integer)request.getAttribute("page")).intValue();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DIE DIE</title>
		</style>
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
									<form action="/diedie/qmodify?qno=<%= qna.getqNo() %>&page=<%= currentPage %>" method="post" enctype="multipart/form-data">
										<table class="col-6 col-12-midium">
											<thead>
												<tr>
													<th width="100px;">게시글 수정</th>
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
													<td colspan="3">
														<input type="text" name="qtitle" value="<%= qna.getqTitle() %>">
													</td>
												</tr>
												<tr>
													<th>작성자</th>													
													<td colspan="3">
														<input type="text" readonly name="qwriter" value="<%= loginUser.getUserId() %>">
													</td> 
												</tr>
												<tr>
													<th>비밀번호</th>
													<td colspan="3">
														<input type="text" name="qpwd" value="<%= qna.getPwd() %>">
														</td>
												</tr>
												<tr>
													<% if(qna.getFile1() != null){ %>
													<td colspan="3"><input type="file" name="file1" value="<%= qna.getFile1() %>"></td>
														<% if(qna.getFile2() != null){ %>
															<td colspan="2"><input type="file" name="file2" value="<%= qna.getFile2() %>"></td>
															<% if(qna.getFile3() != null){ %>
																<td colspan="1"><input type="file" name="file3" value="<%= qna.getFile3() %>"></td>
															<% } %>
														<% } %>
													<% }else{ %>
													<th>첨부파일</th>
													<td><input type="file" name="file1"></td>
													<td><input type="file" name="file2"></td>
													<td><input type="file" name="file3"></td>
													<% } %>
												</tr>
												<tr>
													<th>내용</th>
													<td colspan="3">
														<textarea rows="17" cols="100" name="qcontent"><%= qna.getContents() %></textarea>
													</td>
												</tr>
											</tbody>
										</table>
										<div align="center">
										<input type="submit" class="button" value="수정">
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
			<script src="/diedie/assets/js/jquery.min.js"></script>
			<script src="/diedie/assets/js/browser.min.js"></script>
			<script src="/diedie/assets/js/breakpoints.min.js"></script>
			<script src="/diedie/assets/js/util.js"></script>
			<script src="/diedie/assets/js/main.js"></script>

	</body>
</html>