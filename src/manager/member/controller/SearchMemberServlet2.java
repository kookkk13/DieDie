package manager.member.controller;

import java.io.FileWriter;
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

import manager.member.model.service.UserService;
import manager.member.model.vo.User;

/**
 * Servlet implementation class SearchMember
 */
@WebServlet("/searchmem1")
public class SearchMemberServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMemberServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String category = request.getParameter("category");
		String val = request.getParameter("val");
		if(category == null) {
			category = "아이디";
		}
		if(val == null) {
			val = "";
		}
		System.out.println("category : " + category + " val : " + val);
		ArrayList<User> list = new UserService().searchList(category, val);
		
		JSONObject sendJson = new JSONObject();
		//리턴 받은 list 저장용 json 배열 객체 준비
		JSONArray jarr = new JSONArray();
		for(User user : list) {
			JSONObject job = new JSONObject();
			job.put("userid", user.getUserId());
			//json 에서 한글깨짐 막으려면,
			//java.net.URLEncoder 클래스의 encode()로 인코딩 처리함
			job.put("usernm", URLEncoder.encode(user.getUserNm(), "utf-8"));
			job.put("nickname", URLEncoder.encode(user.getNickName(), "utf-8"));
			job.put("enrolldate", user.getEnrollDate());
			jarr.add(job);
		}
        
		sendJson.put("list", jarr);
		System.out.println("json : " + sendJson.toJSONString());
//		FileWriter file = new FileWriter("f:\\dmyJson.json");
		FileWriter file = new FileWriter("f:\\Eclipse\\SemiProject\\web\\assets\\json\\myJson.json");
        file.write(sendJson.toJSONString());
        file.flush();
        file.close();
        
        System.out.println("Create JSON Object : "+sendJson);

		
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
