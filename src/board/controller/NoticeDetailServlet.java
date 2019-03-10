package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.NoticeService;
import board.model.vo.Board;

/**
 * Servlet implementation class NoticeDetailServlet
 */
@WebServlet("/ndetail")
public class NoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int bNo = Integer.parseInt(request.getParameter("bnum"));
			int currentPage = Integer.parseInt(request.getParameter("page"));
			NoticeService nservice = new NoticeService();
			//조회수 
			nservice.addReadCount(bNo);
			
	
			Board board = nservice.selectBoard(bNo);
			
			response.setContentType("text/html; charset=utf-8");
			RequestDispatcher view = null;

			if(board != null) {
				view = request.getRequestDispatcher("view/board/notice/noticeDetail.jsp");
				request.setAttribute("board", board);
				request.setAttribute("page", currentPage);
				view.forward(request, response);
			}else {
				view = request.getRequestDispatcher("view/board/boardError.sjp");
				request.setAttribute("message", "잠시만 기다려 주세요..");
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
