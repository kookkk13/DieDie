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
 * Servlet implementation class QNAReplyServlet
 */
@WebServlet("/qrwrite")
public class QNAReplyWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 11111111118L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNAReplyWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int boardNum = Integer.parseInt(request.getParameter("qnum"));
		String qWriter = request.getParameter("qwriter");
		String qContent = request.getParameter("qcontent");
		
		QNAService qservice = new QNAService();
//		QNA originBoard = qservice.selectBoard(boardNum);
		
		QNAReply qr = new QNAReply();
		qr.setContent(qContent);
		qr.setqNo(boardNum);
		qr.setUserId(qWriter);
		
		int result = qservice.writeReply(qr);
		
		response.setContentType("text/html; charset=utf-8");
		if(result > 0) {
			response.sendRedirect("/diedie/qlist?page=1");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("view/service/serviceError.jsp");
			request.setAttribute("message", "댓글 등록 실패");
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
