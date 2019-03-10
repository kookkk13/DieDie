package manager.member.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import user.model.vo.User;

public class UserDao {

	public ArrayList<User> searchMem(Connection conn, String category, String val, int currentPage, int limit) {
		ArrayList<User> list = new ArrayList<User>();

		PreparedStatement stmt = null;
		ResultSet rset = null;
		String query = "";
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		
		try {
//		System.out.println("dao : " + val);
			// select * from(select ROWNUM RNUM, user_id, user_nm, nickname, enroll_date
			// from (select * from tb_user order by enroll_date)) WHERE USER_NM = ? RNUM
			// BETWEEN ? AND ?;
			if ("".equals(val)) {
				query = "select * from(select ROWNUM RNUM, user_id, user_nm, nickname, enroll_date from (select * from tb_user order by enroll_date)) WHERE RNUM BETWEEN ? AND ?";
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, startRow);
				stmt.setInt(2, endRow);
				rset = stmt.executeQuery();
			} else if (category.equals("아이디")) {
				query = "select * from tb_user where user_id = ?";
				stmt = conn.prepareStatement(query);
				stmt.setString(1, val);
				rset = stmt.executeQuery();
			} else if (category.equals("이름")) {
				query = "select * from(select ROWNUM RNUM, user_id, user_nm, nickname, enroll_date from (select * from tb_user order by enroll_date)) WHERE USER_NM = ? and RNUM BETWEEN ? AND ?";
				stmt = conn.prepareStatement(query);
				stmt.setString(1, val);
				stmt.setInt(2, startRow);
				stmt.setInt(3, endRow);
				rset = stmt.executeQuery();
			} else if (category.equals("닉네임")) {
				query = "select * from tb_user where nickname = ?";
				stmt = conn.prepareStatement(query);
				stmt.setString(1, val);
				rset = stmt.executeQuery();
			}

			while (rset.next()) {
				User user = new User();
				user.setUserId(rset.getString("user_id"));
				user.setUserNm(rset.getString("user_nm"));
				user.setNickName(rset.getString("nickname"));
				user.setEnrollDate(rset.getDate("enroll_date"));

				list.add(user);
			}

//			System.out.println("list : " + list);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		return list;
	}

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select count(*) from tb_user";

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		return listCount;
	}

	public int deleteMember(Connection conn, String userid) {
		int result = 0;
		PreparedStatement stmt = null;
		
		String query = "delete from tb_user where user_id = ?";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, userid);
			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return result;
	}
}