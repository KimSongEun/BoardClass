package kh.semi.boardclass.community.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.boardclass.admin.model.dao.AdminDao;
import kh.semi.boardclass.admin.model.vo.Notice;
import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.community.model.dao.CommunityDao;
import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.community.model.vo.BoardReport;
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
		
		volist = new CommunityDao().selectBoardList(conn, start, end, category);
		
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
	public ArrayList<Board> bestFreeView () {
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();
		
		list = new CommunityDao().bestFreeView(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}
	public ArrayList<Board> bestFreeViewone () {
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();
		
		list = new CommunityDao().bestFreeViewone(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}
	public ArrayList<Board> bestFreeViewtwo(){
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();
		
		list = new CommunityDao().bestFreeViewtwo(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}
	public ArrayList<Board> bestFreeViewthree(){
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();

		list = new CommunityDao().bestFreeViewthree(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}
	public ArrayList<Board> bestFreeViewfour(){
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();

		list = new CommunityDao().bestFreeViewfour(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}
	public ArrayList<Board> bestFreeViewfive(){
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();

		list = new CommunityDao().bestFreeViewfive(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}
	// 자유게시판 댓글순
	public ArrayList<Board> bestFreeComt () {
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();
		list = new CommunityDao().bestFreeComt(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	//자유게시판 추천순
	public ArrayList<Board> bestFreeLike () {
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();
		list = new CommunityDao().bestFreeLike(conn);
		JDBCTemplate.close(conn);
		return list;
	}
//	public ArrayList<Board> bestFreeComtTwo () {
//		ArrayList<Board> list = null;
//		Connection conn = JDBCTemplate.getConnection();
//		list = new CommunityDao().bestFreeComtTwo(conn);
//		JDBCTemplate.close(conn);
//		return list;
//	}
//	public ArrayList<Board> bestFreeComtThree () {
//		ArrayList<Board> list = null;
//		Connection conn = JDBCTemplate.getConnection();
//		list = new CommunityDao().bestFreeComtThree(conn);
//		JDBCTemplate.close(conn);
//		return list;
//	}
//	public ArrayList<Board> bestFreeComtFour () {
//		ArrayList<Board> list = null;
//		Connection conn = JDBCTemplate.getConnection();
//		list = new CommunityDao().bestFreeComtFour(conn);
//		JDBCTemplate.close(conn);
//		return list;
//	}
//	public ArrayList<Board> bestFreeComtFive () {
//		ArrayList<Board> list = null;
//		Connection conn = JDBCTemplate.getConnection();
//		list = new CommunityDao().bestFreeComtFive(conn);
//		JDBCTemplate.close(conn);
//		return list;
//	}
	//유저정보게시판 인기글 추천순 
	public ArrayList<Board> bestUserLike () {
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();
		list = new CommunityDao().bestUserLike(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	// 유저정보게시판 인기글
	public ArrayList<Board> bestUserViewOne () {
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();
		list = new CommunityDao().bestUserViewOne(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	public ArrayList<Board> bestUserViewTwo () {
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();
		list = new CommunityDao().bestUserViewTwo(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	public ArrayList<Board> bestUserViewThree () {
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();
		list = new CommunityDao().bestUserViewThree(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	public ArrayList<Board> bestUserViewFour () {
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();
		list = new CommunityDao().bestUserViewFour(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	public ArrayList<Board> bestUserViewFive () {
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();
		list = new CommunityDao().bestUserViewFive(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	//유저정보게시판 댓글순
	public ArrayList<Board> bestUserComtOne () {
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();
		list = new CommunityDao().bestUserComtOne(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	public ArrayList<Board> bestUserComtTwo () {
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();
		list = new CommunityDao().bestUserComtTwo(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	public ArrayList<Board> bestUserComtThree () {
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();
		list = new CommunityDao().bestUserComtThree(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	public ArrayList<Board> bestUserComtFour () {
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();
		list = new CommunityDao().bestUserComtFour(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	public ArrayList<Board> bestUserComtFive () {
		ArrayList<Board> list = null;
		Connection conn = JDBCTemplate.getConnection();
		list = new CommunityDao().bestUserComtFive(conn);
		JDBCTemplate.close(conn);
		return list;
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
	public int insertBoard(Board vo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		 new CommunityDao().insertBoard(conn, vo);
		 JDBCTemplate.close(conn);
			return result;
	}
	public int updateBoard(Board vo, int boardNo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		 new CommunityDao().updateBoard(conn, vo, boardNo);
	 if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
		
	}
	public int deleteBoard (int boardNo) { 
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		 new CommunityDao().deleteBoard(conn, boardNo);
	 if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
		
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

	public int insertUserBoard(Board vo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		 new CommunityDao().insertUserBoard(conn, vo);
	 if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
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

	public int insertGatheringBoard(Board vo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		 new CommunityDao().insertGatheringBoard(conn, vo);
	 if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
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
	//공지검색
	public ArrayList<Notice> searchNoticeContent(String keyword, int start, int end) {
		ArrayList<Notice> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new CommunityDao().searchNoticeContent(conn, keyword, start, end);
		JDBCTemplate.close(conn);
		return volist;
		
	}
	public int getNoticeSearchCount(String keyword) { 
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new CommunityDao().getNoticeSearchCount(conn, keyword);
		JDBCTemplate.close(conn);
		return result;
	}
	public ArrayList<Notice> searchNoticeTitle (String keyword, int start, int end) {
		ArrayList<Notice> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new CommunityDao().searchNoticeTitle(conn, keyword, start, end);
		JDBCTemplate.close(conn);
		return volist;
	}
	public int getNoticeSearchTitleCount(String keyword) { 
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new CommunityDao().getNoticeSearchTitleCount(conn, keyword);
		JDBCTemplate.close(conn);
		return result;
	}
	public void searchUserBoard() {

	}

	public void searchGatheringBoard() {

	}
	
	public ArrayList<Comment> selectComment(int boardNo) {
		ArrayList<Comment> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new CommunityDao().selectComment(conn, boardNo);
		JDBCTemplate.close(conn);
		return volist;
	}

	public int insertComment(Comment comment,  String userId) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		 new CommunityDao().insertComment(conn, comment, userId);
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

	public int insertReportBoard(int boardNo, String userId) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new CommunityDao().insertReportBoard(conn, boardNo, userId);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int countBoardReport(int boardNo, String userId) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new CommunityDao().countBoardReport(conn, boardNo, userId);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int countComtReport (int commentNo, String userId) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new CommunityDao().countComtReport(conn, commentNo, userId);
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertReportComment(int commentNo, String userId) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new CommunityDao().insertReportComment(conn, commentNo, userId);
		JDBCTemplate.close(conn);
		return result;
	}
	public int countReportComment (int commentNo, String userId) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new CommunityDao().countReportComment(conn, commentNo, userId);
		JDBCTemplate.close(conn);
		return result;
	}

	public int totalLikeBoard (int boardNo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new CommunityDao().totalLikeBoard(conn, boardNo);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int countLikeBoard(int boardNo, String userId) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new CommunityDao().countLikeBoard(conn, boardNo, userId);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int insertLikeBoard(int boardNo, String userId) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new CommunityDao().insertLikeBoard(conn, boardNo, userId);
		JDBCTemplate.close(conn);
		System.out.println("서비스insertlike="+result);
		return result;
	}
	
	public int deleteLikeBoard(int boardNo, String userId) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new CommunityDao().deleteLikeBoard(conn, boardNo, userId);
		JDBCTemplate.close(conn);
		System.out.println("서비스deletelike="+result);
		return result;
	}

}
