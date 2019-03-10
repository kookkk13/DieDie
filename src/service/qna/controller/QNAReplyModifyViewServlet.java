package service.qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.qna.model.service.QNAService;
import service.qna.model.vo.QNAReply;

/**
 * Servlet implementation class QNAReplyModifyServlet
 */
@WebServlet("/qrmodifyView")
public class QNAReplyModifyViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNAReplyModifyViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int replyNum = Integer.parseInt(request.getParameter("qrno"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		QNAReply qr = new QNAService().selectReply(replyNum);
		RequestDispatcher view = null;
		
		if(qr != null) {
			view = request.getRequestDispatcher("view/service/qnoModify.jsp");
			request.setAttribute("qr", qr);
			request.setAttribute("page", new Integer(currentPage));
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("view/service/servicError.jsp");
			request.setAttribute("message", "댓글 수정 페이지 조회 실패");
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
