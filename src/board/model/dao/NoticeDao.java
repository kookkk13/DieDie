package board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.catalina.filters.RestCsrfPreventionFilter;

import board.model.vo.Board;
import board.model.vo.Reply;

import static common.JDBCTemplate.*;
public class NoticeDao {

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query ="SELECT COUNT(*) FROM TB_BD_NOTICE";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}

	public ArrayList<Board> selectList(Connection conn, int currentPage, int limit) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * "
					 + "FROM(SELECT ROWNUM RNUM, NT_NO, NT_TITLE, NT_CONTENTS, NT_DATE, NT_UP, NT_HITS, USER_ID, NT_FILE1, NT_FILE2, NT_FILE3, NT_REFILE1, NT_REFILE2, NT_REFILE3 FROM (SELECT * FROM TB_BD_NOTICE ORDER BY NT_NO DESC))"
					 + "WHERE RNUM BETWEEN ? AND ?";
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
				Board b = new Board();
				b.setbNo(rset.getInt("NT_NO"));
				b.setbTtitle(rset.getString("NT_TITLE"));
				b.setContent(rset.getString("NT_CONTENTS"));
				b.setbDate(rset.getDate("NT_DATE"));
				b.setbUp(rset.getInt("NT_UP"));
				b.setbHits(rset.getInt("NT_HITS"));
				b.setUserId(rset.getString("USER_ID"));
				b.setFile1(rset.getString("NT_FILE1"));
				b.setFile2(rset.getString("NT_FILE2"));
				b.setFile3(rset.getString("NT_FILE3"));
				b.setRefile1(rset.getString("NT_REFILE1"));
				b.setRefile2(rset.getString("NT_REFILE2"));
				b.setRefile3(rset.getString("NT_REFILE3"));
				
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int addReadCount(Connection conn, int bNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "UPDATE TB_BD_NOTICE SET NT_HITS = NT_HITS + 1 WHERE NT_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Board selectBoard(Connection conn, int bNo) {
		Board b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM TB_BD_NOTICE WHERE NT_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				b = new Board();
				b.setbNo(rset.getInt("NT_NO"));
				b.setbTtitle(rset.getString("NT_TITLE"));
				b.setContent(rset.getString("NT_CONTENTS"));
				b.setbDate(rset.getDate("NT_DATE"));
				b.setbUp(rset.getInt("NT_UP"));
				b.setbHits(rset.getInt("NT_HITS"));
				b.setUserId(rset.getString("USER_ID"));
				b.setFile1(rset.getString("NT_FILE1"));
				b.setFile2(rset.getString("NT_FILE2"));
				b.setFile3(rset.getString("NT_FILE3"));
				b.setRefile1(rset.getString("NT_REFILE1"));
				b.setRefile2(rset.getString("NT_REFILE2"));
				b.setRefile3(rset.getString("NT_REFILE3"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return b;
	}

	public ArrayList<Board> selectList(Connection conn,String keyWord, String category, int currentPage, int limit) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String catnum = null;
		String query = null;
		Boolean flag = false;
		System.out.println("page >>>>> "+currentPage);
		System.out.println("limit >>>>> "+limit);
		
		switch(category) {
			case"1": 
				query = "SELECT *" 
						+"FROM(SELECT ROWNUM RNUM, NT_NO, NT_TITLE, NT_CONTENTS, NT_DATE, NT_UP, NT_HITS, USER_ID, NT_FILE1, NT_FILE2, NT_FILE3, NT_REFILE1, NT_REFILE2, NT_REFILE3 FROM (SELECT * FROM TB_BD_NOTICE ORDER BY NT_NO DESC) WHERE NT_TITLE LIKE ?)"
						+"WHERE RNUM BETWEEN ? AND ?"; 
				break;
			case"2": 
				query = "SELECT *" 
						+"FROM(SELECT ROWNUM RNUM, NT_NO, NT_TITLE, NT_CONTENTS, NT_DATE, NT_UP, NT_HITS, USER_ID, NT_FILE1, NT_FILE2, NT_FILE3, NT_REFILE1, NT_REFILE2, NT_REFILE3 FROM (SELECT * FROM TB_BD_NOTICE ORDER BY NT_NO DESC) WHERE USER_ID LIKE ?)"
						+"WHERE RNUM BETWEEN ? AND ?"; 
				break;
			case"3": 
				query = "SELECT *" 
						+"FROM(SELECT ROWNUM RNUM, NT_NO, NT_TITLE, NT_CONTENTS, NT_DATE, NT_UP, NT_HITS, USER_ID, NT_FILE1, NT_FILE2, NT_FILE3, NT_REFILE1, NT_REFILE2, NT_REFILE3 FROM (SELECT * FROM TB_BD_NOTICE ORDER BY NT_NO DESC) WHERE NT_CONTENTS LIKE ?)"
						+"WHERE RNUM BETWEEN ? AND ?";
				break;
			case"4":
				//query = "SELECT * FROM (SELECT * FROM (SELECT * FROM TB_BD_NOTICE ORDER BY NT_NO DESC)WHERE NT_TITLE LIKE ? OR USER_ID LIKE ?)WHERE ROWNUM BETWEEN ? AND ?";
				query = "SELECT *" 
						+"FROM(SELECT ROWNUM RNUM, NT_NO, NT_TITLE, NT_CONTENTS, NT_DATE, NT_UP, NT_HITS, USER_ID, NT_FILE1, NT_FILE2, NT_FILE3, NT_REFILE1, NT_REFILE2, NT_REFILE3 FROM (SELECT * FROM TB_BD_NOTICE ORDER BY NT_NO DESC) WHERE NT_TITLE LIKE ? OR USER_ID LIKE ?)"
						+"WHERE RNUM BETWEEN ? AND ?";
				flag = true;
				break;
		}
					
		try {
			if(flag) {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "%" + keyWord + "%");
				pstmt.setString(2, "%" + keyWord + "%");
				pstmt.setInt(3, currentPage);
				pstmt.setInt(4, limit);			
			}else {
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, "%" + keyWord + "%");
					pstmt.setInt(2, currentPage);
					pstmt.setInt(3, limit);
			}
			rset = pstmt.executeQuery();

			while(rset.next()) {
				
				Board b = new Board();
				b.setbNo(rset.getInt("NT_NO"));
				b.setbTtitle(rset.getString("NT_TITLE"));
				b.setContent(rset.getString("NT_CONTENTS"));
				b.setbDate(rset.getDate("NT_DATE"));
				b.setbUp(rset.getInt("NT_UP"));
				b.setbHits(rset.getInt("NT_HITS"));
				b.setUserId(rset.getString("USER_ID"));
				b.setFile1(rset.getString("NT_FILE1"));
				b.setFile2(rset.getString("NT_FILE2"));
				b.setFile3(rset.getString("NT_FILE3"));
				b.setRefile1(rset.getString("NT_REFILE1"));
				b.setRefile2(rset.getString("NT_REFILE2"));
				b.setRefile3(rset.getString("NT_REFILE3"));

				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int insertNotice(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query =  "INSERT INTO TB_BD_NOTICE VALUES (SEQ_BD_NOTICE.NEXTVAL, " + 
				   		"?, ?, SYSDATE, 0, 0, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getbTtitle());
			pstmt.setString(2, b.getContent());
			pstmt.setString(3, b.getUserId());
			pstmt.setString(4, b.getFile1());
			pstmt.setString(5, b.getFile2());
			pstmt.setString(6, b.getFile3());
			pstmt.setString(7, b.getRefile1());
			pstmt.setString(8, b.getRefile2());
			pstmt.setString(9, b.getRefile3());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int getListCount(Connection conn, String keyWord, String category) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String catnum = null;
		String query = null;
		Boolean flag = false;
		switch(category) {
		case"1": 
			query ="SELECT COUNT(*) FROM TB_BD_NOTICE WHERE NT_TITLE LIKE ?"; 
			break;
		case"2": 
			query ="SELECT COUNT(*) FROM TB_BD_NOTICE WHERE USER_ID LIKE ?";
			break;
		case"3": 
			query ="SELECT COUNT(*) FROM TB_BD_NOTICE WHERE NT_CONTENTS LIKE ?";
			break;
		case"4": 
			query ="SELECT COUNT(*) FROM TB_BD_NOTICE WHERE NT_CONTENTS LIKE ? OR  NT_TITLE LIKE ?";
			flag = true;
			break;
		}
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyWord + "%");
			if(flag) {
				pstmt.setString(2, "%" + keyWord + "%");
			}
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			System.out.println("=================== "+ listCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	public int updateNotice(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "UPDATE TB_BD_NOTICE SET NT_TITLE = ?, NT_CONTENTS = ?, NT_FILE1 = ?, NT_REFILE1 = ? WHERE NT_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getbTtitle());
			pstmt.setString(2, b.getContent());
			pstmt.setString(3, b.getFile1());
			pstmt.setString(4, b.getRefile1());
			pstmt.setInt(5, b.getbNo());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteNotice(Connection conn, int bnum) {
		int result =0;
		PreparedStatement pstmt = null;
		
		String query = "DELETE FROM TB_BD_NOTICE WHERE NT_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bnum);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int writerCom(Connection conn, HashMap hm) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "INSERT INTO TB_NOTICE_REPLY VALUES (SEQ_NO_COM.NEXTVAL,SYSDATE,?,?,?)";
		
		String content = (String)hm.get("comContent");
		String userid = (String)hm.get("userId");
		int bnum = Integer.parseInt((String)hm.get("bno"));
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, content);
			pstmt.setString(2, userid);
			pstmt.setInt(3, bnum);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Reply> comList(Connection conn, int bnum) {
		ArrayList<Reply> list = new ArrayList<Reply>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM (SELECT * from tb_notice_reply ORDER BY NOTICE_RP_NO) WHERE NOTICE_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bnum);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Reply r = new Reply();
				r.setrNo(rset.getInt("NOTICE_RP_NO"));
				r.setRdate(rset.getDate("NOTICE_RP_DATE"));				
				r.setRcontent(rset.getString("NOTICE_RP_CONTENT"));
				r.setUserId(rset.getString("USER_ID"));
				r.setRbNo(rset.getInt("NOTICE_NO"));
				
				list.add(r);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int deleteCom(Connection conn, int cnum) {
		int result =0;
		PreparedStatement pstmt = null;
		
		String query = "DELETE FROM TB_NOTICE_REPLY WHERE NOTICE_RP_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cnum);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;	
	}

	public int selectComnum(Connection conn, String userId) {
		int cnum = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query ="SELECT * FROM (SELECT * FROM TB_NOTICE_REPLY ORDER BY NOTICE_RP_NO DESC) WHERE USER_ID = ? AND ROWNUM = 1";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				cnum = rset.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return cnum;
	}


}
