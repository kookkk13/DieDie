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
 * Servlet implementation class PartnerViewServlet
 */
@WebServlet("/partner")
public class PartnerViewServlet extends HttpServlet {
	private static final long serialVersionUID = 111111111111L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartnerViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String userId = request.getParameter("loginUser");
		
		User partner = new PartnerService().viewPartner(userId);
		
		RequestDispatcher view = null;
		if(partner != null) {
			view = request.getRequestDispatcher("view/partner/partner.jsp");
			request.setAttribute("partner", partner);
			view.forward(request, response);

		} else {
			view = request.getRequestDispatcher("view/partner/partner.jsp");
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
