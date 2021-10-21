package kh.semi.boardclass.main.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kh.semi.boardclass.admin.model.vo.Banner;
import kh.semi.boardclass.admin.model.vo.Notice;
import kh.semi.boardclass.common.JDBCTemplate;

public class MainDao {

	public MainDao() {
	}
	
	public ArrayList<Banner> getAdList(Connection conn) {
		ArrayList<Banner> volist = null;
		String sql = "SELECT * \r\n" + 
				"FROM BANNER\r\n" + 
				"WHERE PROMOTION_PLACE = 1\r\n" + 
				"ORDER BY PROMOTION_DATE DESC";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
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

}
