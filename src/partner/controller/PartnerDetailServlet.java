package partner.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import partner.model.service.PartnerService;
import user.model.vo.User;

/**
 * Servlet implementation class PartnerDetailServlet
 */
@WebServlet("/partdetail")
public class PartnerDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartnerDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String userId = request.getParameter("userid");
		
		User user = new PartnerService().detailPartner(userId);
		
		RequestDispatcher view = null;
		if(user != null) {
			view = request.getRequestDispatcher("view/partner/partnerDetail.jsp");
			request.setAttribute("partner", user);
			view.forward(request, response);

		} else {
			view = request.getRequestDispatcher("view/partner/partnerError.jsp");
			request.setAttribute("message", "파트너 상세 조회 실패");
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
