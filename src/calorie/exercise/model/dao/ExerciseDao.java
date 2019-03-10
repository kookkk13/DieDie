package calorie.exercise.model.dao;

import static common.JDBCTemplate.*;
import java.sql.*;
import java.util.*;

import calorie.exercise.model.vo.Exercise;
import calorie.food.model.vo.Food;

public class ExerciseDao {
	
	public ExerciseDao() {}

	//검색한 운동칼로리 조회
	public ArrayList<Exercise> exerSearch(Connection conn, String searchExer) {
		ArrayList<Exercise> list = new ArrayList<Exercise>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM TB_EXERCISE " + 
						"WHERE EXER_NM LIKE ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + searchExer + "%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Exercise e = new Exercise();

				e.setExerNo(rset.getInt("exer_no"));
				e.setExerNm(rset.getString("exer_nm"));
				e.setExerTime(rset.getInt("exer_time"));
				e.setExerKcal(rset.getDouble("exer_kcal"));
				e.setMet(rset.getDouble("met"));

				list.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	//운동칼로리 상세보기
	public Exercise exerciseDetail(Connection conn, int eno) {
		Exercise e = new Exercise();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM TB_EXERCISE WHERE EXER_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, eno);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				e.setExerNo(rset.getInt("exer_no"));
				e.setExerNm(rset.getString("exer_nm"));
				e.setMet(rset.getDouble("met"));
				e.setExerTime(rset.getInt("exer_time"));
				e.setExerKcal(rset.getDouble("exer_kcal"));
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return e;
	}
}
