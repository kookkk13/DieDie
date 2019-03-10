package calorie.food.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calorie.food.model.service.FoodService;
import calorie.food.model.vo.Food;

/**
 * Servlet implementation class FoodDetailServlet
 */
@WebServlet("/foodetail")
public class FoodDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//음식칼로리 상세보기
		int fno = 0;
		if(request.getParameter("fno") != null) {
			fno = Integer.parseInt(request.getParameter("fno"));
		}
		Food f = new FoodService().foodDetail(fno);
		
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		if(f != null) {
			view = request.getRequestDispatcher("view/calorie/food/foodDetail.jsp");
			request.setAttribute("food", f);
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
