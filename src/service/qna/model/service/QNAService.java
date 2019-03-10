package service.qna.model.service;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;
import service.qna.model.dao.QNADao;
import service.qna.model.vo.QNA;
import service.qna.model.vo.QNAReply;

public class QNAService {
	private QNADao qdao = new QNADao();
	
	public QNAService() {}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = qdao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<QNA> selectList(int currentPage, int limit) {
		Connection conn = getConnection();
		ArrayList<QNA> list = qdao.selectList(conn, currentPage, limit);
		close(conn);
		return list;
	}
	
	public QNA selectBoard(int boardNum) {
		Connection conn = getConnection();
		QNA qna = qdao.selectBoard(conn, boardNum);
		close(conn);
		return qna;
	}

	public int deleteBoard(int boardNum) {
		Connection conn = getConnection();
		int result = qdao.deleteBoard(conn, boardNum);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int writeBoard(QNA qna) {
		Connection conn = getConnection();
		int result = qdao.writeBoard(conn, qna);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int modifyBoard(QNA qna) {
		Connection conn = getConnection();
		int result = qdao.modifyBoard(conn, qna);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public ArrayList<QNAReply> selectReplyList(int boardNum) {
		Connection conn = getConnection();
		ArrayList<QNAReply> list = qdao.selectReplyList(conn, boardNum);
		close(conn);
		return list;
	}

	public QNAReply selectReply(int replyNum) {
		Connection conn = getConnection();
		QNAReply qr = qdao.selectReply(conn, replyNum);
		close(conn);
		return qr;
	}

	

}
