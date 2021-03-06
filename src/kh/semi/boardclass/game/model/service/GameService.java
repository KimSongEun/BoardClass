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
	public int deleteGameLike(String userId, int gameNo) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().deleteGameLike(conn, userId, gameNo);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int insertGameLike(String userId, int gameNo) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().insertGameLike(conn, userId, gameNo);
		JDBCTemplate.close(conn);
		return result;
	}
	public int deleteReviewLike(String userId, int reviewNo,  int gameNo) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().deleteReviewLike(conn, userId, reviewNo,gameNo);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int insertReviewLike(String userId, int reviewNo, int gameNo) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().insertReviewLike(conn, userId, reviewNo, gameNo);
		JDBCTemplate.close(conn);
		return result;
	}


	public Game InfoGame(int no) {
		Game vo= null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new GameDao().InfoGame(conn,no);
		JDBCTemplate.close(conn);
		return vo;
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
	public ArrayList<GameReview> selectReview(int start, int end,int no, String userId) {
		ArrayList<GameReview> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectReview(conn,start,end,no, userId);
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public ArrayList<GameReview> selectHotReview(int start, int end,int no, String userId) {
		ArrayList<GameReview> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectHotReview(conn,start,end,no,userId);
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
	public int getGameCount( ){
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().getGameCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}
	public int getGameCount(String cate){
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().getGameCount(conn,cate);
		JDBCTemplate.close(conn);
		return result;
	}
	public int getReviewCount(int gameno){
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().getReviewCount(conn, gameno);
		JDBCTemplate.close(conn);
		return result;
	}
	public int countGameLike(String userId, int gameNo){
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().countGameLike(conn, userId, gameNo);
		JDBCTemplate.close(conn);
		return result;
	}
	public int countReviewLike(String userId, int gameNo){
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().countReviewLike(conn, userId, gameNo);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int countReviewReport(int reviewNo, String userId) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().countReviewReport(conn, reviewNo, userId);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int insertReivewReport(int reviewNo, String userId,int gameNo) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().insertReviewReport(conn, reviewNo, userId,gameNo);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int deleteReivewReport(int reviewNo, String userId,int gameNo) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().deleteReviewReport(conn, reviewNo, userId,gameNo);
		JDBCTemplate.close(conn);
		return result;
	}


	public int deleteReview(int reviewNo) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().deleteReview(conn, reviewNo);
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
	public int updateViewCount(int gameno) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new GameDao().updateViewCount(conn, gameno);
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
	
	public ArrayList<Game> selectLevelGameList(int start, int end,String cate, String search) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectLevelGameList(conn,start, end,cate, search);
		JDBCTemplate.close(conn);
		return volist;
	}
	public ArrayList<Game> selectGradeGameList(int start, int end, String cate,String search) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectGradeGameList(conn,start, end,cate,search);
		JDBCTemplate.close(conn);
		return volist;
	}
	public ArrayList<Game> selectGradeDescGameList(int start, int end,String cate,String search) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectGradeDescGameList (conn,start, end,cate,search);
		JDBCTemplate.close(conn);
		return volist;
	}
	public ArrayList<Game> selectSortGameList(int start, int end,String cate,String search) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectSortGameList (conn,start, end,cate,search);
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
	public ArrayList<Game> selectSortGradeRankList(int start, int end,String sort1,String sort2,String sort3,String sort4) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectSortGradeRankList(conn, start, end,sort1,sort2,sort3,sort4);
		JDBCTemplate.close(conn);
		return volist;
	}
	public ArrayList<Game> selectSortViewRankList(int start, int end,String sort1,String sort2,String sort3,String sort4) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectSortViewRankList(conn, start, end,sort1,sort2,sort3,sort4);
		JDBCTemplate.close(conn);
		return volist;
	}
	public ArrayList<Game> selectSortJjimRankList(int start, int end,String sort1,String sort2,String sort3,String sort4) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().selectSortJjimRankList(conn, start, end,sort1,sort2,sort3,sort4);
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
	
	public ArrayList<Game> gamePlusNo(String s1, String s2) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new GameDao().gamePlusNo(conn, s1, s2);
		JDBCTemplate.close(conn);
		return volist;
	}
}
