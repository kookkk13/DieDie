package service.faq.model.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import service.faq.model.vo.FAQ;

public class FAQDao {
	public FAQDao() {}

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from tb_faq";
		
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

	public ArrayList<FAQ> selectList(Connection conn, int currentPage, int limit) {
		ArrayList<FAQ> list = new ArrayList<FAQ>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * " +
					   "from (select rownum rnum, faq_no, faq_title, faq_conents, user_id " +
					   "from (select * from tb_faq order by faq_no desc)) " +
					   "where rnum between ? and ?";
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				FAQ faq = new FAQ();
				faq.setfNo(rset.getInt("faq_no"));
				faq.setfTitle(rset.getString("faq_title"));
				faq.setContent(rset.getString("faq_conents"));
				faq.setUserId(rset.getString("user_id"));
				
				list.add(faq);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public FAQ selectBoard(Connection conn, int boardNum) {
		FAQ faq = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_faq where faq_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				faq = new FAQ();
				faq.setfNo(boardNum);
				faq.setfTitle(rset.getString("faq_title"));
				faq.setContent(rset.getString("faq_conents"));
				faq.setUserId(rset.getString("user_id"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return faq;
	}

}
