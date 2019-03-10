package calorie.food.controller;

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

import calorie.food.model.service.FoodService;
import calorie.food.model.vo.Food;

/**
 * Servlet implementation class FoodSearchServlet
 */
@WebServlet("/fsearch")
public class FoodSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//검색한 음식명을 포함한 음식칼로리 조회 ajax 요청 처리용 컨트롤러
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String searchFood = request.getParameter("searchfood");
		ArrayList<Food> list = new FoodService().foodSearch(searchFood);
		
		JSONObject sendJson = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for(Food f : list) {
			JSONObject job = new JSONObject();
			job.put("fno", f.getFoodNo());
			job.put("fname", URLEncoder.encode(f.getFoodName(), "UTF-8"));
			job.put("foncein", f.getOnceIn());
			job.put("fcalorie", f.getCalorie());
		
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
