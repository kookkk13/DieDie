package service.faq.model.service;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;
import service.faq.model.dao.FAQDao;
import service.faq.model.vo.FAQ;

public class FAQService {
	private FAQDao fdao = new FAQDao();
	
	public FAQService() {}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = fdao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<FAQ> selectList(int currentPage, int limit) {
		Connection conn = getConnection();
		ArrayList<FAQ> list = fdao.selectList(conn, currentPage, limit);
		close(conn);
		return list;
	}

	public FAQ selectBoard(int boardNum) {
		Connection conn = getConnection();
		FAQ faq = fdao.selectBoard(conn, boardNum);
		close(conn);
		return faq;
	}

}
