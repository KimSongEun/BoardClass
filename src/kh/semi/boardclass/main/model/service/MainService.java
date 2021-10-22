package kh.semi.boardclass.main.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.boardclass.admin.model.vo.Banner;
import kh.semi.boardclass.admin.model.vo.Notice;
import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.main.model.dao.MainDao;

public class MainService {

	public MainService() {
	}
	
	public ArrayList<Banner> getAdList() {
		ArrayList<Banner> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MainDao().getAdList(conn);
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public int getAdCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new MainDao().getAdCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}	

	public ArrayList<Notice> getNotice() {
		ArrayList<Notice> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MainDao().getNoticeList(conn);
		JDBCTemplate.close(conn);
		return volist;
	}
}
