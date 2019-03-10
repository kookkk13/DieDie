package partner.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import partner.model.dao.PartnerDao;
import user.model.vo.User;

public class PartnerService {
	private PartnerDao pdao = new PartnerDao();

	public User viewPartner(String userId) {
		Connection conn = getConnection();
		User partner = pdao.viewPartner(conn, userId);
		close(conn);
		return partner;
	}

	public ArrayList<User> selectList(String location, String gender, int age, int score) {
		Connection conn = getConnection();
		ArrayList<User> list = pdao.selectList(conn, location, gender, age, score);
		close(conn);
		return list;
	}

	public int delectPartner(String userId) {
		Connection conn = getConnection();
		int result = pdao.deletePartner(conn, userId);
		if(result > 1)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public User detailPartner(String userId) {
		Connection conn =getConnection();
		User user = pdao.detailPartner(conn, userId);
		close(conn);
		return user;
	}

}
