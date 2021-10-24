package kh.semi.boardclass.main.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.boardclass.admin.model.vo.Banner;
import kh.semi.boardclass.admin.model.vo.Notice;
import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.community.model.dao.CommunityDao;
import kh.semi.boardclass.community.model.vo.Board;
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
	public ArrayList<Board> getBestBoardOne() {
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MainDao().getBestBoardOne(conn);
		JDBCTemplate.close(conn);
		return volist;
	}
	public ArrayList<Board> getBestBoardTwo () {
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MainDao().getBestBoardTwo(conn);
		JDBCTemplate.close(conn);
		return volist;
	}
	public ArrayList<Board> getBestBoardThree () {
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MainDao().getBestBoardThree(conn);
		JDBCTemplate.close(conn);
		return volist;
	}
	public ArrayList<Board> getBestBoardFour () {
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MainDao().getBestBoardFour(conn);
		JDBCTemplate.close(conn);
		return volist;
	}
	public ArrayList<Board> getBestBoardFive () {
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MainDao().getBestBoardFive(conn);
		JDBCTemplate.close(conn);
		return volist;
	}

}
