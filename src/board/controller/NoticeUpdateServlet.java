package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.NoticeService;
import board.model.vo.Board;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/nupdate")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNum = Integer.parseInt(request.getParameter("bnum"));
		int currentPage = Integer.parseInt(request.getParameter("page"));

		Board board = new NoticeService().selectBoard(boardNum);
		
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		if(board != null) {
			view = request.getRequestDispatcher("view/board/notice/noticeUpdate.jsp");
			request.setAttribute("board", board);
			request.setAttribute("page", new Integer(currentPage));
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("view/board/boardError");
			request.setAttribute("message", "수정 실패!");
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
