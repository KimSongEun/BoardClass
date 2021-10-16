package kh.semi.boardclass.admin.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import kh.semi.boardclass.admin.model.dao.AdminDao;
import kh.semi.boardclass.admin.model.vo.AllBoardUser;
import kh.semi.boardclass.admin.model.vo.AllCommentUser;
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

	public ArrayList<Notice> getNewestNotice() {
		ArrayList<Notice> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().getNewestNotice(conn);
		JDBCTemplate.close(conn);
		return volist;
	}

	public Notice getNotice(int announceNo) {
		Notice vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new AdminDao().getNotice(conn, announceNo);
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

	public int insertNotice(String title, String content, String writer) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().insertNotice(conn, title, content, writer);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateNotice(String title, String content, int announceNo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().updateNotice(conn, title, content, announceNo);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteNotice(int announceNo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().deleteNotice(conn, announceNo);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public Game getBoardGame(int gameNo) {
		Game vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new AdminDao().getBoardGame(conn, gameNo);
		JDBCTemplate.close(conn);
		return vo;
	}

	public int getBoardGameCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().getBoardGameCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public ArrayList<Game> selectBoardGameList(int start, int end) {
		ArrayList<Game> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().selectBoardGameList(conn, start, end);
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

	public int insertBoardGame(String kotitle, String entitle, String category, String age, String player, String time, int price, int grade, int level, String designer,String writer, String brand, String releasedate, String language, String image, String ruleimage, String video, String plus) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().insertBoardGame(conn, kotitle, entitle, category, age, player, time, price, grade, level, designer, writer, brand, releasedate, language, image, ruleimage, video, plus);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateBoardGame(String kotitle, String entitle, String category, String age, String player, String time, int price, int grade, int level, String designer, String writer, String brand, String releasedate, String language, String image, String ruleimage, String video, String plus, int gameNo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().updateBoardGame(conn, kotitle, entitle, category, age, player, time, price, grade, level, designer, writer, brand, releasedate, language, image, ruleimage, video, plus, gameNo);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteBoardGame(int gameNo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().deleteBoardGame(conn, gameNo);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Banner getAd(int promotionNo) {
		Banner vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new AdminDao().getAd(conn, promotionNo);
		JDBCTemplate.close(conn);
		return vo;
	}

	public int getAdCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().getAdCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public ArrayList<Banner> selectAdList(int start, int end) {
		ArrayList<Banner> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().selectAdList(conn, start, end);
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

	public int insertAd(String title, String content, String writer, String img) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().insertAd(conn, title, content, writer, img);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateAd(String title, String content, String img, int promotionNo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().updateAd(conn, title, content, img, promotionNo);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteAd(int promotionNo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().deleteAd(conn, promotionNo);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	
	public int getAllBoardCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().getAllBoardCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<AllBoardUser> selectAllBoardList(int start, int end) {
		ArrayList<AllBoardUser> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().selectAllBoardList(conn, start, end);
		JDBCTemplate.close(conn);
		return volist;
	}

	public int getAllBoardUserIdCount(String keyword) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().getAllBoardUserIdCount(conn, keyword);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<AllBoardUser> searchAllBoardUserId(String keyword, int start, int end) {
		ArrayList<AllBoardUser> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().searchAllBoardUserId(conn, keyword, start, end);
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public int getAllBoardUserNoCount(String keyword) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().getAllBoardUserNoCount(conn, keyword);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<AllBoardUser> searchAllBoardUserNo(String keyword, int start, int end) {
		ArrayList<AllBoardUser> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().searchAllBoardUserNo(conn, keyword, start, end);
		JDBCTemplate.close(conn);
		return volist;
	}

	public int getAllBoardTitleCount(String keyword) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().getAllBoardTitleCount(conn, keyword);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<AllBoardUser> searchAllBoardTitle(String keyword, int start, int end) {
		ArrayList<AllBoardUser> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().searchAllBoardTitle(conn, keyword, start, end);
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public int updateAllBoard(int boardNo, String boardCategory, String boardType) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().updateAllBoard(conn, boardNo, boardCategory, boardType);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteAllBoard(int boardNo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().deleteAllBoard(conn, boardNo);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int getAllCommentCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().getAllCommentCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<AllCommentUser> selectAllCommentList(int start, int end) {
		ArrayList<AllCommentUser> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().selectAllCommentList(conn, start, end);
		JDBCTemplate.close(conn);
		return volist;
	}

	public int getAllCommentUserIdCount(String keyword) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().getAllBoardUserIdCount(conn, keyword);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<AllCommentUser> searchAllCommentUserId(String keyword, int start, int end) {
		ArrayList<AllCommentUser> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().searchAllCommentUserId(conn, keyword, start, end);
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public int getAllCommentUserNoCount(String keyword) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().getAllCommentUserNoCount(conn, keyword);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<AllCommentUser> searchAllCommentUserNo(String keyword, int start, int end) {
		ArrayList<AllCommentUser> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().searchAllCommentUserNo(conn, keyword, start, end);
		JDBCTemplate.close(conn);
		return volist;
	}

	public int getAllCommentTitleCount(String keyword) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().getAllCommentTitleCount(conn, keyword);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<AllCommentUser> searchAllCommentTitle(String keyword, int start, int end) {
		ArrayList<AllCommentUser> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new AdminDao().searchAllCommentTitle(conn, keyword, start, end);
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public int deleteAllComment(int commentNo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new AdminDao().deleteAllComment(conn, commentNo);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public AllCommentUser getAllCommentDetail(String commentNo) {
		AllCommentUser vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new AdminDao().getAllCommentDetail(conn, commentNo);
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
