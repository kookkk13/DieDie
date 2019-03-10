package partner.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

import partner.model.service.PartnerService;
import user.model.vo.User;

/**
 * Servlet implementation class PartnerListServlet
 */
@WebServlet("/plist")
public class PartnerListServlet extends HttpServlet {
	private static final long serialVersionUID = 111111111110L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartnerListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String location = request.getParameter("location");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		int score = Integer.parseInt(request.getParameter("score"));
		
		PartnerService pservice = new PartnerService();
		
		ArrayList<User> list = pservice.selectList(location, gender, age, score);
		System.out.println(list.toString());
		
		RequestDispatcher view = null;
		if(list.size() > 0) {
			view = request.getRequestDispatcher("view/partner/partnerSearchResult.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
			
		}else {
			view = request.getRequestDispatcher("view/partner/partnerError.jsp");
			request.setAttribute("message", "파트너 목록 조회 실패");
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
