<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./serviceError.jsp" %>
<%@ page import="service.qna.model.vo.QNA, user.model.vo.User, service.qna.model.vo.QNAReply, java.util.ArrayList" %>
<%
	QNA qna = (QNA)request.getAttribute("qna");
	int qno = qna.getqNo();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	ArrayList<QNAReply> list = (ArrayList<QNAReply>)request.getAttribute("list");
	
	User loginUser = (User)session.getAttribute("loginUser");
%>
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
									<a class="logo"><strong>QNA</strong></a>
								</header>

							<!-- Content -->
								<section>
									<div class="table-wrapper">
										<table class="col-6 col-12-midium">
											<thead>
												<tr>
													<th>
														<%= qna.getqTitle() %>
													</th>
													<th>
														<%= qna.getCategory() %>
													</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>
														 <%= qna.getUserId() %>
													</td>
													<td>
														 <%= qna.getqHits() %>
													</td>
													<td align="right">
														 <%= qna.getqDate() %>
													</td>
												</tr>
												<tr>
												<% if(qna.getFile1() != null){ %>
													<td width="700px;">
														첨부파일 : 
														<a href="/diedie/fdown?fname=<%= qna.getFile1() %>&frename<%= qna.getRefile1() %>"></a>
														<% if(qna.getFile2() != null){ %>
															&nbsp; | <%= qna.getFile2() %>
														<% } %>
														<% if(qna.getFile3() != null){ %>
															&nbsp; | <%= qna.getFile3() %>
														<% } %>
													</td>
												</tr>
												<% } %>
	
												<tr>
													<td colspan="3">
														<%= qna.getContents() %>
														<br>
														<br>
														<br>
													</td>
												</tr>
											</tbody>
										</table>
									</div>
									
									<div id="replyList"></div>
									
									
									<div align="right">
										<a href="/diedie/qlist" class="button small">목록</a>
										<% if(loginUser.getUserId().equals(qna.getUserId())){ %>
										<a href="/diedie/qmoview?qno=<%= qna.getqNo() %>&page=<%= currentPage %>" class="button small">수정</a>
										<a onclick="deleteQna();" class="button small">삭제</a>
										<script type="text/javascript">
											function deleteQna(){
												if(confirm('게시물을 삭제하시겠습니까?') == true){
													location.href = "/diedie/qdelete?qno=<%= qno %>";
												}else {
													location.href = "/diedie/qdetail?qno=<%= qno %>";
												} 
											}
										</script>
										<% } %>
									</div>
									
									<!-- 댓글 -->
									<br>
									<div>
									</div>
									
										<div class="table wrapper" align="center" style="float: left;">
											<% if(list != null){ %>
												<% for(QNAReply qr : list){ %>
													<div class="box" style="height: 100px;">
														<%= qr.getUserId() %>
														<%= qr.getQdate() %>
														<br>
														<%= qr.getContent() %>
													</div>		
												<% } %>
											<% } %>
										<div>
											<textarea name="demo-message" id="demo-message" rows="1" style="width: 850px;" placeholder="댓글을 입력하세요."></textarea>
											<a href="/diedie/qrwrite" class="button primary" style="margin-left: 5px; height: 44px; float: left;">등록</a>
											</div>
										</div>
									
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