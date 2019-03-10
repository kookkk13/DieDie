package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.NoticeService;

/**
 * Servlet implementation class NoticeComDeleteServlet
 */
@WebServlet("/ndelcom")
public class NoticeComDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeComDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cnum = Integer.parseInt(request.getParameter("cnum"));

		int page = Integer.parseInt(request.getParameter("page"));
				
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		
		System.out.println(cnum);
		System.out.println(bnum);
		
		NoticeService nservice = new NoticeService();
		
		if(nservice.deleteCom(cnum) > 0) {
			response.sendRedirect("/diedie/ndetail?bnum="+bnum+"&page="+page);
		}else {
			
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
