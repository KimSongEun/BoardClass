package kh.semi.boardclass.mypage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.community.model.vo.BoardLike;
import kh.semi.boardclass.community.model.vo.Comment;
import kh.semi.boardclass.game.model.vo.Game;
import kh.semi.boardclass.mypage.model.dao.MyPageDao;
import kh.semi.boardclass.mypage.model.vo.MyGameLike;
import kh.semi.boardclass.mypage.model.vo.MyGameReview;
import kh.semi.boardclass.mypage.model.vo.UserMyUsed;
import kh.semi.boardclass.review.model.vo.Review;
import kh.semi.boardclass.used.model.vo.Used;
import kh.semi.boardclass.used.model.vo.UsedLike;

//import kh.semi.boardclass.mypage.model.dao.Board;
//import kh.semi.boardclass.mypage.model.dao.BoardLike;
//import kh.semi.boardclass.mypage.model.dao.Boardgame;
//import kh.semi.boardclass.mypage.model.dao.Comment;
//import kh.semi.boardclass.mypage.model.dao.Review;
//import kh.semi.boardclass.mypage.model.dao.Used;
//import kh.semi.boardclass.mypage.model.dao.UsedLike;

public class MyPageService {

	public MyPageService() {
		// TODO Auto-generated constructor stub
	}

	public int countMyBoardGame() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new MyPageDao().countMyBoardGame(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public int countMyTrade() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new MyPageDao().countMyTrade(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public int countLikeTrade() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new MyPageDao().countLikeTrade(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public int countMyCommunity() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new MyPageDao().countMyCommunity(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public int countMyComment() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new MyPageDao().countMyComment(conn);
		JDBCTemplate.close(conn);
		return result;
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

	public ArrayList<Board> myCommunityList(Board board) {
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MyPageDao().myCommunityList(conn, board);
		JDBCTemplate.close(conn);
		return volist;
	}

	public ArrayList<Board> myCommunityDetail(Board board) {
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MyPageDao().myCommunityDetail(conn, board);
		JDBCTemplate.close(conn);
		return volist;
	}

	public ArrayList<Comment> myCommentList(Comment comment) {
		ArrayList<Comment> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MyPageDao().myCommentList(conn, comment);
		JDBCTemplate.close(conn);
		return volist;
	}

	public ArrayList<Comment> myCommentDetail(Comment comment) {
		ArrayList<Comment> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MyPageDao().myCommentDetail(conn, comment);
		JDBCTemplate.close(conn);
		return volist;
	}

}
