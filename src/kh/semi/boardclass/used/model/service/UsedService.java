package kh.semi.boardclass.used.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.used.model.dao.UsedDao;
import kh.semi.boardclass.used.model.vo.Used;

public class UsedService {

	public UsedService() {
	}

	public ArrayList<Used> selectUsedList(int start, int end, String search) {
		ArrayList<Used> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new UsedDao().selectUsedList(conn, start, end, search);
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public ArrayList<Used> selectCateUsedList(int start, int end, String cate, String search) {
		ArrayList<Used> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new UsedDao().selectCateUsedList(conn, start, end, cate, search);
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
	
	public Used getUsedDetail(int usedNo) {
		Used vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new UsedDao().getUsedDetail(conn, usedNo);
		JDBCTemplate.close(conn);
		return vo;
	}

	public int insertUsed(Used vo) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new UsedDao().insertUsed(conn, vo);
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateUsed(Used vo, int usedNo) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new UsedDao().updateUsed(conn, vo, usedNo);
		System.out.println("result����?"+result);
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteUsed(int usedNo) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new UsedDao().deleteUsed(conn, usedNo);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int countUsedLike(int usedNo, String userId){
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new UsedDao().countUsedLike(conn, usedNo, userId);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int deleteUsedLike(int usedNo, String userId) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new UsedDao().deleteUsedLike(conn, usedNo, userId);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int insertUsedLike(int usedNo, String userId) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new UsedDao().insertUsedLike(conn, usedNo, userId);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int countUsedReport(int usedNo, String userId) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new UsedDao().countUsedReport(conn, usedNo, userId);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int insertUsedReport(int usedNo, String userId) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new UsedDao().insertUsedReport(conn, usedNo, userId);
		JDBCTemplate.close(conn);
		return result;
	}

}
