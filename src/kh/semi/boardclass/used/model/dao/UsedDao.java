package kh.semi.boardclass.used.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.boardclass.used.model.vo.Used;

public class UsedDao {

	public UsedDao() {
	}

	public int insertUsed(Connection conn, Used used) {
		int result = 0;
		return result;
	}
	
	public ArrayList<Used> selectUsed(Connection conn, Used used) {
		ArrayList<Used> volist = null;
		return volist;
	}
	
	public void updateUsed(Connection conn, Used used) {
		
	}
	
	public int chatUset(Connection conn, Used used) {
		int result = 0;
		return result;
	}
}
