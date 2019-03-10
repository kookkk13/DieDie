package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 4L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 처리용 컨트롤러
		//1. 전송값에 한글이 있다면, 인코딩처리함
		request.setCharacterEncoding("utf-8");
		//결과 뷰파일 내보낼 때를 위해 미리 셋팅해 둠
		response.setContentType("text/html;charset=utf-8");
		
		//2. 전송온 값 꺼내서 변수 또는 객체에 저장 처리
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpwd");
		
		//System.out.println(userId + ", " + userPwd);
		
		//3. 모델쪽으로 전송온 값 전달하면서, 처리된 결과받음
		//controller --> service --> dao
		User loginUser = new UserService().loginCheck(userId, userPwd);
		
		//4. 받은 결과를 가지고 뷰를 선택해서 내보냄
		if(loginUser != null) {
			//로그인 성공시
			HttpSession session = request.getSession(true);
			System.out.println("sessionID : " + session.getId());
			session.setAttribute("loginUser", loginUser);
			
			response.sendRedirect("/diedie/view/login/login.jsp");
			
			/*if(userId.equals("admin")) {
				response.sendRedirect("/first/adminIndex.jsp");
			}else {
				response.sendRedirect("/first/index.jsp");
			}*/
			
			
			
		}else {
			//로그인 실패시
			RequestDispatcher view = request.getRequestDispatcher("/view/user/userError.jsp");	//상대경로로 설정!
			request.setAttribute("message", "로그인에 실패하였습니다!" + "\n" + "아이디나 암호를 확인하시고, 다시 시도하세요.");
			view.forward(request, response);
		}
		
	}

}
