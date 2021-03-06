package kh.semi.boardclass.mypage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.mypage.model.dao.MyPageDao;
import kh.semi.boardclass.mypage.model.vo.MyGameLike;
import kh.semi.boardclass.mypage.model.vo.MyGameReview;
import kh.semi.boardclass.mypage.model.vo.UserMyComt;
import kh.semi.boardclass.mypage.model.vo.UserMyUsed;
import kh.semi.boardclass.used.model.vo.Used;


public class MyPageService {

	public MyPageService() {
		// TODO Auto-generated constructor stub
	}

	

// 보드게임 찜리스트 
	public int getMyBoardGameListCount(String userId) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new MyPageDao().getMyBoardGameListCount(conn, userId);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<MyGameLike> myBoardGameList(String userId, int start, int end) {
		ArrayList<MyGameLike> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MyPageDao().myBoardGameList(conn, userId, start, end);
		JDBCTemplate.close(conn);
		return volist;
	}

	// 보드게임 리뷰
	public int getMyBoardGameReviewCount(String userId) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new MyPageDao().getMyBoardGameReviewCount(conn, userId);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<MyGameReview> myBoardGameReviewList(String userId, int start, int end) {
		ArrayList<MyGameReview> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MyPageDao().myBoardGameReviewList(conn, userId, start, end);
		JDBCTemplate.close(conn);
		return volist;
	}

// 중고거래 판매글 
	public int getMyTradeListCount(String userId) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new MyPageDao().getMyTradeListCount(conn, userId);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Used> myTradeList(String userId, int start, int end) {
		ArrayList<Used> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MyPageDao().myTradeList(conn, userId, start, end);
		JDBCTemplate.close(conn);
		return volist;
	}

// 중고거래 찜 

	public int getMyLikeTradeListCount(String userId) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new MyPageDao().getMyLikeTradeListCount(conn, userId);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<UserMyUsed> myLikeTradeList(String userId, int start, int end) {
		ArrayList<UserMyUsed> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MyPageDao().myLikeTradeList(conn, userId, start, end);
		JDBCTemplate.close(conn);
		return volist;
	}

	// 커뮤니티 작성글
	public int getMyBoardCount(String userId) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new MyPageDao().getMyBoardCount(conn, userId);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Board> myBoardList(String userId, int start, int end) {
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MyPageDao().myBoardList(conn, userId, start, end);
		JDBCTemplate.close(conn);
		return volist;
	}

// 커뮤니티 댓글 
	public int getMyBoardComtCount(String userId) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new MyPageDao().getMyBoardComtCount(conn, userId);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<UserMyComt> myBoardCommentList(String userId, int start, int end) {
		ArrayList<UserMyComt> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MyPageDao().myBoardCommentList(conn, userId, start, end);
		JDBCTemplate.close(conn);
		return volist;
	}

}
