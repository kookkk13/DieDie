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
 * Servlet implementation class UserEnrollServlet
 */
@WebServlet("/enroll")
public class UserEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 4L;

    /**
     * Default constructor. 
     */
    public UserEnrollServlet() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 가입 처리용 컨트롤러
				//1.
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				
				//2.
				User user = new User();
				user.setUserId(request.getParameter("userid"));
				
				String[] hobbies = request.getParameterValues("hobby");
				if(hobbies != null) {
				}
				
				//3.
				int result = new UserService().insertUser(user);
				
				//4.
				if(result > 0) {
					response.sendRedirect("/first/index.jsp");
				}else {
					RequestDispatcher view = request.getRequestDispatcher("views/member/memberError.jsp");
			        request.setAttribute("message", "회원가입이 실패하였습니다.");
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
