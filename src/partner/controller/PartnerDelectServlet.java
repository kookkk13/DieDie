package partner.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import partner.model.service.PartnerService;
import user.model.vo.User;

/**
 * Servlet implementation class PartnerDelect
 */
@WebServlet("/pdelect")
public class PartnerDelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartnerDelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("loginUser");
		int result = new PartnerService().delectPartner(userId);
		
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		loginUser.setPartnerId(null);
		session.setAttribute("loginUser", loginUser);
		
		if(result > 0) {
			response.sendRedirect("/diedie/partner");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("view/partner/partnerError.jsp");
			request.setAttribute("message", "파트너 해지 실패");
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
