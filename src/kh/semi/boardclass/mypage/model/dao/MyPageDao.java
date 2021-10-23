package kh.semi.boardclass.mypage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.community.model.vo.BoardLike;
import kh.semi.boardclass.community.model.vo.Comment;
import kh.semi.boardclass.game.model.vo.Game;
import kh.semi.boardclass.mypage.model.vo.MyGameLike;
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
	
    // 보드게임 찜 리스트
	public int getMyBoardGameListCount(Connection conn, String userId) {
		int result = 0;
		String sql = "Select count(*) from BOARDGAME_LIKE where user_Id =? ";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public ArrayList<MyGameLike> myBoardGameList(Connection conn, String userId, int start, int end) {
		ArrayList<MyGameLike> volist = null;
		String sql = "select * from ( select Rownum r, t1.* from (\r\n" + 
				"SELECT B.GAME_NO, L.BOARDGAME_LIKE_NO,B.GAME_CATEGORY, B.GAME_KONAME, L.USER_ID, B.GAME_GRADE, B.GAME_IMAGE\r\n" + 
				"FROM BOARDGAME_LIKE L JOIN BOARDGAME B ON L.GAME_NO = B.GAME_NO where L.USER_ID = ? \r\n" + 
				"GROUP BY B.GAME_NO, L.BOARDGAME_LIKE_NO,B.GAME_CATEGORY, B.GAME_KONAME, L.USER_ID, B.GAME_GRADE, B.GAME_IMAGE \r\n" + 
				"ORDER BY BOARDGAME_LIKE_NO DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<MyGameLike>();
			
			while (rset.next()) {
				MyGameLike vo = new MyGameLike();
				vo.setBoardGameLikeNo(rset.getInt("BOARDGAME_LIKE_NO"));
				vo.setGameNumber(rset.getInt("GAME_NO"));
				vo.setGameKoName(rset.getString("GAME_KONAME"));
				vo.setGameCategory(rset.getString("GAME_CATEGORY"));
				vo.setUserId(rset.getString("USER_ID"));
				vo.setGameGrade(rset.getInt("GAME_GRADE"));			
				vo.setGameImage(rset.getString("GAME_IMAGE"));
				volist.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
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
