package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import board.model.service.NoticeService;
import board.model.vo.Reply;

/**
 * Servlet implementation class NoticeComReadServlet
 */
@WebServlet("/ncomread")
public class NoticeComReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeComReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Reply> list = new ArrayList<Reply>();
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		
		list = new NoticeService().comList(bnum);

		JSONObject sendJson = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		SimpleDateFormat sim = new SimpleDateFormat("yyMMdd-HH:mm");

		for(Reply r : list) {
			JSONObject job = new JSONObject();
			job.put("userId", URLEncoder.encode(r.getUserId(),"utf-8"));
			job.put("comContent", URLEncoder.encode(r.getRcontent(),"utf-8"));
			job.put("date", sim.format(r.getRdate()).toString());
			job.put("cnum", r.getrNo());
			
			jarr.add(job);
		}
		sendJson.put("list", jarr);
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(sendJson.toJSONString());
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
