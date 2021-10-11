package kh.semi.boardclass.game.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.game.model.dao.GameDao;
import kh.semi.boardclass.game.model.vo.Game;
import kh.semi.boardclass.game.model.vo.GameLike;


public class GameService {

	public GameService() {
		// TODO Auto-generated constructor stub
	}

	public int getListCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().getListCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public int selectCategory() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().selectCategory(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Game> selectGame() {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectGame(conn);
		JDBCTemplate.close(conn);
		return volist;
	}

	public int getListCounterFilter() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().getListCounterFilter(conn);
		JDBCTemplate.close(conn);
		return result;
	}
	public int getGameCount(){
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().getGameCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public ArrayList<Game> selectFilterGameList() {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectFilterGameList(conn);
		JDBCTemplate.close(conn);
		return volist;
	}
	public ArrayList<Game> selectFilterGameList(int start, int end) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectFilterGameList(conn,start, end);
		JDBCTemplate.close(conn);
		return volist;
	}

	public int addViewCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().addViewCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertGameLike(GameLike gameLike) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().insertGameLike(conn, gameLike);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Game> selectGameRank() {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectGameRank(conn);
		JDBCTemplate.close(conn);
		return volist;
	}

	public ArrayList<Game> searchFilterGameRank(String gameCategory, String gameAge, String gamePlayer, int gameTime,int gamePrice) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().searchFilterGameRank(conn, gameCategory, gameAge, gamePlayer, gameTime, gamePrice);
		JDBCTemplate.close(conn);
		return volist;
	}

}
