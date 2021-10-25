package kh.semi.boardclass.game.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.game.model.vo.Game;
import kh.semi.boardclass.game.model.vo.GameReview;
import kh.semi.boardclass.used.model.vo.Used;

public class GameDao {

	public GameDao() {
		// TODO Auto-generated constructor stub
	}

	public Game InfoGame(Connection conn, int no) {
		Game vo = null;
		String sql = "select * from BOARDGAME where GAME_NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no );
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
	
	public GameReview InfoReview(Connection conn, int no) {
		GameReview vo = null;
		String sql = "select * from REVIEW where REVIEW_NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				vo = new GameReview();

				vo.setReviewNo(rset.getInt("REVIEW_NO"));
				vo.setUserId(rset.getString("USER_ID"));
				vo.setGameNo(rset.getInt("GAME_NO"));
				vo.setReviewContent(rset.getString("REVIEW_CONTENT"));
				vo.setReviewScore(rset.getInt("REVIEW_SCORE"));
				vo.setReviewDate(rset.getDate("REVIEW_DATE"));

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return vo;
	}
	public ArrayList<GameReview> selectReview(Connection conn, int start, int end,  int no , String userId) {
		ArrayList<GameReview> volist = null;
//		String sql = "select * from (select rownum rnum, t1.* from (select * from REVIEW where GAME_NO = ? order by REVIEW_DATE desc) t1) t2 where rnum between ? and ?";
		String sql = "select t3.*, NVL(t4.liked,0) as liked, NVL(t5.likecount,0) as likecount from (select * from (select rownum rnum, t1.* from "
			    +"(select * from REVIEW where GAME_NO = ? order by REVIEW_DATE desc) t1) t2 where rnum between ? and ? ) t3 "
			    +"left outer join (select count(*) as liked, review_no from review_LIKE where user_id= ? and GAME_NO= ? group by review_no) t4 "
			    +"on t3.review_no=t4.review_no "
			    +"left outer join (select count(*) as likecount, review_no from review_like where GAME_NO = ? group by review_no) t5 "
			    +"on t3.review_no=t5.review_no";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			if(userId == null){
				userId="";
			}
			pstmt.setString(4, userId);   // 오류 날나면
			pstmt.setInt(5, no);
			pstmt.setInt(6, no);   
			
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
					vo.setLiked(rset.getInt("liked"));
					vo.setLikecount(rset.getInt("likecount"));
					
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
	public ArrayList<GameReview> selectHotReview(Connection conn, int start, int end,  int no, String userId) {
		ArrayList<GameReview> volist = null;
		String sql = "select t3.*, NVL(t4.liked,0) as liked, NVL(t5.likecount,0) as likecount from (select * from (select rownum rnum, t1.* from "
    + "(select * from REVIEW where GAME_NO = ? order by REVIEW_DATE desc) t1) t2 where rnum between ? and ? ) t3 "
    + "left outer join (select count(*) as liked, review_no from review_LIKE where user_id= ? and GAME_NO = ? group by review_no) t4 "
    + "on t3.review_no=t4.review_no "
    + "left outer join (select count(*) as likecount, review_no from review_like where GAME_NO = ? group by review_no) t5 "
    + "on t3.review_no=t5.review_no order by likecount desc";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			if(userId == null){
				userId="";
			}
			pstmt.setString(4, userId);   // 오류 날나면
			pstmt.setInt(5, no);
			pstmt.setInt(6, no);   
			
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
					vo.setLiked(rset.getInt("liked"));
					vo.setLikecount(rset.getInt("likecount"));
					
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
			String name1 = "%" + name + "%";
			pstmt.setString(1, name1);
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

	public int getGameCount(Connection conn, String cate) {
		int result = 0;
		String sql = "select count(GAME_NO) from BOARDGAME where GAME_CATEGORY like ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		cate = "%" + cate + "%";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  cate);
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
	
	public int getReviewCount(Connection conn, int gameno) {
		int result = 0;
		String sql = "select count(REVIEW_NO) from REVIEW where GAME_NO=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gameno);
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

	


	public ArrayList<Game> selectCateGameList(Connection conn, int start, int end, String cate, String search) {

		ArrayList<Game> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql1 = "select * from (select Rownum r, u.* from "
				+ "(select * from BOARDGAME where GAME_CATEGORY like ?) u) "
				+ " where r between ? and ?";
				
		String sql2 = "select * from (select Rownum r, u.* from "
				+ "(select * from BOARDGAME where GAME_CATEGORY like ? and GAME_KONAME like ? or GAME_ENNAME like ? or GAME_WRITER like ? or GAME_AGE like ? or GAME_PLAYER like ?) u) "
				+ " where r between ? and ?";
		
				
		System.out.println("abc"+cate);
		System.out.println("abcd"+search);
		
		try {
			if (search != null && !search.equals("")) {
				pstmt = conn.prepareStatement(sql2);
				cate = "%" + cate + "%";
				pstmt.setString(1, cate);
				search = "%" + search + "%";
				pstmt.setString(2, search);
				pstmt.setString(3, search);
				pstmt.setString(4, search);
				pstmt.setString(5, search);
				pstmt.setString(6, search);
				pstmt.setInt(7, start);
				pstmt.setInt(8, end);
				
			} else {
				pstmt = conn.prepareStatement(sql1);
				cate = "%" + cate + "%";
				pstmt.setString(1, cate);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}

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

	public ArrayList<Game> selectLevelGameList(Connection conn, int start, int end, String cate,String search) {

		ArrayList<Game> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql1 = "select * from " + " (select Rownum r, t1.* from "
				+ " (select * from BOARDGAME where GAME_CATEGORY like ? order by GAME_LEVEL asc) t1 ) t2 " + " where r between ? and ?";

		String sql2 = "select * from (select Rownum r, u.* from "
				+ "(select * from BOARDGAME where GAME_KONAME like ? order by GAME_LEVEL asc) u) "
				+ " where r between ? and ?";
		String sql = "";
		
		if (search != null && !search.equals("")) {
			sql = sql2;
		} else {
			sql = sql1;
		}
		
		System.out.println("abc"+cate);
		try {
			pstmt = conn.prepareStatement(sql);
			int idx = 0;
			if (search != null && !search.equals("")) {
				search = "%" + search + "%";
				pstmt.setString(++idx, search);
				
			}
			cate = "%" + cate + "%";
			pstmt.setString(++idx, cate);
			pstmt.setInt(++idx, start);
			pstmt.setInt(++idx, end);
			
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

	public ArrayList<Game> selectGradeGameList(Connection conn, int start, int end,String cate, String search) {

		ArrayList<Game> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql1 = "select * from " + " (select Rownum r, t1.* from "
				+ " (select * from BOARDGAME where GAME_CATEGORY like ? order by GAME_GRADE desc) t1 ) t2 " + " where r between ? and ?";

		String sql2 = "select * from (select Rownum r, u.* from "
				+ "(select * from BOARDGAME where GAME_KONAME like ? order by GAME_LEVEL desc) u) "
				+ " where r between ? and ?";
		String sql = "";

		if (search != null && !search.equals("")) {
			sql = sql2;
		} else {
			sql = sql1;
		}
		cate = "%" + cate + "%";

		try {
			pstmt = conn.prepareStatement(sql);
			int idx = 0;
			if (search != null && !search.equals("")) {
				search = "%" + search + "%";
				pstmt.setString(++idx, search);
				
			}
			pstmt.setString(++idx, cate);
			pstmt.setInt(++idx, start);
			pstmt.setInt(++idx, end);
			
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

	public ArrayList<Game> selectGradeDescGameList(Connection conn, int start, int end,String cate, String search) {

		ArrayList<Game> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql1 = "select * from " + " (select Rownum r, t1.* from "
				+ " (select * from BOARDGAME where GAME_CATEGORY like ? order by GAME_GRADE asc) t1 ) t2 " + " where r between ? and ?";
		String sql2 = "select * from (select Rownum r, u.* from "
				+ "(select * from BOARDGAME where GAME_KONAME like ? order by GAME_GRADE asc) u) "
				+ " where r between ? and ?";
		String sql = "";
		if (search != null && !search.equals("")) {
			sql = sql2;
		} else {
			sql = sql1;
		}
		
		cate = "%" + cate + "%";
		try {
			pstmt = conn.prepareStatement(sql);
			int idx = 0;
			if (search != null && !search.equals("")) {
				search = "%" + search + "%";
				pstmt.setString(++idx, search);
				
			}
			pstmt.setString(++idx, cate);
			pstmt.setInt(++idx, start);
			pstmt.setInt(++idx, end);
			
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

	public ArrayList<Game> selectSortGameList(Connection conn, int start, int end, String cate, String search) {

		ArrayList<Game> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql1 = "select * from " + " (select Rownum r, t1.* from "
				+ " (select * from BOARDGAME where GAME_CATEGORY like ? order by GAME_KONAME asc) t1 ) t2 " + " where r between ? and ?";
		String sql2 = "select * from (select Rownum r, u.* from "
				+ "(select * from BOARDGAME where GAME_KONAME like ? order by GAME_KONAME asc) u) "
				+ " where r between ? and ?";
		String sql = "";
		if (search != null && !search.equals("")) {
			sql = sql2;
		} else {
			sql = sql1;
		}
		cate = "%" + cate + "%";

		try {
			pstmt = conn.prepareStatement(sql);
			int idx = 0;
			if (search != null && !search.equals("")) {
				search = "%" + search + "%";
				pstmt.setString(++idx, search);
				
			}
			pstmt.setString(++idx, cate);
			pstmt.setInt(++idx, start);
			pstmt.setInt(++idx, end);
			
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

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from " + " (select Rownum r, t1.* from "
				+ " (select * from BOARDGAME order by GAME_GRADE asc) t1 ) t2 " + " where r between ? and ?";


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
					vo.setR(rset.getInt("r"));

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
	public ArrayList<Game> selectSortGradeRankList(Connection conn, int start, int end,String sort1,String sort2,String sort3,String sort4) {

		ArrayList<Game> volist = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = " select * from (select Rownum r, t1.* from "
				+ " (select * from BOARDGAME where GAME_AGE like ? and GAME_PLAYER like ? and GAME_TIME like ? and GAME_CATEGORY like ? order by GAME_GRADE asc) t1 ) t2 "
				+ " where r between ? and ?";
		sort1 = "%"+ sort1 +"%";
		sort2 = "%"+ sort2 +"%";
		sort3 = "%"+ sort3 +"%";
		sort4 = "%"+ sort4 +"%";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sort1);
			pstmt.setString(2, sort2);	
			pstmt.setString(3, sort3);
			pstmt.setString(4, sort4);
			pstmt.setInt(5, start);
			pstmt.setInt(6, end);
			
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
					vo.setR(rset.getInt("r"));

					volist.add(vo);
					
					System.out.println(vo);
					System.out.println(volist);
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
	public ArrayList<Game> selectSortViewRankList(Connection conn, int start, int end,String sort1,String sort2,String sort3,String sort4) {

		ArrayList<Game> volist = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = " select * from (select Rownum r, t1.* from "
				+ " (select * from BOARDGAME where GAME_AGE like ? and GAME_PLAYER like ? and GAME_TIME like ? and GAME_CATEGORY like ? order by GAME_VIEW_COUNT desc) t1 ) t2 "
				+ " where r between ? and ?";
		sort1 = "%"+ sort1 +"%";
		sort2 = "%"+ sort2 +"%";
		sort3 = "%"+ sort3 +"%";
		sort4 = "%"+ sort4 +"%";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sort1);
			pstmt.setString(2, sort2);	
			pstmt.setString(3, sort3);
			pstmt.setString(4, sort4);
			pstmt.setInt(5, start);
			pstmt.setInt(6, end);
			
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
					vo.setR(rset.getInt("r"));

					volist.add(vo);
					
					System.out.println(vo);
					System.out.println(volist);
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

	public ArrayList<Game> selectSortJjimRankList(Connection conn, int start, int end,String sort1,String sort2,String sort3,String sort4) {

		ArrayList<Game> volist = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = " select * from (select Rownum r, t1.* from "
				+ " (select * from BOARDGAME where GAME_AGE like ? and GAME_PLAYER like ? and GAME_TIME like ? and GAME_CATEGORY like ? order by likecount desc) t1 ) t2 "
				+ " where r between ? and ?";
		sort1 = "%"+ sort1 +"%";
		sort2 = "%"+ sort2 +"%";
		sort3 = "%"+ sort3 +"%";
		sort4 = "%"+ sort4 +"%";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sort1);
			pstmt.setString(2, sort2);	
			pstmt.setString(3, sort3);
			pstmt.setString(4, sort4);
			pstmt.setInt(5, start);
			pstmt.setInt(6, end);
			
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
					vo.setR(rset.getInt("r"));

					volist.add(vo);
					
					System.out.println(vo);
					System.out.println(volist);
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
				+ " (select * from BOARDGAME order by GAME_VIEW_COUNT desc) t1 ) t2 " + " where r between ? and ?";

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
					vo.setR(rset.getInt("r"));
					
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

		String sql = "select t3.*, NVL(t4.likecount,0) as likecount from (select * from  (select Rownum r, t1.* from (select * from BOARDGAME) t1) t2  where r between ? and ?) t3 "
				+" left outer join (select game_no, count(*) as likecount from BOARDGAME_LIKE group by game_no order by likecount desc) t4 "
				+" on t3.game_no = t4.game_no";

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
					vo.setR(rset.getInt("r"));
					
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
	
	public int updateViewCount(Connection conn, int gameno){
		int result = 0;
		String sql = "update BOARDGAME set GAME_VIEW_COUNT = GAME_VIEW_COUNT + 1 where GAME_NO = ?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gameno);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteReviewLike(Connection conn, String userId, int reviewNo, int gameNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "delete from REVIEW_LIKE where (USER_ID = ? and REVIEW_NO = ? and GAME_NO = ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, reviewNo);
			pstmt.setInt(3, gameNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int insertReviewLike(Connection conn, String userId,int reviewNo,  int gameNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "insert into REVIEW_LIKE values(REVIEW_LIKE_NUM.nextval,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, reviewNo);
			pstmt.setInt(3, gameNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int countReviewLike(Connection conn,  String userId, int gameNo) {
		int result = -1;
		String sql = "select count(REVIEW_LIKE_NO) from REVIEW_LIKE where (USER_ID = ? and GAME_NO = ?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, gameNo);
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
	
	public int deleteGameLike(Connection conn, String userId, int gameNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "delete from BOARDGAME_LIKE where (USER_ID = ? and GAME_NO = ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, gameNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int insertGameLike(Connection conn, String userId, int gameNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "insert into BOARDGAME_LIKE values(BOARDGAME_LIKE_NUM.nextval, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, gameNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int countGameLike(Connection conn,  String userId, int gameNo) {
		int result = -1;
		String sql = "select count(BOARDGAME_LIKE_NO) from BOARDGAME_LIKE where (USER_ID = ? and GAME_NO = ?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, gameNo);
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
	
	public int countReviewReport(Connection conn, int reviewNo, String userId) {
		int result = -1;
		String sql = "select count(COMMENT_REPORT_NO) from REVIEW_REPORT where (REVIEW_NO = ? and USER_ID = ?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			pstmt.setString(2, userId);
			
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
	
	public int deleteReviewReport(Connection conn, int reviewNo, String userId, int gameNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "delete from BOARDGAME_LIKE where (REVIEW_NO = ? and USER_ID = ? and GAME_NO = ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			pstmt.setString(2, userId);
			pstmt.setInt(3, gameNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int insertReviewReport(Connection conn, int reviewNo, String userId, int gameNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "insert into REVIEW_REPORT values(REVIEW_REPORT_NUM.nextval, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			pstmt.setString(2, userId);
			pstmt.setInt(3, gameNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int deleteReview(Connection conn, int reviewNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "delete from REVIEW where REVIEW_NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public List<Game> searchList(Connection conn, String searchKeyword) {
		List<Game> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from BOARDGAME where GAME_KONAME like ? or GAME_ENNAME like ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			searchKeyword = "%" + searchKeyword + "%";
			pstmt.setString(1, searchKeyword);
			pstmt.setString(2, searchKeyword);
		//	pstmt.setString(3, searchKeyword);
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
