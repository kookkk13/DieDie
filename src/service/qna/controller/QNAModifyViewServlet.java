package service.qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.qna.model.service.QNAService;
import service.qna.model.vo.QNA;

/**
 * Servlet implementation class QNAModifyView
 */
@WebServlet("/qmoview")
public class QNAModifyViewServlet extends HttpServlet {
	private static final long serialVersionUID = 11111111116L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNAModifyViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNum = Integer.parseInt(request.getParameter("qno"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		QNA qna = new QNAService().selectBoard(boardNum);
		RequestDispatcher view = null;
		
		if(qna != null) {
			view = request.getRequestDispatcher("view/service/qnaModify.jsp");
			request.setAttribute("qna", qna);
			request.setAttribute("page", new Integer(currentPage));
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("view/service/serviceError.jsp");
			request.setAttribute("message", "게시글 수정 조회 페이지 조회 실패");
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
