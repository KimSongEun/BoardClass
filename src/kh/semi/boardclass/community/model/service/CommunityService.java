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
	// 전체 보드 개수 조회
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
	public void updateCount (Board vo) {
		Connection conn = JDBCTemplate.getConnection();
		new CommunityDao().updateCount(conn, vo);
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
	// 자유게시판 수정
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
	// 자유게시판 삭제
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
	
//	public ArrayList<Board> searchFreeBoard(String query, String field, int start, int end) {
//		ArrayList<Board> list = null;
//		Connection conn = JDBCTemplate.getConnection();
//		list = new CommunityDao().searchFreeBoard(conn, query, field,start,end); 
//		return list;
//	}
	
	//검색
	
	public ArrayList<Board> searchAllBoardUserId( String keyword, int start, int end) {
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();
		list = new CommunityDao().searchAllBoardUserId(conn, keyword,start,end); 
		return list;
	}
	
	public int getAllBoardUserIdCount(String keyword) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new CommunityDao().getAllBoardUserIdCount(conn, keyword);
		return result;
	}
	
	public ArrayList<Board> searchAllBoardTitle(String keyword, int start, int end){
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();
		list = new CommunityDao().searchAllBoardTitle(conn, keyword, start, end);
		return list;
		
	}
	public int getAllBoardTitleCount(String keyword) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new CommunityDao().getAllBoardTitleCount(conn, keyword);
		return result;
	}
	
	public ArrayList<Board> searchAllBoardContent(String keyword, int start, int end){
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();
		list = new CommunityDao().searchAllBoardContent(conn, keyword, start, end);
		return list;
	}
	public int getAllBoardContentCount(String keyword) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new CommunityDao().getAllBoardContentCount(conn, keyword);
		return result;
	}
	
	
	public void searchUserBoard() {

	}

	public void searchGatheringBoard() {

	}
	// 댓글
	public int getCommentCount(int boardNo) { 
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new CommunityDao().getCommentCount(conn,boardNo);
		return result;
	}
	
	public ArrayList<Comment> selectComment(int boardNo) {
		ArrayList<Comment> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new CommunityDao().selectComment(conn, boardNo);
		JDBCTemplate.close(conn);
		return volist;
	}

	public int insertComment(Comment comment) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		 new CommunityDao().insertComment(conn, comment);
	 if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateComment() {
		int result = -1;
		return result;
	}

	public int deleteComment(int commentNo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		 new CommunityDao().deleteComment(conn, commentNo);
		JDBCTemplate.close(conn);
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
