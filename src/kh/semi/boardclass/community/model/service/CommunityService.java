package kh.semi.boardclass.community.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.community.model.dao.CommunityDao;
import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.community.model.vo.Comment;

public class CommunityService {

	public CommunityService() {
		// TODO Auto-generated constructor stub
	}
	// 보드 가져오기
	public Board getBoard(int board_no) {
		Board vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new CommunityDao().getBoard(conn, board_no);
		JDBCTemplate.close(conn);
		return vo;
	}
	//보드 개수 조회
	public static int getBoardCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new CommunityDao().getBoardCount(conn);
		return result;
	}
	// 보드 리스트 조회
	public ArrayList<Board> selectBoardList(int start, int end){
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		
		volist = new CommunityDao().selectBoardList(conn, start, end);
		
		JDBCTemplate.close(conn);
		return volist;
	}

	public ArrayList<Board> selectUserBoardList() {
		ArrayList<Board> volist = null;
		return volist;
	}

	public ArrayList<Board> selectGatheringBoardList() {
		ArrayList<Board> volist = null;
		return volist;
	}

	public Board getFreeboard() {
		Board vo = null;
		return vo;
	}

	public Board getUserBoard() {
		Board vo = null;
		return vo;
	}

	public Board getGatheringBoard() {
		Board vo = null;
		return vo;
	}

	public int insertFreeBoard() {
		int result = -1;
		return result;
	}

	public int updateFreeBoard() {
		int result = -1;
		return result;
	}

	public int deleteFreeBoard() {
		int result = -1;
		return result;
	}

	public int insertUserBoard() {
		int result = -1;
		return result;
	}

	public int updateUserBoard() {
		int result = -1;
		return result;
	}

	public int deleteUserBoard() {
		int result = -1;
		return result;
	}

	public int insertGatheringBoard() {
		int result = -1;
		return result;
	}

	public int updateGatheringBoard() {
		int result = -1;
		return result;
	}

	public int deleteGatheringBoard() {
		int result = -1;
		return result;
	}

	public void searchFreeBoard() {

	}

	public void searchUserBoard() {

	}

	public void searchGatheringBoard() {

	}

	public ArrayList<Comment> selectComment() {
		ArrayList<Comment> volist = null;
		return volist;
	}

	public int insertComment() {
		int result = -1;
		return result;
	}

	public int updateComment() {
		int result = -1;
		return result;
	}

	public int deleteComment() {
		int result = -1;
		return result;
	}

	public void getRankFreeBoard() {

	}

	public void getRankUserBoard() {

	}

	public void getRankAllBoard() {

	}

	public int insertReportBoard() {
		int result = -1;
		return result;
	}

	public int insertReportComment() {
		int result = -1;
		return result;
	}

	public int insertLikeBoard() {
		int result = -1;
		return result;
	}

}
