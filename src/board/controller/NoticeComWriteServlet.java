package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import board.model.service.NoticeService;

/**
 * Servlet implementation class NoticeComWriteServlet
 */
@WebServlet("/ncomwrite")
public class NoticeComWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeComWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		
		HashMap hm = new HashMap();
		hm.put("comContent", request.getParameter("comContent"));
		hm.put("bno", request.getParameter("bno"));
		hm.put("userId", request.getParameter("userId"));
		SimpleDateFormat sim = new SimpleDateFormat("yyMMdd-HH:mm");
		hm.put("date", sim.format(new java.sql.Date(new java.util.Date().getTime())));
	
		JSONObject job = new JSONObject();
		NoticeService nservice = new NoticeService();
		int result = nservice.writeCom(hm);
		int cnum = nservice.selectComnum(request.getParameter("userId"));
		if(result == 1) {
			//job.put("time", new java.sql.Date(new java.util.Date().getTime()));
			job.put("comContent", URLEncoder.encode(request.getParameter("comContent"), "utf-8"));
			job.put("bno", request.getParameter("bno"));
			job.put("result", result);
			job.put("userId", URLEncoder.encode(request.getParameter("userId"),"utf-8"));
			job.put("date", hm.get("date").toString());
			job.put("cnum", cnum);
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(job.toJSONString());
		out.flush();
		out.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
