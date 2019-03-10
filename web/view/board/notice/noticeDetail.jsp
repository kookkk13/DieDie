<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="board.model.vo.Board, java.util.*, java.sql.Date" %>

<%
	Board b = (Board)request.getAttribute("board");
	int currentPage = ((Integer)request.getAttribute("page")).intValue();
	User loginUser = null; 
	loginUser = (User)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
	<head>
	<script src="/diedie/assets/js/jquery.min.js"></script>
   <style>
        #popup {display:none;border:5px solid #cccccc;margin:0;padding:5px;background-color:#ffffff;z-index:5;}
        #popup .b-close {position:absolute;top:10px;right:15px;color:#f37a20;font-weight:bold;cursor:hand;}
        #popup .popupContent {margin:0;padding:0;text-align:center;border:0;}
        #popup .popupContent iframe {width:900px;height:700px;border:0;padding:0px;margin:0;z-index:10;}
   </style>
<script type="text/javascript" src="/diedie/resources/js/jquery.bpopup.min.js"></script>
<script type="text/javascript">
	//삭제 함수
	function deletePop(){
			var x,y;
    	    x = window.innerWidth/2.5;
        	y = window.innerHeight/3;
		$('#popup').bPopup({
			position: [x, y]
		});
		
		$('#deleteb').click(function(){
			sessionPwd = "<%= loginUser.getUserPwd() %>" ;
			userPwd = $('#userpwd').val();
			if(sessionPwd === userPwd){
					alert("삭제되었습니다.");
					location.href = "/diedie/ndel?bnum=<%=b.getbNo()%>";				
			} 
		});
	}
	function cancleb(){
		$('#popup').bPopup().close();
	}

	
	//댓글 
	//쓰기
	function writercom(){
	       $.ajax({
	    	   url: "/diedie/ncomwrite",
	    	   type:"post",
	    	   dataType: "json",
	           data:{
	       	     comContent:$("#inputComment").val(),
	             bno:<%= b.getbNo() %>,
	             userId:$("#userId").val()
	           },
	           success:function(data) {

	               if(data.result == 1) {       
	                   console.log("댓글 입력 완료!.");
	                   $("#inputComment").val("");
	                   showcom(data);
	               }else{
	            	   alert("댓글 입력 실패")
	               }
	           },
	           error: function(jqXHR, textstatus, errorthrown){
					console.log("error : " + jqXHR + ", " + textstatus
							+ ", " + errorthrown);
				}
	       });
	}
     function showcom(data) { 
    	 var id=data.userId;
		 var cnum=data.cnum;
    	 <% if(loginUser != null && loginUser.getUserId() != null ){ %>

	 		if(id==="<%=loginUser.getUserId()%>")
    	 	$('#comtable').append("<tr><td>"+decodeURIComponent(data.userId)+"</td><td>"
    	 			+decodeURIComponent(data.comContent)+"</td><td>"+data.date
    	 			+"</td><td><a class='button small'" + "href='/diedie/ndelcom?cnum="+cnum+"&page="+<%=currentPage%>+"&bnum="+<%=b.getbNo()%>+"'>삭제</td></tr>");
    	 <% } %>
        }
     function showcomList(){		 	 
     	 $.ajax({
    		url:"/diedie/ncomread",
    		data:{bnum:<%= b.getbNo() %>},
    		type: "post",
    		dataType: "json",
    		success: function(data){
    			console.log("값 불러옴")
    		 	var jsonStr = JSON.stringify(data);
    		 	var json = JSON.parse(jsonStr);
    		 	
    		 	for(var i in json.list){
    		 		var id = json.list[i].userId;
    		 		var cnum = json.list[i].cnum;
    		 		<% if(loginUser != null && loginUser.getUserId() != null ){ %>
    		 		if(id==="<%=loginUser.getUserId()%>"){
    		 			$('#comtable').append("<tr><td>"+decodeURIComponent(json.list[i].userId)+"</td><td>"
    	    	 				+decodeURIComponent(json.list[i].comContent)+"</td><td>"+json.list[i].date 
    	    	 				+"</td><td><a class='button small'" + "href='/diedie/ndelcom?cnum="+cnum+"&page="+<%=currentPage%>+"&bnum="+<%=b.getbNo()%>+"'>삭제</td></tr>");  	 		
    		 		<% } %>
    		 		}else{$('#comtable').append("<tr><td>"+decodeURIComponent(json.list[i].userId)+"</td><td>"
	    	 				+decodeURIComponent(json.list[i].comContent)+"</td><td>"+json.list[i].date 
	    	 				+"</td><td></td></tr>");
    		 		}
    		 	}
    		},
    		 error: function(jqXHR, textStatus, errorThrown){
                 console.log("error : " + textStatus);
    		 }
    	 }); 
     }  
    function conDelete(data){
    	
    }
 

</script>
		<meta charset="UTF-8">
		<title>DIE DIE</title>
		<link rel="stylesheet" href="/diedie/assets/css/main.css" />
	</head>
<body class="is-preload" onLoad="showcomList()">

<!-- Wrapper -->
<div id="wrapper">

	<!-- Main -->
	<div id="main">
		<div class="inner">
			<!-- Header -->
				<header id="header">
					<a class="logo"><strong>공지사항</strong></a>
				</header>

<!-- 게시글 상세보기 -->
<section>
<div>
	<table>
		<thead>
			<tr>
				<th><%= b.getbTtitle()  %></th>
			</tr>
		</thead>
		<tbody>
		<tr>
			<td>작성자 : <%= b.getUserId() %></td>
			<td>작성일 : <%= b.getbDate() %></td>
			<td>조회수 : <%= b.getbHits() %></td>
		</tr>
		<tr>
			<td colspan="3">
				<%= b.getContent() %>
			</td>
		</tr>
		</tbody>
	</table>
</div>
<!-- 댓글등록 -->
<div>
	<div>
		<table id="comtable">
				<tr>
					<!-- <td id="tid">"+decodeURIComponent(data.userId)+"</td>
					<td id="tcontent">"+decodeURIComponent(data.comContent)+"</td>
					<td id="tdate">"+data.date +"</td>
					<td><a href="#">삭제</a></td> -->
				</tr>
		</table>
	</div>
	<div>
	<table>
		<tr>
			<td>
				<textarea id="inputComment" style="width:100%;height:60px"></textarea>
			</td>
			<td>
				<form id="writercomment">
				<input type="hidden" id=userId value="<%= loginUser.getUserId() %>">
				<button type="button" onclick="writercom()">댓글등록</button>
				</form>
			</td>
		</tr>
	</table>
	</div>
</div>
<!-- 목록/수정/삭제 -->
<div align="right">
	<a class="button small" href=/diedie/nlist?page=<%= currentPage %>>목록</a>
 	<% if(loginUser != null && loginUser.getUserId() != null &&b.getUserId().equals(loginUser.getUserId())){ %>
	<a class="button small" href="/diedie/nupdate?bnum=<%= b.getbNo() %>&page=<%= currentPage %>">수정</a>
	<a class="button small" onclick="deletePop();">삭제</a>
	<div id='popup' style="display:none; height:180px; width:500px;">게시글을 삭제하시겠습니까?<input type="password" id="userpwd" placeholder="삭제 시 비밀번호 입력">
		<br>
		<div align="right">
			<a class="button small" id="deleteb">확인</a>
			<a class="button small" onclick="cancleb()">취소</a>
		</div>
	</div>
	<% } %>
</div>
</section>
									
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