package service.qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.qna.model.service.QNAService;
import service.qna.model.vo.QNA;

/**
 * Servlet implementation class QNAServlet
 */
@WebServlet("/qlist")
public class QNAListServlet extends HttpServlet {
	private static final long serialVersionUID = 11111111114L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNAListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		int limit = 10;
		
		QNAService qservice = new QNAService();
		
		int listCount = qservice.getListCount();
		ArrayList<QNA> list = qservice.selectList(currentPage, limit);
		int maxPage = (int)((double)listCount / limit + 0.9);
		int startPage = (((int)((double)currentPage / limit + 0.9)) - 1) * limit + 1;
		int endPage = startPage + limit - 1;
		
		if(maxPage < endPage)
			endPage = maxPage;
		
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		if(list.size() > 0) {
			view = request.getRequestDispatcher("view/service/qna.jsp");
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", listCount);
			view.forward(request, response);
			
		}else {
			view = request.getRequestDispatcher("view/service/serviceError.jsp");
			request.setAttribute("message", "QNA 목록 조회 실패");
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
