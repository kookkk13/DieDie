package manager.member.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import manager.member.model.dao.UserDao;
import user.model.vo.User;

public class UserService {

	UserDao udao = new UserDao();

	public ArrayList<User> searchList(String category, String val, int currentPage, int limit) {
		Connection conn = getConnection();
		ArrayList<User> list = udao.searchMem(conn, category, val, currentPage, limit);
		close(conn);
		return list;
	}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = udao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public int deleteMember(String userid) {
		Connection conn = getConnection();
		int result = udao.deleteMember(conn, userid);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int deleteMembers(String userid) {
		// TODO 자동 생성된 메소드 스텁
		return 0;
	}
}
