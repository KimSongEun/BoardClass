package kh.semi.boardclass.main.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kh.semi.boardclass.admin.model.vo.Banner;
import kh.semi.boardclass.admin.model.vo.Notice;
import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.community.model.vo.Board;

public class MainDao {

	public MainDao() {
	}
	
	public ArrayList<Banner> getAdList(Connection conn) {
		ArrayList<Banner> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from (\r\n" + 
				"SELECT * \r\n" + 
				"FROM BANNER\r\n" + 
				"WHERE PROMOTION_PLACE = 1\r\n" + 
				"ORDER BY PROMOTION_DATE DESC) t1) t2";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Banner>();
			if (rset.next()) {
				do {
					Banner vo = new Banner();
					vo.setRownum(rset.getInt(1));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setPromotionPlace(rset.getInt("PROMOTION_PLACE"));
					vo.setPromotionTitle(rset.getString("PROMOTION_TITLE"));
					vo.setPromotionContent(rset.getString("PROMOTION_CONTENT"));
					vo.setPromotionDate(rset.getDate("PROMOTION_DATE"));
					vo.setPromotionImg(rset.getString("PROMOTION_IMG"));
					vo.setPromotionNo(rset.getInt("PROMOTION_NO"));
					vo.setPromotionURL(rset.getString("PROMOTION_URL"));
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
	
	public int getAdCount(Connection conn) {
		int result = 0;
		String sql = "SELECT count(*) FROM(\r\n" + 
				"SELECT * \r\n" + 
				"FROM BANNER\r\n" + 
				"WHERE PROMOTION_PLACE = 1\r\n" + 
				"ORDER BY PROMOTION_DATE DESC)";
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
	
	public ArrayList<Notice> getNoticeList(Connection conn){
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
	public ArrayList<Board> getBestBoard (Connection conn) {
		ArrayList<Board> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select *  from (select rownum r, a.* from (select * from board order by board_view_count desc) a) " 
				+ " where r between 1 and 5";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Board>();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					vo.setBoardRank(rset.getInt("r"));
					volist.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}
	public ArrayList<Board> getBestBoardTwo (Connection conn) {
		ArrayList<Board> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select *  from (select rownum r, a.* from (select * from board order by board_view_count desc) a) " 
				+ " where r = 2";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Board>();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					volist.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}
	public ArrayList<Board> getBestBoardThree (Connection conn) {
		ArrayList<Board> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select *  from (select rownum r, a.* from (select * from board order by board_view_count desc) a) " 
				+ " where r = 3";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Board>();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					volist.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}
	public ArrayList<Board> getBestBoardFour (Connection conn) {
		ArrayList<Board> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select *  from (select rownum r, a.* from (select * from board order by board_view_count desc) a) " 
				+ " where r = 4";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Board>();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					volist.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}
	public ArrayList<Board> getBestBoardFive (Connection conn) {
		ArrayList<Board> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select *  from (select rownum r, a.* from (select * from board order by board_view_count desc) a) " 
				+ " where r = 5";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Board>();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					volist.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}
}
