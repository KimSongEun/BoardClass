package kh.semi.boardclass.game.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

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
		return volist;
	}
	
	public int getListCounterFilter(Connection conn) {
		int result = 0;
		return result;
	}
	
	public int selectFilterGameList(Connection conn) {
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
	
	public ArrayList<Game> searchFilterGameRank(Connection conn, String gameCategory, String gameAge, String gamePlayer, int gameTime,int gamePrice) {
		ArrayList<Game> volist = null;
		return volist;
	}
	

	
	
	
	

}
