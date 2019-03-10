package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;
import user.model.vo.User;



/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/uupdate")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 4L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 정보 수정 처리용 컨트롤러
				//1.
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				
				//2.
				User user = new User();
				user.setNickName(request.getParameter("nickName"));
				user.setUserNm(request.getParameter("user_NM"));
				user.setGender(request.getParameter("gender"));
				user.setAddress(request.getParameter("address"));
				user.setEmail(request.getParameter("email"));
				user.setProfile(request.getParameter("profile"));
				
				
				
				
				//3.
				int result = new UserService().updateMember(user);
				//4.
				if(result > 0) {
					response.sendRedirect("/diedie/myinfo?user_id=" + user.getUserId());
				}else {
					RequestDispatcher view = request.getRequestDispatcher("view/user/userError.jsp");
			        request.setAttribute("message", user.getUserId() + "아이디에 대한 수정처리가 실패하였습니다.");
			        view.forward(request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
