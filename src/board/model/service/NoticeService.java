package board.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import board.model.dao.NoticeDao;
import board.model.vo.Board;
import board.model.vo.Reply;
public class NoticeService {

	private NoticeDao ndao = new NoticeDao();
	
	public int getListCount() {
		Connection conn = getConnection();
		int listCount = ndao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Board> selectList(int currentPage, int limit) {
		Connection conn = getConnection();
		ArrayList<Board> list = ndao.selectList(conn,currentPage,limit);
		close(conn);
		return list;
	}


	public void addReadCount(int bNo) {
		Connection conn = getConnection();
		int result = ndao.addReadCount(conn,bNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return;
		
	}


	public Board selectBoard(int bNo) {
		Connection conn = getConnection();
		Board board = ndao.selectBoard(conn,bNo);
		close(conn);
		return board;
	}

	public ArrayList<Board> selectList(String keyWord, String category,int currentPage, int limit) {
		Connection conn = getConnection();
		ArrayList<Board> list = ndao.selectList(conn, keyWord, category, currentPage, limit);
		close(conn);
		return list;
	}

	public int insertNotice(Board b) {
		Connection conn = getConnection();
		int result = new NoticeDao().insertNotice(conn,b);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int getListCount(String keyWord, String category) {
		Connection conn = getConnection();
		int listCount = ndao.getListCount(conn,keyWord,category);
		close(conn);
		return listCount;
		
	}

	public int updateNotice(Board b) {
		Connection conn = getConnection();
		int result = ndao.updateNotice(conn,b);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int deleteNotice(int bnum) {
		Connection conn = getConnection();
		int result = ndao.deleteNotice(conn,bnum);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int writeCom(HashMap hm) {
		Connection conn = getConnection();
		int result = 0;
		result = ndao.writerCom(conn,hm);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public ArrayList<Reply> comList(int bnum) {
		Connection conn = getConnection();
		ArrayList<Reply> list = ndao.comList(conn,bnum);
		close(conn);
		return list;
	}

	public int deleteCom(int cnum) {
		int result = 0;
		Connection conn = getConnection();
		result = ndao.deleteCom(conn,cnum);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int selectComnum(String userId) {
		int cnum = 0;
		Connection conn = getConnection();
		cnum = ndao.selectComnum(conn,userId);
		close(conn);
		return cnum;
	}



}
