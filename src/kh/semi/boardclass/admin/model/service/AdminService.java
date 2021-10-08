package kh.semi.boardclass.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.boardclass.admin.model.dao.AdminDao;
import kh.semi.boardclass.admin.model.vo.Banner;
import kh.semi.boardclass.admin.model.vo.Notice;
import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.community.model.vo.BoardReport;
import kh.semi.boardclass.community.model.vo.Comment;
import kh.semi.boardclass.community.model.vo.CommentReport;
import kh.semi.boardclass.game.model.vo.Game;
import kh.semi.boardclass.user.model.vo.User;

public class AdminService {
	public AdminService() {

	}

	public int getAllUserCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().getAllUserCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public int getTodayVisitCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().getTodayVisitCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public int getMonthVisitCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().getMonthVisitCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public int getTodayBoardCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().getTodayBoardCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<BoardReport> getRankReportBoard() {
		ArrayList<BoardReport> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().getRankReportBoard(conn);
		JDBCTemplate.close(conn);
		return volist;
	}

	public ArrayList<CommentReport> getRankReportComment() {
		ArrayList<CommentReport> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().getRankReportComment(conn);
		JDBCTemplate.close(conn);
		return volist;
	}

	public ArrayList<Notice> getRankNotice() {
		ArrayList<Notice> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().getRankNotice(conn);
		JDBCTemplate.close(conn);
		return volist;
	}

	public Notice getNotice(int announceNo) {
		Notice vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new AdminDao().getnotice(conn, announceNo);
		JDBCTemplate.close(conn);
		return vo;
	}

	public int getNoticeCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().getNoticeCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Notice> selectNoticeList(int start, int end) {
		ArrayList<Notice> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().selectNoticeList(conn, start, end);
		JDBCTemplate.close(conn);
		return volist;
	}

	public Notice searchNotice(int announceNo) {
		Notice vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new AdminDao().searchNotice(conn, announceNo);
		JDBCTemplate.close(conn);
		return vo;
	}

	public int insertNotice(Notice notice) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().insertNotice(conn, notice);
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateNotice(Notice notice) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().updateNotice(conn, notice);
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteNotice(Notice notice) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().deleteNotice(conn, notice);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Game> selectBoardGameList() {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().selectBoardGameList(conn);
		JDBCTemplate.close(conn);
		return volist;
	}

	public Game searchBoardGame() {
		Game vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new AdminDao().searchBoardGame(conn);
		JDBCTemplate.close(conn);
		return vo;
	}

	public int insertBoardGame(Game game) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().insertBoardGame(conn, game);
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateBoardGame(Game game) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().updateBoardGame(conn, game);
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteBoardGame(Game game) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().deleteBoardGame(conn, game);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Banner> selectAdList() {
		ArrayList<Banner> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().selectAdList(conn);
		JDBCTemplate.close(conn);
		return volist;
	}

	public Banner searchAd() {
		Banner vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new AdminDao().searchAd(conn);
		JDBCTemplate.close(conn);
		return vo;
	}

	public int insertAd(Banner banner) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().insertAd(conn, banner);
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateAd(Banner banner) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().updateAd(conn, banner);
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteAd(Banner banner) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().deleteAd(conn, banner);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Board> selectAllBoardList() {
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().selectAllBoardList(conn);
		JDBCTemplate.close(conn);
		return volist;
	}

	public Board searchAllBoard() {
		Board vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new AdminDao().searchAllBoard(conn);
		JDBCTemplate.close(conn);
		return vo;
	}

	public int updateBoardCategory(Board comu) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().updateBoardCategory(conn, comu);
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateBoardType(Board comu) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().updateBoardType(conn, comu);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Comment> selectAllCommentList() {
		ArrayList<Comment> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().selectAllCommentList(conn);
		JDBCTemplate.close(conn);
		return volist;
	}

	public Comment searchAllcomment() {
		Comment vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new AdminDao().searchAllcomment(conn);
		JDBCTemplate.close(conn);
		return vo;
	}

	public ArrayList<User> selectUserList() {
		ArrayList<User> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().selectUserList(conn);
		JDBCTemplate.close(conn);
		return volist;
	}

	public User searchUser() {
		User vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new AdminDao().searchUser(conn);
		JDBCTemplate.close(conn);
		return vo;
	}

	public User getUser(int userNum) {
		User vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new AdminDao().getUser(conn, userNum);
		JDBCTemplate.close(conn);
		return vo;
	}

	public int deleteUserByForce(User user) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().deleteUserByForce(conn, user);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Board> selectReportBoardList() {
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().selectReportBoardList(conn);
		JDBCTemplate.close(conn);
		return volist;
	}

	public BoardReport searchReportBoard() {
		BoardReport vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new AdminDao().searchReportBoard(conn);
		JDBCTemplate.close(conn);
		return vo;
	}

	public ArrayList<Board> selectReportCommentList() {
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().selectReportCommentList(conn);
		JDBCTemplate.close(conn);
		return volist;
	}

	public CommentReport searchReportComment() {
		CommentReport vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new AdminDao().searchReportComment(conn);
		JDBCTemplate.close(conn);
		return vo;
	}
}
