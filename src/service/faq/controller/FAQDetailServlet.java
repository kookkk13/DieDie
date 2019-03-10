package service.faq.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.faq.model.service.FAQService;
import service.faq.model.vo.FAQ;

/**
 * Servlet implementation class FAQDetailServlet
 */
@WebServlet("/fdetail")
public class FAQDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNum = Integer.parseInt(request.getParameter("fnum"));
		int currentPage = 1;
		
		FAQService fservice = new FAQService();
		FAQ faq = fservice.selectBoard(boardNum);
		
		response.setContentType("text/html; charset=utf-8"); 
		RequestDispatcher view = null;
		
		if(faq != null) {
			view = request.getRequestDispatcher("view/service/faqDetail.jsp");
			request.setAttribute("faq", faq);
			request.setAttribute("currentPage", currentPage);
			view.forward(request, response);
		
		} else {
			view = request.getRequestDispatcher("view/service/serviceError.jsp");
			request.setAttribute("message", "FAQ 게시글 상세조회 실패");
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
