package partner.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import user.model.vo.User;

public class PartnerDao {

	public User viewPartner(Connection conn, String userId) {
		User partner = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_user " + 
						"where user_id = " + 
						"(select partner_id from tb_user where user_id = ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				partner = new User();
				partner.setUserId(rset.getString("user_id"));
				partner.setUserNm(rset.getString("user_nm"));
				partner.setUserPwd(rset.getString("user_pwd"));
				partner.setNickName(rset.getString("nickname"));
				partner.setBirth(rset.getDate("birth"));
				partner.setGender(rset.getString("gender"));
				partner.setAddress(rset.getString("address"));
				partner.setEmail(rset.getString("email"));
				partner.setPurpose(rset.getString("purpose"));
				partner.setAgreeYN(rset.getString("agree_yn"));
				partner.setProfile(rset.getString("profile"));
				partner.setWeight(rset.getInt("weight"));
				partner.setCautionCount(rset.getInt("caution_count"));
				partner.setScore(rset.getInt("score"));
				partner.setDropYN(rset.getString("drop_yn"));
				partner.setEnrollDate(rset.getDate("enroll_date"));
				partner.setPartnerId(userId);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return partner;
	}

	public ArrayList<User> selectList(Connection conn, String location, String gender, int age, int score) {
		ArrayList<User> list = new ArrayList<User>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * " +
					   "from (select * from (select nvl(round(months_between(sysdate, birth) / 12 + 1.3), 0) as age, user_id, user_nm, user_pwd, nickname, birth, gender, address, email, purpose, agree_yn, profile, weight, caution_count, score, drop_yn, enroll_date, partner_id from tb_user) " +
				       "where age like '" + age + "_') " +
				       "where address like '%" + location + "%' and gender = '" + gender + "'  and score >= " + score + " and partner_id is null ";
				                     
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				User partner = new User();
				partner.setUserId(rset.getString("user_id"));
				partner.setUserNm(rset.getString("user_nm"));
				partner.setUserPwd(rset.getString("user_pwd"));
				partner.setNickName(rset.getString("nickname"));
				partner.setBirth(rset.getDate("birth"));
				partner.setGender(rset.getString("gender"));
				partner.setAddress(rset.getString("address"));
				partner.setEmail(rset.getString("email"));
				partner.setPurpose(rset.getString("purpose"));
				partner.setAgreeYN(rset.getString("agree_yn"));
				partner.setProfile(rset.getString("profile"));
				partner.setWeight(rset.getInt("weight"));
				partner.setCautionCount(rset.getInt("caution_count"));
				partner.setScore(rset.getInt("score"));
				partner.setDropYN(rset.getString("drop_yn"));
				partner.setEnrollDate(rset.getDate("enroll_date"));
				partner.setPartnerId(rset.getString("partner_id"));
				
				list.add(partner);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public int deletePartner(Connection conn, String userId) {
		int result = 0;
		int result2 = 0;
		Statement stmt = null;
		Statement stmt2 = null;
		
		String query = "update tb_user set partner_id = null where user_id = '" + userId + "'";
		String query2 = "update tb_user set partner_id = null where partner_id = '" + userId + "'";

		try {
			stmt = conn.createStatement();
			stmt2 = conn.createStatement();
			result = stmt.executeUpdate(query);
			result2 = stmt2.executeUpdate(query2);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(stmt2);
		}
		return result+result2;
	}

	public User detailPartner(Connection conn, String userId) {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * " +
					   "from (select * from (select nvl(round(months_between(sysdate, birth) / 12 + 1.3), 0) as age, user_id, user_nm, user_pwd, nickname, birth, gender, address, email, purpose, agree_yn, profile, weight, caution_count, score, drop_yn, enroll_date, partner_id from tb_user)) " + 
					   "where user_id = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				user = new User();
				user.setUserId(userId);
				user.setUserNm(rset.getString("user_nm"));
				user.setUserPwd(rset.getString("user_pwd"));
				user.setNickName(rset.getString("nickname"));
				user.setBirth(rset.getDate("birth"));
				user.setGender(rset.getString("gender"));
				user.setAddress(rset.getString("address"));
				user.setEmail(rset.getString("email"));
				user.setPurpose(rset.getString("purpose"));
				user.setAgreeYN(rset.getString("agree_yn"));
				user.setProfile(rset.getString("profile"));
				user.setWeight(rset.getInt("weight"));
				user.setCautionCount(rset.getInt("caution_count"));
				user.setScore(rset.getInt("score"));
				user.setDropYN(rset.getString("drop_yn"));
				user.setEnrollDate(rset.getDate("enroll_date"));
				user.setPartnerId(rset.getString("partner_id"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return user;
	}

}
