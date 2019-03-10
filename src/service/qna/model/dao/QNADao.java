package service.qna.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import service.qna.model.vo.QNA;
import service.qna.model.vo.QNAReply;

public class QNADao {
	public QNADao() {}

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from tb_qna";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next())
				listCount = rset.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}

	public ArrayList<QNA> selectList(Connection conn, int currentPage, int limit) {
		ArrayList<QNA> list = new ArrayList<QNA>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query =  "select * " +
						"from (select rownum rnum, qna_no, qna_category, qna_title, qna_contents, " +
						"qna_date, qna_hits, qna_pwd, user_id, qna_file1, qna_file2, qna_file3, " +
						"qna_refile1, qna_refile2, qna_refile3 " +
						"from (select * from tb_qna order by qna_no desc)) " +
						"where rnum between ? and ?";
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				QNA qna = new QNA();
				qna.setqNo(rset.getInt("qna_no"));
				qna.setCategory(rset.getString("qna_category"));
				qna.setqTitle(rset.getString("qna_title"));
				qna.setContents(rset.getString("qna_contents"));
				qna.setqDate(rset.getDate("qna_date"));
				qna.setqHits(rset.getInt("qna_hits"));
				qna.setPwd(rset.getString("qna_pwd"));
				qna.setUserId(rset.getString("user_id"));
				qna.setFile1(rset.getString("qna_file1"));
				qna.setFile2(rset.getString("qna_file2"));
				qna.setFile3(rset.getString("qna_file3"));
				qna.setRefile1(rset.getString("qna_refile1"));
				qna.setRefile2(rset.getString("qna_refile2"));
				qna.setRefile3(rset.getString("qna_refile3"));
				
				list.add(qna);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public QNA selectBoard(Connection conn, int boardNum) {
		QNA qna = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String  query = "select * from tb_qna where qna_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				qna = new QNA();
				qna.setqNo(rset.getInt("qna_no"));
				qna.setCategory(rset.getString("qna_category"));
				qna.setqTitle(rset.getString("qna_title"));
				qna.setContents(rset.getString("qna_contents"));
				qna.setqDate(rset.getDate("qna_date"));
				qna.setqHits(rset.getInt("qna_hits"));
				qna.setPwd(rset.getString("qna_pwd"));
				qna.setUserId(rset.getString("user_id"));
				qna.setFile1(rset.getString("qna_file1"));
				qna.setFile2(rset.getString("qna_file2"));
				qna.setFile3(rset.getString("qna_file3"));
				qna.setRefile1(rset.getString("qna_refile1"));
				qna.setRefile2(rset.getString("qna_refile2"));
				qna.setRefile3(rset.getString("qna_refile3"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return qna;
	}

	public int deleteBoard(Connection conn, int boardNum) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_qna where qna_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNum);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int writeBoard(Connection conn, QNA qna) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_qna values (seq_qna.nextval, " + 
					   "?, ?, ?, sysdate, 0, ?, ?, ?, ?, ?, ?, ?, ?)";
	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, qna.getCategory());
			pstmt.setString(2, qna.getqTitle());
			pstmt.setString(3, qna.getContents());
			pstmt.setString(4, qna.getPwd());
			pstmt.setString(5, qna.getUserId());
			pstmt.setString(6, qna.getFile1());
			pstmt.setString(7, qna.getFile2());
			pstmt.setString(8, qna.getFile3());
			pstmt.setString(9, qna.getRefile1());
			pstmt.setString(10, qna.getRefile2());
			pstmt.setString(11, qna.getRefile3());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int writeReply(Connection conn, QNAReply qr) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_qna_reply values (seq_rp_qna.nextval, sysdate, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, qr.getContent());
			pstmt.setString(2, qr.getUserId());
			pstmt.setInt(3, qr.getqNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int modifyBoard(Connection conn, QNA qna) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_qna set qna_category = ?, qna_title = ?, qna_contents = ?, " + 
					   "qna_date = sysdate, qna_hits = ?, qna_pwd = ?, qna_file1 = ?, qna_file2 = ?, qna_file3 = ?, " + 
					   "qna_refile1 = ?, qna_refile2 = ?, qna_refile3 = ? " +
					   "where qna_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);	
			pstmt.setString(1, qna.getCategory());
			pstmt.setString(2, qna.getqTitle());
			pstmt.setString(3, qna.getContents());
			pstmt.setInt(4, qna.getqHits());
			pstmt.setString(5, qna.getPwd());
			if(qna.getFile1() != null) {
				pstmt.setString(6, qna.getFile1());
				pstmt.setString(9, qna.getRefile1());
			}else {
				pstmt.setString(6, null);
				pstmt.setString(9, null);
			}if(qna.getFile2() != null) {
				pstmt.setString(7, qna.getFile2());
				pstmt.setString(10, qna.getRefile2());
			}else {
				pstmt.setString(7, null);
				pstmt.setString(10, null);
			}if(qna.getFile3() != null) {
				pstmt.setString(8, qna.getFile3());
				pstmt.setString(11, qna.getRefile3());				
			}else {
				pstmt.setString(8, null);
				pstmt.setString(11, null);
			}
			pstmt.setInt(12, qna.getqNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<QNAReply> selectReplyList(Connection conn, int boardNum) {
		ArrayList<QNAReply> list = new ArrayList<QNAReply>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query =  "select * from tb_qna_reply where qna_no = " + boardNum;
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				QNAReply qr = new QNAReply();
				qr.setqRpNo(rset.getInt("qna_rp_no"));
				qr.setQdate(rset.getDate("qna_rp_date"));
				qr.setContent(rset.getString("qna_rp_content"));
				qr.setUserId(rset.getString("user_id"));
				qr.setqNo(boardNum);
				
				list.add(qr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public QNAReply selectReply(Connection conn, int replyNum) {
		QNAReply qr = new QNAReply();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query =  "select * from tb_qna_reply where qna_rp_no = " + replyNum;
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				qr = new QNAReply();
				qr.setqRpNo(replyNum);
				qr.setQdate(rset.getDate("qna_rp_date"));
				qr.setContent(rset.getString("qna_rp_content"));
				qr.setUserId(rset.getString("user_id"));
				qr.setqNo(rset.getInt("qna_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return qr;
	}

}
