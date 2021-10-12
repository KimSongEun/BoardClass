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
	public Board getBoard(int boardNo) {
		Board vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new CommunityDao().getBoard(conn, boardNo);
		JDBCTemplate.close(conn);
		return vo;
	}
	public int getBoardCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new CommunityDao().getBoardCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}
	//category 별 보드 개수 조회
	public int getBoardCount(String category) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new CommunityDao().getBoardCount(conn, category);
		JDBCTemplate.close(conn);
		return result;
	}
	// 전체 글 리스트 조회
	public ArrayList<Board> selectBoardList(int start, int end){
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		
		volist = new CommunityDao().selectBoardList(conn, start, end);
		
		JDBCTemplate.close(conn);
		return volist;
	}
	// category 별 글 리스트 조회
	public ArrayList<Board> selectBoardList(int start, int end, String category) {
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		
		volist = new CommunityDao().selectBoardList(conn, start, end);
		
		JDBCTemplate.close(conn);
		return volist;
	}

	// 조회수 1 상승
	public void readCount (int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		 new CommunityDao().readCount(conn, boardNo);
		 JDBCTemplate.close(conn);
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
	// 자유게시판 글쓰기
	public int insertFreeBoard(Board vo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		 new CommunityDao().insertFreeBoard(conn, vo);
	 if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateFreeBoard(Board vo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		 new CommunityDao().updateFreeBoard(conn, vo);
	 if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteFreeBoard(int boardNo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		 new CommunityDao().deleteFreeBoard(conn, boardNo);
	 if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
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
