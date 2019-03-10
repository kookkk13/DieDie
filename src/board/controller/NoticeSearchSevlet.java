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
 * Servlet implementation class NoticeSearchSevlet
 */
@WebServlet("/nsearch")
public class NoticeSearchSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSearchSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		int currentPage = 1;

		int limit = 15; //공지,자유,질문 게시판
		
		NoticeService nservice = new NoticeService();
		String category = request.getParameter("category");

		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		String keyWord = "";
		if(request.getParameter("keyWord")!=null) {
			 keyWord = request.getParameter("keyWord").trim();
		}
		int listCount = nservice.getListCount(keyWord,category);
		
		ArrayList<Board> list = nservice.selectList(keyWord,category,currentPage,limit);
		String flag = "search";
		int maxPage = (int)((double)listCount / limit + 0.95);		
		int startPage = (((int)((double)currentPage / limit + 0.95)) -1 ) * limit + 1;		
		int endPage = startPage + limit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		
		view = request.getRequestDispatcher("view/board/notice/notice.jsp");
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("listCount", listCount);
		request.setAttribute("flag", flag);
		request.setAttribute("category", category);
		request.setAttribute("keyWord", keyWord);
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
