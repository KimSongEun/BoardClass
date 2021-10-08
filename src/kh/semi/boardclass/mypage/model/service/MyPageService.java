package kh.semi.boardclass.mypage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.community.model.vo.BoardLike;
import kh.semi.boardclass.community.model.vo.Comment;
import kh.semi.boardclass.game.model.vo.Game;
import kh.semi.boardclass.mypage.model.dao.MyPageDao;
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

	public ArrayList<BoardLike> myBoardGameList(BoardLike boardLike) {
		ArrayList<BoardLike> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MyPageDao().myBoardGameList(conn, boardLike);
		JDBCTemplate.close(conn);
		return volist;
	}

	public ArrayList<Game> myBoardGameListDetail(Game boardgame) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MyPageDao().myBoardGameListDetail(conn, boardgame);
		JDBCTemplate.close(conn);
		return volist;
	}

	public ArrayList<Review> myBoardGameReviewList(Review review) {
		ArrayList<Review> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MyPageDao().myBoardGameReviewList(conn, review);
		JDBCTemplate.close(conn);
		return volist;
	}

	public ArrayList<Review> myBoardGameReviewDetail(Review review) {
		ArrayList<Review> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MyPageDao().myBoardGameReviewDetail(conn, review);
		JDBCTemplate.close(conn);
		return volist;
	}

	public ArrayList<Used> myTradeList(Used used) {
		ArrayList<Used> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MyPageDao().myTradeList(conn, used);
		JDBCTemplate.close(conn);
		return volist;
	}

	public ArrayList<Used> myTradeListDetail(Used used) {
		ArrayList<Used> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MyPageDao().myTradeListDetail(conn, used);
		JDBCTemplate.close(conn);
		return volist;
	}

	public ArrayList<UsedLike> myLikeTradeList(UsedLike usedLike) {
		ArrayList<UsedLike> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MyPageDao().myLikeTradeList(conn, usedLike);
		JDBCTemplate.close(conn);
		return volist;
	}

	public ArrayList<Used> myLikeTradeListDetail(Used used) {
		ArrayList<Used> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new MyPageDao().myLikeTradeListDetail(conn, used);
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
