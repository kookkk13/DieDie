package calorie.food.model.dao;

import static common.JDBCTemplate.*;
import java.sql.*;
import java.util.*;

import calorie.food.model.vo.Food;

public class FoodDao {
	
	public FoodDao() {}

	//검색한 음식칼로리 조회
	public ArrayList<Food> foodSearch(Connection conn, String searchFood) {
		ArrayList<Food> list = new ArrayList<Food>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT FOOD_NO, FOOD_NAME, ONCE_IN, CALORIE FROM TB_FOOD " + 
						"WHERE FOOD_NAME LIKE ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + searchFood + "%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Food f = new Food();
				f.setFoodNo(rset.getInt("food_no"));
				f.setFoodName(rset.getString("food_name"));
				f.setOnceIn(rset.getDouble("once_in"));
				f.setCalorie(rset.getDouble("calorie"));

				list.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	//음식칼로리 상세보기
	public Food foodDetail(Connection conn, int fno) {
		Food f = new Food();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM TB_FOOD WHERE FOOD_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fno);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				f.setFoodNo(rset.getInt("food_no"));
				f.setFoodName(rset.getString("food_name"));
				f.setOnceIn(rset.getDouble("once_in"));
				f.setCalorie(rset.getDouble("calorie"));
				f.setCarb(rset.getDouble("carb"));
				f.setProtein(rset.getDouble("protein"));
				f.setFat(rset.getDouble("fat"));
				f.setSugar(rset.getDouble("sugar"));
				f.setNa(rset.getDouble("na"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return f;
	}

}
