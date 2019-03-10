package calorie.food.model.service;

import static common.JDBCTemplate.*;
import java.sql.*;
import java.util.*;

import calorie.food.model.dao.FoodDao;
import calorie.food.model.vo.Food;


public class FoodService {
	private FoodDao fdao = new FoodDao();
	
	public FoodService() {}
	
	//음식 검색 결과 조회
	public ArrayList<Food> foodSearch(String searchFood) {
		Connection conn = getConnection();
		ArrayList<Food> list = fdao.foodSearch(conn, searchFood);
		close(conn);
		return list;
	}
	
	//음식칼로리 상세보기
	public Food foodDetail(int fno) {
		Connection conn = getConnection();
		Food f = fdao.foodDetail(conn, fno);
		close(conn);
		return f;
	}

	

}
