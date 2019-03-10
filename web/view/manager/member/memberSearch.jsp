<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="user.model.vo.User, java.util.*"%>

<%
	ArrayList<User> list = (ArrayList<User>) request.getAttribute("list");

	int listCount = ((Integer) request.getAttribute("listCount")).intValue();
	int startPage = ((Integer) request.getAttribute("startPage")).intValue();
	int endPage = ((Integer) request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer) request.getAttribute("maxPage")).intValue();
	int currentPage = ((Integer) request.getAttribute("current")).intValue();
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>DIE DIE</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="/diedie/assets/css/main.css" />
    <style>
        h2 {
	padding-top: 0px;
}

* {
	padding-left: 10px;
}

select option {
	text-align: center;
}

select, select option {
	background-color: darkgrey !important;
	font-weight: bold !important;
	color: black !important;
}

.btn_submit {
	background-image: url('../../../images/search.png');
	background-position: 0px 0px;
	background-repeat: no-repeat;
	width: 60px;
	height: 29px;
	border: 0px;
	cursor: pointer;
	outline: 0;
}

.container {
	width: 400px;
	height: 300px;
	background-color: #DCDCDC;
	overflow: scroll; /* showing scrollbars */
}

#userfield th, td {
	text-align: center;
}
</style>
    <!-- <script type="text/javascript" src="/diedie/assets/js/jquery-3.3.1.min.js"></script> -->
    <script type="text/javascript" src="//code.jquery.com/jquery.min.js"></script>

    <script type="text/javascript">
        // $(function () {
        //     //주기적으로 반복 요청
        //     /* 
        //         setInterval(function(){ $.ajax()}, 시간)
        //      */
        //     $.ajax({
        //         url: "/diedie/searchmem",
        //         type: "get",
        //         dataType: "JSON",
        //         // data: JSON.stringify(data),
        //         data: { "category": "아이디", "val": "" },
        //         success: function (data) {
        //             console.log("success : " + data);
        //             //객체를 문자열로 변환 처리함
        //             var jsonStr = JSON.stringify(data); //배열에 접근하기 위한 작업
        //             //문자열을 배열 객체로 바꾸는 작업
        //             var json = JSON.parse(jsonStr);

        //             var values = "";

        //             for (var i in json.list) {
        //                 values += "<tr><td>"
        //                     + json.list[i].userid
        //                     + "</td><td>"
        //                     + decodeURIComponent(json.list[i].usernm).replace(
        //                         /\+/gi, " ") + "</td><td>"
        //                     + decodeURIComponent(json.list[i].nickname).replace(
        //                         /\+/gi, " ") + "</td><td>"
        //                     + json.list[i].enrolldate + "</td></tr>";
        //             } //for in

        //             $("#userfield").html($("#userfield").html() + values);
        //         },
        //         error: test1
        //     })
        // })

        // function test1() {
        //     $.ajax({
        //         type: "GET",
        //         url: "/diedie/assets/json/myJson.json",
        //         dataType: 'json',
        //         cache: false,
        //         success: function (data) {
        //             console.log("Status: " + "ok!!");
        //         }, error: function (XMLHttpRequest, textStatus, errorThrown) {
        //             console.log("Status: " + textStatus);
        //         }
        //     })
        // }
        
        $(function(){
        	$(".check-all").click(function(){
                //클릭되었으면
                if($(".check-all").prop("checked")){
                    //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
                    $(".ab").prop("checked",true);
                    //클릭이 안되있으면
                }else{
                    //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
                    $(".ab").prop("checked",false);
                }
            })
        })

        function deleteMember(userid) {
            if (confirm("탈퇴 처리 하시겠습니까?")) {
                location.href = "/diedie/mdel?userid=" + userid;
            }
        }


        function deleteMembers() {
        	var size = <%= list.size() %>;
        	
        	var values = "";
        	values = $("#demo-human0").val();
        	for(var i = 0; i<size; i++){
        		
        	}
        	
        	console.log(size);
        	console.log(values);
        }
        
    </script>

</head>

<body class="is-preload">

    <!-- Wrapper -->
    <div id="wrapper">

        <!-- Main -->
        <div id="main">
            <div class="inner">

                <!-- Header -->
                <header id="header">
                    <a href="/diedie/index.jsp" class="logo"><strong>DIE
                            DIE</strong></a>
                </header>

                <!-- Content -->

                <p style="padding-top: 10px;"></p>
                <h2 style="font-family: '나눔스퀘어라운드'; font-size: 20pt">전체 회원관리</h2>

                <font face="나눔스퀘어라운드" size="2pt">- 모든 회원을 검색, 관리 할 수 있습니다</font> <br>
                <form action="/diedie/searchmem" method="POST" style="padding-top: 15px">
                    <select id="category" name="category" style="width: 100px; height: 40px; float: left;">
                        <option selected>아이디</option>
                        <option>이름</option>
                        <option>닉네임</option>
                    </select><input type="text" id="val" name="val" style="width: 200px; height: 40px;"> <input type="submit"
                        id="go" value="검색 &nbsp;&nbsp;" onclick="test();" class="button primary icon fa-search" style="width: 72px; position: absolute; left: 360px; top: 251px;">
                </form>
                <article class="container" style="width: 1150px; height: 350px; border: 1px solid white; background: azure;">

                    <table id="userfield">
                        <tr>
                            <th><%-- <input class="check-all" type="checkbox" id="demo-human" name="demo-human"">
                                <label for="demo-human<"></label> --%></th>
                            <th>
                                <font face="나눔스퀘어라운드" size="3">아이디</font>
                            </th>
                            <th>
                                <font face="나눔스퀘어라운드" size="3">회원 이름</font>
                            </th>
                            <th>
                                <font face="나눔스퀘어라운드" size="3">닉네임</font>
                            </th>
                            <th>
                                <font face="나눔스퀘어라운드" size="3">등록일자</font>
                            </th>
                            <th></th>
                            <th></th>
                        </tr>
                        <!-- </table>
					<table id="userfield1"> -->
                        <%
							if (list != null) {
								for (int i = 0; i < list.size(); i++) {
						%>

                        <tr>
                            <td><input class="ab" type="checkbox" id="demo-human<%=i%>" name="demo-human"> <label for="demo-human<%=i%>"></label>
                            </td>
                            <%-- <%
								if (currentPage != 1) {
							%>
                            <font face="나눔스퀘어라운드" size="3">
                                <%="" + (currentPage - 1) + (i + 1)%>
                            </font>
                            <%
								} else {
							%>
                            <font face="나눔스퀘어라운드" size="3">
                                <%=i + 1%>
                            </font>
                            <%
								}
							%> --%>
                            <td>
                                <font face="나눔스퀘어라운드" size="3">
                                    <%=list.get(i).getUserId()%>
                                </font>
                            </td>
                            <td>
                                <font face="나눔스퀘어라운드" size="3">
                                    <%=list.get(i).getUserNm()%>
                                </font>
                            </td>
                            <td>
                                <font face="나눔스퀘어라운드" size="3">
                                    <%=list.get(i).getNickName()%>
                                </font>
                            </td>
                            <td>
                                <font face="나눔스퀘어라운드" size="3">
                                    <%=list.get(i).getEnrollDate()%>
                                </font>
                            </td>
                            <td><button>수정</button>
                            <td>
                                <button onclick="deleteMember('<%=list.get(i).getUserId()%>');">강제탈퇴처리</button>
                            </td>
                        </tr>
                        <%
							}
							} else {
						%>

                        <tr>
                            <td colspan="7" style="text-align: center;">회원 정보가 없습니다.</td>
                        </tr>

                        <%
							}
						%>
                    </table>
                </article>
                <br>
                <button class="button primary small" style="position: absolute; left: 1150px; top: 680px;">등록</button>
                <button class="button primary small" style="position: absolute; left: 1085px; top: 680px;" onclick="deleteMembers();">삭제</button>
                <center>
                    <div>
                        <ul class="pagination">
                            <li>
                                <%
									if (currentPage == 1) {
								%> <span class="button disabled"> First
                                </span>
                                <%
 	} else {
 %> <a class="button" href="/diedie/searchmem?page=1">First</a>
                                <%
 	}
 %>
                            </li>


                            <li>
                                <%
									if ((currentPage - 10) < startPage && (currentPage - 10) > 1) {
								%>
                                <a href="/diedie/searchmem?page=<%=startPage - 10%>">Prev</a>
                                <%
									} else {
								%> <span class="button disabled"> Prev </span>
                                <%
 	}
 %>
                            </li>&nbsp; &nbsp;


                            <!-- <li><a class="button" href="/first/blist?page=1">Prev</a></li> -->


                            <%
								for (int p = startPage; p <= endPage; p++) {
									if (p == currentPage) {
							%>
                            <li><a href="/diedie/searchmem?page=<%=currentPage%>" class="page active">
                                    <%=p%></a></li>
                            <%
								} else {
							%>
                            <li><a class="page" href="/diedie/searchmem?page=<%=p%>">
                                    <%=p%></a></li>
                            <%
								}
								}
							%>

                            <%
								if ((currentPage + 10) > endPage && (currentPage + 10) < maxPage) {
							%>
                            &nbsp;&nbsp;
                            <li><a class="page active" href="/diedie/searchmem?page=<%=endPage + 10%>">Next</a></li>
                            <%
								} else {
							%>
                            &nbsp;&nbsp;
                            <span class="button disabled"> Next </span>
                            <%
								}
							%>

                            <li>
                                <%
									if (currentPage >= maxPage) {
								%> <span class="button disabled">
                                    Last </span>
                                <%
 	} else {
 %> <a class="button" href="/diedie/searchmem?page=<%=maxPage%>">Last</a>
                                <%
									}
								%>
                            </li>


                        </ul>
                    </div>
                </center>


            </div>
        </div>


        <!-- Sidebar -->
        <%@ include file="../../common/adminSidebar.jsp"%>

    </div>

    <!-- Scripts -->
    <script src="/diedie/assets/js/jquery.min.js"></script>
    <script src="/diedie/assets/js/browser.min.js"></script>
    <script src="/diedie/assets/js/breakpoints.min.js"></script>
    <script src="/diedie/assets/js/util.js"></script>
    <script src="/diedie/assets/js/main.js"></script>

</body>

</html>