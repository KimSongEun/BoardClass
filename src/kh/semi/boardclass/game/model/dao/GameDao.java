package kh.semi.boardclass.game.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.game.model.vo.Game;
import kh.semi.boardclass.game.model.vo.GameLike;
import kh.semi.boardclass.game.model.vo.GameReview;
import kh.semi.boardclass.used.model.vo.Used;

public class GameDao {

	public GameDao() {
		// TODO Auto-generated constructor stub
	}

	public int getListCount(Connection conn) {
		int result = 0;
		return result;
	}

	public Game InfoGame(Connection conn, String name) {
		Game vo = null;
		String sql = "select * from BOARDGAME where GAME_KONAME = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name );
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				vo = new Game();

				vo.setGameNumber(rset.getInt("GAME_NO"));
				vo.setUsedNum(rset.getInt("USED_NO"));
				vo.setGameKoName(rset.getString("GAME_KONAME"));
				vo.setGameEnName(rset.getString("GAME_ENNAME"));
				vo.setGameCategory(rset.getString("GAME_CATEGORY"));
				vo.setGameView(rset.getInt("GAME_VIEW"));
				vo.setGameAge(rset.getString("GAME_AGE"));
				vo.setGamePlayer(rset.getString("GAME_PLAYER"));
				vo.setGameTime(rset.getString("GAME_TIME"));
				vo.setGamePrice(rset.getInt("GAME_PRICE"));
				vo.setGameGrade(rset.getInt("GAME_GRADE"));
				vo.setGameDate(rset.getDate("GAME_DATE"));
				vo.setGameLevel(rset.getInt("GAME_LEVEL"));
				vo.setGameDesigner(rset.getString("GAME_DESIGNER"));
				vo.setGameWriter(rset.getString("GAME_WRITER"));
				vo.setGameBrand(rset.getString("GAME_BRAND"));
				vo.setGameReleaseDate(rset.getString("GAME_RELEASEDATE"));
				vo.setGameRank(rset.getInt("GAME_RANK"));
				vo.setGameLanguage(rset.getString("GAME_LANGUAGE"));
				vo.setGameReview(rset.getString("GAME_REVIEW"));
				vo.setGameImage(rset.getString("GAME_IMAGE"));
				vo.setGameRuleImage(rset.getString("GAME_RULE_IMAGE"));
				vo.setGameVideo(rset.getString("GAME_VIDEO"));
				vo.setGamePlus(rset.getString("GAME_PLUS"));
				vo.setGamePlusImage(rset.getString("Game_PLUSIMAGE"));

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return vo;
	}
	public ArrayList<GameReview> selectReview(Connection conn, int start, int end, int no) {
		ArrayList<GameReview> volist = null;
		String sql = "select * from REVIEW where Rownum between ? and ? and GAME_NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			pstmt.setInt(3, no);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				volist = new ArrayList<GameReview>();
				do {
					GameReview vo = new GameReview();

					vo.setReviewNo(rset.getInt("REVIEW_NO"));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setGameNo(rset.getInt("GAME_NO"));
					vo.setReviewContent(rset.getString("REVIEW_CONTENT"));
					vo.setReviewScore(rset.getInt("REVIEW_SCORE"));
					vo.setReviewDate(rset.getDate("REVIEW_DATE"));
					
					volist.add(vo);
				} while (rset.next());
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}
	
	public ArrayList<Game> selectGame(Connection conn, String name) {
		ArrayList<Game> volist = null;
		String sql = "select * from BOARDGAME where GAME_KONAME like ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "'%" + name + "%'");
			rset = pstmt.executeQuery();
			if (rset.next()) {
				volist = new ArrayList<Game>();
				do {
					Game vo = new Game();
					vo.setGameNumber(rset.getInt("GAME_NO"));
					vo.setUsedNum(rset.getInt("USED_NO"));
					vo.setGameKoName(rset.getString("GAME_KONAME"));
					vo.setGameEnName(rset.getString("GAME_ENNAME"));
					vo.setGameCategory(rset.getString("GAME_CATEGORY"));
					vo.setGameView(rset.getInt("GAME_VIEW"));
					vo.setGameAge(rset.getString("GAME_AGE"));
					vo.setGamePlayer(rset.getString("GAME_PLAYER"));
					vo.setGameTime(rset.getString("GAME_TIME"));
					vo.setGamePrice(rset.getInt("GAME_PRICE"));
					vo.setGameGrade(rset.getInt("GAME_GRADE"));
					vo.setGameDate(rset.getDate("GAME_DATE"));
					vo.setGameLevel(rset.getInt("GAME_LEVEL"));
					vo.setGameDesigner(rset.getString("GAME_DESIGNER"));
					vo.setGameWriter(rset.getString("GAME_WRITER"));
					vo.setGameBrand(rset.getString("GAME_BRAND"));
					vo.setGameReleaseDate(rset.getString("GAME_RELEASEDATE"));
					vo.setGameRank(rset.getInt("GAME_RANK"));
					vo.setGameLanguage(rset.getString("GAME_LANGUAGE"));
					vo.setGameReview(rset.getString("GAME_REVIEW"));
					vo.setGameImage(rset.getString("GAME_IMAGE"));
					vo.setGameRuleImage(rset.getString("GAME_RULE_IMAGE"));
					vo.setGameVideo(rset.getString("GAME_VIDEO"));
					vo.setGamePlus(rset.getString("GAME_PLUS"));
					vo.setGamePlusImage(rset.getString("Game_PLUSIMAGE"));

					volist.add(vo);

				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;

	}

	public int getListCounterFilter(Connection conn) {
		int result = 0;
		return result;
	}

	public int getGameCount(Connection conn) {
		int result = 0;
		String sql = "select count(GAME_NO) from BOARDGAME";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
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

	public ArrayList<Game> selectCateGameList(Connection conn, int start, int end, String cate) {

		ArrayList<Game> volist = null;

		String sql = "select * from BOARDGAME where Rownum between ? and ? and GAME_CATEGORY like ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			pstmt.setString(3, "%" + cate + "%");

			rset = pstmt.executeQuery();
			if (rset.next()) {
				volist = new ArrayList<Game>();
				do {
					Game vo = new Game();
					vo.setGameNumber(rset.getInt("GAME_NO"));
					vo.setUsedNum(rset.getInt("USED_NO"));
					vo.setGameKoName(rset.getString("GAME_KONAME"));
					vo.setGameEnName(rset.getString("GAME_ENNAME"));
					vo.setGameCategory(rset.getString("GAME_CATEGORY"));
					vo.setGameView(rset.getInt("GAME_VIEW"));
					vo.setGameAge(rset.getString("GAME_AGE"));
					vo.setGamePlayer(rset.getString("GAME_PLAYER"));
					vo.setGameTime(rset.getString("GAME_TIME"));
					vo.setGamePrice(rset.getInt("GAME_PRICE"));
					vo.setGameGrade(rset.getInt("GAME_GRADE"));
					vo.setGameDate(rset.getDate("GAME_DATE"));
					vo.setGameLevel(rset.getInt("GAME_LEVEL"));
					vo.setGameDesigner(rset.getString("GAME_DESIGNER"));
					vo.setGameWriter(rset.getString("GAME_WRITER"));
					vo.setGameBrand(rset.getString("GAME_BRAND"));
					vo.setGameReleaseDate(rset.getString("GAME_RELEASEDATE"));
					vo.setGameRank(rset.getInt("GAME_RANK"));
					vo.setGameLanguage(rset.getString("GAME_LANGUAGE"));
					vo.setGameReview(rset.getString("GAME_REVIEW"));
					vo.setGameImage(rset.getString("GAME_IMAGE"));
					vo.setGameRuleImage(rset.getString("GAME_RULE_IMAGE"));
					vo.setGameVideo(rset.getString("GAME_VIDEO"));
					vo.setGamePlus(rset.getString("GAME_PLUS"));
					vo.setGamePlusImage(rset.getString("Game_PLUSIMAGE"));

					volist.add(vo);

				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}

	public ArrayList<Game> selectLevelGameList(Connection conn, int start, int end) {

		ArrayList<Game> volist = null;

		String sql = "select * from " + " (select Rownum r, t1.* from "
				+ " (select * from BOARDGAME order by GAME_LEVEL asc) t1 ) t2 " + " where r between ? and ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				volist = new ArrayList<Game>();
				do {
					Game vo = new Game();
					vo.setGameNumber(rset.getInt("GAME_NO"));
					vo.setUsedNum(rset.getInt("USED_NO"));
					vo.setGameKoName(rset.getString("GAME_KONAME"));
					vo.setGameEnName(rset.getString("GAME_ENNAME"));
					vo.setGameCategory(rset.getString("GAME_CATEGORY"));
					vo.setGameView(rset.getInt("GAME_VIEW"));
					vo.setGameAge(rset.getString("GAME_AGE"));
					vo.setGamePlayer(rset.getString("GAME_PLAYER"));
					vo.setGameTime(rset.getString("GAME_TIME"));
					vo.setGamePrice(rset.getInt("GAME_PRICE"));
					vo.setGameGrade(rset.getInt("GAME_GRADE"));
					vo.setGameDate(rset.getDate("GAME_DATE"));
					vo.setGameLevel(rset.getInt("GAME_LEVEL"));
					vo.setGameDesigner(rset.getString("GAME_DESIGNER"));
					vo.setGameWriter(rset.getString("GAME_WRITER"));
					vo.setGameBrand(rset.getString("GAME_BRAND"));
					vo.setGameReleaseDate(rset.getString("GAME_RELEASEDATE"));
					vo.setGameRank(rset.getInt("GAME_RANK"));
					vo.setGameLanguage(rset.getString("GAME_LANGUAGE"));
					vo.setGameReview(rset.getString("GAME_REVIEW"));
					vo.setGameImage(rset.getString("GAME_IMAGE"));
					vo.setGameRuleImage(rset.getString("GAME_RULE_IMAGE"));
					vo.setGameVideo(rset.getString("GAME_VIDEO"));
					vo.setGamePlus(rset.getString("GAME_PLUS"));
					vo.setGamePlusImage(rset.getString("Game_PLUSIMAGE"));

					volist.add(vo);

				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}

	public ArrayList<Game> selectGradeGameList(Connection conn, int start, int end) {

		ArrayList<Game> volist = null;
		String sql = "select * from " + " (select Rownum r, t1.* from "
				+ " (select * from BOARDGAME order by GAME_GRADE asc) t1 ) t2 " + " where r between ? and ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				volist = new ArrayList<Game>();
				do {
					Game vo = new Game();
					vo.setGameNumber(rset.getInt("GAME_NO"));
					vo.setUsedNum(rset.getInt("USED_NO"));
					vo.setGameKoName(rset.getString("GAME_KONAME"));
					vo.setGameEnName(rset.getString("GAME_ENNAME"));
					vo.setGameCategory(rset.getString("GAME_CATEGORY"));
					vo.setGameView(rset.getInt("GAME_VIEW"));
					vo.setGameAge(rset.getString("GAME_AGE"));
					vo.setGamePlayer(rset.getString("GAME_PLAYER"));
					vo.setGameTime(rset.getString("GAME_TIME"));
					vo.setGamePrice(rset.getInt("GAME_PRICE"));
					vo.setGameGrade(rset.getInt("GAME_GRADE"));
					vo.setGameDate(rset.getDate("GAME_DATE"));
					vo.setGameLevel(rset.getInt("GAME_LEVEL"));
					vo.setGameDesigner(rset.getString("GAME_DESIGNER"));
					vo.setGameWriter(rset.getString("GAME_WRITER"));
					vo.setGameBrand(rset.getString("GAME_BRAND"));
					vo.setGameReleaseDate(rset.getString("GAME_RELEASEDATE"));
					vo.setGameRank(rset.getInt("GAME_RANK"));
					vo.setGameLanguage(rset.getString("GAME_LANGUAGE"));
					vo.setGameReview(rset.getString("GAME_REVIEW"));
					vo.setGameImage(rset.getString("GAME_IMAGE"));
					vo.setGameRuleImage(rset.getString("GAME_RULE_IMAGE"));
					vo.setGameVideo(rset.getString("GAME_VIDEO"));
					vo.setGamePlus(rset.getString("GAME_PLUS"));
					vo.setGamePlusImage(rset.getString("Game_PLUSIMAGE"));

					volist.add(vo);

				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}

	public ArrayList<Game> selectGradeDescGameList(Connection conn, int start, int end) {

		ArrayList<Game> volist = null;
		String sql = "select * from " + " (select Rownum r, t1.* from "
				+ " (select * from BOARDGAME order by GAME_GRADE desc) t1 ) t2 " + " where r between ? and ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				volist = new ArrayList<Game>();
				do {
					Game vo = new Game();
					vo.setGameNumber(rset.getInt("GAME_NO"));
					vo.setUsedNum(rset.getInt("USED_NO"));
					vo.setGameKoName(rset.getString("GAME_KONAME"));
					vo.setGameEnName(rset.getString("GAME_ENNAME"));
					vo.setGameCategory(rset.getString("GAME_CATEGORY"));
					vo.setGameView(rset.getInt("GAME_VIEW"));
					vo.setGameAge(rset.getString("GAME_AGE"));
					vo.setGamePlayer(rset.getString("GAME_PLAYER"));
					vo.setGameTime(rset.getString("GAME_TIME"));
					vo.setGamePrice(rset.getInt("GAME_PRICE"));
					vo.setGameGrade(rset.getInt("GAME_GRADE"));
					vo.setGameDate(rset.getDate("GAME_DATE"));
					vo.setGameLevel(rset.getInt("GAME_LEVEL"));
					vo.setGameDesigner(rset.getString("GAME_DESIGNER"));
					vo.setGameWriter(rset.getString("GAME_WRITER"));
					vo.setGameBrand(rset.getString("GAME_BRAND"));
					vo.setGameReleaseDate(rset.getString("GAME_RELEASEDATE"));
					vo.setGameRank(rset.getInt("GAME_RANK"));
					vo.setGameLanguage(rset.getString("GAME_LANGUAGE"));
					vo.setGameReview(rset.getString("GAME_REVIEW"));
					vo.setGameImage(rset.getString("GAME_IMAGE"));
					vo.setGameRuleImage(rset.getString("GAME_RULE_IMAGE"));
					vo.setGameVideo(rset.getString("GAME_VIDEO"));
					vo.setGamePlus(rset.getString("GAME_PLUS"));
					vo.setGamePlusImage(rset.getString("Game_PLUSIMAGE"));

					volist.add(vo);

				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}

	public ArrayList<Game> selectSortGameList(Connection conn, int start, int end) {

		ArrayList<Game> volist = null;
		String sql = "select * from " + " (select Rownum r, t1.* from "
				+ " (select * from BOARDGAME order by GAME_KONAME asc) t1 ) t2 " + " where r between ? and ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				volist = new ArrayList<Game>();
				do {
					Game vo = new Game();
					vo.setGameNumber(rset.getInt("GAME_NO"));
					vo.setUsedNum(rset.getInt("USED_NO"));
					vo.setGameKoName(rset.getString("GAME_KONAME"));
					vo.setGameEnName(rset.getString("GAME_ENNAME"));
					vo.setGameCategory(rset.getString("GAME_CATEGORY"));
					vo.setGameView(rset.getInt("GAME_VIEW"));
					vo.setGameAge(rset.getString("GAME_AGE"));
					vo.setGamePlayer(rset.getString("GAME_PLAYER"));
					vo.setGameTime(rset.getString("GAME_TIME"));
					vo.setGamePrice(rset.getInt("GAME_PRICE"));
					vo.setGameGrade(rset.getInt("GAME_GRADE"));
					vo.setGameDate(rset.getDate("GAME_DATE"));
					vo.setGameLevel(rset.getInt("GAME_LEVEL"));
					vo.setGameDesigner(rset.getString("GAME_DESIGNER"));
					vo.setGameWriter(rset.getString("GAME_WRITER"));
					vo.setGameBrand(rset.getString("GAME_BRAND"));
					vo.setGameReleaseDate(rset.getString("GAME_RELEASEDATE"));
					vo.setGameRank(rset.getInt("GAME_RANK"));
					vo.setGameLanguage(rset.getString("GAME_LANGUAGE"));
					vo.setGameReview(rset.getString("GAME_REVIEW"));
					vo.setGameImage(rset.getString("GAME_IMAGE"));
					vo.setGameRuleImage(rset.getString("GAME_RULE_IMAGE"));
					vo.setGameVideo(rset.getString("GAME_VIDEO"));
					vo.setGamePlus(rset.getString("GAME_PLUS"));
					vo.setGamePlusImage(rset.getString("Game_PLUSIMAGE"));

					volist.add(vo);

				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}

	public ArrayList<Game> selectGradeRankList(Connection conn, int start, int end) {

		ArrayList<Game> volist = null;

		String sql = "select * from " + " (select Rownum r, t1.* from "
				+ " (select * from BOARDGAME order by GAME_GRADE asc) t1 ) t2 " + " where r between ? and ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			// pstmt.setString(3, grade);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				volist = new ArrayList<Game>();
				do {
					Game vo = new Game();
					vo.setGameNumber(rset.getInt("GAME_NO"));
					vo.setUsedNum(rset.getInt("USED_NO"));
					vo.setGameKoName(rset.getString("GAME_KONAME"));
					vo.setGameEnName(rset.getString("GAME_ENNAME"));
					vo.setGameCategory(rset.getString("GAME_CATEGORY"));
					vo.setGameView(rset.getInt("GAME_VIEW"));
					vo.setGameAge(rset.getString("GAME_AGE"));
					vo.setGamePlayer(rset.getString("GAME_PLAYER"));
					vo.setGameTime(rset.getString("GAME_TIME"));
					vo.setGamePrice(rset.getInt("GAME_PRICE"));
					vo.setGameGrade(rset.getInt("GAME_GRADE"));
					vo.setGameDate(rset.getDate("GAME_DATE"));
					vo.setGameLevel(rset.getInt("GAME_LEVEL"));
					vo.setGameDesigner(rset.getString("GAME_DESIGNER"));
					vo.setGameWriter(rset.getString("GAME_WRITER"));
					vo.setGameBrand(rset.getString("GAME_BRAND"));
					vo.setGameReleaseDate(rset.getString("GAME_RELEASEDATE"));
					vo.setGameRank(rset.getInt("GAME_RANK"));
					vo.setGameLanguage(rset.getString("GAME_LANGUAGE"));
					vo.setGameReview(rset.getString("GAME_REVIEW"));
					vo.setGameImage(rset.getString("GAME_IMAGE"));
					vo.setGameRuleImage(rset.getString("GAME_RULE_IMAGE"));
					vo.setGameVideo(rset.getString("GAME_VIDEO"));
					vo.setGamePlus(rset.getString("GAME_PLUS"));
					vo.setGamePlusImage(rset.getString("Game_PLUSIMAGE"));

					volist.add(vo);

				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}

	public ArrayList<Game> selectViewRankList(Connection conn, int start, int end) {

		ArrayList<Game> volist = null;

		String sql = "select * from " + " (select Rownum r, t1.* from "
				+ " (select * from BOARDGAME order by GAME_GRADE asc) t1 ) t2 " + " where r between ? and ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			// pstmt.setString(3, grade);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				volist = new ArrayList<Game>();
				do {
					Game vo = new Game();
					vo.setGameNumber(rset.getInt("GAME_NO"));
					vo.setUsedNum(rset.getInt("USED_NO"));
					vo.setGameKoName(rset.getString("GAME_KONAME"));
					vo.setGameEnName(rset.getString("GAME_ENNAME"));
					vo.setGameCategory(rset.getString("GAME_CATEGORY"));
					vo.setGameView(rset.getInt("GAME_VIEW"));
					vo.setGameAge(rset.getString("GAME_AGE"));
					vo.setGamePlayer(rset.getString("GAME_PLAYER"));
					vo.setGameTime(rset.getString("GAME_TIME"));
					vo.setGamePrice(rset.getInt("GAME_PRICE"));
					vo.setGameGrade(rset.getInt("GAME_GRADE"));
					vo.setGameDate(rset.getDate("GAME_DATE"));
					vo.setGameLevel(rset.getInt("GAME_LEVEL"));
					vo.setGameDesigner(rset.getString("GAME_DESIGNER"));
					vo.setGameWriter(rset.getString("GAME_WRITER"));
					vo.setGameBrand(rset.getString("GAME_BRAND"));
					vo.setGameReleaseDate(rset.getString("GAME_RELEASEDATE"));
					vo.setGameRank(rset.getInt("GAME_RANK"));
					vo.setGameLanguage(rset.getString("GAME_LANGUAGE"));
					vo.setGameReview(rset.getString("GAME_REVIEW"));
					vo.setGameImage(rset.getString("GAME_IMAGE"));
					vo.setGameRuleImage(rset.getString("GAME_RULE_IMAGE"));
					vo.setGameVideo(rset.getString("GAME_VIDEO"));
					vo.setGamePlus(rset.getString("GAME_PLUS"));
					vo.setGamePlusImage(rset.getString("Game_PLUSIMAGE"));

					volist.add(vo);

				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}

	public ArrayList<Game> selectJjimRankList(Connection conn, int start, int end) {

		ArrayList<Game> volist = null;

		String sql = "select * from " + " (select Rownum r, t1.* from "
				+ " (select * from BOARDGAME order by GAME_GRADE asc) t1 ) t2 " + " where r between ? and ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			// pstmt.setString(3, grade);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				volist = new ArrayList<Game>();
				do {
					Game vo = new Game();
					vo.setGameNumber(rset.getInt("GAME_NO"));
					vo.setUsedNum(rset.getInt("USED_NO"));
					vo.setGameKoName(rset.getString("GAME_KONAME"));
					vo.setGameEnName(rset.getString("GAME_ENNAME"));
					vo.setGameCategory(rset.getString("GAME_CATEGORY"));
					vo.setGameView(rset.getInt("GAME_VIEW"));
					vo.setGameAge(rset.getString("GAME_AGE"));
					vo.setGamePlayer(rset.getString("GAME_PLAYER"));
					vo.setGameTime(rset.getString("GAME_TIME"));
					vo.setGamePrice(rset.getInt("GAME_PRICE"));
					vo.setGameGrade(rset.getInt("GAME_GRADE"));
					vo.setGameDate(rset.getDate("GAME_DATE"));
					vo.setGameLevel(rset.getInt("GAME_LEVEL"));
					vo.setGameDesigner(rset.getString("GAME_DESIGNER"));
					vo.setGameWriter(rset.getString("GAME_WRITER"));
					vo.setGameBrand(rset.getString("GAME_BRAND"));
					vo.setGameReleaseDate(rset.getString("GAME_RELEASEDATE"));
					vo.setGameRank(rset.getInt("GAME_RANK"));
					vo.setGameLanguage(rset.getString("GAME_LANGUAGE"));
					vo.setGameReview(rset.getString("GAME_REVIEW"));
					vo.setGameImage(rset.getString("GAME_IMAGE"));
					vo.setGameRuleImage(rset.getString("GAME_RULE_IMAGE"));
					vo.setGameVideo(rset.getString("GAME_VIDEO"));
					vo.setGamePlus(rset.getString("GAME_PLUS"));
					vo.setGamePlusImage(rset.getString("Game_PLUSIMAGE"));

					volist.add(vo);

				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}
	
	public ArrayList<Used> usedlist(Connection conn, String name) {
		ArrayList<Used> volist = null;
		String sql = "select USED_TITLE, USED_IMG from USED where USED_KEYWORD = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name );
			rset = pstmt.executeQuery();
			if (rset.next()) {
				volist = new ArrayList<Used>();
				do {
					Used vo = new Used();
					vo.setUsedTitle(rset.getString("USED_TITLE"));
					vo.setUsedImg(rset.getString("USED_IMG"));
					
					volist.add(vo);

				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;

	}
	public int insertReview(Connection conn, GameReview vo) {
		int result = 0;
		String sql = "INSERT INTO REVIEW VALUES (REVIEW_NUM.nextval, ?, ?, ?, ?, sysdate)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getUserId());
			pstmt.setInt(2, vo.getGameNo());
			pstmt.setString(3,vo.getReviewContent());
			pstmt.setInt(4, vo.getReviewScore());
		
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateGrade(Connection conn, int gameno){
		int result = 0;
		String sql = "update BOARDGAME set GAME_GRADE = (select round(avg(REVIEW_SCORE)) from REVIEW where GAME_NO = ?) where GAME_NO = ?";
		PreparedStatement pstmt = null;
		System.out.println("yoo1 "+gameno);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gameno);
			pstmt.setInt(2, gameno);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void updateUsed(Connection conn, Used used) {

	}

	public int chatUset(Connection conn, Used used) {
		int result = 0;
		return result;
	}

	public int addViewCount(Connection conn) {
		int result = 0;
		return result;
	}

	public int insertGameLike(Connection conn, GameLike gameLike) {
		int result = 0;
		return result;
	}

	public ArrayList<Game> selectGameRank(Connection conn) {
		ArrayList<Game> volist = null;
		return volist;
	}

	public ArrayList<Game> searchFilterGameRank(Connection conn, String gameCategory, String gameAge, String gamePlayer,
			int gameTime, int gamePrice) {
		ArrayList<Game> volist = null;
		return volist;
	}
	
	public List<Game> searchList(Connection conn, String searchKeyword) {
		List<Game> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from BOARDGAME where GAME_KONAME like ? or GAME_ENNAME like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			searchKeyword = "%" + searchKeyword + "%";
			pstmt.setString(1, searchKeyword);
			pstmt.setString(2, searchKeyword);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				volist = new ArrayList<Game>();
				do {
					Game vo = new Game();

					vo.setGameNumber(rset.getInt("GAME_NO"));
					vo.setUsedNum(rset.getInt("USED_NO"));
					vo.setGameKoName(rset.getString("GAME_KONAME"));
					vo.setGameEnName(rset.getString("GAME_ENNAME"));
					vo.setGameCategory(rset.getString("GAME_CATEGORY"));
					vo.setGameView(rset.getInt("GAME_VIEW"));
					vo.setGameAge(rset.getString("GAME_AGE"));
					vo.setGamePlayer(rset.getString("GAME_PLAYER"));
					vo.setGameTime(rset.getString("GAME_TIME"));
					vo.setGamePrice(rset.getInt("GAME_PRICE"));
					vo.setGameGrade(rset.getInt("GAME_GRADE"));
					vo.setGameDate(rset.getDate("GAME_DATE"));
					vo.setGameLevel(rset.getInt("GAME_LEVEL"));
					vo.setGameDesigner(rset.getString("GAME_DESIGNER"));
					vo.setGameWriter(rset.getString("GAME_WRITER"));
					vo.setGameBrand(rset.getString("GAME_BRAND"));
					vo.setGameReleaseDate(rset.getString("GAME_RELEASEDATE"));
					vo.setGameRank(rset.getInt("GAME_RANK"));
					vo.setGameLanguage(rset.getString("GAME_LANGUAGE"));
					vo.setGameReview(rset.getString("GAME_REVIEW"));
					vo.setGameImage(rset.getString("GAME_IMAGE"));
					vo.setGameRuleImage(rset.getString("GAME_RULE_IMAGE"));
					vo.setGameVideo(rset.getString("GAME_VIDEO"));
					vo.setGamePlus(rset.getString("GAME_PLUS"));
					vo.setGamePlusImage(rset.getString("Game_PLUSIMAGE"));

					volist.add(vo);

				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}

	public int matchList(Connection conn, String matchKeyword) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "SELECT COUNT(*) FROM BOARDGAME WHERE GAME_KONAME like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, matchKeyword);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			} else {
				result = rset.getInt(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
