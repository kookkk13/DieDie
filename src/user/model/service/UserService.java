package user.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import user.model.dao.UserDao;
import user.model.vo.User;



public class UserService {
	//의존성 주입 : DI
		private UserDao udao = new UserDao();
		
		
		public UserService() {}
		
		//로그인 요청 처리용
		public User loginCheck(String userId, String userPwd) {
			Connection conn = getConnection();
			User loginUser = udao.selectLogin(conn, userId, userPwd);
			close(conn);
			return loginUser;
		}

		public int insertUser(User user) {
			Connection conn = getConnection();
			int result = udao.insertUser(conn, user);
			if(result > 0) {
				commit(conn);
			}
			else {
				rollback(conn);
			}
			close(conn);
			return result;
		}

		public User selectUser(String userId) {
			Connection conn = getConnection();
			User user = udao.selectUser(conn, userId);
			close(conn);
			return user;
		}

		public int updateMember(User user) {
			Connection conn = getConnection();
			int result = udao.updateUser(conn, user);
			if(result > 0) {
				commit(conn);
			}
			else {
				rollback(conn);
			}
			close(conn);
			return result;
		}

		
}
