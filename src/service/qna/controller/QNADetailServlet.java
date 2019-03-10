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
import service.qna.model.vo.QNAReply;

/**
 * Servlet implementation class QNADetailServlet
 */
@WebServlet("/qdetail")
public class QNADetailServlet extends HttpServlet {
	private static final long serialVersionUID = 11111111112L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNADetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNum = Integer.parseInt(request.getParameter("qno"));
		int currentPage = 1;

		QNAService qservice = new QNAService();
		QNA qna = qservice.selectBoard(boardNum);
		ArrayList<QNAReply> list = qservice.selectReplyList(boardNum);
		
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		
		if(qna != null) {
			view = request.getRequestDispatcher("view/service/qnaDetail.jsp");
			request.setAttribute("qna", qna);
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			view.forward(request, response);

		} else {
			view = request.getRequestDispatcher("view/service/serviceError.jsp");
			request.setAttribute("message", "QNA 게시글 상세조회 실패");
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
