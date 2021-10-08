package kh.semi.boardclass.mypage.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.community.model.vo.BoardLike;
import kh.semi.boardclass.community.model.vo.Comment;
import kh.semi.boardclass.game.model.vo.Game;
import kh.semi.boardclass.review.model.vo.Review;
import kh.semi.boardclass.used.model.vo.Used;
import kh.semi.boardclass.used.model.vo.UsedLike;


public class MyPageDao {

	public MyPageDao() {
		// TODO Auto-generated constructor stub
	}

	public int countMyBoardGame(Connection conn) {
		int result = 0;
		return result;
	}

	public int countMyTrade(Connection conn) {
		int result = 0;
		return result;
	}

	public int countLikeTrade(Connection conn) {
		int result = 0;
		return result;
	}

	public int countMyCommunity(Connection conn) {
		int result = 0;
		return result;
	}

	public int countMyComment(Connection conn) {
		int result = 0;
		return result;
	}

	public ArrayList<BoardLike> myBoardGameList(Connection conn, BoardLike boardLike) {
		ArrayList<BoardLike> volist = null;
		return volist;
	}

	public ArrayList<Game> myBoardGameListDetail(Connection conn, Game boardgame) {
		ArrayList<Game> volist = null;
		return volist;
	}

	public ArrayList<Review> myBoardGameReviewList(Connection conn, Review review) {
		ArrayList<Review> volist = null;
		return volist;
	}

	public ArrayList<Review> myBoardGameReviewDetail(Connection conn, Review review) {
		ArrayList<Review> volist = null;
		return volist;
	}

	public ArrayList<Used> myTradeList(Connection conn, Used used) {
		ArrayList<Used> volist = null;
		return volist;
	}

	public ArrayList<Used> myTradeListDetail(Connection conn, Used used) {
		ArrayList<Used> volist = null;
		return volist;
	}

	public ArrayList<UsedLike> myLikeTradeList(Connection conn, UsedLike usedLike) {
		ArrayList<UsedLike> volist = null;
		return volist;
	}

	public ArrayList<Used> myLikeTradeListDetail(Connection conn, Used used) {
		ArrayList<Used> volist = null;
		return volist;
	}

	public ArrayList<Board> myCommunityList(Connection conn, Board board) {
		ArrayList<Board> volist = null;
		return volist;
	}

	public ArrayList<Board> myCommunityDetail(Connection conn, Board board) {
		ArrayList<Board> volist = null;
		return volist;
	}

	public ArrayList<Comment> myCommentList(Connection conn, Comment comment) {
		ArrayList<Comment> volist = null;
		return volist;
	}

	public ArrayList<Comment> myCommentDetail(Connection conn, Comment comment) {
		ArrayList<Comment> volist = null;
		return volist;
	}
}
