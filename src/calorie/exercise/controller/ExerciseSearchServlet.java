package calorie.exercise.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import calorie.exercise.model.service.ExerciseService;
import calorie.exercise.model.vo.Exercise;

/**
 * Servlet implementation class ExerciseSearchServlet
 */
@WebServlet("/esearch")
public class ExerciseSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExerciseSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//검색한 운동명을 포함한 운동칼로리 조회 ajax 요청 처리용 컨트롤러
		
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				String searchExer = request.getParameter("searchexer");
				ArrayList<Exercise> list = new ExerciseService().exerciseSearch(searchExer);
				
				JSONObject sendJson = new JSONObject();
				JSONArray jarr = new JSONArray();
				
				for(Exercise e : list) {
					JSONObject job = new JSONObject();
					job.put("eno", e.getExerNo());
					job.put("ename", URLEncoder.encode(e.getExerNm(), "UTF-8"));
					job.put("etime", e.getExerTime());
					job.put("ecalorie", e.getExerKcal());
				
					jarr.add(job);
				}
				
				sendJson.put("list", jarr);
				
				response.setContentType("application/json; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.write(sendJson.toJSONString());
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
