package calorie.exercise.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calorie.exercise.model.service.ExerciseService;
import calorie.exercise.model.vo.Exercise;

/**
 * Servlet implementation class ExerciseDetailServlet
 */
@WebServlet("/edetail")
public class ExerciseDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExerciseDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//운동칼로리 상세보기
		int eno = 0;
		if(request.getParameter("eno") != null) {
			eno = Integer.parseInt(request.getParameter("eno"));
		}
		Exercise e = new ExerciseService().exerciseDetail(eno);
		
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		if(e != null) {
			view = request.getRequestDispatcher("view/calorie/exercise/exerDetail.jsp");
			request.setAttribute("exer", e);
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
