package kh.semi.boardclass.game.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.game.model.dao.GameDao;
import kh.semi.boardclass.game.model.vo.Game;
import kh.semi.boardclass.game.model.vo.GameLike;
import kh.semi.boardclass.game.model.vo.GameReview;
import kh.semi.boardclass.used.model.dao.UsedDao;
import kh.semi.boardclass.used.model.vo.Used;
import kh.semi.boardclass.user.model.dao.UserDao;


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

	public Game InfoGame(String name) {
		Game vo= null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new GameDao().InfoGame(conn,name);
		JDBCTemplate.close(conn);
		return vo;
	}
	

	public ArrayList<Game> selectGame(String name) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectGame(conn,name);
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
	
	public ArrayList<Used> usedlist(String name) {
		ArrayList<Used> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().usedlist(conn,name);
		JDBCTemplate.close(conn);
		return volist;
	}
	public int insertRiview(GameReview vo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().insertRiview(conn, vo);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public ArrayList<Game> selectCateGameList(int start, int end, String cate) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectCateGameList(conn, start, end, cate);
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public ArrayList<Game> selectLevelGameList(int start, int end) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectLevelGameList(conn,start, end);
		JDBCTemplate.close(conn);
		return volist;
	}
	public ArrayList<Game> selectGradeGameList(int start, int end) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectGradeGameList(conn,start, end);
		JDBCTemplate.close(conn);
		return volist;
	}
	public ArrayList<Game> selectGradeDescGameList(int start, int end) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectGradeDescGameList (conn,start, end);
		JDBCTemplate.close(conn);
		return volist;
	}
	public ArrayList<Game> selectSortGameList(int start, int end) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectSortGameList (conn,start, end);
		JDBCTemplate.close(conn);
		return volist;
	}
	
	
	public ArrayList<Game> selectGradeRankList(int start, int end) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectGradeRankList(conn, start, end);
		JDBCTemplate.close(conn);
		return volist;
	}
	public ArrayList<Game> selectViewRankList(int start, int end) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectViewRankList(conn, start, end);
		JDBCTemplate.close(conn);
		return volist;
	}
	public ArrayList<Game> selectJjimRankList(int start, int end) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectJjimRankList(conn, start, end);
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
	
	public List<Game> searchList(String searchKeyword){
		List<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().searchList(conn, searchKeyword);
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public int matchList(String matchKeyword) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().matchList(conn, matchKeyword);
		JDBCTemplate.close(conn);
		return result;
	}

}
