package kh.semi.boardclass.used.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.used.model.dao.UsedDao;
import kh.semi.boardclass.used.model.vo.Used;

public class UsedService {

	public UsedService() {
	}

	public ArrayList<Used> selectUsedList() {
		ArrayList<Used> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new UsedDao().selectUsedList(conn);
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public int getUsedCount() {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new UsedDao().getUsedCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}

//	public int insertUsed(Used vo) {
//		int result = 0;
//		Connection conn = JDBCTemplate.getConnection();
//		result = new UsedDao().insertUsed(conn, vo);
//		JDBCTemplate.close(conn);
//		return result;
//	}

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
