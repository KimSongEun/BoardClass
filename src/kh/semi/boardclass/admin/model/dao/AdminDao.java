package kh.semi.boardclass.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.community.model.vo.BoardReport;
import kh.semi.boardclass.community.model.vo.Comment;
import kh.semi.boardclass.community.model.vo.CommentReport;
import kh.semi.boardclass.game.model.vo.Game;
import kh.semi.boardclass.user.model.vo.User;

import java.util.ArrayList;

import kh.semi.boardclass.admin.model.vo.Banner;
import kh.semi.boardclass.admin.model.vo.Notice;

public class AdminDao {

	public AdminDao() {

	}

	public int getAllUserCount(Connection conn){
		int result = 0;
		return result;
	}
	public int getTodayVisitCount(Connection conn){
		int result = 0;
		return result;
	}
	public int getMonthVisitCount(Connection conn){
		int result = 0;
		return result;
	}
	public int getTodayBoardCount(Connection conn){
		int result = 0;
		return result;
	}
	public ArrayList<BoardReport> getRankReportBoard(Connection conn){
		ArrayList<BoardReport> volist = null;
		return volist;
	}
	public ArrayList<CommentReport> getRankReportComment(Connection conn){
		ArrayList<CommentReport> volist = null;
		return volist;
	}
	public ArrayList<Notice> getRankNotice(Connection conn){
		ArrayList<Notice> volist = null;
		return volist;
	}
	
	public Notice getnotice(Connection conn, int announceNo) {
		Notice vo = null;
		return vo;
	}
	public int getNoticeCount(Connection conn) {
		int result = 0;
		return result; 
	}
	public ArrayList<Notice> selectNoticeList(Connection conn, int start, int end) {
		ArrayList<Notice> volist = null;
		return volist;
	}
	public Notice searchNotice(Connection conn, int announceNo){
		Notice vo = null;
		return vo;
	}
	public int insertNotice(Connection conn, Notice notice){
		int result = 0;
		return result;
	}	
	public int updateNotice(Connection conn, Notice notice){
		int result = 0;
		return result;
	}
	public int deleteNotice(Connection conn, Notice notice){
		int result = 0;
		return result;
	}
	public ArrayList<Game> selectBoardGameList(Connection conn){
		ArrayList<Game> volist = null;
		return volist;
	}
	public Game searchBoardGame(Connection conn){
		Game vo = null;
		return vo;
	}
	public int insertBoardGame(Connection conn, Game game){
		int result = 0;
		return result;
	}
	public int updateBoardGame(Connection conn, Game game){
		int result = 0;
		return result;
	}
	public int deleteBoardGame(Connection conn, Game game){
		int result = 0;
		return result;
	}
	public ArrayList<Banner> selectAdList(Connection conn){
		ArrayList<Banner> volist = null;
		return volist;
	}
	public Banner searchAd(Connection conn){
		Banner vo = null;
		return vo;
	}
	public int insertAd(Connection conn, Banner banner){
		int result = 0;
		return result;
	}
	public int updateAd(Connection conn, Banner banner){
		int result = 0;
		return result;
	}
	public int deleteAd(Connection conn, Banner banner){
		int result = 0;
		return result;
	} 
	
	public ArrayList<Board> selectAllBoardList(Connection conn){
		ArrayList<Board> volist = null;
		return volist;
	}
	public Board searchAllBoard(Connection conn){
		Board vo = null;
		return vo;
	}
	public int updateBoardCategory(Connection conn, Board comu){
		int result = 0;
		return result;
	}
	public int updateBoardType(Connection conn, Board comu){
		int result = 0;
		return result;
	} 
	public ArrayList<Comment> selectAllCommentList(Connection conn){
		ArrayList<Comment> volist = null;
		return volist;
	}
	public Comment searchAllcomment(Connection conn){
		Comment vo = null;
		return vo;
	}
	public ArrayList<User> selectUserList(Connection conn){
		ArrayList<User> volist = null;
		return volist;
	} 
	public User searchUser(Connection conn){
		User vo = null;
		return vo;
	}
	public User getUser(Connection conn, int userNum){
		User vo = null;
		return vo;
	}
	
	public int deleteUserByForce(Connection conn, User user){
		int result = 0;
		return result;
	} 

	public ArrayList<Board> selectReportBoardList(Connection conn){
		ArrayList<Board> volist = null;
		return volist;
	}
	public BoardReport searchReportBoard(Connection conn){
		BoardReport vo = null;
		return vo;
	}
	public ArrayList<Board> selectReportCommentList(Connection conn){
		ArrayList<Board> volist = null;
		return volist;
	}
	public CommentReport searchReportComment(Connection conn){
		CommentReport vo = null;
		return vo;
	}
}
