<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>DIE DIE</title>
      <script type="text/javascript" src="/diedie/assets/js/jquery.min.js"></script>
      <script type="text/javascript"></script>
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
                           <a class="logo"><strong>회원 서비스</strong></a>
                        </header>

                     <!-- Content -->
				<body>
					<h3>
						<%if (exception != null) {%>
						예외 발생 :
						<%=exception.getMessage()%><br>
						<%}%>
						<%-- 출력태그(Expression Tag) 자바 코드로는 out.print(출력할 값) 메소드임. --%>
						<%if (request.getAttribute("message") != null) {%>
						<%=request.getAttribute("message")%>
					</h3>
					<%}%>

					<a href="/diedie/view/login/login.jsp">로그인 페이지로 이동</a>
				</body>

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