package service.qna.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QNAFileDownlodeServlet
 */
@WebServlet("/fdown")
public class QNAFileDownlodeServlet extends HttpServlet {
	private static final long serialVersionUID = 11111111113L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNAFileDownlodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String refname = request.getParameter("refname");
		File path = new File("../../files/" + fname);
		
		RequestDispatcher view = request.getRequestDispatcher("/diedie/view/service/fdown.jsp");
		response.setContentType("text/html; charset=utf-8");
		request.setAttribute("fname", fname);
		request.setAttribute("refname", refname);
		request.setAttribute("path", path);
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
