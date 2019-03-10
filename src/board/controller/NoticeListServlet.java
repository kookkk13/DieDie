package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.NoticeService;
import board.model.vo.Board;


/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/nlist")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NoticeListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPage = 1;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		int limit = 15; //공지,자유,질문 게시판
		
		NoticeService nservice = new NoticeService();
		int listCount = nservice.getListCount();
		
		ArrayList<Board> list = nservice.selectList(currentPage, limit);
		
		String flag = "list";
		int maxPage = (int)((double)listCount / limit + 0.95);		
		int startPage = (((int)((double)currentPage / limit + 0.95)) -1 ) * limit + 1;		
		int endPage = startPage + limit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}

		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		if(list.size()>0) {
			view = request.getRequestDispatcher("view/board/notice/notice.jsp");
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", listCount);
			request.setAttribute("flag", flag);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("view/board/boardError.jsp");
			request.setAttribute("message", "공지사항 목록 불러오기 오류....");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
