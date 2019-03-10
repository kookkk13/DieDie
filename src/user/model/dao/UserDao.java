package user.model.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import user.model.vo.User;

public class UserDao {

	public User selectLogin(Connection conn, String userId, String userPwd) {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		System.out.println("dao : " + userId + ", " + userPwd);
		System.out.println("conn : " + conn);
		String query = "select * from tb_user where user_id = ? and user_pwd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				user = new User();
				
				user.setUserId(userId);
				user.setUserPwd(userPwd);
				user.setUserNm(rset.getString("user_NM"));
				user.setNickName(rset.getString("nickName"));
				user.setBirth(rset.getDate("birth"));
				user.setGender(rset.getString("gender"));
				user.setAddress(rset.getString("address"));
				user.setEmail(rset.getString("email"));
				user.setPurpose(rset.getString("purpose"));
				user.setAgreeYN(rset.getString("agree_YN"));
				user.setProfile(rset.getString("profile"));
				user.setWeight(rset.getShort("weight"));
				user.setCautionCount(rset.getInt("caution_Count"));
				user.setScore(rset.getInt("score"));
				user.setDropYN(rset.getString("drop_YN"));
				user.setEnrollDate(rset.getDate("enroll_Date"));
				user.setPartnerId(rset.getString("partner_Id"));
				
				
				System.out.println("user : " + user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return user;
	}

	public int insertUser(Connection conn, User user) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_user values(?, ?, ?, ?, ?, ?, ?, ?, ?, default, ?, ?, default,"
				+ "default, default, sysdate, default)";
				
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserNm());
			pstmt.setString(3, user.getUserPwd());
			pstmt.setString(4, user.getNickName());
			pstmt.setDate(5, user.getBirth());
			pstmt.setString(6, user.getGender());
			pstmt.setString(7, user.getAddress());
			pstmt.setString(8, user.getEmail());
			pstmt.setString(9, user.getPurpose());
			//AGREE_YN default
			pstmt.setString(10, user.getProfile());
			pstmt.setInt(11, user.getWeight());
			/*private int cautionCount default;
			private int score default;
			private String dropYN default;*/
			pstmt.setDate(12, user.getEnrollDate());
			//private String partnerId default;
			
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public User selectUser(Connection conn, String userId) {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_user where user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				user = new User();
				
				user.setUserId(userId);
				user.setUserPwd(rset.getString("userPwd"));
				user.setUserNm(rset.getString("user_NM"));
				user.setNickName(rset.getString("nickName"));
				user.setBirth(rset.getDate("birth"));
				user.setGender(rset.getString("gender"));
				user.setAddress(rset.getString("address"));
				user.setEmail(rset.getString("email"));
				user.setPurpose(rset.getString("purpose"));
				user.setAgreeYN(rset.getString("agree_YN"));
				user.setProfile(rset.getString("profile"));
				user.setWeight(rset.getShort("weight"));
				user.setCautionCount(rset.getInt("caution_Count"));
				user.setScore(rset.getInt("score"));
				user.setDropYN(rset.getString("drop_YN"));
				user.setEnrollDate(rset.getDate("enroll_Date"));
				user.setPartnerId(rset.getString("partner_Id"));
				
				System.out.println("user : " + user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return user;
	}

	public int updateUser(Connection conn, User user) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_user set nickName = ?, user_NM = ?, "
				+ "gender = ?, address = ?, email = ?, profile = ? "
				+ "where user_id = ?";
		
		System.out.println("별명 : " + user.getNickName());
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, user.getNickName());
			pstmt.setString(2, user.getUserNm());
			pstmt.setString(3, user.getGender());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getProfile());
			pstmt.setString(7, user.getUserId());
			
			
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	

}
