<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="user.model.vo.User, java.util.*" %>
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
</style>
    <script type="text/javascript" src="/diedie/assets/js/jquery-3.3.1.min.js"></script>

    <script type="text/javascript">
        $(function () {
            //주기적으로 반복 요청
            /* 
                setInterval(function(){ $.ajax()}, 시간)
             */
            $.ajax({
                url: "/diedie/searchmem",
                type: "get",
                dataType: "JSON",
                // data: JSON.stringify(data),
                data: { "category": "아이디", "val": "" },
                success: function (data) {
                    console.log("success : " + data);
                    //객체를 문자열로 변환 처리함
                    var jsonStr = JSON.stringify(data); //배열에 접근하기 위한 작업
                    //문자열을 배열 객체로 바꾸는 작업
                    var json = JSON.parse(jsonStr);

                    var values = "";

                    for (var i in json.list) {
                        values += "<tr><td>"
                            + json.list[i].userid
                            + "</td><td>"
                            + decodeURIComponent(json.list[i].usernm).replace(
                                /\+/gi, " ") + "</td><td>"
                            + decodeURIComponent(json.list[i].nickname).replace(
                                /\+/gi, " ") + "</td><td>"
                            + json.list[i].enrolldate + "</td></tr>";
                    } //for in

                    $("#userfield").html($("#userfield").html() + values);
                },
                error: test1
            })
        })

        function test1() {
            $.ajax({
                type: "GET",
                url: "/diedie/assets/json/myJson.json",
                dataType: 'json',
                cache: false,
                success: function (data) {
                    console.log("Status: " + "ok!!");
                }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                    console.log("Status: " + textStatus);
                }
            })
        }

        function test() {
            console.log("123");
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

                <p style="padding-top: 10px;">
                    <h2 style="font-family: '나눔스퀘어라운드'; font-size: 20pt">전체 회원관리</h2>
                </p>
                <font face="나눔스퀘어라운드" size="2pt">- 모든 회원을 검색, 관리 할 수 있습니다</font> <br><br>

                <!-- <form action="/diedie/searchmem" method="POST" style="padding-top: 15px">
                </form> -->
                <select id="category" name="category" style="width: 100px; height: 40px; float: left;">
                    <option selected>아이디</option>
                    <option>이름</option>
                    <option>닉네임</option>
                </select><input type="text" id="val" name="val" style="width: 200px; height: 40px;">

                <input type="submit" id="go" value="go" onclick="test();" class="btn_submit" style="width: 65px; position: absolute; left: 360px; top: 260px;">

                <br>

                <article style="width: 900px; height: 350px; border: 1px solid white; background: azure;">

                    <table id="userfield">
                        <tr>
                            <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th>
                                <font face="나눔스퀘어라운드" size="3">아이디</font>
                            </th>
                            <th>
                                <font face="나눔스퀘어라운드" size="3">닉네임</font>
                            </th>
                            <th>
                                <font face="나눔스퀘어라운드" size="3">회원 이름</font>
                            </th>
                            <th>
                                <font face="나눔스퀘어라운드" size="3">등록일자</font>
                            </th>
                            <th></th>
                            <th></th>
                    </table>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <table id="userfield1">

                    </table>
                </article>
                <!-- <div style="padding-top: 15px; padding-bottom: 15px; border: 1px solid white">
                    &nbsp; &nbsp;<a href="#" style="border: 1px solid black; width: 65px; height: 25px; display: inline-block; text-align: center;">Previous</a><a
                        style="border-top: 1px solid black; border-right: 1px solid black; border-bottom: 1px solid black; width: 35px; height: 25px; display: inline-block; text-align: center;">···</a><a
                        href="#" style="border-top: 1px solid black; border-right: 1px solid black; border-bottom: 1px solid black; width: 35px; height: 25px; display: inline-block; text-align: center;">1</a><a
                        href="#" style="border-top: 1px solid black; border-right: 1px solid black; border-bottom: 1px solid black; width: 35px; height: 25px; display: inline-block; text-align: center;">2</a><a
                        href="#" style="border-top: 1px solid black; border-right: 1px solid black; border-bottom: 1px solid black; width: 35px; height: 25px; display: inline-block; text-align: center;">3</a><a
                        href="#" style="border-top: 1px solid black; border-right: 1px solid black; border-bottom: 1px solid black; width: 35px; height: 25px; display: inline-block; text-align: center;">4</a><a
                        style="border-top: 1px solid black; border-right: 1px solid black; border-bottom: 1px solid black; width: 35px; height: 25px; display: inline-block; text-align: center;">···</a><a
                        href="#" style="border-top: 1px solid black; border-right: 1px solid black; border-bottom: 1px solid black; width: 35px; height: 25px; display: inline-block; text-align: center;">Next</a>
                </div> -->

                <div>
                    <ul class="pagination">
                        <li><span class="button disabled">Prev</span></li>
                        <li><a href="#" class="page active">1</a></li>
                        <li><a href="#" class="page">2</a></li>
                        <li><a href="#" class="page">3</a></li>
                        <li><span>…</span></li>
                        <li><a href="#" class="page">8</a></li>
                        <li><a href="#" class="page">9</a></li>
                        <li><a href="#" class="page">10</a></li>
                        <li><a href="#" class="button">Next</a></li>
                    </ul>
                </div>



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