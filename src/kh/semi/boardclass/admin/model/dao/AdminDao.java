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

import kh.semi.boardclass.admin.model.vo.AllBoardUser;
import kh.semi.boardclass.admin.model.vo.AllCommentUser;
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
	public int insertBoardGame(Connection conn, String kotitle, String entitle, String category, String age, String player, String time, int price, int grade, int level, String designer, String writer, String brand, String releasedate, String language, String image, String ruleimage, String video, String plus){
		int result = 0;
		String sql = "insert into BOARDGAME values(GAME_NUM.nextval,null,?,?,?,0,?,?,?,?,?,SYSDATE,?,?,?,?,?,null,?,null,?,?,?,?)";
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
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateBoardGame(Connection conn, String kotitle, String entitle, String category, String age, String player, String time, int price, int grade, int level, String designer, String writer, String brand, String releasedate, String language, String image, String ruleimage, String video, String plus, int gameNo){
		int result = 0;
		String sql = "UPDATE BOARDGAME SET GAME_KONAME = ?, GAME_ENNAME = ?, GAME_CATEGORY = ?, GAME_AGE = ?, GAME_PLAYER = ?, GAME_TIME = ?, GAME_PRICE = ?, GAME_GRADE = ?, GAME_LEVEL = ?, GAME_DESIGNER = ?, GAME_WRITER = ?, GAME_BRAND = ?, GAME_RELEASEDATE = ?, GAME_LANGUAGE = ?, GAME_IMAGE = ?, GAME_RULE_IMAGE = ?, GAME_VIDEO = ?, GAME_PLUS = ?  WHERE GAME_NO=?";
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
			pstmt.setInt(19, gameNo);
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
