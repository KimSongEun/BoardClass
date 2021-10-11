package kh.semi.boardclass.admin.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public ArrayList<Notice> getNewestNotice(Connection conn){
		ArrayList<Notice> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT * FROM NOTICE ORDER BY ADMIN_RWR_DATE DESC) t1) t2 where r between 1 and 5";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Notice>();
			if (rset.next()) {
				do {
					Notice vo = new Notice();
					vo.setAdminContent(rset.getString("ADMIN_CONTENT"));
					vo.setAdminRwrDate(rset.getDate("ADMIN_RWR_DATE"));
					vo.setAdminWrDate(rset.getDate("ADMIN_WR_DATE"));
					vo.setAdminTitle(rset.getString("ADMIN_TITLE"));
					vo.setAnnounceNo(rset.getInt("ANNOUNCE_NO"));
					vo.setUserId(rset.getString("USER_ID"));
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
	
	public Notice getNotice(Connection conn, int announceNo) {
		Notice vo = null;
		String sql = "select * from notice where announce_no = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  announceNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				vo = new Notice();
				vo.setAdminContent(rset.getString("ADMIN_CONTENT"));
				vo.setAdminRwrDate(rset.getDate("ADMIN_RWR_DATE"));
				vo.setAdminWrDate(rset.getDate("ADMIN_WR_DATE"));
				vo.setAdminTitle(rset.getString("ADMIN_TITLE"));
				vo.setAnnounceNo(rset.getInt("ANNOUNCE_NO"));
				vo.setUserId(rset.getString("USER_ID"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			} 
		return vo;
	}
	
	public int getNoticeCount(Connection conn) {
		int result = 0;
		String sql = "select count(ANNOUNCE_NO) from NOTICE";
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

	public ArrayList<Notice> selectNoticeList(Connection conn, int start, int end) {
		ArrayList<Notice> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT * FROM NOTICE ORDER BY ADMIN_RWR_DATE DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Notice>();
			if (rset.next()) {
				do {
					Notice vo = new Notice();
					vo.setAdminContent(rset.getString("ADMIN_CONTENT"));
					vo.setAdminRwrDate(rset.getDate("ADMIN_RWR_DATE"));
					vo.setAdminWrDate(rset.getDate("ADMIN_WR_DATE"));
					vo.setAdminTitle(rset.getString("ADMIN_TITLE"));
					vo.setAnnounceNo(rset.getInt("ANNOUNCE_NO"));
					vo.setUserId(rset.getString("USER_ID"));
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
	
	public Notice searchNotice(Connection conn, int announceNo){
		Notice vo = null;
		return vo;
	}
	
	public int insertNotice(Connection conn, String title, String content, String writer){
		int result = 0;
		String sql = "INSERT INTO NOTICE VALUES (NOTICE_NUM.nextval, ?, ?, ?, SYSDATE, SYSDATE, null, null)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}	
	
	public int updateNotice(Connection conn, String title, String content, int announceNo){
		int result = 0;
		String sql = "UPDATE NOTICE SET ADMIN_TITLE = ? , ADMIN_CONTENT =?, ADMIN_RWR_DATE = SYSDATE WHERE ANNOUNCE_NO=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, announceNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteNotice(Connection conn, int announceNo){
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM NOTICE WHERE ANNOUNCE_NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, announceNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
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
	
	public Banner getAd(Connection conn, int promotionNo) {
		Banner vo = null;
		String sql = "select * from banner where promotion_no = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  promotionNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				vo = new Banner();
				vo.setUserId(rset.getString("USER_ID"));
				vo.setPromotionPlace(rset.getInt("PROMOTION_PLACE"));
				vo.setPromotionTitle(rset.getString("PROMOTION_TITLE"));
				vo.setPromotionContent(rset.getString("PROMOTION_CONTENT"));
				vo.setPromotionDate(rset.getDate("PROMOTION_DATE"));
				vo.setPromotionImg(rset.getString("PROMOTION_IMG"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			} 
		return vo;
	}
	
	public int getAdCount(Connection conn) {
		int result = 0;
		String sql = "select count(PROMOTION_NO) from BANNER";
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
	
	public ArrayList<Banner> selectAdList(Connection conn, int start, int end) {
		ArrayList<Banner> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT * FROM BANNER ORDER BY PROMOTION_DATE DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Banner>();
			if (rset.next()) {
				do {
					Banner vo = new Banner();
					vo.setUserId(rset.getString("USER_ID"));
					vo.setPromotionPlace(rset.getInt("PROMOTION_PLACE"));
					vo.setPromotionTitle(rset.getString("PROMOTION_TITLE"));
					vo.setPromotionContent(rset.getString("PROMOTION_CONTENT"));
					vo.setPromotionDate(rset.getDate("PROMOTION_DATE"));
					vo.setPromotionImg(rset.getString("PROMOTION_IMG"));
					vo.setPromotionNo(rset.getInt("PROMOTION_NO"));
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
	
	public Banner searchAd(Connection conn){
		Banner vo = null;
		return vo;
	}
	
	public int insertAd(Connection conn, String title, String content, String writer, String img){
		int result = 0;
		String sql = "INSERT INTO BANNER VALUES (PROMOTION_NUM.nextval, ?, 2147483647, ?, ?, SYSDATE, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setString(4, img);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int updateAd(Connection conn, String title, String content, String img, int promotionNo){
		int result = 0;
		String sql = "UPDATE BANNER SET PROMOTION_TITLE = ? , PROMOTION_CONTENT =?, PROMOTION_IMG = ? WHERE PROMOTION_NO=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, img);
			pstmt.setInt(4, promotionNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int deleteAd(Connection conn, int promotionNo){
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM BANNER WHERE PROMOTION_NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, promotionNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
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
