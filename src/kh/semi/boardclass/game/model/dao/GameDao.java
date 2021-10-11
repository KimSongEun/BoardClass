package kh.semi.boardclass.game.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.game.model.vo.Game;
import kh.semi.boardclass.game.model.vo.GameLike;


public class GameDao {

	public GameDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getListCount(Connection conn) {
		int result = 0;
		return result;
	}
	
	public int selectCategory(Connection conn) {
		int result = 0;
		return result;
	}
	
	public ArrayList<Game> selectGame(Connection conn) {
		ArrayList<Game> volist = null;
		String sql ="select * from BOARDGAME";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				volist = new ArrayList<Game>();
				do {
					Game vo = new Game();
					vo.setGameNumber(rset.getInt("GAME_NUMBER"));
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
					vo.setUsedNum(rset.getInt("USED_NUM"));
					
					
					volist.add(vo);
					
				}while(rset.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return volist;
	}
	
	public int getListCounterFilter(Connection conn) {
		int result = 0;
		return result;
	}
	
	public int getGameCount(Connection conn) {
		int result = 0;
		String sql = "select count(GAME_NUMBER) from BOARDGAME";
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
	
public ArrayList<Game> selectFilterGameList(Connection conn) {
		
		ArrayList<Game> volist = null;
		String sql ="select * from BOARDGAME";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				volist = new ArrayList<Game>();
				do {
					Game vo = new Game();
					vo.setGameNumber(rset.getInt("GAME_NUMBER"));
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
					vo.setUsedNum(rset.getInt("USED_NUM"));
					
					
					volist.add(vo);
					
				}while(rset.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return volist;
	}
	
	public ArrayList<Game> selectFilterGameList(Connection conn, int start, int end) {
		
		ArrayList<Game> volist = null;
		String sql ="select * from "
				+ " (select Rownum r, t1.* from "
				+ " (select * from BOARDGAME order by GAME_LEVEL asc) t1 ) t2 "
				+ " where r between ? and ?";
//		String sql ="select * from BOARDGAME";
				
				
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				volist = new ArrayList<Game>();
				do {
					Game vo = new Game();
					vo.setGameNumber(rset.getInt("GAME_NUMBER"));
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
					vo.setUsedNum(rset.getInt("USED_NUM"));
					
					volist.add(vo);
					
				}while(rset.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return volist;
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
	
	public ArrayList<Game> searchFilterGameRank(Connection conn, String gameCategory, String gameAge, String gamePlayer, int gameTime,int gamePrice) {
		ArrayList<Game> volist = null;
		return volist;
	}
	

	
	
	
	

}
