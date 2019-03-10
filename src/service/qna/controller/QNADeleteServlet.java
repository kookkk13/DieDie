package service.qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.qna.model.service.QNAService;

/**
 * Servlet implementation class QNADeleteServlet
 */
@WebServlet("/qdelete")
public class QNADeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 11111111111L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNADeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNum = Integer.parseInt(request.getParameter("qno"));
		int result = new QNAService().deleteBoard(boardNum);
		
		if(result > 0) {
			response.sendRedirect("/diedie/qlist?page=1");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("view/service/serviceError.jsp");
			request.setAttribute("message", "게시글 삭제 실패");
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
