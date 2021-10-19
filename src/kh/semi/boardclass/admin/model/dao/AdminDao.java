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

import kh.semi.boardclass.admin.model.vo.AdminUser;
import kh.semi.boardclass.admin.model.vo.AllBoardUser;
import kh.semi.boardclass.admin.model.vo.AllCommentUser;
import kh.semi.boardclass.admin.model.vo.Banner;
import kh.semi.boardclass.admin.model.vo.Notice;
import kh.semi.boardclass.admin.model.vo.ReportBoard;
import kh.semi.boardclass.admin.model.vo.ReportComment;
import kh.semi.boardclass.admin.model.vo.ReportReview;
import kh.semi.boardclass.admin.model.vo.ReportUsed;

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
		String sql = "INSERT INTO NOTICE VALUES (ANNOUNCE_NUM.nextval, ?, ?, ?, SYSDATE, SYSDATE)";
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
	
	public Game getBoardGame(Connection conn, int gameNo) {
		Game vo = null;
		String sql = "select * from boardgame where game_no = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  gameNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				vo = new Game();
				vo.setGameNumber(rset.getInt("GAME_NO"));
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
				vo.setGamePlusImage(rset.getString("GAME_PLUSIMAGE"));
				vo.setUsedNum(rset.getInt("USED_NO"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			} 
		return vo;
	}
	
	public int getBoardGameCount(Connection conn) {
		int result = 0;
		String sql = "select count(GAME_NO) from BOARDGAME";
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
	
	public ArrayList<Game> selectBoardGameList(Connection conn, int start, int end){
		ArrayList<Game> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT * FROM BOARDGAME ORDER BY GAME_KONAME) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Game>();
			if (rset.next()) {
				do {
					Game vo = new Game();
					vo.setGameNumber(rset.getInt("GAME_NO"));
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
					vo.setGamePlusImage(rset.getString("GAME_PLUSIMAGE"));
					vo.setUsedNum(rset.getInt("USED_NO"));
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
	
	public Game searchBoardGame(Connection conn){
		Game vo = null;
		return vo;
	}
	public int insertBoardGame(Connection conn, String kotitle, String entitle, String category, String age, String player, String time, int price, int grade, int level, String designer, String writer, String brand, String releasedate, String language, String image, String ruleimage, String video, String plus, String plusImage){
		int result = 0;
		String sql = "insert into BOARDGAME values(GAME_NUM.nextval,null,?,?,?,0,?,?,?,?,?,SYSDATE,?,?,?,?,?,null,?,null,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kotitle);
			pstmt.setString(2, entitle);
			pstmt.setString(3, category);
			pstmt.setString(4, age);
			pstmt.setString(5, player);
			pstmt.setString(6, time);
			pstmt.setInt(7, price);
			pstmt.setInt(8, grade);
			pstmt.setInt(9, level);
			pstmt.setString(10, designer);
			pstmt.setString(11, writer);
			pstmt.setString(12, brand);
			pstmt.setString(13, releasedate);
			pstmt.setString(14, language);
			pstmt.setString(15, image);
			pstmt.setString(16, ruleimage);
			pstmt.setString(17, video);
			pstmt.setString(18, plus);
			pstmt.setString(19, plusImage);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateBoardGame(Connection conn, String kotitle, String entitle, String category, String age, String player, String time, int price, int grade, int level, String designer, String writer, String brand, String releasedate, String language, String image, String ruleimage, String video, String plus, String plusImage, int gameNo){
		int result = 0;
		String sql = "UPDATE BOARDGAME SET GAME_KONAME = ?, GAME_ENNAME = ?, GAME_CATEGORY = ?, GAME_AGE = ?, GAME_PLAYER = ?, GAME_TIME = ?, GAME_PRICE = ?, GAME_GRADE = ?, GAME_LEVEL = ?, GAME_DESIGNER = ?, GAME_WRITER = ?, GAME_BRAND = ?, GAME_RELEASEDATE = ?, GAME_LANGUAGE = ?, GAME_IMAGE = ?, GAME_RULE_IMAGE = ?, GAME_VIDEO = ?, GAME_PLUS = ?, GAME_PLUSIMAGE = ? WHERE GAME_NO=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kotitle);
			pstmt.setString(2, entitle);
			pstmt.setString(3, category);
			pstmt.setString(4, age);
			pstmt.setString(5, player);
			pstmt.setString(6, time);
			pstmt.setInt(7, price);
			pstmt.setInt(8, grade);
			pstmt.setInt(9, level);
			pstmt.setString(10, designer);
			pstmt.setString(11, writer);
			pstmt.setString(12, brand);
			pstmt.setString(13, releasedate);
			pstmt.setString(14, language);
			pstmt.setString(15, image);
			pstmt.setString(16, ruleimage);
			pstmt.setString(17, video);
			pstmt.setString(18, plus);
			pstmt.setString(19, plusImage);
			pstmt.setInt(20, gameNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteBoardGame(Connection conn, int gameNo){
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM BOARDGAME WHERE GAME_NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gameNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
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
	
	public int getAllBoardCount(Connection conn) {
		int result = 0;
		String sql = "select count(Board_NO) FROM BOARD B JOIN MEMBER M ON B.USER_ID = M.USER_ID";
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
	
	public ArrayList<AllBoardUser> selectAllBoardList(Connection conn, int start, int end){
		ArrayList<AllBoardUser> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT B.USER_ID, B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY, B.BOARD_TITLE, B.BOARD_CONTENT, B.BOARD_WRITE_DATE, B.BOARD_REWRITE_DATE, M.USER_NO FROM BOARD B JOIN MEMBER M ON B.USER_ID = M.USER_ID ORDER BY BOARD_REWRITE_DATE DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<AllBoardUser>();
			if (rset.next()) {
				do {
					AllBoardUser vo = new AllBoardUser();
					vo.setBoardNo(rset.getInt("BOARD_NO"));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setBoardType(rset.getString("BOARD_TYPE"));
					vo.setBoardCategory(rset.getString("BOARD_CATEGORY"));
					vo.setBoardTitle(rset.getString("BOARD_TITLE"));
					vo.setBoardContent(rset.getString("BOARD_CONTENT"));
					vo.setBoardWriteDate(rset.getDate("BOARD_WRITE_DATE"));
					vo.setBoardRewriteDate(rset.getDate("BOARD_REWRITE_DATE"));
					vo.setUserNo(rset.getInt("USER_NO"));
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
	
	public int getAllBoardUserIdCount(Connection conn, String keyword) {
		int result = 0;
		String sql = "select count(*) as total FROM BOARD B JOIN MEMBER M ON B.USER_ID = M.USER_ID where M.USER_ID like (?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
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
	
	public ArrayList<AllBoardUser> searchAllBoardUserId(Connection conn, String keyword, int start, int end){
		ArrayList<AllBoardUser> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT B.USER_ID, B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY, B.BOARD_TITLE, B.BOARD_CONTENT, B.BOARD_WRITE_DATE, B.BOARD_REWRITE_DATE, M.USER_NO FROM BOARD B JOIN MEMBER M ON B.USER_ID = M.USER_ID WHERE M.USER_ID like (?) ORDER BY BOARD_REWRITE_DATE DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<AllBoardUser>();
			if (rset.next()) {
				do {
					AllBoardUser vo = new AllBoardUser();
					vo.setBoardNo(rset.getInt("BOARD_NO"));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setBoardType(rset.getString("BOARD_TYPE"));
					vo.setBoardCategory(rset.getString("BOARD_CATEGORY"));
					vo.setBoardTitle(rset.getString("BOARD_TITLE"));
					vo.setBoardContent(rset.getString("BOARD_CONTENT"));
					vo.setBoardWriteDate(rset.getDate("BOARD_WRITE_DATE"));
					vo.setBoardRewriteDate(rset.getDate("BOARD_REWRITE_DATE"));
					vo.setUserNo(rset.getInt("USER_NO"));
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
	public int getAllBoardUserNoCount(Connection conn, String keyword) {
		int result = 0;
		String sql = "select count(*) as total FROM BOARD B JOIN MEMBER M ON B.USER_ID = M.USER_ID where USER_NO like (?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
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
	
	public ArrayList<AllBoardUser> searchAllBoardUserNo(Connection conn, String keyword, int start, int end){
		ArrayList<AllBoardUser> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT B.USER_ID, B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY, B.BOARD_TITLE, B.BOARD_CONTENT, B.BOARD_WRITE_DATE, B.BOARD_REWRITE_DATE, M.USER_NO FROM BOARD B JOIN MEMBER M ON B.USER_ID = M.USER_ID WHERE USER_NO like (?) ORDER BY BOARD_REWRITE_DATE DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<AllBoardUser>();
			if (rset.next()) {
				do {
					AllBoardUser vo = new AllBoardUser();
					vo.setBoardNo(rset.getInt("BOARD_NO"));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setBoardType(rset.getString("BOARD_TYPE"));
					vo.setBoardCategory(rset.getString("BOARD_CATEGORY"));
					vo.setBoardTitle(rset.getString("BOARD_TITLE"));
					vo.setBoardContent(rset.getString("BOARD_CONTENT"));
					vo.setBoardWriteDate(rset.getDate("BOARD_WRITE_DATE"));
					vo.setBoardRewriteDate(rset.getDate("BOARD_REWRITE_DATE"));
					vo.setUserNo(rset.getInt("USER_NO"));
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
	public int getAllBoardTitleCount(Connection conn, String keyword) {
		int result = 0;
		String sql = "select count(*) as total FROM BOARD B JOIN MEMBER M ON B.USER_ID = M.USER_ID where BOARD_TITLE like (?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
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
	
	public ArrayList<AllBoardUser> searchAllBoardTitle(Connection conn, String keyword, int start, int end){
		ArrayList<AllBoardUser> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT B.USER_ID, B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY, B.BOARD_TITLE, B.BOARD_CONTENT, B.BOARD_WRITE_DATE, B.BOARD_REWRITE_DATE, M.USER_NO FROM BOARD B JOIN MEMBER M ON B.USER_ID = M.USER_ID WHERE  BOARD_TITLE like (?) ORDER BY BOARD_REWRITE_DATE DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<AllBoardUser>();
			if (rset.next()) {
				do {
					AllBoardUser vo = new AllBoardUser();
					vo.setBoardNo(rset.getInt("BOARD_NO"));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setBoardType(rset.getString("BOARD_TYPE"));
					vo.setBoardCategory(rset.getString("BOARD_CATEGORY"));
					vo.setBoardTitle(rset.getString("BOARD_TITLE"));
					vo.setBoardContent(rset.getString("BOARD_CONTENT"));
					vo.setBoardWriteDate(rset.getDate("BOARD_WRITE_DATE"));
					vo.setBoardRewriteDate(rset.getDate("BOARD_REWRITE_DATE"));
					vo.setUserNo(rset.getInt("USER_NO"));
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
	public int updateAllBoard(Connection conn, int boardNo, String boardCategory, String boardType){
		int result = 0;
		String sql = "UPDATE BOARD SET BOARD_CATEGORY = ? , BOARD_TYPE =? WHERE BOARD_NO=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardCategory);
			pstmt.setString(2, boardType);
			pstmt.setInt(3, boardNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteAllBoard(Connection conn, int boardNo){
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM BOARD WHERE BOARD_NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	} 
	
	public int getAllCommentCount(Connection conn) {
		int result = 0;
		String sql = "SELECT count(*) FROM COMT C JOIN BOARD B ON C.BOARD_NO=B.BOARD_NO JOIN MEMBER M ON C.USER_ID = M.USER_ID";
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
	
	public ArrayList<AllCommentUser> selectAllCommentList(Connection conn, int start, int end){
		ArrayList<AllCommentUser> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT C.COMMENT_NO, B.BOARD_TITLE, C.COMMENT_CONTENT, M.USER_ID, M.USER_NO, C.COMMENT_REWRITE_DATE FROM COMT C JOIN BOARD B ON C.BOARD_NO=B.BOARD_NO JOIN MEMBER M ON C.USER_ID = M.USER_ID ORDER BY COMMENT_REWRITE_DATE DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<AllCommentUser>();
			if (rset.next()) {
				do {
					AllCommentUser vo = new AllCommentUser();
					vo.setCommentNo(rset.getInt("COMMENT_NO"));
					vo.setBoardTitle(rset.getString("BOARD_TITLE"));
					vo.setCommentContent(rset.getString("COMMENT_CONTENT"));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setUserNo(rset.getInt("USER_NO"));
					vo.setCommentRewriteDate(rset.getDate("COMMENT_REWRITE_DATE"));
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
	
	public int getAllCommentUserIdCount(Connection conn, String keyword) {
		int result = 0;
		String sql = "select count(*) as total FROM COMT C JOIN BOARD B ON C.BOARD_NO=B.BOARD_NO JOIN MEMBER M ON C.USER_ID = M.USER_ID where M.USER_ID like (?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
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
	
	public ArrayList<AllCommentUser> searchAllCommentUserId(Connection conn, String keyword, int start, int end){
		ArrayList<AllCommentUser> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT C.COMMENT_NO, B.BOARD_TITLE, C.COMMENT_CONTENT, M.USER_ID, M.USER_NO, C.COMMENT_REWRITE_DATE FROM COMT C JOIN BOARD B ON C.BOARD_NO=B.BOARD_NO  JOIN MEMBER M ON C.USER_ID = M.USER_ID WHERE M.USER_ID like (?) ORDER BY COMMENT_REWRITE_DATE DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<AllCommentUser>();
			if (rset.next()) {
				do {
					AllCommentUser vo = new AllCommentUser();
					vo.setCommentNo(rset.getInt("COMMENT_NO"));
					vo.setBoardTitle(rset.getString("BOARD_TITLE"));
					vo.setCommentContent(rset.getString("COMMENT_CONTENT"));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setUserNo(rset.getInt("USER_NO"));
					vo.setCommentRewriteDate(rset.getDate("COMMENT_REWRITE_DATE"));
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
	public int getAllCommentUserNoCount(Connection conn, String keyword) {
		int result = 0;
		String sql = "select count(*) as total FROM COMT C JOIN BOARD B ON C.BOARD_NO=B.BOARD_NO JOIN MEMBER M ON C.USER_ID = M.USER_ID where USER_NO like (?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
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
	
	public ArrayList<AllCommentUser> searchAllCommentUserNo(Connection conn, String keyword, int start, int end){
		ArrayList<AllCommentUser> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT C.COMMENT_NO, B.BOARD_TITLE, C.COMMENT_CONTENT, M.USER_ID, M.USER_NO, C.COMMENT_REWRITE_DATE FROM COMT C JOIN BOARD B ON C.BOARD_NO=B.BOARD_NO  JOIN MEMBER M ON C.USER_ID = M.USER_ID WHERE USER_NO like (?) ORDER BY COMMENT_REWRITE_DATE DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<AllCommentUser>();
			if (rset.next()) {
				do {
					AllCommentUser vo = new AllCommentUser();
					vo.setCommentNo(rset.getInt("COMMENT_NO"));
					vo.setBoardTitle(rset.getString("BOARD_TITLE"));
					vo.setCommentContent(rset.getString("COMMENT_CONTENT"));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setUserNo(rset.getInt("USER_NO"));
					vo.setCommentRewriteDate(rset.getDate("COMMENT_REWRITE_DATE"));
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
	public int getAllCommentTitleCount(Connection conn, String keyword) {
		int result = 0;
		String sql = "select count(*) as total FROM COMT C JOIN BOARD B ON C.BOARD_NO=B.BOARD_NO JOIN MEMBER M ON C.USER_ID = M.USER_ID where BOARD_TITLE like (?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
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
	
	public ArrayList<AllCommentUser> searchAllCommentTitle(Connection conn, String keyword, int start, int end){
		ArrayList<AllCommentUser> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT C.COMMENT_NO, B.BOARD_TITLE, C.COMMENT_CONTENT, M.USER_ID, M.USER_NO, C.COMMENT_REWRITE_DATE FROM COMT C JOIN BOARD B ON C.BOARD_NO=B.BOARD_NO  JOIN MEMBER M ON C.USER_ID = M.USER_ID WHERE BOARD_TITLE like (?) ORDER BY COMMENT_REWRITE_DATE DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<AllCommentUser>();
			if (rset.next()) {
				do {
					AllCommentUser vo = new AllCommentUser();
					vo.setCommentNo(rset.getInt("COMMENT_NO"));
					vo.setBoardTitle(rset.getString("BOARD_TITLE"));
					vo.setCommentContent(rset.getString("COMMENT_CONTENT"));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setUserNo(rset.getInt("USER_NO"));
					vo.setCommentRewriteDate(rset.getDate("COMMENT_REWRITE_DATE"));
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
	
	public int deleteAllComment(Connection conn, int commentNo){
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM COMT WHERE COMMENT_NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	} 
	
	public AllCommentUser getAllCommentDetail(Connection conn, String commentNo) {
		AllCommentUser vo = null;
		String sql = "SELECT COMMENT_CONTENT FROM COMT WHERE COMMENT_NO=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  commentNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				vo = new AllCommentUser();
				vo.setCommentContent(rset.getString("COMMENT_CONTENT"));

			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			} 
		return vo;
	}

	public int getAdminUserCount(Connection conn) {
		int result = 0;
		String sql = "SELECT count(*) FROM(\r\n" + 
				"SELECT * \r\n" + 
				"FROM (\r\n" + 
				"SELECT  M.USER_ID, M.USER_NO,\r\n" + 
				"(SELECT COUNT(*) FROM BOARD WHERE USER_ID = M.USER_ID) AS BOARDCOUNT,\r\n" + 
				"(SELECT COUNT(*) FROM COMT WHERE USER_ID = M.USER_ID) AS COMTCOUNT,\r\n" + 
				"(SELECT COUNT(*) FROM REVIEW WHERE USER_ID = M.USER_ID) AS REVIEWCOUNT,\r\n" + 
				"(SELECT COUNT(*) FROM USED WHERE USER_ID = M.USER_ID) AS USEDCOUNT,\r\n" + 
				"M.USER_HISTORY\r\n" + 
				"FROM MEMBER M))";
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
	
	public ArrayList<AdminUser> selectAdminUserList(Connection conn, int start, int end){
		ArrayList<AdminUser> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT * \r\n" + 
				"FROM (\r\n" + 
				"SELECT  M.USER_ID, M.USER_NO,\r\n" + 
				"(SELECT COUNT(*) FROM BOARD WHERE USER_ID = M.USER_ID) AS BOARDCOUNT,\r\n" + 
				"(SELECT COUNT(*) FROM COMT WHERE USER_ID = M.USER_ID) AS COMTCOUNT,\r\n" + 
				"(SELECT COUNT(*) FROM REVIEW WHERE USER_ID = M.USER_ID) AS REVIEWCOUNT,\r\n" + 
				"(SELECT COUNT(*) FROM USED WHERE USER_ID = M.USER_ID) AS USEDCOUNT,\r\n" + 
				"M.USER_HISTORY\r\n" + 
				"FROM MEMBER M)) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<AdminUser>();
			if (rset.next()) {
				do {
					AdminUser vo = new AdminUser();
					vo.setUserId(rset.getString(2));
					vo.setUserNo(rset.getInt(3));
					vo.setBoardCount(rset.getInt(4));
					vo.setComtCount(rset.getInt(5));
					vo.setReviewCount(rset.getInt(6));
					vo.setUsedCount(rset.getInt(7));
					vo.setUserHistory(rset.getInt(8));
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
	
	public int getAdminUserUserIdCount(Connection conn, String keyword) {
		int result = 0;
		String sql = "SELECT count(*) FROM(\r\n" + 
				"SELECT * \r\n" + 
				"FROM (\r\n" + 
				"SELECT  M.USER_ID, M.USER_NO,\r\n" + 
				"(SELECT COUNT(*) FROM BOARD WHERE USER_ID = M.USER_ID) AS BOARDCOUNT,\r\n" + 
				"(SELECT COUNT(*) FROM COMT WHERE USER_ID = M.USER_ID) AS COMTCOUNT,\r\n" + 
				"(SELECT COUNT(*) FROM REVIEW WHERE USER_ID = M.USER_ID) AS REVIEWCOUNT,\r\n" + 
				"(SELECT COUNT(*) FROM USED WHERE USER_ID = M.USER_ID) AS USEDCOUNT,\r\n" + 
				"M.USER_HISTORY\r\n" + 
				"FROM MEMBER M)\r\n" + 
				"WHERE USER_ID like(?))";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
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
	
	public ArrayList<AdminUser> searchAdminUserUserId(Connection conn, String keyword, int start, int end){
		ArrayList<AdminUser> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT * \r\n" + 
				"FROM (\r\n" + 
				"SELECT  M.USER_ID, M.USER_NO,\r\n" + 
				"(SELECT COUNT(*) FROM BOARD WHERE USER_ID = M.USER_ID) AS BOARDCOUNT,\r\n" + 
				"(SELECT COUNT(*) FROM COMT WHERE USER_ID = M.USER_ID) AS COMTCOUNT,\r\n" + 
				"(SELECT COUNT(*) FROM REVIEW WHERE USER_ID = M.USER_ID) AS REVIEWCOUNT,\r\n" + 
				"(SELECT COUNT(*) FROM USED WHERE USER_ID = M.USER_ID) AS USEDCOUNT,\r\n" + 
				"M.USER_HISTORY\r\n" + 
				"FROM MEMBER M)\r\n" + 
				"WHERE USER_ID like(?)) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<AdminUser>();
			if (rset.next()) {
				do {
					AdminUser vo = new AdminUser();
					vo.setUserId(rset.getString(2));
					vo.setUserNo(rset.getInt(3));
					vo.setBoardCount(rset.getInt(4));
					vo.setComtCount(rset.getInt(5));
					vo.setReviewCount(rset.getInt(6));
					vo.setUsedCount(rset.getInt(7));
					vo.setUserHistory(rset.getInt(8));
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
	public int getAdminUserUserNoCount(Connection conn, String keyword) {
		int result = 0;
		String sql = "SELECT count(*) FROM(\r\n" + 
				"SELECT * \r\n" + 
				"FROM (\r\n" + 
				"SELECT  M.USER_ID, M.USER_NO,\r\n" + 
				"(SELECT COUNT(*) FROM BOARD WHERE USER_ID = M.USER_ID) AS BOARDCOUNT,\r\n" + 
				"(SELECT COUNT(*) FROM COMT WHERE USER_ID = M.USER_ID) AS COMTCOUNT,\r\n" + 
				"(SELECT COUNT(*) FROM REVIEW WHERE USER_ID = M.USER_ID) AS REVIEWCOUNT,\r\n" + 
				"(SELECT COUNT(*) FROM USED WHERE USER_ID = M.USER_ID) AS USEDCOUNT,\r\n" + 
				"M.USER_HISTORY\r\n" + 
				"FROM MEMBER M)\r\n" + 
				"WHERE USER_NO like(?))";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
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
	
	public ArrayList<AdminUser> searchAdminUserUserNo(Connection conn, String keyword, int start, int end){
		ArrayList<AdminUser> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT * \r\n" + 
				"FROM (\r\n" + 
				"SELECT  M.USER_ID, M.USER_NO,\r\n" + 
				"(SELECT COUNT(*) FROM BOARD WHERE USER_ID = M.USER_ID) AS BOARDCOUNT,\r\n" + 
				"(SELECT COUNT(*) FROM COMT WHERE USER_ID = M.USER_ID) AS COMTCOUNT,\r\n" + 
				"(SELECT COUNT(*) FROM REVIEW WHERE USER_ID = M.USER_ID) AS REVIEWCOUNT,\r\n" + 
				"(SELECT COUNT(*) FROM USED WHERE USER_ID = M.USER_ID) AS USEDCOUNT,\r\n" + 
				"M.USER_HISTORY\r\n" + 
				"FROM MEMBER M)\r\n" + 
				"WHERE USER_NO like(?)) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<AdminUser>();
			if (rset.next()) {
				do {
					AdminUser vo = new AdminUser();
					vo.setUserId(rset.getString(2));
					vo.setUserNo(rset.getInt(3));
					vo.setBoardCount(rset.getInt(4));
					vo.setComtCount(rset.getInt(5));
					vo.setReviewCount(rset.getInt(6));
					vo.setUsedCount(rset.getInt(7));
					vo.setUserHistory(rset.getInt(8));
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
	
	public int deleteUserByForce(Connection conn, String userId){
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MEMBER WHERE USER_ID = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	public int getReportBoardCount(Connection conn) {
		int result = 0;
		String sql = "SELECT count(*) \r\n" + 
				"FROM(SELECT  count(*)\r\n" + 
				"FROM BOARD_REPORT R JOIN BOARD B\r\n" + 
				"ON R.BOARD_NO = B.BOARD_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON B.USER_ID = M.USER_ID\r\n" + 
				"GROUP BY B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY, B.BOARD_TITLE, B.USER_ID, M.USER_NO, B.BOARD_WRITE_DATE, B. BOARD_REWRITE_DATE\r\n" + 
				")";
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
	
	public ArrayList<ReportBoard> selectReportBoardList(Connection conn, int start, int end){
		ArrayList<ReportBoard> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT  count(*) 신고횟수,  B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY, B.BOARD_TITLE, B.USER_ID ,M.USER_NO, B.BOARD_WRITE_DATE, B. BOARD_REWRITE_DATE \r\n" + 
				"FROM BOARD_REPORT R JOIN BOARD B\r\n" + 
				"ON R.BOARD_NO = B.BOARD_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON B.USER_ID = M.USER_ID\r\n" + 
				"GROUP BY B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY, B.BOARD_TITLE, B.USER_ID, M.USER_NO, B.BOARD_WRITE_DATE, B. BOARD_REWRITE_DATE\r\n" + 
				"ORDER BY 신고횟수 DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<ReportBoard>();
			if (rset.next()) {
				do {
					ReportBoard vo = new ReportBoard();
					vo.setReportCount(rset.getInt(2));
					vo.setBoardNo(rset.getInt("BOARD_NO"));
					vo.setBoardType(rset.getString("BOARD_TYPE"));
					vo.setBoardCategory(rset.getString("BOARD_CATEGORY"));
					vo.setBoardTitle(rset.getString("BOARD_TITLE"));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setUserNo(rset.getInt("USER_NO"));
					vo.setBoardWriteDate(rset.getDate("BOARD_WRITE_DATE"));
					vo.setBoardRewriteDate(rset.getDate("BOARD_REWRITE_DATE"));
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
	
	public ArrayList<ReportBoard> selectReportBoardAscList(Connection conn, int start, int end){
		ArrayList<ReportBoard> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT  count(*) 신고횟수,  B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY, B.BOARD_TITLE, B.USER_ID ,M.USER_NO, B.BOARD_WRITE_DATE, B. BOARD_REWRITE_DATE \r\n" + 
				"FROM BOARD_REPORT R JOIN BOARD B\r\n" + 
				"ON R.BOARD_NO = B.BOARD_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON B.USER_ID = M.USER_ID\r\n" + 
				"GROUP BY B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY, B.BOARD_TITLE, B.USER_ID, M.USER_NO, B.BOARD_WRITE_DATE, B.BOARD_REWRITE_DATE\r\n" + 
				"ORDER BY 신고횟수) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<ReportBoard>();
			if (rset.next()) {
				do {
					ReportBoard vo = new ReportBoard();
					vo.setReportCount(rset.getInt(2));
					vo.setBoardNo(rset.getInt("BOARD_NO"));
					vo.setBoardType(rset.getString("BOARD_TYPE"));
					vo.setBoardCategory(rset.getString("BOARD_CATEGORY"));
					vo.setBoardTitle(rset.getString("BOARD_TITLE"));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setUserNo(rset.getInt("USER_NO"));
					vo.setBoardWriteDate(rset.getDate("BOARD_WRITE_DATE"));
					vo.setBoardRewriteDate(rset.getDate("BOARD_REWRITE_DATE"));
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
	
	public int getReportBoardUserIdCount(Connection conn, String keyword) {
		int result = 0;
		String sql = "SELECT count(*) \r\n" + 
				"FROM(\r\n" + 
				"select count(*) as total \r\n" + 
				"FROM  BOARD_REPORT R JOIN BOARD B\r\n" + 
				"ON R.BOARD_NO = B.BOARD_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON B.USER_ID = M.USER_ID\r\n" + 
				"where B.USER_ID like (?)\r\n" + 
				"GROUP BY B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY, B.BOARD_TITLE, B.USER_ID, M.USER_NO, B.BOARD_WRITE_DATE, B.BOARD_REWRITE_DATE)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
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
	
	public ArrayList<ReportBoard> searchReportBoardUserId(Connection conn, String keyword, int start, int end){
		ArrayList<ReportBoard> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT  count(*) 신고횟수,  B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY, B.BOARD_TITLE, B.USER_ID ,M.USER_NO, B.BOARD_WRITE_DATE, B.BOARD_REWRITE_DATE \r\n" + 
				"FROM BOARD_REPORT R JOIN BOARD B\r\n" + 
				"ON R.BOARD_NO = B.BOARD_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON B.USER_ID = M.USER_ID\r\n" + 
				"WHERE B.USER_ID like(?)\r\n" + 
				"GROUP BY B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY, B.BOARD_TITLE, B.USER_ID, M.USER_NO, B.BOARD_WRITE_DATE, B. BOARD_REWRITE_DATE\r\n" + 
				"ORDER BY 신고횟수 DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<ReportBoard>();
			if (rset.next()) {
				do {
					ReportBoard vo = new ReportBoard();
					vo.setReportCount(rset.getInt(2));
					vo.setBoardNo(rset.getInt("BOARD_NO"));
					vo.setBoardType(rset.getString("BOARD_TYPE"));
					vo.setBoardCategory(rset.getString("BOARD_CATEGORY"));
					vo.setBoardTitle(rset.getString("BOARD_TITLE"));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setUserNo(rset.getInt("USER_NO"));
					vo.setBoardWriteDate(rset.getDate("BOARD_WRITE_DATE"));
					vo.setBoardRewriteDate(rset.getDate("BOARD_REWRITE_DATE"));
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
	public int getReportBoardUserNoCount(Connection conn, String keyword) {
		int result = 0;
		String sql = "SELECT count(*) \r\n" + 
				"FROM(\r\n" + 
				"select count(*) as total \r\n" + 
				"FROM  BOARD_REPORT R JOIN BOARD B\r\n" + 
				"ON R.BOARD_NO = B.BOARD_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON B.USER_ID = M.USER_ID\r\n" + 
				"where M.USER_NO like (?)\r\n" + 
				"GROUP BY B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY, B.BOARD_TITLE, B.USER_ID, M.USER_NO, B.BOARD_WRITE_DATE, B.BOARD_REWRITE_DATE)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
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
	
	public ArrayList<ReportBoard> searchReportBoardUserNo(Connection conn, String keyword, int start, int end){
		ArrayList<ReportBoard> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT  count(*) 신고횟수,  B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY, B.BOARD_TITLE, B.USER_ID ,M.USER_NO, B.BOARD_WRITE_DATE, B. BOARD_REWRITE_DATE \r\n" + 
				"FROM BOARD_REPORT R JOIN BOARD B\r\n" + 
				"ON R.BOARD_NO = B.BOARD_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON B.USER_ID = M.USER_ID\r\n" + 
				"WHERE M.USER_NO like(?)\r\n" + 
				"GROUP BY B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY, B.BOARD_TITLE, B.USER_ID, M.USER_NO, B.BOARD_WRITE_DATE, B.BOARD_REWRITE_DATE\r\n" + 
				"ORDER BY 신고횟수 DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<ReportBoard>();
			if (rset.next()) {
				do {
					ReportBoard vo = new ReportBoard();
					vo.setReportCount(rset.getInt(2));
					vo.setBoardNo(rset.getInt("BOARD_NO"));
					vo.setBoardType(rset.getString("BOARD_TYPE"));
					vo.setBoardCategory(rset.getString("BOARD_CATEGORY"));
					vo.setBoardTitle(rset.getString("BOARD_TITLE"));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setUserNo(rset.getInt("USER_NO"));
					vo.setBoardWriteDate(rset.getDate("BOARD_WRITE_DATE"));
					vo.setBoardRewriteDate(rset.getDate("BOARD_REWRITE_DATE"));
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
	

	public int getReportCommentCount(Connection conn) {
		int result = 0;
		String sql = "SELECT count(*) \r\n" + 
				"FROM(SELECT  count(*)\r\n" + 
				"FROM COMMENT_REPORT R JOIN COMT C\r\n" + 
				"ON R.COMMENT_NO = C.COMMENT_NO\r\n" + 
				"JOIN BOARD B\r\n" + 
				"ON C.BOARD_NO = B.BOARD_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON C.USER_ID = M.USER_ID\r\n" + 
				"GROUP BY C.COMMENT_NO, B.BOARD_TITLE, C.COMMENT_CONTENT, C.USER_ID, M.USER_NO, C.COMMENT_WRITE_DATE, C.COMMENT_REWRITE_DATE\r\n" + 
				")";
		
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
	
	public ArrayList<ReportComment> selectReportCommentList(Connection conn, int start, int end){
		ArrayList<ReportComment> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT  count(*) 신고횟수, C.COMMENT_NO, B.BOARD_TITLE, C.COMMENT_CONTENT, C.USER_ID, M.USER_NO, C.COMMENT_WRITE_DATE, C.COMMENT_REWRITE_DATE\r\n" + 
				"FROM COMMENT_REPORT R JOIN COMT C\r\n" + 
				"ON R.COMMENT_NO = C.COMMENT_NO\r\n" + 
				"JOIN BOARD B\r\n" + 
				"ON C.BOARD_NO = B.BOARD_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON C.USER_ID = M.USER_ID\r\n" + 
				"GROUP BY C.COMMENT_NO, B.BOARD_TITLE, C.COMMENT_CONTENT, C.USER_ID, M.USER_NO, C.COMMENT_WRITE_DATE, C.COMMENT_REWRITE_DATE\r\n" + 
				"ORDER BY 신고횟수 DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<ReportComment>();
			if (rset.next()) {
				do {
					ReportComment vo = new ReportComment();
					vo.setReportCount(rset.getInt(2));
					vo.setCommentNo(rset.getInt(3));
					vo.setBoardTitle(rset.getString(4));
					vo.setCommentContent(rset.getString(5));
					vo.setUserId(rset.getString(6));
					vo.setUserNo(rset.getInt(7));
					vo.setCommentWriteDate(rset.getDate(8));
					vo.setCommentRewriteDate(rset.getDate(9));
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
	
	public ArrayList<ReportComment> selectReportCommentAscList(Connection conn, int start, int end){
		ArrayList<ReportComment> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT  count(*) 신고횟수, C.COMMENT_NO, B.BOARD_TITLE, C.COMMENT_CONTENT, C.USER_ID, M.USER_NO, C.COMMENT_WRITE_DATE, C.COMMENT_REWRITE_DATE\r\n" + 
				"FROM COMMENT_REPORT R JOIN COMT C\r\n" + 
				"ON R.COMMENT_NO = C.COMMENT_NO\r\n" + 
				"JOIN BOARD B\r\n" + 
				"ON C.BOARD_NO = B.BOARD_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON C.USER_ID = M.USER_ID\r\n" + 
				"GROUP BY C.COMMENT_NO, B.BOARD_TITLE, C.COMMENT_CONTENT, C.USER_ID, M.USER_NO, C.COMMENT_WRITE_DATE, C.COMMENT_REWRITE_DATE\r\n" + 
				"ORDER BY 신고횟수) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<ReportComment>();
			if (rset.next()) {
				do {
					ReportComment vo = new ReportComment();
					vo.setReportCount(rset.getInt(2));
					vo.setCommentNo(rset.getInt(3));
					vo.setBoardTitle(rset.getString(4));
					vo.setCommentContent(rset.getString(5));
					vo.setUserId(rset.getString(6));
					vo.setUserNo(rset.getInt(7));
					vo.setCommentWriteDate(rset.getDate(8));
					vo.setCommentRewriteDate(rset.getDate(9));
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
	
	public int getReportCommentUserIdCount(Connection conn, String keyword) {
		int result = 0;
		String sql = "SELECT count(*) \r\n" + 
				"FROM(\r\n" + 
				"select count(*) as total \r\n" + 
				"FROM COMMENT_REPORT R JOIN COMT C\r\n" + 
				"ON R.COMMENT_NO = C.COMMENT_NO\r\n" + 
				"JOIN BOARD B\r\n" + 
				"ON C.BOARD_NO = B.BOARD_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON C.USER_ID = M.USER_ID\r\n" + 
				"where C.USER_ID like (?)\r\n" + 
				"GROUP BY C.COMMENT_NO, B.BOARD_TITLE, C.COMMENT_CONTENT, C.USER_ID, M.USER_NO, C.COMMENT_WRITE_DATE, C.COMMENT_REWRITE_DATE)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
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
	
	public ArrayList<ReportComment> searchReportCommentUserId(Connection conn, String keyword, int start, int end){
		ArrayList<ReportComment> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT  count(*) 신고횟수, C.COMMENT_NO, B.BOARD_TITLE, C.COMMENT_CONTENT, C.USER_ID, M.USER_NO, C.COMMENT_WRITE_DATE, C.COMMENT_REWRITE_DATE\r\n" + 
				"FROM COMMENT_REPORT R JOIN COMT C\r\n" + 
				"ON R.COMMENT_NO = C.COMMENT_NO\r\n" + 
				"JOIN BOARD B\r\n" + 
				"ON C.BOARD_NO = B.BOARD_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON C.USER_ID = M.USER_ID\r\n" + 
				"WHERE C.USER_ID like (?)\r\n" + 
				"GROUP BY C.COMMENT_NO, B.BOARD_TITLE, C.COMMENT_CONTENT, C.USER_ID, M.USER_NO, C.COMMENT_WRITE_DATE, C.COMMENT_REWRITE_DATE\r\n" + 
				"ORDER BY 신고횟수 DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<ReportComment>();
			if (rset.next()) {
				do {
					ReportComment vo = new ReportComment();
					vo.setReportCount(rset.getInt(2));
					vo.setCommentNo(rset.getInt(3));
					vo.setBoardTitle(rset.getString(4));
					vo.setCommentContent(rset.getString(5));
					vo.setUserId(rset.getString(6));
					vo.setUserNo(rset.getInt(7));
					vo.setCommentWriteDate(rset.getDate(8));
					vo.setCommentRewriteDate(rset.getDate(9));
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
	public int getReportCommentUserNoCount(Connection conn, String keyword) {
		int result = 0;
		String sql = "SELECT count(*) \r\n" + 
				"FROM(\r\n" + 
				"select count(*) as total \r\n" + 
				"FROM COMMENT_REPORT R JOIN COMT C\r\n" + 
				"ON R.COMMENT_NO = C.COMMENT_NO\r\n" + 
				"JOIN BOARD B\r\n" + 
				"ON C.BOARD_NO = B.BOARD_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON C.USER_ID = M.USER_ID\r\n" + 
				"where M.USER_NO like (?)\r\n" + 
				"GROUP BY C.COMMENT_NO, B.BOARD_TITLE, C.COMMENT_CONTENT, C.USER_ID, M.USER_NO, C.COMMENT_WRITE_DATE, C.COMMENT_REWRITE_DATE)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
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
	
	public ArrayList<ReportComment> searchReportCommentUserNo(Connection conn, String keyword, int start, int end){
		ArrayList<ReportComment> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT  count(*) 신고횟수, C.COMMENT_NO, B.BOARD_TITLE, C.COMMENT_CONTENT, C.USER_ID, M.USER_NO, C.COMMENT_WRITE_DATE, C.COMMENT_REWRITE_DATE \r\n" + 
				"FROM COMMENT_REPORT R JOIN COMT C\r\n" + 
				"ON R.COMMENT_NO = C.COMMENT_NO\r\n" + 
				"JOIN BOARD B\r\n" + 
				"ON C.BOARD_NO = B.BOARD_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON C.USER_ID = M.USER_ID\r\n" + 
				"WHERE M.USER_NO like (?)\r\n" + 
				"GROUP BY C.COMMENT_NO, B.BOARD_TITLE, C.COMMENT_CONTENT, C.USER_ID, M.USER_NO, C.COMMENT_WRITE_DATE, C.COMMENT_REWRITE_DATE\r\n" + 
				"ORDER BY 신고횟수 DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<ReportComment>();
			if (rset.next()) {
				do {
					ReportComment vo = new ReportComment();
					vo.setReportCount(rset.getInt(2));
					vo.setCommentNo(rset.getInt(3));
					vo.setBoardTitle(rset.getString(4));
					vo.setCommentContent(rset.getString(5));
					vo.setUserId(rset.getString(6));
					vo.setUserNo(rset.getInt(7));
					vo.setCommentWriteDate(rset.getDate(8));
					vo.setCommentRewriteDate(rset.getDate(9));
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
	
	public int getReportReviewCount(Connection conn) {
		int result = 0;
		String sql = "SELECT count(*) \r\n" + 
				"FROM(SELECT  count(*)\r\n" + 
				"FROM REVIEW_REPORT R JOIN REVIEW V\r\n" + 
				"ON R.REVIEW_NO = V.REVIEW_NO\r\n" + 
				"JOIN BOARDGAME B\r\n" + 
				"ON B.GAME_NO = V.GAME_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON V.USER_ID = M.USER_ID\r\n" + 
				"GROUP BY V.REVIEW_NO, B.GAME_KONAME, V.REVIEW_CONTENT, V.USER_ID, M.USER_NO, V.REVIEW_DATE\r\n" + 
				")";
		
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
	
	public ArrayList<ReportReview> selectReportReviewList(Connection conn, int start, int end){
		ArrayList<ReportReview> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT  count(*) 신고횟수, V.REVIEW_NO, B.GAME_KONAME, V.REVIEW_CONTENT, V.USER_ID, M.USER_NO, V.REVIEW_DATE\r\n" + 
				"FROM REVIEW_REPORT R JOIN REVIEW V\r\n" + 
				"ON R.REVIEW_NO = V.REVIEW_NO\r\n" + 
				"JOIN BOARDGAME B\r\n" + 
				"ON B.GAME_NO = V.GAME_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON V.USER_ID = M.USER_ID\r\n" + 
				"GROUP BY V.REVIEW_NO, B.GAME_KONAME, V.REVIEW_CONTENT, V.USER_ID, M.USER_NO, V.REVIEW_DATE\r\n" + 
				"ORDER BY 신고횟수 DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<ReportReview>();
			if (rset.next()) {
				do {
					ReportReview vo = new ReportReview();
					vo.setReportCount(rset.getInt(2));
					vo.setReviewNo(rset.getInt(3));
					vo.setGameKoName(rset.getString(4));
					vo.setReviewContent(rset.getString(5));
					vo.setUserId(rset.getString(6));
					vo.setUserNo(rset.getInt(7));
					vo.setReviewDate(rset.getDate(8));
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
	
	public ArrayList<ReportReview> selectReportReviewAscList(Connection conn, int start, int end){
		ArrayList<ReportReview> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT  count(*) 신고횟수, V.REVIEW_NO, B.GAME_KONAME, V.REVIEW_CONTENT, V.USER_ID, M.USER_NO, V.REVIEW_DATE\r\n" + 
				"FROM REVIEW_REPORT R JOIN REVIEW V\r\n" + 
				"ON R.REVIEW_NO = V.REVIEW_NO\r\n" + 
				"JOIN BOARDGAME B\r\n" + 
				"ON B.GAME_NO = V.GAME_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON V.USER_ID = M.USER_ID\r\n" + 
				"GROUP BY V.REVIEW_NO, B.GAME_KONAME, V.REVIEW_CONTENT, V.USER_ID, M.USER_NO, V.REVIEW_DATE\r\n" + 
				"ORDER BY 신고횟수) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<ReportReview>();
			if (rset.next()) {
				do {
					ReportReview vo = new ReportReview();
					vo.setReportCount(rset.getInt(2));
					vo.setReviewNo(rset.getInt(3));
					vo.setGameKoName(rset.getString(4));
					vo.setReviewContent(rset.getString(5));
					vo.setUserId(rset.getString(6));
					vo.setUserNo(rset.getInt(7));
					vo.setReviewDate(rset.getDate(8));
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
	
	public int getReportReviewUserIdCount(Connection conn, String keyword) {
		int result = 0;
		String sql = "SELECT count(*) \r\n" + 
				"FROM(\r\n" + 
				"select count(*) as total \r\n" + 
				"FROM REVIEW_REPORT R JOIN REVIEW V\r\n" + 
				"ON R.REVIEW_NO = V.REVIEW_NO\r\n" + 
				"JOIN BOARDGAME B\r\n" + 
				"ON B.GAME_NO = V.GAME_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON V.USER_ID = M.USER_ID\r\n" + 
				"where V.USER_ID like (?)\r\n" + 
				"GROUP BY V.REVIEW_NO, B.GAME_KONAME, V.REVIEW_CONTENT, V.USER_ID, M.USER_NO, V.REVIEW_DATE)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
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
	
	public ArrayList<ReportReview> searchReportReviewUserId(Connection conn, String keyword, int start, int end){
		ArrayList<ReportReview> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT  count(*) 신고횟수, V.REVIEW_NO, B.GAME_KONAME, V.REVIEW_CONTENT, V.USER_ID, M.USER_NO, V.REVIEW_DATE\r\n" + 
				"FROM REVIEW_REPORT R JOIN REVIEW V\r\n" + 
				"ON R.REVIEW_NO = V.REVIEW_NO\r\n" + 
				"JOIN BOARDGAME B\r\n" + 
				"ON B.GAME_NO = V.GAME_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON V.USER_ID = M.USER_ID\r\n" + 
				"where V.USER_ID like (?)\r\n" + 
				"GROUP BY V.REVIEW_NO, B.GAME_KONAME, V.REVIEW_CONTENT, V.USER_ID, M.USER_NO, V.REVIEW_DATE\r\n" + 
				"ORDER BY 신고횟수 DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<ReportReview>();
			if (rset.next()) {
				do {
					ReportReview vo = new ReportReview();
					vo.setReportCount(rset.getInt(2));
					vo.setReviewNo(rset.getInt(3));
					vo.setGameKoName(rset.getString(4));
					vo.setReviewContent(rset.getString(5));
					vo.setUserId(rset.getString(6));
					vo.setUserNo(rset.getInt(7));
					vo.setReviewDate(rset.getDate(8));
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
	public int getReportReviewUserNoCount(Connection conn, String keyword) {
		int result = 0;
		String sql = "SELECT count(*) \r\n" + 
				"FROM(\r\n" + 
				"select count(*) as total \r\n" + 
				"FROM REVIEW_REPORT R JOIN REVIEW V\r\n" + 
				"ON R.REVIEW_NO = V.REVIEW_NO\r\n" + 
				"JOIN BOARDGAME B\r\n" + 
				"ON B.GAME_NO = V.GAME_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON V.USER_ID = M.USER_ID\r\n" + 
				"where M.USER_NO like (?)\r\n" + 
				"GROUP BY V.REVIEW_NO, B.GAME_KONAME, V.REVIEW_CONTENT, V.USER_ID, M.USER_NO, V.REVIEW_DATE)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
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
	
	public ArrayList<ReportReview> searchReportReviewUserNo(Connection conn, String keyword, int start, int end){
		ArrayList<ReportReview> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT  count(*) 신고횟수, V.REVIEW_NO, B.GAME_KONAME, V.REVIEW_CONTENT, V.USER_ID, M.USER_NO, V.REVIEW_DATE\r\n" + 
				"FROM REVIEW_REPORT R JOIN REVIEW V\r\n" + 
				"ON R.REVIEW_NO = V.REVIEW_NO\r\n" + 
				"JOIN BOARDGAME B\r\n" + 
				"ON B.GAME_NO = V.GAME_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON V.USER_ID = M.USER_ID\r\n" + 
				"where M.USER_NO like (?)\r\n" + 
				"GROUP BY V.REVIEW_NO, B.GAME_KONAME, V.REVIEW_CONTENT, V.USER_ID, M.USER_NO, V.REVIEW_DATE\r\n" + 
				"ORDER BY 신고횟수 DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<ReportReview>();
			if (rset.next()) {
				do {
					ReportReview vo = new ReportReview();
					vo.setReportCount(rset.getInt(2));
					vo.setReviewNo(rset.getInt(3));
					vo.setGameKoName(rset.getString(4));
					vo.setReviewContent(rset.getString(5));
					vo.setUserId(rset.getString(6));
					vo.setUserNo(rset.getInt(7));
					vo.setReviewDate(rset.getDate(8));
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
	
	public int deleteReview(Connection conn, int reviewNo){
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM REVIEW WHERE REVIEW_NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	public ReportReview getReviewDetail(Connection conn, String reviewNo) {
		ReportReview vo = null;
		String sql = "SELECT REVIEW_CONTENT FROM REVIEW WHERE REVIEW_NO=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  reviewNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				vo = new ReportReview();
				vo.setReviewContent(rset.getString("REVIEW_CONTENT"));

			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			} 
		return vo;
	}
	
	public int getReportUsedCount(Connection conn) {
		int result = 0;
		String sql = "SELECT count(*) \r\n" + 
				"FROM(SELECT  count(*)\r\n" + 
				"FROM USED_REPORT R JOIN USED U\r\n" + 
				"ON R.USED_NO = U.USED_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON U.USER_ID = M.USER_ID\r\n" + 
				"GROUP BY U.USED_NO, U.USED_TITLE, U.USER_ID, M.USER_NO, U.USED_DAY\r\n" + 
				")";
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
	
	public ArrayList<ReportUsed> selectReportUsedList(Connection conn, int start, int end){
		ArrayList<ReportUsed> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT  count(*) 신고횟수, U.USED_NO, U.USED_TITLE, U.USER_ID, M.USER_NO, U.USED_DAY\r\n" + 
				"FROM USED_REPORT R JOIN USED U\r\n" + 
				"ON R.USED_NO = U.USED_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON U.USER_ID = M.USER_ID\r\n" + 
				"GROUP BY U.USED_NO, U.USED_TITLE, U.USER_ID, M.USER_NO, U.USED_DAY\r\n" + 
				"ORDER BY 신고횟수 DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<ReportUsed>();
			if (rset.next()) {
				do {
					ReportUsed vo = new ReportUsed();
					vo.setReportCount(rset.getInt(2));
					vo.setUsedNo(rset.getInt(3));
					vo.setUsedTitle(rset.getString(4));
					vo.setUserId(rset.getString(5));
					vo.setUserNo(rset.getInt(6));
					vo.setUsedDate(rset.getDate(7));
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
	
	public ArrayList<ReportUsed> selectReportUsedAscList(Connection conn, int start, int end){
		ArrayList<ReportUsed> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT  count(*) 신고횟수, U.USED_NO, U.USED_TITLE, U.USER_ID, M.USER_NO, U.USED_DAY\r\n" + 
				"FROM USED_REPORT R JOIN USED U\r\n" + 
				"ON R.USED_NO = U.USED_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON U.USER_ID = M.USER_ID\r\n" + 
				"GROUP BY U.USED_NO, U.USED_TITLE, U.USER_ID, M.USER_NO, U.USED_DAY\r\n" + 
				"ORDER BY 신고횟수 ) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<ReportUsed>();
			if (rset.next()) {
				do {
					ReportUsed vo = new ReportUsed();
					vo.setReportCount(rset.getInt(2));
					vo.setUsedNo(rset.getInt(3));
					vo.setUsedTitle(rset.getString(4));
					vo.setUserId(rset.getString(5));
					vo.setUserNo(rset.getInt(6));
					vo.setUsedDate(rset.getDate(7));
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
	
	public int getReportUsedUserIdCount(Connection conn, String keyword) {
		int result = 0;
		String sql = "SELECT count(*) \r\n" + 
				"FROM(\r\n" + 
				"select count(*) as total \r\n" + 
				"FROM USED_REPORT R JOIN USED U\r\n" + 
				"ON R.USED_NO = U.USED_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON U.USER_ID = M.USER_ID\r\n" + 
				"where U.USER_ID like (?)\r\n" + 
				"GROUP BY U.USED_NO, U.USED_TITLE, U.USER_ID, M.USER_NO, U.USED_DAY)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
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
	
	public ArrayList<ReportUsed> searchReportUsedUserId(Connection conn, String keyword, int start, int end){
		ArrayList<ReportUsed> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT  count(*) 신고횟수, U.USED_NO, U.USED_TITLE, U.USER_ID, M.USER_NO, U.USED_DAY\r\n" + 
				"FROM USED_REPORT R JOIN USED U\r\n" + 
				"ON R.USED_NO = U.USED_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON U.USER_ID = M.USER_ID\r\n" + 
				"where U.USER_ID like (?)\r\n" + 
				"GROUP BY U.USED_NO, U.USED_TITLE, U.USER_ID, M.USER_NO, U.USED_DAY\r\n" + 
				"ORDER BY 신고횟수 DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<ReportUsed>();
			if (rset.next()) {
				do {
					ReportUsed vo = new ReportUsed();
					vo.setReportCount(rset.getInt(2));
					vo.setUsedNo(rset.getInt(3));
					vo.setUsedTitle(rset.getString(4));
					vo.setUserId(rset.getString(5));
					vo.setUserNo(rset.getInt(6));
					vo.setUsedDate(rset.getDate(7));
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
	public int getReportUsedUserNoCount(Connection conn, String keyword) {
		int result = 0;
		String sql = "SELECT count(*) \r\n" + 
				"FROM(\r\n" + 
				"select count(*) as total \r\n" + 
				"FROM USED_REPORT R JOIN USED U\r\n" + 
				"ON R.USED_NO = U.USED_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON U.USER_ID = M.USER_ID\r\n" + 
				"where M.USER_NO like (?)\r\n" + 
				"GROUP BY U.USED_NO, U.USED_TITLE, U.USER_ID, M.USER_NO, U.USED_DAY)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
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
	
	public ArrayList<ReportUsed> searchReportUsedUserNo(Connection conn, String keyword, int start, int end){
		ArrayList<ReportUsed> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (SELECT  count(*) 신고횟수, U.USED_NO, U.USED_TITLE, U.USER_ID, M.USER_NO, U.USED_DAY\r\n" + 
				"FROM USED_REPORT R JOIN USED U\r\n" + 
				"ON R.USED_NO = U.USED_NO\r\n" + 
				"JOIN MEMBER M\r\n" + 
				"ON U.USER_ID = M.USER_ID\r\n" + 
				"where M.USER_NO like (?)\r\n" + 
				"GROUP BY U.USED_NO, U.USED_TITLE, U.USER_ID, M.USER_NO, U.USED_DAY\r\n" + 
				"ORDER BY 신고횟수 DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<ReportUsed>();
			if (rset.next()) {
				do {
					ReportUsed vo = new ReportUsed();
					vo.setReportCount(rset.getInt(2));
					vo.setUsedNo(rset.getInt(3));
					vo.setUsedTitle(rset.getString(4));
					vo.setUserId(rset.getString(5));
					vo.setUserNo(rset.getInt(6));
					vo.setUsedDate(rset.getDate(7));
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
	
	public int deleteUsed(Connection conn, int usedNo){
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM USED WHERE USED_NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, usedNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
}
