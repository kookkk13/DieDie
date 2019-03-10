<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="boardError.jsp"%>
<%@ page import="board.model.vo.Board, java.util.ArrayList, java.sql.Date" %>
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	int listCount = ((Integer)request.getAttribute("listCount")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	String flag = (String)request.getAttribute("flag");
	//String category = (String)request.getAttribute("category");
	//String keyWord = (String)request.getAttribute("keyWord");
	User 	loginUser = null;
	loginUser = (User)session.getAttribute("loginUser");

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DIE DIE</title>
		<link rel="stylesheet" href="/diedie/assets/css/main.css" />
	
<script type="text/javascript" src="/diedie/assets/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function init(){
	<%if(keyWord !=null && category!=null){%>
		$("#keyWord").val();		
		$("#keyWord").val('<%=keyWord%>');
		$("#category").val(1);		
		$("#category").val(<%=category%>);
	<%}%>		
	}
	function searchPaging(cd,page){
		url = "/diedie/nsearch?";
		url += "category="+'<%=category%>';
		url += "&keyWord="+'<%=keyWord%>';
		if(cd ===1){
			// 이전
			url += "&page="+'<%=startPage -15%>';
		}else if(cd ===2){
			// 페이지
			url += "&page="+page;
		}else if(cd ===3){
			// 다음
			url += "&page="+'<%=endPage +15%>';
		}
		location.href = url;
	}
	
</script>
</head>
<body class="is-preload" onLoad="init()">

<!-- Wrapper -->
<div id="wrapper">

	<!-- Main -->
	<div id="main">
		<div class="inner">
			<!-- Header -->
				<header id="header">
					<a class="logo"><strong>공지사항</strong></a>
				</header>
				
<!-- 게시글 목록 -->
<section>
<div class="table-wrapper">
	<table>
		<%if(list.size() == 0){ %>
			<tr><td>검색 결과가 없습니다</td></tr>	
		<% }else{ %>
			<thead>
				<tr>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
			<% for(Board b : list){ %>		
				<tr>
					<td>
					<%if(loginUser!=null){%>
						<a style="border-bottom:none !important;" href="/diedie/ndetail?bnum=<%= b.getbNo() %>&page=<%= currentPage %>">
						<%= b.getbTtitle() %>
						</a>
					<%}else{%>
						<a style="border-bottom:none !important;" href="javascript:void(0)">
						<%= b.getbTtitle() %>
						</a>
					<%}%>
					</td>
					<td><%= b.getUserId() %></td>
					<td><%= b.getbDate() %> </td>
					<td><%= b.getbHits() %></td>
				</tr>		
			<% } %>
		<% } %>
		</tbody>
	</table>
	<form method="get" name="search" action="/diedie/nsearch">
		<div class="row gtr-uniform">
			<div>
				<select name="category" id="category">
					<option value="1">제목</option>
					<option value="2">작성자</option>
					<option value="3">내용</option>
					<option value="4">제목+작성자</option>
				</select>
			</div>
			<div style="width:80%;">
				<input type="text" placeholder="검색어 입력" name="keyWord" id="keyWord">
			</div>
		</div>
		<div style="text-align:right;">
			<input type="submit" class="button small" value="검색">
			<a class="button small" href="/diedie/view/board/notice/noticeWrite.jsp">글쓰기</a>
		</div>
	</form>
</div>

<!-- 페이지 숫자 -->
<div>
	<div>
	<%
		if("list".equals(flag)){
	%>
	<ul class="pagination" align="center">
		<!-- 이전 -->
		<% if((currentPage - 10) < startPage && (currentPage -10) > 1){ %>
			<li>
				<a href="/diedie/nlist?page=<%= startPage -15 %>" class="button">이전</a>
			</li>
		<% } %>
		
		
		<!-- 페이지 번호 -->
		<% for(int p = startPage; p <= endPage; p++){
			if(p == currentPage){%>
				<li>
					<a class="page active"><%= p %></a>
				</li>
		<% }else{ %>
			<li>
				<a href="/diedie/nlist?page=<%= p %>" class="page"><%= p %></a>
			</li>
		<% 	  }//if 
			}//for%>
			
		<!--  다음 -->	
		<% if((currentPage + 10)>endPage && (currentPage + 10) < maxPage){ %>
			<li>
				<a href="/diedie/nlist?page<%= endPage + 15 %>" class="button">다음</a>
			</li>
		<% } %>
		</ul>		
	<%}else if("search".equals(flag)){ %>
	<ul class="pagination" align="center">
		<!-- 이전 -->
		<% if((currentPage - 10) < startPage && (currentPage -10) > 1){ %>
			<li>
				<a href="javascript:searchPaging(1)" class="button">이전</a>
			</li>
		<% } %>
		
		
		<!-- 페이지 번호 -->
		<% for(int p = startPage; p <= endPage; p++){
			if(p == currentPage){%>
				<li>
					<a class="page active"><%= p %></a>
				</li>
		<% }else{ %>
			<li>
				<a href="javascript:searchPaging(2,<%=p %>)" class="page"><%=p %></a>
			</li>
		<% 	  }//if 
			}//for%>
			
		<!--  다음 -->	
		<% if((currentPage + 10)>endPage && (currentPage + 10) < maxPage){ %>
			<li>
				<a href="javascript:searchPaging(3)" class="button">다음</a>
 			</li>
		<% } %>
		</ul>		
	<%} %>
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
