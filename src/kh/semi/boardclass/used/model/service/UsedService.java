package kh.semi.boardclass.used.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.used.model.dao.UsedDao;
import kh.semi.boardclass.used.model.vo.Used;

public class UsedService {

	public UsedService() {
	}
	
	public int insertUsed(Used used) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new UsedDao().insertUsed(conn, used);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public ArrayList<Used> selectUsed(Used used) {
		ArrayList<Used> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new UsedDao().selectUsed(conn, used);
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public void updateUsed(Used used) {
		Connection conn = JDBCTemplate.getConnection();
		new UsedDao().updateUsed(conn, used);
		JDBCTemplate.close(conn);
	}
	
	public int chatUset(Used used) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new UsedDao().chatUset(conn, used);
		JDBCTemplate.close(conn);
		return result;
	}

}
