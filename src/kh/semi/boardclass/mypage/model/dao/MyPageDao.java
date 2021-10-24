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
import kh.semi.boardclass.mypage.model.vo.MyGameReview;
import kh.semi.boardclass.mypage.model.vo.UserMyComt;
import kh.semi.boardclass.mypage.model.vo.UserMyUsed;
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
		String sql = "select * from ( select Rownum r, t1.* from (\r\n"
				+ "SELECT B.GAME_NO, L.BOARDGAME_LIKE_NO,B.GAME_CATEGORY, B.GAME_KONAME, L.USER_ID, B.GAME_GRADE, B.GAME_IMAGE\r\n"
				+ "FROM BOARDGAME_LIKE L JOIN BOARDGAME B ON L.GAME_NO = B.GAME_NO where L.USER_ID = ? \r\n"
				+ "GROUP BY B.GAME_NO, L.BOARDGAME_LIKE_NO,B.GAME_CATEGORY, B.GAME_KONAME, L.USER_ID, B.GAME_GRADE, B.GAME_IMAGE \r\n"
				+ "ORDER BY BOARDGAME_LIKE_NO DESC) t1) t2 where r between ? and ?";
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

	// 보드게임 리뷰 리스트
	public int getMyBoardGameReviewCount(Connection conn, String userId) {
		int result = 0;
		String sql = "Select count(*) from REVIEW where user_Id =? ";
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

	public ArrayList<MyGameReview> myBoardGameReviewList(Connection conn, String userId, int start, int end) {
		ArrayList<MyGameReview> volist = null;
		String sql = "select * from ( select Rownum r, t1.* from (\r\n"
				+ "SELECT B.GAME_NO, V.REVIEW_NO,V.REVIEW_SCORE, B.GAME_CATEGORY, B.GAME_KONAME, V.USER_ID,B.GAME_IMAGE\r\n"
				+ "FROM REVIEW V JOIN BOARDGAME B ON V.GAME_NO = B.GAME_NO where V.USER_ID = ? \r\n"
				+ "GROUP BY   B.GAME_NO, V.REVIEW_NO,V.REVIEW_SCORE, B.GAME_CATEGORY, B.GAME_KONAME, V.USER_ID,B.GAME_IMAGE\r\n"
				+ "ORDER BY REVIEW_NO DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<MyGameReview>();
			while (rset.next()) {
				MyGameReview vo = new MyGameReview();
				vo.setReviewNo(rset.getInt("REVIEW_NO"));
				vo.setGameNumber(rset.getInt("GAME_NO"));
				vo.setGameKoName(rset.getString("GAME_KONAME"));
				vo.setGameCategory(rset.getString("GAME_CATEGORY"));
				vo.setUserId(rset.getString("USER_ID"));
				vo.setReviewScore(rset.getInt("REVIEW_SCORE"));
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

// 중고거래 작성글 
	public int getMyTradeListCount(Connection conn, String userId) {
		int result = 0;
		String sql = "Select count(*) from used where user_Id = ?";
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

	public ArrayList<Used> myTradeList(Connection conn, String userId, int start, int end) {
		ArrayList<Used> volist = null;
		String sql = "select * from(select rownum rnum, B.* from( SELECT * FROM used B where USER_ID =? order by USED_NO desc) B) where rnum between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Used>();
			while (rset.next()) {
				Used vo = new Used();
				vo.setUsedNo(rset.getInt("USED_NO"));
				vo.setUserId(rset.getString("USER_ID"));
				vo.setUsedTitle(rset.getString("USED_TITLE"));
				vo.setUsedPrice(rset.getInt("USED_PRICE"));
				vo.setUsedDay(rset.getString("USED_DAY"));
				vo.setUsedCategory(rset.getString("USED_CATEGORY"));
				vo.setUsedImg(rset.getString("USED_IMG"));
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

// 중고거래 찜 
	public int getMyLikeTradeListCount(Connection conn, String userId) {
		int result = 0;
		String sql = "Select count(*) from USED_LIKE where user_Id = ?";
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

	public ArrayList<UserMyUsed> myLikeTradeList(Connection conn, String userId, int start, int end) {
		ArrayList<UserMyUsed> volist = null;
		String sql = "select * from ( select Rownum r, t1.* from (SELECT U.USED_NO, L.USED_LIKE_NO, U.USED_CATEGORY, U.USED_TITLE, U.USER_ID, U.USED_PRICE,U.USED_IMG FROM USED_LIKE L JOIN USED U ON L.USED_NO = U.USED_NO where U.USER_ID = ? GROUP BY U.USED_NO, L.USED_LIKE_NO, U.USED_CATEGORY, U.USED_TITLE, U.USER_ID, U.USED_PRICE,U.USED_IMG ORDER BY USED_LIKE_NO DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<UserMyUsed>();
			while (rset.next()) {
				UserMyUsed vo = new UserMyUsed();
				vo.setUsedNo(rset.getInt("USED_NO"));
				vo.setUserId(rset.getString("USER_ID"));
				vo.setUsedTitle(rset.getString("USED_TITLE"));
				vo.setUsedPrice(rset.getInt("USED_PRICE"));
				vo.setUsedCategory(rset.getString("USED_CATEGORY"));
				vo.setUsedImg(rset.getString("USED_IMG"));
				vo.setUsedLikeNo(rset.getInt("USED_LIKE_NO"));
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

// 커뮤니티 작성글 
	public int getMyBoardCount(Connection conn, String userId) {
		int result = 0;
		String sql = "Select count(*) from BOARD where user_Id = ?";
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

	public ArrayList<Board> myBoardList(Connection conn, String userId, int start, int end) {
		ArrayList<Board> volist = null;
		String sql = "select * from(select rownum rnum, B.* from( select * from board B where USER_ID = ? order by BOARD_NO desc) B) where rnum between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Board>();
			while (rset.next()) {
				Board vo = new Board();
				vo.setBoardNo(rset.getInt("BOARD_NO"));
				vo.setUserId(rset.getString("USER_ID"));
				vo.setBoardCategory(rset.getString("BOARD_CATEGORY"));
				vo.setBoardTitle(rset.getString("BOARD_TITLE"));
				vo.setBoardContent(rset.getString("BOARD_CONTENT"));
				vo.setBoardWriteDate(rset.getString("BOARD_WRITE_DATE"));
				vo.setBoardViewCount(rset.getInt("BOARD_VIEW_COUNT"));
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

// 커뮤니티 댓글 
	public int getMyBoardComtCount(Connection conn, String userId) {
		int result = 0;
		String sql = "Select count(*) from COMT where user_Id = ?";
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

	public ArrayList<UserMyComt> myBoardCommentList(Connection conn, String userId, int start, int end) {
		ArrayList<UserMyComt> volist = null;
		String sql = "select * from ( select Rownum r, t1.* from (\r\n"
				+ "SELECT B.BOARD_NO,C.USER_ID,B.BOARD_TITLE,B.BOARD_CONTENT,B.BOARD_WRITE_DATE,B.BOARD_VIEW_COUNT,B.BOARD_CATEGORY, C.COMMENT_NO,C.COMMENT_CONTENT, C.COMMENT_WRITE_DATE, C.COMMENT_RE_LEVEL,C.COMMENT_REF,C.COMMENT_RE_STEP\r\n"
				+ "FROM COMT C JOIN BOARD B ON C.BOARD_NO = B.BOARD_NO where C.USER_ID = ? \r\n"
				+ "GROUP BY B.BOARD_NO,C.USER_ID,B.BOARD_TITLE,B.BOARD_CONTENT,B.BOARD_WRITE_DATE,B.BOARD_VIEW_COUNT,B.BOARD_CATEGORY, C.COMMENT_NO,C.COMMENT_CONTENT, C.COMMENT_WRITE_DATE, C.COMMENT_RE_LEVEL,C.COMMENT_REF,C.COMMENT_RE_STEP\r\n"
				+ "order by COMMENT_REF desc, COMMENT_RE_STEP asc) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<UserMyComt>();
			while (rset.next()) {

				UserMyComt vo = new UserMyComt();
				vo.setBoardNo(rset.getInt("BOARD_NO"));
				vo.setUserId(rset.getString("USER_ID"));
				vo.setBoardCategory(rset.getString("BOARD_CATEGORY"));
				vo.setBoardTitle(rset.getString("BOARD_TITLE"));
				vo.setBoardContent(rset.getString("BOARD_CONTENT"));
				vo.setBoardWriteDate(rset.getString("BOARD_WRITE_DATE"));
				vo.setBoardViewCount(rset.getInt("BOARD_VIEW_COUNT"));
				vo.setCommentNo(rset.getInt("COMMENT_NO"));
				vo.setCommentContent(rset.getString("COMMENT_CONTENT"));
				vo.setCommentWriteDate(rset.getString("COMMENT_WRITE_DATE"));
				vo.setCommentReLevel(rset.getInt("COMMENT_RE_LEVEL"));
				vo.setCommentReLevel(rset.getInt("COMMENT_RE_STEP"));
				vo.setCommentReLevel(rset.getInt("COMMENT_RE_LEVEL"));
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
}
