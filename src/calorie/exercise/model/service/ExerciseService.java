package calorie.exercise.model.service;

import static common.JDBCTemplate.*;
import java.sql.*;
import java.util.*;

import calorie.exercise.model.dao.ExerciseDao;
import calorie.exercise.model.vo.Exercise;
import calorie.food.model.vo.Food;

public class ExerciseService {
private ExerciseDao edao = new ExerciseDao();
	
	public ExerciseService() {}
	
	//운동 검색 결과 조회
	public ArrayList<Exercise> exerciseSearch(String searchExer) {
		Connection conn = getConnection();
		ArrayList<Exercise> list = edao.exerSearch(conn, searchExer);
		close(conn);
		return list;
	}
	
	//운동칼로리 상세보기
	public Exercise exerciseDetail(int eno) {
		Connection conn = getConnection();
		Exercise e = edao.exerciseDetail(conn, eno);
		close(conn);
		return e;
	}

}
