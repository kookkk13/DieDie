package manager.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.vo.Board;
import manager.member.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class SearchMember
 */
@WebServlet("/searchmem")
public class SearchMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchMemberServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String category = request.getParameter("category");
		String val = request.getParameter("val");
		if (category == null) {
			category = "아이디";
		}
		if (val == null) {
			val = "";
		}
		
//		System.out.println("category : " + category + " val : " + val);
		

		int currentPage = 1;
		// page 이름으로 전송온 값이 있을 때만 페이지 값 추출
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		// 한 페이지당 출력할 목록 갯수 지정

		int limit = 10;

		UserService bservice = new UserService();
		// 전체 목록 갯수 조회
		int listCount = bservice.getListCount();
		
		ArrayList<User> list = bservice.searchList(category, val, currentPage, limit);
		// 현재 페이지에 출력할 목록 조회
		
		// 총 페이지수 계산 : 목록이 마지막 1개일 때도 1page로 처리
		int maxPage = (int) ((double) listCount / limit + 0.9);
		// 현재 페이지 그룹(10페이지를 한 그룹으로 처리한 경우)
		// 보여줄 시작 페이지 수 (현 13page - 11~20)
		// 121 13 12 121
		int startPage = (((int)((double) currentPage / limit + 0.9)) - 1) * limit + 1;
		
		int endPage = startPage + limit - 1;

		if (maxPage < endPage) {
			endPage = maxPage;
		}
		
		
		RequestDispatcher view = null;

		if (list.size() > 0) {
			view = request.getRequestDispatcher("view/manager/member/memberSearch.jsp");
			request.setAttribute("list", list);
			request.setAttribute("current", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", listCount);
			
			// setAttribute 해주어야 함.
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("view/manager/member/memberSearch.jsp");
			request.setAttribute("message", "회원 전체 목록 조회 실패");
			view.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
