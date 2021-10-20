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


public class GameService {

	public GameService() {
		// TODO Auto-generated constructor stub
	}



	public Game InfoGame(String name) {
		Game vo= null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new GameDao().InfoGame(conn,name);
		JDBCTemplate.close(conn);
		return vo;
	}
	public GameReview InfoReview(int no) {
		GameReview vo= null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new GameDao().InfoReview(conn,no);
		JDBCTemplate.close(conn);
		return vo;
	}
	public ArrayList<GameReview> selectReview(int start, int end,int no) {
		ArrayList<GameReview> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectReview(conn,start,end,no);
		JDBCTemplate.close(conn);
		return volist;
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
	public int insertReview(GameReview vo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().insertReview(conn, vo);
		JDBCTemplate.close(conn);
		return result;
	}
	public int updateGrade(int gameno) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().updateGrade(conn, gameno);
		JDBCTemplate.close(conn);
		return result;
	}
	public ArrayList<Game> selectCateGameList(int start, int end, String cate, String search) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectCateGameList(conn, start, end, cate, search);
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public ArrayList<Game> selectLevelGameList(int start, int end, String search) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectLevelGameList(conn,start, end, search);
		JDBCTemplate.close(conn);
		return volist;
	}
	public ArrayList<Game> selectGradeGameList(int start, int end, String search) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectGradeGameList(conn,start, end,search);
		JDBCTemplate.close(conn);
		return volist;
	}
	public ArrayList<Game> selectGradeDescGameList(int start, int end,String search) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectGradeDescGameList (conn,start, end,search);
		JDBCTemplate.close(conn);
		return volist;
	}
	public ArrayList<Game> selectSortGameList(int start, int end,String search) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectSortGameList (conn,start, end,search);
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
